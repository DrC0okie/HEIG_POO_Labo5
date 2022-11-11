/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Utils.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 8 nov. 2022
Description     : Collection of utils static methods
Remark(s)       :
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.utils;
public final class Utils {
    /** Finds the number of digits in a number
     * @param number the number to evaluate
     * @return the number of digits of the given number */
    public static int nbDigits(int number){
        number = Math.abs(number);
        if (number == 0)
            return 1;
        return (int) Math.log10(number) + 1;
    }

    /**
     * Converts a String[] into an int[]
     * @param args The String array to be converted
     * @return The converted int array
     * @throws NumberFormatException if the character cannot be cast to int
     */
    static public int[] StringArraytoIntArray(String[] args) throws NumberFormatException {
        int[] arguments = new int[args.length];
        for (int i = 0; i < args.length; ++i)
            arguments[i] = Integer.parseInt(args[i]);
        return arguments;
    }
}