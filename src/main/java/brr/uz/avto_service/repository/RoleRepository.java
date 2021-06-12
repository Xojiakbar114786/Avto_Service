package brr.uz.avto_service.repository;

import brr.uz.avto_service.entity.Role;
import brr.uz.avto_service.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByRoleName(RoleName roleName);
}

