package akai.repository;

import akai.jpa.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u " +
            "left join fetch u.address " +
            "where u.active = true and " +
            "u.lastName = :name")
    public User findByName(@Param("name") String name);
}
