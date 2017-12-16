package pl.karol.java.functional.chapter3.exercise5;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 4);
        Integer sum = CollectionUtilites.fold(integers, 0, x -> y -> x + y);
        System.out.println("Suma: " + sum);
    }
}
