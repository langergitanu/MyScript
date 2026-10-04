package com.myscript.snt.core;

import com.myscript.snt.core.NeboSanitizer;

/* JADX INFO: loaded from: classes7.dex */
public class PageControllerSanitized {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PageControllerSanitized(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PageControllerSanitized pageControllerSanitized) {
        if (pageControllerSanitized == null) {
            return 0L;
        }
        return pageControllerSanitized.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_PageControllerSanitized(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setPageController(PageController pageController) {
        NeboEngineJNI.PageControllerSanitized_pageController_set(this.swigCPtr, this, PageController.getCPtr(pageController), pageController);
    }

    public PageController getPageController() {
        long jPageControllerSanitized_pageController_get = NeboEngineJNI.PageControllerSanitized_pageController_get(this.swigCPtr, this);
        if (jPageControllerSanitized_pageController_get == 0) {
            return null;
        }
        return new PageController(jPageControllerSanitized_pageController_get, true);
    }

    public void setSanitizerResult(NeboSanitizer.SanitizerResult sanitizerResult) {
        NeboEngineJNI.PageControllerSanitized_sanitizerResult_set(this.swigCPtr, this, NeboSanitizer.SanitizerResult.getCPtr(sanitizerResult), sanitizerResult);
    }

    public NeboSanitizer.SanitizerResult getSanitizerResult() {
        long jPageControllerSanitized_sanitizerResult_get = NeboEngineJNI.PageControllerSanitized_sanitizerResult_get(this.swigCPtr, this);
        if (jPageControllerSanitized_sanitizerResult_get == 0) {
            return null;
        }
        return new NeboSanitizer.SanitizerResult(jPageControllerSanitized_sanitizerResult_get, false);
    }

    public PageControllerSanitized() {
        this(NeboEngineJNI.new_PageControllerSanitized(), true);
    }
}
