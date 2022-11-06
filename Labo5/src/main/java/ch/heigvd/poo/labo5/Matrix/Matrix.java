package ch.heigvd.poo.labo5.Matrix;
import ch.heigvd.poo.labo5.operations.Addition;
import ch.heigvd.poo.labo5.operations.Multiplication;
import ch.heigvd.poo.labo5.operations.Operation;
import ch.heigvd.poo.labo5.operations.Subtraction;

import java.util.Random;

public class Matrix {

    private int[][] internalValue;

    private int nbLines, nbRows, modulus;

    private static final Random random = new Random();

    public Matrix(int[][] values, int modulus) throws RuntimeException {
        nbLines = values.length;
        nbRows = values[0].length;
        this.modulus = modulus;
        internalValue = new int[nbLines][nbRows];
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                if (values[i][j] < 0 || values[i][j] >= this.modulus) {
                    throw new RuntimeException(
                            "The given values must be > 0 and < " + (modulus - 1));
                }
                internalValue[i][j] = values[i][j];
            }
        }
    }

    public Matrix(int nbLines, int nbRows, int modulus) throws RuntimeException {
        if (modulus < 0)
            throw new RuntimeException("The modulus must be >= 0");

        if (nbLines < 0 || nbRows < 0)
            throw new RuntimeException("The number of rows / lines must be >= 0");

        this.modulus = modulus;
        this.nbLines = nbLines;
        this.nbRows = nbRows;
        internalValue = new int[nbLines][nbRows];
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                internalValue[i][j] = random.nextInt(modulus);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                tmp.append(internalValue[i][j]).append(" ");
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }

    private boolean inBounds(int lineIndex, int rowIndex) {
        return lineIndex <= nbLines - 1 && rowIndex <= nbRows - 1;
    }

    private Matrix executeOperation(Matrix m1, Matrix m2, Operation op) throws RuntimeException {
        if (m1.modulus != m2.modulus)
            throw new RuntimeException("The modulus of the 2 matrices must be " +
                    "identical");
        int nbLines = Math.max(m1.nbLines, m2.nbLines);
        int nbRows = Math.max(m1.nbRows, m2.nbRows);
        int[][] result = new int[nbLines][nbRows];
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                int valM1 = m1.inBounds(i, j) ? m1.internalValue[i][j] : 0;
                int valM2 = m2.inBounds(i, j) ? m2.internalValue[i][j] : 0;
                result[i][j] = Math.floorMod(op.execute(valM1, valM2), m1.modulus);
            }
        }
        return new Matrix(result, m1.modulus);
    }

    public Matrix add(Matrix m) throws RuntimeException {
        return executeOperation(this, m, new Addition());
    }

    public Matrix sub(Matrix m) throws RuntimeException {
        return executeOperation(this, m, new Subtraction());
    }

    public Matrix mult(Matrix m) throws RuntimeException {
        return executeOperation(this, m, new Multiplication());
    }
}
