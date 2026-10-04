package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorPageAction extends ArrayList<PageAction> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorPageAction(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorPageAction sWIGVectorPageAction) {
        if (sWIGVectorPageAction == null) {
            return 0L;
        }
        return sWIGVectorPageAction.swigCPtr;
    }

    public SWIGVectorPageAction(Iterable<PageAction> iterable) {
        this(NeboDMSJNI.new_SWIGVectorPageAction(), true);
        Iterator<PageAction> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public PageAction get(int i) {
        return m1112at(i);
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
    public Iterator<PageAction> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<PageAction> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorPageAction.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public PageAction next() {
            if (this.cursor >= SWIGVectorPageAction.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorPageAction sWIGVectorPageAction = SWIGVectorPageAction.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorPageAction.get(i);
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
                NeboDMSJNI.delete_SWIGVectorPageAction(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(PageAction pageAction) {
        NeboDMSJNI.SWIGVectorPageAction_push_back(this.swigCPtr, this, pageAction.swigValue());
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorPageAction_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public PageAction m1112at(int i) {
        return PageAction.swigToEnum(NeboDMSJNI.SWIGVectorPageAction_at(this.swigCPtr, this, i));
    }

    public SWIGVectorPageAction() {
        this(NeboDMSJNI.new_SWIGVectorPageAction(), true);
    }
}
