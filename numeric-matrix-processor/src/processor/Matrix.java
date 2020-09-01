package processor;

public class Matrix {
    private int[][] data;

    public Matrix(int rowsCount, int columnsCount) {
        this.data = new int[rowsCount][columnsCount];
    }

    public void addElement(int row, int column, int value) {
        this.data[row][column] = value;
    }

    public int getElement(int row, int column) {
        return this.data[row][column];
    }

    public boolean sameSize(Matrix matrix) {
        return this.getRowsCount() == matrix.getRowsCount() &&
                this.getColumnsCount() == matrix.getColumnsCount();
    }

    public int getRowsCount() {
        return this.data.length;
    }

    public int getColumnsCount() {
        return this.data[0].length;
    }

    public Matrix add(Matrix matrix) throws WrongMatrixSizeException {
        if (!this.sameSize(matrix)) {
            throw new WrongMatrixSizeException();
        }

        int rowsCount = this.getRowsCount();
        int columnsCount = this.getColumnsCount();
        Matrix result = new Matrix(rowsCount, columnsCount);

        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < columnsCount; c++) {
                int value = this.getElement(r, c) + matrix.getElement(r, c);
                result.addElement(r, c, value);
            }
        }
        return result;
    }
}
