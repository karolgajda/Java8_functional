package pl.karol.java.functional.chapter4.exercise1;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4);

        numbers.forEach(n -> System.out.println("Fiboncacci for " + n + " is: " + fibonacci(n)));

    }

    public static int fibonacci(int n) {
        return fibonacci(1, 0, n);
    }

    public static int fibonacci(int a1, int a2, int n) {
        System.out.println("a1= " + a1 + " a2= " + a2);
        if (n == 0) {
            return n;
        } else if (n == 1) {
            return a1 + a2;
        } else {
            return fibonacci(a2, a1 + a2, n - 1);
        }
    }


}

