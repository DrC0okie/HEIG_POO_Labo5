package ch.heigvd.poo.labo5.operations;

public class Multiplication extends Operation {

    private static final String sign = "*";
    @Override
    public int execute(int var1, int var2) {
        return var1 * var2;
    }
}
