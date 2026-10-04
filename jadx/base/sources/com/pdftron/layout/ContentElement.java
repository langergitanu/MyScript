package com.pdftron.layout;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ContentElement {
    protected long mImpl;

    private static native long AsContentNode(long j) throws PDFNetException;

    private static native long AsList(long j) throws PDFNetException;

    private static native long AsListItem(long j) throws PDFNetException;

    private static native long AsParagraph(long j) throws PDFNetException;

    private static native long AsTable(long j) throws PDFNetException;

    private static native long AsTableCell(long j) throws PDFNetException;

    private static native long AsTableRow(long j) throws PDFNetException;

    private static native long AsTextRun(long j) throws PDFNetException;

    ContentElement(long j) {
        this.mImpl = j;
    }

    public TextStyledElement getTextStyledElement() {
        return new TextStyledElement(this.mImpl);
    }

    public TextRun asTextRun() throws PDFNetException {
        long jAsTextRun = AsTextRun(this.mImpl);
        if (jAsTextRun != 0) {
            return new TextRun(jAsTextRun);
        }
        return null;
    }

    public ContentNode asContentNode() throws PDFNetException {
        long jAsContentNode = AsContentNode(this.mImpl);
        if (jAsContentNode != 0) {
            return new ContentNode(jAsContentNode);
        }
        return null;
    }

    public Paragraph asParagraph() throws PDFNetException {
        long jAsParagraph = AsParagraph(this.mImpl);
        if (jAsParagraph != 0) {
            return new Paragraph(jAsParagraph);
        }
        return null;
    }

    public List asList() throws PDFNetException {
        long jAsList = AsList(this.mImpl);
        if (jAsList != 0) {
            return new List(jAsList);
        }
        return null;
    }

    public ListItem asListItem() throws PDFNetException {
        long jAsListItem = AsListItem(this.mImpl);
        if (jAsListItem != 0) {
            return new ListItem(jAsListItem);
        }
        return null;
    }

    public TableCell asTableCell() throws PDFNetException {
        long jAsTableCell = AsTableCell(this.mImpl);
        if (jAsTableCell != 0) {
            return new TableCell(jAsTableCell);
        }
        return null;
    }

    public TableRow asTableRow() throws PDFNetException {
        long jAsTableRow = AsTableRow(this.mImpl);
        if (jAsTableRow != 0) {
            return new TableRow(jAsTableRow);
        }
        return null;
    }

    public Table asTable() throws PDFNetException {
        long jAsTable = AsTable(this.mImpl);
        if (jAsTable != 0) {
            return new Table(jAsTable);
        }
        return null;
    }
}
