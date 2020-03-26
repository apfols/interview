package number;

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/submissions/
 */
public class MinFlips {

    /**
     * Solution:
     *  - iterate over each digit
     *    - calculate each digit: d % 2 == 1
     *    - calculate remain number: d / 2
     *    - if digit is matched => do nothing
     *    - if digit is not matched => accumulate flips
     *
     * assume max number of digits is n
     * time: O(n)
     */
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a != 0 || b != 0 || c != 0) {
            boolean bA = a % 2 == 1;
            boolean bB = b % 2 == 1;
            boolean bC = c % 2 == 1;

            if ((bA || bB) != bC) {
                if (bC)
                    flips++;
                else {
                    if (bA)
                        flips++;
                    if (bB)
                        flips++;
                }
            }


            a /= 2;
            b /= 2;
            c /= 2;
        }

        return flips;
    }

    public static void main(String[] args) {
        MinFlips m = new MinFlips();
//        System.out.println(m.minFlips(2, 6, 5));
//        System.out.println(m.minFlips(4, 2, 7));
//        System.out.println(m.minFlips(1, 2, 3));
        System.out.println(m.minFlips(8, 3, 5));

    }
}
