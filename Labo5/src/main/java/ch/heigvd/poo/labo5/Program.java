package ch.heigvd.poo.labo5;

import ch.heigvd.poo.labo5.Matrix.Matrix;
import ch.heigvd.poo.labo5.operations.Addition;
import ch.heigvd.poo.labo5.operations.Multiplication;
import ch.heigvd.poo.labo5.operations.Operation;
import ch.heigvd.poo.labo5.operations.Subtraction;

public class Program {
    public static void main(String[] args) {

        try {
            Matrix m1 = new Matrix(
                    new int[][]{{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}}, 5);
            Matrix m2 = new Matrix(
                    new int[][]{{1, 4, 2, 3, 2},{0, 1, 0, 4, 2},{0, 0, 2, 0, 2}}, 5);

            System.out.println("M1 : \n" + m1 + '\n' + "M2 : \n" + m2 + '\n');

            System.out.println("M1 + M2 : \n" + executeOperation(m1, m2,
                    new Addition()));
            System.out.println("M1 - M2 : \n" + executeOperation(m1, m2,
                    new Subtraction()));
            System.out.println("M1 * M2 : \n" + executeOperation(m1, m2,
                    new Multiplication()));

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("The program will exit.");
            System.exit(-1);
        }
    }

    private static Matrix executeOperation(Matrix m1, Matrix m2, Operation op) {
        int nbLines = Math.max(m1.getNbLines(), m2.getNbLines());
        int nbRows = Math.max(m2.getNbRows(), m2.getNbRows());
        int[][] result = new int[nbLines][nbRows];
        for (int i = 0; i < nbLines; ++i) {
            for (int j = 0; j < nbRows; ++j) {
                int tmpM1 = m1.inBounds(i, j) ? m1.at(i, j) : 0;
                int tmpM2 = m2.inBounds(i, j) ? m2.at(i, j) : 0;
                result[i][j] = Math.floorMod(op.execute(tmpM1, tmpM2),
                        m1.getModulus());
            }
        }
        return new Matrix(result, m1.getModulus());
    }

}