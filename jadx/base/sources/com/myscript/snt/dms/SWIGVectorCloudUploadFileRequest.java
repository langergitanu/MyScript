package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorCloudUploadFileRequest extends ArrayList<CloudUploadFileRequest> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCloudUploadFileRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest) {
        if (sWIGVectorCloudUploadFileRequest == null) {
            return 0L;
        }
        return sWIGVectorCloudUploadFileRequest.swigCPtr;
    }

    public SWIGVectorCloudUploadFileRequest(Iterable<CloudUploadFileRequest> iterable) {
        this(NeboDMSJNI.new_SWIGVectorCloudUploadFileRequest(), true);
        Iterator<CloudUploadFileRequest> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public CloudUploadFileRequest get(int i) {
        return m1108at(i);
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
    public Iterator<CloudUploadFileRequest> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<CloudUploadFileRequest> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCloudUploadFileRequest.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CloudUploadFileRequest next() {
            if (this.cursor >= SWIGVectorCloudUploadFileRequest.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest = SWIGVectorCloudUploadFileRequest.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCloudUploadFileRequest.get(i);
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
                NeboDMSJNI.delete_SWIGVectorCloudUploadFileRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(CloudUploadFileRequest cloudUploadFileRequest) {
        NeboDMSJNI.SWIGVectorCloudUploadFileRequest_push_back(this.swigCPtr, this, CloudUploadFileRequest.getCPtr(cloudUploadFileRequest), cloudUploadFileRequest);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorCloudUploadFileRequest_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public CloudUploadFileRequest m1108at(int i) {
        return new CloudUploadFileRequest(NeboDMSJNI.SWIGVectorCloudUploadFileRequest_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorCloudUploadFileRequest() {
        this(NeboDMSJNI.new_SWIGVectorCloudUploadFileRequest(), true);
    }
}
