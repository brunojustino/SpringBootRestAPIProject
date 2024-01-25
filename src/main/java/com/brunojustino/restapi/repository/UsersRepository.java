package com.brunojustino.restapi.repository;

import com.brunojustino.restapi.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
