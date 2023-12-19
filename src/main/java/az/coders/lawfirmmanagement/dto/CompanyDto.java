package az.coders.lawfirmmanagement.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDto {

    Long id;
    String name;
    String email;
    String website;
    String phoneNumber;
    String address;
    String city;
    String country;
    String description;
}
