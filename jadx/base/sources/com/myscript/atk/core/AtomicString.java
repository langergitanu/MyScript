package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class AtomicString {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public AtomicString(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(AtomicString atomicString) {
        if (atomicString == null) {
            return 0L;
        }
        return atomicString.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_AtomicString(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public AtomicString() {
        this(ATKCoreJNI.new_AtomicString(), true);
    }

    public String load() {
        return new String(ATKCoreJNI.AtomicString_load(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void store(String str) {
        ATKCoreJNI.AtomicString_store(this.swigCPtr, this, str.getBytes());
    }

    public boolean empty() {
        return ATKCoreJNI.AtomicString_empty(this.swigCPtr, this);
    }

    public long length() {
        return ATKCoreJNI.AtomicString_length(this.swigCPtr, this);
    }

    public void clear() {
        ATKCoreJNI.AtomicString_clear(this.swigCPtr, this);
    }
}
