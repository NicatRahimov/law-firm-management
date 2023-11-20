package az.coders.lawfirmmanagement.repository;

import az.coders.lawfirmmanagement.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    Image findByName(String name);
}
