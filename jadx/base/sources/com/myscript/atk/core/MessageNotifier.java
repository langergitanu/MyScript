package com.myscript.atk.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MessageNotifier extends MessageListener {
    private transient long swigCPtr;

    public MessageNotifier(long j, boolean z) {
        super(ATKCoreJNI.MessageNotifier_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(MessageNotifier messageNotifier) {
        if (messageNotifier == null) {
            return 0L;
        }
        return messageNotifier.swigCPtr;
    }

    @Override // com.myscript.atk.core.MessageListener
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.MessageListener
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MessageNotifier(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public void addMessageListener(SWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t sWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t) {
        ATKCoreJNI.MessageNotifier_addMessageListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t));
    }

    public void removeMessageListener(SWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t sWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t) {
        ATKCoreJNI.MessageNotifier_removeMessageListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__MessageListener_t));
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, List<String> list, String str2, String str3, String str4) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageNotifier_notify__SWIG_0(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, str2.getBytes(), str3.getBytes(), str4.getBytes());
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, List<String> list, String str2, String str3) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageNotifier_notify__SWIG_1(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, str2.getBytes(), str3.getBytes());
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, List<String> list, String str2) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageNotifier_notify__SWIG_2(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, str2.getBytes());
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        ATKCoreJNI.MessageNotifier_notify__SWIG_3(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, MessageIdentifier messageIdentifier, String str2, String str3, String str4) {
        ATKCoreJNI.MessageNotifier_notify__SWIG_4(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue(), str2.getBytes(), str3.getBytes(), str4.getBytes());
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, MessageIdentifier messageIdentifier, String str2, String str3) {
        ATKCoreJNI.MessageNotifier_notify__SWIG_5(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue(), str2.getBytes(), str3.getBytes());
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, MessageIdentifier messageIdentifier, String str2) {
        ATKCoreJNI.MessageNotifier_notify__SWIG_6(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue(), str2.getBytes());
    }

    @Override // com.myscript.atk.core.MessageListener
    public void notify(String str, MessageIdentifier messageIdentifier) {
        ATKCoreJNI.MessageNotifier_notify__SWIG_7(this.swigCPtr, this, str.getBytes(), messageIdentifier.swigValue());
    }

    public MessageNotifier() {
        this(ATKCoreJNI.new_MessageNotifier(), true);
    }
}
