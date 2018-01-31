package pl.karol.java.functional.chapter4.exercise3;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 10, 6);

        Integer value = CollectionUtilites.foldLeft(numbers, 0, x -> y -> x + y);
        System.out.println("Valie is:" + value);

    }


}

