package az.coders.lawfirmmanagement.controller;

import az.coders.lawfirmmanagement.dto.response.JwtAuthResponse;
import az.coders.lawfirmmanagement.dto.request.SignInRequest;
import az.coders.lawfirmmanagement.dto.request.SignUpRequest;
import az.coders.lawfirmmanagement.dto.request.GrantRequest;
import az.coders.lawfirmmanagement.dto.request.RefreshTokenRequest;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.service.AuthService;
import az.coders.lawfirmmanagement.service.ImageService;
import az.coders.lawfirmmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthService authService;
    private final ImageService imageService;
    private final UserService userService;




    @PostMapping("/register")
    public ResponseEntity<String> signUp(@ModelAttribute SignUpRequest sign,
                                       @RequestParam("photo") MultipartFile photo) throws IOException {
        User user = new User();
        if (userService.getByUsername(sign.getUsername())==null &&
            userService.getByEmail(sign.getEmail())==null){
            user = authService.signUpReq(sign);
            System.out.println(user);
        }

        if (user.getId() != null) {
            imageService.uploadImage(photo, user.getId());
        }else throw new UsernameNotFoundException("User id is null!");

        return new ResponseEntity<>("good",
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