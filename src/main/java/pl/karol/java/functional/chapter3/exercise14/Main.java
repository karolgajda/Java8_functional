package pl.karol.java.functional.chapter3.exercise14;


import java.util.Arrays;
import java.util.List;

import static pl.karol.java.functional.chapter3.exercise14.CollectionUtilites.returnHeadElement;
import static pl.karol.java.functional.chapter3.exercise14.CollectionUtilites.returnTailElement;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5);
        System.out.println("range: " + sum(list));
    }

    static Integer sum(List<Integer> list) {
        return sumTail(list, 0);
    }

    private static Integer sumTail(List<Integer> list, int i) {
        return list.isEmpty()
                ? i
                : sumTail(returnTailElement(list), i + returnHeadElement(list));
    }

}
