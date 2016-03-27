package tutor.hellow;

import java.io.InputStream;

/**
 * Created by Bomot on 2016.03.27..
 */
public class Fraction {
    public Fraction(int c, int d) {
        int lko = gcd(c, d);

        counter = c / lko;
        denominator = d / lko;

    }

    private static int gcd(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        return new Fraction(a.counter * b.counter, a.denominator * b.denominator);
    }

    private int counter;
    private int denominator;

    @Override
    public String toString() {
        return Integer.toString(counter) + "/" + Integer.toString(denominator);
    }
}
