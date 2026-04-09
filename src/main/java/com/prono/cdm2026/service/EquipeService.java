package com.prono.cdm2026.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prono.cdm2026.model.Equipe;
import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.repository.EquipeRepository;
@Service
public class EquipeService {
    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> findAll(){
        return equipeRepository.findAll();
    }
    public Equipe save(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public List<Equipe> findByGroupe(Groupe groupe){
      return  equipeRepository.findByGroupe(groupe);
    }
    public Equipe findById(Long id){
        return equipeRepository.findById(id).orElseThrow();
    }
}
