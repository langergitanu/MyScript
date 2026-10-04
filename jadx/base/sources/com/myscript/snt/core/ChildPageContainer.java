package com.myscript.snt.core;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Layout;
import com.myscript.atk.core.SWIGVectorString;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ChildPageContainer {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ChildPageContainer(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ChildPageContainer childPageContainer) {
        if (childPageContainer == null) {
            return 0L;
        }
        return childPageContainer.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ChildPageContainer(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public String getWorkingDirPath() {
        return new String(NeboEngineJNI.ChildPageContainer_getWorkingDirPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public long getContainerRowId() {
        return NeboEngineJNI.ChildPageContainer_getContainerRowId(this.swigCPtr, this);
    }

    public long getChildPageRowId(String str) {
        return NeboEngineJNI.ChildPageContainer_getChildPageRowId(this.swigCPtr, this, str.getBytes());
    }

    public String getChildPageThumbnailTag(String str) {
        return new String(NeboEngineJNI.ChildPageContainer_getChildPageThumbnailTag(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public Extent getChildPageExtent(String str) {
        return new Extent(NeboEngineJNI.ChildPageContainer_getChildPageExtent(this.swigCPtr, this, str.getBytes()), true);
    }

    public Layout getLayout(String str) {
        return new Layout(NeboEngineJNI.ChildPageContainer_getLayout(this.swigCPtr, this, str.getBytes()), true);
    }

    public List<String> getChildPageIds() {
        return new SWIGVectorString(NeboEngineJNI.ChildPageContainer_getChildPageIds(this.swigCPtr, this), true);
    }
}
