package com.myscript.atk.p021ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGActionMenuEntryList extends ArrayList<ActionMenuEntry> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGActionMenuEntryList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGActionMenuEntryList sWIGActionMenuEntryList) {
        if (sWIGActionMenuEntryList == null) {
            return 0L;
        }
        return sWIGActionMenuEntryList.swigCPtr;
    }

    public SWIGActionMenuEntryList(Iterable<ActionMenuEntry> iterable) {
        this(ATKSharedUIJNI.new_SWIGActionMenuEntryList(), true);
        Iterator<ActionMenuEntry> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ActionMenuEntry get(int i) {
        return m1063at(i);
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
    public Iterator<ActionMenuEntry> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<ActionMenuEntry> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGActionMenuEntryList.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ActionMenuEntry next() {
            if (this.cursor >= SWIGActionMenuEntryList.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGActionMenuEntryList sWIGActionMenuEntryList = SWIGActionMenuEntryList.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGActionMenuEntryList.get(i);
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
                ATKSharedUIJNI.delete_SWIGActionMenuEntryList(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(ActionMenuEntry actionMenuEntry) {
        ATKSharedUIJNI.SWIGActionMenuEntryList_push_back(this.swigCPtr, this, actionMenuEntry.swigValue());
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKSharedUIJNI.SWIGActionMenuEntryList_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public ActionMenuEntry m1063at(int i) {
        return ActionMenuEntry.swigToEnum(ATKSharedUIJNI.SWIGActionMenuEntryList_at(this.swigCPtr, this, i));
    }

    public SWIGActionMenuEntryList() {
        this(ATKSharedUIJNI.new_SWIGActionMenuEntryList(), true);
    }
}
