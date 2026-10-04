package com.dropbox.core.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Maybe<T> {
    private static final Maybe<Object> Nothing = new Nothing();

    public abstract boolean equals(Maybe<T> maybe);

    public abstract T get(T t);

    public abstract T getJust();

    public abstract int hashCode();

    public abstract boolean isJust();

    public abstract boolean isNothing();

    public abstract String toString();

    private Maybe() {
    }

    public static <T> Maybe<T> Just(T t) {
        return new Just(t);
    }

    private static final class Just<T> extends Maybe<T> {
        private final T value;

        @Override // com.dropbox.core.util.Maybe
        public boolean isJust() {
            return true;
        }

        @Override // com.dropbox.core.util.Maybe
        public boolean isNothing() {
            return false;
        }

        private Just(T t) {
            super();
            this.value = t;
        }

        @Override // com.dropbox.core.util.Maybe
        public T getJust() {
            return this.value;
        }

        @Override // com.dropbox.core.util.Maybe
        public T get(T t) {
            return this.value;
        }

        @Override // com.dropbox.core.util.Maybe
        public String toString() {
            return "Just(" + this.value + ")";
        }

        @Override // com.dropbox.core.util.Maybe
        public int hashCode() {
            return LangUtil.nullableHashCode(this.value) + 1;
        }

        @Override // com.dropbox.core.util.Maybe
        public boolean equals(Maybe<T> maybe) {
            if (maybe instanceof Just) {
                return LangUtil.nullableEquals(this.value, ((Just) maybe).value);
            }
            if (maybe instanceof Nothing) {
                return false;
            }
            throw LangUtil.badType(maybe);
        }
    }

    public static <T> Maybe<T> Nothing() {
        return (Maybe<T>) Nothing;
    }

    private static final class Nothing<T> extends Maybe<T> {
        @Override // com.dropbox.core.util.Maybe
        public boolean equals(Maybe<T> maybe) {
            return maybe == this;
        }

        @Override // com.dropbox.core.util.Maybe
        public T get(T t) {
            return t;
        }

        @Override // com.dropbox.core.util.Maybe
        public int hashCode() {
            return 0;
        }

        @Override // com.dropbox.core.util.Maybe
        public boolean isJust() {
            return false;
        }

        @Override // com.dropbox.core.util.Maybe
        public boolean isNothing() {
            return true;
        }

        private Nothing() {
            super();
        }

        @Override // com.dropbox.core.util.Maybe
        public T getJust() {
            throw new IllegalStateException("can't call getJust() on a Nothing");
        }

        @Override // com.dropbox.core.util.Maybe
        public String toString() {
            return "Nothing";
        }
    }
}
