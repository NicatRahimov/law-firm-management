package az.coders.lawfirmmanagement.model;

import az.coders.lawfirmmanagement.enums.CaseStage;
import az.coders.lawfirmmanagement.enums.Office;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "cases")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    @Column(name = "case_number")
    String caseNumber;

    @Column(name = "opened_date")
    LocalDate openedDate;

    @Column(name = "limit_date")
    LocalDate limitDate;

    String description;

    @Enumerated(EnumType.STRING)
    Office office;

    @Enumerated(EnumType.STRING)
    CaseStage caseStage;
}
