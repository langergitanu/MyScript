package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class RenderingUpdateSession {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public RenderingUpdateSession(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(RenderingUpdateSession renderingUpdateSession) {
        if (renderingUpdateSession == null) {
            return 0L;
        }
        return renderingUpdateSession.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_RenderingUpdateSession(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public RenderingUpdateSession(Renderer renderer) {
        this(ATKCoreJNI.new_RenderingUpdateSession(Renderer.getCPtr(renderer), renderer), true);
    }
}
