 package com.example.webstore.repository;

 import com.example.webstore.models.CustomerModels;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;

 public interface CustomerRepository extends JpaRepository<CustomerModels, Integer> {

     // select information about customer by "account_email"
     @Query(value = "SELECT * FROM customer u WHERE u.account_email = ?1", nativeQuery = true)
     CustomerModels findCustomer(String account_email);
 }
