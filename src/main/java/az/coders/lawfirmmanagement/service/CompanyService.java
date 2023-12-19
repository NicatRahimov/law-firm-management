package az.coders.lawfirmmanagement.service;

import az.coders.lawfirmmanagement.dto.CaseDto;
import az.coders.lawfirmmanagement.dto.CompanyDto;
import az.coders.lawfirmmanagement.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    List<CompanyDto> getAllCompanies();
    CompanyDto getCompById(Long id);
    String addCompany(CompanyDto companyDto);
    String deleteCompanyById(Long id);
    String editCompany(CompanyDto companyDto,Long id);
}
