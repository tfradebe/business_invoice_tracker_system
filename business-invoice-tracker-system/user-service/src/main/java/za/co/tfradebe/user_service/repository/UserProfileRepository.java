package za.co.tfradebe.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tfradebe.user_service.model.entities.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {
    UserProfileEntity findByEmail(String email);
}
