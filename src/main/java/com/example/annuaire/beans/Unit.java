package com.example.annuaire.beans;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Long id_survey; // L'idée est de générer un mdp par enquête, a faire plus tard
    public Unit() {

    }
    public Unit(String nom, String prenom, String email, String telephone,Long idSurvey){
        this.email =email;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.id_survey = id_survey;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getIdSurvey() {
        return id_survey;
    }

    public void setIdSurvey(Long id_survey) {
        this.id_survey = id_survey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return nom.equals(unit.nom) && prenom.equals(unit.prenom) && email.equals(unit.email) && telephone.equals(unit.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, email, telephone);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", id_survey=" + id_survey +
                '}';
    }
}
