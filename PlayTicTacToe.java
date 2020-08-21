import java.util.Scanner;
import java.util.Random;

public class PlayTicTacToe {
	private static Player currentPlayer;
	private static Scanner sc = new Scanner(System.in);
	private static int isComputer = 1;

	PlayTicTacToe() {
		init();
	}

	public void init() {
		System.out.println("simulating coin toss to decide who plays first");
		Random rand = new Random();
		int random = rand.nextInt(2);
	}

	public static void main(String[] args) {
		System.out.println("welcome to Tic Tac Toe game");
		new PlayTicTacToe();
	}
}
