package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.Annot;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class RadioButtonWidget extends Widget {
    static native void EnableButton(long j);

    static native long GetGroup(long j);

    static native boolean IsEnabled(long j);

    public RadioButtonWidget(Obj obj) {
        super(obj);
    }

    public RadioButtonWidget() {
    }

    RadioButtonWidget(long j, Object obj) {
        super(j, obj);
    }

    public RadioButtonWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public RadioButtonGroup getGroup() throws PDFNetException {
        return new RadioButtonGroup(GetGroup(__GetHandle()), __GetRefHandle());
    }

    public void enableButton() throws PDFNetException {
        EnableButton(__GetHandle());
    }

    public boolean isEnabled() throws PDFNetException {
        return IsEnabled(__GetHandle());
    }
}
