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
    public Subtraction(){
        symbol = "-";
    }

    /**
     * Executes a subtraction of operand1 - operand2
     * @param operand1 The first operand
     * @param operand2 The second operand
     * @return The difference
     */
    @Override
    public int execute(int operand1, int operand2) {
        return operand1 - operand2;
    }
}
