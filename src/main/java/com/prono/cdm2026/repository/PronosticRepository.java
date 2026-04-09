package com.prono.cdm2026.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.model.Pronostic;
import com.prono.cdm2026.model.User;

public interface PronosticRepository extends JpaRepository<Pronostic,Long>{
    List<Pronostic> findByUser(User user);
    boolean existsByUserAndGroupe(User user, Groupe groupe);
    Pronostic findByUserAndGroupe(User user, Groupe groupe);
}
