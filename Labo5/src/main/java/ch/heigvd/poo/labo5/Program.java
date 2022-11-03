package ch.heigvd.poo.labo5;

import ch.heigvd.poo.labo5.Matrix.Matrix;

public class Program {
    public static void main(String[] args) {

        try {
            Matrix test = new Matrix(16, 16, 10);
            System.out.println(test);
            Matrix test2 = new Matrix(
                    new int[][]{{1, 2, 3, 4}, {4, 3, 2, 1}, {0, 0, 0, 0}, {9, 9, 9, 9}});
            System.out.println(test2);
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("The program will exit.");
            System.exit(-1);
        }
    }
}