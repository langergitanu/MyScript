package com.myscript.snt.dms;

import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SharePageRequest {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePageRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePageRequest sharePageRequest) {
        if (sharePageRequest == null) {
            return 0L;
        }
        return sharePageRequest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePageRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SharePageRequest(PageKey pageKey) {
        this(NeboDMSJNI.new_SharePageRequest__SWIG_0(PageKey.getCPtr(pageKey), pageKey), true);
    }

    public SharePageRequest(NotebookKey notebookKey) {
        this(NeboDMSJNI.new_SharePageRequest__SWIG_1(NotebookKey.getCPtr(notebookKey), notebookKey), true);
    }

    public PageKey pageKey() {
        return new PageKey(NeboDMSJNI.SharePageRequest_pageKey(this.swigCPtr, this), true);
    }

    public NotebookKey notebookKey() {
        return new NotebookKey(NeboDMSJNI.SharePageRequest_notebookKey(this.swigCPtr, this), true);
    }

    public String uuid() {
        return new String(NeboDMSJNI.SharePageRequest_uuid(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
