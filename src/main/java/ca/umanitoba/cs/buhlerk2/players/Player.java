package ca.umanitoba.cs.buhlerk2.players;

import ca.umanitoba.cs.buhlerk2.exceptions.game.board.IllegalPlayerException;
import ca.umanitoba.cs.buhlerk2.game.Board;

public interface Player {
	void takeTurn(Board board, int playerNumber) throws IllegalPlayerException;
}
