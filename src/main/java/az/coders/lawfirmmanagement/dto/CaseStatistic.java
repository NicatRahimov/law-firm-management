package az.coders.lawfirmmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CaseStatistic {

    int allCases;
    int casesInProgress;
    int closedCases;

}
