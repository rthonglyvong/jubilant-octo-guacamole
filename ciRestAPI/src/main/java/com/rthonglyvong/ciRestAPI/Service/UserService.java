package com.rthonglyvong.ciRestAPI.Service;

import com.rthonglyvong.ciRestAPI.Repo.OrganizationRepository;
import com.rthonglyvong.ciRestAPI.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rthonglyvong.ciRestAPI.Model.Users;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganizationRepository organizationRepository;

    public void save(Users user) {
        userRepository.save(user);
    }

    public void delete(Long user_id) {
        userRepository.deleteById(user_id);
    }

    public List<Users> findAll() {
        return (List<Users>) userRepository.findAll();
    }

    public void addUserToOrganization(Long userId, Long organizationId) {
        userRepository.findById(userId).ifPresent(u -> {
            organizationRepository.findById(organizationId).ifPresent(o -> {
                u.getOrganizations().add(o);
                save(u);
            });
        });
    }

}
