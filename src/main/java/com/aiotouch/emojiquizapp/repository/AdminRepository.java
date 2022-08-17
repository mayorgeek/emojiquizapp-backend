package com.aiotouch.emojiquizapp.repository;

import com.aiotouch.emojiquizapp.entity.AdminDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminDAO, Long> {
    AdminDAO findByUsername(String username);
}