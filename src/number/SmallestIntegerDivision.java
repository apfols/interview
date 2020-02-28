package number;

import java.util.HashSet;

/**
 * 1. 111 % K = ((11 % K) * 10) + 1 %K
 * 2. To terminate the search, find out if there is any duplicate remainder
 */
public class SmallestIntegerDivision {
    public int smallestRepunitDivByK(int K) {
        if (K == 1)
            return 1;

        if (K % 2 == 0)
            return -1;

        HashSet<Integer> set = new HashSet<>();

        int num = 1;
        int count = 1;
        while (!set.contains(num)) {
            set.add(num);
            count++;
            num = (num * 10 + 1) % K;

            if (num == 0)
                return count;
        }

        return -1;
    }

    public static void main(String[] args) {
        SmallestIntegerDivision div = new SmallestIntegerDivision();
        System.out.println(div.smallestRepunitDivByK(1));
        System.out.println(div.smallestRepunitDivByK(2));
        System.out.println(div.smallestRepunitDivByK(3));
        System.out.println(div.smallestRepunitDivByK(5));
        System.out.println(div.smallestRepunitDivByK(7));

    }
}
