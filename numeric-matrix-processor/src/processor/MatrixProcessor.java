package processor;

import java.util.Scanner;

public class MatrixProcessor {
    private final Scanner scanner;

    public MatrixProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addMatrices() {
        Matrix matrix1 = createMatrix("Enter size of first matrix: ");
        fillUpMatrix("Enter first matrix:", matrix1);
        Matrix matrix2 = createMatrix("Enter size of second matrix: ");
        fillUpMatrix("Enter second matrix:", matrix2);

        try {
            Matrix result = matrix1.add(matrix2);
            printMatrix("The adding result is:", result);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void multiplyMatrixByANumber() {
        Matrix matrix = createMatrix("Enter matrix size: ");
        fillUpMatrix("Enter matrix:", matrix);
        System.out.print("Enter constant: ");
        int number = scanner.nextInt();

        Matrix result = matrix.multiplyByNumber(number);
        printMatrix("The multiplication by the constant result is:", result);
    }

    public void multiplyMatrices() {
        Matrix matrix1 = createMatrix("Enter size of first matrix: ");
        fillUpMatrix("Enter first matrix:", matrix1);
        Matrix matrix2 = createMatrix("Enter size of second matrix: ");
        fillUpMatrix("Enter second matrix:", matrix2);

        try {
            Matrix result = matrix1.multiply(matrix2);
            printMatrix("The multiplication result is:", result);
        } catch (WrongMatrixSizeException e) {
            System.out.println("ERROR");
        }
    }

    private Matrix createMatrix(String s) {
        System.out.print(s);
        int rowsCount = scanner.nextInt();
        int columnsCount= scanner.nextInt();
        return new Matrix(rowsCount, columnsCount);
    }

    private void fillUpMatrix(String s, Matrix matrix) {
        System.out.println(s);
        int rowsCount = matrix.getRowsCount();
        int columnsCount = matrix.getColumnsCount();

        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < columnsCount; c++) {
                matrix.addElement(r, c, scanner.nextDouble());
            }
        }
    }

    private void printMatrix(String s, Matrix matrix) {
        System.out.println(s);
        int rowsCount = matrix.getRowsCount();
        int columnsCount = matrix.getColumnsCount();

        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < columnsCount; c++) {
                System.out.print(matrix.getElement(r, c)+ " ");
            }
            System.out.println();
        }
    }

    public void transposeMatrix() {
        printTransposeMenu();
        System.out.print("Your choice: ");
        String userChoice = scanner.next();
        Matrix matrix = createMatrix("Enter matrix size: ");
        fillUpMatrix("Enter matrix:", matrix);
        Matrix transposedMatrix = null;
        switch (userChoice) {
            case "1":
                transposedMatrix = matrix.transposeMailDiagonal();
                break;
            case "2":
                transposedMatrix = matrix.transposeSideDiagonal();
                break;
            case "3":
                transposedMatrix = matrix.transposeVerticalLine();
                break;
            case "4":
                transposedMatrix = matrix.transposeHorizontalLine();
                break;
            default:
                System.out.println("Unknown operation");
        }

        printMatrix("The result is:", transposedMatrix);
    }

    private void printTransposeMenu() {
        System.out.println("\n1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line");
    }
}
