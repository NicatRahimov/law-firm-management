package az.coders.lawfirmmanagement.service.Impl;

import az.coders.lawfirmmanagement.dto.ImageDto;
import az.coders.lawfirmmanagement.model.Image;
import az.coders.lawfirmmanagement.model.User;
import az.coders.lawfirmmanagement.repository.ImageRepository;
import az.coders.lawfirmmanagement.repository.UserRepository;
import az.coders.lawfirmmanagement.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Value("${photo.directory}")
     static String DIRECTORY;

private final ImageRepository imageRepository;
private final UserRepository userRepository;

    @Override
    public void uploadImage(ImageDto imageDto) throws IOException {
        String filePath=DIRECTORY+imageDto.getName();


            // Decode Base64 string to bytes
            byte[] decodedBytes = Base64.getDecoder().decode(imageDto.getBase64());

            // Specify the file path and name where you want to save the file

            // Save the decoded bytes to a file
            Files.write(Path.of(filePath), decodedBytes);

    }

    @Override
    public String downloadImage(String username) throws IOException {

        User user = userRepository.findByUsername(username);

        Image userImage = user.getImage();

        String imageDir = DIRECTORY + userImage.getName();

        byte[] imageData = Files.readAllBytes(Paths.get(imageDir));

        return Base64.getEncoder().encodeToString(imageData);   //image base64 formatted

    }

    @Override
    public Image saveImage(Image image) {
        Image image1 = imageRepository.save(image);
        return image1;
    }

}
