package pl.karol.java.functional.chapter3.exercise2;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;

import static pl.karol.java.functional.chapter3.exercise2.Case.match;
import static pl.karol.java.functional.chapter3.exercise2.Case.mcase;
import static pl.karol.java.functional.chapter3.exercise2.Result.failure;
import static pl.karol.java.functional.chapter3.exercise2.Result.success;

public class Main {

    public static void main(String[] args) {

        emailChecker.apply("karoll.gajda@gmail.com").bind(onSuccess, onError);
        emailChecker.apply("karo").bind(onSuccess, onError);
        emailChecker.apply("").bind(onSuccess, onError);
        emailChecker.apply(null).bind(onSuccess, onError);
    }

    final static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");

    static Consumer<String> onSuccess = s -> System.out.println("E-mail został wysłany: " + s);
    static Consumer<String> onError = s -> System.err.println("Błąd: " + s);

    final static Function<String, Result<String>> emailChecker = s -> match(
            mcase(() -> success(s)),
            mcase(() -> s == null, () -> failure("E-mail nie może być NULL")),
            mcase(() -> s.isEmpty(), () -> failure("E-mail nie może być pusty")),
            mcase(() -> !emailPattern.matcher(s).matches(), () -> failure("E-mail jest błędny"))

    );

}

