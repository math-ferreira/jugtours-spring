package com.okta.developer.jugtours.model.repository;

import com.okta.developer.jugtours.model.Group;
import com.okta.developer.jugtours.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
