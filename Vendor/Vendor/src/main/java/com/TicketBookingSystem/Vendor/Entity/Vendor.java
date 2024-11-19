package com.TicketBookingSystem.Vendor.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
    @Id
    private int vendorID;
    private String vendorName;
    private String vendorPassword;
    private String vendorEmail;


}
