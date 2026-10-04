package com.myscript.snt.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
public class SWIGVectorToolConfiguration extends ArrayList<ToolConfiguration> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorToolConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorToolConfiguration sWIGVectorToolConfiguration) {
        if (sWIGVectorToolConfiguration == null) {
            return 0L;
        }
        return sWIGVectorToolConfiguration.swigCPtr;
    }

    public SWIGVectorToolConfiguration(Iterable<ToolConfiguration> iterable) {
        this(NeboEngineJNI.new_SWIGVectorToolConfiguration(), true);
        Iterator<ToolConfiguration> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ToolConfiguration get(int i) {
        return m1101at(i);
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
    public Iterator<ToolConfiguration> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<ToolConfiguration> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorToolConfiguration.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ToolConfiguration next() {
            if (this.cursor >= SWIGVectorToolConfiguration.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorToolConfiguration sWIGVectorToolConfiguration = SWIGVectorToolConfiguration.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorToolConfiguration.get(i);
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
                NeboEngineJNI.delete_SWIGVectorToolConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(ToolConfiguration toolConfiguration) {
        NeboEngineJNI.SWIGVectorToolConfiguration_push_back(this.swigCPtr, this, ToolConfiguration.getCPtr(toolConfiguration), toolConfiguration);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return NeboEngineJNI.SWIGVectorToolConfiguration_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public ToolConfiguration m1101at(int i) {
        return new ToolConfiguration(NeboEngineJNI.SWIGVectorToolConfiguration_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorToolConfiguration() {
        this(NeboEngineJNI.new_SWIGVectorToolConfiguration(), true);
    }
}
