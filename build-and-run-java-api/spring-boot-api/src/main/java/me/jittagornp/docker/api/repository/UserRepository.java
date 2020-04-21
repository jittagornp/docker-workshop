package me.jittagornp.docker.api.repository;

import me.jittagornp.docker.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jitta
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
