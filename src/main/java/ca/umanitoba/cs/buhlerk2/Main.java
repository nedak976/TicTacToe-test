package ca.umanitoba.cs.buhlerk2;

import ca.umanitoba.cs.buhlerk2.exceptions.game.board.PositionTakenException;
import ca.umanitoba.cs.buhlerk2.exceptions.game.board.IllegalPlayerException;
import ca.umanitoba.cs.buhlerk2.game.Board;
import ca.umanitoba.cs.buhlerk2.display.BoardDisplay;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		BoardDisplay boardDisplay = new BoardDisplay(board);
		boardDisplay.display();
		try {
			board.makeMove(1, 0, 0);
			board.makeMove(2, 1, 1);
			board.makeMove(1, 0, 1);
			board.makeMove(2, 2, 1);
			board.makeMove(1, 0, 2);

		} catch (IllegalPlayerException | PositionTakenException e) {
			System.err.println("You're doing something wrong!");
		}
		boardDisplay.display();
		System.out.println(board.winner());
	}
}