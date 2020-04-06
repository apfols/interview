package string;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/submissions/
 */
public class MyAtoi {

    /**
     * Solution 1: calculate number by each digits
     * time: O(n)
     * space: O(1)
     */
//    public int myAtoi(String str) {
//        String first = str.trim().split("\\s+")[0];
//
//        if (first.isEmpty())
//            return 0;
//
//        int num = 0;
//        boolean sign = true;
//
//        int reminder = Integer.MAX_VALUE % 10;
//        int div = Integer.MAX_VALUE / 10;
//
//        for (int i = 0; i < first.length(); i++) {
//            Character c = first.charAt(i);
//
//            if (i == 0) {
//                if (c == '-') {
//                    sign = false;
//                    continue;
//                }
//
//                if (c == '+')
//                    continue;
//            }
//
//            if (!Character.isDigit(c)) {
//                break;
//            }
//
//            if (num > div) {
//                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            }
//
//            int current = Integer.parseInt(c.toString());
//            if (sign && num == div && current > reminder)
//                return Integer.MAX_VALUE;
//
//            if (!sign && num == div && current > reminder + 1)
//                return Integer.MIN_VALUE;
//
//            num = num * 10 + current;
//        }
//
//        return sign ? num : -num;
//    }

    /**
     * Solution 2: Find the target digit and use Integer.parseInt
     * if there is an exception => overflow situation
     *
     * boundary condition:
     * - ""
     * - " "
     * - "+"
     * - "-"
     * - "abcdef"
     *
     * time: O(n)
     * space: O(1)
     */
    public int myAtoi(String str) {
        str = str.trim();

        if (str.isEmpty())
            return 0;

        char firstChar = str.charAt(0);
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar))
            return 0;

        int ptr = 1;
        while (ptr < str.length() && Character.isDigit(str.charAt(ptr)))
            ptr++;

        String substring = str.substring(0, ptr);
        if (substring.equals("+") || substring.equals("-"))
            return 0;

        try {
            return Integer.parseInt(substring);
        } catch (Exception e) {
            return firstChar == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }



    public static void main(String[] args) {
        MyAtoi m = new MyAtoi();
        System.out.println(m.myAtoi("  "));
        System.out.println(m.myAtoi("+"));
        System.out.println(m.myAtoi("-"));
        System.out.println(m.myAtoi("42"));
        System.out.println(m.myAtoi("  -42"));
        System.out.println(m.myAtoi("4193 with words"));
        System.out.println(m.myAtoi("words and 987"));
        System.out.println(m.myAtoi("-91283472332"));
        System.out.println(m.myAtoi("3.14"));
        System.out.println(m.myAtoi("345abc"));


    }
}