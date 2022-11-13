/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−-----------------------------------------------
File name       : Program.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Program that execute +, - and * operations on matrices created
                  with random values depending on the given program input arguments.
                  The arguments must be: <R1> <C1> <R2> <C2> <Modulus> as integers
Remark(s)       : This program automatically closes after displaying the result.
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−-----------------------------------------------*/
package ch.heigvd.poo.labo5;

import ch.heigvd.poo.labo5.Matrix.Matrix;
import ch.heigvd.poo.labo5.operations.*;
import static ch.heigvd.poo.labo5.util.Util.StringArrayToIntArray;

public class Program {
    final static int ARG_NUMBER = 5;
    final static String M1 = "one", M2 = "two";

    public static void main(String[] args) {
        try {
            if (args.length != ARG_NUMBER) {
                throw new RuntimeException("Error : Expected 5 arguments, " +
                        args.length + " given.\n" +
                        "The arguments must be: <R1> <C1> <R2> <C2> <Modulus> \n" +
                        "<R1> : number of rows in the matrix 1\n" +
                        "<C1> : number of columns in the matrix 1\n");
            }
            int[] arguments = StringArrayToIntArray(args);
            Matrix m1 = new Matrix(arguments[0], arguments[1], arguments[4]);
            Matrix m2 = new Matrix(arguments[2], arguments[3], arguments[4]);

            //Display the matrices
            System.out.println(M1 + ": \n" + m1 + "\n" + M2 + ": \n" + m2);

            // Create an Operation array to iterate on it
            Operation[] operations = new Operation[]{
                    new Addition(), new Subtraction(), new Multiplication()};

            //Display each operation result
            for (Operation op : operations) {
                System.out.println(M1 + " " + op + " " + M2 + ":");
                System.out.println(m1.executeOperation(m2, op));
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("The program will exit");
        }
    }
}