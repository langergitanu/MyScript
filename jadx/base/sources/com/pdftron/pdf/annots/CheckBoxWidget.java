package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class CheckBoxWidget extends Widget {
    static native long Create(long j, long j2, long j3);

    static native long Create(long j, long j2, String str);

    static native boolean IsChecked(long j);

    static native void SetChecked(long j, boolean z);

    public CheckBoxWidget(Obj obj) {
        super(obj);
    }

    public CheckBoxWidget() {
    }

    private CheckBoxWidget(long j, Object obj) {
        super(j, obj);
    }

    public CheckBoxWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static CheckBoxWidget create(Doc doc, Rect rect, String str) throws PDFNetException {
        CheckBoxWidget checkBoxWidget = new CheckBoxWidget(Create(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return checkBoxWidget;
    }

    public static CheckBoxWidget create(Doc doc, Rect rect) throws PDFNetException {
        return create(doc, rect, "");
    }

    public static CheckBoxWidget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        CheckBoxWidget checkBoxWidget = new CheckBoxWidget(Create(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return checkBoxWidget;
    }

    public boolean isChecked() throws PDFNetException {
        return IsChecked(__GetHandle());
    }

    public void setChecked(boolean z) throws PDFNetException {
        SetChecked(__GetHandle(), z);
    }
}
