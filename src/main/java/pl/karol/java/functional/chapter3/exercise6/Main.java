package pl.karol.java.functional.chapter3.exercise6;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 4);
        Function<String, Function<Integer, String>> function = x -> y -> addSI(x, y);
        String identity = "0";
        String sum = CollectionUtilites.foldLeft(integers, identity, function);
        System.out.println("Suma: " + sum);
    }

    private static String addSI(String x, Integer y) {
        return "(" + x + " + " + y + " )";
    }
}
