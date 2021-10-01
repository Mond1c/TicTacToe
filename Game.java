package com.company;
import java.util.Scanner;
import java.util.Random;

public class Game {
	private Player player1;
	private Player player2;
	private Character[][] board;
	private Scanner scanner;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.board = new Character[3][3];
		try {
			this.scanner = new Scanner(System.in);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (scanner != null) scanner.close();
	}
	
	private Character getWinner() {
		if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) return board[0][0];
		if (board[1][0] == board[1][1] && board[1][1] == board[1][2]) return board[1][0];
		if (board[2][0] == board[2][1] && board[2][1] == board[2][2]) return board[2][0];
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) return board[0][0];
		if (board[0][1] == board[1][1] && board[1][1] == board[2][1]) return board[0][1];
		if (board[0][2] == board[1][2] && board[1][2] == board[2][2]) return board[0][2];
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];
		return null;
	}
	
	private boolean isDraw() {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				if (board[i][j] == null) return false;
			}
		}
		return true;
	}
	
	public void start() {
		Random random = new Random();
		boolean player1Move = random.nextInt(2) == 1;
		printBoard();
		while (true) {
			Character winner = getWinner();
			if (winner != null) {
				gameOver(winner);
				break;
			}
			if (isDraw()) {
				draw();
				break;
			}
			if (player1Move) {
				System.out.println(player1.getName() + " move");
				player1.move(board, scanner);
			} else {
				System.out.println(player2.getName() + " move");
				player2.move(board, scanner);
			}
			player1Move = !player1Move;
			printBoard();
		}
	}
	
	private void gameOver(Character character) {
		printBoard();
		if (player1.getCharacter().equals(character)) {
			System.out.println(player1.getName() + " win");
		} else {
			System.out.println(player2.getName() + " win");
		}
	}
	
	private void draw() {
		printBoard();
		System.out.println("Draw");
	}
	
	private void printBoard() {
		System.out.println("-------");
		for (int i = 0; i < board.length; ++i) {
			System.out.print("|");
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] == null) System.out.print("0|");
				else System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
		System.out.println("-------");
		System.out.println();
	}
}