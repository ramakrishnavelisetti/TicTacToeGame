package com.bdlz.TTT;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();
    public static char[] board = new char[10];
    public static char userChoice, computerChoice;
    public static int indexNumber, computerIndex;
    public static int turn = 1, flag = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe Game");
        createBoard();
        chooseChoice();
        tossCoin();
        currentBoard();
        selectIndex();
        freeSpaceMove();
        outerloop: while (flag == 0) {
            if ((turn + 1) % 2 == 0) {
                currentBoard();
                selectIndex();
                freeSpaceMove();
                currentBoard();
                flag = checkWin();
                if (flag == 1) {
                    System.out.println("Excellent! You are the winner");
                    break outerloop;
                }

                flag = checkTie();
                if (flag == 1) {
                    System.out.println("Nice Play! It's Tie");
                    ;
                    break outerloop;
                }
                turn++;
            }
        }
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
         indexNumber = sc.nextInt();
        for (int i = 0; i < board.length; i++) {
            if ((i) == indexNumber) {
                board[i] = userChoice;
            }
        }
        currentBoard();
    }
    private static void freeSpaceMove() {
        if (board[indexNumber] == 'x' || board[indexNumber] == 'o') {
            currentBoard();
            System.out.println("Number which is selected is not free");
            selectIndex();
            freeSpaceMove();
        } else {
            board[indexNumber] = userChoice;
            System.out.println(userChoice + " user is marked " + indexNumber);
        }
    }
    private static void tossCoin() {
        System.out.println("Toss a to check who plays first Choose 1 for Head or 2 for Tail");
        int option = sc.nextInt();
        if (option == 1 || option == 2) {
            int toss = random.nextInt(2)+ 1;
            if (toss == 1) {
                System.out.println("By tossing Coin it shows HEAD");
            } else {
                System.out.println("By tossing Coin it shows TAIL");
            }
            if (toss == option) {
                System.out.println("User will start the game");
            } else {
                System.out.println("Computer will start the game");
                computerFirstTurn();
            }
        } else {
            System.out.println("Invalid input Again");
            tossCoin();
        }
    }
    public static void computerFirstTurn() {
        computerIndex = random.nextInt(9) + 1;
        board[computerIndex] = computerChoice;
        System.out.println("Computer choses '" + computerIndex + "' now user turn");
    }
    public static int checkWin() {
        for (int i = 1; i < 9; i++) {
            int win[] = winArray(i);
            if (board[win[0]] == board[win[1]] && board[win[1]] == board[win[2]]) {
                flag = 1;
            }
        }
        return flag;
    }

    private static int[] winArray(int number) {
        if (number == 1) {
            int arrayWin[] = { 1, 2, 3 };
            return arrayWin;
        } else if (number == 2) {
            int arrayWin[] = { 4, 5, 6 };
            return arrayWin;
        } else if (number == 3) {
            int arrayWin[] = { 7, 8, 9 };
            return arrayWin;
        } else if (number == 4) {
            int arrayWin[] = { 1, 4, 7 };
            return arrayWin;
        } else if (number == 5) {
            int arrayWin[] = { 2, 5, 8 };
            return arrayWin;
        } else if (number == 6) {
            int arrayWin[] = { 3, 6, 9 };
            return arrayWin;
        } else if (number == 7) {
            int arrayWin[] = { 1, 5, 9 };
            return arrayWin;
        } else {
            int arrayWin[] = { 3, 5, 7 };
            return arrayWin;
        }
    }

    public static int checkTie() {
        for (int i = 1; i < 10; i++) {
            if (board[i] == 'x' || board[i] == 'o') {
                if (i == 9) {
                    flag = 1;
                }
            }
        }
        return flag;
    }
}
