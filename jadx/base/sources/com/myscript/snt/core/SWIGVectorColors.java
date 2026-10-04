package com.myscript.snt.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorColors extends ArrayList<Integer> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorColors(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorColors sWIGVectorColors) {
        if (sWIGVectorColors == null) {
            return 0L;
        }
        return sWIGVectorColors.swigCPtr;
    }

    public SWIGVectorColors(Iterable<Integer> iterable) {
        this(NeboEngineJNI.new_SWIGVectorColors(), true);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next().intValue());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(m1095at(i));
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
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Integer> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorColors.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            if (this.cursor >= SWIGVectorColors.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorColors sWIGVectorColors = SWIGVectorColors.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorColors.get(i);
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
                NeboEngineJNI.delete_SWIGVectorColors(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(int i) {
        NeboEngineJNI.SWIGVectorColors_push_back(this.swigCPtr, this, i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboEngineJNI.SWIGVectorColors_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public int m1095at(int i) {
        return NeboEngineJNI.SWIGVectorColors_at(this.swigCPtr, this, i);
    }

    public SWIGVectorColors() {
        this(NeboEngineJNI.new_SWIGVectorColors(), true);
    }
}
