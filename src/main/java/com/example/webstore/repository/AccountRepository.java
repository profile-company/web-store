package com.example.webstore.repository;

import com.example.webstore.models.AccountModels;
import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountModels, String> {

    @Query(value = "SELECT password FROM account u WHERE u.email = ?1", nativeQuery = true)
    String findPassword(String email);

    @Query(value = "SELECT COUNT(email) from account u where u.email = ?1", nativeQuery = true)
    int existsEmail(String email);

    @Query(value = "SELECT * FROM account u where u.email = ?1", nativeQuery = true)
    AccountModels findAccountByEmail(String email);

    // create query insert new account into account model
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO account(email, password, datetime, enabled) values (?1, ?2, ?3, ?4)",
            nativeQuery = true)
    void insertNewAccount(String email, String password, String date, boolean enabled);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account u SET u.enabled = ?1 WHERE u.email = ?2",
            nativeQuery = true)
    void updateEnabled(boolean flag, String email);
}
