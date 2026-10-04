package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorCloudFileIdRev extends ArrayList<CloudFileIdRev> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCloudFileIdRev(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCloudFileIdRev sWIGVectorCloudFileIdRev) {
        if (sWIGVectorCloudFileIdRev == null) {
            return 0L;
        }
        return sWIGVectorCloudFileIdRev.swigCPtr;
    }

    public SWIGVectorCloudFileIdRev(Iterable<CloudFileIdRev> iterable) {
        this(NeboDMSJNI.new_SWIGVectorCloudFileIdRev(), true);
        Iterator<CloudFileIdRev> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public CloudFileIdRev get(int i) {
        return m1106at(i);
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
    public Iterator<CloudFileIdRev> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<CloudFileIdRev> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCloudFileIdRev.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CloudFileIdRev next() {
            if (this.cursor >= SWIGVectorCloudFileIdRev.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCloudFileIdRev sWIGVectorCloudFileIdRev = SWIGVectorCloudFileIdRev.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCloudFileIdRev.get(i);
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
                NeboDMSJNI.delete_SWIGVectorCloudFileIdRev(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(CloudFileIdRev cloudFileIdRev) {
        NeboDMSJNI.SWIGVectorCloudFileIdRev_push_back(this.swigCPtr, this, CloudFileIdRev.getCPtr(cloudFileIdRev), cloudFileIdRev);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorCloudFileIdRev_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public CloudFileIdRev m1106at(int i) {
        return new CloudFileIdRev(NeboDMSJNI.SWIGVectorCloudFileIdRev_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorCloudFileIdRev() {
        this(NeboDMSJNI.new_SWIGVectorCloudFileIdRev(), true);
    }
}
