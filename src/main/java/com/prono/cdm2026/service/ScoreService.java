package com.prono.cdm2026.service;

import org.springframework.stereotype.Service;

import com.prono.cdm2026.model.ClassementReel;
import com.prono.cdm2026.model.Pronostic;

@Service
public class ScoreService {

    public int calcul(Pronostic pronostic, ClassementReel classementReel){
        int score = 0;
        if (pronostic.getEquipe1er().equals(classementReel.getEquipe1er())) {
            score += 2;
        }
        if (pronostic.getEquipe2eme().equals(classementReel.getEquipe2eme())) {
            score += 2;
            
        }
        if (pronostic.getEquipe3eme().equals(classementReel.getEquipe3eme())) {
            score +=2;
            
        }
        if (pronostic.getEquipe4eme().equals(classementReel.getEquipe4eme())) {
            score += 2;
            
        }
        return score;
            
        }
    }

