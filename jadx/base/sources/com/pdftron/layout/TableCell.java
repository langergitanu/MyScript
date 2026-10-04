package com.pdftron.layout;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class TableCell extends ContentNode {
    static native long AddParagraph(long j) throws PDFNetException;

    static native long AddTable(long j) throws PDFNetException;

    static native double GetBorderThickness(long j) throws PDFNetException;

    static native double GetHeight(long j) throws PDFNetException;

    static native int GetHorizontalAlignment(long j) throws PDFNetException;

    static native int GetVerticalAlignment(long j) throws PDFNetException;

    static native double GetWidth(long j) throws PDFNetException;

    static native long MergeCellsDown(long j, int i) throws PDFNetException;

    static native long MergeCellsRight(long j, int i) throws PDFNetException;

    static native void SetBackgroundColor(long j, int i, int i2, int i3) throws PDFNetException;

    static native void SetBorder(long j, double d, int i, int i2, int i3) throws PDFNetException;

    static native void SetHeight(long j, double d) throws PDFNetException;

    static native void SetHorizontalAlignment(long j, int i) throws PDFNetException;

    static native void SetVerticalAlignment(long j, int i) throws PDFNetException;

    static native void SetWidth(long j, double d) throws PDFNetException;

    public enum CellAlignmentVerticalVals {
        e_alignment_top(1),
        e_alignment_center(2),
        e_alignment_bottom(3);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, CellAlignmentVerticalVals> f1432b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1434a;

        static {
            for (CellAlignmentVerticalVals cellAlignmentVerticalVals : values()) {
                f1432b.put(Integer.valueOf(cellAlignmentVerticalVals.f1434a), cellAlignmentVerticalVals);
            }
        }

        CellAlignmentVerticalVals(int i) {
            this.f1434a = i;
        }

        /* JADX INFO: renamed from: a */
        static CellAlignmentVerticalVals m1132a(int i) {
            return f1432b.get(Integer.valueOf(i));
        }
    }

    public enum CellAlignmentHorizontalVals {
        e_alignment_left(1),
        e_alignment_middle(2),
        e_alignment_right(3);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, CellAlignmentHorizontalVals> f1429b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1431a;

        static {
            for (CellAlignmentHorizontalVals cellAlignmentHorizontalVals : values()) {
                f1429b.put(Integer.valueOf(cellAlignmentHorizontalVals.f1431a), cellAlignmentHorizontalVals);
            }
        }

        CellAlignmentHorizontalVals(int i) {
            this.f1431a = i;
        }

        /* JADX INFO: renamed from: a */
        static CellAlignmentHorizontalVals m1131a(int i) {
            return f1429b.get(Integer.valueOf(i));
        }
    }

    TableCell(long j) {
        super(j);
    }

    public Paragraph addParagraph() throws PDFNetException {
        return new Paragraph(AddParagraph(this.mImpl));
    }

    public Paragraph addParagraph(String str) throws PDFNetException {
        Paragraph paragraph = new Paragraph(AddParagraph(this.mImpl));
        paragraph.addText(str);
        return paragraph;
    }

    public Table addTable() throws PDFNetException {
        return new Table(AddTable(this.mImpl));
    }

    public TableCell mergeCellsRight(int i) throws PDFNetException {
        return new TableCell(MergeCellsRight(this.mImpl, i));
    }

    public TableCell mergeCellsDown(int i) throws PDFNetException {
        return new TableCell(MergeCellsDown(this.mImpl, i));
    }

    public void setBackgroundColor(int i, int i2, int i3) throws PDFNetException, IllegalArgumentException {
        C6928a.m1133a(i, i2, i3);
        SetBackgroundColor(this.mImpl, i, i2, i3);
    }

    public void setBorder(double d, int i, int i2, int i3) throws PDFNetException {
        SetBorder(this.mImpl, d, i, i2, i3);
    }

    public double getBorderThickness() throws PDFNetException {
        return GetBorderThickness(this.mImpl);
    }

    public void setVerticalAlignment(CellAlignmentVerticalVals cellAlignmentVerticalVals) throws PDFNetException {
        SetVerticalAlignment(this.mImpl, cellAlignmentVerticalVals.f1434a);
    }

    public CellAlignmentVerticalVals getVerticalAlignment() throws PDFNetException {
        return CellAlignmentVerticalVals.m1132a(GetVerticalAlignment(this.mImpl));
    }

    public void setHorizontalAlignment(CellAlignmentHorizontalVals cellAlignmentHorizontalVals) throws PDFNetException {
        SetHorizontalAlignment(this.mImpl, cellAlignmentHorizontalVals.f1431a);
    }

    public CellAlignmentHorizontalVals getHorizontalAlignment() throws PDFNetException {
        return CellAlignmentHorizontalVals.m1131a(GetHorizontalAlignment(this.mImpl));
    }

    public void setHeight(double d) throws PDFNetException {
        SetHeight(this.mImpl, d);
    }

    public double getHeight() throws PDFNetException {
        return GetHeight(this.mImpl);
    }

    public void setWidth(double d) throws PDFNetException {
        SetWidth(this.mImpl, d);
    }

    public double getWidth() throws PDFNetException {
        return GetWidth(this.mImpl);
    }
}
