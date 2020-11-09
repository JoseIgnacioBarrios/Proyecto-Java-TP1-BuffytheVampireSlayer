package View;
import Logic.Game;
import Utils.MyStringUtils;

public class Gameprinter {
	Game game;
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public Gameprinter (Game game, int cols, int rows) {
		this.game = game;
		this.numCols = cols;
		this.numRows = rows;
		this.board=new String[numRows][numCols];
	}
	
	private void encodeGame(Game game) {
		board = new String[this.numRows][this.numCols];
		for(int i = 0; i < this.numRows; i++) {
			for(int j = 0; j < this.numCols; j++) {
				board[i][j] =  space;
				board[i][j] = this.game.getBuscarAvatar(j, i).toString();
				}
		}
	}
	
	 public String toString() {		
		encodeGame(game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;

		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);

		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;

		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
		        str.append(margin).append(vDelimiter);
		        for (int j=0; j<numCols; j++)
		            str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
		        if (i != numRows - 1) str.append(lineDelimiter);
		        else str.append(lineEdge);   
		}

		return str.toString();
	    }
}
