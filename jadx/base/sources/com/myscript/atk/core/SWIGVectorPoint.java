package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorPoint extends ArrayList<Point> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorPoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorPoint sWIGVectorPoint) {
        if (sWIGVectorPoint == null) {
            return 0L;
        }
        return sWIGVectorPoint.swigCPtr;
    }

    public SWIGVectorPoint(Iterable<Point> iterable) {
        this(ATKCoreJNI.new_SWIGVectorPoint(), true);
        Iterator<Point> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Point get(int i) {
        return m1056at(i);
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
    public Iterator<Point> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Point> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorPoint.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Point next() {
            if (this.cursor >= SWIGVectorPoint.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorPoint sWIGVectorPoint = SWIGVectorPoint.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorPoint.get(i);
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
                ATKCoreJNI.delete_SWIGVectorPoint(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(Point point) {
        ATKCoreJNI.SWIGVectorPoint_push_back(this.swigCPtr, this, Point.getCPtr(point), point);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorPoint_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public Point m1056at(int i) {
        return new Point(ATKCoreJNI.SWIGVectorPoint_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorPoint() {
        this(ATKCoreJNI.new_SWIGVectorPoint(), true);
    }
}
