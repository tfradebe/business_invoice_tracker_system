package za.co.tfradebe.api_gateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.util.Date;

//@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    @Value("${jwt.secret}")
    private String secret;

    public JwtAuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                return onError(exchange,"No authorization header",HttpStatus.UNAUTHORIZED);
            }
            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if(authHeader == null || !authHeader.startsWith("Bearer ")){
                return onError(exchange,"Invalid authorization", HttpStatus.UNAUTHORIZED);
            }
            String token = authHeader.substring(7);
            if(!isJwtValid(token)){
                return onError(exchange, "Invalid JWT Token", HttpStatus.UNAUTHORIZED);
            }

            String userId = getUserIdFromToken(token);
            exchange.getRequest().mutate().header("X-User-Id", userId);
            return chain.filter(exchange);
        };
    }

    private boolean isJwtValid(String token){
        try{
            Claims claims = getClaimsFromToken(token);
            return claims.getExpiration() != null && !claims.getExpiration().before(new Date());
        } catch (Exception e){
            return false;
        }
    }

    private String getUserIdFromToken(String token){
        try{
            Claims claims = getClaimsFromToken(token);
            return claims.getSubject();
        }catch (Exception e){
            return null;
        }
    }

    private Claims getClaimsFromToken(String token){
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Mono<Void> onError(ServerWebExchange exchange, String errorMsg, HttpStatus status){
        exchange.getResponse().setStatusCode(status);
        return exchange.getResponse().setComplete();
    }

    public static class Config{}
}
