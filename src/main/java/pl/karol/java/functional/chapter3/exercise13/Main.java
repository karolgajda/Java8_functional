package pl.karol.java.functional.chapter3.exercise13;


import pl.karol.java.functional.chapter3.exercise12.CollectionUtilites;

import java.util.List;

public class
Main {

    public static void main(String[] args) {
        System.out.println("range: " + range(2, 20));
    }

    static List<Integer> range(int start, int end) {
        return CollectionUtilites.unflold(start, i -> ++i, i -> i < end);
    }

}
