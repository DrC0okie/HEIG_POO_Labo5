/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : ProgramTest.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Program that execute +, - and * operations on matrices created
                  with fixed values.
Remark(s)       :
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
    /**
     * Tests the program with the values given in the lab instructions
     */
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

    @Test
    public void additionWithDifferentModulus() {
        assertThrows(RuntimeException.class,
                () -> new Matrix(3, 4, 5).executeOperation(
                        new Matrix(3, 4, 6), new Addition()));
    }

    @Test
    public void subtractionWithDifferentModulus() {
        assertThrows(RuntimeException.class,
                () -> new Matrix(1, 4, 1).executeOperation(
                        new Matrix(10, 11, 6), new Subtraction()));
    }

    @Test
    public void multiplicationWithDifferentModulus() {
        assertThrows(RuntimeException.class,
                () -> new Matrix(100, 200, 1000).executeOperation(
                        new Matrix(66, 1, 1001), new Multiplication()));
    }

    @Test
    public void checkConstructionWithValuesHigherThanModulus() {
        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(new int[][]{{6}, {0}, {3}}, 5);});
    }

    @Test
    public void checkConstructionWith0Row() {
        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(0, 2, 2);});
    }

    @Test
    public void checkConstructionWith0Column() {
        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(2, -1, 2);});
    }

    @Test
    public void checkConstructionWithNegativeModulus() {
        assertThrows(RuntimeException.class, () -> {
            Matrix m = new Matrix(3, 3, -1);});
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
}
