package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorSpanInterval extends ArrayList<SpanInterval> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorSpanInterval(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorSpanInterval sWIGVectorSpanInterval) {
        if (sWIGVectorSpanInterval == null) {
            return 0L;
        }
        return sWIGVectorSpanInterval.swigCPtr;
    }

    public SWIGVectorSpanInterval(Iterable<SpanInterval> iterable) {
        this(ATKCoreJNI.new_SWIGVectorSpanInterval(), true);
        Iterator<SpanInterval> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public SpanInterval get(int i) {
        return m1058at(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int size = size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<SpanInterval> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<SpanInterval> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorSpanInterval.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public SpanInterval next() {
            if (this.cursor >= SWIGVectorSpanInterval.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorSpanInterval sWIGVectorSpanInterval = SWIGVectorSpanInterval.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorSpanInterval.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_SWIGVectorSpanInterval(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(SpanInterval spanInterval) {
        ATKCoreJNI.SWIGVectorSpanInterval_push_back(this.swigCPtr, this, SpanInterval.getCPtr(spanInterval), spanInterval);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorSpanInterval_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public SpanInterval m1058at(int i) {
        return new SpanInterval(ATKCoreJNI.SWIGVectorSpanInterval_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorSpanInterval() {
        this(ATKCoreJNI.new_SWIGVectorSpanInterval(), true);
    }
}
