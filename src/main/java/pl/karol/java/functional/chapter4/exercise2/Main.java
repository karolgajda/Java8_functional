package pl.karol.java.functional.chapter4.exercise2;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4);

        numbers.forEach(n -> System.out.println("Fiboncacci for " + n + " is: " + fibonacci(n)));

    }

    public static Integer fibonacci(Integer n) {
        return fibonacci(1, 0, n).eval();
    }

    public static TailCall<Integer> fibonacci(Integer a1, Integer a2, Integer n) {
        if (n == 0) {
            return TailCall.ret(n);
        } else if (n == 1) {
            return TailCall.ret(a1 + a2);
        } else {
            return TailCall.sus(() -> fibonacci(a2, a1 + a2, n - 1));
        }
    }

}

