package com.rthonglyvong.ciRestAPI.Service;

import com.rthonglyvong.ciRestAPI.Repo.OrganizationRepository;
import com.rthonglyvong.ciRestAPI.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rthonglyvong.ciRestAPI.Model.Users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<Users> findUser(long userId) {
        return userRepository.findById(userId);
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

    public void deleteUserToOrganization(Long userId, Long organizationId) {
        userRepository.findById(userId).ifPresent(u -> {
            organizationRepository.findById(organizationId).ifPresent(o -> {
                u.getOrganizations().remove(o);
                save(u);
            });
        });
    }

    public List<Users> findAllUsersInOrganization(long organizationId) {
        List<Users> retValue = findAll();
        retValue = retValue.stream().filter(u -> u.getOrganizations().stream()
                .anyMatch(o -> o.getOrganization_id() == organizationId))
                .collect(Collectors.toList());
        return retValue;
    }

}
