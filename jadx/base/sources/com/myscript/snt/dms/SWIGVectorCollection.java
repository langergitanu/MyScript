package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorCollection extends ArrayList<Collection> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCollection(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCollection sWIGVectorCollection) {
        if (sWIGVectorCollection == null) {
            return 0L;
        }
        return sWIGVectorCollection.swigCPtr;
    }

    public SWIGVectorCollection(Iterable<Collection> iterable) {
        this(NeboDMSJNI.new_SWIGVectorCollection(), true);
        Iterator<Collection> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Collection get(int i) {
        return m1109at(i);
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
    public Iterator<Collection> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Collection> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCollection.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Collection next() {
            if (this.cursor >= SWIGVectorCollection.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCollection sWIGVectorCollection = SWIGVectorCollection.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCollection.get(i);
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
                NeboDMSJNI.delete_SWIGVectorCollection(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(Collection collection) {
        NeboDMSJNI.SWIGVectorCollection_push_back(this.swigCPtr, this, Collection.getCPtr(collection), collection);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorCollection_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public Collection m1109at(int i) {
        long jSWIGVectorCollection_at = NeboDMSJNI.SWIGVectorCollection_at(this.swigCPtr, this, i);
        if (jSWIGVectorCollection_at == 0) {
            return null;
        }
        return new Collection(jSWIGVectorCollection_at, true);
    }

    public SWIGVectorCollection() {
        this(NeboDMSJNI.new_SWIGVectorCollection(), true);
    }
}
