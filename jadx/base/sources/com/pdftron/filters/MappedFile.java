package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class MappedFile extends Filter {
    public static final int e_append_mode = 2;
    public static final int e_read_mode = 0;
    public static final int e_write_mode = 1;

    static native long FileSize(long j);

    static native long MappedFileCreate(String str);

    public MappedFile(String str) throws PDFNetException {
        super(MappedFileCreate(str), null);
    }

    public long fileSize() throws PDFNetException {
        return FileSize(this.impl);
    }
}
