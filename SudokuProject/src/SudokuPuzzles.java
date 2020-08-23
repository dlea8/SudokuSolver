public class SudokuPuzzles {
	private String puzzle;
	private int[][] board = new int[9][9];
	
	public SudokuPuzzles(String puzzle) {
		this.puzzle = puzzle;
	}
	
	public String getPuzzle() {
		return puzzle;
	}
	
	public int[][] puzzleArray() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(puzzle.substring(0,1));
				puzzle = puzzle.substring(1);
			}
		}
		return board;
	}
		
	public String format() {
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
