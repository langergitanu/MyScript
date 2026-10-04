package com.myscript.atk.p021ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGShapeCandidate extends ArrayList<ShapeCandidate> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGShapeCandidate(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGShapeCandidate sWIGShapeCandidate) {
        if (sWIGShapeCandidate == null) {
            return 0L;
        }
        return sWIGShapeCandidate.swigCPtr;
    }

    public SWIGShapeCandidate(Iterable<ShapeCandidate> iterable) {
        this(ATKSharedUIJNI.new_SWIGShapeCandidate(), true);
        Iterator<ShapeCandidate> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ShapeCandidate get(int i) {
        return m1065at(i);
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
    public Iterator<ShapeCandidate> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<ShapeCandidate> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGShapeCandidate.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ShapeCandidate next() {
            if (this.cursor >= SWIGShapeCandidate.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGShapeCandidate sWIGShapeCandidate = SWIGShapeCandidate.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGShapeCandidate.get(i);
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
                ATKSharedUIJNI.delete_SWIGShapeCandidate(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(ShapeCandidate shapeCandidate) {
        ATKSharedUIJNI.SWIGShapeCandidate_push_back(this.swigCPtr, this, ShapeCandidate.getCPtr(shapeCandidate), shapeCandidate);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKSharedUIJNI.SWIGShapeCandidate_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public ShapeCandidate m1065at(int i) {
        return new ShapeCandidate(ATKSharedUIJNI.SWIGShapeCandidate_at(this.swigCPtr, this, i), true);
    }

    public SWIGShapeCandidate() {
        this(ATKSharedUIJNI.new_SWIGShapeCandidate(), true);
    }
}
