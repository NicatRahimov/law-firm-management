package az.coders.lawfirmmanagement.service;

import az.coders.lawfirmmanagement.dto.request.GrantRequest;
import az.coders.lawfirmmanagement.dto.request.RefreshTokenRequest;
import az.coders.lawfirmmanagement.dto.request.SignInRequest;
import az.coders.lawfirmmanagement.dto.request.SignUpRequest;
import az.coders.lawfirmmanagement.dto.response.JwtAuthResponse;
import az.coders.lawfirmmanagement.enums.Role;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.repository.UserRepository;
import az.coders.lawfirmmanagement.service.Impl.JWTServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTServiceImpl jwtServiceImpl;

    public User signUpReq(SignUpRequest signUpRequest) {
        User user = new User();

        if (userRepository.findByUsername(signUpRequest.getEmail()) == null) {
            user.setFirstName(signUpRequest.getFirstName());
            user.setSecondName(signUpRequest.getLastName());
            user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            user.setUsername(signUpRequest.getUsername());
            user.setEmail(signUpRequest.getEmail());
            user.setRole(Role.USER);
//            user.setImage(image);


            userRepository.save(user);

        }
        return user;
    }

    public JwtAuthResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                        signInRequest.getPassword()));
        System.out.println(signInRequest);
        User user = userRepository.findByUsername(signInRequest.getEmail());
        System.out.println(user);
        String jwt = jwtServiceImpl.generateToken(user);

        String refreshToken = jwtServiceImpl.generateRefreshToken(new HashMap<>(), user);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();


        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);

        return jwtAuthResponse;
    }

    public JwtAuthResponse refreshToken(RefreshTokenRequest refresh) {

        String token = refresh.getToken();
        String username = jwtServiceImpl.extractUsername(token);
        User user = userRepository.findByUsername(username);


        if (jwtServiceImpl.isTokenValid(token, user)) {
            String newToken = jwtServiceImpl.generateToken(user);

            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

            jwtAuthResponse.setToken(newToken);
            jwtAuthResponse.setRefreshToken(refresh.getToken());


            return jwtAuthResponse;
        } else return null;

    }

    public JwtAuthResponse grant(GrantRequest grantRequest) {
        String token = grantRequest.getToken();
        String username = jwtServiceImpl.extractUsername(token);
        User user = userRepository.findByUsername(username);


        user.setRole(Role.ADMIN);

        userRepository.save(user);

        return JwtAuthResponse.builder()
                .token(jwtServiceImpl.generateToken(user))
                .build();
    }
}