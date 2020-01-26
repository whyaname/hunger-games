package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Logic {
    ArrayList<Contestants> listOfContestants = new ArrayList<>(24);
    Random randomize = new Random();

    public void start() {
        for (int i = 0; i < 24; i++) {
            Contestants contestant = new Contestants(randomize.nextBoolean(), randomize.nextInt(100),
                    randomize.nextInt(100), randomize.nextInt(1000), randomize.nextInt(100),
                    randomize.nextBoolean(), randomize.nextInt(Integer.MAX_VALUE)); //generate a contestant
            if (contestant.typeContestant) {
                contestant.attack += contestant.attack + (randomize.nextInt(50)/10); //training for careers
                contestant.attack += contestant.attack + (randomize.nextInt(50)/10); //item bonus
            } else {
                contestant.defense += contestant.defense + (randomize.nextInt(50)/10); //training for districters
            }
            listOfContestants.add(contestant);
        }
        games(listOfContestants);
    }

    public void games(ArrayList<Contestants> listOfContestants) {
        do {
            Contestants contestant1 = this.listOfContestants.get(randomize.nextInt(listOfContestants.size()));
            Contestants contestant2 = this.listOfContestants.get(randomize.nextInt(listOfContestants.size()));
            while (contestant1 == contestant2) {
                contestant2 = this.listOfContestants.get(randomize.nextInt(listOfContestants.size()));
            }
            System.out.println("The two contestants selected for battle are: " + contestant1.id + " and " +
                    contestant2.id);

            while (contestant1.health > 0 && contestant2.health > 0) {
                System.out.println("The health of contestant " + contestant1.id + " is " + contestant1.health);
                System.out.println("The health of contestant " + contestant2.id + " is " + contestant2.health);
                if (randomize.nextInt(2) == 1) {
                    contestant1.health = contestant1.health - Math.abs((contestant2.attack - contestant1.defense) *
                            randomize.nextInt(contestant2.chanceHit));
                    System.out.println("The health of contestant " + contestant1.id + " is " + contestant1.health + " after"
                            + " taking damage");
                    if (contestant1.health < 0) {
                        System.out.println("Contestant " + contestant1.id + " HAS BEEN ELIMINATED. BETTER LUCK IN THE NEXT"
                                + " LIFE");
                        listOfContestants.remove(contestant1);
                        break;
                    }
                    contestant2.health = contestant2.health - Math.abs((contestant1.attack - contestant2.defense) *
                            randomize.nextInt(contestant1.chanceHit));
                    System.out.println("The health of contestant " + contestant2.id + " is " + contestant2.health + " after"
                            + " taking damage");
                    if (contestant2.health < 0) {
                        System.out.println("Contestant " + contestant2.id + " HAS BEEN ELIMINATED. BETTER LUCK IN THE NEXT" +
                                " LIFE");
                        listOfContestants.remove(contestant2);
                        break;
                    }
                } else {
                    contestant2.health = contestant2.health - Math.abs((contestant1.attack - contestant2.defense) *
                            randomize.nextInt(contestant1.chanceHit));
                    System.out.println("The health of contestant " + contestant2.id + " is " + contestant2.health + " after " +
                            "taking damage");
                    if (contestant2.health < 0) {
                        listOfContestants.remove(contestant2);
                        break;
                    }
                    contestant1.health = contestant1.health - Math.abs((contestant2.attack - contestant1.defense) *
                            randomize.nextInt(contestant2.chanceHit));
                    System.out.println("The health of contestant " + contestant1.id + " is " + contestant1.health + " after " +
                            "taking damage");
                    if (contestant1.health < 0) {
                        listOfContestants.remove(contestant1);
                        break;
                    }
                }
            }
        } while (listOfContestants.size() > 1);
        System.out.println("The winning contestant is " + listOfContestants.get(0).id + ". CONGRATULATIONS, PRESIDENT" +
                " SNOW WISHES YOU A GOOD AFTERLIFE");
        listOfContestants.remove(0);
    }
}