package az.coders.lawfirmmanagement.dto;

import az.coders.lawfirmmanagement.enums.Priority;
import az.coders.lawfirmmanagement.model.Case;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    Long id;
    String name;
    Priority priority;
    String description;
    Integer remindDate;
    Case aCase;
}
