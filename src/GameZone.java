import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GameZone {
    static Scanner sc = new Scanner(System.in);
    static int Balance = 10000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(
                "====================================================================================================================================");
        System.out.println(
                "********************************************************     GAME ZONE     *********************************************************");
        System.out.println(
                "====================================================================================================================================");
        int flag = 0;
        while (flag == 0) {
            System.out.println();
            System.out.println("Balance=" + Balance);
            System.out.println("\n1-> Snake Game         ===   250");
            System.out.println("2-> MineSweeper        ===   500");
            System.out.println("3-> Tic Tac Toe        ===   350");
            System.out.println("4-> Shut The Box       ===   400");
            System.out.println("5-> 2048 Game          ===   300");
            System.out.println("6-> Recharge");
            System.out.println("7-> Exit");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Enter your choice in numbers only.");
                choice = -1;
                sc.nextLine();
            }
            switch (choice) {
                case 1:
                    if (Balance >= 200) {
                        Balance -= 200;
                        new Snake();
                    } else {
                        System.out.println("Insufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 2:
                    if (Balance >= 500) {
                        Balance -= 500;
                        new MineSweeper();
                    } else {
                        System.out.println("Insufficient balance---Please recharge your card");
                        recharge();
                    }
                    break;
                case 3:
                    if (Balance >= 350) {
                        Balance -= 350;
                        new TicTacToe();

                    } else {
                        System.out.println("You don't have balance---Please Recharge your card");
                        recharge();
                    }
                    break;
                case 4:
                    if (Balance >= 400) {
                        Balance -= 400;
                        new ShutTheBox();

                    } else {
                        System.out.println("You don't have balance---Please Recharge your card");
                        recharge();
                    }
                    break;
                case 5:
                    if (Balance >= 300) {
                        Balance -= 300;
                        new Game2048();

                    } else {
                        System.out.println("You don't have balance---Please Recharge your card");
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
                    System.out.println("Enter Valid Choice");
                    break;
            }

            // clrscr();
        }

    }

    public static void recharge() {
        String amt = JOptionPane.showInputDialog("Enter Recharge Amount");
        int amt1 = 0;
        try {
            amt1 = Integer.parseInt(amt);
        } catch (Exception e) {
            System.out.println("Enter digits only");
            amt1 = 0;
        }
        Balance += amt1;
        sc.nextLine();
    }

    public static void clrscr() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {

        }

    }

}