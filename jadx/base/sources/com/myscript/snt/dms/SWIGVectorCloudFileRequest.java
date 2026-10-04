package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorCloudFileRequest extends ArrayList<CloudFileRequest> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCloudFileRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest) {
        if (sWIGVectorCloudFileRequest == null) {
            return 0L;
        }
        return sWIGVectorCloudFileRequest.swigCPtr;
    }

    public SWIGVectorCloudFileRequest(Iterable<CloudFileRequest> iterable) {
        this(NeboDMSJNI.new_SWIGVectorCloudFileRequest(), true);
        Iterator<CloudFileRequest> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public CloudFileRequest get(int i) {
        return m1107at(i);
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
    public Iterator<CloudFileRequest> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<CloudFileRequest> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCloudFileRequest.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CloudFileRequest next() {
            if (this.cursor >= SWIGVectorCloudFileRequest.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest = SWIGVectorCloudFileRequest.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCloudFileRequest.get(i);
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
                NeboDMSJNI.delete_SWIGVectorCloudFileRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(CloudFileRequest cloudFileRequest) {
        NeboDMSJNI.SWIGVectorCloudFileRequest_push_back(this.swigCPtr, this, CloudFileRequest.getCPtr(cloudFileRequest), cloudFileRequest);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorCloudFileRequest_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public CloudFileRequest m1107at(int i) {
        return new CloudFileRequest(NeboDMSJNI.SWIGVectorCloudFileRequest_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorCloudFileRequest() {
        this(NeboDMSJNI.new_SWIGVectorCloudFileRequest(), true);
    }
}
