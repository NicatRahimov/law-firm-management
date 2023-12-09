package az.coders.lawfirmmanagement.dto;

import az.coders.lawfirmmanagement.enums.CaseStage;
import az.coders.lawfirmmanagement.enums.Office;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CaseDto {
    Long id;
    String name;
    String caseNumber;
    String description;
    String openedDate;
    String limitDate;
    Office office;
    CaseStage caseStage;
}
