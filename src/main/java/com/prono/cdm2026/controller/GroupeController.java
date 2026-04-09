package com.prono.cdm2026.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.prono.cdm2026.model.Equipe;
import com.prono.cdm2026.model.Groupe;
import com.prono.cdm2026.model.User;
import com.prono.cdm2026.service.EquipeService;
import com.prono.cdm2026.service.GroupeService;
import com.prono.cdm2026.service.PronosticService;
import com.prono.cdm2026.service.UserService;

@Controller
public class GroupeController {

    @Autowired private GroupeService groupeService;
    @Autowired private EquipeService equipeService;
    @Autowired private UserService userService;
    @Autowired private PronosticService pronosticService;

    @GetMapping("/groupes")
    public String listGroupes(@RequestParam Long userId, Model model) {
        User user = userService.findById(userId);
        List<Groupe> groupes = groupeService.findAll();

        Map<Long, List<Equipe>> equipesParGroupe = new HashMap<>();
        Map<Long, Boolean> pronosPlaces = new HashMap<>();

        for (Groupe g : groupes) {
            equipesParGroupe.put(g.getId(), equipeService.findByGroupe(g));
            pronosPlaces.put(g.getId(), pronosticService.existsByUserAndGroupe(user, g));
        }

        model.addAttribute("groupes", groupes);
        model.addAttribute("equipesParGroupe", equipesParGroupe);
        model.addAttribute("pronosPlaces", pronosPlaces);
        model.addAttribute("userId", userId);
        return "groupes";
    }

    @GetMapping("/groupes/{id}")
    public String groupe(@RequestParam Long userId, @PathVariable Long id, Model model) {
        Groupe groupe = groupeService.findById(id);
        List<Equipe> equipe = equipeService.findByGroupe(groupe);
        model.addAttribute("groupe", groupe);
        model.addAttribute("equipe", equipe);
        model.addAttribute("userId", userId);
        return "groupe-detail";
    }
}