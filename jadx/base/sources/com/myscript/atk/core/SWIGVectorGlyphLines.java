package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorGlyphLines extends ArrayList<GlyphLines> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorGlyphLines(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorGlyphLines sWIGVectorGlyphLines) {
        if (sWIGVectorGlyphLines == null) {
            return 0L;
        }
        return sWIGVectorGlyphLines.swigCPtr;
    }

    public SWIGVectorGlyphLines(Iterable<GlyphLines> iterable) {
        this(ATKCoreJNI.new_SWIGVectorGlyphLines(), true);
        Iterator<GlyphLines> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public GlyphLines get(int i) {
        return m1050at(i);
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
    public Iterator<GlyphLines> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<GlyphLines> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorGlyphLines.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public GlyphLines next() {
            if (this.cursor >= SWIGVectorGlyphLines.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorGlyphLines sWIGVectorGlyphLines = SWIGVectorGlyphLines.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorGlyphLines.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(GlyphLines glyphLines) {
        ATKCoreJNI.SWIGVectorGlyphLines_push_back(this.swigCPtr, this, GlyphLines.getCPtr(glyphLines), glyphLines);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorGlyphLines_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public GlyphLines m1050at(int i) {
        return new GlyphLines(ATKCoreJNI.SWIGVectorGlyphLines_at(this.swigCPtr, this, i), true);
    }
}
