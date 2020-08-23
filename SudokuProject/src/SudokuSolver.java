import java.util.*;

public class SudokuSolver {
	
	private int[][] board;
	
	public SudokuSolver(int[][] board) {
		this.board = board;
	}
	
	
	//iterate through each number
	//jumps from box to box
	public void locate() {
		int number = 1; 
		
		while (!checkWin()) {
			
			for (int i = 0; i < 9; i+=3) {			
				for (int j = 0; j < 9; j+=3) {
					getPosSpaces(i, j, number);
				}
			}
			
			if (number == 9) {
				number = 0;
			}
			else {
				number += 1;
			}
		}
	}
	
	
	//goes through a particular box in the puzzle and place the number where it should go if possible
	public void getPosSpaces(int startX, int startY, int num) {
		ArrayList<Space> posSpaces = new ArrayList<Space>();
		for(int row = startX; row < startX + 3; row++) {      //3 times
			for (int col = startY; col < startY + 3; col++) {  //3 times each time
				if (board[row][col] == 0 && checkRow(board[row], num) && checkCol(col, num) && checkBox(startX, startY, num)) {
					Space open = new Space(row, col);
					posSpaces.add(open);
				}
			}
		}
		//return posSpaces;
		if (posSpaces.size() == 1) {
			board[posSpaces.get(0).getX()][posSpaces.get(0).getY()] = num;
		}
	}
	
	
	//num is the number we want to input into the space (done)
	public boolean checkRow(int[] row, int num ) {
		for (int i = 0; i < row.length; i++) {
			if (row[i] == num) {
				return false;
			}
		}
		return true;
	}
	
	
	//done (maybe)
	public boolean checkCol(int col, int num) {
		for(int row = 0; row < board.length; row++) {
			if (board[row][col] == num) {
				return false;
			}
		}
		return true;
	}

	//done (maybe)
	public boolean checkBox(int startX, int startY, int num) {
		for (int i = startX; i < startX + 3; i++) {
			for (int j = startY; j < startY + 3; j++) {
				if (board[i][j] == num) 
				{
					return false; 
				}
			}
		}
		return true;
	}
	
	
	//checks to see if the board is filled in (done)
	public boolean checkWin() {
		for(int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 0) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	
//	public String format(int[][] board) {
//		String stringBoard = " ____________________\n";
//		for (int row = 0; row < board.length; row++) {
//			for (int col = 0; col < board.length; col++) {
//				if ((col)%3 == 0) {
//					stringBoard += "|";
//				}
//				stringBoard = stringBoard + board[row][col] + " ";
//			}
//			stringBoard += "|\n";
//			if ((row+1)%3 == 0) {
//				stringBoard += "|------|------|------|\n";
//			}
//		}
//		return stringBoard;
//	}
//	
	
	public int emptySpaces(int[][] board) {
		int spaces = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] ==  0) {
					spaces++;
				}
			}
		}
		return spaces;
	}
}
