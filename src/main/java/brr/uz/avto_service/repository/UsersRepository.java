package brr.uz.avto_service.repository;

import brr.uz.avto_service.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE deleted=false AND id IN (SELECT user_id FROM user_role WHERE role_id = (SELECT id FROM role WHERE role_name = :roleName))")
    Page<Users> findAllByRole(Pageable pageable, String roleName);

    Optional<Users> findByPhoneNumber(String phoneNumber);

    boolean existsByPhoneNumber(String phoneNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE phone_number= :phoneNumber AND password= :password")
    Users findByPhoneNumberAndPassword(String phoneNumber, String password);
}
