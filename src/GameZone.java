import java.util.Scanner;

import javax.swing.JOptionPane;

public class GameZone {
    static Scanner sc = new Scanner(System.in);
    static int Balance = 1000;

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("====================== ! GAME ZONE ! =======================");
        System.out.println("============================================================");

        int flag = 0;
        while (flag == 0) {
            System.out.println();
            System.out.println("\tBalance=" + Balance+"\n");
            System.out.println("\t    1 -> Tic Tac Toe        ===   350");
            System.out.println("\t    2 -> Mine Sweeper       ===   500");
            System.out.println("\t    3 -> Snake Game         ===   250");
            System.out.println("\t    4 -> Shut The Box       ===   400");
            System.out.println("\t    5 -> 2048 Game          ===   300");
            System.out.println("\t    6 -> Recharge");
            System.out.println("\t    7 -> Exit\n");
            System.out.print("\tYour Choice : ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                choice = -1;
                sc.nextLine();
            }
            switch (choice) {
                case 1:
                    if (Balance >= 350) {
                        Balance -= 350;
                        new TicTacToe();
                    } else {
                        System.out.println("\tInsufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 2:
                    if (Balance >= 500) {
                        Balance -= 500;
                        new MineSweeper();
                    } else {
                        System.out.println("\tInsufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 3:
                    if (Balance >= 250) {
                        Balance -= 250;
                        new SnakeGame();
                    } else {
                        System.out.println("\tInsufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 4:
                    if (Balance >= 400) {
                        Balance -= 400;
                        new ShutTheBox();

                    } else {
                        System.out.println("\tInsufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 5:
                    if (Balance >= 300) {
                        Balance -= 300;
                        new Game2048();

                    } else {
                        System.out.println("\tInsufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 6:
                    recharge();
                    break;
                case 7:
                    flag = 1;
                    break;
                default:
                    System.out.println("\tEnter Valid Choice");
                    break;
            }
        }
    }

    public static void recharge() {
        String amt = JOptionPane.showInputDialog("Enter Recharge Amount");
        int amt1 = 0;
        try {
            amt1 = Integer.parseInt(amt);
        } catch (Exception e) {
            System.out.println("Enter digits only");
        }
        Balance += amt1;
        sc.nextLine();
    }
}
