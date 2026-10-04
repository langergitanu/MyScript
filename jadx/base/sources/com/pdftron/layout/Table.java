package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class Table extends ContentNode {
    static native long AddTableRow(long j) throws PDFNetException;

    static native double GetBorderThickness(long j) throws PDFNetException;

    static native double GetDefaultRowHeight(long j) throws PDFNetException;

    static native int GetNumColumns(long j) throws PDFNetException;

    static native int GetNumRows(long j) throws PDFNetException;

    static native long GetTableCell(long j, int i, int i2) throws PDFNetException;

    static native void SetBorder(long j, double d, int i, int i2, int i3) throws PDFNetException;

    static native void SetDefaultColumnWidth(long j, double d) throws PDFNetException;

    static native void SetDefaultRowHeight(long j, double d) throws PDFNetException;

    Table(long j) {
        super(j);
    }

    public TableRow addTableRow() throws PDFNetException {
        return new TableRow(AddTableRow(this.mImpl));
    }

    public TableCell getTableCell(int i, int i2) throws PDFNetException {
        return new TableCell(GetTableCell(this.mImpl, i, i2));
    }

    public void setDefaultColumnWidth(double d) throws PDFNetException {
        SetDefaultColumnWidth(this.mImpl, d);
    }

    public double getDefaultRowHeight() throws PDFNetException {
        return GetDefaultRowHeight(this.mImpl);
    }

    public void setDefaultRowHeight(double d) throws PDFNetException {
        SetDefaultRowHeight(this.mImpl, d);
    }

    public void setBorder(double d, int i, int i2, int i3) throws PDFNetException, IllegalArgumentException {
        C6928a.m1133a(i, i2, i3);
        SetBorder(this.mImpl, d, i, i2, i3);
    }

    public double getBorderThickness() throws PDFNetException {
        return GetBorderThickness(this.mImpl);
    }

    public int getNumRows() throws PDFNetException {
        return GetNumRows(this.mImpl);
    }

    public int getNumColumns() throws PDFNetException {
        return GetNumColumns(this.mImpl);
    }
}
