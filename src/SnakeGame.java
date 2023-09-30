import java.util.*;

class SnakeGame {
    SnakeGame() {
        Random random = new Random();
        int snakeX = random.nextInt(10);
        int snakeY = random.nextInt(10);
        int foodX = random.nextInt(10);
        int foodY = random.nextInt(10);
        int score = 0;
        List<int[]> snakeBody = new ArrayList<>();
        snakeBody.add(new int[] { snakeX, snakeY });
        System.out.println("\n\n============== ! Welcome to The Snake Game ! ==============\n");

        while (true) {
            // Print the game board
            System.out.println();
            for (int i = 0; i < 12; i++) {
                System.out.print("\t\t  ");
                for (int j = 0; j < 12; j++) {
                    if (i == 0 || i == 11 || j == 0 || j == 11) {
                        System.out.print("@ ");
                    } else if (i - 1 == snakeY && j - 1 == snakeX) {
                        System.out.print("O ");
                    } else if (i - 1 == foodY && j - 1 == foodX) {
                        System.out.print("F ");
                    } else {
                        boolean isBodyPart = false;
                        for (int[] bodyPart : snakeBody) {
                            if (bodyPart[0] == j - 1 && bodyPart[1] == i - 1) {
                                System.out.print("o ");
                                isBodyPart = true;
                                break;
                            }
                        }
                        if (!isBodyPart) {
                            System.out.print(". ");
                        }
                    }
                }
                System.out.println();
            }
            System.out.println();

            // Prompt the user for a move
            Scanner scanner = new Scanner(System.in);
            System.out.print("   Enter your move (W/A/S/D) : ");

            String move = scanner.next().toUpperCase();
            if (move.length() != 1) {
                 System.out.println("\n\t\t        INVALID MOVE");
                continue;
            }

            // Update the snake's position based on the move
            int[] snakeHead = snakeBody.get(0);

            switch (move) {
                case "Q":
                    System.out.println("\n\t\t         GAME OVER!         ");
                    return;
                case "W":
                    snakeY--;
                    break;
                case "A":
                    snakeX--;
                    break;
                case "S":
                    snakeY++;
                    break;
                case "D":
                    snakeX++;
                    break;
                default:
                    System.out.println("\n\t\t        INVALID MOVE");
                    break;
            }

            // Check if the snake has collided with the walls
            if (snakeX < 0 || snakeX >= 10 || snakeY < 0 || snakeY >= 10) {
                System.out.print("\n\t\t         GAME OVER!         ");
                System.out.print("\n\t\t         SCORE = " + score);
                System.out.println();
                System.out.println();
                return;
            }
            
            // Check if the snake has collided with itself
            for (int i = 1; i < snakeBody.size(); i++) {
                int[] coord = snakeBody.get(i);
                if (coord[0] == snakeX && coord[1] == snakeY) {
                    System.out.print("\n\t\t         GAME OVER!         ");
                    System.out.print("\n\t\t         SCORE = " + score);
                    System.out.println();
                    System.out.println();
                    return;
                }
            }

            // Check if the snake has eaten the food
            if (snakeX == foodX && snakeY == foodY) {
                score++;
                foodX = random.nextInt(10);
                foodY = random.nextInt(10);
                snakeBody.add(0, new int[] { snakeX, snakeY });
            } else {
                // Move the snake
                for (int i = snakeBody.size() - 1; i >= 1; i--) {
                    int[] prevCoord = snakeBody.get(i - 1);
                    int[] currCoord = snakeBody.get(i);
                    currCoord[0] = prevCoord[0];
                    currCoord[1] = prevCoord[1];
                }
                snakeHead[0] = snakeX;
                snakeHead[1] = snakeY;
            }
        }
    }
}