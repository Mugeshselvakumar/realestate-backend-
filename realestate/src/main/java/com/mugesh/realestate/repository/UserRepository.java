package com.mugesh.realestate.repository;

import com.mugesh.realestate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long>{

}
