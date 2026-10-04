package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class UndoManager implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2189a;

    static native boolean CanRedo(long j);

    static native boolean CanUndo(long j);

    static native void Destroy(long j);

    static native long DiscardAllSnapshots(long j);

    static native long GetNextRedoSnapshot(long j);

    static native long GetNextUndoSnapshot(long j);

    static native long Redo(long j);

    static native long TakeSnapshot(long j);

    static native long Undo(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2189a;
        if (j != 0) {
            Destroy(j);
            this.f2189a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public UndoManager(long j) {
        this.f2189a = j;
    }

    public DocSnapshot discardAllSnapshots() throws PDFNetException {
        return new DocSnapshot(DiscardAllSnapshots(this.f2189a));
    }

    public ResultSnapshot undo() throws PDFNetException {
        return new ResultSnapshot(Undo(this.f2189a));
    }

    public boolean canUndo() throws PDFNetException {
        return CanUndo(this.f2189a);
    }

    public DocSnapshot getNextUndoSnapshot() throws PDFNetException {
        return new DocSnapshot(GetNextUndoSnapshot(this.f2189a));
    }

    public ResultSnapshot redo() throws PDFNetException {
        return new ResultSnapshot(Redo(this.f2189a));
    }

    public boolean canRedo() throws PDFNetException {
        return CanRedo(this.f2189a);
    }

    public DocSnapshot getNextRedoSnapshot() throws PDFNetException {
        return new DocSnapshot(GetNextRedoSnapshot(this.f2189a));
    }

    public ResultSnapshot takeSnapshot() throws PDFNetException {
        return new ResultSnapshot(TakeSnapshot(this.f2189a));
    }

    public long __GetHandle() {
        return this.f2189a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
