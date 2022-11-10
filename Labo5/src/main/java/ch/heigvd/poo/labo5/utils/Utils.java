package ch.heigvd.poo.labo5.utils;

public final class Utils {
    public static int nbDigits(int number) {
        if (number == 0)
            return 1;
        return (int) Math.log10(number) + 1;
    }
}