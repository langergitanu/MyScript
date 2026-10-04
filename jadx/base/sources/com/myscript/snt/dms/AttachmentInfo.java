package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class AttachmentInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public AttachmentInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(AttachmentInfo attachmentInfo) {
        if (attachmentInfo == null) {
            return 0L;
        }
        return attachmentInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_AttachmentInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setAttachment(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.AttachmentInfo_attachment_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getAttachment() {
        long jAttachmentInfo_attachment_get = NeboDMSJNI.AttachmentInfo_attachment_get(this.swigCPtr, this);
        if (jAttachmentInfo_attachment_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jAttachmentInfo_attachment_get, false);
    }

    public void setPage(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.AttachmentInfo_page_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getPage() {
        long jAttachmentInfo_page_get = NeboDMSJNI.AttachmentInfo_page_get(this.swigCPtr, this);
        if (jAttachmentInfo_page_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jAttachmentInfo_page_get, false);
    }

    public void setUrl(String str) {
        NeboDMSJNI.AttachmentInfo_url_set(this.swigCPtr, this, str.getBytes());
    }

    public String getUrl() {
        return new String(NeboDMSJNI.AttachmentInfo_url_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setReferenceCount(int i) {
        NeboDMSJNI.AttachmentInfo_referenceCount_set(this.swigCPtr, this, i);
    }

    public int getReferenceCount() {
        return NeboDMSJNI.AttachmentInfo_referenceCount_get(this.swigCPtr, this);
    }

    public void setExtension(String str) {
        NeboDMSJNI.AttachmentInfo_extension_set(this.swigCPtr, this, str.getBytes());
    }

    public String getExtension() {
        return new String(NeboDMSJNI.AttachmentInfo_extension_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSignature(String str) {
        NeboDMSJNI.AttachmentInfo_signature_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSignature() {
        return new String(NeboDMSJNI.AttachmentInfo_signature_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public AttachmentInfo() {
        this(NeboDMSJNI.new_AttachmentInfo(), true);
    }

    public boolean valid() {
        return NeboDMSJNI.AttachmentInfo_valid(this.swigCPtr, this);
    }
}
