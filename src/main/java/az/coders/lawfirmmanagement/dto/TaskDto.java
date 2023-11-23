package az.coders.lawfirmmanagement.dto;

import az.coders.lawfirmmanagement.enums.Priority;
import az.coders.lawfirmmanagement.model.Case;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class TaskDto {
    Long id;
    String name;
    Priority priority;
    String description;
    Case aCase;
}
