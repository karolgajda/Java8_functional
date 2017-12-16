package pl.karol.java.functional.chapter3.exercise3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class CollectionUtilites {

    public final static List createEmptyList() {
        return Collections.emptyList();
    }

    public final static <T> List<T> createList(T value) {
        return Collections.singletonList(value);
    }

    public final static <T> List<T> createList(List<T> values) {
        return Collections.unmodifiableList(new ArrayList<>(values));
    }

    public final static <T> List<T> createList(T... values) {
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(values, values.length)));
    }


}

