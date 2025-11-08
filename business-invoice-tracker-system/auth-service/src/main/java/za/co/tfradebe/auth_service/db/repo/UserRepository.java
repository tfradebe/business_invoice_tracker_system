package za.co.tfradebe.auth_service.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tfradebe.auth_service.db.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
