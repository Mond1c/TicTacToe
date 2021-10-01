package com.company;
import java.util.Scanner;

public interface Player {
    public void move(Character[][] board, Scanner scanner);
    public Character getCharacter();
    public String getName();
}