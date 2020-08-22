public class Board {
	public static final int ROWS = 3, COLS = 3;
	int currentRow, currentCol;
	Cell[][] cells;

	public Board() {
		cells = new Cell[ROWS][COLS];
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}

	public boolean isDraw() {
		for (Cell[] cell : cells) {
			for (Cell value : cell) {
				if(value.content == Player.Empty)
					return false;
			}
		}
		return true;
	}

	public boolean hasWon(Player player) {
		if(currentRow == 1 && currentCol == 1) {
			return(cells[0][0].content == player && cells[2][2].content == player ||
				cells[0][2].content == player && cells[2][0].content == player);
		} else {
			return(cells[0][currentCol].content == player && cells[1][currentCol].content == player
				&& cells[2][currentCol].content == player || cells[currentRow][0].content == player
				&& cells[currentRow][1].content == player && cells[currentRow][2].content == player );
		}
	}

	public void paint() {
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col].paint();
				if(col < COLS - 1)
					System.out.print("|");
			}
			System.out.println();
			if(row < ROWS - 1)
				System.out.println("--------------");
		}
	}

}
