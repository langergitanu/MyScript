package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PushButtonWidget extends Widget {
    static native long Create(long j, long j2, long j3);

    static native long Create(long j, long j2, String str);

    public PushButtonWidget(Obj obj) {
        super(obj);
    }

    public PushButtonWidget() {
    }

    private PushButtonWidget(long j, Object obj) {
        super(j, obj);
    }

    public PushButtonWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static PushButtonWidget create(Doc doc, Rect rect, String str) throws PDFNetException {
        PushButtonWidget pushButtonWidget = new PushButtonWidget(Create(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return pushButtonWidget;
    }

    public static PushButtonWidget create(Doc doc, Rect rect) throws PDFNetException {
        return create(doc, rect, "");
    }

    public static PushButtonWidget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        PushButtonWidget pushButtonWidget = new PushButtonWidget(Create(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return pushButtonWidget;
    }
}
