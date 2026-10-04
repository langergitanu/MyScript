package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorExtent extends ArrayList<Extent> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorExtent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorExtent sWIGVectorExtent) {
        if (sWIGVectorExtent == null) {
            return 0L;
        }
        return sWIGVectorExtent.swigCPtr;
    }

    public SWIGVectorExtent(Iterable<Extent> iterable) {
        this(ATKCoreJNI.new_SWIGVectorExtent(), true);
        Iterator<Extent> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Extent get(int i) {
        return m1048at(i);
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
    public Iterator<Extent> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Extent> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorExtent.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Extent next() {
            if (this.cursor >= SWIGVectorExtent.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorExtent sWIGVectorExtent = SWIGVectorExtent.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorExtent.get(i);
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
                ATKCoreJNI.delete_SWIGVectorExtent(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(Extent extent) {
        ATKCoreJNI.SWIGVectorExtent_push_back(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorExtent_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public Extent m1048at(int i) {
        return new Extent(ATKCoreJNI.SWIGVectorExtent_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorExtent() {
        this(ATKCoreJNI.new_SWIGVectorExtent(), true);
    }
}
