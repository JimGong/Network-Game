import java.util.Scanner;

public class JimHumanPlayer extends Player {
	public int usedPiece = 0;

	public int[][] location = new int[9][9];

	public JimHumanPlayer(int playerNum) {
		super(playerNum);
	}

	@Override
	public Move getMove() {
		char toRow, fromRow;
		int toCol, fromCol;
		String position;
		Move myMove;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		// SingletonScanner.getInstance();
		if (this.usedPiece < 10) {
			do {
				// System.out.println("\n%%%%%%%%");
				System.out.println("Player " + playerNum
						+ " Enter where u want to put the piece: (EX: A 5)");

				position = sc.nextLine();
				if (position.length() != 3) {
					System.err.println("invalid input. Try again");
				}
			} while (position.length() != 3);

			toRow = position.charAt(0);
			toCol = Integer.parseInt(position.substring(2));
			System.out.println("input: " + toRow + toCol);
			myMove = new Move(toRow, toCol);
		} else {
			do {
				// System.out.println("\n########");
				// this do while check if basic valid input
				do {
					System.out
							.println("Player "
									+ playerNum
									+ " You have already used all 10 piece. So, Enter which piece you want to move and the location you want move to : (EX: B 2 C 5) ");
					position = sc.nextLine();
					if (position.length() != 7) {
						System.err.println("invalid input. Try again");
					}
				} while (position.length() != 7);

				fromRow = position.charAt(0);
				fromCol = Integer.parseInt(position.substring(2, 3));
				toRow = position.charAt(4);
				toCol = Integer.parseInt(position.substring(6));
				// System.out.println("from: " + fromRow + "" + fromCol + " to "
				// + toRow + toCol);
			} while (position.length() != 7);
			myMove = new Move(fromRow, fromCol, toRow, toCol);
		}
		return myMove;
	}

	@Override
	public void OpponentMove(Move m) {

	}

}
