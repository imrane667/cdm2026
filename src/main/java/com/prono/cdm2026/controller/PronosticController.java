package com.prono.cdm2026.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prono.cdm2026.model.Equipe;
import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.model.Pronostic;
import com.prono.cdm2026.model.User;
import com.prono.cdm2026.service.EquipeService;
import com.prono.cdm2026.service.GroupeService;
import com.prono.cdm2026.service.PronosticService;
import com.prono.cdm2026.service.UserService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class PronosticController {

    @Autowired
    private GroupeService groupeService;
    @Autowired 
    private UserService userService;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private PronosticService pronosticService;

    @GetMapping("/prono")
    public String pronostic(@RequestParam Long groupeId, @RequestParam Long userId, Model model) {
        Groupe groupe = groupeService.findById(groupeId);
        User user = userService.findById(userId);
        Pronostic existingProno = pronosticService.findByUserAndGroupe(user, groupe);
        
        model.addAttribute("groupe", groupe);
        model.addAttribute("userId", user);
        model.addAttribute("equipe", equipeService.findByGroupe(groupe));
        model.addAttribute("existingProno", existingProno);
        return "prono";
    }
    @PostMapping("/prono")
    public String postProno(@RequestParam Long userId, @RequestParam Long groupeId, @RequestParam Long equipe1erId, @RequestParam Long equipe2emeId, @RequestParam Long equipe3emeId, @RequestParam Long equipe4emeId) {
        User user = userService.findById(userId);
        Groupe groupe = groupeService.findById(groupeId);
        Equipe e1 = equipeService.findById(equipe1erId);
        Equipe e2 = equipeService.findById(equipe2emeId);
        Equipe e3 = equipeService.findById(equipe3emeId);
        Equipe e4 = equipeService.findById(equipe4emeId);
    
        Pronostic prono = pronosticService.findByUserAndGroupe(user, groupe);
        if (prono == null) {
            prono = new Pronostic();
        }
        prono.setUser(user);
        prono.setGroupe(groupe);
        prono.setEquipe1er(e1);
        prono.setEquipe2eme(e2);
        prono.setEquipe3eme(e3);
        prono.setEquipe4eme(e4);
        pronosticService.save(prono);
        
        return "redirect:/groupes?userId=" + userId;
    }
    
    
}
