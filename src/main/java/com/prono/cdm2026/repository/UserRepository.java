package com.prono.cdm2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prono.cdm2026.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
