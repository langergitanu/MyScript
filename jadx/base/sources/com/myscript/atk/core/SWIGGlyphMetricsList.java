package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGGlyphMetricsList extends ArrayList<GlyphMetrics> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGGlyphMetricsList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGGlyphMetricsList sWIGGlyphMetricsList) {
        if (sWIGGlyphMetricsList == null) {
            return 0L;
        }
        return sWIGGlyphMetricsList.swigCPtr;
    }

    public SWIGGlyphMetricsList(Iterable<GlyphMetrics> iterable) {
        this(ATKCoreJNI.new_SWIGGlyphMetricsList(), true);
        Iterator<GlyphMetrics> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public GlyphMetrics get(int i) {
        return m1043at(i);
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
    public Iterator<GlyphMetrics> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<GlyphMetrics> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGGlyphMetricsList.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public GlyphMetrics next() {
            if (this.cursor >= SWIGGlyphMetricsList.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGGlyphMetricsList sWIGGlyphMetricsList = SWIGGlyphMetricsList.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGGlyphMetricsList.get(i);
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
                ATKCoreJNI.delete_SWIGGlyphMetricsList(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(GlyphMetrics glyphMetrics) {
        ATKCoreJNI.SWIGGlyphMetricsList_push_back(this.swigCPtr, this, GlyphMetrics.getCPtr(glyphMetrics), glyphMetrics);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGGlyphMetricsList_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public GlyphMetrics m1043at(int i) {
        return new GlyphMetrics(ATKCoreJNI.SWIGGlyphMetricsList_at(this.swigCPtr, this, i), true);
    }

    public SWIGGlyphMetricsList() {
        this(ATKCoreJNI.new_SWIGGlyphMetricsList(), true);
    }
}
