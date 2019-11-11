package com.rthonglyvong.ciRestAPI.Controller;

import com.rthonglyvong.ciRestAPI.Model.Organization;
import com.rthonglyvong.ciRestAPI.Service.OrganizationService;
import com.rthonglyvong.ciRestAPI.Service.UserService;
import com.rthonglyvong.ciRestAPI.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins={"http://localhost:3000"}) //For a react front end if i have time
public class CameraIQController {

    @Autowired
    UserService userService;
    @Autowired
    OrganizationService organizationService;

    @PostMapping("/createUser")
    public void createUser(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String email,
                           @RequestParam String address,
                           @RequestParam String phone
                           ) {
        Users user = new Users(firstName, lastName, email, address, phone);
        userService.save(user);
    }

    @PostMapping("/createOrganization")
    public void createOrganization(@RequestParam String name,
                                   @RequestParam String address,
                                   @RequestParam String phone) {
        Organization organization = new Organization(name, address, phone);
        organizationService.save(organization);
    }
    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        List<Users> retValue = userService.findAll();
        return retValue;
    }

    @PostMapping("/addUserToOrganization")
    public void addUserToOrganization(@RequestParam long userId,
                                      @RequestParam long organizationId) {
        userService.addUserToOrganization(userId, organizationId);
    }
}
