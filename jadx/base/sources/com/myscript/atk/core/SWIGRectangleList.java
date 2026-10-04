package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGRectangleList extends ArrayList<Rectangle> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGRectangleList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGRectangleList sWIGRectangleList) {
        if (sWIGRectangleList == null) {
            return 0L;
        }
        return sWIGRectangleList.swigCPtr;
    }

    public SWIGRectangleList(Iterable<Rectangle> iterable) {
        this(ATKCoreJNI.new_SWIGRectangleList(), true);
        Iterator<Rectangle> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Rectangle get(int i) {
        return m1044at(i);
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
    public Iterator<Rectangle> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Rectangle> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGRectangleList.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rectangle next() {
            if (this.cursor >= SWIGRectangleList.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGRectangleList sWIGRectangleList = SWIGRectangleList.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGRectangleList.get(i);
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
                ATKCoreJNI.delete_SWIGRectangleList(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(Rectangle rectangle) {
        ATKCoreJNI.SWIGRectangleList_push_back(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGRectangleList_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public Rectangle m1044at(int i) {
        return new Rectangle(ATKCoreJNI.SWIGRectangleList_at(this.swigCPtr, this, i), true);
    }

    public SWIGRectangleList() {
        this(ATKCoreJNI.new_SWIGRectangleList(), true);
    }
}
