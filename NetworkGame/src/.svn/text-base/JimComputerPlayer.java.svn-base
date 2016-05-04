import java.util.ArrayList;

public class JimComputerPlayer extends Player {
	JimBoard board = new JimBoard();
	int usedPiece;

	public JimComputerPlayer(int playerNum) {
		super(playerNum);
		usedPiece = 0;
	}

	private class MoveAndScore {
		private int score;
		private Move move;

		public MoveAndScore(int score, Move move) {
			this.score = score;
			this.move = move;
		}
	}

	@Override
	public void OpponentMove(Move m) {
		// just to kkep the board
		int fromRow, fromCol, toRow, toCol;
		int opponentplayernum = -1;
		if (this.playerNum == 1) {
			opponentplayernum = 2;
		} else if (this.playerNum == 2) {
			opponentplayernum = 1;
		}
		if (m.moveType == Move.MoveType.PLACE_PIECE) {
			toRow = m.toRow - 64;
			toCol = m.toCol;
			board.location[toRow][toCol] = opponentplayernum;
		}
		if (m.moveType == Move.MoveType.MOVE_PIECE) {
			fromRow = m.fromRow - 64;
			fromCol = m.fromCol;
			toRow = m.toRow - 64;
			toCol = m.toCol;
			board.location[fromRow][fromCol] = -1;
			board.location[toRow][toCol] = opponentplayernum;
		}
	}

	@Override
	public Move getMove() {
		Move bestMove = null;
		ArrayList<Move> availableMove = getAvailableMove();
		ArrayList<MoveAndScore> moveScore = evaluateAvailableMove(
				availableMove, board.location);
		bestMove = getBestMove(moveScore);
		board.makeMove(bestMove, this);
		return bestMove;
	}

	public ArrayList<Move> getAvailableMove() {
		ArrayList<Move> availableMove = new ArrayList<Move>();
		Move move;
		int fromRow, fromCol, toRow, toCol;
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				if (board.validLocation(i, j)) {
					if (this.usedPiece < 10) {
						if (board.location[i][j] == -1) {
							toRow = i;
							toCol = j;
							// if (toRow == 1 && toCol == 2) {
							// System.out.println((char) (toRow + 64) + ""
							// + toCol + " ** "
							// + board.location[toRow][toCol]);
							// }
							// if (toRow == 2 && toCol == 1) {
							// System.out.println((char) (toRow + 64) + ""
							// + toCol + " ** "
							// + board.location[toRow][toCol]);
							// }
							// System.out.println("checking " + (char)
							// (toRow +
							// 64)
							// + "" + toCol);
							move = new Move((char) (toRow + 64), toCol);
							if (board.checkValidMove(move, this)) {
								// System.out.println("available location: "
								// + move.toRow + "" + move.toCol);
								availableMove.add(move);
							}
						}
					} else {
						if (board.location[i][j] == this.playerNum) {
							fromRow = i;
							fromCol = j;
							for (int m = 1; m < 9; m++) {
								for (int n = 1; n < 9; n++) {
									if (board.validLocation(i, j)) {
										if (board.location[m][n] == -1) {
											toRow = m;
											toCol = n;
											move = new Move(
													(char) (fromRow + 64),
													fromCol,
													(char) (toRow + 64), toCol);
											if (board
													.checkValidMove(move, this)) {
												availableMove.add(move);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return availableMove;
	}

	public ArrayList<MoveAndScore> evaluateAvailableMove(
			ArrayList<Move> availableMove, int[][] location) {
		Move temp;
		int score;
		ArrayList<MoveAndScore> moveScore = new ArrayList<MoveAndScore>();
		for (int i = 0; i < availableMove.size(); i++) {
			temp = availableMove.get(i);
			board.makeMove(temp, this);
			board.checkWin(this.playerNum);
			if (board.checkWin(this.playerNum)) {
				score = Integer.MAX_VALUE;
			} else {
				// System.out.println("size: " + winPath.size());
				score = board.winPath.size();
				// System.out.println(temp.toRow + "" + temp.toCol + " score: "
				// + score);

			}
			MoveAndScore cur = new MoveAndScore(score, temp);
			// System.out.println("Move: " + temp.toRow + temp.toCol +
			// " score: "
			// + score);
			moveScore.add(cur);
			// reset

			if (temp.moveType == Move.MoveType.PLACE_PIECE) {
				board.location[temp.toRow - 64][temp.toCol] = -1;
			} else {
				board.location[temp.fromRow - 64][temp.fromCol] = this.playerNum;
				board.location[temp.toRow - 64][temp.toCol] = -1;

			}
			this.usedPiece--;
		}
		return moveScore;
	}

	public Move getBestMove(ArrayList<MoveAndScore> moveScore) {
		int best = -1;
		int maxscore = Integer.MIN_VALUE;
		for (int i = 0; i < moveScore.size(); i++) {
			if (moveScore.get(i).score > maxscore) {
				maxscore = moveScore.get(i).score;
				best = i;
			}
		}
		if (best == -1) {
			best = 0;
		}

		return moveScore.get(best).move;
	}
}
