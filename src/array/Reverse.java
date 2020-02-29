package array;

import java.util.Arrays;

public class Reverse {

    public int[] reverse(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(Arrays.toString(r.reverse(null)));
        System.out.println(Arrays.toString(r.reverse(new int[0])));
        System.out.println(Arrays.toString(r.reverse(new int[] { 1 })));
        System.out.println(Arrays.toString(r.reverse(new int[] { 1,2 })));
        System.out.println(Arrays.toString(r.reverse(new int[] { 1,2,3,4,5 })));
        System.out.println(Arrays.toString(r.reverse(new int[] { 1,2,3,4,5,6 })));

    }

}
