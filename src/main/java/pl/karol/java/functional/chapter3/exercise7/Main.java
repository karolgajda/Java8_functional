package pl.karol.java.functional.chapter3.exercise7;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 6);
        Function<Integer, Function<String, String>> function = x -> y -> addSI(x, y);
        String identity = "0";
        String sum = CollectionUtilites.foldRight(integers, identity, function);
        System.out.println("Suma: " + sum);
    }

    private static String addSI(Integer x, String y) {
        return "(" + x + " + " + y + " )";
    }
}
