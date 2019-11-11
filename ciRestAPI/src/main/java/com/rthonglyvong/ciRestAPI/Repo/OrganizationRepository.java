package com.rthonglyvong.ciRestAPI.Repo;

import com.rthonglyvong.ciRestAPI.Model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long>{
}
