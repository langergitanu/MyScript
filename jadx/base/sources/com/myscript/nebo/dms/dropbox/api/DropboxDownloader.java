package com.myscript.nebo.dms.dropbox.api;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.myscript.android.utils.ThreadExt;
import com.myscript.nebo.dms.cloud.common.api.Downloader;
import com.myscript.nebo.dms.cloud.common.api.ProgressListener;
import com.myscript.nebo.dms.cloud.common.utils.ProgressOutputStream;
import com.myscript.snt.dms.BatchResult;
import com.myscript.snt.dms.CloudFileRequest;
import com.myscript.snt.dms.SWIGVectorCloudFileRequest;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.p039io.CloseableKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: DropboxDownloader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/DropboxDownloader;", "Lcom/myscript/nebo/dms/cloud/common/api/Downloader;", NotificationCompat.CATEGORY_SERVICE, "Lcom/dropbox/core/v2/DbxClientV2;", "<init>", "(Lcom/dropbox/core/v2/DbxClientV2;)V", "downloaders", "", "Lcom/myscript/snt/dms/CloudFileRequest;", "Lcom/dropbox/core/DbxDownloader;", "Lcom/dropbox/core/v2/files/FileMetadata;", "canceled", "", "setCanceled", "(Z)V", "launchDownload", "cloudFileRequest", "progressListener", "Lcom/myscript/nebo/dms/cloud/common/api/ProgressListener;", "(Lcom/myscript/snt/dms/CloudFileRequest;Lcom/myscript/nebo/dms/cloud/common/api/ProgressListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download", "Lcom/myscript/snt/dms/BatchResult;", "cloudFileRequests", "Lcom/myscript/snt/dms/SWIGVectorCloudFileRequest;", "callback", "cancel", "", "Companion", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DropboxDownloader extends Downloader {
    private static final int CHUNKED_ATTEMPTS_COUNT = 5;
    private static final long CHUNKED_ATTEMPTS_TEMPO = 1000;
    private static final int MAX_DOWNLOAD_TRY = 5;
    private static final int MAX_PARALLEL_SESSIONS = 50;
    private static final String TAG = "DropboxDownloader";
    private volatile boolean canceled;
    private Map<CloudFileRequest, DbxDownloader<FileMetadata>> downloaders;
    private final DbxClientV2 service;

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.api.DropboxDownloader$launchDownload$1 */
    /* JADX INFO: compiled from: DropboxDownloader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.dropbox.api.DropboxDownloader", m1609f = "DropboxDownloader.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {102, 117}, m1612m = "launchDownload", m1613n = {"cloudFileRequest", "progressListener", "notebookCloudPathOrId", "localPath", "file", "ex", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "cloudFileRequest", "progressListener", "notebookCloudPathOrId", "localPath", "file", CmcdData.OBJECT_TYPE_INIT_SEGMENT}, m1614nl = {HttpStatusCodesKt.HTTP_EARLY_HINTS, 64}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m1616v = 2)
    static final class C62531 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C62531(Continuation<? super C62531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DropboxDownloader.this.launchDownload(null, null, this);
        }
    }

    public DropboxDownloader(DbxClientV2 service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
        this.downloaders = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCanceled(boolean z) {
        if (this.canceled == z) {
            return;
        }
        synchronized (this.downloaders) {
            this.canceled = z;
            if (!z) {
                this.downloaders.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:144|42|43|146|44|(1:46)(3:47|55|(5:58|(7:60|125|64|132|65|66|(3:68|16c|72)(2:76|77))|99|(6:102|103|116|117|37|(4:120|24a|124|125)(0))|113)(1:57))) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01e5, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e8, code lost:
    
        r14 = r14;
        r15 = r15;
        r9 = r6;
        r4 = r4;
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01f4, code lost:
    
        r4 = r14;
        r5 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f8, code lost:
    
        if (r19.canceled == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01fa, code lost:
    
        r8 = r0.getBackoffMillis();
        r10 = new com.myscript.nebo.dms.dropbox.api.DropboxDownloader$$ExternalSyntheticLambda1(r19);
        r13.L$0 = r2;
        r13.L$1 = r7;
        r13.L$2 = r6;
        r13.L$3 = r5;
        r13.L$4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16);
        r13.L$5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0);
        r13.I$0 = r4;
        r13.label = 1;
        r18 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0228, code lost:
    
        if (com.myscript.android.utils.ThreadExt.cancellableDelay$default(r8, r10, 0, r13, 4, null) != r3) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x022b, code lost:
    
        r11 = r2;
        r9 = r6;
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0232, code lost:
    
        r14 = r4;
        r16 = r16;
        r15 = r5;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0247, code lost:
    
        throw new java.io.IOException("Canceled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0109, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x018d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a1, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.getMessage(), "Canceled") != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117 A[Catch: NetworkIOException -> 0x0104, IOException -> 0x018b, RetryException -> 0x018d, Exception -> 0x0190, CancellationException -> 0x0192, TryCatch #14 {CancellationException -> 0x0192, Exception -> 0x0190, blocks: (B:40:0x00e3, B:42:0x00e7, B:44:0x00fa, B:55:0x010f, B:58:0x0117, B:60:0x0123, B:61:0x0125, B:63:0x012e, B:64:0x012f, B:66:0x015f, B:68:0x016a, B:69:0x016c, B:71:0x0175, B:74:0x0178, B:75:0x0179, B:76:0x017a, B:77:0x017f, B:82:0x0184, B:83:0x0187, B:85:0x0189, B:86:0x018a), top: B:136:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01d5 -> B:103:0x01dc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object launchDownload(CloudFileRequest cloudFileRequest, ProgressListener progressListener, Continuation<? super FileMetadata> continuation) throws Exception {
        C62531 c62531;
        String str;
        String str2;
        int i;
        File file;
        final ProgressListener progressListener2;
        C62531 c625312;
        final CloudFileRequest cloudFileRequest2;
        File parentFile;
        String str3;
        int i2;
        boolean z;
        Throwable th;
        CloudFileRequest cloudFileRequest3;
        boolean z2;
        if (continuation instanceof C62531) {
            c62531 = (C62531) continuation;
            if ((c62531.label & Integer.MIN_VALUE) != 0) {
                c62531.label -= Integer.MIN_VALUE;
            } else {
                c62531 = new C62531(continuation);
            }
        }
        Object obj = c62531.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c62531.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            String path = cloudFileRequest.getFile().getPath();
            String id = (path == null || path.length() == 0) ? cloudFileRequest.getFile().getId() : cloudFileRequest.getFile().getPath();
            String outputPath = cloudFileRequest.getOutputPath();
            if (outputPath == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            File file2 = new File(outputPath);
            File parentFile2 = file2.getParentFile();
            if (parentFile2 != null && !parentFile2.exists() && (parentFile = file2.getParentFile()) != null && !parentFile.mkdirs()) {
                throw new IllegalAccessError("Unable to create directory: " + file2.getParentFile());
            }
            str = id;
            str2 = outputPath;
            i = 1;
            file = file2;
            progressListener2 = progressListener;
            c625312 = c62531;
            cloudFileRequest2 = cloudFileRequest;
            if (i >= 6) {
            }
        } else if (i3 == 1) {
            int i4 = c62531.I$0;
            File file3 = (File) c62531.L$4;
            String str4 = (String) c62531.L$3;
            str = (String) c62531.L$2;
            ProgressListener progressListener3 = (ProgressListener) c62531.L$1;
            cloudFileRequest3 = (CloudFileRequest) c62531.L$0;
            ResultKt.throwOnFailure(obj);
            z = true;
            i2 = i4;
            file = file3;
            str2 = str4;
            progressListener2 = progressListener3;
            c625312 = c62531;
            cloudFileRequest2 = cloudFileRequest3;
            i = i2 + 1;
            if (i >= 6) {
            }
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = c62531.I$0;
            File file4 = (File) c62531.L$4;
            String str5 = (String) c62531.L$3;
            str = (String) c62531.L$2;
            ProgressListener progressListener4 = (ProgressListener) c62531.L$1;
            cloudFileRequest3 = (CloudFileRequest) c62531.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i5;
            file = file4;
            str2 = str5;
            progressListener2 = progressListener4;
            z = true;
            c625312 = c62531;
            cloudFileRequest2 = cloudFileRequest3;
            i = i2 + 1;
            if (i >= 6) {
                try {
                    try {
                        try {
                        } catch (IOException e) {
                            e = e;
                            th = null;
                            str3 = str;
                        }
                    } catch (CancellationException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw e3;
                    }
                } catch (NetworkIOException unused) {
                    i2 = i;
                    str2 = str2;
                    str = str;
                    c625312 = c625312;
                    z = true;
                } catch (RetryException e4) {
                    e = e4;
                    C62531 c625313 = c625312;
                    str3 = str;
                }
                if (this.canceled) {
                    th = null;
                    str3 = str;
                } else {
                    try {
                    } catch (NetworkIOException unused2) {
                        str3 = str;
                    } catch (RetryException e5) {
                        e = e5;
                        str3 = str;
                    }
                    th = null;
                    str3 = str;
                    if (!progressListener2.onProgress(Boxing.boxLong(cloudFileRequest2.getRequestId()), true, 0L, 0L)) {
                        z2 = false;
                        setCanceled(z2);
                        if (this.canceled) {
                            return th;
                        }
                        final DbxDownloader<FileMetadata> dbxDownloaderDownload = this.service.files().download(str3);
                        if (dbxDownloaderDownload != null) {
                            synchronized (this.downloaders) {
                                this.downloaders.put(cloudFileRequest2, dbxDownloaderDownload);
                            }
                            FileMetadata result = dbxDownloaderDownload.getResult();
                            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.dropbox.core.v2.files.FileMetadata");
                            long size = result.getSize();
                            DropboxDownloader dropboxDownloader = this;
                            FileOutputStream fileOutputStream = new FileOutputStream(str2);
                            try {
                                dbxDownloaderDownload.download(new ProgressOutputStream(size, fileOutputStream, new ProgressOutputStream.ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.api.DropboxDownloader$$ExternalSyntheticLambda0
                                    @Override // com.myscript.nebo.dms.cloud.common.utils.ProgressOutputStream.ProgressListener
                                    public final void progress(long j, long j2) throws IOException {
                                        DropboxDownloader.launchDownload$lambda$0$1$0$0(this.f$0, progressListener2, cloudFileRequest2, dbxDownloaderDownload, j, j2);
                                    }
                                }));
                                CloseableKt.closeFinally(fileOutputStream, th);
                                FileMetadata result2 = dbxDownloaderDownload.getResult();
                                if (result2 == null) {
                                    throw new IllegalStateException();
                                }
                                synchronized (this.downloaders) {
                                    this.downloaders.remove(cloudFileRequest2);
                                }
                                return result2;
                            } finally {
                            }
                        }
                        Function0 function0 = new Function0() { // from class: com.myscript.nebo.dms.dropbox.api.DropboxDownloader$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(this.f$0.canceled);
                            }
                        };
                        c625312.L$0 = cloudFileRequest2;
                        c625312.L$1 = progressListener2;
                        c625312.L$2 = str3;
                        c625312.L$3 = str2;
                        c625312.L$4 = SpillingKt.nullOutSpilledVariable(file);
                        c625312.L$5 = th;
                        c625312.I$0 = i;
                        c625312.label = 2;
                        String str6 = str2;
                        C62531 c625314 = c625312;
                        i5 = i;
                        if (ThreadExt.cancellableDelay$default(((long) i) * 1000, function0, 0L, c625314, 4, null) != coroutine_suspended) {
                            cloudFileRequest3 = cloudFileRequest2;
                            str5 = str6;
                            str = str3;
                            progressListener4 = progressListener2;
                            c62531 = c625314;
                            file4 = file;
                            i2 = i5;
                            file = file4;
                            str2 = str5;
                            progressListener2 = progressListener4;
                            z = true;
                            c625312 = c62531;
                            cloudFileRequest2 = cloudFileRequest3;
                            i = i2 + 1;
                            if (i >= 6) {
                                synchronized (this.downloaders) {
                                    this.downloaders.remove(cloudFileRequest2);
                                }
                                throw new RuntimeException("Maximum attempts at download have been reached (5)");
                            }
                        }
                        return coroutine_suspended;
                    }
                }
                z2 = true;
                setCanceled(z2);
                if (this.canceled) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchDownload$lambda$0$1$0$0(DropboxDownloader dropboxDownloader, ProgressListener progressListener, CloudFileRequest cloudFileRequest, DbxDownloader dbxDownloader, long j, long j2) throws IOException {
        dropboxDownloader.setCanceled(dropboxDownloader.canceled || progressListener.onProgress(Long.valueOf(cloudFileRequest.getRequestId()), false, j, j2));
        if (dropboxDownloader.canceled) {
            dbxDownloader.close();
            throw new IOException("Canceled");
        }
    }

    @Override // com.myscript.nebo.dms.cloud.common.api.Downloader
    public BatchResult download(SWIGVectorCloudFileRequest cloudFileRequests, ProgressListener callback) throws Throwable {
        Intrinsics.checkNotNullParameter(cloudFileRequests, "cloudFileRequests");
        ProgressListener callback2 = callback;
        Intrinsics.checkNotNullParameter(callback2, "callback");
        ArrayList arrayList = new ArrayList();
        for (CloudFileRequest cloudFileRequest : cloudFileRequests) {
            Intrinsics.checkNotNull(cloudFileRequest);
            arrayList.add(cloudFileRequest);
        }
        CopyOnWriteArrayList<CloudFileRequest> copyOnWriteArrayList = new CopyOnWriteArrayList(arrayList);
        BatchResult batchResult = new BatchResult();
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(50);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        int iMax = 50;
        ExecutorCoroutineDispatcher executorCoroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewFixedThreadPool);
        int i = 1;
        while (true) {
            CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
            if (copyOnWriteArrayList2.isEmpty() || i > 5 || this.canceled) {
                break;
            }
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(executorCoroutineDispatcherFrom.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
            try {
                for (CloudFileRequest cloudFileRequest2 : copyOnWriteArrayList) {
                    if (!this.canceled) {
                        CoroutineScope coroutineScope = CoroutineScope;
                        try {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DropboxDownloader$download$2$1(this, cloudFileRequest2, callback2, copyOnWriteArrayList, batchResult, CoroutineScope, null), 3, null);
                            CoroutineScope = coroutineScope;
                        } catch (Throwable th) {
                            th = th;
                            CoroutineScope = coroutineScope;
                            CoroutineScopeKt.cancel$default(CoroutineScope, null, 1, null);
                            throw th;
                        }
                    } else {
                        CoroutineScopeKt.cancel$default(CoroutineScope, null, 1, null);
                    }
                    callback2 = callback;
                }
                CoroutineScopeKt.cancel$default(CoroutineScope, null, 1, null);
                this.downloaders.clear();
                i++;
                iMax = Math.max(1, MathKt.roundToInt((iMax * 2.0f) / 3.0f));
                if (!copyOnWriteArrayList2.isEmpty() && i <= 5 && !this.canceled) {
                    executorCoroutineDispatcherFrom.close();
                    ExecutorService executorServiceNewFixedThreadPool2 = Executors.newFixedThreadPool(iMax);
                    Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool2, "newFixedThreadPool(...)");
                    executorCoroutineDispatcherFrom = ExecutorsKt.from(executorServiceNewFixedThreadPool2);
                    for (long jMin = ((long) i) * 1000; jMin > 0 && !this.canceled; jMin -= Math.min(jMin, 100L)) {
                        Thread.sleep(Math.min(jMin, 100L));
                    }
                }
                callback2 = callback;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        executorCoroutineDispatcherFrom.close();
        setCanceled(false);
        return batchResult;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.api.DropboxDownloader$download$3 */
    /* JADX INFO: compiled from: DropboxDownloader.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.dropbox.api.DropboxDownloader$download$3", m1609f = "DropboxDownloader.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_8_4}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C62523 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $scopeJob;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62523(Job job, Continuation<? super C62523> continuation) {
            super(2, continuation);
            this.$scopeJob = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C62523(this.$scopeJob, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62523) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Sequence<Job> children;
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = this.$scopeJob;
                if (job == null || (children = job.getChildren()) == null || (list = SequencesKt.toList(children)) == null) {
                    return null;
                }
                this.label = 1;
                if (AwaitKt.joinAll(list, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.dms.cloud.common.api.Cancelable
    public void cancel() {
        new Thread(new Runnable() { // from class: com.myscript.nebo.dms.dropbox.api.DropboxDownloader$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                DropboxDownloader.cancel$lambda$0(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancel$lambda$0(DropboxDownloader dropboxDownloader) {
        synchronized (dropboxDownloader.downloaders) {
            Iterator<T> it = dropboxDownloader.downloaders.values().iterator();
            while (it.hasNext()) {
                try {
                    ((DbxDownloader) it.next()).close();
                    dropboxDownloader.setCanceled(true);
                } catch (IllegalStateException e) {
                    Log.e(TAG, e.getMessage(), e);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
