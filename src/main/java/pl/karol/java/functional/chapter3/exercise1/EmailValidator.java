package pl.karol.java.functional.chapter3.exercise1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidator {
    final static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");

    final static Function<String, Result> emailChecker = mail -> {
        if (mail == null) {
            return Result.failure("E-mail nie może być NULL");
        } else if (mail.isEmpty()) {
            return Result.failure("E-mail nie może być pusty");

        } else if (emailPattern.matcher(mail).matches()) {
            return Result.success(mail);
        } else {
            return Result.failure("E-mail " + mail + " jest nie prawidłowy");

        }
    };

    Result validate(String mail) {
        return emailChecker.apply(mail);
    }

}

interface Result<T> {

    void bind(Consumer<T> success, Consumer<String> error);

    static <T> Result<T> failure(String message) {
        return new Failue<>(message);
    }

    static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    class Success<T> implements Result<T> {

        private final T value;


        public Success(T value) {
            this.value = value;
        }

        @Override
        public void bind(Consumer<T> success, Consumer<String> error) {
            success.accept(value);
        }
    }

    class Failue<T> implements Result<T> {
        private final String errorMessage;

        public Failue(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public void bind(Consumer<T> success, Consumer<String> error) {
            error.accept(errorMessage);
        }
    }
}
