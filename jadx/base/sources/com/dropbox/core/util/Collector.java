package com.dropbox.core.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Collector<E, L> {
    public abstract void add(E e);

    public abstract L finish();

    public static final class ArrayListCollector<E> extends Collector<E, ArrayList<E>> {
        private ArrayList<E> list = new ArrayList<>();

        @Override // com.dropbox.core.util.Collector
        public void add(E e) {
            ArrayList<E> arrayList = this.list;
            if (arrayList == null) {
                throw new IllegalStateException("already called finish()");
            }
            arrayList.add(e);
        }

        @Override // com.dropbox.core.util.Collector
        public ArrayList<E> finish() {
            ArrayList<E> arrayList = this.list;
            if (arrayList == null) {
                throw new IllegalStateException("already called finish()");
            }
            this.list = null;
            return arrayList;
        }
    }

    public static final class NullSkipper<E, L> extends Collector<E, L> {
        private final Collector<E, L> underlying;

        public NullSkipper(Collector<E, L> collector) {
            this.underlying = collector;
        }

        /* JADX INFO: renamed from: mk */
        public static <E, L> Collector<E, L> m518mk(Collector<E, L> collector) {
            return new NullSkipper(collector);
        }

        @Override // com.dropbox.core.util.Collector
        public void add(E e) {
            if (e != null) {
                this.underlying.add(e);
            }
        }

        @Override // com.dropbox.core.util.Collector
        public L finish() {
            return this.underlying.finish();
        }
    }
}
