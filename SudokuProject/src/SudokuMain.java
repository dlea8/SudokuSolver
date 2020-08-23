import java.util.*;

import core.data.DataSource;

public class SudokuMain {
	
	public static void main(String[] args) {
		
//		// create a board
//		int[][] myBoard = {
//				{2, 7, 0,   5, 0, 3,   9, 1, 0},
//				{5, 0, 0,   2, 0, 7,   6, 0, 0},
//				{9, 8, 3,   0, 0, 0,   5, 7, 0},
//				
//				{3, 0, 5,   7, 1, 0,   8, 4, 0},
//				{8, 2, 0,   9, 0, 5,   0, 6, 7},
//				{0, 1, 9,   0, 6, 4,   3, 0, 5},
//				
//				{0, 3, 8,   0, 0, 0,   7, 5, 6},
//				{0, 0, 2,   3, 0, 8,   0, 0, 1},
//				{0, 9, 7,   6, 0, 1,   0, 3, 8}
//		};
//		
//		
//		//solve
//		SudokuSolver solver = new SudokuSolver(myBoard);
//		System.out.println(SudokuBoard.format(myBoard));
//		solver.locate();
//		System.out.println(SudokuBoard.format(myBoard));
//		System.out.println(solver.emptySpaces(myBoard));
		
		DataSource puzzles = DataSource.connect("C:\\Users\\ben_j\\Downloads\\sudoku\\sudoku.csv");  // connecting to a database of puzzles
		puzzles.load();
		
		ArrayList<SudokuPuzzles> games = puzzles.fetchList("SudokuPuzzles", "quizzes");   // creating an arraylist of all the puzzles in the database
		
		System.out.println("CHOOSING PUZZLE");
		int randomValue = (int) (Math.random()* 1000000);
		String chosenPuzzle = games.get(randomValue).getPuzzle();   // choosing a random puzzle from the arraylist of puzzles
		
		System.out.println(chosenPuzzle);
		int [][] myBoard = games.get(randomValue).puzzleArray();
		
		System.out.println(games.get(randomValue).format());
		SudokuSolver solver = new SudokuSolver(myBoard);
		System.out.println("SOLVING");
		solver.locate();
		System.out.println(games.get(randomValue).format());
		System.out.println(solver.emptySpaces(myBoard));
		if (solver.emptySpaces(myBoard) == 0) {
			System.out.println("SOLVED");
		}
	}
	
}
