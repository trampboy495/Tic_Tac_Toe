import java.util.Scanner;
import java.util.Random;

public class PlayTicTacToe {
	private static Player currentPlayer;
	private static Scanner sc = new Scanner(System.in);
	private static int isComputer = 1;
	private static Board board;
	private static GameState currentState;

	PlayTicTacToe() {
		board = new Board();
		init();
		playMove(currentPlayer);
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
		currentState = GameState.Playing;
		board.paint();

	}

	public void playMove(Player player) {
		boolean validInput = false;
		do {
			System.out.print("player enter your move (rows:[1-3] cols:[1-3]) : ");
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
					&& board.cells[row][col].content == Player.Empty) {
				board.cells[row][col].content = player;
				board.currentRow = row;
				board.currentCol = col;
				validInput = true;
			} else {
				System.out.println("Invalid move at (" + row + "," + col + ") try again");
			}
		} while (!validInput);
	}

	public static void main(String[] args) {
		System.out.println("welcome to Tic Tac Toe game");
		new PlayTicTacToe();
	}
}
