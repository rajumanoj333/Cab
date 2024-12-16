package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepo extends JpaRepository<Cab, String> {  // Primary Key is fullName, so use String

    // Query to check login based on fullName and password
    String query = "select c from Cab c where c.fullName = ?1 and c.password = ?2";

    @Query(query)
    public Cab loginCheck(String fullName, String password);

}
