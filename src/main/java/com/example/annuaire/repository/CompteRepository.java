package com.example.annuaire.repository;

import com.example.annuaire.beans.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
