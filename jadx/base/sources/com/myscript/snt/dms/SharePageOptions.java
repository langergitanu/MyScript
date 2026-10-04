package com.myscript.snt.dms;

import com.myscript.atk.core.Json;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class SharePageOptions {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePageOptions(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePageOptions sharePageOptions) {
        if (sharePageOptions == null) {
            return 0L;
        }
        return sharePageOptions.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePageOptions(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public SharePageOptions() {
        this(NeboDMSJNI.new_SharePageOptions(), true);
    }

    public SharePageVisibility visibility() {
        return SharePageVisibility.swigToEnum(NeboDMSJNI.SharePageOptions_visibility(this.swigCPtr, this));
    }

    public void setVisibility(SharePageVisibility sharePageVisibility) {
        NeboDMSJNI.SharePageOptions_setVisibility(this.swigCPtr, this, sharePageVisibility.swigValue());
    }

    public List<SharePageUser> sharePageUsers() {
        return new SWIGVectorSharePageUser(NeboDMSJNI.SharePageOptions_sharePageUsers(this.swigCPtr, this), true);
    }

    public boolean addUser(SharePageUser sharePageUser) {
        return NeboDMSJNI.SharePageOptions_addUser(this.swigCPtr, this, SharePageUser.getCPtr(sharePageUser), sharePageUser);
    }

    public boolean removeUser(String str) {
        return NeboDMSJNI.SharePageOptions_removeUser(this.swigCPtr, this, str.getBytes());
    }

    public boolean replaceUser(SharePageUser sharePageUser) {
        return NeboDMSJNI.SharePageOptions_replaceUser(this.swigCPtr, this, SharePageUser.getCPtr(sharePageUser), sharePageUser);
    }

    public String userMessage() {
        return new String(NeboDMSJNI.SharePageOptions_userMessage(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setUserMessage(String str) {
        NeboDMSJNI.SharePageOptions_setUserMessage(this.swigCPtr, this, str.getBytes());
    }

    public SharePageUser user(String str) {
        long jSharePageOptions_user = NeboDMSJNI.SharePageOptions_user(this.swigCPtr, this, str.getBytes());
        if (jSharePageOptions_user == 0) {
            return null;
        }
        return new SharePageUser(jSharePageOptions_user, true);
    }

    public void clearUsers() {
        NeboDMSJNI.SharePageOptions_clearUsers(this.swigCPtr, this);
    }

    public static Json toJSON(SharePageOptions sharePageOptions) {
        return new Json(NeboDMSJNI.SharePageOptions_toJSON(getCPtr(sharePageOptions), sharePageOptions), true);
    }

    public static SharePageOptions fromJSON(Json json) {
        long jSharePageOptions_fromJSON = NeboDMSJNI.SharePageOptions_fromJSON(Json.getCPtr(json), json);
        if (jSharePageOptions_fromJSON == 0) {
            return null;
        }
        return new SharePageOptions(jSharePageOptions_fromJSON, true);
    }

    public static Json userToJSON(SharePageUser sharePageUser) {
        return new Json(NeboDMSJNI.SharePageOptions_userToJSON(SharePageUser.getCPtr(sharePageUser), sharePageUser), true);
    }

    public static SharePageUser userFromJSON(Json json) {
        long jSharePageOptions_userFromJSON = NeboDMSJNI.SharePageOptions_userFromJSON(Json.getCPtr(json), json);
        if (jSharePageOptions_userFromJSON == 0) {
            return null;
        }
        return new SharePageUser(jSharePageOptions_userFromJSON, true);
    }
}
