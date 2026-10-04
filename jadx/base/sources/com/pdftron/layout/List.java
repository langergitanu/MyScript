package com.pdftron.layout;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class List extends ContentNode {
    protected long mImpl;

    static native long AddItem(long j) throws PDFNetException;

    static native long AsContentElement(long j) throws PDFNetException;

    static native void ContinueList(long j) throws PDFNetException;

    /* JADX INFO: renamed from: Id */
    static native int m1129Id(long j) throws PDFNetException;

    static native int Level(long j) throws PDFNetException;

    static native void SetNumberFormat(long j, int i, String str, boolean z) throws PDFNetException;

    static native void SetStartIndex(long j, int i) throws PDFNetException;

    public enum ListItemNumberFormat {
        e_none(0),
        e_decimal(1),
        e_lower_roman(2),
        e_upper_roman(3),
        e_lower_letter(4),
        e_upper_letter(5),
        e_ordinal(6),
        e_ordinal_text(7),
        e_chinese_counting(8),
        e_chinese_counting_thousand(9),
        e_cardinal_text(10),
        e_decimal_zero(11);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, ListItemNumberFormat> f1422b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1424a;

        static {
            for (ListItemNumberFormat listItemNumberFormat : values()) {
                f1422b.put(Integer.valueOf(listItemNumberFormat.f1424a), listItemNumberFormat);
            }
        }

        ListItemNumberFormat(int i) {
            this.f1424a = i;
        }
    }

    List(long j) throws PDFNetException {
        super(AsContentElement(j));
        this.mImpl = j;
    }

    public void setNumberFormat(ListItemNumberFormat listItemNumberFormat) throws PDFNetException {
        SetNumberFormat(this.mImpl, listItemNumberFormat.f1424a, ".", false);
    }

    public void setNumberFormat(ListItemNumberFormat listItemNumberFormat, String str, boolean z) throws PDFNetException {
        SetNumberFormat(this.mImpl, listItemNumberFormat.f1424a, str, z);
    }

    public TextStyledElement getLabelStyle() throws PDFNetException {
        return new TextStyledElement(AsContentElement(this.mImpl));
    }

    public void setStartIndex(int i) throws PDFNetException {
        SetStartIndex(this.mImpl, i);
    }

    public ListItem addItem() throws PDFNetException {
        return new ListItem(AddItem(this.mImpl));
    }

    public void continueList() throws PDFNetException {
        ContinueList(this.mImpl);
    }

    public int getIndentationLevel() throws PDFNetException {
        return Level(this.mImpl);
    }

    public int getListIdentifier() throws PDFNetException {
        return m1129Id(this.mImpl);
    }
}
