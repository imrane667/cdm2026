package com.prono.cdm2026.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prono.cdm2026.model.Equipe;
import com.prono.cdm2026.model.Groupe;


public interface EquipeRepository extends JpaRepository<Equipe,Long>{
    List<Equipe> findByGroupe(Groupe groupe);
    
}
