package com.myscript.snt.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorNotebookKey extends ArrayList<NotebookKey> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorNotebookKey(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorNotebookKey sWIGVectorNotebookKey) {
        if (sWIGVectorNotebookKey == null) {
            return 0L;
        }
        return sWIGVectorNotebookKey.swigCPtr;
    }

    public SWIGVectorNotebookKey(Iterable<NotebookKey> iterable) {
        this(NeboEngineJNI.new_SWIGVectorNotebookKey(), true);
        Iterator<NotebookKey> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public NotebookKey get(int i) {
        return m1098at(i);
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
    public Iterator<NotebookKey> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<NotebookKey> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorNotebookKey.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public NotebookKey next() {
            if (this.cursor >= SWIGVectorNotebookKey.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorNotebookKey sWIGVectorNotebookKey = SWIGVectorNotebookKey.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorNotebookKey.get(i);
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
                NeboEngineJNI.delete_SWIGVectorNotebookKey(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(NotebookKey notebookKey) {
        NeboEngineJNI.SWIGVectorNotebookKey_push_back(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboEngineJNI.SWIGVectorNotebookKey_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public NotebookKey m1098at(int i) {
        return new NotebookKey(NeboEngineJNI.SWIGVectorNotebookKey_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorNotebookKey() {
        this(NeboEngineJNI.new_SWIGVectorNotebookKey(), true);
    }
}
