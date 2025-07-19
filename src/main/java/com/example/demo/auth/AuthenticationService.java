package com.example.demo.auth;
import com.example.demo.security.config.*;
import com.example.demo.User.Role;
import com.example.demo.User.User;
import com.example.demo.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

        var user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.Admin)
                .build();
                repository.save(user);
                var jwtToken = jwtService.generationTocken(user.getEmail());
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generationTocken(user.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
