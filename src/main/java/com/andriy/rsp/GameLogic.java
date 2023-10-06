package com.andriy.rsp;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    private final Field field = new Field();
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        Figure f1 = getHumanInput();
        Figure f2 = getPCInput();

        field.setF1(f1);
        field.setF2(f2);
        String winner = checkWinner();

        System.out.println("Winner is: " + winner);
    }

    private Figure getHumanInput() {
        System.out.println("Enter input: (1)ROCK, (2)SCISSORS, (3)PAPER");
        // 1 - ROCK, 2 - SCISSORS, 3 - PAPER
        int input = scanner.nextInt();

        while (!validateUserInput(input)) {
            System.out.println("Enter input: (1)ROCK, (2)SCISSORS, (3)PAPER");
            // 1 - ROCK, 2 - SCISSORS, 3 - PAPER,
            input = scanner.nextInt();
        }

        return switch (input) {
            case 1 -> Figure.ROCK;
            case 2 -> Figure.SCISSORS;
            case 3 -> Figure.PAPER;
            default -> null;
        };
    }

    private Figure getPCInput() {
        int input = random.nextInt(2) + 1;
        return switch (input) {
            case 1 -> Figure.ROCK;
            case 2 -> Figure.SCISSORS;
            case 3 -> Figure.PAPER;
            default -> null;
        };
    }

    private String checkWinner() {
        if (field.getF1() == Figure.ROCK && field.getF2() == Figure.SCISSORS) {
            System.out.println("Winner is HUMAN");
        } else if (field.getF1() == Figure.PAPER && field.getF2() == Figure.ROCK) {
            System.out.println("Winner is HUMAN");
        } else if (field.getF1() == Figure.SCISSORS && field.getF2() == Figure.PAPER) {
            System.out.println("Winner is HUMAN");
        }
        if (field.getF2() == Figure.ROCK && field.getF1() == Figure.SCISSORS) {
            System.out.println("Winner is PC");
        } else if (field.getF2() == Figure.PAPER && field.getF1() == Figure.ROCK) {
            System.out.println("Winner is PC");
        } else if (field.getF2() == Figure.SCISSORS && field.getF1() == Figure.PAPER) {
            System.out.println("Winner is PC");
        }
        if (field.getF1() == Figure.ROCK && field.getF2() == Figure.ROCK) {
            System.out.println("Its a Tie");
        } else if (field.getF1() == Figure.PAPER && field.getF2() == Figure.PAPER) {
            System.out.println("Its a Tie");
        } else if (field.getF1() == Figure.SCISSORS && field.getF2() == Figure.SCISSORS) {
            System.out.println("Its a Tie");
        }
       return null;
    }

        private boolean validateUserInput ( int input){

            return input >= 1 && input <= 3;
        }
    }









