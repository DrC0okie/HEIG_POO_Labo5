package ch.heigvd.poo.labo5.Matrix;
import ch.heigvd.poo.labo5.operations.Addition;
import ch.heigvd.poo.labo5.operations.Multiplication;
import ch.heigvd.poo.labo5.operations.Operation;
import ch.heigvd.poo.labo5.operations.Subtraction;

import java.util.Random;

public class Matrix {

    private int[][] internalValue;

    private int nbRows, nbColumns, modulus;

    private static final Random random = new Random();

    public Matrix(int[][] values, int modulus) throws RuntimeException {
        nbRows = values.length;
        nbColumns = values[0].length;
        this.modulus = modulus;
        internalValue = new int[nbRows][nbColumns];
        for (int i = 0; i < nbRows; ++i) {
            for (int j = 0; j < nbColumns; ++j) {
                if (values[i][j] < 0 || values[i][j] >= this.modulus) {
                    throw new RuntimeException(
                            "The given values must be > 0 and < " + (modulus - 1));
                }
                internalValue[i][j] = values[i][j];
            }
        }
    }

    public Matrix(int nbRows, int nbColumns, int modulus) throws RuntimeException {
        if (modulus < 0)
            throw new RuntimeException("The modulus must be > 0");

        if (nbRows < 0 || nbColumns < 0)
            throw new RuntimeException("The number of rows / columns must be > 0");

        this.modulus = modulus;
        this.nbRows = nbRows;
        this.nbColumns = nbColumns;
        internalValue = new int[nbRows][nbColumns];
        for (int i = 0; i < nbRows; ++i) {
            for (int j = 0; j < nbColumns; ++j) {
                internalValue[i][j] = random.nextInt(modulus);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < nbRows; ++i) {
            for (int j = 0; j < nbColumns; ++j) {
                tmp.append(internalValue[i][j]).append(" ");
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }

    private boolean inBounds(int rowIndex, int columnIndex) {
        return rowIndex <= nbRows - 1 && columnIndex <= nbColumns - 1;
    }

    public Matrix executeOperation(Matrix rhs, Operation op) throws RuntimeException {
        if (this.modulus != rhs.modulus)
            throw new RuntimeException("The modulus of the 2 matrices must be " +
                    "identical");
        int maxRows = Math.max(nbRows, rhs.nbRows);
        int maxColumns = Math.max(nbColumns, rhs.nbColumns);
        int[][] result = new int[maxRows][maxColumns];
        for (int i = 0; i < maxRows; ++i) {
            for (int j = 0; j < maxColumns; ++j) {
                int valM1 = inBounds(i, j) ? internalValue[i][j] : 0;
                int valM2 = rhs.inBounds(i, j) ? rhs.internalValue[i][j] : 0;
                result[i][j] = Math.floorMod(op.execute(valM1, valM2), modulus);
            }
        }
        return new Matrix(result, modulus);
    }
}
