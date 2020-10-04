package com.rafaldebowski.UsersApp.repository;

import com.rafaldebowski.UsersApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
