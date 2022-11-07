/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Program1.java
Author(s)       : Kévin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Program that execute +, - and * operations on matrices created
                  with random values.
Remark(s)       : This program automatically closes after displaying the result.
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5;
import ch.heigvd.poo.labo5.Matrix.Matrix;
import ch.heigvd.poo.labo5.operations.Addition;
import ch.heigvd.poo.labo5.operations.Multiplication;
import ch.heigvd.poo.labo5.operations.Subtraction;

public class Program {
    final static int ARG_NUMBER = 5;

    public static void main(String[] args) {

        if (args.length != ARG_NUMBER) {
            System.err.println("5 expected arguments, " + args.length + " given.\n" +
                    "The arguments must be: <R1> <C1> <R2> <C2> <Modulus> \n" +
                    "<R1> : number of rows in the matrix 1\n" +
                    "<C1> : number of columns in the matrix 1\n" +
                    "The program will exit.");
            System.exit(-1);
        }
        try {
            int[] arguments = getInputArguments(args);

            Matrix matrix1 = new Matrix(arguments[0], arguments[1], arguments[4]);
            Matrix matrix2 = new Matrix(arguments[2], arguments[3], arguments[4]);

            System.out.println("The modulus is " + arguments[4]);
            System.out.println("one: \n" + matrix1 + '\n' + "two: \n" + matrix2);
            System.out.println("one + two : ");
            System.out.println(matrix1.executeOperation(matrix2, new Addition()));
            System.out.println("one - two : ");
            System.out.println(matrix1.executeOperation(matrix2, new Subtraction()));
            System.out.println("one * two : ");
            System.out.println(matrix1.executeOperation(matrix2, new Multiplication()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println("The given arguments must be integer numbers");
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("The program will exit.");
            System.exit(-1);
        }
    }

    static int[] getInputArguments(String[] args) throws NumberFormatException {
        int[] arguments = new int[args.length];
        for (int i = 0; i < args.length; ++i)
            arguments[i] = Integer.parseInt(args[i]);
        return arguments;
    }
}