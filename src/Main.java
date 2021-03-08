import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Objetos del sistema

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Variables enemigos
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Demon"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        //Variables Jugador
        int health = 100;
        int attackDamage = 50;
        int numHealthPots = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50; //Porcentaje de q caiga

        boolean running = true;
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Welcome to the dungeon!");

        Game:
        while (running) {
            System.out.println("------------------------------------------------------------------");
            int enemyHealth = rand.nextInt(health);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");
            while (enemyHealth > 0) {

                System.out.println("\tYour Hp: +" + health);
                System.out.println("\t" + enemy + "'s HP:" + enemyHealth);
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink health potion");
                System.out.println("\t3.Run for your life!");

                // Las opciones del jugador
                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    enemyHealth -= damageDealt;
                    health -= damageTaken;
                    System.out.println("\t> Your strike the " + enemy + " for: " + damageDealt + " Damage.");
                    System.out.println("\t Your recieve " + damageTaken + " for " + "in retalation!");
                    if (health < 1) {
                        System.out.println("\t You have taken too much damage, your to week to go on!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPots > 0) {
                        health += healthPotionHealAmount;
                        numHealthPots--;
                        System.out.println("\t You drink a health potion, healing yourself for: " + healthPotionHealAmount + "."
                                + "\n\t> You now have " + health + "HP."
                                + "\n\t> You have " + numHealthPots + "Health potions left\n");


                    } else {
                        System.out.println("\t You have no potion left!, defeat enemies for a chance to get one");
                    }

                } else if (input.equals("3")) {
                    System.out.println("\t You run away for the " + enemy + "!.");
                    continue Game;

                } else {
                    System.out.println("\t Invalid Command");

                }
                if (health < 1) {
                    System.out.println("You limp out of the dungeon, weak from the battle");
                    break;
                }
                System.out.println("---------------------------------------------------------------------");
                System.out.println("#" + enemy + "Was deafeted! #");
                System.out.println("# you have:" + health + "life left");
                if (rand.nextInt(100) < healthPotionDropChance) {
                    numHealthPots++;
                    System.out.println("#The " + enemy + "dropped a health potion");
                    System.out.println("# You have " + numHealthPots + " health potion(s)");

                }
                System.out.println("---------------------------------------------------------------------");
                System.out.println("What would you like to do now adalid?");
                System.out.println("1.Continue fighting");
                System.out.println("2. Exit dungeon");

                input = in.nextLine();

                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid Command!");
                    input = in.nextLine();

                }
                if (input.equals("1")) {
                    System.out.println("You continue on your adventure");
                } else if (input.equals("2")) {
                    System.out.println("You exit the dungeon, succesful for your adventure");
                    break;
                }

                System.out.println("#########################");
                System.out.println("#THANKS FOR PLAYING #");
                System.out.println("########################");

            }


        }
    }
}
