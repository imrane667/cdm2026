package com.prono.cdm2026.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prono.cdm2026.repository.EquipeRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ClassementReel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;
    @ManyToOne
    @JoinColumn(name = "equipe1er_id")
    private Equipe equipe1er;
    @ManyToOne
    @JoinColumn(name = "equipe2eme_id")
    private Equipe equipe2eme;
    @ManyToOne 
    @JoinColumn(name = "equipe3eme_id")
    private Equipe equipe3eme;
    @ManyToOne
    @JoinColumn(name = "equipe4eme_id")
    private Equipe equipe4eme;
   
}
