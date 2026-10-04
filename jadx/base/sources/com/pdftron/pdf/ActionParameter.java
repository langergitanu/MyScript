package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class ActionParameter implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f1437a;

    /* JADX INFO: renamed from: b */
    private Action f1438b;

    static native long ActionParameterCreate(long j);

    static native long ActionParameterCreateWithAnnot(long j, long j2);

    static native long ActionParameterCreateWithField(long j, long j2);

    static native long ActionParameterCreateWithPage(long j, long j2);

    static native void Destroy(long j);

    public ActionParameter(Action action, Field field) throws PDFNetException {
        this.f1437a = ActionParameterCreateWithField(action.f1435a, field.f1541a);
        ReachabilityHelper.ensureReachable(field);
        this.f1438b = action;
    }

    public ActionParameter(Action action, Annot annot) throws PDFNetException {
        this.f1437a = ActionParameterCreateWithAnnot(action.f1435a, annot.f1439a);
        ReachabilityHelper.ensureReachable(annot);
        this.f1438b = action;
    }

    public ActionParameter(Action action, Page page) throws PDFNetException {
        this.f1437a = ActionParameterCreateWithPage(action.f1435a, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
        this.f1438b = action;
    }

    public ActionParameter(Action action) throws PDFNetException {
        this.f1437a = ActionParameterCreate(action.f1435a);
        this.f1438b = action;
    }

    public Action getAction() throws PDFNetException {
        return this.f1438b;
    }

    public void destroy() throws PDFNetException {
        long j = this.f1437a;
        if (j != 0) {
            Destroy(j);
            this.f1437a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    private ActionParameter(long j) {
        this.f1437a = j;
    }

    public static ActionParameter __Create(long j) {
        return new ActionParameter(j);
    }

    public long __GetHandle() {
        return this.f1437a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
