package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorSharePageUser extends ArrayList<SharePageUser> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorSharePageUser(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorSharePageUser sWIGVectorSharePageUser) {
        if (sWIGVectorSharePageUser == null) {
            return 0L;
        }
        return sWIGVectorSharePageUser.swigCPtr;
    }

    public SWIGVectorSharePageUser(Iterable<SharePageUser> iterable) {
        this(NeboDMSJNI.new_SWIGVectorSharePageUser(), true);
        Iterator<SharePageUser> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public SharePageUser get(int i) {
        return m1115at(i);
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
    public Iterator<SharePageUser> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<SharePageUser> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorSharePageUser.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public SharePageUser next() {
            if (this.cursor >= SWIGVectorSharePageUser.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorSharePageUser sWIGVectorSharePageUser = SWIGVectorSharePageUser.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorSharePageUser.get(i);
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
                NeboDMSJNI.delete_SWIGVectorSharePageUser(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(SharePageUser sharePageUser) {
        NeboDMSJNI.SWIGVectorSharePageUser_push_back(this.swigCPtr, this, SharePageUser.getCPtr(sharePageUser), sharePageUser);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorSharePageUser_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public SharePageUser m1115at(int i) {
        long jSWIGVectorSharePageUser_at = NeboDMSJNI.SWIGVectorSharePageUser_at(this.swigCPtr, this, i);
        if (jSWIGVectorSharePageUser_at == 0) {
            return null;
        }
        return new SharePageUser(jSWIGVectorSharePageUser_at, true);
    }

    public SWIGVectorSharePageUser() {
        this(NeboDMSJNI.new_SWIGVectorSharePageUser(), true);
    }
}
