package com.TicketBookingSystem.Vendor.Service;

import com.TicketBookingSystem.Vendor.DataTransferObject.VendorDTO;
import com.TicketBookingSystem.Vendor.Entity.Vendor;
import com.TicketBookingSystem.Vendor.Repository.VendorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = vendorRepository.findAll();
        return modelMapper.map(vendors, new TypeToken<List<VendorDTO>>() {}.getType());
    }

    public String saveVendor(VendorDTO vendorDTO) {
        vendorRepository.save(modelMapper.map(vendorDTO, Vendor.class));
        return "save successfully";
    }

    public String updateVendor(VendorDTO vendorDTO) {
        vendorRepository.save(modelMapper.map(vendorDTO, Vendor.class));
        return "update successfully";
    }
    public String deleteVendor(int vendorID) {
        vendorRepository.deleteById(vendorID);
        return "delete successfully";
    }

    public VendorDTO getVendorByvendorID(Integer vendorid) {
        Vendor vendor = vendorRepository.getVendorByvendorID(vendorid);
        return modelMapper.map(vendor, VendorDTO.class);
    }

}
