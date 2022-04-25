package com.example.buildyourownadventure;

import java.io.Serializable;

public class Character implements Serializable {




    String name;
    String characterClass;
    String background;
    String race;
    String alignment;
    String[] skills;
    String[][][] toolProficiencies;
    String[][][] attacksSpells;
    String[][] typeProficiency;
    String[][][] equipmentWeight;
    String personalityTraits;
    String ideals;
    String bonds;
    String flaws;
    String bio;



    int experiencePoints;
    int inspiration;
    int proficiencyBonus;
    int passiveWisdom;
    int armorClass;
    int initiative;
    int speed;
    int currentHitPoints;
    int tempHitPoints;
    int hitDice;
    int bardicInspiration;
    int otherResource;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int copper;
    int silver;
    int electrum;
    int gold;
    int platinum;

    /*SavingThrows And Skills*/
    int AttributeStrength;
    int AttributeDexterity;
    int AttributeConstitution;
    int AttributeIntelligence;
    int AttributeWisdom;
    int AttributeCharisma;

    int AttributeAcrobatics;
    int AttributeAnimalHandling;
    int AttributeArcana;
    int AttributeAthletics;
    int AttributeDeception;
    int AttributeHistory;
    int AttributeInsight;
    int AttributeIntimidation;
    int AttributeInvestigation;
    int AttributeMedicine;
    int AttributeNature;
    int AttributePerception;
    int AttributePerformance;
    int AttributePersuasion;
    int AttributeReligion;
    int AttributeSleightOfHand;
    int AttributeStealth;
    int AttributeSurvival;


    int failures;   /*Death*/
    int successes;  /*Saves*/









    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }



    public Character(String name, String characterClass, String race) {
        this.name = name;
        this.characterClass = characterClass;
        this.race = race;
    }
    public Character() {

    }


}
