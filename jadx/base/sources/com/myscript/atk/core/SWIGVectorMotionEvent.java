package com.myscript.atk.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGVectorMotionEvent extends ArrayList<MotionEvent> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGVectorMotionEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGVectorMotionEvent sWIGVectorMotionEvent) {
        if (sWIGVectorMotionEvent == null) {
            return 0L;
        }
        return sWIGVectorMotionEvent.swigCPtr;
    }

    public SWIGVectorMotionEvent(Iterable<MotionEvent> iterable) {
        this(ATKCoreJNI.new_SWIGVectorMotionEvent(), true);
        Iterator<MotionEvent> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public MotionEvent get(int i) {
        return m1053at(i);
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
    public Iterator<MotionEvent> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<MotionEvent> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGVectorMotionEvent.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MotionEvent next() {
            if (this.cursor >= SWIGVectorMotionEvent.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGVectorMotionEvent sWIGVectorMotionEvent = SWIGVectorMotionEvent.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGVectorMotionEvent.get(i);
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
                ATKCoreJNI.delete_SWIGVectorMotionEvent(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(MotionEvent motionEvent) {
        ATKCoreJNI.SWIGVectorMotionEvent_push_back(this.swigCPtr, this, MotionEvent.getCPtr(motionEvent), motionEvent);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKCoreJNI.SWIGVectorMotionEvent_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public MotionEvent m1053at(int i) {
        return new MotionEvent(ATKCoreJNI.SWIGVectorMotionEvent_at(this.swigCPtr, this, i), true);
    }

    public SWIGVectorMotionEvent() {
        this(ATKCoreJNI.new_SWIGVectorMotionEvent(), true);
    }
}
