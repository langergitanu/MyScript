package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorPointerInfo extends ArrayList<PointerInfo> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorPointerInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorPointerInfo sWIGVectorPointerInfo) {
        if (sWIGVectorPointerInfo == null) {
            return 0L;
        }
        return sWIGVectorPointerInfo.swigCPtr;
    }

    public SWIGVectorPointerInfo(Iterable<PointerInfo> iterable) {
        this(ATKCoreJNI.new_SWIGVectorPointerInfo(), true);
        Iterator<PointerInfo> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public PointerInfo get(int i) {
        return m1057at(i);
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
    public Iterator<PointerInfo> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<PointerInfo> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorPointerInfo.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public PointerInfo next() {
            if (this.cursor >= SWIGVectorPointerInfo.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorPointerInfo sWIGVectorPointerInfo = SWIGVectorPointerInfo.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorPointerInfo.get(i);
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
                ATKCoreJNI.delete_SWIGVectorPointerInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(PointerInfo pointerInfo) {
        ATKCoreJNI.SWIGVectorPointerInfo_push_back(this.swigCPtr, this, PointerInfo.getCPtr(pointerInfo), pointerInfo);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorPointerInfo_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public PointerInfo m1057at(int i) {
        return new PointerInfo(ATKCoreJNI.SWIGVectorPointerInfo_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorPointerInfo() {
        this(ATKCoreJNI.new_SWIGVectorPointerInfo(), true);
    }
}
