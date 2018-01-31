package pl.karol.java.functional.chapter4.exercise6;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> add = x -> x * 2;
        Function<Integer, Integer> add2 = x -> x * 3;
        List<Function<Integer, Integer>> numbers = Arrays.asList(add, add2);

        System.out.println(CollectionUtilites.composeAll(numbers).apply(3));

    }


}

