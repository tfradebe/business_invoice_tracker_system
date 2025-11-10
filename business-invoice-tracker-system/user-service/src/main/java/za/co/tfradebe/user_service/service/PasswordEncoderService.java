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

    public char[] encode(char[] rawPassword){
        return passwordEncoder.encode(new String(rawPassword)).toCharArray();
    }

    public boolean matches(char[] rawPassword, String encodedPassword){
        return passwordEncoder.matches(new String(rawPassword), encodedPassword);
    }
}
