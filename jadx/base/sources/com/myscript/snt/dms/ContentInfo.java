package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ContentInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ContentInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ContentInfo contentInfo) {
        if (contentInfo == null) {
            return 0L;
        }
        return contentInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_ContentInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static class Rev {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Rev(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Rev rev) {
            if (rev == null) {
                return 0L;
            }
            return rev.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_ContentInfo_Rev(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setSignature(String str) {
            NeboDMSJNI.ContentInfo_Rev_signature_set(this.swigCPtr, this, str.getBytes());
        }

        public String getSignature() {
            return new String(NeboDMSJNI.ContentInfo_Rev_signature_get(this.swigCPtr, this), StandardCharsets.UTF_8);
        }

        public void setTimestamp(long j) {
            NeboDMSJNI.ContentInfo_Rev_timestamp_set(this.swigCPtr, this, j);
        }

        public long getTimestamp() {
            return NeboDMSJNI.ContentInfo_Rev_timestamp_get(this.swigCPtr, this);
        }

        public void setIsModified(boolean z) {
            NeboDMSJNI.ContentInfo_Rev_isModified_set(this.swigCPtr, this, z);
        }

        public boolean getIsModified() {
            return NeboDMSJNI.ContentInfo_Rev_isModified_get(this.swigCPtr, this);
        }

        public Rev() {
            this(NeboDMSJNI.new_ContentInfo_Rev__SWIG_0(), true);
        }

        public Rev(String str, long j, boolean z) {
            this(NeboDMSJNI.new_ContentInfo_Rev__SWIG_1(str.getBytes(), j, z), true);
        }
    }

    public void setCurrent(Rev rev) {
        NeboDMSJNI.ContentInfo_current_set(this.swigCPtr, this, Rev.getCPtr(rev), rev);
    }

    public Rev getCurrent() {
        long jContentInfo_current_get = NeboDMSJNI.ContentInfo_current_get(this.swigCPtr, this);
        if (jContentInfo_current_get == 0) {
            return null;
        }
        return new Rev(jContentInfo_current_get, false);
    }

    public void setLastModification(Rev rev) {
        NeboDMSJNI.ContentInfo_lastModification_set(this.swigCPtr, this, Rev.getCPtr(rev), rev);
    }

    public Rev getLastModification() {
        long jContentInfo_lastModification_get = NeboDMSJNI.ContentInfo_lastModification_get(this.swigCPtr, this);
        if (jContentInfo_lastModification_get == 0) {
            return null;
        }
        return new Rev(jContentInfo_lastModification_get, false);
    }

    public void setPath(String str) {
        NeboDMSJNI.ContentInfo_path_set(this.swigCPtr, this, str.getBytes());
    }

    public String getPath() {
        return new String(NeboDMSJNI.ContentInfo_path_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setPageId(String str) {
        NeboDMSJNI.ContentInfo_pageId_set(this.swigCPtr, this, str.getBytes());
    }

    public String getPageId() {
        return new String(NeboDMSJNI.ContentInfo_pageId_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setHistory(SWIGTYPE_p_std__vectorT_snt__dms__ContentInfo__Rev_t sWIGTYPE_p_std__vectorT_snt__dms__ContentInfo__Rev_t) {
        NeboDMSJNI.ContentInfo_history_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_snt__dms__ContentInfo__Rev_t.getCPtr(sWIGTYPE_p_std__vectorT_snt__dms__ContentInfo__Rev_t));
    }

    public SWIGTYPE_p_std__vectorT_snt__dms__ContentInfo__Rev_t getHistory() {
        long jContentInfo_history_get = NeboDMSJNI.ContentInfo_history_get(this.swigCPtr, this);
        if (jContentInfo_history_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_snt__dms__ContentInfo__Rev_t(jContentInfo_history_get, false);
    }

    public ContentInfo() {
        this(NeboDMSJNI.new_ContentInfo__SWIG_0(), true);
    }

    public ContentInfo(Rev rev, Rev rev2, String str, String str2) {
        this(NeboDMSJNI.new_ContentInfo__SWIG_1(Rev.getCPtr(rev), rev, Rev.getCPtr(rev2), rev2, str.getBytes(), str2.getBytes()), true);
    }
}
