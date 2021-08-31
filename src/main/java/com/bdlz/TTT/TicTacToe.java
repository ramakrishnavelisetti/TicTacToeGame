package com.bdlz.TTT;

import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);
    public static void createBoard() {
        char[] board = new char[10];
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
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
    
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe Game");
        createBoard();
        chooseChoice();
        showBoard();
    }
}
