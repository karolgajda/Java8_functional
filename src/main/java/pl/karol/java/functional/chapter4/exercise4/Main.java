package pl.karol.java.functional.chapter4.exercise4;


import pl.karol.java.functional.chapter4.exercise3.CollectionUtilites;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("range: " + range(2, 10, new ArrayList<>()));
    }

    static List<Integer> range(int start, int end, List<Integer> result) {
        TailCall<List<Integer>> listTailCall = range_(start, end, result);
        return listTailCall.eval();
    }

    static TailCall<List<Integer>> range_(int start, int end, List<Integer> result) {
        if (start == end) {
            return TailCall.ret(result);
        }
        return TailCall.sus(
                () -> range_(start + 1, end, CollectionUtilites.addend(result, start))
        );
    }


}

