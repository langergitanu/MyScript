package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorPendingStroke extends ArrayList<PendingStroke> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorPendingStroke(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorPendingStroke sWIGVectorPendingStroke) {
        if (sWIGVectorPendingStroke == null) {
            return 0L;
        }
        return sWIGVectorPendingStroke.swigCPtr;
    }

    public SWIGVectorPendingStroke(Iterable<PendingStroke> iterable) {
        this(ATKCoreJNI.new_SWIGVectorPendingStroke(), true);
        Iterator<PendingStroke> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public PendingStroke get(int i) {
        return m1055at(i);
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
    public Iterator<PendingStroke> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<PendingStroke> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorPendingStroke.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public PendingStroke next() {
            if (this.cursor >= SWIGVectorPendingStroke.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorPendingStroke sWIGVectorPendingStroke = SWIGVectorPendingStroke.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorPendingStroke.get(i);
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
                ATKCoreJNI.delete_SWIGVectorPendingStroke(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(PendingStroke pendingStroke) {
        ATKCoreJNI.SWIGVectorPendingStroke_push_back(this.swigCPtr, this, PendingStroke.getCPtr(pendingStroke), pendingStroke);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorPendingStroke_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public PendingStroke m1055at(int i) {
        return new PendingStroke(ATKCoreJNI.SWIGVectorPendingStroke_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorPendingStroke() {
        this(ATKCoreJNI.new_SWIGVectorPendingStroke(), true);
    }
}
