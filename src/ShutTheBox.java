import java.util.Scanner;

public class ShutTheBox {
	Scanner sc = new Scanner(System.in);

	ShutTheBox()  {
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
				//this loop for checking valid user inputs.
				for (String num : number) {
					if (checkDigit(num, 1, 9, 1)) {
						if (!(checkGameBoard(num, gameBoard))) {
							//slot available then else condition. not available then if.
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
				//logic to check if user input satisfies game condition.
				if (change) {
					next = false;
					if (sum == (dice1 + dice2)) {
						//user input satisfies condition then if or else(game over).
						for (String num : number) {
							//make unavailable the number used.
                            changeGameBoard(num, gameBoard);
                        }
						if (checkVictory(gameBoard)) {
							printGameBoard(gameBoard, 0, 0);
							//dice are 0 so only gameboard part will be printed.
							System.out.printf("\n%35s\n", "YOU WON!");
							
							return;
						}
					} else {
						printGameBoard(gameBoard, 0, 0);
						System.out.printf("\n%35s\n", "GAME OVER!");
						
						return;
					}
				}
			}
		}
	}

	public static void printGameBoard(String[][] gameBoard, int dice1, int dice2) {
		System.out.println();
		for (String[] row : gameBoard) {
			System.out.printf("%23s", " ");
			for (String col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
		String s = "| " + dice1 + " |  | " + dice2 + " |  =  | " + (dice1 + dice2) + " |";
		System.out.println();
		if (dice1 == 0) {
			return;
		}
		//above code only prints Matrix
		if (dice1 + dice2 < 10) {
			System.out.println();
			System.out.printf("%41s%n", "+---+  +---+     +---+");
			System.out.printf("%41s%n", s);
			System.out.printf("%41s%n", "+---+  +---+     +---+");
			System.out.printf("%41s%n", "DICE 1  DICE 2    TOTAL");
		} else {
			System.out.printf("%41s%n", "+---+  +---+     +----+");
			System.out.printf("%41s%n", s);
			System.out.printf("%41s%n", "+---+  +---+     +----+");
			System.out.printf("%40s%n", "DICE 1  DICE 2    TOTAL");
		}
		System.out.println();
		//code till here prints matrix + dice.
	}

	public static boolean checkGameBoard(String num, String[][] gameBoard) {
		//check number in board available?
		switch (Integer.parseInt(num)) {
			case 1:
                return gameBoard[0][0] == " 1 ";
            case 2:
                return gameBoard[0][2] == " 2 ";
            case 3:
                return gameBoard[0][4] == " 3 ";
            case 4:
                return gameBoard[2][0] == " 4 ";
            case 5:
                return gameBoard[2][2] == " 5 ";
            case 6:
                return gameBoard[2][4] == " 6 ";
            case 7:
                return gameBoard[4][0] == " 7 ";
            case 8:
                return gameBoard[4][2] == " 8 ";
            case 9:
                return gameBoard[4][4] == " 9 ";
        }
		return false;
	}

	public static void changeGameBoard(String num, String[][] gameBoard) {
		//change used num to X.
		switch (Integer.parseInt(num)) {
			case 1:
				gameBoard[0][0] = " X ";
				return;
			case 2:
				gameBoard[0][2] = " X ";
				return;
			case 3:
				gameBoard[0][4] = " X ";
				return;
			case 4:
				gameBoard[2][0] = " X ";
				return;
			case 5:
				gameBoard[2][2] = " X ";
				return;
			case 6:
				gameBoard[2][4] = " X ";
				return;
			case 7:
				gameBoard[4][0] = " X ";
				return;
			case 8:
				gameBoard[4][2] = " X ";
				return;
			case 9:
				gameBoard[4][4] = " X ";
		}
	}

	public static boolean checkVictory(String[][] gameBoard) {
		//if all X->win or lose.
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
				//return false if num out of range 1-9.
				return false;
			}
		}
		int num = Integer.parseInt(str);
		for (int i = 0; i < str.length(); i++) {
			int temp = num % 10;
			if (temp < start || temp > end) {
				//return false if num out of range 1-9.
				return false;
			}
			num /= 10;
		}
		return true;
	}
}