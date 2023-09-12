import java.util.*;

public class Snake {
    static Scanner sc = new Scanner(System.in);

    Snake() {

        Snake1 s = new Snake1();
        int[][] board = new int[10][10];
        s.addBody(board);
        s.generateFood(board);

        while (!Snake1.gameOver) {
            printBoard(board);
            s.direction = takeInput(s);
            board = s.movement(board);
            System.out.println("\n\n\n");
        }

        System.out.println("GAME OVER");
    }

    static String takeInput(Snake1 s) {
        System.out.print(" ENTER THE DIRECTION TO MOVE : ");
        String input = sc.next();
        if (!(input.compareToIgnoreCase("L") == 0 || input.compareToIgnoreCase("R") == 0
                || input.compareToIgnoreCase("U") == 0 || input.compareToIgnoreCase("D") == 0)) {
            input = s.direction;
        }

        return input;

    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            for (int x = 0; x < 3; x++) {
                System.out.print("|");
                for (int j = 0; j < board[0].length; j++) {
                    String prevPointer = "", nextPointer = "";
                    if (board[i][j] > 0) {

                        if (i - 1 >= 0 && board[i][j] - 1 == board[i - 1][j]) {
                            nextPointer = "U";
                        } else if (j - 1 >= 0 && board[i][j] - 1 == board[i][j - 1]) {
                            nextPointer = "L";
                        } else if (i + 1 < 10 && board[i][j] - 1 == board[i + 1][j]) {
                            nextPointer = "D";
                        } else if (j + 1 < 10 && board[i][j] - 1 == board[i][j + 1]) {
                            nextPointer = "R";
                        } else {
                            System.out.print("i:" + i + "j:" + "b:" + board[i][j] + " " + board[i + 1][j] + ""
                                    + board[i - 1][j] + "" + board[i][j + 1] + "" + board[i][j - 1]);
                        }

                        if (i - 1 >= 0 && board[i][j] + 1 == board[i - 1][j]) {
                            prevPointer = "U";
                        } else if (j - 1 >= 0 && board[i][j] + 1 == board[i][j - 1]) {
                            prevPointer = "L";
                        } else if (i + 1 < 10 && board[i][j] + 1 == board[i + 1][j]) {
                            prevPointer = "D";
                        } else if (j + 1 < 10 && board[i][j] + 1 == board[i][j + 1]) {
                            prevPointer = "R";
                        }
                        if (prevPointer == "") {
                            if (Snake1.prevTaili - i == -1) {
                                prevPointer = "U";
                            } else if (Snake1.prevTailj - j == -1) {
                                prevPointer = "L";
                            } else if (Snake1.prevTaili - i == 1) {
                                prevPointer = "D";
                            } else if (Snake1.prevTailj - j == 1) {
                                prevPointer = "R";
                            } else {
                                System.out.print("prev not-set i : " + i + " j : " + j + " " + Snake1.prevTaili + " "
                                        + Snake1.prevTailj);
                            }
                        }
                        if (board[i][j] == 1) {

                            if (prevPointer.equals("D")) {
                                if (x == 2) {
                                    System.out.print("   X   |");
                                } else if (x == 1) {
                                    System.out.print("   O   |");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if (prevPointer.equals("R")) {
                                if (x == 1) {
                                    System.out.print("   OXXX|");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if (prevPointer.equals("U")) {
                                if (x == 0) {
                                    System.out.print("   X   |");
                                } else if (x == 1) {
                                    System.out.print("   O   |");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if (prevPointer.equals("L")) {
                                if (x == 1) {
                                    System.out.print("XXXO   |");
                                } else {
                                    System.out.print("       |");
                                }
                            }

                        } else {

                            if ((prevPointer.equals("U") && nextPointer.equals("D"))
                                    || (prevPointer.equals("D") && nextPointer.equals("U"))) {
                                System.out.print("   X   |");
                            } else if ((prevPointer.equals("R") && nextPointer.equals("L"))
                                    || (prevPointer.equals("L") && nextPointer.equals("R"))) {
                                if (x == 1) {
                                    System.out.print("XXXXXXX|");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if ((prevPointer.equals("L") && nextPointer.equals("U"))
                                    || (prevPointer.equals("U") && nextPointer.equals("L"))) {
                                if (x == 1) {
                                    System.out.print("XXXX   |");
                                } else if (x == 0) {
                                    System.out.print("   X   |");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if ((prevPointer.equals("L") && nextPointer.equals("D"))
                                    || (prevPointer.equals("D") && nextPointer.equals("L"))) {
                                if (x == 1) {
                                    System.out.print("XXXX   |");
                                } else if (x == 2) {
                                    System.out.print("   X   |");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if ((prevPointer.equals("R") && nextPointer.equals("D"))
                                    || (prevPointer.equals("D") && nextPointer.equals("R"))) {
                                if (x == 1) {
                                    System.out.print("   XXXX|");
                                } else if (x == 2) {
                                    System.out.print("   X   |");
                                } else {
                                    System.out.print("       |");
                                }
                            } else if ((prevPointer.equals("R") && nextPointer.equals("U"))
                                    || (prevPointer.equals("U") && nextPointer.equals("R"))) {
                                if (x == 1) {
                                    System.out.print("   XXXX|");
                                } else if (x == 0) {
                                    System.out.print("   X   |");
                                } else {
                                    System.out.print("       |");
                                }
                            } else {
                                System.out.print("prev:" + prevPointer + ",next:" + nextPointer + "|");
                            }
                        }

                    } else if (board[i][j] == -1) {
                        if (x == 1) {
                            System.out.print("  O O  |");
                        } else {
                            System.out.print("  OOO  |");
                        }
                    } else {
                        System.out.print("       |");
                    }
                }
                System.out.println();
            }
        }
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
    }

}

class Snake1 {

    static int prevTaili = 4, prevTailj = 3;
    static boolean gameOver = false;
    static int bodyLength = 0;
    Body head;
    Body tail;
    String direction = "R";
    int fi, fj;

    class Body {

        Body nextPart;
        Body prevPart;
        int i;
        int j;
        int bodycount;

        Body(int i, int j, int bodyCount) {
            this.i = i;
            this.j = j;
            this.bodycount = bodyCount;
        }

    }

    void addBody(int[][] board) {
        bodyLength++;
        if (tail == null) {
            head = tail = new Body(4, 4, bodyLength);
            board[4][4] = bodyLength;
        } else {
            Body newBody = new Body(prevTaili, prevTailj, bodyLength);
            newBody.nextPart = tail;
            tail.prevPart = newBody;
            tail = newBody;
        }
    }

    int[][] movement(int[][] board) {
        Body tempBody = tail;
        int tempi = prevTaili, tempj = prevTailj;
        prevTaili = tail.i;
        prevTailj = tail.j;
        while (true) {
            if (tempBody == head) {
                if (direction.compareToIgnoreCase("R") == 0) {
                    head.j += 1;
                } else if (direction.compareToIgnoreCase("U") == 0) {
                    head.i -= 1;
                } else if (direction.compareToIgnoreCase("L") == 0) {
                    head.j -= 1;
                } else if (direction.compareToIgnoreCase("D") == 0) {
                    head.i += 1;
                }
                break;
            }
            tempBody.i = tempBody.nextPart.i;
            tempBody.j = tempBody.nextPart.j;
            tempBody = tempBody.nextPart;
        }

        if (head.i > board.length - 1 || head.j > board[0].length - 1 || head.i < 0 || head.j < 0) {
            gameOver = true;
            return new int[board.length][board[0].length];
        }

        if (board[head.i][head.j] > 0) {
            gameOver = true;
            return new int[board.length][board[0].length];
        }

        if (board[head.i][head.j] == -1) {
            generateFood(board);
            addBody(board);
            prevTaili = tempi;
            prevTailj = tempj;
        }

        board = new int[board.length][board[0].length];
        board[fi][fj] = -1;
        tempBody = tail;
        while (tempBody != null) {
            board[tempBody.i][tempBody.j] = tempBody.bodycount;
            tempBody = tempBody.nextPart;
        }

        return board;
    }

    void generateFood(int[][] board) {
        do {
            fi = 0 + (int) (Math.random() * board.length);
            fj = 0 + (int) (Math.random() * board[0].length);
            System.out.println(fi + " " + fj);
            if (bodyLength == 1 && (fi == 5 || fi == 3 || fj == 3 || fj == 5)) {
                continue;
            }
        } while (board[fi][fj] != 0);
        board[fi][fj] = -1;

    }
}