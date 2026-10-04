package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorPageProperties extends ArrayList<PageProperties> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorPageProperties(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorPageProperties sWIGVectorPageProperties) {
        if (sWIGVectorPageProperties == null) {
            return 0L;
        }
        return sWIGVectorPageProperties.swigCPtr;
    }

    public SWIGVectorPageProperties(Iterable<PageProperties> iterable) {
        this(NeboDMSJNI.new_SWIGVectorPageProperties(), true);
        Iterator<PageProperties> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public PageProperties get(int i) {
        return m1113at(i);
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
    public Iterator<PageProperties> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<PageProperties> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorPageProperties.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public PageProperties next() {
            if (this.cursor >= SWIGVectorPageProperties.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorPageProperties sWIGVectorPageProperties = SWIGVectorPageProperties.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorPageProperties.get(i);
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
                NeboDMSJNI.delete_SWIGVectorPageProperties(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(PageProperties pageProperties) {
        NeboDMSJNI.SWIGVectorPageProperties_push_back(this.swigCPtr, this, PageProperties.getCPtr(pageProperties), pageProperties);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorPageProperties_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public PageProperties m1113at(int i) {
        return new PageProperties(NeboDMSJNI.SWIGVectorPageProperties_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorPageProperties() {
        this(NeboDMSJNI.new_SWIGVectorPageProperties(), true);
    }
}
