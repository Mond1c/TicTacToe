package com.company;
import java.util.Scanner;

public class Man implements Player {
	private Character character;
	private String name;
	
	public Man(Character character, String name) {
		this.character = character;
		this.name = name;
	}
	
	@Override
	public void move(Character[][] board, Scanner scanner) {
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		
		while (!isValidPosition(board, row, column)) {
			System.out.println("Invalid position, try again!");
			row = scanner.nextInt();
			column = scanner.nextInt();
		}
		
		board[row][column] = character;
	}
	
	@Override
	public Character getCharacter() {
		return character;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	private boolean isValidPosition(Character[][] board, int row, int column) {
		return board[row][column] == null;
	}
}