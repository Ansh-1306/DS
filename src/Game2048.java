import java.util.Random;
import java.util.Scanner;

class Game2048 {
    private static final int SIZE = 4;
    private final int[][] board;
    private final Random random;
    private boolean gameOver;

    public Game2048() throws InterruptedException {
        System.out.println("\n\n===================== !    2048    ! =====================\n");

        board = new int[SIZE][SIZE];
        random = new Random();
        gameOver = false;
        addRandomTile();
        addRandomTile();
        playGame();
    }

    private void addRandomTile() {
        int value = (random.nextInt(2) + 1) * 2; // Generate a 2 or 4
        int row, col;

        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (board[row][col] != 0);

        board[row][col] = value;
    }

    private void printBoard() throws InterruptedException {
        for (int[] row : board) {
            System.out.printf("%17s", " ");
            for (int cell : row) {
                System.out.printf("%5d", cell);
            }
            Thread.sleep(100);
            System.out.println();
        }
        System.out.println();
    }

    private void moveLeft() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 1; col < SIZE; col++) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int targetCol = col;

                    while (targetCol > 0 && board[row][targetCol - 1] == 0) {
                        board[row][targetCol - 1] = value;
                        board[row][targetCol] = 0;
                        targetCol--;
                    }

                    if (targetCol > 0 && board[row][targetCol - 1] == value) {
                        board[row][targetCol - 1] *= 2;
                        board[row][targetCol] = 0;
                    }
                }
            }
        }
    }

    private void moveRight() {
        // Similar logic to moveLeft, but in the opposite direction (right to left)
        for (int row = 0; row < SIZE; row++) {
            for (int col = SIZE - 2; col >= 0; col--) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int targetCol = col;

                    while (targetCol < SIZE - 1 && board[row][targetCol + 1] == 0) {
                        board[row][targetCol + 1] = value;
                        board[row][targetCol] = 0;
                        targetCol++;
                    }

                    if (targetCol < SIZE - 1 && board[row][targetCol + 1] == value) {
                        board[row][targetCol + 1] *= 2;
                        board[row][targetCol] = 0;
                    }
                }
            }
        }
    }

    private void moveUp() {
        // Similar logic to moveLeft, but for vertical movement (upwards)
        for (int col = 0; col < SIZE; col++) {
            for (int row = 1; row < SIZE; row++) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int targetRow = row;

                    while (targetRow > 0 && board[targetRow - 1][col] == 0) {
                        board[targetRow - 1][col] = value;
                        board[targetRow][col] = 0;
                        targetRow--;
                    }

                    if (targetRow > 0 && board[targetRow - 1][col] == value) {
                        board[targetRow - 1][col] *= 2;
                        board[targetRow][col] = 0;
                    }
                }
            }
        }
    }

    private void moveDown() {
        // Similar logic to moveLeft, but for vertical movement (downwards)
        for (int col = 0; col < SIZE; col++) {
            for (int row = SIZE - 2; row >= 0; row--) {
                if (board[row][col] != 0) {
                    int value = board[row][col];
                    int targetRow = row;

                    while (targetRow < SIZE - 1 && board[targetRow + 1][col] == 0) {
                        board[targetRow + 1][col] = value;
                        board[targetRow][col] = 0;
                        targetRow++;
                    }

                    if (targetRow < SIZE - 1 && board[targetRow + 1][col] == value) {
                        board[targetRow + 1][col] *= 2;
                        board[targetRow][col] = 0;
                    }
                }
            }
        }
    }

    private boolean isGameOver() {
        if (!isFull()) return false;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int value = board[row][col];
                if ((row < SIZE - 1 && board[row + 1][col] == value) ||
                    (col < SIZE - 1 && board[row][col + 1] == value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isFull() {
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void playGame() throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard();
            System.out.print("   Enter your move (W/A/S/D) : ");
            String move = sc.next().toUpperCase();
            System.out.println();
            switch (move) {
                case "W":
                    moveUp();
                    break;
                case "A":
                    moveLeft();
                    break;
                case "S":
                    moveDown();
                    break;
                case "D":
                    moveRight();
                    break;
                default:
                    System.out.println("\n   Invalid move. Use W/A/S/D.\n");
                    continue;
            }

            addRandomTile();
            gameOver = isGameOver();
        }

        printBoard();
        System.out.println("\t\t\t GAME OVER!\n");
    }
}