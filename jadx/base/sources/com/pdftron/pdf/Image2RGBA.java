package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes7.dex */
public class Image2RGBA extends Filter implements __Delete, AutoCloseable {

    /* JADX INFO: renamed from: a */
    private Thread f1571a;

    static native long Image2RGBAE(long j, boolean z);

    static native long Image2RGBAI(long j, boolean z);

    static native long Image2RGBAO(long j, boolean z);

    public Image2RGBA(Element element) throws PDFNetException {
        super(Image2RGBAE(element.f1533a, false), null);
        ReachabilityHelper.ensureReachable(element);
        clearList();
    }

    public Image2RGBA(Obj obj) throws PDFNetException {
        super(Image2RGBAO(obj.__GetHandle(), false), null);
        ReachabilityHelper.ensureReachable(obj);
        clearList();
    }

    public Image2RGBA(Image image) throws PDFNetException {
        super(Image2RGBAI(image.f1568a, false), null);
        ReachabilityHelper.ensureReachable(image);
        clearList();
    }

    public Image2RGBA(Element element, boolean z) throws PDFNetException {
        super(Image2RGBAE(element.f1533a, z), null);
        ReachabilityHelper.ensureReachable(element);
        clearList();
    }

    public Image2RGBA(Obj obj, boolean z) throws PDFNetException {
        super(Image2RGBAO(obj.__GetHandle(), z), null);
        ReachabilityHelper.ensureReachable(obj);
        clearList();
    }

    public Image2RGBA(Image image, boolean z) throws PDFNetException {
        super(Image2RGBAI(image.f1568a, z), null);
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
            obj = AbstractC6968g.f2147b.get(this.f1571a);
        }
        if (obj != null) {
            synchronized (obj) {
                ((LinkedList) obj).add(this);
            }
        }
    }

    protected void clearList() throws PDFNetException {
        Object obj;
        this.f1571a = Thread.currentThread();
        synchronized (AbstractC6968g.f2147b) {
            obj = AbstractC6968g.f2147b.get(this.f1571a);
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
            AbstractC6968g.f2147b.put(this.f1571a, linkedList2);
        }
    }

    @Override // com.pdftron.filters.Filter, java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
