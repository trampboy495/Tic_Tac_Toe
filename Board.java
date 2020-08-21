public class Board {
	public static final int ROWS = 3, COLS = 3;
	Cell[][] cells;

	public Board() {
		cells = new Cell[ROWS][COLS];
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				cells[row][col] = new Cell(row, col);
			}
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
