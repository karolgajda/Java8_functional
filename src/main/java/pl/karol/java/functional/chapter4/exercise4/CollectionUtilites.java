package pl.karol.java.functional.chapter4.exercise4;


import pl.karol.java.functional.chapter4.exercise3.TailCall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CollectionUtilites {

    public static List createEmptyList() {
        return Collections.emptyList();
    }

    public static <T> List<T> createList(T value) {
        return Collections.singletonList(value);
    }

    public static <T> List<T> createList(List<T> values) {
        return Collections.unmodifiableList(new ArrayList<>(values));
    }

    public static <T> List<T> createList(T... values) {
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(values, values.length)));
    }


    public static <T> T returnHeadElement(List<T> list) {
        if (list.isEmpty()) throw new IllegalStateException("Head dla pustej wartości");
        return list.get(0);
    }

    public static <T> List<T> returnTailElement(List<T> list) {
        if (list.isEmpty()) throw new IllegalStateException("Head dla pustej wartości");
        List<T> copy = copy(list);
        copy.remove(0);
        return Collections.unmodifiableList(copy);
    }

    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }

    public static <T> List<T> addend(List<T> list, T t) {
        List<T> copy = copy(list);
        copy.add(t);
        return Collections.unmodifiableList(copy);
    }


    public static <T, U> U foldLeft(List<T> list, U a, Function<U, Function<T, U>> fun) {
        return foldLeft_(list, a, fun).eval();
    }

    private static <T, U> TailCall<U> foldLeft_(List<T> list, U a, Function<U, Function<T, U>> fun) {
        return list.isEmpty() ?
                TailCall.ret(a)
                : TailCall.sus(() -> foldLeft_(returnTailElement(list), fun.apply(a).apply(returnHeadElement(list)), fun));
    }


}

