package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class DefaultDocumentControllerFactory {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DefaultDocumentControllerFactory(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DefaultDocumentControllerFactory defaultDocumentControllerFactory) {
        if (defaultDocumentControllerFactory == null) {
            return 0L;
        }
        return defaultDocumentControllerFactory.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_DefaultDocumentControllerFactory(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static DocumentController createDocumentController(String str, String str2, String str3) {
        long jM1077xe24bb793 = NeboEngineJNI.m1077xe24bb793(str.getBytes(), str2.getBytes(), str3.getBytes());
        if (jM1077xe24bb793 == 0) {
            return null;
        }
        return new DocumentController(jM1077xe24bb793, true);
    }

    public static DocumentController createDocumentController(String str, String str2) {
        long jM1078xe24bb794 = NeboEngineJNI.m1078xe24bb794(str.getBytes(), str2.getBytes());
        if (jM1078xe24bb794 == 0) {
            return null;
        }
        return new DocumentController(jM1078xe24bb794, true);
    }

    public DefaultDocumentControllerFactory() {
        this(NeboEngineJNI.new_DefaultDocumentControllerFactory(), true);
    }
}
