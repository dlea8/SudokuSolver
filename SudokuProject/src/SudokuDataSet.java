//not used anymore (test)

import core.data.*;
import java.util.ArrayList;

public class SudokuDataSet {
	public static void main(String[] args) {
		DataSource puzzles = DataSource.connect("C:\\Users\\ben_j\\Downloads\\sudoku\\sudoku.csv");  // connecting to a database of puzzles
		puzzles.load();
		
		ArrayList<SudokuPuzzles> games = puzzles.fetchList("SudokuPuzzles", "quizzes");   // creating an arraylist of all the puzzles in the database
		
		int randomValue = (int) (Math.random()* 1000000);
		String chosenPuzzle = games.get(randomValue).getPuzzle();   // choosing a random puzzle from the arraylist of puzzles
		
		System.out.println(chosenPuzzle);
		games.get(randomValue).puzzleArray();
		System.out.println(games.get(randomValue).format());
	}
}


