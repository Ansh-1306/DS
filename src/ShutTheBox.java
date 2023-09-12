import java.util.Scanner;

public class ShutTheBox {
	Scanner sc = new Scanner(System.in);

	ShutTheBox() throws InterruptedException {
		String[][] gameBoard = { { " 1 ", " | ", " 2 ", " | ", " 3 " }, { "---", "-+-", "---", "-+-", "---" },
				{ " 4 ", " | ", " 5 ", " | ", " 6 " }, { "---", "-+-", "---", "-+-", "---" },
				{ " 7 ", " | ", " 8 ", " | ", " 9 " } };

		System.out.println("\n\n================ ! Welcome to Shut The Box ! ================\n");
		while (true) {
			int dice1 = 1 + (int) (Math.random() * 6);
			int dice2 = 1 + (int) (Math.random() * 6);
			boolean next = true;
			while (next) {
				printGameBoard(gameBoard, dice1, dice2);
				boolean change = true;
				int sum = 0;
				System.out.print("  ENTER DIGITS 1 TO 9 : ");
				String inp = sc.nextLine();
				System.out.println();
				String[] number = (inp.trim()).split(" ");
				for (String num : number) {
					if (checkDigit(num, 1, 9, 1)) {
						if (!(checkGameBoard(num, gameBoard))) {
							System.out.println("  " + num + " IS ALREADY USED .");
							change = false;
						} else {
							sum += Integer.parseInt(num);
						}
					} else {
						System.out.println("  INVALID INPUT\n");
						System.out.println("  ENTER DIGITS FROM 1 TO 9 .");
						change = false;
						break;
					}
				}
				if (change) {
					next = false;
					if (sum == (dice1 + dice2)) {
						for (String num : number) {
							gameBoard = changeGameBoard(num, gameBoard);
						}
						if (checkVictory(gameBoard)) {
							printGameBoard(gameBoard, 0, 0);
							System.out.printf("\n%35s\n", "YOU WON!");
							Thread.sleep(1000);
							return;
						}
					} else {
						printGameBoard(gameBoard, 0, 0);
						System.out.printf("\n%35s\n", "GAME OVER!");
						Thread.sleep(1000);
						return;
					}
				}
			}
		}
	}

	public static void printGameBoard(String[][] gameBoard, int dice1, int dice2) throws InterruptedException {
		System.out.println();
		for (String[] row : gameBoard) {
			System.out.print(String.format("%23s", " "));
			for (String col : row) {
				System.out.print(col);
				Thread.sleep(20);
			}
			System.out.println();
			Thread.sleep(100);
		}
		String s = "| " + dice1 + " |  | " + dice2 + " |  =  | " + (dice1 + dice2) + " |";
		System.out.println();
		if (dice1 == 0) {
			return;
		}
		if (dice1 + dice2 < 10) {
			System.out.println();
			System.out.println(String.format("%41s", "+---+  +---+     +---+"));
			Thread.sleep(50);
			System.out.println(String.format("%41s", s));
			Thread.sleep(50);
			System.out.println(String.format("%41s", "+---+  +---+     +---+"));
			System.out.println(String.format("%41s", "DICE 1  DICE 2    TOTAL"));
		} else {
			System.out.println(String.format("%41s", "+---+  +---+     +----+"));
			Thread.sleep(50);
			System.out.println(String.format("%41s", s));
			Thread.sleep(50);
			System.out.println(String.format("%41s", "+---+  +---+     +----+"));
			System.out.println(String.format("%40s", "DICE 1  DICE 2    TOTAL"));
		}
		System.out.println();
	}

	public static boolean checkGameBoard(String num, String[][] gameBoard) {
		switch (Integer.parseInt(num)) {
			case 1:
				if (gameBoard[0][0] == " 1 ") {
					return true;
				}
				return false;
			case 2:
				if (gameBoard[0][2] == " 2 ") {
					return true;
				}
				return false;
			case 3:
				if (gameBoard[0][4] == " 3 ") {
					return true;
				}
				return false;
			case 4:
				if (gameBoard[2][0] == " 4 ") {
					return true;
				}
				return false;
			case 5:
				if (gameBoard[2][2] == " 5 ") {
					return true;
				}
				return false;
			case 6:
				if (gameBoard[2][4] == " 6 ") {
					return true;
				}
				return false;
			case 7:
				if (gameBoard[4][0] == " 7 ") {
					return true;
				}
				return false;
			case 8:
				if (gameBoard[4][2] == " 8 ") {
					return true;
				}
				return false;
			case 9:
				if (gameBoard[4][4] == " 9 ") {
					return true;
				}
				return false;
		}
		return false;
	}

	public static String[][] changeGameBoard(String num, String[][] gameBoard) {
		switch (Integer.parseInt(num)) {
			case 1:
				gameBoard[0][0] = " X ";
				return gameBoard;
			case 2:
				gameBoard[0][2] = " X ";
				return gameBoard;
			case 3:
				gameBoard[0][4] = " X ";
				return gameBoard;
			case 4:
				gameBoard[2][0] = " X ";
				return gameBoard;
			case 5:
				gameBoard[2][2] = " X ";
				return gameBoard;
			case 6:
				gameBoard[2][4] = " X ";
				return gameBoard;
			case 7:
				gameBoard[4][0] = " X ";
				return gameBoard;
			case 8:
				gameBoard[4][2] = " X ";
				return gameBoard;
			case 9:
				gameBoard[4][4] = " X ";
				return gameBoard;
		}
		return gameBoard;
	}

	public static boolean checkVictory(String[][] gameBoard) {
		for (int i = 0; i < 5; i += 2) {
			for (int j = 0; j < 5; j += 2) {
				if (!(gameBoard[i][j] == " X ")) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checkDigit(String str, int start, int end, int length) {
		if (str.length() != length) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 48 || str.charAt(i) > 58) {
				return false;
			}
		}
		int num = Integer.parseInt(str);
		for (int i = 0; i < str.length(); i++) {
			int temp = num % 10;
			if (temp < start || temp > end) {
				return false;
			}
			num /= 10;
		}
		return true;
	}
}