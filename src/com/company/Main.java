package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.println("Welcome to Roulette!\n");
        String bet = "";

        int won = 0;

        int lost = 0;

        double madeMoney = 0;

        while (!bet.equals("false")) {

            gamble roulette = new gamble();

            while (roulette.getBetType() == -1) {

                System.out.println("Enter the type of bet you would like to place: (red|black|even|odd|high|low)");

                roulette.setType(read.nextLine());
            }

            System.out.println("Enter in your bet amount:");
            double amount = 0;
            while (amount <= 0) {

                amount = read.nextDouble();
            }

            read.nextLine();

            double result = roulette.gambling(amount) - amount;

            if (result > 0) {

                System.out.println("You won the bet!\n");

                won++;

            } else {

                System.out.println("Sorry, you've lost the bet.\n");

                lost++;
            }

            madeMoney += result;

            System.out.println("You currently have: $" + String.format("%.2f", madeMoney) +

                    "\n\nWould you like to play again? (true|false)?");

            bet = read.nextLine();

        }

        System.out.println("Thank you for playing!\nThis is how much you have remaining: $" + String.format("%.2f", madeMoney)

                + "\nYou've won " + won + " games(s) and lost " + lost + " game(s)");

    }

}