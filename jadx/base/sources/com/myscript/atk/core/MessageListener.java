package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MessageListener {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MessageListener(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MessageListener messageListener) {
        if (messageListener == null) {
            return 0L;
        }
        return messageListener.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MessageListener(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void notify(String str, List<String> list, String str2, String str3, String str4) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageListener_notify__SWIG_0(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, str2.getBytes(), str3.getBytes(), str4.getBytes());
    }

    public void notify(String str, List<String> list, String str2, String str3) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageListener_notify__SWIG_1(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, str2.getBytes(), str3.getBytes());
    }

    public void notify(String str, List<String> list, String str2) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageListener_notify__SWIG_2(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, str2.getBytes());
    }

    public void notify(String str, List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageListener_notify__SWIG_3(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void notify(String str, MessageIdentifier messageIdentifier, String str2, String str3, String str4) {
        ATKCoreJNI.MessageListener_notify__SWIG_4(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue(), str2.getBytes(), str3.getBytes(), str4.getBytes());
    }

    public void notify(String str, MessageIdentifier messageIdentifier, String str2, String str3) {
        ATKCoreJNI.MessageListener_notify__SWIG_5(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue(), str2.getBytes(), str3.getBytes());
    }

    public void notify(String str, MessageIdentifier messageIdentifier, String str2) {
        ATKCoreJNI.MessageListener_notify__SWIG_6(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue(), str2.getBytes());
    }

    public void notify(String str, MessageIdentifier messageIdentifier) {
        ATKCoreJNI.MessageListener_notify__SWIG_7(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue());
    }
}
