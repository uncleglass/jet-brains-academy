package processor;

public class Matrix {
    private final int[][] data;
    private final int rowsCount;
    private final int columnsCount;

    public Matrix(int rowsCount, int columnsCount) {
        this.data = new int[rowsCount][columnsCount];
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
    }

    public void addElement(int row, int column, int value) {
        this.data[row][column] = value;
    }

    public int getElement(int row, int column) {
        return this.data[row][column];
    }

    public boolean sameSize(Matrix matrix) {
        return this.rowsCount == matrix.getRowsCount() &&
                this.columnsCount == matrix.getColumnsCount();
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
                int value = this.getElement(r, c) + matrix.getElement(r, c);
                result.addElement(r, c, value);
            }
        }
        return result;
    }

    public Matrix multiplyByNumber(int number) {
        Matrix result = new Matrix(this.rowsCount, this.columnsCount);

        for (int r = 0; r < this.rowsCount; r++) {
            for (int c = 0; c < this.columnsCount; c++) {
                int value = this.getElement(r, c) * number;
                result.addElement(r, c, value);
            }
        }
        return result;
    }
}
