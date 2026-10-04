package com.pdftron.pdf;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintJob;
import android.print.PrintJobInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.credentials.provider.CredentialEntry;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class Print {
    public static final int PRINT_CONTENT_ANNOTATION_BIT = 2;
    public static final int PRINT_CONTENT_DOCUMENT_BIT = 1;
    public static final int PRINT_CONTENT_SUMMARY_BIT = 4;

    /* JADX INFO: renamed from: a */
    static final ArrayList<PrintJob> f2004a = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private static ArrayList<PrintCallback> f2005b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private static final ReentrantLock f2006c = new ReentrantLock();

    public interface PrintCallback {
        void onPrintCancelled();

        void onPrintCompleted(int i, int i2);

        void onPrintFailed();
    }

    static native void Format(long j, long j2, long j3, long j4);

    static native void FormatWithCancel(long j, long j2, long j3, long j4, long j5, long j6);

    public static void addPrintListener(PrintCallback printCallback) {
        ReentrantLock reentrantLock = f2006c;
        reentrantLock.lock();
        if (!f2005b.contains(printCallback)) {
            f2005b.add(printCallback);
        }
        reentrantLock.unlock();
    }

    public static void removePrintListener(PrintCallback printCallback) {
        ReentrantLock reentrantLock = f2006c;
        reentrantLock.lock();
        if (f2005b.contains(printCallback)) {
            f2005b.remove(printCallback);
        }
        reentrantLock.unlock();
    }

    public static void clearPrintListeners() {
        ReentrantLock reentrantLock = f2006c;
        reentrantLock.lock();
        f2005b.clear();
        reentrantLock.unlock();
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.Print$a */
    static class HandlerC6960a extends Handler {
        private HandlerC6960a() {
        }

        /* synthetic */ HandlerC6960a(byte b) {
            this();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ArrayList arrayList = new ArrayList();
            for (PrintJob printJob : Print.f2004a) {
                if (printJob.isCompleted()) {
                    PrintJobInfo info = printJob.getInfo();
                    int i = message.what;
                    int copies = info.getCopies();
                    arrayList.add(printJob);
                    Print.f2006c.lock();
                    Iterator it = Print.f2005b.iterator();
                    while (it.hasNext()) {
                        ((PrintCallback) it.next()).onPrintCompleted(i, copies);
                    }
                    Print.f2006c.unlock();
                } else if (printJob.isFailed()) {
                    arrayList.add(printJob);
                    Print.f2006c.lock();
                    Iterator it2 = Print.f2005b.iterator();
                    while (it2.hasNext()) {
                        ((PrintCallback) it2.next()).onPrintFailed();
                    }
                    Print.f2006c.unlock();
                } else if (printJob.isCancelled()) {
                    arrayList.add(printJob);
                    Print.f2006c.lock();
                    Iterator it3 = Print.f2005b.iterator();
                    while (it3.hasNext()) {
                        ((PrintCallback) it3.next()).onPrintCancelled();
                    }
                    Print.f2006c.unlock();
                }
            }
            Print.f2004a.removeAll(arrayList);
        }
    }

    public static void startPrintJob(Context context, String str, PDFDoc pDFDoc, Integer num, Boolean bool) throws PDFNetException {
        startPrintJob(context, str, pDFDoc, num, bool, (com.pdftron.pdf.ocg.Context) null);
    }

    public static void startPrintJob(Context context, String str, PDFDoc pDFDoc, Integer num, Boolean bool, com.pdftron.pdf.ocg.Context context2) throws PDFNetException {
        startPrintJob(context, str, null, pDFDoc, num, bool, context2);
    }

    public static void startPrintJob(Context context, String str, String str2, PDFDoc pDFDoc, Integer num, Boolean bool, com.pdftron.pdf.ocg.Context context2) throws PDFNetException {
        HandlerC6960a handlerC6960a = new HandlerC6960a((byte) 0);
        if (pDFDoc.getRoot().findObj("Collection") != null) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 0L, "Print.java", "startPrintJob", "The document is a portfolio/collection and can't be printed.");
        }
        f2004a.add(((PrintManager) context.getSystemService("print")).print(str, new C69591(pDFDoc, num.intValue(), bool.booleanValue(), context2, str2, handlerC6960a), null));
    }

    /* JADX INFO: renamed from: com.pdftron.pdf.Print$1 */
    final class C69591 extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ PDFDoc f2007a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ int f2008b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ boolean f2009c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ com.pdftron.pdf.ocg.Context f2010d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ String f2011e;

        /* JADX INFO: renamed from: f */
        private PrintDocumentInfo f2012f;

        /* JADX INFO: renamed from: g */
        private PDFDoc f2013g;

        /* JADX INFO: renamed from: h */
        private final ReentrantLock f2014h = new ReentrantLock();

        /* JADX INFO: renamed from: i */
        private final ReentrantLock f2015i = new ReentrantLock();

        /* JADX INFO: renamed from: j */
        private int f2016j;

        /* JADX INFO: renamed from: k */
        private int f2017k;

        /* JADX INFO: renamed from: l */
        private boolean f2018l;

        /* JADX INFO: renamed from: m */
        private PageRange[] f2019m;

        /* JADX INFO: renamed from: n */
        private /* synthetic */ HandlerC6960a f2020n;

        C69591(PDFDoc pDFDoc, int i, boolean z, com.pdftron.pdf.ocg.Context context, String str, HandlerC6960a handlerC6960a) {
            this.f2007a = pDFDoc;
            this.f2008b = i;
            this.f2009c = z;
            this.f2010d = context;
            this.f2011e = str;
            this.f2020n = handlerC6960a;
        }

        /* JADX INFO: renamed from: a */
        static /* synthetic */ int m1476a(C69591 c69591) {
            int i = c69591.f2016j + 1;
            c69591.f2016j = i;
            return i;
        }

        /* JADX INFO: renamed from: f */
        static /* synthetic */ int m1484f(C69591 c69591) {
            int i = c69591.f2016j - 1;
            c69591.f2016j = i;
            return i;
        }

        /* JADX INFO: renamed from: i */
        static /* synthetic */ int m1487i(C69591 c69591) {
            int i = c69591.f2017k + 1;
            c69591.f2017k = i;
            return i;
        }

        /* JADX INFO: renamed from: j */
        static /* synthetic */ int m1488j(C69591 c69591) {
            int i = c69591.f2017k - 1;
            c69591.f2017k = i;
            return i;
        }

        @Override // android.print.PrintDocumentAdapter
        public final void onStart() {
            super.onStart();
            this.f2012f = null;
            this.f2013g = null;
            this.f2016j = 0;
            this.f2017k = 0;
            this.f2018l = false;
        }

        @Override // android.print.PrintDocumentAdapter
        public final void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            PrintDocumentInfo printDocumentInfo;
            if (printAttributes2.equals(printAttributes) && (printDocumentInfo = this.f2012f) != null) {
                layoutResultCallback.onLayoutFinished(printDocumentInfo, true);
            } else {
                new AnonymousClass1(cancellationSignal, layoutResultCallback, printAttributes2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
            }
        }

        /* JADX INFO: renamed from: com.pdftron.pdf.Print$1$1, reason: invalid class name */
        final class AnonymousClass1 extends AsyncTask<Void, Void, Integer> {

            /* JADX INFO: renamed from: a */
            CancelFlag f2021a = null;

            /* JADX INFO: renamed from: c */
            private /* synthetic */ CancellationSignal f2023c;

            /* JADX INFO: renamed from: d */
            private /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f2024d;

            /* JADX INFO: renamed from: e */
            private /* synthetic */ PrintAttributes f2025e;

            AnonymousClass1(CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, PrintAttributes printAttributes) {
                this.f2023c = cancellationSignal;
                this.f2024d = layoutResultCallback;
                this.f2025e = printAttributes;
            }

            @Override // android.os.AsyncTask
            protected final /* synthetic */ Integer doInBackground(Void[] voidArr) {
                return m1490a();
            }

            @Override // android.os.AsyncTask
            protected final /* synthetic */ void onPostExecute(Integer num) {
                if (num.intValue() == 1 && C69591.this.f2013g != null) {
                    try {
                        C69591.this.f2012f = new PrintDocumentInfo.Builder(C69591.this.f2011e != null ? C69591.this.f2011e : Print.m1468a(C69591.this.f2007a.getFileName())).setContentType(0).setPageCount(C69591.this.f2013g.getPageCount()).build();
                        if (C69591.this.f2012f != null) {
                            this.f2024d.onLayoutFinished(C69591.this.f2012f, true);
                        } else {
                            this.f2024d.onLayoutFailed("An error occurred while trying to print the document.");
                            Log.e("Print", "onLayoutFailed: printDocumentInfo is null");
                        }
                    } catch (Exception e) {
                        this.f2024d.onLayoutFailed("An error occurred while trying to print the document.");
                        Log.e("Print", "onLayoutFailed: " + e.getMessage());
                    }
                } else {
                    this.f2024d.onLayoutFailed("An error occurred while trying to print the document.");
                    Log.e("Print", "onLayoutFailed: ".concat(C69591.this.f2013g == null ? "output document is null" : "failed on creating layout"));
                }
                C69591.m1484f(C69591.this);
                if (C69591.this.f2017k == 0 && C69591.this.f2018l && C69591.this.f2013g != null) {
                    Print.m1470a(C69591.this.f2013g);
                    C69591.this.f2013g = null;
                }
            }

            @Override // android.os.AsyncTask
            protected final void onPreExecute() {
                C69591.m1476a(C69591.this);
                this.f2023c.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.pdftron.pdf.Print.1.1.1
                    @Override // android.os.CancellationSignal.OnCancelListener
                    public final void onCancel() {
                        AnonymousClass1.this.cancel(true);
                        C69591.this.f2015i.lock();
                        if (AnonymousClass1.this.f2021a != null) {
                            AnonymousClass1.this.f2021a.set(true);
                        }
                        C69591.this.f2015i.unlock();
                    }
                });
            }

            /* JADX WARN: Removed duplicated region for block: B:130:0x02df  */
            /* JADX WARN: Removed duplicated region for block: B:137:0x0302 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:175:0x02e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:184:0x035d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:201:0x0334 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:203:0x02f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:231:? A[SYNTHETIC] */
            /* JADX INFO: renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private Integer m1490a() throws Throwable {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                PageSet pageSet;
                CancelFlag cancelFlag;
                if (isCancelled()) {
                    return -1;
                }
                try {
                    try {
                        C69591.this.f2007a.lockRead();
                        try {
                            z2 = true;
                            pageSet = new PageSet(1, C69591.this.f2007a.getPageCount());
                            try {
                                Obj objCreateDict = new ObjSet().createDict();
                                objCreateDict.putBool("PORTRAIT", this.f2025e.getMediaSize().isPortrait());
                                objCreateDict.putNumber("PAPER_SIZE_HEIGHT", this.f2025e.getMediaSize().getHeightMils());
                                objCreateDict.putNumber("PAPER_SIZE_WIDTH", this.f2025e.getMediaSize().getWidthMils());
                                if ((C69591.this.f2008b & 1) == 0 && (C69591.this.f2008b & 4) != 0) {
                                    objCreateDict.putNumber("PRINT_CONTENT", 3.0d);
                                } else if (C69591.this.f2008b == 1) {
                                    objCreateDict.putNumber("PRINT_CONTENT", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                                } else if ((C69591.this.f2008b & 4) == 0) {
                                    objCreateDict.putNumber("PRINT_CONTENT", 1.0d);
                                } else {
                                    objCreateDict.putNumber("PRINT_CONTENT", 2.0d);
                                }
                                objCreateDict.putBool("IS_RTL", C69591.this.f2009c);
                                objCreateDict.putBool("IS_PAGE_SCALE_TYPE_FIT_PAGE", true);
                                if (isCancelled()) {
                                    CancelFlag cancelFlag2 = this.f2021a;
                                    if (cancelFlag2 != null) {
                                        cancelFlag2.destroy();
                                        this.f2021a = null;
                                    }
                                    PDFDoc unused = C69591.this.f2013g;
                                    try {
                                        pageSet.destroy();
                                    } catch (Exception unused2) {
                                    }
                                    return -1;
                                }
                                while (!C69591.this.f2014h.tryLock()) {
                                    Thread.sleep(50L);
                                    if (isCancelled()) {
                                        CancelFlag cancelFlag3 = this.f2021a;
                                        if (cancelFlag3 != null) {
                                            cancelFlag3.destroy();
                                            this.f2021a = null;
                                        }
                                        PDFDoc unused3 = C69591.this.f2013g;
                                        try {
                                            pageSet.destroy();
                                        } catch (Exception unused4) {
                                        }
                                        return -1;
                                    }
                                }
                                try {
                                    if (C69591.this.f2013g != null) {
                                        C69591.this.f2013g.close();
                                        C69591.this.f2013g = null;
                                    }
                                    C69591.this.f2013g = new PDFDoc();
                                    C69591.this.f2013g.lock();
                                    try {
                                        C69591.this.f2007a.lockRead();
                                        try {
                                            C69591.this.f2015i.lock();
                                            try {
                                                this.f2021a = new CancelFlag();
                                                Print.FormatWithCancel(C69591.this.f2007a.__GetHandle(), pageSet.__GetHandle(), C69591.this.f2013g.__GetHandle(), objCreateDict.__GetHandle(), this.f2021a.__GetHandle(), C69591.this.f2010d != null ? C69591.this.f2010d.__GetHandle() : 0L);
                                                CancelFlag cancelFlag4 = this.f2021a;
                                                if (cancelFlag4 != null) {
                                                    cancelFlag4.destroy();
                                                    this.f2021a = null;
                                                }
                                                try {
                                                    C69591.this.f2015i.unlock();
                                                } catch (Exception unused5) {
                                                }
                                                try {
                                                    C69591.this.f2014h.unlock();
                                                } catch (Exception unused6) {
                                                }
                                                if (C69591.this.f2013g != null) {
                                                    try {
                                                        C69591.this.f2013g.unlock();
                                                    } catch (Exception e) {
                                                        C69591.this.f2013g = null;
                                                        this.f2024d.onLayoutFailed("An error occurred while trying to print the document: cannot write on the output PDF file");
                                                        Log.e("Print", "onLayoutFailed: " + e.getMessage());
                                                        return 0;
                                                    }
                                                }
                                                try {
                                                    C69591.this.f2007a.unlockRead();
                                                    try {
                                                        pageSet.destroy();
                                                    } catch (Exception unused7) {
                                                    }
                                                    return isCancelled() ? -1 : 1;
                                                } catch (Exception e2) {
                                                    this.f2024d.onLayoutFailed("An error occurred while trying to print the document: cannot access the input PDF file");
                                                    Log.e("Print", "onLayoutFailed: " + e2.getMessage());
                                                    return 0;
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                z = true;
                                                z3 = true;
                                            } catch (Throwable th) {
                                                th = th;
                                                z = true;
                                                z3 = true;
                                                z4 = z3;
                                                cancelFlag = this.f2021a;
                                                if (cancelFlag != null) {
                                                }
                                                if (z2) {
                                                }
                                                if (z) {
                                                }
                                                if (C69591.this.f2013g != null) {
                                                    try {
                                                        C69591.this.f2013g.unlock();
                                                    } catch (Exception e4) {
                                                        C69591.this.f2013g = null;
                                                        this.f2024d.onLayoutFailed("An error occurred while trying to print the document: cannot write on the output PDF file");
                                                        Log.e("Print", "onLayoutFailed: " + e4.getMessage());
                                                        return 0;
                                                    }
                                                }
                                                if (z4) {
                                                }
                                                if (pageSet != null) {
                                                }
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            z = true;
                                            z3 = true;
                                            z4 = true;
                                            z2 = false;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            z = true;
                                            z3 = true;
                                            z4 = true;
                                            z2 = false;
                                            cancelFlag = this.f2021a;
                                            if (cancelFlag != null) {
                                            }
                                            if (z2) {
                                            }
                                            if (z) {
                                            }
                                            if (C69591.this.f2013g != null) {
                                            }
                                            if (z4) {
                                            }
                                            if (pageSet != null) {
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        z4 = false;
                                        z = true;
                                        z3 = true;
                                        z2 = z4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z4 = false;
                                        z = true;
                                        z3 = true;
                                        z2 = z4;
                                        cancelFlag = this.f2021a;
                                        if (cancelFlag != null) {
                                        }
                                        if (z2) {
                                        }
                                        if (z) {
                                        }
                                        if (C69591.this.f2013g != null) {
                                        }
                                        if (z4) {
                                        }
                                        if (pageSet != null) {
                                        }
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    z3 = false;
                                    z4 = false;
                                    z = true;
                                } catch (Throwable th4) {
                                    th = th4;
                                    z3 = false;
                                    z4 = false;
                                    z = true;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                z = false;
                                z2 = false;
                                z3 = false;
                            } catch (Throwable th5) {
                                th = th5;
                                z = false;
                                z2 = false;
                                z3 = false;
                            }
                            z4 = z3;
                        } catch (Exception e9) {
                            e = e9;
                            z = false;
                            z2 = false;
                            z3 = false;
                            z4 = false;
                            pageSet = null;
                        } catch (Throwable th6) {
                            th = th6;
                            z = false;
                            z2 = false;
                            z3 = false;
                            z4 = false;
                            pageSet = null;
                        }
                        try {
                            this.f2024d.onLayoutFailed("An error occurred while trying to print the document.");
                            Log.e("Print", "onLayoutFailed: " + e.getMessage());
                            CancelFlag cancelFlag5 = this.f2021a;
                            if (cancelFlag5 != null) {
                                cancelFlag5.destroy();
                                this.f2021a = null;
                            }
                            if (z2) {
                                try {
                                    C69591.this.f2015i.unlock();
                                } catch (Exception unused8) {
                                }
                            }
                            if (z) {
                                try {
                                    C69591.this.f2014h.unlock();
                                } catch (Exception unused9) {
                                }
                            }
                            if (C69591.this.f2013g != null && z3) {
                                try {
                                    C69591.this.f2013g.unlock();
                                } catch (Exception e10) {
                                    C69591.this.f2013g = null;
                                    this.f2024d.onLayoutFailed("An error occurred while trying to print the document: cannot write on the output PDF file");
                                    Log.e("Print", "onLayoutFailed: " + e10.getMessage());
                                    return 0;
                                }
                            }
                            if (z4) {
                                try {
                                    C69591.this.f2007a.unlockRead();
                                } catch (Exception e11) {
                                    this.f2024d.onLayoutFailed("An error occurred while trying to print the document: cannot access the input PDF file");
                                    Log.e("Print", "onLayoutFailed: " + e11.getMessage());
                                    return 0;
                                }
                            }
                            if (pageSet != null) {
                                try {
                                    pageSet.destroy();
                                } catch (Exception unused10) {
                                }
                            }
                            return 0;
                        } catch (Throwable th7) {
                            th = th7;
                            cancelFlag = this.f2021a;
                            if (cancelFlag != null) {
                                cancelFlag.destroy();
                                this.f2021a = null;
                            }
                            if (z2) {
                                try {
                                    C69591.this.f2015i.unlock();
                                } catch (Exception unused11) {
                                }
                            }
                            if (z) {
                                try {
                                    C69591.this.f2014h.unlock();
                                } catch (Exception unused12) {
                                }
                            }
                            if (C69591.this.f2013g != null && z3) {
                                C69591.this.f2013g.unlock();
                            }
                            if (z4) {
                                try {
                                    C69591.this.f2007a.unlockRead();
                                } catch (Exception e12) {
                                    this.f2024d.onLayoutFailed("An error occurred while trying to print the document: cannot access the input PDF file");
                                    Log.e("Print", "onLayoutFailed: " + e12.getMessage());
                                    return 0;
                                }
                            }
                            if (pageSet != null) {
                                throw th;
                            }
                            try {
                                pageSet.destroy();
                                throw th;
                            } catch (Exception unused13) {
                                throw th;
                            }
                        }
                    } finally {
                        try {
                            C69591.this.f2007a.unlockRead();
                        } catch (PDFNetException unused14) {
                        }
                    }
                } catch (PDFNetException unused15) {
                    this.f2024d.onLayoutFailed("The input document is locked somewhere.");
                    try {
                        C69591.this.f2007a.unlockRead();
                    } catch (PDFNetException unused16) {
                    }
                    return 0;
                }
            }

            @Override // android.os.AsyncTask
            protected final /* synthetic */ void onCancelled(Integer num) {
                C69591.m1484f(C69591.this);
                this.f2024d.onLayoutCancelled();
                if (C69591.this.f2017k == 0 && C69591.this.f2018l && C69591.this.f2013g != null) {
                    Print.m1470a(C69591.this.f2013g);
                    C69591.this.f2013g = null;
                }
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.pdftron.pdf.Print$1$2] */
        @Override // android.print.PrintDocumentAdapter
        public final void onWrite(final PageRange[] pageRangeArr, final ParcelFileDescriptor parcelFileDescriptor, final CancellationSignal cancellationSignal, final PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            new AsyncTask<Void, Void, Void>() { // from class: com.pdftron.pdf.Print.1.2
                @Override // android.os.AsyncTask
                protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
                    return m1491a();
                }

                @Override // android.os.AsyncTask
                protected final void onPreExecute() {
                    C69591.m1487i(C69591.this);
                    cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: com.pdftron.pdf.Print.1.2.1
                        @Override // android.os.CancellationSignal.OnCancelListener
                        public final void onCancel() {
                            cancel(true);
                        }
                    });
                }

                /* JADX WARN: Code restructure failed: missing block: B:101:0x01f6, code lost:
                
                    r14.f2031e.f2013g.unlockRead();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:102:0x01ff, code lost:
                
                    return null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:105:0x0202, code lost:
                
                    r14.f2031e.f2014h.unlock();
                    com.pdftron.pdf.Print.m1471a(r4);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:106:0x0214, code lost:
                
                    if (r14.f2031e.f2013g != null) goto L107;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:108:0x0218, code lost:
                
                    r14.f2031e.f2013g.unlockRead();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:109:0x0221, code lost:
                
                    throw r0;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
                
                    if (r14.f2031e.f2013g != null) goto L18;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
                
                    r14.f2031e.f2013g.lockRead();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
                
                    if (com.pdftron.pdf.Print.m1472a(r4, r14.f2031e.f2013g.getPageCount()) == false) goto L152;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
                
                    if (isCancelled() == false) goto L28;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
                
                    r14.f2031e.f2014h.unlock();
                    com.pdftron.pdf.Print.m1471a(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x008b, code lost:
                
                    if (r14.f2031e.f2013g == null) goto L27;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
                
                    r14.f2031e.f2013g.unlockRead();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:28:0x0097, code lost:
                
                    r14.f2031e.f2013g.save(r5, 32, (com.pdftron.pdf.ProgressMonitor) null);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
                
                    r7 = new com.pdftron.pdf.PDFDoc();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
                
                    r7.lock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
                
                    r10 = r14.f2031e.f2013g.getPageCount();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
                
                    if (r3 >= r10) goto L160;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:
                
                    if (com.pdftron.pdf.Print.m1475c(r4, r3) == false) goto L37;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
                
                    r7.pagePushBack(r14.f2031e.f2013g.getPage(r3 + 1));
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00d0, code lost:
                
                    if (isCancelled() == false) goto L45;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00d2, code lost:
                
                    r7.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x00f6, code lost:
                
                    r3 = r3 + 1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00f9, code lost:
                
                    r7.save(r5, 32, (com.pdftron.pdf.ProgressMonitor) null);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:0x00fc, code lost:
                
                    r7.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x014b, code lost:
                
                    r3 = th;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x014c, code lost:
                
                    r8 = r7;
                    r7 = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:62:0x0150, code lost:
                
                    r3 = e;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:0x0151, code lost:
                
                    r8 = r7;
                    r7 = true;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
                
                    r8 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:65:0x0155, code lost:
                
                    r7 = false;
                    r3 = r8;
                    r8 = r7;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:66:0x015a, code lost:
                
                    r8 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:67:0x015b, code lost:
                
                    r7 = false;
                    r3 = r8;
                    r8 = r7;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:68:0x0160, code lost:
                
                    r7 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:69:0x0161, code lost:
                
                    r7 = false;
                    r3 = r7;
                    r8 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:70:0x0166, code lost:
                
                    r7 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:71:0x0167, code lost:
                
                    r7 = false;
                    r3 = r7;
                    r8 = null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:72:0x016b, code lost:
                
                    r5.onWriteFailed("An error occurred while trying to print the document: on write failed");
                    android.util.Log.e("Print", "onWriteFailed: " + r3.getMessage());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:73:0x0184, code lost:
                
                    if (r8 != null) goto L74;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:75:0x0188, code lost:
                
                    r8.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
                
                    com.pdftron.pdf.Print.m1470a(r8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:77:0x018e, code lost:
                
                    r14.f2031e.f2014h.unlock();
                    com.pdftron.pdf.Print.m1471a(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:78:0x01a0, code lost:
                
                    if (r14.f2031e.f2013g != null) goto L123;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:79:0x01a2, code lost:
                
                    r14.f2031e.f2013g.unlockRead();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:80:0x01ab, code lost:
                
                    return null;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:81:0x01ac, code lost:
                
                    r3 = th;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:82:0x01ad, code lost:
                
                    if (r8 != null) goto L83;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:84:0x01b1, code lost:
                
                    r8.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:85:0x01b4, code lost:
                
                    com.pdftron.pdf.Print.m1470a(r8);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:86:0x01b7, code lost:
                
                    throw r3;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:87:0x01b8, code lost:
                
                    r0 = th;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:88:0x01b9, code lost:
                
                    r4 = r5;
                    r3 = 1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:89:0x01bc, code lost:
                
                    r3 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:90:0x01bd, code lost:
                
                    r6 = r3;
                    r3 = 1;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:97:0x01c7, code lost:
                
                    r5.onWriteFailed("An error occurred while trying to print the document: on write failed");
                    android.util.Log.e("Print", "onWriteFailed: " + r6.getMessage());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:98:0x01e0, code lost:
                
                    r14.f2031e.f2014h.unlock();
                    com.pdftron.pdf.Print.m1471a(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:99:0x01f2, code lost:
                
                    if (r14.f2031e.f2013g != null) goto L100;
                 */
                /* JADX WARN: Not initialized variable reg: 5, insn: 0x0201: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:104:0x0201 */
                /* JADX INFO: renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                private Void m1491a() throws Throwable {
                    FileOutputStream fileOutputStream;
                    FileOutputStream fileOutputStream2;
                    PDFDoc pDFDoc;
                    FileOutputStream fileOutputStream3 = null;
                    if (isCancelled() || C69591.this.f2013g == null) {
                        return null;
                    }
                    int i = 0;
                    try {
                        try {
                            fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                            while (true) {
                                try {
                                    if (C69591.this.f2014h.tryLock()) {
                                        break;
                                    }
                                    Thread.sleep(50L);
                                    if (isCancelled()) {
                                        break;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                }
                            }
                            C69591.this.f2014h.unlock();
                            Print.m1471a(fileOutputStream);
                            PDFDoc unused = C69591.this.f2013g;
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream3 = fileOutputStream2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    Print.m1470a(pDFDoc);
                    C69591.this.f2014h.unlock();
                    Print.m1471a(fileOutputStream);
                    if (C69591.this.f2013g != null) {
                        try {
                            C69591.this.f2013g.unlockRead();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                    return null;
                    Print.m1470a(pDFDoc);
                    if (isCancelled()) {
                        C69591.this.f2014h.unlock();
                        Print.m1471a(fileOutputStream);
                        if (C69591.this.f2013g != null) {
                            try {
                                C69591.this.f2013g.unlockRead();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    }
                    writeResultCallback.onWriteFinished(pageRangeArr);
                    C69591.this.f2014h.unlock();
                    Print.m1471a(fileOutputStream);
                    if (C69591.this.f2013g != null) {
                        try {
                            C69591.this.f2013g.unlockRead();
                        } catch (Exception unused4) {
                        }
                    }
                    return null;
                    return null;
                    return null;
                    return null;
                }

                @Override // android.os.AsyncTask
                protected final /* synthetic */ void onCancelled(Void r2) {
                    C69591.m1488j(C69591.this);
                    writeResultCallback.onWriteCancelled();
                    if (C69591.this.f2016j == 0 && C69591.this.f2018l && C69591.this.f2013g != null) {
                        Print.m1470a(C69591.this.f2013g);
                        C69591.this.f2013g = null;
                    }
                }

                @Override // android.os.AsyncTask
                protected final /* synthetic */ void onPostExecute(Void r2) {
                    C69591.m1488j(C69591.this);
                    if (C69591.this.f2016j == 0 && C69591.this.f2018l && C69591.this.f2013g != null) {
                        Print.m1470a(C69591.this.f2013g);
                        C69591.this.f2013g = null;
                    }
                    C69591.this.f2019m = pageRangeArr;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
        @Override // android.print.PrintDocumentAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onFinish() {
            int pageCount;
            PageRange[] pageRangeArr;
            PDFDoc pDFDoc;
            super.onFinish();
            if (this.f2016j == 0 && this.f2017k == 0 && (pDFDoc = this.f2013g) != null) {
                Print.m1470a(pDFDoc);
                this.f2013g = null;
            } else {
                this.f2018l = true;
            }
            int i = 0;
            try {
                try {
                    this.f2007a.lockRead();
                    pageCount = this.f2007a.getPageCount();
                    try {
                        this.f2007a.unlockRead();
                    } catch (PDFNetException unused) {
                    }
                } catch (PDFNetException unused2) {
                    pageCount = 0;
                    pageRangeArr = this.f2019m;
                    if (pageRangeArr != null) {
                        int i2 = 0;
                        while (i < pageCount) {
                        }
                        i = i2;
                    }
                    this.f2020n.sendEmptyMessageDelayed(i, 200L);
                }
            } catch (PDFNetException unused3) {
                this.f2007a.unlockRead();
                pageCount = 0;
                pageRangeArr = this.f2019m;
                if (pageRangeArr != null) {
                }
                this.f2020n.sendEmptyMessageDelayed(i, 200L);
            } catch (Throwable th) {
                try {
                    this.f2007a.unlockRead();
                } catch (PDFNetException unused4) {
                }
                throw th;
            }
            pageRangeArr = this.f2019m;
            if (pageRangeArr != null && pageRangeArr.length > 0) {
                int i22 = 0;
                while (i < pageCount) {
                    if (Print.m1475c(this.f2019m, i)) {
                        i22++;
                    }
                    i++;
                }
                i = i22;
            }
            this.f2020n.sendEmptyMessageDelayed(i, 200L);
        }
    }

    public static void startPrintJob(Context context, String str, PDFDoc pDFDoc, String str2, Integer num, Boolean bool) throws PDFNetException {
        if (!pDFDoc.initSecurityHandler() && !pDFDoc.initStdSecurityHandler(str2)) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 0L, "Print.java", "startPrintJob", "The document is encrypted and the password supplied is wrong.");
        }
        startPrintJob(context, str, pDFDoc, num, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static boolean m1475c(PageRange[] pageRangeArr, int i) {
        int length = pageRangeArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (pageRangeArr[i2].getStart() <= i && pageRangeArr[i2].getEnd() >= i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PDFDoc exportAnnotations(PDFDoc pDFDoc, boolean z) throws Throwable {
        PageSet pageSet;
        Obj objCreateDict;
        PDFDoc pDFDoc2;
        Log.d("Print", "start exportAnnotations");
        PDFDoc pDFDoc3 = null;
        boolean z2 = false;
        try {
            boolean z3 = true;
            pageSet = new PageSet(1, pDFDoc.getPageCount());
            try {
                objCreateDict = new ObjSet().createDict();
                objCreateDict.putNumber("PRINT_CONTENT", 3.0d);
                objCreateDict.putBool("IS_RTL", z);
                pDFDoc2 = new PDFDoc();
                try {
                    pDFDoc2.lock();
                    try {
                        pDFDoc.lockRead();
                    } catch (PDFNetException e) {
                        e = e;
                        z3 = false;
                        z2 = true;
                        pDFDoc3 = pDFDoc2;
                    } catch (Throwable th) {
                        th = th;
                        pDFDoc3 = pDFDoc2;
                    }
                } catch (PDFNetException e2) {
                    e = e2;
                    pDFDoc3 = pDFDoc2;
                    z3 = false;
                    try {
                        throw new PDFNetException(CredentialEntry.FALSE_STRING, 0L, "Print.java", "exportAnnotations", e.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                        boolean z4 = z3;
                        z3 = z2;
                        z2 = z4;
                        if (z2) {
                            try {
                                pDFDoc.unlockRead();
                            } catch (PDFNetException unused) {
                            }
                        }
                        if (pDFDoc3 != null && z3) {
                            try {
                                pDFDoc3.unlock();
                            } catch (PDFNetException unused2) {
                            }
                        }
                        if (pageSet != null) {
                            try {
                                pageSet.destroy();
                                throw th;
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pDFDoc3 = pDFDoc2;
                    z3 = false;
                    if (z2) {
                    }
                    if (pDFDoc3 != null) {
                        pDFDoc3.unlock();
                    }
                    if (pageSet != null) {
                    }
                }
            } catch (PDFNetException e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (PDFNetException e4) {
            e = e4;
            pageSet = null;
        } catch (Throwable th5) {
            th = th5;
            pageSet = null;
        }
        try {
            Format(pDFDoc.__GetHandle(), pageSet.__GetHandle(), pDFDoc2.__GetHandle(), objCreateDict.__GetHandle());
            try {
                pDFDoc.unlockRead();
            } catch (PDFNetException unused4) {
            }
            try {
                pDFDoc2.unlock();
            } catch (PDFNetException unused5) {
            }
            try {
                pageSet.destroy();
            } catch (Exception unused6) {
            }
            return pDFDoc2;
        } catch (PDFNetException e5) {
            e = e5;
            pDFDoc3 = pDFDoc2;
            z2 = true;
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 0L, "Print.java", "exportAnnotations", e.getMessage());
        } catch (Throwable th6) {
            th = th6;
            pDFDoc3 = pDFDoc2;
            z2 = true;
            if (z2) {
            }
            if (pDFDoc3 != null) {
            }
            if (pageSet != null) {
            }
        }
    }

    public static class Compat {
        public static void Format(long j, long j2, long j3, long j4) throws PDFNetException {
            Print.Format(j, j2, j3, j4);
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ String m1468a(String str) {
        if (str != null) {
            String strSubstring = str.substring(str.lastIndexOf(47) + 1);
            int iLastIndexOf = strSubstring.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                strSubstring = strSubstring.substring(0, iLastIndexOf);
            }
            String str2 = strSubstring + "-print.pdf";
            return (str2 == null || str2.isEmpty()) ? "temp.pdf" : str2;
        }
        return "temp.pdf";
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1470a(PDFDoc pDFDoc) {
        if (pDFDoc != null) {
            try {
                pDFDoc.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m1472a(PageRange[] pageRangeArr, int i) {
        if (pageRangeArr[0].equals(PageRange.ALL_PAGES)) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!m1475c(pageRangeArr, i2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m1471a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
