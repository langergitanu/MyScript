package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.DigitalSignatureField;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Image;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class SignatureWidget extends Widget {
    static native long CreateFromDigitalSignatureField(long j, long j2, long j3);

    static native long CreateFromField(long j, long j2, long j3);

    static native long CreateSigWidgetAndFieldWithName(long j, long j2);

    static native long CreateSigWidgetAndFieldWithName(long j, long j2, String str);

    static native void CreateSignatureAppearance(long j, long j2);

    static native long GetDigitalSignatureField(long j);

    public SignatureWidget(Obj obj) {
        super(obj);
    }

    public SignatureWidget() {
    }

    private SignatureWidget(long j, Object obj) {
        super(j, obj);
    }

    public SignatureWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public DigitalSignatureField getDigitalSignatureField() throws PDFNetException {
        return DigitalSignatureField.__Create(GetDigitalSignatureField(__GetHandle()), __GetRefHandle());
    }

    public void createSignatureAppearance(Image image) throws PDFNetException {
        CreateSignatureAppearance(__GetHandle(), image.__GetHandle());
        ReachabilityHelper.ensureReachable(image);
    }

    public static SignatureWidget create(Doc doc, Rect rect, String str) throws PDFNetException {
        SignatureWidget signatureWidget = new SignatureWidget(CreateSigWidgetAndFieldWithName(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return signatureWidget;
    }

    public static SignatureWidget create(Doc doc, Rect rect) throws PDFNetException {
        SignatureWidget signatureWidget = new SignatureWidget(CreateSigWidgetAndFieldWithName(doc.__GetHandle(), rect.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        return signatureWidget;
    }

    public static SignatureWidget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        SignatureWidget signatureWidget = new SignatureWidget(CreateFromField(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return signatureWidget;
    }

    public static SignatureWidget create(Doc doc, Rect rect, DigitalSignatureField digitalSignatureField) throws PDFNetException {
        SignatureWidget signatureWidget = new SignatureWidget(CreateFromDigitalSignatureField(doc.__GetHandle(), rect.__GetHandle(), digitalSignatureField.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(digitalSignatureField);
        return signatureWidget;
    }
}
