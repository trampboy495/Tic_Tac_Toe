import java.util.Scanner;
import java.util.Random;

public class PlayTicTacToe {
	private static Player currentPlayer;
	private static Player computer;
	private static Player human;
	private static Scanner sc = new Scanner(System.in);
	private static int isComputer = 1;
	private static int cornerRow = -1;
	private static int cornerCol = -1;
	private static int sideRow = -1;
	private static int sideCol = -1;
	private static Board board;
	private static GameState currentState;

	PlayTicTacToe() {
		board = new Board();
		init();
		do {
			playMove(currentPlayer);
			board.paint();
			updateGameStatus(currentPlayer);
			if (currentState == GameState.Player_Won) {
				System.out.println("Game has ended and Player is the winner ");
			} else if (currentState == GameState.Computer_Won) {
				System.out.println("Game has ended and Computer is the winner");
			} else if (currentState == GameState.Draw) {
				System.out.println("it's a draw");
			}
			currentPlayer = (currentPlayer == computer) ? (human) : (computer);
		} while (currentState == GameState.Playing);
	}

	public void init() {
		System.out.print("simulating coin toss to decide who plays first \n\n");
		Random rand = new Random();
		int random = rand.nextInt(2);
		if (random == isComputer) {
			System.out.println("computer won the toss");
			currentPlayer = Player.Cross;
			computer = Player.Cross;
			human = Player.Nought;
		} else {
			System.out.println("you won choose your symbol X or O");
			String choice = sc.nextLine();
			currentPlayer = (choice.equals("X")) ? (Player.Cross) : (Player.Nought);
			computer = (choice.equals("X")) ? (Player.Nought) : (Player.Cross);
			human = currentPlayer;
			board.paint();
		}
		currentState = GameState.Playing;
	}

	public void playMove(Player player) {
		if (player == computer) {
			computerMove(player);
		} else {
			boolean validInput = false;
			do {
				System.out.print("player enter your move (rows:[1-3] cols:[1-3]) : ");
				int row = sc.nextInt() - 1;
				int col = sc.nextInt() - 1;
				if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
						&& board.cells[row][col].content == Player.Empty) {
					board.cells[row][col].content = player;
					setCurrentRowAndCol(row, col);
					validInput = true;
				} else {
					System.out.println("Invalid move at (" + row + "," + col + ") try again");
				}
			} while (!validInput);
		}
	}

	public void setCurrentRowAndCol(int row, int col) {
		board.currentRow = row;
		board.currentCol = col;
	}

	public boolean getMove(Player player) {
		int size = board.cells.length * board.cells.length;
		int cornerCounter = 0;
		int sideCounter = 0;
		for (int i = 0; i < size; i++) {
			int row = i / board.cells.length;
			int col = i % board.cells.length;
			if (board.cells[row][col].content == Player.Empty) {
				board.cells[row][col].content = player;
				setCurrentRowAndCol(row, col);
				if (board.hasWon(player))
					return true;
				board.cells[row][col].content = Player.Empty;
				if (++row * ++col != 4 && ((row * col) - 1) % 2 == 0 && cornerCounter < 1) {
					cornerRow = row - 1;
					cornerCol = col - 1;
					cornerCounter++;
				}
				if (((row * col) - 1) % 2 != 0 && sideCounter < 1) {
					sideRow = row - 1;
					sideCol = col - 1;
					sideCounter++;
				}
			}
		}
		return false;
	}

	public void computerMove(Player player) {
		if (!getMove(player)) {
			if (getMove(human)) {
				board.cells[board.currentRow][board.currentCol].content = player;
			} else if (cornerRow != -1) {
				board.cells[cornerRow][cornerCol].content = player;
				setCurrentRowAndCol(cornerRow, cornerCol);
			} else if (board.cells[1][1].content == Player.Empty) {
				board.cells[1][1].content = player;
				setCurrentRowAndCol(1, 1);
			} else if (sideRow != -1) {
				board.cells[sideRow][sideCol].content = player;
				setCurrentRowAndCol(sideRow, sideCol);
			}
		}
		System.out.println("computer played its move");
	}

	public void updateGameStatus(Player player) {
		if (board.hasWon(player)) {
			currentState = (player == computer) ? (GameState.Computer_Won) : (GameState.Player_Won);
		} else if (board.isDraw()) {
			currentState = GameState.Draw;
		}
	}

	public static void main(String[] args) {
		System.out.println("welcome to Tic Tac Toe game");
		new PlayTicTacToe();
	}
}
