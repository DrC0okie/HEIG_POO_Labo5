/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Addition.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Subclass of Operation who do the addition
Remark(s)       :
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.operations;

public class Addition extends Operation {
    public Addition(){
        symbol = "+";
    }

    /**
     * Executes an addition of operand1 + operand2
     * @param operand1 The first operand
     * @param operand2 The second operand
     * @return The sum
     */
    @Override
    public int execute(int operand1, int operand2) {
        return operand1 + operand2;
    }
}
