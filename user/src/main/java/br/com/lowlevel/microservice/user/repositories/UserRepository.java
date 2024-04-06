package br.com.lowlevel.microservice.user.repositories;

import br.com.lowlevel.microservice.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
