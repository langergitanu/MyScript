package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class LanguageUpdater {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LanguageUpdater(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LanguageUpdater languageUpdater) {
        if (languageUpdater == null) {
            return 0L;
        }
        return languageUpdater.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LanguageUpdater(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public int updateLanguage(Page page, String str) {
        return ATKCoreJNI.LanguageUpdater_updateLanguage(this.swigCPtr, this, Page.getCPtr(page), page, str.getBytes());
    }

    public LanguageUpdater() {
        this(ATKCoreJNI.new_LanguageUpdater(), true);
    }
}
