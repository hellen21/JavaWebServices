package com.javaWebServices.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javaWebServices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
