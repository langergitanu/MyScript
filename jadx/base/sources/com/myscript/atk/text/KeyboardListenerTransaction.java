package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public class KeyboardListenerTransaction implements AutoCloseable {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public KeyboardListenerTransaction(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(KeyboardListenerTransaction keyboardListenerTransaction) {
        if (keyboardListenerTransaction == null) {
            return 0L;
        }
        return keyboardListenerTransaction.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_KeyboardListenerTransaction(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public KeyboardListenerTransaction(IKeyboardListener iKeyboardListener) {
        this(ATKTextJNI.new_KeyboardListenerTransaction__SWIG_0(iKeyboardListener), true);
    }

    public KeyboardListenerTransaction(KeyboardListenerTransaction keyboardListenerTransaction) {
        this(ATKTextJNI.new_KeyboardListenerTransaction__SWIG_1(getCPtr(keyboardListenerTransaction), keyboardListenerTransaction), true);
    }
}
