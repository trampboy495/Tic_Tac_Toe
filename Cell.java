public class Cell {
	public Player content;
	int row, col;

	Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();
	}

	public void clear() {
		content = Player.Empty;
	}

	public void paint() {
		switch(content) {
		case Cross:
			System.out.print(" X ");
			break;
		case Nought:
			System.out.print(" O ");
			break;
		case Empty:
			System.out.print("   ");
			break;
		}
	}
}
