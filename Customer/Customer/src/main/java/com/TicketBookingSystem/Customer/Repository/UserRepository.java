package com.TicketBookingSystem.Customer.Repository;


import com.TicketBookingSystem.Customer.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * FROM user WHERE user_ID=?1", nativeQuery = true)
    User getUserByuserID(int userID);
}
