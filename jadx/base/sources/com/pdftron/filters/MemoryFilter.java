package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class MemoryFilter extends Filter {
    static native byte[] GetBuffer(long j);

    static native long MemoryFilterCreate(long j, boolean z);

    static native void SetAsInputFilter(long j);

    public MemoryFilter(long j, boolean z) throws PDFNetException {
        super(MemoryFilterCreate(j, z), null);
    }

    public byte[] getBuffer() throws PDFNetException {
        return GetBuffer(this.impl);
    }

    public void setAsInputFilter() throws PDFNetException {
        SetAsInputFilter(this.impl);
    }
}
