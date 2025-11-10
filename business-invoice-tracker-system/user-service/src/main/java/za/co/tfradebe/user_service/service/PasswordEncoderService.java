package za.co.tfradebe.user_service.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordEncoderService {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncoderService(){
        this.passwordEncoder = new BCryptPasswordEncoder(9,new SecureRandom());
    }

    public String encode(char[] rawPassword){
        return passwordEncoder.encode(new String(rawPassword));
    }

    public String encode(String rawPassword){
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matches(char[] rawPassword, String encodedPassword){
        return passwordEncoder.matches(new String(rawPassword), encodedPassword);
    }

    public boolean upgradeEncoding(String rawPassword){
        return passwordEncoder.upgradeEncoding(rawPassword);
    }
}
