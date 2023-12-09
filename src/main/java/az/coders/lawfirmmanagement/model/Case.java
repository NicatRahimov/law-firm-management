package az.coders.lawfirmmanagement.model;

import az.coders.lawfirmmanagement.enums.CaseStage;
import az.coders.lawfirmmanagement.enums.Office;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "cases")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "case_number")
    String caseNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Column(name = "opened_date")
    LocalDate openedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Column(name = "limit_date")
    LocalDate limitDate;

    String description;

    @Enumerated(EnumType.STRING)
    Office office;

    @Enumerated(EnumType.STRING)
    CaseStage caseStage;
}
