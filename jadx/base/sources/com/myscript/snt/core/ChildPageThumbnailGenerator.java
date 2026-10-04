package com.myscript.snt.core;

import com.myscript.atk.core.IColorInversionPolicy;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ChildPageThumbnailGenerator implements AutoCloseable, IChildPageThumbnailGenerator {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ChildPageThumbnailGenerator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ChildPageThumbnailGenerator childPageThumbnailGenerator) {
        if (childPageThumbnailGenerator == null) {
            return 0L;
        }
        return childPageThumbnailGenerator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ChildPageThumbnailGenerator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public static ChildPageThumbnailGenerator create(SWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t sWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t, IThumbnailerImageRequester iThumbnailerImageRequester, IColorInversionPolicy iColorInversionPolicy) {
        long jChildPageThumbnailGenerator_create__SWIG_0 = NeboEngineJNI.ChildPageThumbnailGenerator_create__SWIG_0(SWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t), iThumbnailerImageRequester, iColorInversionPolicy);
        if (jChildPageThumbnailGenerator_create__SWIG_0 == 0) {
            return null;
        }
        return new ChildPageThumbnailGenerator(jChildPageThumbnailGenerator_create__SWIG_0, true);
    }

    public static ChildPageThumbnailGenerator create(SWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t sWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t, IThumbnailerImageRequester iThumbnailerImageRequester) {
        long jChildPageThumbnailGenerator_create__SWIG_1 = NeboEngineJNI.ChildPageThumbnailGenerator_create__SWIG_1(SWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__ChildPageContainer_t), iThumbnailerImageRequester);
        if (jChildPageThumbnailGenerator_create__SWIG_1 == 0) {
            return null;
        }
        return new ChildPageThumbnailGenerator(jChildPageThumbnailGenerator_create__SWIG_1, true);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public void stop() {
        NeboEngineJNI.ChildPageThumbnailGenerator_stop(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public void addListener(IChildPageThumbnailListener iChildPageThumbnailListener) {
        NeboEngineJNI.ChildPageThumbnailGenerator_addListener(this.swigCPtr, this, iChildPageThumbnailListener);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public void removeListener(IChildPageThumbnailListener iChildPageThumbnailListener) {
        NeboEngineJNI.ChildPageThumbnailGenerator_removeListener(this.swigCPtr, this, iChildPageThumbnailListener);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public void setColorInversionPolicy(IColorInversionPolicy iColorInversionPolicy) {
        NeboEngineJNI.ChildPageThumbnailGenerator_setColorInversionPolicy(this.swigCPtr, this, iColorInversionPolicy);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public void setThumbnailSize(long j) {
        NeboEngineJNI.ChildPageThumbnailGenerator_setThumbnailSize(this.swigCPtr, this, j);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public String getThumbnailPath(String str) {
        return new String(NeboEngineJNI.ChildPageThumbnailGenerator_getThumbnailPath(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public boolean generateThumbnail(String str, boolean z) {
        return NeboEngineJNI.ChildPageThumbnailGenerator_generateThumbnail(this.swigCPtr, this, str.getBytes(), z);
    }

    @Override // com.myscript.snt.core.IChildPageThumbnailGenerator
    public void cleanOldThumbnails() {
        NeboEngineJNI.ChildPageThumbnailGenerator_cleanOldThumbnails(this.swigCPtr, this);
    }

    public static ChildPageThumbnailGenerator newRef(ChildPageThumbnailGenerator childPageThumbnailGenerator) {
        long jChildPageThumbnailGenerator_newRef = NeboEngineJNI.ChildPageThumbnailGenerator_newRef(getCPtr(childPageThumbnailGenerator), childPageThumbnailGenerator);
        if (jChildPageThumbnailGenerator_newRef == 0) {
            return null;
        }
        return new ChildPageThumbnailGenerator(jChildPageThumbnailGenerator_newRef, true);
    }
}
