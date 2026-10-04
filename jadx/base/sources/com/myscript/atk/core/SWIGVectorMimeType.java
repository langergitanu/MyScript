package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorMimeType extends ArrayList<MimeType> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorMimeType(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorMimeType sWIGVectorMimeType) {
        if (sWIGVectorMimeType == null) {
            return 0L;
        }
        return sWIGVectorMimeType.swigCPtr;
    }

    public SWIGVectorMimeType(Iterable<MimeType> iterable) {
        this(ATKCoreJNI.new_SWIGVectorMimeType(), true);
        Iterator<MimeType> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MimeType get(int i) {
        return m1052at(i);
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
    public Iterator<MimeType> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<MimeType> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorMimeType.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MimeType next() {
            if (this.cursor >= SWIGVectorMimeType.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorMimeType sWIGVectorMimeType = SWIGVectorMimeType.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorMimeType.get(i);
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
                ATKCoreJNI.delete_SWIGVectorMimeType(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(MimeType mimeType) {
        ATKCoreJNI.SWIGVectorMimeType_push_back(this.swigCPtr, this, mimeType.swigValue());
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorMimeType_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public MimeType m1052at(int i) {
        return MimeType.swigToEnum(ATKCoreJNI.SWIGVectorMimeType_at(this.swigCPtr, this, i));
    }

    public SWIGVectorMimeType() {
        this(ATKCoreJNI.new_SWIGVectorMimeType(), true);
    }
}
