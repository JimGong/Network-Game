import java.util.Scanner;

public class Network {

	public static void main(String[] args) {

		Move m;
		JimBoard board = new JimBoard();
		Scanner scan = new Scanner(System.in);
		int numplayer;
		System.err
				.println("\nPassed ALL TEST: 1,2,3,4,5,6\nHaven't passed TEST: NONE");

		System.out.println("Enter num of human players:(0, 1, 2) ");

		numplayer = scan.nextInt();

		// numplayer = 3;
		System.out.println("human player: " + numplayer);

		if (numplayer == 0) {
			JimComputerPlayer p1 = new JimComputerPlayer(1);
			JimComputerPlayer p2 = new JimComputerPlayer(2);

			do {

				m = p1.getMove();
				System.out.println("\nplayer1: " + m.toRow + m.toCol);
				board.makeMove(m, p1);
				p2.OpponentMove(m);
				board.printBoard();
				if (board.checkWin(1)) {
					return;
				}

				m = p2.getMove();
				System.out.println("\nplayer2: " + m.toRow + m.toCol);

				board.makeMove(m, p2);
				p1.OpponentMove(m);
				board.printBoard();
				if (board.checkWin(2)) {
					return;
				}
			} while (board.checkWin(1) == false && board.checkWin(2) == false);

		} else if (numplayer == 1) {
			JimHumanPlayer p1 = new JimHumanPlayer(1);
			JimComputerPlayer p2 = new JimComputerPlayer(2);

			do {
				do {
					m = p1.getMove();
				} while (board.checkValidMove(m, p1) == false);

				board.makeMove(m, p1);
				p2.OpponentMove(m);
				board.printBoard();
				if (board.checkWin(1)) {
					return;
				}

				m = p2.getMove();

				board.makeMove(m, p2);
				p1.OpponentMove(m);
				board.printBoard();
				if (board.checkWin(2)) {
					return;
				}
			} while (board.checkWin(1) == false || board.checkWin(2) == false);

		} else if (numplayer == 2) {
			JimHumanPlayer p1 = new JimHumanPlayer(1);
			JimHumanPlayer p2 = new JimHumanPlayer(2);

			do {
				do {
					m = p1.getMove();
				} while (board.checkValidMove(m, p1) == false);

				board.makeMove(m, p1);
				p2.OpponentMove(m);
				board.printBoard();
				if (board.checkWin(1)) {
					return;
				}

				do {
					m = p2.getMove();
				} while (board.checkValidMove(m, p2) == false);
				board.makeMove(m, p2);
				p1.OpponentMove(m);
				board.printBoard();
				if (board.checkWin(2)) {
					return;
				}
			} while (board.checkWin(1) == false || board.checkWin(2) == false);
		} else if (numplayer == 3) {
			JimHumanPlayer human1 = new JimHumanPlayer(1);
			JimHumanPlayer human2 = new JimHumanPlayer(2);
			Move mymove;
			System.err.println("*********** TESTING *************");
			mymove = new Move('A', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('B', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('D', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('E', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 5);
			board.makeMove(mymove, human2);

			mymove = new Move('G', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 8);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 5);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 6);
			board.makeMove(mymove, human2);

			board.printBoard();
			board.checkWin(1);
			board.checkWin(2);
		} else if (numplayer == 4) {
			JimHumanPlayer human1 = new JimHumanPlayer(1);
			JimHumanPlayer human2 = new JimHumanPlayer(2);
			Move mymove;
			System.err.println("\n*********** TEST FIVE *************");

			mymove = new Move('A', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 3);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 5);
			board.makeMove(mymove, human1);

			mymove = new Move('D', 5);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('F', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('E', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('D', 3);
			board.makeMove(mymove, human2);

			mymove = new Move('E', 7);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 6);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 7);
			board.makeMove(mymove, human1);

			board.printBoard();
			board.checkWin(1);
			board.checkWin(2);

		} else if (numplayer == 5) {
			JimHumanPlayer human1 = new JimHumanPlayer(1);
			JimHumanPlayer human2 = new JimHumanPlayer(2);
			Move mymove;

			System.err.println("\n*********** TEST FIVE *************");

			mymove = new Move('E', 5);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('F', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 4);
			board.makeMove(mymove, human2);

			mymove = new Move('E', 7);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 3);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 3);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('F', 7);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 5);
			board.makeMove(mymove, human2);

			mymove = new Move('A', 6);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 6);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 8);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 5);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 6);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 6);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 6);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 7);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 1);
			board.makeMove(mymove, human2);

			System.out.println("**** BEFORE MOVE****");
			// System.err.println("\n\n**** BEFORE MOVE****\n\n");
			System.out.println();
			board.printBoard();
			System.out.println();
			System.out.println();

			mymove = new Move('C', 7, 'F', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 1, 'C', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('F', 7, 'D', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 1, 'B', 8);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 3, 'A', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 6, 'G', 5);
			board.makeMove(mymove, human2);

			mymove = new Move('D', 2, 'C', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 2, 'G', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 6, 'A', 3);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 4, 'E', 4);
			board.makeMove(mymove, human2);

			mymove = new Move('A', 6, 'C', 7);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 2, 'B', 5);
			board.makeMove(mymove, human2);

			mymove = new Move('E', 5, 'F', 7);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 2, 'G', 8);
			board.makeMove(mymove, human2);

			mymove = new Move('F', 4, 'E', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 4, 'B', 3);
			board.makeMove(mymove, human2);

			mymove = new Move('A', 3, 'A', 6);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 6, 'D', 2);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 4, 'E', 4);
			board.makeMove(mymove, human1);
			System.err.println("\n**** AFTER MOVE****\n");
			board.printBoard();
			System.out.println();

			board.checkWin(1);
			board.checkWin(2);

		} else if (numplayer == 6) {
			JimHumanPlayer human1 = new JimHumanPlayer(1);
			JimHumanPlayer human2 = new JimHumanPlayer(2);
			Move mymove;

			System.err.println("\n*********** TEST SIX *************");

			mymove = new Move('D', 6);
			board.makeMove(mymove, human1);

			mymove = new Move('B', 4);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 5);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 7);
			board.makeMove(mymove, human2);

			mymove = new Move('C', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 4);
			board.makeMove(mymove, human2);

			mymove = new Move('F', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 3);
			board.makeMove(mymove, human2);

			mymove = new Move('F', 5);
			board.makeMove(mymove, human1);

			mymove = new Move('G', 4);
			board.makeMove(mymove, human2);

			mymove = new Move('G', 6);
			board.makeMove(mymove, human1);

			mymove = new Move('F', 7);
			board.makeMove(mymove, human2);

			mymove = new Move('A', 3);
			board.makeMove(mymove, human1);

			mymove = new Move('C', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('A', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('E', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 3);
			board.makeMove(mymove, human1);

			mymove = new Move('F', 1);
			board.makeMove(mymove, human2);

			mymove = new Move('H', 4);
			board.makeMove(mymove, human1);

			mymove = new Move('F', 8);
			board.makeMove(mymove, human2);

			System.out.println("**** BEFORE MOVE****");
			System.out.println();
			board.printBoard();
			System.out.println();
			System.out.println();

			mymove = new Move('A', 3, 'A', 2);
			board.makeMove(mymove, human1);

			mymove = new Move('F', 1, 'B', 6);
			board.makeMove(mymove, human2);

			System.err.println("\n**** AFTER MOVE****\n");
			board.printBoard();
			System.out.println();
			board.checkWin(1);
			board.checkWin(2);
		} else {
			System.out.println("Invalid num of player. Try again!");
		}

	}
}
