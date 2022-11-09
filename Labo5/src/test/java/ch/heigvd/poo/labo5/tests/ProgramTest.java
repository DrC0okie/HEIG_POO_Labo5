/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Program1.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Program that execute +, - and * operations on matrices created
                  with random values.
Remark(s)       : This program automatically closes after displaying the result.
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.tests;

import ch.heigvd.poo.labo5.Matrix.Matrix;
import ch.heigvd.poo.labo5.operations.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProgramTest {
    @Test
    //Tests the program with the values given in the lab instructions
    public void givenExampleTest() {
        Matrix m1 = new Matrix(
                new int[][]{
                        {1, 3, 1, 1},
                        {3, 2, 4, 2},
                        {1, 0, 1, 0}}, 5);
        Matrix m2 = new Matrix(
                new int[][]{
                        {1, 4, 2, 3, 2},
                        {0, 1, 0, 4, 2},
                        {0, 0, 2, 0, 2}}, 5);

        int[][] resultAdd = new int[][]{
                {2, 2, 3, 4, 2},
                {3, 3, 4, 1, 2},
                {1, 0, 3, 0, 2}};

        int[][] resultSub = new int[][]{
                {0, 4, 4, 3, 3},
                {3, 1, 4, 3, 3},
                {1, 0, 4, 0, 3}};

        int[][] resultMult = new int[][]{
                {1, 2, 2, 3, 0},
                {0, 2, 0, 3, 0},
                {0, 0, 2, 0, 0}};

        //Test the printed matrices with the printed 2d result arrays
        assertEquals(print2dArray(resultAdd),
                m1.executeOperation(m2, new Addition()).toString());

        assertEquals(print2dArray(resultSub),
                m1.executeOperation(m2, new Subtraction()).toString());

        assertEquals(print2dArray(resultMult),
                m1.executeOperation(m2, new Multiplication()).toString());
    }

    private String print2dArray(int[][] array) {
        StringBuilder tmp = new StringBuilder();
        for (int[] ints : array) {
            for (int i = 0; i < array[0].length; ++i) {
                tmp.append(ints[i]).append(" ");
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }

    @Test
    public void operationWithDifferentModulus() {
        Matrix m1 = new Matrix(3, 3, 3),
                m2 = new Matrix(3, 3, 4);
        assertThrows(RuntimeException.class,
                () -> m1.executeOperation(m2, new Addition()));

        assertThrows(RuntimeException.class,
                () -> m1.executeOperation(m2, new Subtraction()));

        assertThrows(RuntimeException.class,
                () -> m1.executeOperation(m2, new Multiplication()));
    }

    @Test
    public void checkConstructionExceptions() {
        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(new int[][]{{6}, {0}, {3}}, 5);});

        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(0, 2, 2);});

        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(2, -1, 2);});

        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(3, 3, -1);});
    }
}
