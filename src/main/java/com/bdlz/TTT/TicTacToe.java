package com.bdlz.TTT;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);
    public static char[] board = new char[10];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe Game");
        createBoard();
        chooseChoice();
        showBoard();
    }

    public static void createBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
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
        System.out.println("Choose x or 0");
        char a = sc.next().charAt(0);
        if (a == '0') {
            System.out.println("Player choice is " + a);
            System.out.println("Computer choice is x");
        } else if (a == 'x') {
            System.out.println("Player choice is " + a);
            System.out.println("Computer choice is 0");
        } else {
            System.out.println("Entered wrong input");
        }

    }

}
