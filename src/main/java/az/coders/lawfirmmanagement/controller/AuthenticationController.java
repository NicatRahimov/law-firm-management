package az.coders.lawfirmmanagement.controller;

import az.coders.lawfirmmanagement.dto.response.JwtAuthResponse;
import az.coders.lawfirmmanagement.dto.request.SignInRequest;
import az.coders.lawfirmmanagement.dto.request.SignUpRequest;
import az.coders.lawfirmmanagement.dto.request.GrantRequest;
import az.coders.lawfirmmanagement.dto.request.RefreshTokenRequest;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthService authService;




    @PostMapping("/register")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest sign)  {
        return new ResponseEntity<>(authService.signUpReq(sign),
                HttpStatusCode.valueOf(200));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignInRequest sign){
        return new ResponseEntity<>(authService.signIn(sign), HttpStatusCode.valueOf(200));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse>refresh(@RequestBody RefreshTokenRequest refresh){
        return new ResponseEntity<>(authService.refreshToken(refresh)
                ,HttpStatusCode.valueOf(200));

    }

    @PostMapping("/grant")
    public JwtAuthResponse grantUser(@RequestBody GrantRequest grantRequest){
       return authService.grant(grantRequest);

    }

}