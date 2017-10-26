package pl.karol.java.functional.chapter2.exercise2;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> triple = integer -> integer * 3;

        Function<Integer, Integer> square = integer -> integer * integer;

        //5*5*3
        Integer result = compose(triple, square).apply(5);

        System.out.println("Result: " + result);


    }

    static Function<Integer, Integer> compose(Function<Integer, Integer> f1,
                                              Function<Integer, Integer> f2) {
        return integer -> f1.apply(f2.apply(integer));
    }
}
