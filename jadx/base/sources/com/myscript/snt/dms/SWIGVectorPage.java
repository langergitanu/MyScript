package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorPage extends ArrayList<Page> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorPage(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorPage sWIGVectorPage) {
        if (sWIGVectorPage == null) {
            return 0L;
        }
        return sWIGVectorPage.swigCPtr;
    }

    public SWIGVectorPage(Iterable<Page> iterable) {
        this(NeboDMSJNI.new_SWIGVectorPage(), true);
        Iterator<Page> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Page get(int i) {
        return m1111at(i);
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
    public Iterator<Page> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Page> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorPage.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Page next() {
            if (this.cursor >= SWIGVectorPage.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorPage sWIGVectorPage = SWIGVectorPage.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorPage.get(i);
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
                NeboDMSJNI.delete_SWIGVectorPage(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(Page page) {
        NeboDMSJNI.SWIGVectorPage_push_back(this.swigCPtr, this, Page.getCPtr(page), page);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorPage_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public Page m1111at(int i) {
        long jSWIGVectorPage_at = NeboDMSJNI.SWIGVectorPage_at(this.swigCPtr, this, i);
        if (jSWIGVectorPage_at == 0) {
            return null;
        }
        return new Page(jSWIGVectorPage_at, true);
    }

    public SWIGVectorPage() {
        this(NeboDMSJNI.new_SWIGVectorPage(), true);
    }
}
