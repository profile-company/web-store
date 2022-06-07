
package com.example.webstore.repository;


import com.example.webstore.models.CustomerModels;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<CustomerModels, Integer> {

 // select information about customer by "account_email"
 @Query(value = "SELECT * FROM customer u WHERE u.account_email = ?1", nativeQuery = true)
 CustomerModels findCustomer(String account_email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO customer(firstname, lastname, dateborn, sex, account_email) " +
            "value (?1, ?2, ?3, ?4, ?5)",
            nativeQuery = true)
    void insertNewCustomer(String firstName, String lastName, String dateBorn, String sex,
                           String email);
}
