package com.prono.cdm2026.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prono.cdm2026.model.ClassementReel;
import com.prono.cdm2026.model.Groupe;

public interface ClassementReelRepository extends JpaRepository<ClassementReel,Long>{
    ClassementReel findByGroupe(Groupe groupe);
        
}

