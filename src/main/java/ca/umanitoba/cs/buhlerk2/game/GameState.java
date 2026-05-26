package ca.umanitoba.cs.buhlerk2.game;

import ca.umanitoba.cs.buhlerk2.display.BoardDisplay;
import ca.umanitoba.cs.buhlerk2.exceptions.game.board.IllegalPlayerException;
import ca.umanitoba.cs.buhlerk2.players.Player;

public class GameState {
	private final Board board;
	private final BoardDisplay display;
	private final Player[] players;

	public GameState(Board board, Player player1, Player player2) {
		this.board = board;
		display = new BoardDisplay(board);
		players = new Player[]{player1, player2};
	}

	public void run() {
		try {
			int currentPlayer = 0;
			int winner = -1;

			while (winner < 0) {
				players[currentPlayer].takeTurn(board, currentPlayer);

				if (board.hasWon(currentPlayer)) {
					winner = currentPlayer;
				} else {
					currentPlayer++;
					currentPlayer %= 2;
				}
			}

			display.display();
		} catch (IllegalPlayerException e) {
			System.err.println("Illegal state encountered. Error:" + e);
		}
	}
}
