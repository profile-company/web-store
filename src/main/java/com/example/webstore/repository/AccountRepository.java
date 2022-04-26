package com.example.webstore.repository;

import com.example.webstore.models.AccountModels;
import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModels, Integer> {

    @Query(value = "SELECT password FROM account u WHERE u.username = ?2",
            nativeQuery = true)
    String findPassword(String username);
}