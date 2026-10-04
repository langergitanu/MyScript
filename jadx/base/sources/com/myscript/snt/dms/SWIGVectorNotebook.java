package com.myscript.snt.dms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorNotebook extends ArrayList<Notebook> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorNotebook(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorNotebook sWIGVectorNotebook) {
        if (sWIGVectorNotebook == null) {
            return 0L;
        }
        return sWIGVectorNotebook.swigCPtr;
    }

    public SWIGVectorNotebook(Iterable<Notebook> iterable) {
        this(NeboDMSJNI.new_SWIGVectorNotebook(), true);
        Iterator<Notebook> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Notebook get(int i) {
        return m1110at(i);
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
    public Iterator<Notebook> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Notebook> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorNotebook.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Notebook next() {
            if (this.cursor >= SWIGVectorNotebook.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorNotebook sWIGVectorNotebook = SWIGVectorNotebook.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorNotebook.get(i);
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
                NeboDMSJNI.delete_SWIGVectorNotebook(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(Notebook notebook) {
        NeboDMSJNI.SWIGVectorNotebook_push_back(this.swigCPtr, this, Notebook.getCPtr(notebook), notebook);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboDMSJNI.SWIGVectorNotebook_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public Notebook m1110at(int i) {
        long jSWIGVectorNotebook_at = NeboDMSJNI.SWIGVectorNotebook_at(this.swigCPtr, this, i);
        if (jSWIGVectorNotebook_at == 0) {
            return null;
        }
        return new Notebook(jSWIGVectorNotebook_at, true);
    }

    public SWIGVectorNotebook() {
        this(NeboDMSJNI.new_SWIGVectorNotebook(), true);
    }
}
