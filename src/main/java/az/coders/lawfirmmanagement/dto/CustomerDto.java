package az.coders.lawfirmmanagement.dto;

import az.coders.lawfirmmanagement.model.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String city;
    String country;
}
