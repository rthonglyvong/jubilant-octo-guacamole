package com.rthonglyvong.ciRestAPI.Controller;

import com.rthonglyvong.ciRestAPI.Service.UserService;
import com.rthonglyvong.ciRestAPI.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class CameraIQController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public void createUser(@RequestParam String name
                           ) {
        Users user = new Users();
        user.setFirstName(name);
        userService.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }
}
