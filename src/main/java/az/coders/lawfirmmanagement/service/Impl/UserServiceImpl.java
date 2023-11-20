package az.coders.lawfirmmanagement.service.Impl;


import az.coders.lawfirmmanagement.dto.UserDto;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.repository.UserRepository;
import az.coders.lawfirmmanagement.service.ImageService;
import az.coders.lawfirmmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ImageService imageService;

    @Override
    public UserDetailsService userDetailsService(){
       return new UserDetailsService() {
           @Override
           public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
             return userRepository.findByUsername(username);
           }
       };
    }


//    @Override
//    public ResponseEntity<UserDto> getByUsername(String username) throws IOException {
//        User user = userRepository.findByUsername(username);
//
//        File file = new File(ImageServiceImpl.DIRECTORY + user.getImage().getName());
//
//        UserDto userDto = UserDto.builder().firstName(user.getFirstName())
//                .secondName(user.getSecondName())
//                .password(user.getPassword())
//                .role(user.getRole())
//                .username(user.getUsername())
//                .id(user.getId())
//                .base64Photo(imageService.downloadImage(username))
//                .build();
//
//        return new ResponseEntity<>( userDto,HttpStatusCode.valueOf(200));
//    }

    @Override
    public List<User> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("not found"));
    }

    @Override
    public void saveUser(User user) {
userRepository.save(user);
    }


}