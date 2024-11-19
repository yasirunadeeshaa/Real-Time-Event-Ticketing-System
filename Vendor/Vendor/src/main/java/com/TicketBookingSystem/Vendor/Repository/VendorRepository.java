package com.TicketBookingSystem.Vendor.Repository;

import com.TicketBookingSystem.Vendor.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    @Query(value = "select * FROM vendor WHERE vendor_id=?1", nativeQuery = true)
    Vendor getVendorByvendorID(int id);
}
