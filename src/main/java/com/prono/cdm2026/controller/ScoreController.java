package com.prono.cdm2026.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prono.cdm2026.model.Pronostic;
import com.prono.cdm2026.model.User;
import com.prono.cdm2026.service.ClassementReelService;
import com.prono.cdm2026.service.PronosticService;
import com.prono.cdm2026.service.ScoreService;
import com.prono.cdm2026.service.UserService;


import com.prono.cdm2026.model.ClassementReel;


@Controller
public class ScoreController {

    @Autowired
    private UserService userService;
    @Autowired
    private PronosticService pronosticService;

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ClassementReelService classementReelService;

    
  @GetMapping("/scores")
public String getScores(Model model) {
    List<User> users = userService.findAll();
    Map<User, Integer> scores = new HashMap<>();

    for (User u : users) {
        int total = 0;
        List<Pronostic> pronos = pronosticService.findByUser(u);
        for (Pronostic prono : pronos) {
            ClassementReel classement = classementReelService.findByGroupe(prono.getGroupe());
            if (classement != null) {
                total += scoreService.calcul(prono, classement);
            }
        }
        scores.put(u, total);
    }

    model.addAttribute("scores", scores);
    return "scores";
}
}