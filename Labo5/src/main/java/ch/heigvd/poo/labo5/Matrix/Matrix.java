package ch.heigvd.poo.labo5.Matrix;

import java.util.Random;
import static java.lang.Math.max;

public class Matrix {

    private int[][] internalValue;
    private final int nbLines;
    private final int nbRows;

    private static final Random random = new Random();

    private int modulus;

    public int getNbLines() {
        return nbLines;
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getModulus() {
        return modulus;
    }

    public int at(int i, int j){
        return internalValue[i][j];
    }

    public Matrix(int[][] matrix) {
        nbLines = matrix.length;
        nbRows = matrix[0].length;
        modulus = 0;

        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                internalValue  = new int[nbLines][nbRows];
                internalValue[i][j] = matrix[i][j];
                modulus = max(modulus, matrix[i][j]);
            }
        }
    }

    public Matrix(int nbLines, int nbRows, int modulus) throws RuntimeException {
        if(modulus < 0)
            throw new RuntimeException("The modulus must be >= 0");

        if(nbLines < 1 || nbRows < 1)
            throw new RuntimeException("The number of rows / lines must be > 0");

        this.modulus = modulus;
        this.nbLines = nbLines;
        this.nbRows = nbRows;
        internalValue  = new int[nbLines][nbRows];
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                internalValue[i][j] = random.nextInt(modulus);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                tmp.append(internalValue[i][j]);
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }
}
