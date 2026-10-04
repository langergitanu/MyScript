package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorCloudCreateFolderRequest extends ArrayList<CloudCreateFolderRequest> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCloudCreateFolderRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCloudCreateFolderRequest sWIGVectorCloudCreateFolderRequest) {
        if (sWIGVectorCloudCreateFolderRequest == null) {
            return 0L;
        }
        return sWIGVectorCloudCreateFolderRequest.swigCPtr;
    }

    public SWIGVectorCloudCreateFolderRequest(Iterable<CloudCreateFolderRequest> iterable) {
        this(NeboDMSJNI.new_SWIGVectorCloudCreateFolderRequest(), true);
        Iterator<CloudCreateFolderRequest> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public CloudCreateFolderRequest get(int i) {
        return m1104at(i);
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
    public Iterator<CloudCreateFolderRequest> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<CloudCreateFolderRequest> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCloudCreateFolderRequest.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CloudCreateFolderRequest next() {
            if (this.cursor >= SWIGVectorCloudCreateFolderRequest.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCloudCreateFolderRequest sWIGVectorCloudCreateFolderRequest = SWIGVectorCloudCreateFolderRequest.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCloudCreateFolderRequest.get(i);
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
                NeboDMSJNI.delete_SWIGVectorCloudCreateFolderRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(CloudCreateFolderRequest cloudCreateFolderRequest) {
        NeboDMSJNI.SWIGVectorCloudCreateFolderRequest_push_back(this.swigCPtr, this, CloudCreateFolderRequest.getCPtr(cloudCreateFolderRequest), cloudCreateFolderRequest);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorCloudCreateFolderRequest_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public CloudCreateFolderRequest m1104at(int i) {
        return new CloudCreateFolderRequest(NeboDMSJNI.SWIGVectorCloudCreateFolderRequest_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorCloudCreateFolderRequest() {
        this(NeboDMSJNI.new_SWIGVectorCloudCreateFolderRequest(), true);
    }
}
