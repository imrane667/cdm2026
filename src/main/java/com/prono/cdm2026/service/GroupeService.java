package com.prono.cdm2026.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.repository.GroupeRepository;

@Service
public class GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;

    public List<Groupe> findAll(){
        return groupeRepository.findAll();
    }

    public Groupe save(Groupe groupe){
        return groupeRepository.save(groupe);
    }
    public Groupe findById(Long id) {
        return groupeRepository.findById(id).orElseThrow();
    }

    
}
