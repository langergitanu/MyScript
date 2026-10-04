package com.myscript.snt.core;

import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentControllerListener {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DocumentControllerListener(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DocumentControllerListener documentControllerListener) {
        if (documentControllerListener == null) {
            return 0L;
        }
        return documentControllerListener.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_DocumentControllerListener(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void documentModified(NotebookKey notebookKey) {
        NeboEngineJNI.DocumentControllerListener_documentModified(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void documentRemoved(NotebookKey notebookKey, List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboEngineJNI.DocumentControllerListener_documentRemoved(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void pageModified(PageKey pageKey, String str) {
        NeboEngineJNI.DocumentControllerListener_pageModified(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public void pageDeleted(PageKey pageKey, String str) {
        NeboEngineJNI.DocumentControllerListener_pageDeleted(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public void pageUUIDReseted(PageKey pageKey, String str, String str2) {
        NeboEngineJNI.DocumentControllerListener_pageUUIDReseted(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes(), str2.getBytes());
    }
}
