package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorCustomResource extends ArrayList<CustomResource> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorCustomResource(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorCustomResource sWIGVectorCustomResource) {
        if (sWIGVectorCustomResource == null) {
            return 0L;
        }
        return sWIGVectorCustomResource.swigCPtr;
    }

    public SWIGVectorCustomResource(Iterable<CustomResource> iterable) {
        this(ATKCoreJNI.new_SWIGVectorCustomResource(), true);
        Iterator<CustomResource> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public CustomResource get(int i) {
        return m1047at(i);
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
    public Iterator<CustomResource> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<CustomResource> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorCustomResource.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CustomResource next() {
            if (this.cursor >= SWIGVectorCustomResource.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorCustomResource sWIGVectorCustomResource = SWIGVectorCustomResource.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorCustomResource.get(i);
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
                ATKCoreJNI.delete_SWIGVectorCustomResource(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(CustomResource customResource) {
        ATKCoreJNI.SWIGVectorCustomResource_push_back(this.swigCPtr, this, CustomResource.getCPtr(customResource), customResource);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorCustomResource_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public CustomResource m1047at(int i) {
        return new CustomResource(ATKCoreJNI.SWIGVectorCustomResource_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorCustomResource() {
        this(ATKCoreJNI.new_SWIGVectorCustomResource(), true);
    }
}
