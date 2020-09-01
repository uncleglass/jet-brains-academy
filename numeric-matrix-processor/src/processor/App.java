package processor;

import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private MatrixProcessor processor = new MatrixProcessor(scanner);

    public void run() {
        boolean runApp = true;
        while (runApp) {
            printMenu();
            System.out.print("Your choice: ");
            String userChoice = scanner.next();
            switch (userChoice) {
                case "1":
                    processor.addMatrices();
                    break;
                case "2":
                    processor.multiplyMatrixByANumber();
                    break;
                case "3":
                    processor.multiplyMatrices();
                    break;
                case "0":
                    runApp = false;
                    break;
                default:
                    System.out.println("Unknown operation");
            }
            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "0. Exit");
    }
}


