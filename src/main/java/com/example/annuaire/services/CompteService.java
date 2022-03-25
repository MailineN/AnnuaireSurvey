package com.example.annuaire.services;

import com.example.annuaire.beans.Compte;
import com.example.annuaire.beans.Unit;
import com.example.annuaire.exceptions.DuplicateException;
import com.example.annuaire.repository.CompteRepository;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CompteService {
    static final Logger LOGGER = LoggerFactory.getLogger(CompteService.class);

    @Autowired
    CompteRepository compteRepository;

    public List<Compte> generateAccount(List<Unit> units, Long idSurvey) throws DuplicateException{
        List<Unit> distinctList = new ArrayList(new HashSet(units));
        LOGGER.info("Id survey in generate account ",idSurvey);
        if (distinctList.size() < units.size()) {
            throw new DuplicateException("Unit");
        } else {
            List<Compte> listAccount = new ArrayList<Compte>();
            for (Unit unit:units){
                Compte account = createAccount(unit);
                account.setId_survey(idSurvey);
                listAccount.add(account);
                LOGGER.info("Create account:  ", account.toString());
            }
            return listAccount;
        }
    }

    Compte createAccount(Unit unit){
        String email = unit.getEmail();
        Long id_survey = unit.getIdSurvey();
        if (email.length() < 2){
            email = generatePassword();
        }
        String password = generatePassword();
        Compte compte = new Compte(email = email, password=password, id_survey);
        LOGGER.info("Account created for " + compte.toString()+ " with id survey "+ compte.getId_survey());
        return compte;
    }

    public String generatePassword() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(1);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return "Error";
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(15, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }
}
