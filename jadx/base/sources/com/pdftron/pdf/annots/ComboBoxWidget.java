package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ComboBoxWidget extends Widget {
    static native void AddOption(long j, String str);

    static native void AddOptions(long j, String[] strArr);

    static native long Create(long j, long j2, long j3);

    static native long Create(long j, long j2, String str);

    static native String[] GetOptions(long j);

    static native String GetSelectedOption(long j);

    static native void RemoveOption(long j, String str);

    static native void ReplaceOptions(long j, String[] strArr);

    static native void SetSelectedOption(long j, String str);

    public ComboBoxWidget(Obj obj) {
        super(obj);
    }

    public ComboBoxWidget() {
    }

    private ComboBoxWidget(long j, Object obj) {
        super(j, obj);
    }

    public ComboBoxWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static ComboBoxWidget create(Doc doc, Rect rect, String str) throws PDFNetException {
        ComboBoxWidget comboBoxWidget = new ComboBoxWidget(Create(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return comboBoxWidget;
    }

    public static ComboBoxWidget create(Doc doc, Rect rect) throws PDFNetException {
        return create(doc, rect, "");
    }

    public static ComboBoxWidget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        ComboBoxWidget comboBoxWidget = new ComboBoxWidget(Create(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return comboBoxWidget;
    }

    public void addOption(String str) throws PDFNetException {
        AddOption(__GetHandle(), str);
    }

    public void addOptions(String[] strArr) throws PDFNetException {
        AddOptions(__GetHandle(), strArr);
    }

    public void setSelectedOption(String str) throws PDFNetException {
        SetSelectedOption(__GetHandle(), str);
    }

    public String getSelectedOption() throws PDFNetException {
        return GetSelectedOption(__GetHandle());
    }

    public String[] getOptions() throws PDFNetException {
        return GetOptions(__GetHandle());
    }

    public void replaceOptions(String[] strArr) throws PDFNetException {
        ReplaceOptions(__GetHandle(), strArr);
    }

    public void removeOption(String str) throws PDFNetException {
        RemoveOption(__GetHandle(), str);
    }
}
