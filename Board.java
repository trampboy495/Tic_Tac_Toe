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
}
