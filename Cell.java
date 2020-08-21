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
			System.out.println(" X ");
		case Nought:
			System.out.println(" O ");
			break;
		default:
			System.out.println("   ");
			break;
		}
	}
}
