import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    char[][] board;
    int count = 0;
    static Scanner sc = new Scanner(System.in);
    HashSet<Integer> usermoves = new HashSet<>();
    HashSet<Integer> aimoves = new HashSet<>();

    TicTacToe() throws InterruptedException {
        System.out.println("\n\n================ ! Welcome to Tic Tac Toe ! ================\n");
        board = new char[3][3];
        System.out.printf("%37s\n","-------------");
        System.out.printf("%37s\n","| 1 | 2 | 3 |");
        System.out.printf("%37s\n","-------------");
        System.out.printf("%37s\n","| 4 | 5 | 6 |");
        System.out.printf("%37s\n","-------------");
        System.out.printf("%37s\n","| 7 | 8 | 9 |");
        System.out.printf("%37s\n","-------------");
        initializeBoard();
        printBoard();
        makeMove();
    }

    void initializeBoard() // Initialise the board with space characters
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    void printBoard() throws InterruptedException // Print Board after every move
    {
        System.out.printf("%37s\n","-------------");
        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            System.out.printf("%26s","| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf(board[i][j] + " | ");
                Thread.sleep(100);
            }
            System.out.println();
            System.out.printf("%37s\n","-------------");
        }
        Thread.sleep(100);
    }

    void placeMark(int pos, char mark, String name) throws InterruptedException // Placing mark on board
    {
        if (pos >= 1 && pos <= 9) {
            if (pos == 1)
                board[0][0] = mark;
            else if (pos == 2)
                board[0][1] = mark;
            else if (pos == 3)
                board[0][2] = mark;
            else if (pos == 4)
                board[1][0] = mark;
            else if (pos == 5)
                board[1][1] = mark;
            else if (pos == 6)
                board[1][2] = mark;
            else if (pos == 7)
                board[2][0] = mark;
            else if (pos == 8)
                board[2][1] = mark;
            else
                board[2][2] = mark;
        } else {
            System.out.printf("%20s\n","Invalid Input");
            
        }
        printBoard();
        count++;
        if (checkColWin() || checkRowWin() || checkDiagWin()) {
            System.out.printf("\n%35s\n","YOU LOST!");
            Thread.sleep(200);
            sc.nextLine();
        } else {
            if (name == "Player" && count <= 8) {
                AIMove();
            } else if (name == "Player" && count == 9) {
                System.out.printf("\n%33s\n","DRAW!");
            } else {
                makeMove();
            }
        }
    }
    
    void makeMove() throws InterruptedException // Player Move
    {
        System.out.printf("\n%20s","Enter position : ");
        int pos = sc.nextInt();
        System.out.println();
        if (isValid(pos)) {
            usermoves.add(pos);
            placeMark(pos, 'X', "Player");
        } else {
            System.out.printf("\n%16s\n","Invalid Input");
            makeMove();
        }
    }

    void AIMove() throws InterruptedException // Computer Move
    {
        int pos;
        if (isValid(5)) {
            pos = 5;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(1) && aimoves.contains(2) && isValid(3))
                || (aimoves.contains(7) && aimoves.contains(5) && isValid(3))
                || (aimoves.contains(6) && aimoves.contains(9) && isValid(3))) {
            pos = 3;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(3) && aimoves.contains(2) && isValid(1))
                || (aimoves.contains(9) && aimoves.contains(5) && isValid(1))
                || (aimoves.contains(4) && aimoves.contains(7) && isValid(1))) {
            pos = 1;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(1) && aimoves.contains(4) && isValid(7))
                || (aimoves.contains(3) && aimoves.contains(5) && isValid(7))
                || (aimoves.contains(8) && aimoves.contains(9) && isValid(7))) {
            pos = 7;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(3) && aimoves.contains(6) && isValid(9))
                || (aimoves.contains(1) && aimoves.contains(5) && isValid(9))
                || (aimoves.contains(7) && aimoves.contains(8) && isValid(9))) {
            pos = 9;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(3) && aimoves.contains(1) && isValid(2))
                || (aimoves.contains(8) && aimoves.contains(5) && isValid(2))) {
            pos = 2;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(7) && aimoves.contains(1) && isValid(4))
                || (aimoves.contains(6) && aimoves.contains(5) && isValid(4))) {
            pos = 4;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(3) && aimoves.contains(9) && isValid(6))
                || (aimoves.contains(4) && aimoves.contains(5) && isValid(6))) {
            pos = 6;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((aimoves.contains(7) && aimoves.contains(9) && isValid(8))
                || (aimoves.contains(2) && aimoves.contains(5) && isValid(8))) {
            pos = 8;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(1) && usermoves.contains(2) && isValid(3))
                || (usermoves.contains(7) && usermoves.contains(5) && isValid(3))
                || (usermoves.contains(6) && usermoves.contains(9) && isValid(3))) {
            pos = 3;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(2) && usermoves.contains(3) && isValid(1))
                || (usermoves.contains(4) && usermoves.contains(7) && isValid(1))
                || (usermoves.contains(5) && usermoves.contains(9) && isValid(1))) {
            pos = 1;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(1) && usermoves.contains(4) && isValid(7))
                || (usermoves.contains(8) && usermoves.contains(9) && isValid(7))
                || (usermoves.contains(5) && usermoves.contains(3) && isValid(7))) {
            pos = 7;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(7) && usermoves.contains(8) && isValid(9))
                || (usermoves.contains(6) && usermoves.contains(3) && isValid(9))
                || (usermoves.contains(5) && usermoves.contains(1) && isValid(9))) {
            pos = 9;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(1) && usermoves.contains(3) && isValid(2))
                || (usermoves.contains(8) && usermoves.contains(5) && isValid(2))) {
            pos = 2;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(1) && usermoves.contains(7) && isValid(4))
                || (usermoves.contains(6) && usermoves.contains(5) && isValid(4))) {
            pos = 4;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(9) && usermoves.contains(3) && isValid(6))
                || (usermoves.contains(4) && usermoves.contains(5) && isValid(6))) {
            pos = 6;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(7) && usermoves.contains(9) && isValid(8))
                || (usermoves.contains(2) && usermoves.contains(5) && isValid(8))) {
            pos = 8;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if ((usermoves.contains(7) && usermoves.contains(3) && isValid(2))
                || (usermoves.contains(1) && usermoves.contains(9) && isValid(2))) {
            pos = 2;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else if (usermoves.contains(5) && (isValid(1) || (isValid(3)) || (isValid(7)) || (isValid(9)))) {
            Random random = new Random();
            int t;
            while (!isValid(t = (random.nextInt(5) * 2) + 1)) {
            }
            pos=t;
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        } else {
            Random random = new Random();
            while (!isValid(pos = random.nextInt(9) + 1)) {
            }
            aimoves.add(pos);
            placeMark(pos, 'O', "Computer");
        }

    }

    boolean isValid(int pos) // Check if the move is valid
    {
        if (!(usermoves.contains(pos) || aimoves.contains(pos))) {
            if (pos < 10 && pos > 0)
                return true;
        }
        return false;
    }

    boolean checkColWin() // Check column win
    {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        return false;
    }

    boolean checkRowWin() // Check row win
    {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagWin() // Check diagonal win
    {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

}