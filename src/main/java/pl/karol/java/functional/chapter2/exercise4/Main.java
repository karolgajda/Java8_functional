package pl.karol.java.functional.chapter2.exercise4;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> triple = integer -> integer * 3;

        Function<Integer, Integer> square = integer -> integer * integer;

        //5*5*3
        Function<Function<Integer, Integer>,
                    Function<Function<Integer, Integer>,
                        Function<Integer, Integer>>> compose =
                f1 -> f2 -> integer -> f1.apply(f2.apply(integer));
        System.out.println("Result: " + compose.apply(triple).apply(square).apply(5));


    }

}
