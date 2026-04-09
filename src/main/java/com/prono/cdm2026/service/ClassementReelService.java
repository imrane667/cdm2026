package com.prono.cdm2026.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prono.cdm2026.model.ClassementReel;
import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.repository.ClassementReelRepository;

@Service
public class ClassementReelService {
    @Autowired
    private ClassementReelRepository classementReelRepository;

    public List<ClassementReel> findAll(){
        return classementReelRepository.findAll();
    }
    public ClassementReel save(ClassementReel classementReel){
        return classementReelRepository.save(classementReel);
    }

    public ClassementReel findByGroupe(Groupe groupe){
        return classementReelRepository.findByGroupe(groupe);
    }
    
}
