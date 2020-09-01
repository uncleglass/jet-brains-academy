package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        Matrix matrix = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix.addElement(i, j, scanner.nextInt());
            }
        }

        int number = scanner.nextInt();

        Matrix multiply = matrix.multiplyByNumber(number);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(multiply.getElement(i, j) + " ");
            }
            System.out.println();
        }


    }
}
