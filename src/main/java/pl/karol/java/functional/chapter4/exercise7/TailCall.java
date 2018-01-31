package pl.karol.java.functional.chapter4.exercise7;

import java.util.function.Supplier;

public abstract class TailCall<T> {
    public abstract TailCall<T> resume();

    public abstract T eval();

    public abstract boolean isSuspend();

    private TailCall() {

    }

    private static class Return<T> extends TailCall<T> {

        private final T t;

        private Return(T t) {
            this.t = t;
        }

        @Override
        public TailCall<T> resume() {
            throw new IllegalStateException();
        }

        @Override
        public T eval() {
            return t;
        }

        @Override
        public boolean isSuspend() {
            return false;
        }
    }

    private static class Suspend<T> extends TailCall<T> {

        private final Supplier<TailCall<T>> resume;

        private Suspend(Supplier<TailCall<T>> resume) {
            this.resume = resume;
        }

        @Override
        public TailCall<T> resume() {
            return resume.get();
        }

        @Override
        public T eval() {
            TailCall<T> tailRes = this;
            while (tailRes.isSuspend()) {
                tailRes = tailRes.resume();
            }
            return tailRes.eval();

        }

        @Override
        public boolean isSuspend() {
            return true;
        }
    }

    public static <T> Return<T> ret(T t) {
        return new Return<>(t);
    }

    public static <T> Suspend<T> sus(Supplier<TailCall<T>> s) {
        return new Suspend<>(s);
    }

}