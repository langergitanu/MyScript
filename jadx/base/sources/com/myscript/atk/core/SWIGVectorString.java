package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorString extends ArrayList<String> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorString(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorString sWIGVectorString) {
        if (sWIGVectorString == null) {
            return 0L;
        }
        return sWIGVectorString.swigCPtr;
    }

    public SWIGVectorString(Iterable<String> iterable) {
        this(ATKCoreJNI.new_SWIGVectorString(), true);
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public String get(int i) {
        return m1059at(i);
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
    public Iterator<String> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<String> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorString.this.size();
        }

        @Override // java.util.Iterator
        public String next() {
            if (this.cursor >= SWIGVectorString.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorString sWIGVectorString = SWIGVectorString.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorString.get(i);
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
                ATKCoreJNI.delete_SWIGVectorString(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(String str) {
        ATKCoreJNI.SWIGVectorString_push_back(this.swigCPtr, this, str.getBytes());
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorString_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public String m1059at(int i) {
        return new String(ATKCoreJNI.SWIGVectorString_at(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public SWIGVectorString() {
        this(ATKCoreJNI.new_SWIGVectorString(), true);
    }
}
