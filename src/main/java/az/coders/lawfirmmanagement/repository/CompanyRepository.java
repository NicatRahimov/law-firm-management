package az.coders.lawfirmmanagement.repository;

import az.coders.lawfirmmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
