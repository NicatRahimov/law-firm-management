package az.coders.lawfirmmanagement.service;

import az.coders.lawfirmmanagement.dto.CaseDto;
import az.coders.lawfirmmanagement.model.Case;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CaseService {

    List<CaseDto> getAllCases();
    CaseDto getCaseById(Long id);
    String addCase(CaseDto caseDto);
    String deleteCaseById(Long id);
    String editCase(CaseDto caseDto);
}
