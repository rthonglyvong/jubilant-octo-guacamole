package com.rthonglyvong.ciRestAPI.Repo;

import com.rthonglyvong.ciRestAPI.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

}
