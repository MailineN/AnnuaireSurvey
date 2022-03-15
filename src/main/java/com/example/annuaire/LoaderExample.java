package com.example.annuaire;

import com.example.annuaire.beans.Unit;
import com.example.annuaire.repository.CompteRepository;
import com.example.annuaire.repository.UnitRepository;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@Configuration
public class LoaderExample {
    private static final Logger log = LoggerFactory.getLogger(LoaderExample.class);

    @Bean
    CommandLineRunner initDatabase(CompteRepository compteRepository, UnitRepository unitRepository) {
        return args -> {
            log.info("PRELOADING : DONE" );
        };
    }
}

