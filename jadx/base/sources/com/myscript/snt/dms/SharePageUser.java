package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SharePageUser {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePageUser(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePageUser sharePageUser) {
        if (sharePageUser == null) {
            return 0L;
        }
        return sharePageUser.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePageUser(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static SharePageUser createDefaultUser(String str, String str2) {
        long jSharePageUser_createDefaultUser__SWIG_0 = NeboDMSJNI.SharePageUser_createDefaultUser__SWIG_0(str.getBytes(), str2.getBytes());
        if (jSharePageUser_createDefaultUser__SWIG_0 == 0) {
            return null;
        }
        return new SharePageUser(jSharePageUser_createDefaultUser__SWIG_0, true);
    }

    public static SharePageUser createDefaultUser(String str) {
        long jSharePageUser_createDefaultUser__SWIG_1 = NeboDMSJNI.SharePageUser_createDefaultUser__SWIG_1(str.getBytes());
        if (jSharePageUser_createDefaultUser__SWIG_1 == 0) {
            return null;
        }
        return new SharePageUser(jSharePageUser_createDefaultUser__SWIG_1, true);
    }

    public SharePageUser(String str, String str2) {
        this(NeboDMSJNI.new_SharePageUser__SWIG_0(str.getBytes(), str2.getBytes()), true);
    }

    public SharePageUser(String str) {
        this(NeboDMSJNI.new_SharePageUser__SWIG_1(str.getBytes()), true);
    }

    public boolean isValid() {
        return NeboDMSJNI.SharePageUser_isValid(this.swigCPtr, this);
    }

    public String email() {
        return new String(NeboDMSJNI.SharePageUser_email(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String name() {
        return new String(NeboDMSJNI.SharePageUser_name(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public SharePageUserRight userRight() {
        return SharePageUserRight.swigToEnum(NeboDMSJNI.SharePageUser_userRight(this.swigCPtr, this));
    }

    public void setUserRight(SharePageUserRight sharePageUserRight) {
        NeboDMSJNI.SharePageUser_setUserRight(this.swigCPtr, this, sharePageUserRight.swigValue());
    }
}
