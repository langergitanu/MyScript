package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class StandalonePageControllerProvider {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StandalonePageControllerProvider(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(StandalonePageControllerProvider standalonePageControllerProvider) {
        if (standalonePageControllerProvider == null) {
            return 0L;
        }
        return standalonePageControllerProvider.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_StandalonePageControllerProvider(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public StandalonePageControllerProvider(String str) {
        this(NeboEngineJNI.new_StandalonePageControllerProvider(str.getBytes()), true);
    }

    public PageController pageController(String str, DisplayContext displayContext, RecoContext recoContext, String str2, String str3) {
        long jStandalonePageControllerProvider_pageController__SWIG_0 = NeboEngineJNI.StandalonePageControllerProvider_pageController__SWIG_0(this.swigCPtr, this, str.getBytes(), DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, str2.getBytes(), str3.getBytes());
        if (jStandalonePageControllerProvider_pageController__SWIG_0 == 0) {
            return null;
        }
        return new PageController(jStandalonePageControllerProvider_pageController__SWIG_0, true);
    }

    public PageController pageController(String str, DisplayContext displayContext, RecoContext recoContext, String str2) {
        long jStandalonePageControllerProvider_pageController__SWIG_1 = NeboEngineJNI.StandalonePageControllerProvider_pageController__SWIG_1(this.swigCPtr, this, str.getBytes(), DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, str2.getBytes());
        if (jStandalonePageControllerProvider_pageController__SWIG_1 == 0) {
            return null;
        }
        return new PageController(jStandalonePageControllerProvider_pageController__SWIG_1, true);
    }

    public PageController pageController(String str, DisplayContext displayContext, RecoContext recoContext) {
        long jStandalonePageControllerProvider_pageController__SWIG_2 = NeboEngineJNI.StandalonePageControllerProvider_pageController__SWIG_2(this.swigCPtr, this, str.getBytes(), DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext);
        if (jStandalonePageControllerProvider_pageController__SWIG_2 == 0) {
            return null;
        }
        return new PageController(jStandalonePageControllerProvider_pageController__SWIG_2, true);
    }

    public boolean save() {
        return NeboEngineJNI.StandalonePageControllerProvider_save(this.swigCPtr, this);
    }

    public boolean clear() {
        return NeboEngineJNI.StandalonePageControllerProvider_clear(this.swigCPtr, this);
    }
}
