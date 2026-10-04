package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorInkStyle extends ArrayList<InkStyle> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorInkStyle(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorInkStyle sWIGVectorInkStyle) {
        if (sWIGVectorInkStyle == null) {
            return 0L;
        }
        return sWIGVectorInkStyle.swigCPtr;
    }

    public SWIGVectorInkStyle(Iterable<InkStyle> iterable) {
        this(ATKCoreJNI.new_SWIGVectorInkStyle(), true);
        Iterator<InkStyle> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public InkStyle get(int i) {
        return m1051at(i);
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
    public Iterator<InkStyle> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<InkStyle> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorInkStyle.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public InkStyle next() {
            if (this.cursor >= SWIGVectorInkStyle.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorInkStyle sWIGVectorInkStyle = SWIGVectorInkStyle.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorInkStyle.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(InkStyle inkStyle) {
        ATKCoreJNI.SWIGVectorInkStyle_push_back(this.swigCPtr, this, InkStyle.getCPtr(inkStyle), inkStyle);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorInkStyle_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public InkStyle m1051at(int i) {
        return new InkStyle(ATKCoreJNI.SWIGVectorInkStyle_at(this.swigCPtr, this, i), true);
    }
}
