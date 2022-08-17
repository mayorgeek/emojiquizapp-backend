package com.aiotouch.emojiquizapp.repository;

import com.aiotouch.emojiquizapp.entity.ClientDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDAO, Long> {
    ClientDAO findByUsername(String username);
}