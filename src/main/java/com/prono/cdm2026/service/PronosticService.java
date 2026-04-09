package com.prono.cdm2026.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.model.Pronostic;
import com.prono.cdm2026.model.User;
import com.prono.cdm2026.repository.PronosticRepository;

@Service
public class PronosticService {
    @Autowired
    private PronosticRepository pronosticRepository;

    public List<Pronostic> findAll(){
        return pronosticRepository.findAll();
    } 
    public Pronostic save(Pronostic pronostic){
        return pronosticRepository.save(pronostic);
    }
    public List<Pronostic> findByUser(User user){
        return pronosticRepository.findByUser(user);
    }
    public boolean existsByUserAndGroupe(User user, Groupe groupe) {
    return pronosticRepository.existsByUserAndGroupe(user, groupe);
}
    public Pronostic findByUserAndGroupe(User user, Groupe groupe) {
    return pronosticRepository.findByUserAndGroupe(user, groupe);
}
    
}
