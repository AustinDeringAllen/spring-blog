package com.codeup.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.id like ?1")
    User getById(long id);

    @Query("from User u where u.email like %:term%")
    List<User> getByEmail(@Param("term") String term);

    @Query("from User u where u.username like %:term%")
    List<User> getByUsername(@Param("term") String term);
}
