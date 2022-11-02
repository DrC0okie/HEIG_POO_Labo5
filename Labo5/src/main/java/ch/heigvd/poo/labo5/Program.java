package ch.heigvd.poo.labo5;

import ch.heigvd.poo.labo5.Matrix.Matrix;

public class Program {
    public static void main(String[] args) {

        try{
            Matrix test = new Matrix(16, 16, -10);
            System.out.println(test);
        }
        catch(RuntimeException e){
            e.printStackTrace();
            System.err.println("The program will exit.");
            System.exit(-1);
        }
    }
}