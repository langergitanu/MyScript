package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ModelLock {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ModelLock(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ModelLock modelLock) {
        if (modelLock == null) {
            return 0L;
        }
        return modelLock.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_ModelLock(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ModelLock(Page page) {
        this(ATKCoreJNI.new_ModelLock__SWIG_0(Page.getCPtr(page), page), true);
    }

    public ModelLock(Document document) {
        this(ATKCoreJNI.new_ModelLock__SWIG_1(Document.getCPtr(document), document), true);
    }

    public ModelLock(Layout layout) {
        this(ATKCoreJNI.new_ModelLock__SWIG_2(Layout.getCPtr(layout), layout), true);
    }

    public ModelLock(Content content) {
        this(ATKCoreJNI.new_ModelLock__SWIG_3(Content.getCPtr(content), content), true);
    }
}
