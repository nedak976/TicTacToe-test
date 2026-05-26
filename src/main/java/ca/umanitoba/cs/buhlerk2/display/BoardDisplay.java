package ca.umanitoba.cs.buhlerk2.display;

import ca.umanitoba.cs.buhlerk2.game.Board;

public class BoardDisplay {
	private final Board board;

	public BoardDisplay(Board board) {
		this.board = board;
	}

	public void display() {
		int[][] layout = board.layout();
		for (int i = 0; i < layout.length; i++) {
			for (int j = 0; j < layout[i].length; j++) {
				System.out.print(layout[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
