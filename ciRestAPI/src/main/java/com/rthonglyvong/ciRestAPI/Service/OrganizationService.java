package com.rthonglyvong.ciRestAPI.Service;

import com.rthonglyvong.ciRestAPI.Model.Organization;
import com.rthonglyvong.ciRestAPI.Repo.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    public void save(Organization organization) {
        organizationRepository.save(organization);
    }
}
