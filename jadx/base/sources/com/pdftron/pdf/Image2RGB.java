package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes7.dex */
public class Image2RGB extends Filter implements __Delete, AutoCloseable {

    /* JADX INFO: renamed from: a */
    private Thread f1570a;

    static native long Image2RGBE(long j);

    static native long Image2RGBI(long j);

    static native long Image2RGBO(long j);

    public Image2RGB(Element element) throws PDFNetException {
        super(Image2RGBE(element.f1533a), null);
        ReachabilityHelper.ensureReachable(element);
        clearList();
    }

    public Image2RGB(Obj obj) throws PDFNetException {
        super(Image2RGBO(obj.__GetHandle()), null);
        ReachabilityHelper.ensureReachable(obj);
        clearList();
    }

    public Image2RGB(Image image) throws PDFNetException {
        super(Image2RGBI(image.f1568a), null);
        ReachabilityHelper.ensureReachable(image);
        clearList();
    }

    @Override // com.pdftron.filters.Filter
    public void destroy() throws PDFNetException {
        super.destroy();
    }

    @Override // com.pdftron.filters.Filter
    protected void finalize() throws Throwable {
        Object obj;
        if (this.impl == 0 || this.ref != null) {
            return;
        }
        synchronized (AbstractC6968g.f2147b) {
            obj = AbstractC6968g.f2147b.get(this.f1570a);
        }
        if (obj != null) {
            synchronized (obj) {
                ((LinkedList) obj).add(this);
            }
        }
    }

    protected void clearList() throws PDFNetException {
        Object obj;
        this.f1570a = Thread.currentThread();
        synchronized (AbstractC6968g.f2147b) {
            obj = AbstractC6968g.f2147b.get(this.f1570a);
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
        synchronized (AbstractC6968g.f2147b) {
            AbstractC6968g.f2147b.put(this.f1570a, linkedList2);
        }
    }

    @Override // com.pdftron.filters.Filter, java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
