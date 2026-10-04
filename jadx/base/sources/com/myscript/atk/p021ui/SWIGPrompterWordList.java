package com.myscript.atk.p021ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public class SWIGPrompterWordList extends ArrayList<PrompterWord> {
    private static final long serialVersionUID = 1;
    protected boolean swigCMemOwn;
    private transient long swigCPtr;

    public SWIGPrompterWordList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SWIGPrompterWordList sWIGPrompterWordList) {
        if (sWIGPrompterWordList == null) {
            return 0L;
        }
        return sWIGPrompterWordList.swigCPtr;
    }

    public SWIGPrompterWordList(Iterable<PrompterWord> iterable) {
        this(ATKSharedUIJNI.new_SWIGPrompterWordList(), true);
        Iterator<PrompterWord> it = iterable.iterator();
        while (it.hasNext()) {
            push_back(it.next());
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public PrompterWord get(int i) {
        return m1064at(i);
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
    public Iterator<PrompterWord> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<PrompterWord> {
        int cursor;

        private Itr() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != SWIGPrompterWordList.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public PrompterWord next() {
            if (this.cursor >= SWIGPrompterWordList.this.size()) {
                throw new NoSuchElementException();
            }
            SWIGPrompterWordList sWIGPrompterWordList = SWIGPrompterWordList.this;
            int i = this.cursor;
            this.cursor = i + 1;
            return sWIGPrompterWordList.get(i);
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
                ATKSharedUIJNI.delete_SWIGPrompterWordList(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void push_back(PrompterWord prompterWord) {
        ATKSharedUIJNI.SWIGPrompterWordList_push_back(this.swigCPtr, this, PrompterWord.getCPtr(prompterWord), prompterWord);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return ATKSharedUIJNI.SWIGPrompterWordList_size(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: at */
    public PrompterWord m1064at(int i) {
        long jSWIGPrompterWordList_at = ATKSharedUIJNI.SWIGPrompterWordList_at(this.swigCPtr, this, i);
        if (jSWIGPrompterWordList_at == 0) {
            return null;
        }
        return new PrompterWord(jSWIGPrompterWordList_at, true);
    }

    public SWIGPrompterWordList() {
        this(ATKSharedUIJNI.new_SWIGPrompterWordList(), true);
    }
}
