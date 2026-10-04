package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class TextWidget extends Widget {
    static native long Create(long j, long j2, long j3);

    static native long Create(long j, long j2, String str);

    static native String GetText(long j);

    static native void SetText(long j, String str);

    public TextWidget(Obj obj) {
        super(obj);
    }

    public TextWidget() {
    }

    private TextWidget(long j, Object obj) {
        super(j, obj);
    }

    public TextWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static TextWidget create(Doc doc, Rect rect, String str) throws PDFNetException {
        TextWidget textWidget = new TextWidget(Create(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return textWidget;
    }

    public static TextWidget create(Doc doc, Rect rect) throws PDFNetException {
        return create(doc, rect, "");
    }

    public static TextWidget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        TextWidget textWidget = new TextWidget(Create(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return textWidget;
    }

    public void setText(String str) throws PDFNetException {
        SetText(__GetHandle(), str);
    }

    public String getText() throws PDFNetException {
        return GetText(__GetHandle());
    }
}
