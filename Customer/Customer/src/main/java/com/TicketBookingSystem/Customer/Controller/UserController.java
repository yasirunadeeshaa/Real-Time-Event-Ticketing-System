package com.TicketBookingSystem.Customer.Controller;

import com.TicketBookingSystem.Customer.DataTranferObject.UserDTO;
import com.TicketBookingSystem.Customer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    private UserService userService;    //create new userservice object

    //get added user
    @GetMapping("/getuser")
    public List<UserDTO> getUser() {
        return userService.getUsers();
    }

    //add user
    @PostMapping("/adduser")
    public String addUser(@RequestBody UserDTO userDTO) {
        return userService.saveuser(userDTO);
    }

    //updateuser
    @PutMapping("/updateuser")
    public String updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateuser(userDTO);
    }

    //delete user
    @DeleteMapping("/deleteuser/{userID}")
    //    public String deleteUser(@RequestBody UserDTO userDTO) {
    //        return userService.deleteuser(userDTO);
    //    }
    public String deleteUser(@PathVariable Integer userID) {
        return userService.deleteuser(userID);
    }

}
