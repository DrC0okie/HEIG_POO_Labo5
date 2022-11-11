/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Operation.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Abstract class who serve as base for the subclasses
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.operations;

public abstract class Operation {
    protected String symbol = "";

    /**
     * Executes a subtraction of operand1 - operand2
     * @param operand1 The first operand
     * @param operand2 The second operand
     * @return The result of the operation
     */
    public abstract int execute(int operand1, int operand2);

    /**
     * Returns the symbol corresponding to the operation
     * @return the symbol of the operation
     */
    @Override
    public String toString(){
        return symbol;
    }
}
