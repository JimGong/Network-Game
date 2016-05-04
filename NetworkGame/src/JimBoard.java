import java.util.ArrayList;

public class JimBoard {
	int[][] location = new int[9][9];
	boolean[][] visited = new boolean[9][9];
	public ArrayList<Move> winPath;

	public JimBoard() {
		initialArray();
	}

	public void initialArray() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				location[i][j] = -1;
				visited[i][j] = false;
			}
		}
	}

	public boolean validLocation(int row, int col) {
		if ((row >= 1) && (col >= 1) && (row <= 8) && (col <= 8)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkValidMove(Move myMove, JimHumanPlayer player) {
		// System.out.println("\n!!!!!!!! Checking if valid move !!!!!!");
		if (player.usedPiece < 10) {
			int row = (int) myMove.toRow - 64;
			int col = myMove.toCol;
			// System.out.println("target row: " + (char) (row + 64) +
			// " col: "
			// + col);
			if (row < 0 || col < 0 || row >= 9 || col >= 9) {
				System.err.println("invalid location");
				return false;
			}

			else if ((col == 1 && row == 1) || (col == 1 && row == 8)
					|| (col == 8 && row == 1) || (col == 8 && row == 8)) {
				System.err.println("the location " + (char) (row + 64) + (col)
						+ " is in corner");
				return false;
			} else if (location[row][col] != -1) {
				System.err.println("a piece is alread in that location "
						+ (char) (row + 64) + (col));
				return false;
			} else if ((player.playerNum == 1) && (col == 1 || col == 8)) {
				System.err.println("the location " + (char) (row + 64) + (col)
						+ " is in opponent's goal");
				return false;
			} else if ((player.playerNum == 2) && (row == 1 || row == 8)) {
				System.err.println("For player 2, the location "
						+ (char) (row + 64) + (col) + " is in opponent's goal");
				return false;
			} else if (checkCluster(myMove, player) == true) {
				System.err.println("placing a piece at location "
						+ (char) (row + 64) + (col)
						+ " would form a cluster of 3 or more pieces");
				return false;
			} else if (checkWin(1) == true && checkWin(2) == true) {
				System.err.println("placing a piece at location "
						+ (char) (row + 64) + (col)
						+ "would create network for both players");
				return false;
			} else {
				// System.out.println("--------- THIS IS VALID MOVE --------");
				return true;
			}
		} else {
			// check if move piece is legal
			int fromRow = (int) myMove.fromRow - 64;
			int fromCol = myMove.fromCol;
			int toRow = (int) myMove.toRow - 64;
			int toCol = myMove.toCol;
			// System.out.println("will move: (" + (char) fromRow + 64 +
			// ", "
			// + fromCol + " to (" + (char) toRow + 74 + ", " + toCol);
			if (fromRow < 1 || fromCol < 0 || toRow < 1 || toCol < 0
					|| fromRow >= 9 || fromRow >= 9 || toRow >= 9
					|| fromCol >= 9) {
				System.err.println("invalid location.");
				return false;
			} else if (location[fromRow][fromCol] != player.playerNum) {
				System.err.println("There is no piece of Player"
						+ player.playerNum);
				return false;
			} else if (location[toRow][toCol] != -1) {
				System.err.println("a piece is already in the location "
						+ (char) (toRow + 64) + toCol);
				return false;
			} else if ((toCol == 1 && toRow == 1) || (toCol == 1 && toRow == 8)

			|| (toCol == 8 && toRow == 1) || (toCol == 8 && toRow == 8)) {
				System.err.println("the location " + (char) (toRow + 64)
						+ toCol + " is in the conrner");
				return false;
			} else if ((player.playerNum == 1) && (toCol == 1 || toCol == 8)) {
				System.err.println("the location " + (char) (toRow + 64)
						+ toCol + " is in opponennt's goal");
				return false;
			} else if (player.playerNum == 2 && (toRow == 1 || toRow == 8)) {
				System.err.println("the location " + (char) (toRow + 64)
						+ toCol + " is in opponennt's goal");
				return false;
			} else if (checkCluster(myMove, player) == true) {
				System.err.println("move a piece from location "
						+ (char) (fromRow + 64) + (fromCol) + " to "
						+ (char) (toRow + 64) + toCol
						+ " would form a cluster of 3 or more pieces");
				return false;
			} else if (checkWin(1) == true && checkWin(2) == true) {
				System.err.println("move a piece from location "
						+ (char) (fromRow + 64) + (fromCol) + " to "
						+ (char) (toRow + 64) + toCol
						+ "would create network for both players");
				return false;
			} else {
				// System.out.println("--------- THIS IS VALID MOVE --------");
				return true;
			}
		}

	}

	public boolean checkValidMove(Move myMove, JimComputerPlayer player) {
		// System.out.println("\n!!!!!!!! Checking if valid move !!!!!!");
		if (player.usedPiece < 10) {
			int row = (int) myMove.toRow - 64;
			int col = myMove.toCol;
			// System.out.println("target row: " + (char) (row + 64) +
			// " col: "
			// + col);
			if (row < 0 || col < 0 || row >= 9 || col >= 9) {
				// System.err.println("invalid location");
				return false;
			}

			else if ((col == 1 && row == 1) || (col == 1 && row == 8)
					|| (col == 8 && row == 1) || (col == 8 && row == 8)) {
				// System.err.println("the location " + (char) (row + 64) +
				// (col)
				// + " is in corner");
				return false;
			} else if (location[row][col] != -1) {
				// System.err.println("a piece is alread in that location "
				// + (char) (row + 64) + (col) + " " + location[row][col]);
				return false;
			} else if ((player.playerNum == 1) && (col == 1 || col == 8)) {
				// System.err.println("the location " + (char) (row + 64) +
				// (col)
				// + " is in opponent's goal");
				return false;
			} else if ((player.playerNum == 2) && (row == 1 || row == 8)) {
				// System.err.println("For player 2, the location "
				// + (char) (row + 64) + (col) + " is in opponent's goal");
				return false;
			} else if (checkCluster(myMove, player) == true) {
				// System.err.println("placing a piece at location "
				// + (char) (row + 64) + (col)
				// + " would form a cluster of 3 or more pieces");
				return false;
			} else if (checkWin(1) == true && checkWin(2) == true) {
				// System.err.println("placing a piece at location "
				// + (char) (row + 64) + (col)
				// + "would create network for both players");
				return false;
			} else {
				// System.out.println("--------- THIS IS VALID MOVE --------");
				return true;
			}
		} else {
			// check if move piece is legal
			int fromRow = (int) myMove.fromRow - 64;
			int fromCol = myMove.fromCol;
			int toRow = (int) myMove.toRow - 64;
			int toCol = myMove.toCol;
			// System.out.println("will move: (" + (char) fromRow + 64 +
			// ", "
			// + fromCol + " to (" + (char) toRow + 74 + ", " + toCol);
			if (fromRow < 1 || fromCol < 0 || toRow < 1 || toCol < 0
					|| fromRow >= 9 || fromRow >= 9 || toRow >= 9
					|| fromCol >= 9) {
				// System.err.println("invalid location.");
				return false;
			} else if (location[fromRow][fromCol] != player.playerNum) {
				// System.err.println("There is no piece of Player"
				// + player.playerNum);
				return false;
			} else if (location[toRow][toCol] != -1) {
				// System.err.println("a piece is already in the location "
				// + (char) (toRow + 64) + toCol);
				return false;
			} else if ((toCol == 1 && toRow == 1) || (toCol == 1 && toRow == 8)

			|| (toCol == 8 && toRow == 1) || (toCol == 8 && toRow == 8)) {
				// System.err.println("the location " + (char) (toRow + 64)
				// + toCol + " is in the conrner");
				return false;
			} else if ((player.playerNum == 1) && (toCol == 1 || toCol == 8)) {
				// System.err.println("the location " + (char) (toRow + 64)
				// + toCol + " is in opponennt's goal");
				return false;
			} else if (player.playerNum == 2 && (toRow == 1 || toRow == 8)) {
				// System.err.println("the location " + (char) (toRow + 64)
				// + toCol + " is in opponennt's goal");
				return false;
			} else if (checkCluster(myMove, player) == true) {
				// System.err.println("move a piece from location "
				// + (char) (fromRow + 64) + (fromCol) + " to "
				// + (char) (toRow + 64) + toCol
				// + " would form a cluster of 3 or more pieces");
				return false;
			} else if (checkWin(1) == true && checkWin(2) == true) {
				// System.err.println("move a piece from location "
				// + (char) (fromRow + 64) + (fromCol) + " to "
				// + (char) (toRow + 64) + toCol
				// + "would create network for both players");
				return false;
			} else {
				// System.out.println("--------- THIS IS VALID MOVE --------");
				return true;
			}
		}

	}

	public boolean checkCluster(Move move, JimHumanPlayer player) {
		int fromRow;
		int fromCol;
		int row = (int) move.toRow - 64;
		int col = move.toCol;
		int numcluster = 1;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				visited[i][j] = false;
			}
		}
		// System.out.println("(checkCluster) player" + player.playerNum
		// + " used pieces:" + player.usedPiece + " "
		// + (player.usedPiece >= 10));
		if (player.usedPiece >= 10) {
			fromRow = (int) move.fromRow - 64;
			fromCol = move.fromCol;
			location[fromRow][fromCol] = -1;
			// System.out.println("set " + (char) (fromRow + 64) + "" + fromCol
			// + "to -1 for testing form cluster");
		}
		int playernum = player.playerNum;
		numcluster = checkFormCluster(row, col, playernum, numcluster, row, col);

		// System.out.println("** numcluster: " + numcluster);
		if (numcluster >= 3) {
			// System.err.println("it will form cluster");
			if (player.usedPiece >= 10) {
				fromRow = (int) move.fromRow - 64;
				fromCol = move.fromCol;
				location[fromRow][fromCol] = playernum;
			}
			return true;
		} else {
			return false;

		}
	}

	public boolean checkCluster(Move move, JimComputerPlayer player) {
		int fromRow;
		int fromCol;
		int row = (int) move.toRow - 64;
		int col = move.toCol;
		int numcluster = 1;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				visited[i][j] = false;
			}
		}
		// System.out.println("(checkCluster) player" + player.playerNum
		// + " used pieces:" + player.usedPiece + " "
		// + (player.usedPiece >= 10));
		if (player.usedPiece >= 10) {
			fromRow = (int) move.fromRow - 64;
			fromCol = move.fromCol;
			location[fromRow][fromCol] = -1;
			// System.out.println("set " + (char) (fromRow + 64) + "" + fromCol
			// + "to -1 for testing form cluster");
		}
		int playernum = player.playerNum;
		numcluster = checkFormCluster(row, col, playernum, numcluster, row, col);

		// System.out.println("** numcluster: " + numcluster);
		if (numcluster >= 3) {
			// System.err.println("it will form cluster");
			if (player.usedPiece >= 10) {
				fromRow = (int) move.fromRow - 64;
				fromCol = move.fromCol;
				location[fromRow][fromCol] = playernum;
			}
			return true;
		} else {
			return false;

		}
	}

	public int checkFormCluster(int row, int col, int playernum,
			int numcluster, int originalRow, int originalCol) {
		// base case
		// System.out.println("\n^^^^^^ numcluster: " + numcluster);

		visited[row][col] = true;

		if (numcluster >= 3 || Math.abs(row - originalRow) >= 2
				|| Math.abs(col - originalCol) >= 2) {
			// System.err.println("returned numcluster: " + numcluster);
			return numcluster;
		}
		// // recursive

		// System.out.println("\n(checkFormCluster) target (" + (char) (row +
		// 64)
		// + ", " + col + ")\n orgininalRow: " + (char) (originalRow + 64)
		// + " orignialCol: " + originalCol);
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {

				if (validLocation(i, j)) {
					// System.out.println("location (" + (char) (i + 64) + ", "
					// + j + ") ---- visited: " + visited[i][j]);
					if (visited[i][j] == false) {
						if (location[i][j] == playernum) {

							// System.out.println("find piece at ("
							// + (char) +(i + 64) + ", " + j + ")");
							numcluster++;
							// System.out.println("----  After increasement: "
							// + numcluster);
							visited[i][j] = true;
							numcluster = checkFormCluster(i, j, playernum,
									numcluster, originalRow, originalCol);
						}
					}
				}
			}

		}

		return numcluster;
	}

	public boolean checkWin(int playerNum) {

		int startRow = -1, startCol = -1, endRow = -1, endCol = -1;
		winPath = new ArrayList<Move>();
		// FOR multi start and end
		if (playerNum == 1) {
			// System.out.println("\nchecking win for player1");
			for (int i = 1; i < 9; i++) {
				// find startlocation

				if (location[1][i] == playerNum) {
					startRow = 1;
					startCol = i;

					for (int j = 1; j < 9; j++) {
						// find endlocation
						if (location[8][j] == playerNum) {
							endRow = 8;
							endCol = j;
							// have found
							winPath = new ArrayList<Move>();
							// System.out.println("\nplayer1 startlocation: "
							// + (char) (startRow + 64) + "" + startCol
							// + " -- endlocation: "
							// + (char) (endRow + 64) + "" + endCol);

							// initial visited
							for (int m = 0; m < 9; m++) {
								for (int n = 0; n < 9; n++) {
									visited[m][n] = false;
								}
							}

							if (startRow < 0 || startCol < 0) {
								return false;
							}

							if (endRow < 0 || endCol < 0) {
								return false;
							}
							boolean pathfound = findPath(startRow, startCol,
									endRow, endCol, playerNum, -2, -1, -100);

							if (pathfound == true) {
								System.out.println("\n****** Player "
										+ playerNum + " win!!! ******");
								System.out.println("player1 connected piece: "
										+ winPath.size());
								for (int z = 0; z < winPath.size(); z++) {
									System.out.print(winPath.get(z).toRow + ""
											+ winPath.get(z).toCol + " ");
								}
								System.out.println();
								return true;
							}
						}
					}
				}
			}
		} else {
			// System.out.println("\nchecking win for player 2");
			for (int i = 1; i < 9; i++) {
				if (location[i][1] == playerNum) {
					startRow = i;
					startCol = 1;
					for (int j = 1; j < 9; j++) {
						if (location[j][8] == playerNum) {
							endRow = j;
							endCol = 8;
							// have found
							winPath = new ArrayList<Move>();
							// System.out.println("\nplayer2 startlocation: "
							// + (char) (startRow + 64) + "" + startCol
							// + " -- endlocation: "
							// + (char) (endRow + 64) + "" + endCol);

							// initial visited
							for (int m = 0; m < 9; m++) {
								for (int n = 0; n < 9; n++) {
									visited[m][n] = false;
								}
							}

							if (startRow < 0 || startCol < 0) {
								return false;
							}

							if (endRow < 0 || endCol < 0) {
								return false;
							}
							boolean pathfound = findPath(startRow, startCol,
									endRow, endCol, playerNum, -2, -1, -100);

							if (pathfound == true) {
								System.out.println("\n****** Player "
										+ playerNum + " win!!! ******");
								System.out.println("player2 connected piece: "
										+ winPath.size());
								for (int z = 0; z < winPath.size(); z++) {
									System.out.print(winPath.get(z).toRow + ""
											+ winPath.get(z).toCol + " ");
								}
								System.out.println();
								return true;
							}
							// else {
							// return false;
							// }
						}
					}
				}
			}
		}
		return false;
	}

	public float getSlop(int x1, int x2, int y1, int y2) {
		if (x1 - x2 == 0) {
			return -10;
		}
		float slop = (float) ((y1 - y2) / (x1 - x2));
		return slop;
	}

	public boolean findPath(int startRow, int startCol, int endRow, int endCol,
			int playernum, int prevRow, int prevCol, float prevslop) {
		// System.out.println("Path: " + winPath.toString());
		Move myMove;
		Move temp;
		// System.out.println("startlocation " + (char) (startRow + 64) +
		// startCol
		// + " lastlocation: " + (char) (lastRow + 64) + lastCol);
		int curX, curY;
		// System.out.println("start: " + (char) (startRow + 64) + "" +
		// startCol);
		if (startRow == endRow && startCol == endCol) {
			// System.out.println("startRow = endRow && startCol = endCol");

			if (winPath.size() >= 6) {
				return true;
			} else {
				return false;
			}
		}
		if (winPath.size() == 0) {
			myMove = new Move((char) (startRow + 64), startCol);
			winPath.add(myMove);
			visited[startRow][startCol] = true;
			// System.out.println((char) (startRow + 64) + "" + startCol
			// + " ADDED AND VISITED SETTED TO TRUE");
		}

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				// System.out.println("start:" + (char) (startRow + 64) + ""
				// + startCol + " ** " + x + " " + y);
				if (x != 0 || y != 0) {
					curX = startRow + x;
					curY = startCol + y;

					while (validLocation(curX, curY)
							&& location[curX][curY] == -1) {
						// System.out.println("going through: "
						// + (char) (curX + 64) + "" + curY);
						curX = curX + x;
						curY = curY + y;
						// System.out.println("going through: "
						// + (char) (curX + 64) + "" + curY);
						// if (validLocation(curX, curY)
						// && locationCopy[curX][curY] == playernum) {
						// break;
						// }
					}
					if (validLocation(curX, curY)) {
						// System.out.println("In FindPath, considering location "
						// + (char) (curX + 64) + "" + curY
						// + " ** valid: " + validLocation(curX, curY)
						// + " ** myself: "
						// + (location[curX][curY] == playernum)
						// + " ** visited==FALSE: "
						// + (visited[curX][curY] == false));

					}
					if (validLocation(curX, curY)
							&& location[curX][curY] == playernum
							&& visited[curX][curY] == false) {
						// slop next is curx-startrow cury
						// slop cur is startrow, startcol
						// slop prev is prevrow, prevcol
						// float prevslop = getSlop(prevRow, startRow,
						// prevCol,
						// startCol, prevslop);
						float nextslop = getSlop(curX, startRow, curY, startCol);
						// System.out.println("slop of " + (char) (prevRow + 64)
						// + "" + prevCol + "" + (char) (startRow + 64)
						// + "" + startCol + " is: " + prevslop
						// + " ---- slop of " + (char) (startRow + 64)
						// + "" + startCol + "" + (char) (curX + 64) + ""
						// + curY + " is: " + nextslop);

						if (nextslop != prevslop) {
							// System.out.println("\nfind piece at: "
							// + (char) (curX + 64) + "" + curY + "\n");
							if (playernum == 1 && winPath.size() > 0
									&& ((char) (curX + 64) != 'A')) {
								// for only one piece in goal region
								if (!((char) (curX + 64) == 'H' && curY != endCol)) {
									// location[curX][curY] =
									// location[curX][curY] + 2;

									myMove = new Move((char) (curX + 64), curY);
									winPath.add(myMove);
									// System.out.println((char) (curX + 64) +
									// ""
									// + curY + " ADDED"
									// + " AND VISITED SETTED TO TRUE");

									visited[curX][curY] = true;

									if (findPath(curX, curY, endRow, endCol,
											playernum, startRow, startCol,
											nextslop)) {
										return true;
									} else {
										// temp = winPath
										// .remove(winPath.size() - 1);
										// System.out
										// .println(temp.toRow
										// + ""
										// + temp.toCol
										// +
										// " REMOVED AND VISITED SETTED TO FALSE");
										// visited[(int) temp.toRow -
										// 64][temp.toCol] = false;
										// System.out.println("SL "
										// + (char) (startRow + 64) + ""
										// + startCol + " PREV "
										// + (char) (curX + 64) + ""
										// + curY);
										// findPath(startRow, startCol, endRow,
										// endCol, playernum, curX, curY,
										// nextslop);
									}
									temp = winPath.remove(winPath.size() - 1);
									visited[(int) temp.toRow - 64][temp.toCol] = false;
									// System.out
									// .println(temp.toRow
									// + ""
									// + temp.toCol
									// +
									// " REMOVED AND VISITED SETTED TO FALSE");
								}
							} else if (playernum == 2 && winPath.size() > 0
									&& (curY != 1)) {

								if (!(curY == endCol && curX != endRow)) {
									myMove = new Move((char) (curX + 64), curY);
									winPath.add(myMove);
									// System.out.println((char) (curX + 64) +
									// ""
									// + curY + " ADDED"
									// + " AND VISITED SETTED TO TRUE");

									visited[curX][curY] = true;

									if (findPath(curX, curY, endRow, endCol,
											playernum, startRow, startCol,
											nextslop)) {
										return true;
									}
									temp = winPath.remove(winPath.size() - 1);
									visited[(int) temp.toRow - 64][temp.toCol] = false;
									// System.out
									// .println(temp.toRow
									// + ""
									// + temp.toCol
									// +
									// " REMOVED AND VISITED SETTED TO FALSE");
								}

							}
						} else {
							// System.err.println("slop are same");
						}
					}
				}
			}
		}
		return false;

	}

	public void printBoard() {
		System.out.println("----- Printing Board ----\n");
		for (int i = 1; i < 9; i++) {
			if (i == 1) {
				System.out.print("   " + (i) + " ");
			} else {
				System.out.print(" " + (i) + " ");
			}
		}
		for (int i = 1; i < 9; i++) {
			System.out.println();
			for (int j = 1; j < 9; j++) {
				String result;
				if (location[i][j] == -1) {
					result = "-";
				} else {
					result = Integer.toString(location[i][j]);
				}
				if (j == 1) {
					System.out.print((char) (i + 64) + ": " + result + "  ");
					// System.out.print(i + ": " + result + "  ");

				} else {
					System.out.print(result + "  ");
				}
			}
		}
	}

	public void makeMove(Move myMove, JimHumanPlayer player) {
		// System.out.println("\n!!!!!!!!! Making Move !!!!!!!!!");
		if (player.usedPiece < 10) {
			int row = (int) myMove.toRow - 64;
			int col = myMove.toCol;
			location[row][col] = player.playerNum;
			// System.out.println("set location[" + row + "][" + col + "] to "
			// + player.playerNum + "\n");
			player.usedPiece++;
			player.location[row][col] = player.playerNum;

		} else {
			// num of piece used more than 10. switch position;
			int fromRow = (int) myMove.fromRow - 64;
			int fromCol = myMove.fromCol;
			int toRow = (int) myMove.toRow - 64;
			int toCol = myMove.toCol;
			// System.out.println("player" + player.playerNum + " move "
			// + (char) (fromRow + 64) + "" + fromCol + " to "
			// + (char) (toRow + 64) + "" + toCol);
			location[fromRow][fromCol] = -1;
			location[toRow][toCol] = player.playerNum;
			player.location[fromRow][fromCol] = -1;
			player.location[toRow][toCol] = player.playerNum;
		}
	}

	public void makeMove(Move myMove, JimComputerPlayer player) {
		// System.out.println("\n!!!!!!!!! Making Move !!!!!!!!!");
		if (player.usedPiece < 10) {
			int row = (int) myMove.toRow - 64;
			int col = myMove.toCol;
			location[row][col] = player.playerNum;
			// System.out.println("set location[" + row + "][" + col + "] to "
			// + player.playerNum + "\n");
			player.usedPiece++;

			// player.location[row][col] = player.playerNum;

		} else {
			// num of piece used more than 10. switch position;
			int fromRow = (int) myMove.fromRow - 64;
			int fromCol = myMove.fromCol;
			int toRow = (int) myMove.toRow - 64;
			int toCol = myMove.toCol;
			// System.out.println("player" + player.playerNum + " move "
			// + (char) (fromRow + 64) + "" + fromCol + " to "
			// + (char) (toRow + 64) + "" + toCol);
			location[fromRow][fromCol] = -1;
			location[toRow][toCol] = player.playerNum;
			// player.location[fromRow][fromCol] = -1;
			// player.location[toRow][toCol] = player.playerNum;
		}
	}
}
