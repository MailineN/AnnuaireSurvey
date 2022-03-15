package com.example.annuaire.services;

import com.example.annuaire.beans.Unit;
import com.example.annuaire.repository.CompteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    static final Logger LOGGER = LoggerFactory.getLogger(CompteService.class);

    @Autowired
    CompteRepository compteRepository;

    public void generateAccount(List<Unit> units){}
}
