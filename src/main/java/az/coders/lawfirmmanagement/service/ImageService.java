package az.coders.lawfirmmanagement.service;

import az.coders.lawfirmmanagement.dto.ImageDto;
import az.coders.lawfirmmanagement.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {
    void uploadImage(ImageDto image) throws IOException;
    String downloadImage(String username) throws IOException;

    Image saveImage(Image image);
}
