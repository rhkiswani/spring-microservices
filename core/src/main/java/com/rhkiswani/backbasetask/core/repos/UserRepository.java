package com.rhkiswani.backbasetask.core.repos;

import com.rhkiswani.backbasetask.core.entites.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User, Integer> {

    @Query("select case when count(u) > 0 then true else false end from User u where u.username= ?1")
    boolean usernameExists(String username);

    User getByUsername(String username);
}
