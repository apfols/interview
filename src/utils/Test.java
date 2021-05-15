package utils;

public class Test {
    public static void check(boolean expect, boolean actual) {
        System.out.println("expect;" + expect + ";actual;" + actual + ";equal;" + (expect == actual));
    }

    public static void check(int expect, int actual) {
        System.out.println("expect;" + expect + ";actual;" + actual + ";equal;" + (expect == actual));
    }
}
