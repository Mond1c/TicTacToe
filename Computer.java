package com.company;
import java.util.Scanner;
import java.util.Random;

class Computer implements Player {
    private Character character;
    private Character playerCharacter;
    private String name;
    
    public Computer(Character character, Character playerCharacter, String name) {
        this.character = character;
        this.name = name;
        this.playerCharacter = playerCharacter;
    }
    
    @Override
    public void move(Character[][] board, Scanner scanner) {
        int[] computerMove = getWinMove(board, character);
        if (computerMove != null) {
            board[computerMove[0]][computerMove[1]] = character;
            return;
        }
        computerMove = getWinMove(board, playerCharacter);
        if (computerMove != null) {
            board[computerMove[0]][computerMove[1]] = character;
            return;
        }
        
        computerMove = getMove(board);
        board[computerMove[0]][computerMove[1]] = character;
    }
    
    @Override
    public Character getCharacter() {
        return character;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    private static int[] getWinMove(Character[][] board, Character candidate) {
        int[] empty = new int[2];
        int counter = 0;
        for (int i = 0; i < board.length; ++i) {
            if (board[i][0] == candidate) ++counter;
            else if (board[i][0] != null) counter = -1;
            else {
                empty[0] = i;
                empty[1] = 0;
            }
        }
        if (counter == board.length - 1) return empty;
        counter = 0;
        
        for (int i = 0; i < board.length; ++i) {
            if (board[i][1] == candidate) ++counter;
            else if (board[i][1] != null) counter = -1;
            else {
                empty[0] = i;
                empty[1] = 1;
            }
        }
        
        if (counter == board.length - 1) return empty;
        counter = 0;
        
        for (int i = 0; i < board.length; ++i) {
            if (board[i][2] == candidate) ++counter;
            else if (board[i][2] != null) counter = -1;
            else {
                empty[0] = i;
                empty[1] = 2;
            }
        }
        
        if (counter == board.length - 1) return empty;
        counter = 0;
        
        for (int i = 0; i < board.length; ++i) {
            if (board[0][i] == candidate) ++counter;
            else if (board[0][i] != null) counter = -1;
            else {
                empty[0] = 0;
                empty[1] = i;
            }
        }
        
        if (counter == board.length - 1) return empty;
        counter = 0;
        
        for (int i = 0; i < board.length; ++i) {
            if (board[1][i] == candidate) ++counter;
            else if (board[1][i] != null) counter = -1;
            else {
                empty[0] = 1;
                empty[1] = i;
            }
        }
        
        if (counter == board.length - 1) return empty;
        counter = 0;
        
        for (int i = 0; i < board.length; ++i) {
            if (board[2][i] == candidate) ++counter;
            else if (board[2][i] != null) counter = -1;
            else {
                empty[0] = 2;
                empty[1] = i;
            }
        }
        
        if (counter == board.length - 1) return empty;
        counter = 0;
        
        for (int i = 0; i < board.length; ++i) {
            if (board[i][i] == candidate) ++counter;
            else if (board[i][i] != null) counter = -1;
            else {
                empty[0] = i;
                empty[1] = i;
            }
        }
        
        if (counter == board.length - 1) return empty;
        for (int i = board.length - 1, j = 0; i >= 0; --i, ++j) {
            if (board[i][j] == candidate) ++counter;
            else if (board[i][j] != null) counter = -1;
            else {
                empty[0] = i;
                empty[1] = j;
            }
        }
        if (counter == board.length - 1) return empty;
        return null;
    }
    
    private int[] getMove(Character[][] board) {
        Random random = new Random();
        return new int[] {random.nextInt(board.length), random.nextInt(board.length)};
    }
}