package com.pdftron.pdf.annots;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.Field;
import com.pdftron.pdf.Page;
import com.pdftron.pdf.Rect;
import com.pdftron.sdf.Doc;

/* JADX INFO: loaded from: classes7.dex */
public class RadioButtonGroup implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2105a;

    /* JADX INFO: renamed from: b */
    private Object f2106b;

    static native long Add(long j, long j2, String str);

    static native void AddGroupButtonsToPage(long j, long j2);

    static native long Create(long j, String str);

    static native long CreateFromField(long j);

    static native void Destroy(long j);

    static native long GetButton(long j, int i);

    static native long GetField(long j);

    static native int GetNumButtons(long j);

    public RadioButtonGroup(Field field) {
        this.f2105a = CreateFromField(field.__GetHandle());
        this.f2106b = field.__GetRefHandle();
    }

    public static RadioButtonGroup create(Doc doc, String str) throws PDFNetException {
        return new RadioButtonGroup(Create(doc.__GetHandle(), str), doc);
    }

    public static RadioButtonGroup create(Doc doc) throws PDFNetException {
        return create(doc, "");
    }

    public RadioButtonGroup() {
        this.f2105a = 0L;
        this.f2106b = null;
    }

    public RadioButtonWidget add(Rect rect, String str) throws PDFNetException {
        RadioButtonWidget radioButtonWidget = new RadioButtonWidget(Add(this.f2105a, rect.__GetHandle(), str), this.f2106b);
        ReachabilityHelper.ensureReachable(rect);
        return radioButtonWidget;
    }

    public RadioButtonWidget add(Rect rect) throws PDFNetException {
        return add(rect, "");
    }

    public int getNumButtons() throws PDFNetException {
        return GetNumButtons(this.f2105a);
    }

    public RadioButtonWidget getButton(int i) throws PDFNetException {
        return new RadioButtonWidget(GetButton(this.f2105a, i), this.f2106b);
    }

    public Field getField() throws PDFNetException {
        return Field.__Create(GetField(this.f2105a), this.f2106b);
    }

    public void addGroupButtonsToPage(Page page) throws PDFNetException {
        AddGroupButtonsToPage(this.f2105a, page.__GetHandle());
        ReachabilityHelper.ensureReachable(page);
    }

    public void destroy() throws PDFNetException {
        long j = this.f2105a;
        if (j != 0) {
            Destroy(j);
            this.f2105a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    RadioButtonGroup(long j, Object obj) {
        this.f2105a = j;
        this.f2106b = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
