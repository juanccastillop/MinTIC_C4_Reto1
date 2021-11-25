package co.edu.usa.lasartenreto1.reto1_lasarten.repositories.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.lasartenreto1.reto1_lasarten.models.User;

public interface UserCrudRepository extends CrudRepository <User, Integer>{
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
