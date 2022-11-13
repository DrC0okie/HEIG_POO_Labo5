/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Util.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 8 nov. 2022
Description     : Collection of utility static methods
Remark(s)       : This class can't be extended
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.util;

public final class Util {
    /**
     * Finds the number of digits in a number
     *
     * @param number the number to evaluate
     * @return the number of digits of the given number
     */
    public static int nbDigits(int number) {
        int absNumber = Math.abs(number);
        if (absNumber == 0)
            return 1;
        return (int) Math.log10(absNumber) + 1;
    }

    /**
     * Converts a String[] into an int[]
     *
     * @param stringArray The String array to be converted
     * @return The converted int array
     * @throws NumberFormatException if the character cannot be parsed to int
     * @throws NullPointerException  if the given array is null
     */
    static public int[] StringArrayToIntArray(String[] stringArray)
            throws NumberFormatException, NullPointerException {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; ++i) {
            try {
                intArray[i] = Integer.parseInt(stringArray[i]);
            } catch (NumberFormatException e) {
                //Throw a more comprehensible exception for the user
                throw new NumberFormatException(
                        "Error cannot parse \"" + stringArray[i] + "\" to int");
            }
        }
        return intArray;
    }
}