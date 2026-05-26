package ca.umanitoba.cs.buhlerk2.game;

import ca.umanitoba.cs.buhlerk2.exceptions.game.board.PositionTakenException;
import ca.umanitoba.cs.buhlerk2.exceptions.game.board.IllegalPlayerException;

public class Board {
	public static final int SIZE = 3;
	private final int[][] layout;

	public Board() {
		layout = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				layout[i][j] = -1;
			}
		}
	}

	public int[][] layout() {
		int[][] result = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			System.arraycopy(layout[i], 0, result[i], 0, SIZE);
		}
		return result;
	}

	public void makeMove(int player, Coordinate position) throws IllegalPlayerException, PositionTakenException {
		if (player < 0 || player > 1) {
			throw new IllegalPlayerException();
		}
		if (layout[position.x()][position.y()] != -1) {
			throw new PositionTakenException();
		}

		layout[position.x()][position.y()] = player;
	}

	public boolean hasWon(int player) {
		return hasOrthogonalLine(player) || hasDiagonalLine(player);
	}

	private boolean hasOrthogonalLine(int player) {
		boolean hasLine = false;
		for (int i = 0; i < SIZE; i++) {
			boolean hasHorizontalLine = true;
			boolean hasVerticalLine = true;
			for (int j = 0; j < SIZE; j++) {
				if (layout[i][j] != player) {
					hasHorizontalLine = false;
				}
				if (layout[j][i] != player) {
					hasVerticalLine = false;
				}
			}
			if (hasHorizontalLine || hasVerticalLine) {
				hasLine = true;
			}
		}
		return hasLine;
	}

	private boolean hasDiagonalLine(int player) {
		boolean hasLine = false;
		boolean hasDiagonalLine1 = true;
		boolean hasDiagonalLine2 = true;
		for (int i = 0; i < 3; i++) {
			if (layout[i][i] != player) {
				hasDiagonalLine1 = false;
			}
			if (layout[i][SIZE - i - 1] != player) {
				hasDiagonalLine2 = false;
			}
		}
		if (hasDiagonalLine1 || hasDiagonalLine2) {
			hasLine = true;
		}
		return hasLine;
	}
}
