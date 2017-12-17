package pl.karol.java.functional.chapter3.exercise9;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 6, 7, 9, 10);
        List<Integer> reverseIntegers = CollectionUtilites.reverse(integers);
        System.out.println("reverse: " + reverseIntegers);
    }

}
