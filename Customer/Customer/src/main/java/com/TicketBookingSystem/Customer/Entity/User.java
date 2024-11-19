package com.TicketBookingSystem.Customer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private int userID;
    private String userName;
    private String userEmail;
    private String userPassword;
    //private String phoneNumber;
}
