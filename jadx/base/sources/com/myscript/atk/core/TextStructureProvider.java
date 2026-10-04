package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class TextStructureProvider {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TextStructureProvider(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TextStructureProvider textStructureProvider) {
        if (textStructureProvider == null) {
            return 0L;
        }
        return textStructureProvider.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_TextStructureProvider(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SWIGTYPE_p_myscript__document__TextStructureGeometry getGeometry(Content content, String str) {
        return new SWIGTYPE_p_myscript__document__TextStructureGeometry(ATKCoreJNI.TextStructureProvider_getGeometry(this.swigCPtr, this, Content.getCPtr(content), content, str.getBytes()), true);
    }

    public boolean getHideListItems(Content content, String str) {
        return ATKCoreJNI.TextStructureProvider_getHideListItems(this.swigCPtr, this, Content.getCPtr(content), content, str.getBytes());
    }

    public int getMaxIndentationLevel(Content content, String str) {
        return ATKCoreJNI.TextStructureProvider_getMaxIndentationLevel(this.swigCPtr, this, Content.getCPtr(content), content, str.getBytes());
    }
}
