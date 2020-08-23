//not used anymore
public class SudokuBoard {
	
	public SudokuBoard() {
	}
	
	//formats the board into a normal sudoku puzzle 
	public static String format(int[][] board) {
		String stringBoard = " ____________________\n";
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if ((col)%3 == 0) {
					stringBoard += "|";
				}
				stringBoard = stringBoard + board[row][col] + " ";
			}
			stringBoard += "|\n";
			if ((row+1)%3 == 0) {
				stringBoard += "|------|------|------|\n";
			}
		}
		return stringBoard;
	}
	
	
}
