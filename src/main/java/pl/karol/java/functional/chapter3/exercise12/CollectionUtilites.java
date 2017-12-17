package pl.karol.java.functional.chapter3.exercise12;


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

    public static <T> List<T> preaddend(List<T> list, T t) {
        return foldLeft(list, createList(t), a -> b -> addend(a, b));
    }

    public static <T, U> U foldLeft(List<T> list, U a, Function<U, Function<T, U>> fun) {
        U result = a;
        for (T el : list) {
            result = fun.apply(result).apply(el);
        }

        return result;
    }

    public static <T, U> U foldRight(List<T> list, U a, Function<T, Function<U, U>> fun) {
        U result = a;

        for (int i = list.size() - 1; i > 0; i--) {

            result = fun.apply(list.get(i)).apply(result);

        }

        return result;
    }

    public static <T, U> U foldRightRec(List<T> list, U a, Function<T, Function<U, U>> fun) {
        U result = a;

        if (list.isEmpty()) {
            return a;
        } else {
            result = fun.apply(returnHeadElement(list)).apply(foldRightRec(returnTailElement(list), result, fun));

        }

        return result;
    }

    public static <T> List<T> reverse(List<T> integers) {
        List<T> a = new ArrayList<>();
        return foldLeft(integers, a, u -> t -> preaddend(u, t));
    }

    public static <T, U> List<U> map(List<T> list, Function<T, U> f) {
        List<U> newList = new ArrayList<>();

        return foldLeft(list, newList, x -> y -> addend(x, f.apply(y)));
    }

    public static <T> List<T> unflold(T speed, Function<T, T> f, Function<T, Boolean> p) {
        List<T> result = new ArrayList<>();
        T temp = speed;
        while (p.apply(temp)) {
            result = CollectionUtilites.addend(result, temp);
            temp = f.apply(temp);
        }
        return result;
    }
}

