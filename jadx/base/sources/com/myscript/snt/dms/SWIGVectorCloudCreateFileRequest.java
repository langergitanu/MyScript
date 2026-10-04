package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorCloudCreateFileRequest extends ArrayList<CloudCreateFileRequest> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCloudCreateFileRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest) {
        if (sWIGVectorCloudCreateFileRequest == null) {
            return 0L;
        }
        return sWIGVectorCloudCreateFileRequest.swigCPtr;
    }

    public SWIGVectorCloudCreateFileRequest(Iterable<CloudCreateFileRequest> iterable) {
        this(NeboDMSJNI.new_SWIGVectorCloudCreateFileRequest(), true);
        Iterator<CloudCreateFileRequest> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public CloudCreateFileRequest get(int i) {
        return m1103at(i);
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
    public Iterator<CloudCreateFileRequest> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<CloudCreateFileRequest> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCloudCreateFileRequest.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CloudCreateFileRequest next() {
            if (this.cursor >= SWIGVectorCloudCreateFileRequest.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest = SWIGVectorCloudCreateFileRequest.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCloudCreateFileRequest.get(i);
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
                NeboDMSJNI.delete_SWIGVectorCloudCreateFileRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(CloudCreateFileRequest cloudCreateFileRequest) {
        NeboDMSJNI.SWIGVectorCloudCreateFileRequest_push_back(this.swigCPtr, this, CloudCreateFileRequest.getCPtr(cloudCreateFileRequest), cloudCreateFileRequest);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorCloudCreateFileRequest_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public CloudCreateFileRequest m1103at(int i) {
        return new CloudCreateFileRequest(NeboDMSJNI.SWIGVectorCloudCreateFileRequest_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorCloudCreateFileRequest() {
        this(NeboDMSJNI.new_SWIGVectorCloudCreateFileRequest(), true);
    }
}
