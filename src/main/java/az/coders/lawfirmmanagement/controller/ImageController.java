package az.coders.lawfirmmanagement.controller;


import az.coders.lawfirmmanagement.dto.UserDto;
import az.coders.lawfirmmanagement.model.Image;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.repository.UserRepository;
import az.coders.lawfirmmanagement.service.ImageService;
import az.coders.lawfirmmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final UserService userService;

  @PostMapping("/upload/{id}")
    public ResponseEntity<String> uploadPhoto(@RequestParam("photo") MultipartFile photo,
                                              @PathVariable("id") Long id) throws IOException {
      return imageService.uploadImage(photo,id);
  }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> uploadPhoto(@PathVariable("id") Long id) throws IOException {
        return imageService.downloadImage(id);
    }

}