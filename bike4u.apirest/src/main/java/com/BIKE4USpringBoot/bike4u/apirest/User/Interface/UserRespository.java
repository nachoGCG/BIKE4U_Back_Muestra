package com.BIKE4USpringBoot.bike4u.apirest.User.Interface;

import com.BIKE4USpringBoot.bike4u.apirest.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
