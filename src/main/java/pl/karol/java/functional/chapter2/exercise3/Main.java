package pl.karol.java.functional.chapter2.exercise3;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;

        Integer result = add.apply(5).apply(10);

        System.out.println("Result: " + result);


    }

}
