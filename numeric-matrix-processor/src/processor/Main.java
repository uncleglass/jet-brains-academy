package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        Matrix matrix1 = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix1.addElement(i, j, scanner.nextInt());
            }
        }

        row = scanner.nextInt();
        column = scanner.nextInt();
        Matrix matrix2 = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix2.addElement(i, j, scanner.nextInt());
            }
        }

        try {
            Matrix add = matrix1.add(matrix2);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(add.getElement(i, j) + " ");
                }
                System.out.println();
            }

        } catch (WrongMatrixSizeException e) {
            System.out.println("ERROR");
        }


    }
}
