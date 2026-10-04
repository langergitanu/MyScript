package com.myscript.snt.core;

import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.SWIGVectorCustomResource;
import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RecoContext {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public RecoContext(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(RecoContext recoContext) {
        if (recoContext == null) {
            return 0L;
        }
        return recoContext.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_RecoContext(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setTypesetListener(SWIGTYPE_p_std__shared_ptrT_atk__core__TypesetListener_t sWIGTYPE_p_std__shared_ptrT_atk__core__TypesetListener_t) {
        NeboEngineJNI.RecoContext_typesetListener_set(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__TypesetListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__TypesetListener_t));
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__TypesetListener_t getTypesetListener() {
        long jRecoContext_typesetListener_get = NeboEngineJNI.RecoContext_typesetListener_get(this.swigCPtr, this);
        if (jRecoContext_typesetListener_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__TypesetListener_t(jRecoContext_typesetListener_get, false);
    }

    public void setResourcesDirs(SWIGVectorString sWIGVectorString) {
        SWIGVectorString sWIGVectorString2 = new SWIGVectorString(sWIGVectorString);
        NeboEngineJNI.RecoContext_resourcesDirs_set(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString2), sWIGVectorString2);
    }

    public SWIGVectorString getResourcesDirs() {
        long jRecoContext_resourcesDirs_get = NeboEngineJNI.RecoContext_resourcesDirs_get(this.swigCPtr, this);
        if (jRecoContext_resourcesDirs_get == 0) {
            return null;
        }
        return new SWIGVectorString(jRecoContext_resourcesDirs_get, false);
    }

    public void setCustomResources(SWIGVectorCustomResource sWIGVectorCustomResource) {
        SWIGVectorCustomResource sWIGVectorCustomResource2 = new SWIGVectorCustomResource(sWIGVectorCustomResource);
        NeboEngineJNI.RecoContext_customResources_set(this.swigCPtr, this, SWIGVectorCustomResource.getCPtr(sWIGVectorCustomResource2), sWIGVectorCustomResource2);
    }

    public SWIGVectorCustomResource getCustomResources() {
        long jRecoContext_customResources_get = NeboEngineJNI.RecoContext_customResources_get(this.swigCPtr, this);
        if (jRecoContext_customResources_get == 0) {
            return null;
        }
        return new SWIGVectorCustomResource(jRecoContext_customResources_get, false);
    }

    private static long SwigConstructRecoContext(ITypesetListener iTypesetListener, List<String> list, List<CustomResource> list2) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        SWIGVectorCustomResource sWIGVectorCustomResource = new SWIGVectorCustomResource(list2);
        return NeboEngineJNI.new_RecoContext__SWIG_0(iTypesetListener, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, SWIGVectorCustomResource.getCPtr(sWIGVectorCustomResource), sWIGVectorCustomResource);
    }

    public RecoContext(ITypesetListener iTypesetListener, List<String> list, List<CustomResource> list2) {
        this(SwigConstructRecoContext(iTypesetListener, list, list2), true);
    }

    private static long SwigConstructRecoContext(ITypesetListener iTypesetListener, List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        return NeboEngineJNI.new_RecoContext__SWIG_1(iTypesetListener, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public RecoContext(ITypesetListener iTypesetListener, List<String> list) {
        this(SwigConstructRecoContext(iTypesetListener, list), true);
    }

    public boolean hasReco() {
        return NeboEngineJNI.RecoContext_hasReco(this.swigCPtr, this);
    }
}
