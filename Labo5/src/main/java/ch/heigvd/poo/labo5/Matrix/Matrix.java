/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Matrix.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Class who will create matrix with an array of array of int
Remark(s)       :
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.Matrix;

import ch.heigvd.poo.labo5.operations.Operation;
import java.util.Random;
import ch.heigvd.poo.labo5.utils.Utils;

public class Matrix {

    private int[][] internalValue;

    private int nbRows, nbColumns, modulus;

    private static final Random random = new Random();

    /**
     * Constructor who take a 2D array of int and a modulus
     * @param values    2D array of int who is the base of the matrix
     * @param modulus   The modulus who will be used for the matrix
     * @throws RuntimeException if modulus, nbRows, nbColumns <= 0, or if a matrix
     * value is >= modulus*/
    public Matrix(int[][] values, int modulus) throws RuntimeException {
        setIntervalValues(values.length, values[0].length, modulus);
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

    /**
     * Constructor who take the number of rows, columns and a modulus.
     * @param nbRows    The number of rows of the matrix
     * @param nbColumns The number of columns of the matrix
     * @param modulus   The modulus who will be used for the matrix
     * @throws RuntimeException if modulus, nbRows, nbColumns <= 0
     */
    public Matrix(int nbRows, int nbColumns, int modulus) throws RuntimeException {
        setIntervalValues(nbRows, nbColumns, modulus);
        internalValue = new int[nbRows][nbColumns];
        for (int i = 0; i < nbRows; ++i) {
            for (int j = 0; j < nbColumns; ++j) {
                internalValue[i][j] = random.nextInt(modulus);
            }
        }
    }

    /**
     * Returns the formatted representation of the matrix with auto-align
     * @return  The formatted representation of the matrix as String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(new String());
        int[] maxDigits = new int[nbColumns];
        for (int i = 0; i < nbColumns; ++i) {
            //Find the max value of each column
            int maxValue = 0;
            for (int j = 0; j < nbRows; ++j) {
                maxValue = Math.max(maxValue, internalValue[j][i]);
            }
            //Get the number of digits of the max number of each column
            maxDigits[i] = Utils.nbDigits(maxValue);
        }
        for(int i = 0; i < nbRows; ++i){
            for(int j = 0; j < nbColumns; ++j) {
                // Get the number of space characters to prefix the value
                int nbSpace = maxDigits[j] + 1 - Utils.nbDigits(internalValue[i][j]);
                result.append(internalValue[i][j]).append(" ".repeat(nbSpace));
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Controls if the indexes are within the bounds of the matrix
     * @param rowIndex      Index of the row which is checked
     * @param columnIndex   Index of the column which is checked
     * @return      true if the indexes are in the bounds of the matrix, else false
     */
    private boolean inBounds(int rowIndex, int columnIndex) {
        return rowIndex <= nbRows - 1 && columnIndex <= nbColumns - 1;
    }

    /**
     * Method who execute the operation from the class Operation and return a matrix as result
     * @param rhs   The second matrix which is used to calculate with the base matrix
     * @param op    The operation which will be used to calculate the new matrix
     * @return      A new matrix who is the result of the operation
     * @throws RuntimeException if the modulus of the 2 matrices are different
     */
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

    /**
     * Helper method used for vales initialization within the class
     * @param nbRows The number of rows to be set
     * @param nbColumns The number of columns to be set
     * @param modulus The modulus value to be set
     * @throws RuntimeException if modulus, nbRows, nbColumns <= 0
     */
    private void setIntervalValues(int nbRows, int nbColumns, int modulus) throws RuntimeException {
        if (nbRows <= 0 || nbColumns <= 0)
            throw new RuntimeException("The number of rows / columns must be > 0");
        if (modulus <= 0)
            throw new RuntimeException("The modulus must be > 0");

        this.nbRows = nbRows;
        this.nbColumns = nbColumns;
        this.modulus = modulus;
    }
}
