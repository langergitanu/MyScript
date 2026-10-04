package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorSharePage extends ArrayList<SharePage> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorSharePage(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorSharePage sWIGVectorSharePage) {
        if (sWIGVectorSharePage == null) {
            return 0L;
        }
        return sWIGVectorSharePage.swigCPtr;
    }

    public SWIGVectorSharePage(Iterable<SharePage> iterable) {
        this(NeboDMSJNI.new_SWIGVectorSharePage(), true);
        Iterator<SharePage> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public SharePage get(int i) {
        return m1114at(i);
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
    public Iterator<SharePage> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<SharePage> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorSharePage.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public SharePage next() {
            if (this.cursor >= SWIGVectorSharePage.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorSharePage sWIGVectorSharePage = SWIGVectorSharePage.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorSharePage.get(i);
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
                NeboDMSJNI.delete_SWIGVectorSharePage(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(SharePage sharePage) {
        NeboDMSJNI.SWIGVectorSharePage_push_back(this.swigCPtr, this, SharePage.getCPtr(sharePage), sharePage);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorSharePage_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public SharePage m1114at(int i) {
        long jSWIGVectorSharePage_at = NeboDMSJNI.SWIGVectorSharePage_at(this.swigCPtr, this, i);
        if (jSWIGVectorSharePage_at == 0) {
            return null;
        }
        return new SharePage(jSWIGVectorSharePage_at, true);
    }

    public SWIGVectorSharePage() {
        this(NeboDMSJNI.new_SWIGVectorSharePage(), true);
    }
}
