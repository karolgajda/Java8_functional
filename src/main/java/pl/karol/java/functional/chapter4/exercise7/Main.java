package pl.karol.java.functional.chapter4.exercise7;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<String, String> f1 = x -> "(a" + x + ")";
        Function<String, String> f2 = x -> "{b" + x + ")";
        Function<String, String> f3 = x -> "[c" + x + ")";
        List<Function<String, String>> numbers = Arrays.asList(f1, f2, f3);

        System.out.println(CollectionUtilites.composeViaLeft(numbers).apply("x"));
        System.out.println(CollectionUtilites.composeViaRight(numbers).apply("x"));

    }


}

