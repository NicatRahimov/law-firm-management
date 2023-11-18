package az.coders.lawfirmmanagement.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequest {
     String firstName;
     String lastName;
     String email;
     String password;
     String photoBase64;
}