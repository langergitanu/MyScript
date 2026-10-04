package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class LocaleInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LocaleInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LocaleInfo localeInfo) {
        if (localeInfo == null) {
            return 0L;
        }
        return localeInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_LocaleInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setName(String str) {
        NeboEngineJNI.LocaleInfo_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboEngineJNI.LocaleInfo_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setLanguage(String str) {
        NeboEngineJNI.LocaleInfo_language_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLanguage() {
        return new String(NeboEngineJNI.LocaleInfo_language_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCountry(String str) {
        NeboEngineJNI.LocaleInfo_country_set(this.swigCPtr, this, str.getBytes());
    }

    public String getCountry() {
        return new String(NeboEngineJNI.LocaleInfo_country_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public LocaleInfo() {
        this(NeboEngineJNI.new_LocaleInfo(), true);
    }
}
