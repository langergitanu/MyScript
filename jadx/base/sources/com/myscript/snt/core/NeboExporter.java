package com.myscript.snt.core;

import com.myscript.atk.core.Json;
import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class NeboExporter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NeboExporter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NeboExporter neboExporter) {
        if (neboExporter == null) {
            return 0L;
        }
        return neboExporter.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_NeboExporter(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean exportPages(List<String> list, boolean z, String str, Json json, String str2, boolean z2, boolean z3) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        return NeboEngineJNI.NeboExporter_exportPages(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, z, str.getBytes(), Json.getCPtr(json), json, str2.getBytes(), z2, z3);
    }

    public List<String> exportRaw(String str, List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        return new SWIGVectorString(NeboEngineJNI.NeboExporter_exportRaw(this.swigCPtr, this, str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString), true);
    }
}
