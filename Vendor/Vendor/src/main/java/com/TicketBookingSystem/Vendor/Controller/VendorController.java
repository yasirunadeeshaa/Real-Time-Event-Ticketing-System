package com.TicketBookingSystem.Vendor.Controller;

import com.TicketBookingSystem.Vendor.DataTransferObject.VendorDTO;
import com.TicketBookingSystem.Vendor.Entity.Vendor;
import com.TicketBookingSystem.Vendor.Service.VendorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    @GetMapping("/getvendor")
    public List<Vendor> getVendor() {
        return vendorService.getAllVendors();
    }

    @PostMapping("/addvendor")
    public String addVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.saveVendor(vendorDTO);
    }

    @PutMapping ("/updatevendor")
    public String updateVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.updateVendor(vendorDTO);
    }

    @DeleteMapping("deletevendor/{vendorID}")
    public String deleteVendor(@PathVariable Integer vendorID) {
        return vendorService.deleteVendor(vendorID);
    }



    //    @GetMapping("getvendor/{vendorID}")
    //    public List<Vendor> getVendorById(@PathVariable int vendorId) {
    //        return vendorService.getAllVendors(vendorId)
    //    }
}
