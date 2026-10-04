package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ExternalAnnotManager implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1540a;

    static native void Destroy(long j);

    static native String GetLastJSON(long j);

    static native String GetLastXFDF(long j);

    static native String GetNextRedoInfo(long j);

    static native String GetNextUndoInfo(long j);

    static native long JumpToAnnotWithID(long j, String str);

    static native void MergeXFDF(long j, String str);

    static native String Redo(long j);

    static native String TakeSnapshot(long j, String str);

    static native String Undo(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1540a;
        if (j != 0) {
            Destroy(j);
            this.f1540a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public ExternalAnnotManager(long j) {
        this.f1540a = j;
    }

    public void mergeXFDF(String str) throws PDFNetException {
        MergeXFDF(this.f1540a, str);
    }

    public String undo() throws PDFNetException {
        return Undo(this.f1540a);
    }

    public Rect jumpToAnnotWithID(String str) throws PDFNetException {
        return Rect.__Create(JumpToAnnotWithID(this.f1540a, str));
    }

    public String getLastXFDF() throws PDFNetException {
        return GetLastXFDF(this.f1540a);
    }

    public String getLastJSON() throws PDFNetException {
        return GetLastJSON(this.f1540a);
    }

    public String redo() throws PDFNetException {
        return Redo(this.f1540a);
    }

    public String getNextRedoInfo() throws PDFNetException {
        return GetNextRedoInfo(this.f1540a);
    }

    public String getNextUndoInfo() throws PDFNetException {
        return GetNextUndoInfo(this.f1540a);
    }

    public String takeSnapshot(String str) throws PDFNetException {
        return TakeSnapshot(this.f1540a, str);
    }

    public long __GetHandle() {
        return this.f1540a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
