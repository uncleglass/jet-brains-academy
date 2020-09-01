package processor;

public class Matrix {
    private final double[][] data;
    private final int rowsCount;
    private final int columnsCount;

    public Matrix(int rowsCount, int columnsCount) {
        this.data = new double[rowsCount][columnsCount];
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
    }

    public void addElement(int row, int column, double value) {
        this.data[row][column] = value;
    }

    public double getElement(int row, int column) {
        return this.data[row][column];
    }

    public int getRowsCount() {
        return this.rowsCount;
    }

    public int getColumnsCount() {
        return this.columnsCount;
    }

    public Matrix add(Matrix matrix) throws WrongMatrixSizeException {
        if (!this.sameSize(matrix)) {
            throw new WrongMatrixSizeException();
        }

        Matrix result = new Matrix(this.rowsCount, this.columnsCount);

        for (int r = 0; r < this.rowsCount; r++) {
            for (int c = 0; c < this.columnsCount; c++) {
                double value = this.getElement(r, c) + matrix.getElement(r, c);
                result.addElement(r, c, value);
            }
        }
        return result;
    }

    public boolean sameSize(Matrix matrix) {
        return this.rowsCount == matrix.rowsCount &&
                this.columnsCount == matrix.columnsCount;
    }

    public Matrix multiplyByNumber(int number) {
        Matrix result = new Matrix(this.rowsCount, this.columnsCount);

        for (int r = 0; r < this.rowsCount; r++) {
            for (int c = 0; c < this.columnsCount; c++) {
                double value = this.getElement(r, c) * number;
                result.addElement(r, c, value);
            }
        }
        return result;
    }

    public Matrix multiply(Matrix matrix) throws WrongMatrixSizeException {
        if (!correctMultiplicationSize(matrix)) {
            throw new WrongMatrixSizeException();
        }

        Matrix result = new Matrix(this.rowsCount, matrix.columnsCount);

        for (int r = 0; r < result.rowsCount; r++) {
            double[] row = this.getRow(r);
            for (int c = 0; c < result.columnsCount; c++) {
                double[] column = matrix.getColumn(c);
                double value = calculateDotProduct(row, column);
                result.addElement(r, c, value);
            }
        }
        return result;
    }

    private double[] getRow(int row) {
        return this.data[row];
    }

    private double[] getColumn(int column) {
        double[] result = new double[this.rowsCount];

        for (int i = 0; i < result.length; i++) {
            result[i] = this.getElement(i, column);
        }
        return result;
    }

    private double calculateDotProduct(double[] row, double[] column) {
        double dotProduct = 0.0;
        for (int i = 0; i < row.length; i++) {
            dotProduct += row[i] * column[i];
        }
        return dotProduct;
    }

    private boolean correctMultiplicationSize(Matrix matrix) {
        return this.columnsCount == matrix.rowsCount;
    }
}
