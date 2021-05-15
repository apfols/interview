package interview2.calculator;

import utils.Test;

/**
 * https://leetcode.com/problems/basic-calculator/
 * Similar to BasicCalculator and use recursion to deal with ()
 *
 * Time: O(n)
 * Space: O(k), k number of '(' inside '()' (stack size)
 */
public class BasicCalculator {

    // end index, total
    public int[] calculate(String s, int start) {
        int total = 0;
        char prevOp = '+';
        int num = 0;
        char c;
        while (start < s.length() && (c = s.charAt(start++)) != ')') {
            if (c == '(') {
                int[] next = calculate(s, start);
                start = next[0];
                num = next[1];
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+' || c == '-') {
                if (prevOp == '+')
                    total += num;
                else
                    total -= num;

                num = 0;
                prevOp = c;
            }
        }

        if (prevOp == '+')
            total += num;
        else
            total -= num;

        return new int[] {start, total};
    }

    public int calculate(String s) {
        return calculate(s, 0)[1];
    }

    public static void main(String[] args) {
        BasicCalculator c = new BasicCalculator();
        Test.check(2, c.calculate("1 + 1"));
        Test.check(3, c.calculate(" 2-1 + 2 "));
        Test.check(23, c.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
