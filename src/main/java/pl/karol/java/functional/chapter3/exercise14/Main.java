package pl.karol.java.functional.chapter3.exercise14;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("range: " + range(2, 20));
    }

    static List<Integer> range(int start, int end) {
        List<Integer> integers = new ArrayList<>();
        if (start == end) {
            return integers;
        }
        List<Integer> range = range(start + 1, end);
        return CollectionUtilites.preaddend(range, start);
    }

}
