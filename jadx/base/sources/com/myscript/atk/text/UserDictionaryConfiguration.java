package com.myscript.atk.text;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class UserDictionaryConfiguration {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public UserDictionaryConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(UserDictionaryConfiguration userDictionaryConfiguration) {
        if (userDictionaryConfiguration == null) {
            return 0L;
        }
        return userDictionaryConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_UserDictionaryConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public UserDictionaryConfiguration(String str, String str2) {
        this(ATKTextJNI.new_UserDictionaryConfiguration(str.getBytes(), str2.getBytes()), true);
    }

    public String lexiconPath() {
        return new String(ATKTextJNI.UserDictionaryConfiguration_lexiconPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setRootDir(String str) {
        ATKTextJNI.UserDictionaryConfiguration_rootDir_set(this.swigCPtr, this, str.getBytes());
    }

    public String getRootDir() {
        return new String(ATKTextJNI.UserDictionaryConfiguration_rootDir_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setResourceFileName(String str) {
        ATKTextJNI.UserDictionaryConfiguration_resourceFileName_set(this.swigCPtr, this, str.getBytes());
    }

    public String getResourceFileName() {
        return new String(ATKTextJNI.UserDictionaryConfiguration_resourceFileName_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
