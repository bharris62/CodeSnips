package co.snpr.repositories;

import co.snpr.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by BHarris on 4/27/17.
 */
public interface UserRepository extends CrudRepository<User, Integer>{
    User findFirstByUsername(String username);
}
