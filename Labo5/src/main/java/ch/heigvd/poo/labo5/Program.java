/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Program.java
Author(s)       : Kevin Farine, Timothée Van Hove
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

    /**
     * The main program who will create a matrix with random value
     * @param args      Arguments who will be use for the matrix
     */
    public static void main(String[] args) {

        Matrix matrix = new Matrix(new int[][]{{1, 20, 100}, {1000, 4, 200}, {5, 6
                , 7}, {1, 200, 0}},1001);
        System.out.println(matrix);

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

    /**
     * Method who convert the arguments into an array of int
     * @param args  the argument who will be used to be converted
     * @return      an array of int
     * @throws NumberFormatException    if an error occure, it would be this kind of error
     */
    static int[] getInputArguments(String[] args) throws NumberFormatException {
        int[] arguments = new int[args.length];
        for (int i = 0; i < args.length; ++i)
            arguments[i] = Integer.parseInt(args[i]);
        return arguments;
    }
}