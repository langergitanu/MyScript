package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultPendingStrokeIdProvider extends IPendingStrokeIdProvider {
    private transient long swigCPtr;

    public DefaultPendingStrokeIdProvider(long j, boolean z) {
        super(ATKCoreJNI.DefaultPendingStrokeIdProvider_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(DefaultPendingStrokeIdProvider defaultPendingStrokeIdProvider) {
        if (defaultPendingStrokeIdProvider == null) {
            return 0L;
        }
        return defaultPendingStrokeIdProvider.swigCPtr;
    }

    @Override // com.myscript.atk.core.IPendingStrokeIdProvider
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.IPendingStrokeIdProvider
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_DefaultPendingStrokeIdProvider(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public DefaultPendingStrokeIdProvider() {
        this(ATKCoreJNI.new_DefaultPendingStrokeIdProvider(), true);
    }

    @Override // com.myscript.atk.core.IPendingStrokeIdProvider
    public long nextPendingStrokeId() {
        return ATKCoreJNI.DefaultPendingStrokeIdProvider_nextPendingStrokeId(this.swigCPtr, this);
    }

    @Override // com.myscript.atk.core.IPendingStrokeIdProvider
    public long allocatePendingStrokeId() {
        return ATKCoreJNI.DefaultPendingStrokeIdProvider_allocatePendingStrokeId(this.swigCPtr, this);
    }
}
