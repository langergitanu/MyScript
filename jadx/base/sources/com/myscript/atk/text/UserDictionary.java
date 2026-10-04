package com.myscript.atk.text;

import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UserDictionary implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public UserDictionary(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(UserDictionary userDictionary) {
        if (userDictionary == null) {
            return 0L;
        }
        return userDictionary.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_UserDictionary(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public UserDictionary(UserDictionaryConfiguration userDictionaryConfiguration) {
        this(ATKTextJNI.new_UserDictionary(UserDictionaryConfiguration.getCPtr(userDictionaryConfiguration), userDictionaryConfiguration), true);
    }

    public void store() {
        ATKTextJNI.UserDictionary_store(this.swigCPtr, this);
    }

    public void clear() {
        ATKTextJNI.UserDictionary_clear(this.swigCPtr, this);
    }

    public void addLabel(String str) {
        ATKTextJNI.UserDictionary_addLabel(this.swigCPtr, this, str.getBytes());
    }

    public void removeLabel(String str) {
        ATKTextJNI.UserDictionary_removeLabel(this.swigCPtr, this, str.getBytes());
    }

    public List<String> getLabels() {
        return new SWIGVectorString(ATKTextJNI.UserDictionary_getLabels(this.swigCPtr, this), true);
    }

    public String getFilepath() {
        return new String(ATKTextJNI.UserDictionary_getFilepath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public SWIGTYPE_p_myscript__text__Lexicon stealLexicon() {
        return new SWIGTYPE_p_myscript__text__Lexicon(ATKTextJNI.UserDictionary_stealLexicon(this.swigCPtr, this), true);
    }

    public static UserDictionary newRef(UserDictionary userDictionary) {
        long jUserDictionary_newRef = ATKTextJNI.UserDictionary_newRef(getCPtr(userDictionary), userDictionary);
        if (jUserDictionary_newRef == 0) {
            return null;
        }
        return new UserDictionary(jUserDictionary_newRef, true);
    }
}
