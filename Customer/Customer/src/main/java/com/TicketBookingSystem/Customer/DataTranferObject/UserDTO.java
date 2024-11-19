package com.TicketBookingSystem.Customer.DataTranferObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       //all getters and setters
@AllArgsConstructor         //constructor with argument
@NoArgsConstructor          // constructor without arguments
public class UserDTO {

    private int userID;
    private String userName;
    private String UserEmail;
    private String userPassword;
    //private String phoneNumber;
}
