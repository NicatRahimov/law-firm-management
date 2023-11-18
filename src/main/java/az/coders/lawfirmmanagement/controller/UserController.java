package az.coders.lawfirmmanagement.controller;


import az.coders.lawfirmmanagement.dto.UserDto;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.repository.UserRepository;
import az.coders.lawfirmmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String username) throws IOException {
       return userService.getByUsername(username);
    }
}