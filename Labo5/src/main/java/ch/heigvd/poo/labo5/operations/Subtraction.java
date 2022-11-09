/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Subtraction.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Subclass of Operation who do the subtraction
Remark(s)       :
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.operations;

public class Subtraction extends Operation {

    /**
     * Method who will do the subtraction
     * @param var1  The first variable
     * @param var2  The second variable
     * @return      The result of the calculation
     */
    @Override
    public int execute(int var1, int var2) {
        return var1 - var2;
    }
}
