package johnson.scott.calculator.model;

import java.util.*;

public class CalculatorModel {
    private String calcType;
    private int n;
    private int r;
    //private long numerator;
    //private long denominator;
    private double answer;

    /**
     * @return the calcType
     */
    public String getCalcType() {
        return calcType;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @return the r
     */
    public int getR() {
        return r;
    }

    /**
     * @return the answer
     */
    public double getAnswer() {
        return answer;
    }

    public void parseLine(String line) {
        line.trim();
        Scanner calc = new Scanner(line);
        calcType = calc.next();
        n = calc.nextInt();
        r = calc.nextInt();
        calc.close();
        if (calcType.equalsIgnoreCase("P"))
            permutation(n, r);
        if (calcType.equalsIgnoreCase("C"))
            combination(n, r);
    }

    public double permutation(int n, int r) {
        if (r == 0) {
            answer = 1;
            return answer;
        } else
            answer = n * permutation(n - 1, r - 1);
        return answer;
    }
    /*
     * public long permutation(int n, int r) { if (n >= 0 && r >= 0) { answer =
     * 1; for (int i = n; i > n - r; i--) { answer = answer * i; } } return
     * answer; }
     */

    public double combination(int n, int r) {
        if (r == 0) {
            answer = 1;
            return answer;
        } else {
            answer = ((double) n / (double) r) * combination(n - 1, r - 1);
        }
        return answer;
    }

    /*
     * public long combination(int n, int r) { if (n >= 0 && r >= 0) { numerator
     * = 1; denominator = 1; for (int i = n; i > r; i--) { numerator = numerator
     * * i; } for (int i = (n - r); i > 1; i--) { denominator = denominator * i;
     * } answer = numerator / denominator; } return answer; }
     */
}
