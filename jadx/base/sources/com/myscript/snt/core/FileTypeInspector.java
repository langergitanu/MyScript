package com.myscript.snt.core;

import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class FileTypeInspector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public FileTypeInspector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(FileTypeInspector fileTypeInspector) {
        if (fileTypeInspector == null) {
            return 0L;
        }
        return fileTypeInspector.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_FileTypeInspector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    private static long SwigConstructFileTypeInspector(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        return NeboEngineJNI.new_FileTypeInspector(SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public FileTypeInspector(List<String> list) {
        this(SwigConstructFileTypeInspector(list), true);
    }

    public boolean searchable(String str) {
        return NeboEngineJNI.FileTypeInspector_searchable(this.swigCPtr, this, str.getBytes());
    }
}
