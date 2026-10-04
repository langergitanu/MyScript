package com.myscript.snt.core;

import com.myscript.atk.core.Json;
import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class LanguageManager {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LanguageManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LanguageManager languageManager) {
        if (languageManager == null) {
            return 0L;
        }
        return languageManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_LanguageManager(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public LanguageManager(SWIGTYPE_p_myscript__configurationmanager__ConfigurationManager sWIGTYPE_p_myscript__configurationmanager__ConfigurationManager) {
        this(NeboEngineJNI.new_LanguageManager__SWIG_0(SWIGTYPE_p_myscript__configurationmanager__ConfigurationManager.getCPtr(sWIGTYPE_p_myscript__configurationmanager__ConfigurationManager)), true);
    }

    private static long SwigConstructLanguageManager(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        return NeboEngineJNI.new_LanguageManager__SWIG_1(SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public LanguageManager(List<String> list) {
        this(SwigConstructLanguageManager(list), true);
    }

    public List<LocaleInfo> availableLanguages(String str) {
        return new SWIGVectorLocaleInfo(NeboEngineJNI.LanguageManager_availableLanguages__SWIG_0(this.swigCPtr, this, str.getBytes()), true);
    }

    public List<LocaleInfo> availableLanguages(Json json) {
        return new SWIGVectorLocaleInfo(NeboEngineJNI.LanguageManager_availableLanguages__SWIG_1(this.swigCPtr, this, Json.getCPtr(json), json), true);
    }

    public List<LocaleInfo> availableLanguages() {
        return new SWIGVectorLocaleInfo(NeboEngineJNI.LanguageManager_availableLanguages__SWIG_2(this.swigCPtr, this), true);
    }
}
