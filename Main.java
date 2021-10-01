package com.company;


public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game(new Man('X', "Mike"), new Computer('O', 'X', "Steve"));
        game.start();
    }
}
