package az.coders.lawfirmmanagement.model;

import az.coders.lawfirmmanagement.enums.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Table(name = "tasks")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    @Enumerated(EnumType.STRING)
    Priority priority;


    String description;

    Integer remindDate;

    @ManyToOne
    @JoinColumn(name = "case_id") // Defines the foreign key column
   Case aCase;


}
