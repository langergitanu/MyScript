package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: renamed from: com.pdftron.pdf.g */
/* JADX INFO: loaded from: classes7.dex */
abstract class AbstractC6968g implements __Delete {

    /* JADX INFO: renamed from: b */
    static HashMap f2147b = new HashMap();

    /* JADX INFO: renamed from: a */
    private Thread f2148a;

    /* JADX INFO: renamed from: c */
    long f2149c;

    @Override // com.pdftron.pdf.__Delete
    public abstract void destroy() throws PDFNetException;

    AbstractC6968g() {
    }

    protected void finalize() throws Throwable {
        Object obj;
        if (this.f2149c != 0) {
            synchronized (f2147b) {
                obj = f2147b.get(this.f2148a);
            }
            if (obj != null) {
                synchronized (obj) {
                    ((LinkedList) obj).add(this);
                }
            }
        }
    }

    protected void clearList() throws PDFNetException {
        Object obj;
        this.f2148a = Thread.currentThread();
        synchronized (f2147b) {
            obj = f2147b.get(this.f2148a);
        }
        if (obj != null) {
            synchronized (obj) {
                LinkedList linkedList = (LinkedList) obj;
                while (!linkedList.isEmpty()) {
                    ((__Delete) linkedList.removeFirst()).destroy();
                }
            }
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        synchronized (f2147b) {
            f2147b.put(this.f2148a, linkedList2);
        }
    }
}
