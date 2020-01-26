package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Contestants {
    protected boolean gender; //false = male and true = female
    protected int attack; //damage done per turn
    protected int defense; //damage reduced per turn
    protected int health; //overall health
    protected int chanceHit; //critical damage factor
    protected boolean typeContestant; // false = district and true = career
    protected int id; //unique id

    public Contestants(boolean gender, int attack, int defense, int health, int chanceHit, boolean type, int id) {
        this.gender = gender;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.chanceHit = chanceHit;
        this.typeContestant = type;
        this.id = id;
    }

    public static void printInfo(ArrayList<Contestants> contestants) { //was for debugging purposes
        for (Contestants contestant : contestants) {
            System.out.println("The health of contestant is " + contestant.health + "\n" +
                    "The attack of contestant is " + contestant.attack + "\n" +
                    "The defense of contestant is " + contestant.defense + "\n"+
                    "The chance to hit of contestant is " + contestant.chanceHit + "\n");
        }
    }
}
