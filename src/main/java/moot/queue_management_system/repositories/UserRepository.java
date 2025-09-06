package moot.queue_management_system.repositories;

import moot.queue_management_system.entities.User;
import moot.queue_management_system.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByOrganizationId(UUID organizationId);
    List<User> findByRole(UserRole role);
}

