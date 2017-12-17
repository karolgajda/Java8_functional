package pl.karol.java.functional.chapter3.exercise11;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("range: " + range(0, 10));
    }

    static List<Integer> range(int start, int end) {
        List<Integer> result = new ArrayList<>();
        int temp = start;
        while (temp < end) {
            result = CollectionUtilites.addend(result, temp);
            temp++;
        }
        return result;
    }

}
