package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Annot;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ListBoxWidget extends Widget {
    static native void AddOption(long j, String str);

    static native void AddOptions(long j, String[] strArr);

    static native long Create(long j, long j2, long j3);

    static native long Create(long j, long j2, String str);

    static native String[] GetOptions(long j);

    static native String[] GetSelectedOptions(long j);

    static native void RemoveOption(long j, String str);

    static native void ReplaceOptions(long j, String[] strArr);

    static native void SetSelectedOptions(long j, String[] strArr);

    public ListBoxWidget(Obj obj) {
        super(obj);
    }

    public ListBoxWidget() {
    }

    private ListBoxWidget(long j, Object obj) {
        super(j, obj);
    }

    public ListBoxWidget(Annot annot) throws PDFNetException {
        super(annot.getSDFObj());
    }

    public static ListBoxWidget create(Doc doc, Rect rect, String str) throws PDFNetException {
        ListBoxWidget listBoxWidget = new ListBoxWidget(Create(doc.__GetHandle(), rect.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(rect);
        return listBoxWidget;
    }

    public static ListBoxWidget create(Doc doc, Rect rect) throws PDFNetException {
        return create(doc, rect, "");
    }

    public static ListBoxWidget create(Doc doc, Rect rect, Field field) throws PDFNetException {
        ListBoxWidget listBoxWidget = new ListBoxWidget(Create(doc.__GetHandle(), rect.__GetHandle(), field.__GetHandle()), doc);
        ReachabilityHelper.ensureReachable(rect);
        ReachabilityHelper.ensureReachable(field);
        return listBoxWidget;
    }

    public void addOption(String str) throws PDFNetException {
        AddOption(__GetHandle(), str);
    }

    public void addOptions(String[] strArr) throws PDFNetException {
        AddOptions(__GetHandle(), strArr);
    }

    public void setSelectedOptions(String[] strArr) throws PDFNetException {
        SetSelectedOptions(__GetHandle(), strArr);
    }

    public String[] getSelectedOptions() throws PDFNetException {
        return GetSelectedOptions(__GetHandle());
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
