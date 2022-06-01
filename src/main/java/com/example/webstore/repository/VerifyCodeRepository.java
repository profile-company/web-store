package com.example.webstore.repository;

import com.example.webstore.models.VerifyCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, Integer> {

    @Query(value = "SELECT code FROM verifycode u where u.account_email = ?1",
            nativeQuery = true)
    String findVerifyCodeByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM verifycode u where u.account_email = ?1",
            nativeQuery = true)
    int deleteVerifyCodeOfAccount(String email);
}
