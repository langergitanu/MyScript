package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ListItem extends ContentNode {
    protected long mImpl;

    static native long AddList(long j) throws PDFNetException;

    static native long AddParagraph(long j) throws PDFNetException;

    static native long AsContentElement(long j) throws PDFNetException;

    /* JADX INFO: renamed from: Id */
    static native int m1130Id(long j) throws PDFNetException;

    static native int Index(long j) throws PDFNetException;

    static native int Level(long j) throws PDFNetException;

    ListItem(long j) throws PDFNetException {
        super(AsContentElement(j));
        this.mImpl = j;
    }

    public Paragraph addParagraph() throws PDFNetException {
        return new Paragraph(AddParagraph(this.mImpl));
    }

    public Paragraph addParagraph(String str) throws PDFNetException {
        Paragraph paragraph = new Paragraph(AddParagraph(this.mImpl));
        paragraph.addText(str);
        return paragraph;
    }

    public List addList() throws PDFNetException {
        return new List(AddList(this.mImpl));
    }

    public int getIndentationLevel() throws PDFNetException {
        return Level(this.mImpl);
    }

    public int getListIdentifier() throws PDFNetException {
        return m1130Id(this.mImpl);
    }

    public int getItemIndex() throws PDFNetException {
        return Index(this.mImpl);
    }
}
