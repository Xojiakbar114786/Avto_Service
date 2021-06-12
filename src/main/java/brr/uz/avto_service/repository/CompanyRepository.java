package brr.uz.avto_service.repository;

import brr.uz.avto_service.collection.LocationCollection;
import brr.uz.avto_service.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository

public interface CompanyRepository extends JpaRepository<Company, Long> {


    List<LocationCollection> findByActiveTrue();

    List<LocationCollection> findByActiveAndLanBetweenAndLatBetween(boolean active, Double lan, Double lan2, Double lat, Double lat2);

    Optional<Company> findById(Long id);
}
