package com.myscript.snt.core;

import com.myscript.atk.core.SWIGVectorExtent;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SearchMatch {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SearchMatch(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SearchMatch searchMatch) {
        if (searchMatch == null) {
            return 0L;
        }
        return searchMatch.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SearchMatch(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setExtents(SWIGVectorExtent sWIGVectorExtent) {
        SWIGVectorExtent sWIGVectorExtent2 = new SWIGVectorExtent(sWIGVectorExtent);
        NeboEngineJNI.SearchMatch_extents_set(this.swigCPtr, this, SWIGVectorExtent.getCPtr(sWIGVectorExtent2), sWIGVectorExtent2);
    }

    public SWIGVectorExtent getExtents() {
        long jSearchMatch_extents_get = NeboEngineJNI.SearchMatch_extents_get(this.swigCPtr, this);
        if (jSearchMatch_extents_get == 0) {
            return null;
        }
        return new SWIGVectorExtent(jSearchMatch_extents_get, false);
    }

    public void setPageUUID(String str) {
        NeboEngineJNI.SearchMatch_pageUUID_set(this.swigCPtr, this, str.getBytes());
    }

    public String getPageUUID() {
        return new String(NeboEngineJNI.SearchMatch_pageUUID_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public SearchMatch() {
        this(NeboEngineJNI.new_SearchMatch(), true);
    }
}
