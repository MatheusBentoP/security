package com.project.exemploDeSeguranca.Repository;

import com.project.exemploDeSeguranca.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
   Optional<User> findbyUsername(String username);
}
