package pl.karol.java.functional.chapter2.exercise7;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<Integer, Integer> square = integer -> integer * integer;

        //(5*3)^2
        Integer result = Main.<Integer, Integer, Integer>partialA(5, x -> square).apply(5);
        System.out.println("Result: " + result);
    }

    static <T, U, V> Function<U, V> partialA(T arg1, Function<T, Function<U, V>> fun) {
        return fun.apply(arg1);
    }


}
