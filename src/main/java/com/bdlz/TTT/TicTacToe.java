package com.bdlz.TTT;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);
    public static char[] board = new char[10];
    public static char userChoice;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe Game");
        createBoard();
        chooseChoice();
        currentBoard();
        selectIndex();
    }

    public static void createBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }
    private static void currentBoard() {
        for (int i = 1; i < 10; i++) {
            if (board[i] != 'x' && board[i] != 'o') {
                board[i] = (char) (i + '0');
            }
        }
        showBoard();
    }
    public static void showBoard() {
            System.out.println();
            System.out.println("     |     |     ");
            System.out.println("   " + board[1] + " |   " + board[2] + " | " + board[3] + " ");
            System.out.println("_____|_____|_____");
            System.out.println("   " + board[4] + " |   " + board[5] + " | " + board[6] + " ");
            System.out.println("_____|_____|_____");
            System.out.println("   " + board[7] + " |   " + board[8] + " | " + board[9] + " ");
            System.out.println("     |     |     ");
    }
    static void chooseChoice() {
        System.out.println("Choose x or o");
        userChoice = sc.next().charAt(0);
        if (userChoice == 'o') {
            System.out.println("Player choice is " + userChoice);
            System.out.println("Computer choice is x");
        } else if (userChoice == 'x') {
            System.out.println("Player choice is " + userChoice);
            System.out.println("Computer choice is o");
        } else {
            System.out.println("Entered wrong input");
            chooseChoice();
        }
    }
    public static void selectIndex() {
        System.out.print("Select number between 1 and 9 :");
        int indexNumber = sc.nextInt();
        for (int i = 0; i < board.length; i++) {
            if ((i) == indexNumber) {
                board[i] = userChoice;
            }
        }
        currentBoard();
    }

}
