package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class TableRow extends ContentNode {
    static native long AddTableCell(long j) throws PDFNetException;

    static native int GetNumColumns(long j) throws PDFNetException;

    static native void SetRowHeight(long j, double d) throws PDFNetException;

    TableRow(long j) {
        super(j);
    }

    public TableCell addTableCell() throws PDFNetException {
        return new TableCell(AddTableCell(this.mImpl));
    }

    public void setRowHeight(double d) throws PDFNetException {
        SetRowHeight(this.mImpl, d);
    }

    public int getNumColumns() throws PDFNetException {
        return GetNumColumns(this.mImpl);
    }
}
