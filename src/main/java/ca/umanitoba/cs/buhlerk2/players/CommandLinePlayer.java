package ca.umanitoba.cs.buhlerk2.players;

import ca.umanitoba.cs.buhlerk2.exceptions.game.board.IllegalPlayerException;
import ca.umanitoba.cs.buhlerk2.exceptions.game.board.PositionTakenException;
import ca.umanitoba.cs.buhlerk2.game.Board;
import ca.umanitoba.cs.buhlerk2.game.Coordinate;

import java.util.Scanner;

public class CommandLinePlayer implements Player {
	@Override
	public void takeTurn(Board board, int playerNumber) throws IllegalPlayerException {
		Scanner scanner = new Scanner(System.in);

		boolean hasValidInput = false;

		while (!hasValidInput) {
			try {
				System.out.println("Select a position ('x,y'):");
				System.out.print(">");
				String input = scanner.nextLine();
				String[] tokens = input.split(",");
				if (tokens.length != 2) {
					throw new InvalidInputException();
				}

				try {
					int x = Integer.parseInt(tokens[0]);
					int y = Integer.parseInt(tokens[0]);

					board.makeMove(playerNumber, new Coordinate(x, y));

				} catch (NumberFormatException _) {
					throw new InvalidInputException();
				} catch (PositionTakenException e) {
					throw new RuntimeException(e);
				}

				hasValidInput = true;
			} catch (InvalidInputException _) {
				System.err.println("Invalid input! Input must be of the form 'x,y'");
			}
		}
	}

	private class InvalidInputException extends Exception {}
}