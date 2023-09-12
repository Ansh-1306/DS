// import java.util.*;
// import java.io.*;

// class Interface {
// 	public static void main(String args[]) throws Exception {
// 		Scanner sc = new Scanner(System.in);
// 		String statusSTB = " (LOCKED)";
// 		String statusTTT = " (LOCKED)";
// 		boolean play = true;
// 		boolean lock = false;

// 		System.out.println();
// 		System.out.println("  " + String.format("%18s", "").replace(" ", "-") + "!! WELCOME TO GAMEBOX !!"
// 				+ String.format("%18s", "").replace(" ", "-"));

// 		while (play) {
// 			switch (homePage(sc, statusSTB, statusTTT)) {
// 				case 1:
// 					if (statusSTB != "") {
// 						statusSTB = lockStatus(sc, statusSTB);
// 						if (statusSTB == "") {
// 							gameSTB(sc);
// 						}
// 					} else {
// 						gameSTB(sc);
// 					}
// 					break;
// 				case 2:
// 					if (statusTTT != "") {
// 						statusTTT = lockStatus(sc, statusTTT);
// 						if (statusTTT == "") {
// 							gameTTT(sc);
// 						}
// 					} else {
// 						gameTTT(sc);
// 					}
// 					break;
// 				case 3:
// 					gameGTN(sc);
// 					break;
// 				case 4:
// 					gameHGM(sc);
// 					break;
// 				case 5:
// 					gameRPS(sc);
// 					break;
// 				case 6:
// 					play = false;
// 					break;

// 			}
// 		}
// 	}

// 	public static int homePage(Scanner sc, String statusSTB, String statusTTT) {
// 		System.out.println();
// 		System.out.println(String.format("%15s", "") + "     : SELECT A GAME TO PLAY : ");
// 		System.out.println();
// 		System.out.println(String.format("%18s", "") + "1. - SHUT THE BOX ." + statusSTB);
// 		System.out.println(String.format("%18s", "") + "2. - TIC TAC TOE ." + statusTTT);
// 		System.out.println(String.format("%18s", "") + "3. - GUESS THE NUMBER .");
// 		System.out.println(String.format("%18s", "") + "4. - HANG MAN .");
// 		System.out.println(String.format("%18s", "") + "5. - ROCK PAPER SCISSORS .");
// 		System.out.println(String.format("%18s", "") + "6. - TURN OFF GAMEBOX .");
// 		System.out.println("\n");
// 		int num = 0;
// 		while (true) {
// 			System.out.print("  SELECT THE GAME  : ");
// 			String select = sc.nextLine();
// 			if (checkDigit(select, 1, 6, 1)) {
// 				num = Integer.parseInt(select);
// 				break;
// 			} else {
// 				System.out.println("\n" + String.format("%20s", "") + "  !! CHOOSE A VALID OPTION !!\n");
// 			}
// 		}

// 		return num;
// 	}

// 	public static String lockStatus(Scanner sc, String status) {
// 		if (status != "") {
// 			while (true) {
// 				System.out.print("\n  ENTER THE PASSCODE OR ENTER EXIT TO GO BACK TO THE HOME PAGE .\n  --> ");
// 				String passcode = sc.nextLine();
// 				if (passcode.compareToIgnoreCase("exit") == 0) {
// 					return " (LOCKED)";
// 				}
// 				if (passcode.compareTo("1202") == 0) {
// 					return "";
// 				}
// 				if (!checkDigit(passcode, 0, 9, 4)) {
// 					System.out.println(
// 							String.format("%10s", "") + "\n  !! PASSCODE ONLY CONTAINS 4 DIGIT !! \n  !! TRY AGAIN !!");
// 					continue;
// 				} else {
// 					System.out.println("\n  INCORRECT PASSCODE !\n  !! TRY AGAIN !! ");
// 				}
// 			}
// 		}
// 		return "";
// 	}

// 	public static boolean checkDigit(String str, int start, int end, int length) {
// 		if (str.length() != length) {
// 			return false;
// 		}
// 		for (int i = 0; i < str.length(); i++) {
// 			if (str.charAt(i) < 48 || str.charAt(i) > 58) {
// 				return false;
// 			}
// 		}
// 		int num = Integer.parseInt(str);
// 		for (int i = 0; i < str.length(); i++) {
// 			int temp = num % 10;
// 			if (temp < start || temp > end) {
// 				return false;
// 			}
// 			num /= 10;
// 		}
// 		return true;
// 	}

// 	// --------------------------------------------------------------------------------------------------
// 	// ----------------------------------------SHUT THE
// 	// BOX----------------------------------------------
// 	// --------------------------------------------------------------------------------------------------

// 	public static void gameSTB(Scanner sc) {
// 		String[][] gameBoard = { { " 1 ", " | ", " 2 ", " | ", " 3 " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ " 4 ", " | ", " 5 ", " | ", " 6 " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ " 7 ", " | ", " 8 ", " | ", " 9 " } };

// 		System.out.println("\n\n  " + String.format("%60s", "").replace(" ", "-"));
// 		System.out.println(String.format("%40s", ": SHUT THE BOX :"));
// 		System.out.println("  " + String.format("%60s", "").replace(" ", "-") + "\n\n");

// 		System.out.println(
// 				"  THE AIM OF THE GAME IS TO SELECT THE NUMBERS AVAILABLE SO\n  THAT THE TOTAL ADDITION OF THE SELECTED NUMBERS IS EQUAL TO \n  THE NUMBER EQUAL TO NUMBERS ON DICE . IF ALL THE NUMBERS ARE \n  USED , YOU WIN .");
// 		System.out.println("\n" + String.format("%42s", "GOOD LUCK!"));
// 		boolean play = true;
// 		// int dice1 = 0 , dice2 = 0 ;
// 		while (play) {
// 			int dice1 = 1 + (int) (Math.random() * 6);
// 			int dice2 = 1 + (int) (Math.random() * 6);
// 			// dice2++;
// 			boolean next = true;
// 			while (next) {
// 				printGameBoard(gameBoard, dice1, dice2);
// 				boolean change = true;
// 				int sum = 0;
// 				System.out.println("  ENTER DIGITS 1 TO 9 : ");
// 				System.out.print("  --> ");
// 				String inp = sc.nextLine();
// 				System.out.println();
// 				String[] number = (inp.trim()).split(" ");
// 				for (String num : number) {
// 					if (checkDigit(num, 1, 9, 1)) {
// 						if (!(checkGameBoard(num, gameBoard))) {
// 							System.out.println("  " + num + " IS ALREADY USED .");
// 							change = false;
// 						} else {
// 							sum += Integer.parseInt(num);
// 						}
// 					} else {
// 						System.out.println("  INVALID INPUT");
// 						System.out.println("  ENTER DIGITS FROM 1 TO 9 .");
// 						change = false;
// 						break;
// 					}
// 				}
// 				if (change) {
// 					next = false;
// 					if (sum == (dice1 + dice2)) {
// 						for (String num : number) {
// 							gameBoard = changeGameBoard(num, gameBoard);
// 						}
// 						if (checkVictory(gameBoard)) {
// 							System.out.println("  !! CONGRATULATION YOU WON !!");
// 							System.out.println("  THANKS FOR PLAYING\n");
// 							System.out.println("  DO YOU WANT TO PLAY AGAIN ? (Y/N) ");
// 							boolean playAgainWIN = true;
// 							while (playAgainWIN) {
// 								System.out.print("  --> ");
// 								String s = sc.nextLine();
// 								if (s.compareToIgnoreCase("Y") == 0) {
// 									gameBoard = resetGameBoard();
// 									playAgainWIN = false;
// 								} else if (s.compareToIgnoreCase("N") == 0) {
// 									playAgainWIN = false;
// 									play = false;
// 								} else {
// 									System.out.println("\n  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .\n");
// 								}
// 							}
// 						}
// 					} else {
// 						boolean playAgain = true;
// 						System.out.println("  GAME OVER!");
// 						System.out.println("  THANKS FOR PLAYING!\n");
// 						while (playAgain) {
// 							System.out.println("  DO YOU WANT TO PLAY AGAIN ? (Y/N) ");
// 							System.out.print("  --> ");
// 							String s = sc.nextLine();
// 							if (s.compareToIgnoreCase("Y") == 0) {
// 								gameBoard = resetGameBoard();
// 								playAgain = false;
// 							} else if (s.compareToIgnoreCase("N") == 0) {
// 								playAgain = false;
// 								play = false;
// 							} else {
// 								System.out.println("\n  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .\n");
// 							}
// 						}
// 					}
// 				}
// 			}
// 		}
// 	}

// 	public static void printGameBoard(String[][] gameBoard, int dice1, int dice2) {
// 		System.out.println();
// 		for (String[] row : gameBoard) {
// 			System.out.print(String.format("%30s", " "));
// 			for (String col : row) {
// 				System.out.print(col);
// 			}
// 			System.out.println();
// 		}
// 		String s = "| " + dice1 + " |  | " + dice2 + " |  =  | " + (dice1 + dice2) + " |";
// 		System.out.println();
// 		if (dice1 + dice2 < 10) {
// 			System.out.println();
// 			System.out.println(String.format("%48s", "+---+  +---+     +---+"));
// 			System.out.println(String.format("%48s", s));
// 			System.out.println(String.format("%48s", "+---+  +---+     +---+"));
// 			System.out.println(String.format("%48s", "DICE 1  DICE 2    TOTAL"));
// 		} else {
// 			System.out.println(String.format("%48s", "+---+  +---+     +----+"));
// 			System.out.println(String.format("%48s", s));
// 			System.out.println(String.format("%48s", "+---+  +---+     +----+"));
// 			System.out.println(String.format("%47s", "DICE 1  DICE 2    TOTAL"));
// 		}
// 		System.out.println();
// 	}

// 	public static boolean checkGameBoard(String num, String[][] gameBoard) {
// 		switch (Integer.parseInt(num)) {
// 			case 1:
// 				if (gameBoard[0][0] == " 1 ") {
// 					return true;
// 				}
// 				return false;
// 			case 2:
// 				if (gameBoard[0][2] == " 2 ") {
// 					return true;
// 				}
// 				return false;
// 			case 3:
// 				if (gameBoard[0][4] == " 3 ") {
// 					return true;
// 				}
// 				return false;
// 			case 4:
// 				if (gameBoard[2][0] == " 4 ") {
// 					return true;
// 				}
// 				return false;
// 			case 5:
// 				if (gameBoard[2][2] == " 5 ") {
// 					return true;
// 				}
// 				return false;
// 			case 6:
// 				if (gameBoard[2][4] == " 6 ") {
// 					return true;
// 				}
// 				return false;
// 			case 7:
// 				if (gameBoard[4][0] == " 7 ") {
// 					return true;
// 				}
// 				return false;
// 			case 8:
// 				if (gameBoard[4][2] == " 8 ") {
// 					return true;
// 				}
// 				return false;
// 			case 9:
// 				if (gameBoard[4][4] == " 9 ") {
// 					return true;
// 				}
// 				return false;
// 		}
// 		return false;
// 	}

// 	public static String[][] changeGameBoard(String num, String[][] gameBoard) {
// 		switch (Integer.parseInt(num)) {
// 			case 1:
// 				gameBoard[0][0] = " X ";
// 				return gameBoard;
// 			case 2:
// 				gameBoard[0][2] = " X ";
// 				return gameBoard;
// 			case 3:
// 				gameBoard[0][4] = " X ";
// 				return gameBoard;
// 			case 4:
// 				gameBoard[2][0] = " X ";
// 				return gameBoard;
// 			case 5:
// 				gameBoard[2][2] = " X ";
// 				return gameBoard;
// 			case 6:
// 				gameBoard[2][4] = " X ";
// 				return gameBoard;
// 			case 7:
// 				gameBoard[4][0] = " X ";
// 				return gameBoard;
// 			case 8:
// 				gameBoard[4][2] = " X ";
// 				return gameBoard;
// 			case 9:
// 				gameBoard[4][4] = " X ";
// 				return gameBoard;
// 		}
// 		return gameBoard;
// 	}

// 	public static boolean checkVictory(String[][] gameBoard) {
// 		boolean win = true;
// 		for (int i = 0; i < 5; i += 2) {
// 			for (int j = 0; j < 5; j += 2) {
// 				if (!(gameBoard[i][j] == " X ")) {
// 					win = false;
// 				}
// 			}
// 		}
// 		return win;
// 	}

// 	public static String[][] resetGameBoard() {
// 		String[][] gameBoard = { { " 1 ", " | ", " 2 ", " | ", " 3 " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ " 4 ", " | ", " 5 ", " | ", " 6 " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ " 7 ", " | ", " 8 ", " | ", " 9 " } };
// 		return gameBoard;
// 	}

// 	// ------------------------------------------------------------------------------------------------
// 	// ------------------------------------------TIC TAC
// 	// TOE-------------------------------------------
// 	// ------------------------------------------------------------------------------------------------

// 	public static void gameTTT(Scanner sc) {
// 		String[][] gameBoard = { { "   ", " | ", "   ", " | ", "   " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ "   ", " | ", "   ", " | ", "   " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ "   ", " | ", "   ", " | ", "   " } };
// 		boolean play = true;
// 		System.out.println("\n\n  " + String.format("%60s", "").replace(" ", "-"));
// 		System.out.println(String.format("%40s", ": TIC-TAC-TOE :"));
// 		System.out.println("  " + String.format("%60s", "").replace(" ", "-") + "\n");
// 		System.out.println("\n " + String.format("%40s", "HOW TO INPUT " + "\n"));
// 		System.out.println(String.format("%38s", " 1 | 2 | 3 "));
// 		System.out.println(String.format("%38s", "---+---+---"));
// 		System.out.println(String.format("%38s", " 4 | 5 | 6 "));
// 		System.out.println(String.format("%38s", "---+---+---"));
// 		System.out.println(String.format("%38s", " 7 | 8 | 9 "));
// 		while (play) {
// 			int choice = 0 + (int) (Math.random() * 2);
// 			String symbolUser, symbolAI;
// 			System.out.println("\n  CHOOSE A SYMBOL : ");
// 			System.out.println("  ENTER 1 FOR 'X'");
// 			System.out.println("  ENTER 2 FOR 'O'");
// 			String symbol;
// 			while (true) {
// 				System.out.print("  --> ");
// 				symbol = sc.nextLine();
// 				if (checkDigit(symbol, 1, 2, 1)) {
// 					break;
// 				} else {
// 					System.out.println("\n  CHOOSE A VALID OPTION !\n");
// 				}
// 			}
// 			int n = Integer.parseInt(symbol);
// 			if (n == 1) {
// 				symbolUser = "X";
// 				symbolAI = "O";
// 			} else {
// 				symbolUser = "O";
// 				symbolAI = "X";
// 			}
// 			boolean next = true;
// 			int i = 1;
// 			printGameBoard(gameBoard);
// 			while (i < 10) {
// 				boolean change = true;
// 				if (choice == 0) {
// 					System.out.println("\n  YOUR TURN\n");
// 					gameBoard = playUser(sc, gameBoard, symbolUser);
// 					choice = 1;
// 				} else {
// 					System.out.println("\n  COMPUTERS TURN\n");
// 					gameBoard = playAI(gameBoard, symbolAI);
// 					choice = 0;
// 				}
// 				printGameBoard(gameBoard);
// 				if (checkWin(gameBoard, symbolUser)) {
// 					System.out.println("\n\n  CONGRATULATIONS . YOU WON !!\n");
// 					break;
// 				}
// 				if (checkWin(gameBoard, symbolAI)) {
// 					System.out.println("\n\n  OOPS THE COMPUTER WON !! . YOU LOSE!!\n");
// 					break;
// 				}
// 				if (i == 9) {
// 					System.out.println("\n\n  DRAW !\n");
// 				}
// 				i++;
// 			}
// 			boolean playAgain = true;
// 			while (playAgain) {
// 				System.out.println("  DO YOU WANT TO PLAY AGAIN ? (Y/N) ");
// 				System.out.print("  --> ");
// 				String s = sc.nextLine();
// 				if (s.compareToIgnoreCase("Y") == 0) {
// 					gameBoard = resetGameBoardTTT();
// 					playAgain = false;
// 				} else if (s.compareToIgnoreCase("N") == 0) {
// 					playAgain = false;
// 					play = false;
// 				} else {
// 					System.out.println("  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .");
// 				}
// 			}
// 		}
// 		printGameBoard(gameBoard);
// 	}

// 	public static void printGameBoard(String[][] gameBoard) {
// 		System.out.println();
// 		for (String[] row : gameBoard) {
// 			System.out.print(String.format("%30s", " "));
// 			for (String col : row) {
// 				System.out.print(col);
// 			}
// 			System.out.println();
// 		}
// 	}

// 	public static boolean checkInputTTT(String num) {
// 		if (num.length() != 1) {
// 			return false;
// 		}
// 		if (checkDigit(num, 1, 9, 1)) {
// 			if (Integer.parseInt(num) > 0 && Integer.parseInt(num) < 10) {
// 				return true;
// 			}
// 		}
// 		return false;
// 	}

// 	public static String[][] playAI(String[][] gameBoard, String symbolAI) {
// 		boolean AI = true;
// 		while (AI) {
// 			int position = 1 + (int) (Math.random() * 9);
// 			switch (position) {
// 				case 1:
// 					if (gameBoard[0][0] == "   ") {
// 						gameBoard[0][0] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 2:
// 					if (gameBoard[0][2] == "   ") {
// 						gameBoard[0][2] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 3:
// 					if (gameBoard[0][4] == "   ") {
// 						gameBoard[0][4] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 4:
// 					if (gameBoard[2][0] == "   ") {
// 						gameBoard[2][0] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 5:
// 					if (gameBoard[2][2] == "   ") {
// 						gameBoard[2][2] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 6:
// 					if (gameBoard[2][4] == "   ") {
// 						gameBoard[2][4] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 7:
// 					if (gameBoard[4][0] == "   ") {
// 						gameBoard[4][0] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 8:
// 					if (gameBoard[4][2] == "   ") {
// 						gameBoard[4][2] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 				case 9:
// 					if (gameBoard[4][4] == "   ") {
// 						gameBoard[4][4] = " " + symbolAI + " ";
// 						return gameBoard;
// 					}
// 					break;
// 			}
// 		}
// 		return gameBoard;
// 	}

// 	public static boolean checkGameBoardTTT(String[][] gameBoard, String position) {
// 		switch (Integer.parseInt(position)) {
// 			case 1:
// 				if (gameBoard[0][0] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 2:
// 				if (gameBoard[0][2] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 3:
// 				if (gameBoard[0][4] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 4:
// 				if (gameBoard[2][0] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 5:
// 				if (gameBoard[2][2] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 6:
// 				if (gameBoard[2][4] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 7:
// 				if (gameBoard[4][0] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 8:
// 				if (gameBoard[4][2] == "   ") {
// 					return true;
// 				}
// 				return false;
// 			case 9:
// 				if (gameBoard[4][4] == "   ") {
// 					return true;
// 				}
// 				return false;
// 		}
// 		return false;
// 	}

// 	public static String[][] changeGameBoardTTT(String[][] gameBoard, String position, String symbolUser) {
// 		switch (Integer.parseInt(position)) {
// 			case 1:
// 				if (gameBoard[0][0] == "   ") {
// 					gameBoard[0][0] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 2:
// 				if (gameBoard[0][2] == "   ") {
// 					gameBoard[0][2] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 3:
// 				if (gameBoard[0][4] == "   ") {
// 					gameBoard[0][4] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 4:
// 				if (gameBoard[2][0] == "   ") {
// 					gameBoard[2][0] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 5:
// 				if (gameBoard[2][2] == "   ") {
// 					gameBoard[2][2] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 6:
// 				if (gameBoard[2][4] == "   ") {
// 					gameBoard[2][4] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 7:
// 				if (gameBoard[4][0] == "   ") {
// 					gameBoard[4][0] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 8:
// 				if (gameBoard[4][2] == "   ") {
// 					gameBoard[4][2] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 			case 9:
// 				if (gameBoard[4][4] == "   ") {
// 					gameBoard[4][4] = " " + symbolUser + " ";
// 					return gameBoard;
// 				}
// 		}
// 		return gameBoard;
// 	}

// 	public static String[][] playUser(Scanner sc, String[][] gameBoard, String symbolUser) {
// 		boolean userTurn = true;
// 		while (userTurn) {
// 			System.out.print("  SELECT THE POSTION : ");
// 			String position = (sc.nextLine()).trim();
// 			if (checkDigit(position, 1, 9, 1)) {
// 				if (checkInputTTT(position)) {
// 					if (checkGameBoardTTT(gameBoard, position)) {
// 						gameBoard = changeGameBoardTTT(gameBoard, position, symbolUser);
// 						userTurn = false;
// 					} else {
// 						System.out.println("\n  " + position + " IS ALREADY TAKEN .\n");
// 						continue;
// 					}
// 				} else {
// 					System.out.println("  SELECT A SINGLE CELL FROM 1 TO 9");
// 					continue;
// 				}
// 			} else {
// 				System.out.println("\n  ONLY DIGITS ARE ALLOWED FROM 1 TO 9 .\n");
// 				continue;
// 			}
// 		}
// 		return gameBoard;
// 	}

// 	public static boolean checkWin(String[][] gameBoard, String symbol) {
// 		if (gameBoard[0][0].compareTo(" " + symbol + " ") == 0 && gameBoard[0][2].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[0][4].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[2][0].compareTo(" " + symbol + " ") == 0 && gameBoard[2][2].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[2][4].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[4][0].compareTo(" " + symbol + " ") == 0 && gameBoard[4][2].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[4][4].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[0][0].compareTo(" " + symbol + " ") == 0 && gameBoard[2][0].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[4][0].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[0][2].compareTo(" " + symbol + " ") == 0 && gameBoard[2][2].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[4][2].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[0][4].compareTo(" " + symbol + " ") == 0 && gameBoard[2][4].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[4][4].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[0][0].compareTo(" " + symbol + " ") == 0 && gameBoard[2][2].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[4][4].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		if (gameBoard[0][4].compareTo(" " + symbol + " ") == 0 && gameBoard[2][2].compareTo(" " + symbol + " ") == 0
// 				&& gameBoard[4][0].compareTo(" " + symbol + " ") == 0) {
// 			return true;
// 		}
// 		return false;
// 	}

// 	public static String[][] resetGameBoardTTT() {
// 		String[][] gameBoard = { { "   ", " | ", "   ", " | ", "   " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ "   ", " | ", "   ", " | ", "   " }, { "---", "-+-", "---", "-+-", "---" },
// 				{ "   ", " | ", "   ", " | ", "   " } };
// 		return gameBoard;
// 	}

// 	// ----------------------------------------------------------------------------------------------------------
// 	// ------------------------------------------GUESS THE
// 	// NUMBER------------------------------------------------
// 	// ----------------------------------------------------------------------------------------------------------

// 	public static void gameGTN(Scanner sc) {
// 		System.out.println("\n\n  " + String.format("%60s", "").replace(" ", "-"));
// 		System.out.printf(String.format("%22s", "") + ": GUESS THE NUMBER :%n");
// 		System.out.println("  " + String.format("%60s", "").replace(" ", "-") + "\n");
// 		System.out.println("  GUESS THE NUMBER RANGING FROM 1 TO 100 . ");
// 		System.out.printf("  YOU HAVE 10 TRIES .%n%n%n");
// 		String input;
// 		while (true) {
// 			System.out.println("  ENTER \"1\" TO START THE GAME OR \"2\" TO EXIT THE GAME .");
// 			System.out.print("  --> ");
// 			input = sc.nextLine();
// 			if (checkDigit(input, 1, 2, 1)) {
// 				break;
// 			} else {
// 				System.out.println("\n  CHOOSE A CORRECT OPTION!!\n");
// 			}
// 		}
// 		int n = Integer.parseInt(input);
// 		boolean play = true;
// 		while (play) {
// 			switch (n) {
// 				case 1:
// 					int number = 1 + (int) (Math.random() * 100);
// 					int i = 1;
// 					System.out.println(String.format("%40s", "+------------------+"));
// 					System.out.println(String.format("%40s", "| !!GAME STARTED!! |"));
// 					System.out.println(String.format("%40s", "+------------------+"));
// 					while (i < 11) {
// 						System.out.println();
// 						String guessinp;
// 						while (true) {
// 							System.out.print("  ENTER YOUR GUESS : ");
// 							guessinp = sc.nextLine();
// 							if (checkDigit(guessinp, 0, 9, 1) || checkDigit(guessinp, 0, 9, 2)
// 									|| checkDigit(guessinp, 0, 9, 3)) {
// 								if (Integer.parseInt(guessinp) < 101 && Integer.parseInt(guessinp) > 0) {
// 									break;
// 								} else {
// 									System.out.println("\n  ENTER NUMBERS BETWEEN 1 AND 100\n");
// 								}
// 							} else {
// 								System.out.println("\n  INVALID INPUT!\n");
// 							}
// 						}
// 						int guess = Integer.parseInt(guessinp);
// 						System.out.println();
// 						if (guess != number) {
// 							if (guess - number <= 10 && guess - number > 0) {
// 								System.out.println("  YOUR GUESS IS SLIGHTLY HIGHER .");
// 							} else if (guess - number <= 40 && guess - number > 10) {
// 								System.out.println("  YOUR GUESS IS HIGHER .");
// 							} else if (guess - number > 40) {
// 								System.out.println("  YOUR GUESS IS EXTREMELY HIGHER .");
// 							} else if (guess - number > -10 && guess - number < 0) {
// 								System.out.println("  YOUR GUESS IS SLIGHTLY LOWER .");
// 							} else if (guess - number > -40 && guess - number < -10) {
// 								System.out.println("  YOUR GUESS IS LOWER .");
// 							} else if (guess - number < -40) {
// 								System.out.println("  YOUR GUESS IS EXTERMELY LOWER .");
// 							}
// 							System.out.println("  YOU HAVE " + (10 - i++) + " CHANCES LEFT .");
// 							if (i > 10) {
// 								System.out.println(String.format("%43s", "+-----------------------+"));
// 								System.out.println(String.format("%43s", "| !! OOPS , YOU LOSE !! |"));
// 								System.out.println(String.format("%43s", "+-----------------------+"));
// 								break;
// 							}
// 						} else {
// 							System.out.println(String.format("%46s", "+-----------------------------+"));
// 							System.out.println(String.format("%46s", "| !!CONGRATULATIONS YOU WIN!! |"));
// 							System.out.println(String.format("%46s", "+-----------------------------+"));
// 							break;
// 						}
// 					}
// 					boolean playAgain = true;
// 					while (playAgain) {
// 						System.out.printf("%n%n  DO YOU WANT TO PLAY AGAIN ? (Y/N) %n  -->");
// 						String s = sc.nextLine();
// 						if (s.compareToIgnoreCase("Y") == 0) {
// 							playAgain = false;
// 						} else if (s.compareToIgnoreCase("N") == 0) {
// 							playAgain = false;
// 							play = false;
// 						} else {
// 							System.out.println("\n  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .");
// 						}
// 					}
// 					break;
// 				case 2:
// 					play = false;
// 			}
// 		}
// 	}

// 	// ----------------------------------------------------------------------------------------------------------
// 	// ------------------------------------------ROCK PAPER
// 	// SCISSIORS--------------------------------------------
// 	// ----------------------------------------------------------------------------------------------------------

// 	public static void gameRPS(Scanner sc) {
// 		System.out.println("\n\n  " + String.format("%60s", "").replace(" ", "-"));
// 		System.out.printf(String.format("%20s", "") + ": ROCK-PAPER-SCISSORS :%n");
// 		System.out.println("  " + String.format("%60s", "").replace(" ", "-") + "\n");
// 		System.out.println(String.format("%26s", "") + ": SELECT :");
// 		System.out.println(String.format("%5s", "") + "'r' --> 'ROCK' , 'p' --> 'PAPER' , 's' --> 'SCISSORS'\n");
// 		System.out.println(String.format("%15s", "") + "AIM OF THE GAME IS TO GET 3 POINTS.");
// 		boolean play = true;
// 		while (play) {
// 			int userpoint = 0, aipoint = 0;
// 			while (userpoint < 3 && aipoint < 3) {
// 				System.out.print("\n\n  SELECT : ");
// 				String select = sc.nextLine();
// 				if (checkInputRPS(select)) {
// 					String uchoice = "";
// 					String cchoice = "";
// 					if (select.compareToIgnoreCase("r") == 0) {
// 						uchoice = "ROCK";
// 					} else if (select.compareToIgnoreCase("p") == 0) {
// 						uchoice = "PAPER";
// 					} else if (select.compareToIgnoreCase("s") == 0) {
// 						uchoice = "SCISSORS";
// 					}
// 					int compchoice = 1 + (int) (Math.random() * 3);
// 					if (compchoice == 1) {
// 						cchoice = "ROCK";
// 					} else if (compchoice == 2) {
// 						cchoice = "PAPER";
// 					} else if (compchoice == 3) {
// 						cchoice = "SCISSORS";
// 					}
// 					System.out.print("\n" + String.format("%21s", "  YOU CHOSE : ") + uchoice);
// 					System.out.println(String.format("%8s", "") + "COMPUTER CHOSE : " + cchoice);
// 					System.out.print("\n" + String.format("%23s", ""));
// 					if (cchoice.compareTo("ROCK") == 0) {
// 						if (uchoice.compareTo("SCISSORS") == 0) {
// 							System.out.println("  YOU LOSE!");
// 							aipoint++;
// 						} else if (uchoice.compareTo("PAPER") == 0) {
// 							System.out.println("  YOU WIN!");
// 							userpoint++;
// 						} else {
// 							System.out.println("  DRAW GAME!");
// 						}
// 					} else if (cchoice.compareTo("SCISSORS") == 0) {
// 						if (uchoice.compareTo("PAPER") == 0) {
// 							System.out.println("  YOU LOSE!");
// 							aipoint++;
// 						} else if (uchoice.compareTo("ROCK") == 0) {
// 							System.out.println("  YOU WIN!");
// 							userpoint++;
// 						} else {
// 							System.out.println("  DRAW GAME!");
// 						}
// 					} else if (cchoice.compareTo("PAPER") == 0) {
// 						if (uchoice.compareTo("ROCK") == 0) {
// 							System.out.println("  YOU LOSE!");
// 							aipoint++;
// 						} else if (uchoice.compareTo("SCISSORS") == 0) {
// 							System.out.println("  YOU WIN!");
// 							userpoint++;
// 						} else {
// 							System.out.println(" DRAW GAME!");
// 						}
// 					}
// 					System.out.println();
// 					System.out.println(String.format("%10s", "") + "YOUR SCORE : " + userpoint
// 							+ String.format("%10s", "") + "COMPUTER SCORE : " + aipoint + "\n");
// 				} else {
// 					System.out.println("\n  INVALID INPUT , SELECT 'R' , 'P' OR 'S' .");
// 				}
// 				if (userpoint == 3) {
// 					System.out.println("  !! CONGRATULATIONS YOU WON !!");
// 				} else if (aipoint == 3) {
// 					System.out.println("  !! THE COMPUTER WON , YOU LOSE  !!");
// 				}
// 			}
// 			boolean playAgain = true;
// 			while (playAgain) {
// 				System.out.println("\n  DO YOU WANT TO PLAY AGAIN ? (Y/N) ");
// 				System.out.print("  -->");
// 				String s = sc.nextLine();
// 				if (s.compareToIgnoreCase("Y") == 0) {
// 					playAgain = false;
// 				} else if (s.compareToIgnoreCase("N") == 0) {
// 					playAgain = false;
// 					play = false;
// 				} else {
// 					System.out.println("  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .");
// 				}
// 			}
// 		}
// 	}

// 	public static boolean checkInputRPS(String num) {
// 		if (num.length() != 1) {
// 			return false;
// 		}
// 		if (num.compareToIgnoreCase("r") == 0 || num.compareToIgnoreCase("p") == 0
// 				|| num.compareToIgnoreCase("s") == 0) {
// 			return true;
// 		}
// 		return false;
// 	}

// 	// ----------------------------------------------------------------------------------------------------------
// 	// -----------------------------------------------HANGMAN----------------------------------------------------
// 	// ----------------------------------------------------------------------------------------------------------

// 	public static void gameHGM(Scanner sc) throws Exception {
// 		System.out.println("\n\n  " + String.format("%60s", "").replace(" ", "-"));
// 		System.out.printf(String.format("%27s", "") + ": HANGMAN :%n");
// 		System.out.println("  " + String.format("%60s", "").replace(" ", "-") + "\n");
// 		FileReader fr = new FileReader("words.txt");
// 		BufferedReader br = new BufferedReader(fr);
// 		String[] words = new String[84];
// 		String temp;
// 		int itr = 0;
// 		while ((temp = br.readLine()) != null) {
// 			words[itr] = temp;
// 			itr++;
// 		}
// 		boolean play = true;
// 		while (play) {
// 			String[] letters = new String[99];
// 			int n = 0 + (int) (Math.random() * 84);
// 			String word = words[n];
// 			int wordLength = wordLength(word);

// 			// System.out.println(" "+word);

// 			itr = 0;
// 			int j = 0;
// 			int k = 0;
// 			String guesses[] = new String[99];
// 			while (true) {
// 				if (itr >= 0) {
// 					System.out.println("   ______");
// 					System.out.println("  /     |");
// 				}
// 				if (itr >= 1) {
// 					System.out.println("  |     O");
// 				} else {
// 					System.out.println("  |");
// 				}
// 				if (itr >= 2) {
// 					if (itr == 2) {
// 						System.out.println("  |     |");
// 					}
// 					if (itr == 3) {
// 						System.out.println("  |    \\|");
// 					}
// 					if (itr >= 4) {
// 						System.out.println("  |    \\|/");
// 					}
// 				} else {
// 					System.out.println("  |");
// 				}
// 				if (itr >= 5) {
// 					System.out.print("  |     |");
// 					System.out.print(String.format("%21s", ""));
// 					for (int i = 0; i < word.length(); i++) {
// 						if (contains(letters, word.charAt(i))) {
// 							System.out.print(Character.toString(word.charAt(i)).toUpperCase());
// 						} else {
// 							System.out.print("_");
// 						}
// 					}
// 					System.out.println();
// 				} else {
// 					System.out.print("  |");
// 					System.out.print(String.format("%21s", ""));
// 					for (int i = 0; i < word.length(); i++) {
// 						if (contains(letters, word.charAt(i))) {
// 							System.out.print(Character.toString(word.charAt(i)).toUpperCase());
// 						} else {
// 							System.out.print("_");
// 						}
// 					}
// 					System.out.println();
// 				}
// 				if (itr >= 6) {
// 					if (itr == 6) {
// 						System.out.println("  |    /");
// 					}
// 					if (itr == 7) {
// 						System.out.println("  |     / \\");
// 					}
// 				} else {
// 					System.out.println("  |");
// 				}

// 				System.out.print("\n\n\n");
// 				String guess;
// 				while (true) {
// 					System.out.print("  ENTER YOUR GUESS : ");
// 					guess = sc.nextLine();
// 					if (checkInputHMG(guess)) {
// 						break;
// 					} else {
// 						System.out.println("\n  !!  INVALID INPUT ENTER A SINGLE CHARACTER !!\n");
// 						continue;
// 					}
// 				}
// 				if (alreadyPresent(guesses, guess) || alreadyPresent(letters, guess)) {
// 					System.out.println("\n  YOU ALREADY GUESSED THIS LETTER !\n");
// 					continue;
// 				} else if (present(word, guess)) {
// 					System.out.println("\n  !! CORRECT GUESS !!\n");
// 				} else {
// 					System.out.println("\n  !! INCORRECT GUESS !!\n");
// 					itr++;
// 					System.out.println("  LIVES remaining = " + (7 - itr) + "\n");
// 					if (itr == 7) {
// 						System.out.println("  YOU LOSE !");
// 						System.out.println("  THE WORD WAS : " + word);
// 						boolean playAgain = true;
// 						while (playAgain) {
// 							System.out.println("\n  DO YOU WANT TO PLAY AGAIN ? (Y/N) ");
// 							System.out.print("  --> ");
// 							String s = sc.nextLine();
// 							if (s.compareToIgnoreCase("Y") == 0) {
// 								playAgain = false;
// 							} else if (s.compareToIgnoreCase("N") == 0) {
// 								playAgain = false;
// 								play = false;
// 							} else {
// 								System.out.println("  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .");
// 							}
// 						}
// 						break;
// 					}
// 					guesses[k] = guess;
// 					continue;
// 				}
// 				letters[j] = guess;
// 				j++;

// 				if (checkWin(letters, wordLength)) {
// 					System.out.print(String.format("%30s", ""));
// 					for (int i = 0; i < word.length(); i++) {
// 						if (contains(letters, word.charAt(i))) {
// 							System.out.print(Character.toString(word.charAt(i)).toUpperCase());
// 						} else {
// 							System.out.print("_");
// 						}
// 					}
// 					System.out.println("\n  !! YOU WIN !!");
// 					boolean playAgain = true;
// 					while (playAgain) {
// 						System.out.println("\n  DO YOU WANT TO PLAY AGAIN ? (Y/N) ");
// 						System.out.print("  --> ");
// 						String s = sc.nextLine();
// 						if (s.compareToIgnoreCase("Y") == 0) {
// 							playAgain = false;
// 						} else if (s.compareToIgnoreCase("N") == 0) {
// 							playAgain = false;
// 							play = false;
// 						} else {
// 							System.out.println("  ENTER \"Y\" TO PLAY AGAIN OR \"N\" TO EXIT .");
// 						}
// 					}
// 					break;
// 				}
// 			}
// 		}
// 	}

// 	public static boolean alreadyPresent(String[] letters, String guess) {
// 		for (String check : letters) {
// 			if (check == null) {
// 				return false;
// 			}
// 			if (check.compareTo(guess) == 0) {
// 				return true;
// 			}
// 		}
// 		return false;
// 	}

// 	public static int wordLength(String word) {
// 		int count = 0;
// 		while (true) {
// 			if (word.compareTo("") == 0) {
// 				return count;
// 			}
// 			count++;
// 			word = word.replace(Character.toString(word.charAt(0)), "");
// 		}
// 	}

// 	public static boolean contains(String[] letters, char c) {
// 		for (int i = 0; i < letters.length && letters[i] != null; i++) {
// 			if (letters[i].compareTo(Character.toString(c)) == 0) {
// 				return true;
// 			}
// 		}
// 		return false;
// 	}

// 	public static boolean present(String word, String s) {
// 		if (s == null) {
// 			return false;
// 		}
// 		for (int i = 0; i < word.length(); i++) {
// 			if (s.compareTo(Character.toString(word.charAt(i))) == 0) {
// 				return true;
// 			}
// 		}
// 		return false;
// 	}

// 	public static boolean checkWin(String[] letters, int wordLenght) {
// 		if (arrayLength(letters) == wordLenght) {
// 			return true;
// 		}
// 		return false;
// 	}

// 	public static int arrayLength(String letters[]) {
// 		int count = 0;
// 		for (String letter : letters) {
// 			if (letter == null) {
// 				return count;
// 			}
// 			count++;
// 		}
// 		return count;
// 	}

// 	public static boolean checkInputHMG(String input) {
// 		if (input.length() != 1) {
// 			return false;
// 		}
// 		if (Character.isLetter(input.charAt(0))) {
// 			return true;
// 		}
// 		return false;
// 	}

// }