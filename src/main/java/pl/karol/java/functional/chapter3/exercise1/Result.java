package pl.karol.java.functional.chapter3.exercise1;

import java.util.function.Consumer;

public interface Result<T> {

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
