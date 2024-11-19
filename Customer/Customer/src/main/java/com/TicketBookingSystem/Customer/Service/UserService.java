package com.TicketBookingSystem.Customer.Service;

import com.TicketBookingSystem.Customer.DataTranferObject.UserDTO;
import com.TicketBookingSystem.Customer.Entity.User;
import com.TicketBookingSystem.Customer.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;      // create new userreposi

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>() {}.getType());
    }

    public String saveuser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return "customer saved successfully";
    }

    public String updateuser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return "customer updated successfully";
    }

    public String deleteuser(Integer userID) {
        userRepository.deleteById(userID);
        return "customer deleted successfully";
    }
    public UserDTO getUserByuserId(Integer userid) {
        User user = userRepository.getUserByuserID(userid);
        return modelMapper.map(user, UserDTO.class);
    }


    //    public UserDTO updateuser(UserDTO userDTO) {
    //        userRepository.save(modelMapper.map(userDTO, User.class));
    //        return userDTO;
    //    }
    //    public String deleteuser(UserDTO userDTO) {
    //        userRepository.delete(modelMapper.map(userDTO, User.class));
    //        return "User deleted";
    //    }
}
