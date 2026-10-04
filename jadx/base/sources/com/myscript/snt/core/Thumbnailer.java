package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class Thumbnailer {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Thumbnailer(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Thumbnailer thumbnailer) {
        if (thumbnailer == null) {
            return 0L;
        }
        return thumbnailer.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_Thumbnailer(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Thumbnailer() {
        this(NeboEngineJNI.new_Thumbnailer(), true);
    }

    public void addThumbnailNotificationListener(IThumbnailerNotificationListener iThumbnailerNotificationListener) {
        NeboEngineJNI.Thumbnailer_addThumbnailNotificationListener(this.swigCPtr, this, iThumbnailerNotificationListener);
    }

    public void removeThumbnailNotificationListener(IThumbnailerNotificationListener iThumbnailerNotificationListener) {
        NeboEngineJNI.Thumbnailer_removeThumbnailNotificationListener(this.swigCPtr, this, iThumbnailerNotificationListener);
    }

    public void setThumbnailImageResquester(IThumbnailerImageRequester iThumbnailerImageRequester) {
        NeboEngineJNI.Thumbnailer_setThumbnailImageResquester(this.swigCPtr, this, iThumbnailerImageRequester);
    }

    public void notifyDrawThumbnailFailed(PageKey pageKey, String str) {
        NeboEngineJNI.Thumbnailer_notifyDrawThumbnailFailed(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public void stop() {
        NeboEngineJNI.Thumbnailer_stop(this.swigCPtr, this);
    }

    public void restart() {
        NeboEngineJNI.Thumbnailer_restart(this.swigCPtr, this);
    }

    public static Thumbnailer newRef(Thumbnailer thumbnailer) {
        long jThumbnailer_newRef = NeboEngineJNI.Thumbnailer_newRef(getCPtr(thumbnailer), thumbnailer);
        if (jThumbnailer_newRef == 0) {
            return null;
        }
        return new Thumbnailer(jThumbnailer_newRef, true);
    }
}
