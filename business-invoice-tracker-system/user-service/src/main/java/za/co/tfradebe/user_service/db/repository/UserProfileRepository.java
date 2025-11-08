package za.co.tfradebe.user_service.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tfradebe.user_service.db.entities.UserProfileEntity;

public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {
}
