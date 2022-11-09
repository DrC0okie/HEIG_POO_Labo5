/*−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------
File name       : Program1.java
Author(s)       : Kevin Farine, Timothée Van Hove
Created         : 3 nov. 2022
Description     : Program that execute +, - and * operations on matrices created
                  with random values.
Remark(s)       : This program automatically closes after displaying the result.
JDK             : OpenJDK Runtime Environment Temurin-17.0.5+8 (build 17.0.5+8)
−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−------------------------------------------------*/
package ch.heigvd.poo.labo5.operations;

public class Multiplication extends Operation {
    @Override
    public int execute(int var1, int var2) {
        return var1 * var2;
    }
}
