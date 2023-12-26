package az.coders.lawfirmmanagement.controller;

import az.coders.lawfirmmanagement.dto.CaseDto;
import az.coders.lawfirmmanagement.dto.CaseStatistic;
import az.coders.lawfirmmanagement.service.CaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomePageController {
    private final CaseService caseService;

    @GetMapping
    public CaseStatistic casesWithStatistic() {
        List<CaseDto> cases = caseService.getAllCases();
        int casesCount = cases.size();
int closedCount = 0;
int inProgressCount=0;
        for(CaseDto c:cases){
            if (c.getCaseStage().getDisplayName().equals("Closed")){
                closedCount++;
            }
            if (c.getCaseStage().getDisplayName().equals("In Progress")){
                inProgressCount++;
            }
        }
        return CaseStatistic.builder()
                .allCases(casesCount)
                .casesInProgress(inProgressCount)
                .closedCases(closedCount)
                .build();
    }


}
