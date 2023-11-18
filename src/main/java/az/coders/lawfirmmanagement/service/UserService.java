package az.coders.lawfirmmanagement.service;

import az.coders.lawfirmmanagement.dto.UserDto;
import az.coders.lawfirmmanagement.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface UserService {

    UserDetailsService userDetailsService();

    ResponseEntity<UserDto> getByUsername(String username) throws IOException;

    List<User> getAllUsers();
}