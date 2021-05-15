package interview2.calculator;

import utils.Test;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * Assume length of s is n
 *
 * Solution 1: use stack
 *   Time: O(n)
 *   Space: O(n)
 *
 * Solution 2: accumulate number directly
 *   Time: O(n)
 *   Space: O(1)
 * Tips:
 *    1. use accNum = accNum * 10 + current - '0' to accumulate instead of StringBuilder to save time
 *    2. when found new operation,
 *       - if it's '+' or '-', update total
 *       - if it's '*' or '/', update prevNum
 *    3. remember to update total after iteration
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int total = 0;
        int prevNum = 0;
        char prevOp = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num = num * 10 + current - '0';
                continue;
            }

            if (current == ' ')
                continue;

            // current is +,-,*,/
            if (current == '+' || current == '-') { // if current is '+' or '-', update total and set preNum to 0
                if (prevOp == '+') {
                    total += num;
                } else if (prevOp == '-') {
                    total -= num;
                } else if (prevOp == '*') {
                    total += prevNum * num;
                } else { // '/'
                    total += prevNum / num;
                }
                prevNum = 0;
            } else { // if current  is '*' or '/', update prevNum
                if (prevOp == '+') {
                    prevNum = num;
                } else if (prevOp == '-') {
                    prevNum = -num;
                } else if (prevOp == '*') {
                    prevNum *= num;
                } else { // '/'
                    prevNum /= num;
                }
            }

            // update prevOp = current, num = 0
            prevOp = current;
            num = 0;
        }

        // update total again for last num
        if (prevOp == '+') {
            total += num;
        } else if (prevOp == '-') {
            total -= num;
        } else if (prevOp == '*') {
            total += prevNum * num;
        } else { // '/'
            total += prevNum / num;
        }

        return total;
    }

    public static void main(String[] args) {
        BasicCalculatorII c = new BasicCalculatorII();
        Test.check(7, c.calculate("3+2*2"));
        Test.check(1, c.calculate(" 3/2 "));
        Test.check(5, c.calculate(" 3+5 / 2 "));
    }
}
