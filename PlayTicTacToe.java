import java.util.Scanner;
import java.util.Random;

public class PlayTicTacToe {
	private static Player currentPlayer;
	private static Scanner sc = new Scanner(System.in);
	private static int isComputer = 1;
	private static Board board;

	PlayTicTacToe() {
		board = new Board();
		init();
		board.paint();

	}

	public void init() {
		System.out.print("simulating coin toss to decide who plays first \n\n");
		Random rand = new Random();
		int random = rand.nextInt(2);
		if(random == isComputer) {
                        currentPlayer = Player.Cross;
                }
                else {
                        System.out.println("you won choose your symbol X or O");
                        String choice = sc.nextLine();
                        if(choice.equals("X")) {
                                currentPlayer = Player.Cross;
                        }
                        else {
                                currentPlayer = Player.Nought;
                        }
                }

	}

	public static void main(String[] args) {
		System.out.println("welcome to Tic Tac Toe game");
		new PlayTicTacToe();
	}
}
