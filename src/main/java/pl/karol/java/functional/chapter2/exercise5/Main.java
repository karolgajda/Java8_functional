package pl.karol.java.functional.chapter2.exercise5;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> triple = integer -> integer * 3;

        Function<Integer, Integer> square = integer -> integer * integer;

        //5*5*3
        Integer result = Main.<Integer, Integer, Integer>compose().apply(triple).apply(square).apply(5);
        System.out.println("Result: " + result);


    }

    static <T, U, V> Function<Function<U, V>,
            Function<Function<T, U>,
                    Function<T, V>>> compose() {
        return x -> y -> z -> x.apply(y.apply(z));
    }


}
