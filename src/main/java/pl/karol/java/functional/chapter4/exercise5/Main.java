package pl.karol.java.functional.chapter4.exercise5;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        String value = CollectionUtilites.foldRightRec(numbers, "0", x -> y -> add(x, y));
        System.out.println(value);

    }

    public static String add(Integer x, String y) {
        return "(" + x + "+" + y + ")";
    }


}

