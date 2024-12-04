package com.meenus.springboot_dto.repository;

import com.meenus.springboot_dto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
