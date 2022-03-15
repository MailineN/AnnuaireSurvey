package com.example.annuaire.controller;

import com.example.annuaire.beans.Compte;
import com.example.annuaire.beans.Unit;
import com.example.annuaire.exceptions.DuplicateException;
import com.example.annuaire.repository.CompteRepository;
import com.example.annuaire.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class CompteController {
    @Autowired
    CompteService compteService;

    private final CompteRepository compteRepository;

    static final Logger LOGGER = LoggerFactory.getLogger(CompteController.class);

    public CompteController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("/comptes")
    ResponseEntity<List<Compte>> all(){

        return ResponseEntity.ok(compteRepository.findAll());
    }

    @PostMapping("/comptes")
    ResponseEntity createAccount(@RequestBody List<Unit> units){
        try {
            List<Compte> listAccount = compteService.generateAccount(units);
            compteRepository.saveAll(listAccount);
            LOGGER.info("Accounts created");
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (DuplicateException e){
            LOGGER.error("Error in request: duplicate unit");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
