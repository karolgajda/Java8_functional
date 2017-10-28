package pl.karol.java.functional.chapter2.exercise6;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> triple = integer -> integer * 3;

        Function<Integer, Integer> square = integer -> integer * integer;

        //(5*3)^2
        Integer result = Main.<Integer, Integer, Integer>higerAndThen().apply(triple).apply(square).apply(5);
        System.out.println("Result: " + result);


    }

    static <T, U, V>
    Function<Function<T, U>,
            Function<Function<U, V>,
                    Function<T, V>>> higerAndThen() {
        return x -> y -> t -> y.apply(x.apply(t));
    }


}
