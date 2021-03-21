import java.util.*;

import core.data.DataSource;

public class SudokuMain {
	
	public static void main(String[] args) {
		
//		// option for testing the solver by putting in hardcoded values
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
		
		DataSource puzzles = DataSource.connect("SudokuProject\\sudoku.csv");  // connecting to a dataset of puzzles
		puzzles.load();

		ArrayList<SudokuPuzzles> games = puzzles.fetchList("SudokuPuzzles", "quizzes");   // creating an arraylist of all the puzzles in the database

		System.out.println("CHOOSING PUZZLE");
		int randomValue = (int) (Math.random() * 1000000);
		String chosenPuzzle = games.get(randomValue).getPuzzle();   // choosing a random puzzle from the arraylist of puzzles


		int [][] myBoard = games.get(randomValue).puzzleArray();    //formatting the puzzle that will be passed to the solver

		System.out.println(games.get(randomValue).format());        // printing out a more legible version of the puzzle show the user the unsolved puzzle
		SudokuSolver solver = new SudokuSolver(myBoard);

		System.out.println("SOLVING");

		solver.locate();                                           //calling the function to solve the puzzle
		System.out.println(games.get(randomValue).format());

		if (solver.emptySpaces(myBoard) == 0) {                    //checking if puzzle is solved
			System.out.println("SOLVED");
		}
	}
	
}