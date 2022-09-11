package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        int[][] whereWinsGuide = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        printBoard(board);

        int timer = 1;
        do {
            switch (timer) {
                case 1, 3 -> {
                    printX(board);
                    printBoard(board);
                    timer++;
                }
                case 2, 4 -> {
                    printO(board);
                    printBoard(board);
                    timer++;
                }
                case 5, 7 -> {
                    printX(board);
                    printBoard(board);
                    if (xWon(board, whereWinsGuide)) {
                        timer = 10;
                    } else {
                        timer++;
                    }
                }
                case 6, 8 -> {
                    printO(board);
                    printBoard(board);
                    if (oWon(board, whereWinsGuide)) {
                        timer = 10;
                    } else {
                        timer++;
                    }
                }
                case 9 -> {
                    printX(board);
                    printBoard(board);
                    if (xWon(board, whereWinsGuide)) {
                        timer = 10;
                    } else {
                        timer++;
                        System.out.println("Draw");
                    }
                }
            }
        } while (timer <= 9);

    }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for (char[] chars : board) {
            System.out.print("|" + " ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void printX(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int coordinate1;
        int coordinate2;
        String[] coordinatesArray;
        String pattern = "([-+])?\\d+";
        boolean loop = true;
        do {
            String coordinatesString = scanner.nextLine();
            coordinatesArray = coordinatesString.split(" ");

            if (!coordinatesArray[0].matches(pattern) && !coordinatesArray[1].matches(pattern)) {
                System.out.println("You should enter numbers!");
            } else {
                coordinate1 = Integer.parseInt(coordinatesArray[0]);
                coordinate2 = Integer.parseInt(coordinatesArray[1]);
                if (coordinate1 > 3 || coordinate1 < 1 || coordinate2 > 3 || coordinate2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[coordinate1 - 1][coordinate2 - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[coordinate1 - 1][coordinate2 - 1] = 'X';
                    loop = false;
                }
            }
        } while (loop);
    }

    public static void printO(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int coordinate1;
        int coordinate2;
        String[] coordinatesArray;
        String pattern = "([-+])?\\d+";
        boolean loop = true;
        do {
            String coordinatesString = scanner.nextLine();
            coordinatesArray = coordinatesString.split(" ");

            if (!coordinatesArray[0].matches(pattern) && !coordinatesArray[1].matches(pattern)) {
                System.out.println("You should enter numbers!");
            } else {
                coordinate1 = Integer.parseInt(coordinatesArray[0]);
                coordinate2 = Integer.parseInt(coordinatesArray[1]);
                if (coordinate1 > 3 || coordinate1 < 1 || coordinate2 > 3 || coordinate2 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[coordinate1 - 1][coordinate2 - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[coordinate1 - 1][coordinate2 - 1] = 'O';
                    loop = false;
                }
            }
        } while (loop);
    }

    public static boolean xWon(char[][] board, int[][] whereWinsGuide){
        StringBuilder value = new StringBuilder();
        boolean xWins = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value.append(board[i][j]);
            }
        }
        // x wins?
        for (int i = 0; i < 8; i++) {
            int counterX = 0;
            for (int j = 0; j < 3; j++) {
                if (value.charAt(whereWinsGuide[i][j]) == 'X') {
                    counterX++;
                }
            }
            if (counterX == 3) {
                xWins = true;
                System.out.println("X wins");
                break;
            }
        }
        return xWins;
    }

    public static boolean oWon(char[][] board, int[][] whereWinsGuide) {
        StringBuilder value = new StringBuilder();
        boolean oWins = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                value.append(board[i][j]);
            }
        }
        // o wins?
        for (int i = 0; i < 8; i++) {
            int counterO = 0;
            for (int j = 0; j < 3; j++) {
                if (value.charAt(whereWinsGuide[i][j]) == 'O') {
                    counterO++;
                }
            }
            if (counterO == 3) {
                oWins = true;
                System.out.println("O wins");
                break;
            }
        }
        return oWins;
    }

}