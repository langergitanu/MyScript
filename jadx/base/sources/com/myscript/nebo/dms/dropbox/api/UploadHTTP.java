package com.myscript.nebo.dms.dropbox.api;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.dropbox.core.DbxException;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.files.CommitInfo;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.UploadErrorException;
import com.dropbox.core.p013v2.files.UploadSessionAppendErrorException;
import com.dropbox.core.p013v2.files.UploadSessionAppendV2Uploader;
import com.dropbox.core.p013v2.files.UploadSessionCursor;
import com.dropbox.core.p013v2.files.UploadSessionFinishArg;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchJobStatus;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchLaunch;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchResultEntry;
import com.dropbox.core.p013v2.files.UploadSessionFinishError;
import com.dropbox.core.p013v2.files.UploadSessionFinishErrorException;
import com.dropbox.core.p013v2.files.UploadSessionFinishUploader;
import com.dropbox.core.p013v2.files.UploadSessionStartResult;
import com.dropbox.core.p013v2.files.UploadSessionStartUploader;
import com.dropbox.core.p013v2.files.WriteError;
import com.dropbox.core.p013v2.files.WriteMode;
import com.dropbox.core.util.IOUtil;
import com.myscript.android.utils.ThreadExt;
import com.myscript.nebo.dms.cloud.common.api.ProgressListener;
import com.myscript.nebo.dms.cloud.common.api.Uploader;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: UploadHTTP.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0!2\u0006\u0010$\u001a\u00020\u001eJ:\u0010%\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0!2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0(2\u0006\u0010$\u001a\u00020\u001eH\u0002JF\u0010*\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00180,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001c0.2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0(H\u0002J \u0010/\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001eH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000103H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/UploadHTTP;", "", "<init>", "()V", "TAG", "", "DBG", "", "CHUNKED_ATTEMPTS_COUNT", "", "CHUNKED_ATTEMPTS_TEMPO", "", "WAIT_FOR_COMPLETE_INTERVAL", "CHUNKED_UPLOAD_SIZE", "SESSION_UPLOAD_SIZE_LIMIT", "NB_FILE_LIMIT_FROM_WHICH_USE_SESSIONS", "SIZE_LIMIT_FROM_WHICH_USE_SESSIONS", "MAX_PARALLEL_SESSIONS", "MAX_UPLOAD_ITEMS_BY_COMMIT_BATCH", "MAX_UPLOAD_TRY", "lastError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "launchUpload", "Lcom/dropbox/core/v2/files/UploadSessionFinishArg;", NotificationCompat.CATEGORY_SERVICE, "Lcom/dropbox/core/v2/DbxClientV2;", "uploadItem", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadItem;", "progressListener", "Lcom/myscript/nebo/dms/cloud/common/api/ProgressListener;", "(Lcom/dropbox/core/v2/DbxClientV2;Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadItem;Lcom/myscript/nebo/dms/cloud/common/api/ProgressListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFiles", "", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadResult;", "uploadItems", "callback", "uploadFilesBatchCommit", "", "uploadResults", "", "Ljava/util/UUID;", "commitSessions", "sessionEntries", "", "currentList", "", "uploadFile", "completeFileInfo", "hasInsufficientStorage", "writeError", "Lcom/dropbox/core/v2/files/WriteError;", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UploadHTTP {
    private static final int CHUNKED_ATTEMPTS_COUNT = 5;
    private static final long CHUNKED_ATTEMPTS_TEMPO = 1000;
    private static final long CHUNKED_UPLOAD_SIZE = 8388608;
    private static final boolean DBG = false;
    public static final UploadHTTP INSTANCE = new UploadHTTP();
    private static final int MAX_PARALLEL_SESSIONS = 25;
    private static final int MAX_UPLOAD_ITEMS_BY_COMMIT_BATCH = 500;
    private static final int MAX_UPLOAD_TRY = 5;
    private static final int NB_FILE_LIMIT_FROM_WHICH_USE_SESSIONS = 5;
    private static final long SESSION_UPLOAD_SIZE_LIMIT = 156237824;
    private static final long SIZE_LIMIT_FROM_WHICH_USE_SESSIONS = 8388608;
    private static final String TAG = "UploadHTTP";
    private static final long WAIT_FOR_COMPLETE_INTERVAL = 50;
    private static Exception lastError;

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.api.UploadHTTP$launchUpload$1 */
    /* JADX INFO: compiled from: UploadHTTP.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.dropbox.api.UploadHTTP", m1609f = "UploadHTTP.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {TsExtractor.TS_STREAM_TYPE_DTS_HD, PDFACompliance.e_PDFA1_8_6}, m1612m = "launchUpload", m1613n = {NotificationCompat.CATEGORY_SERVICE, "uploadItem", "progressListener", "uploaded", "sessionId", "uploadSessionStart", "ex", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "canceled", NotificationCompat.CATEGORY_SERVICE, "uploadItem", "progressListener", "uploaded", "sessionId", "uploadSessionStart", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "canceled"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DTS_UHD, 58}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "Z$0"}, m1616v = 2)
    static final class C62541 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C62541(Continuation<? super C62541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadHTTP.this.launchUpload(null, null, null, this);
        }
    }

    private UploadHTTP() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02bd, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.getMessage(), (java.lang.Object) r20) == false) goto L94;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0316  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v20, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22, types: [T] */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r17v0, types: [long] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v14 */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v41, types: [T, com.dropbox.core.v2.files.UploadSessionStartUploader] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2, types: [com.myscript.nebo.dms.cloud.common.api.ProgressListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x03c1 -> B:123:0x0426). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0316 -> B:98:0x031d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object launchUpload(DbxClientV2 dbxClientV2, Uploader.UploadItem uploadItem, ProgressListener progressListener, Continuation<? super UploadSessionFinishArg> continuation) {
        C62541 c62541;
        Ref.LongRef longRef;
        C62541 c625412;
        ?? objectRef;
        int i;
        Ref.ObjectRef objectRef2;
        DbxClientV2 dbxClientV22;
        final Uploader.UploadItem uploadItem2;
        final ?? r9;
        DbxClientV2 dbxClientV23;
        Object obj;
        int i2;
        char c;
        boolean z;
        String str;
        ?? r12;
        Object obj2;
        int i3;
        DbxClientV2 dbxClientV24;
        ?? r13;
        ?? r17;
        Function0 function0;
        long backoffMillis;
        Function0 function02;
        Throwable th;
        String str2 = "Error uploading to Dropbox: ";
        if (continuation instanceof C62541) {
            c62541 = (C62541) continuation;
            if ((c62541.label & Integer.MIN_VALUE) != 0) {
                c62541.label -= Integer.MIN_VALUE;
            } else {
                c62541 = new C62541(continuation);
            }
        }
        Object obj3 = c62541.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c62541.label;
        boolean z2 = true;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            longRef = new Ref.LongRef();
            c625412 = c62541;
            objectRef = new Ref.ObjectRef();
            i = 1;
            objectRef2 = new Ref.ObjectRef();
            dbxClientV22 = dbxClientV2;
            uploadItem2 = uploadItem;
            r9 = progressListener;
            if (i < 6) {
            }
        } else {
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z3 = c62541.Z$0;
                int i5 = c62541.I$0;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) c62541.L$5;
                Ref.ObjectRef objectRef4 = (Ref.ObjectRef) c62541.L$4;
                Ref.LongRef longRef2 = (Ref.LongRef) c62541.L$3;
                ProgressListener progressListener2 = (ProgressListener) c62541.L$2;
                Uploader.UploadItem uploadItem3 = (Uploader.UploadItem) c62541.L$1;
                DbxClientV2 dbxClientV25 = (DbxClientV2) c62541.L$0;
                ResultKt.throwOnFailure(obj3);
                Object obj4 = coroutine_suspended;
                ?? r5 = objectRef4;
                c = 2;
                boolean z4 = true;
                ?? r122 = progressListener2;
                z = z4;
                str = str2;
                c625412 = c62541;
                obj2 = obj4;
                dbxClientV22 = dbxClientV25;
                i3 = i5;
                uploadItem2 = uploadItem3;
                longRef = longRef2;
                objectRef2 = objectRef3;
                r9 = r122;
                r12 = r5;
                i = i3 + 1;
                coroutine_suspended = obj2;
                z2 = z;
                str2 = str;
                r9 = r9;
                objectRef = r12;
                if (i < 6) {
                    return null;
                }
                int i6 = i;
                Long l = uploadItem2.requestId;
                Long size = uploadItem2.size;
                z4 = z2;
                Intrinsics.checkNotNullExpressionValue(size, "size");
                ?? LongValue = size.longValue();
                final Ref.ObjectRef objectRef5 = objectRef2;
                ?? r20 = objectRef;
                Ref.LongRef longRef3 = longRef;
                DbxClientV2 dbxClientV26 = dbxClientV22;
                C62541 c625413 = c625412;
                Object obj5 = coroutine_suspended;
                ?? r52 = r20;
                boolean zOnProgress = r9.onProgress(l, true, 0L, LongValue);
                if (zOnProgress) {
                    lastError = new IOException("Canceled");
                    return null;
                }
                try {
                    try {
                        try {
                        } catch (RetryException e) {
                            e = e;
                            dbxClientV24 = dbxClientV26;
                            r13 = zOnProgress;
                        }
                    } catch (UploadErrorException e2) {
                        e = e2;
                        LongValue = zOnProgress;
                    } catch (DbxException e3) {
                        e = e3;
                        LongValue = zOnProgress;
                    } catch (IOException e4) {
                        e = e4;
                        LongValue = zOnProgress;
                        r20 = "Canceled";
                    }
                } catch (NetworkIOException unused) {
                    dbxClientV23 = dbxClientV26;
                    obj = obj5;
                    i2 = i6;
                    c625412 = c625413;
                    c = 2;
                    z = z4 ? 1 : 0;
                    str = str2;
                    longRef = longRef3;
                    objectRef2 = objectRef5;
                    r12 = r52;
                    dbxClientV22 = dbxClientV23;
                    obj2 = obj;
                    i3 = i2;
                    i = i3 + 1;
                    coroutine_suspended = obj2;
                    z2 = z;
                    str2 = str;
                    r9 = r9;
                    objectRef = r12;
                    if (i < 6) {
                    }
                } catch (UploadSessionAppendErrorException e5) {
                    dbxClientV23 = dbxClientV26;
                    obj = obj5;
                    i2 = i6;
                    c625412 = c625413;
                    c = 2;
                    if (!e5.errorValue.isIncorrectOffset()) {
                        Log.e(TAG, str2 + e5.getMessage(), e5);
                        lastError = e5;
                        return null;
                    }
                    longRef3.element = e5.errorValue.getIncorrectOffsetValue().getCorrectOffset();
                    z = z4 ? 1 : 0;
                    str = str2;
                    longRef = longRef3;
                    objectRef2 = objectRef5;
                    r12 = r52;
                    dbxClientV22 = dbxClientV23;
                    obj2 = obj;
                    i3 = i2;
                    i = i3 + 1;
                    coroutine_suspended = obj2;
                    z2 = z;
                    str2 = str;
                    r9 = r9;
                    objectRef = r12;
                    if (i < 6) {
                    }
                } catch (UploadSessionFinishErrorException e6) {
                    dbxClientV23 = dbxClientV26;
                    obj = obj5;
                    i2 = i6;
                    c625412 = c625413;
                    c = 2;
                    if (!e6.errorValue.isLookupFailed() || !e6.errorValue.getLookupFailedValue().isIncorrectOffset()) {
                        Log.e(TAG, str2 + e6.getMessage(), e6);
                        lastError = e6;
                        return null;
                    }
                    longRef3.element = e6.errorValue.getLookupFailedValue().getIncorrectOffsetValue().getCorrectOffset();
                    z = z4 ? 1 : 0;
                    str = str2;
                    longRef = longRef3;
                    objectRef2 = objectRef5;
                    r12 = r52;
                    dbxClientV22 = dbxClientV23;
                    obj2 = obj;
                    i3 = i2;
                    i = i3 + 1;
                    coroutine_suspended = obj2;
                    z2 = z;
                    str2 = str;
                    r9 = r9;
                    objectRef = r12;
                    if (i < 6) {
                    }
                } catch (OutOfMemoryError e7) {
                    Log.e(TAG, str2, e7);
                    return null;
                } catch (CancellationException e8) {
                    throw e8;
                }
                try {
                    try {
                    } catch (RetryException e9) {
                        e = e9;
                        LongValue = zOnProgress;
                        dbxClientV24 = dbxClientV26;
                        r13 = LongValue;
                        c = 2;
                        backoffMillis = e.getBackoffMillis();
                        function02 = new Function0() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(UploadHTTP.launchUpload$lambda$1(r9, uploadItem2));
                            }
                        };
                        c625413.L$0 = dbxClientV24;
                        c625413.L$1 = uploadItem2;
                        c625413.L$2 = r9;
                        c625413.L$3 = longRef3;
                        c625413.L$4 = r52;
                        c625413.L$5 = objectRef5;
                        c625413.L$6 = SpillingKt.nullOutSpilledVariable(e);
                        c625413.I$0 = i6;
                        c625413.Z$0 = r13;
                        c625413.label = z4 ? 1 : 0;
                        z = z4 ? 1 : 0;
                        str = str2;
                        obj2 = obj5;
                        if (ThreadExt.cancellableDelay$default(backoffMillis, function02, 0L, c625413, 4, null) == obj2) {
                        }
                    }
                } catch (RetryException e10) {
                    e = e10;
                    dbxClientV24 = dbxClientV26;
                    r13 = LongValue;
                    c = 2;
                    backoffMillis = e.getBackoffMillis();
                    function02 = new Function0() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(UploadHTTP.launchUpload$lambda$1(r9, uploadItem2));
                        }
                    };
                    c625413.L$0 = dbxClientV24;
                    c625413.L$1 = uploadItem2;
                    c625413.L$2 = r9;
                    c625413.L$3 = longRef3;
                    c625413.L$4 = r52;
                    c625413.L$5 = objectRef5;
                    c625413.L$6 = SpillingKt.nullOutSpilledVariable(e);
                    c625413.I$0 = i6;
                    c625413.Z$0 = r13;
                    c625413.label = z4 ? 1 : 0;
                    z = z4 ? 1 : 0;
                    str = str2;
                    obj2 = obj5;
                    if (ThreadExt.cancellableDelay$default(backoffMillis, function02, 0L, c625413, 4, null) == obj2) {
                    }
                } catch (UploadErrorException e11) {
                    e = e11;
                    Log.e(TAG, str2, e);
                    lastError = e;
                    r17 = LongValue;
                    function0 = new Function0() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(UploadHTTP.launchUpload$lambda$2(r9, uploadItem2));
                        }
                    };
                    c625413.L$0 = dbxClientV26;
                    c625413.L$1 = uploadItem2;
                    c625413.L$2 = r9;
                    c625413.L$3 = longRef3;
                    c625413.L$4 = r52;
                    c625413.L$5 = objectRef5;
                    c625413.L$6 = null;
                    c625413.I$0 = i6;
                    c625413.Z$0 = r17;
                    c625413.label = 2;
                    c = 2;
                    obj4 = obj5;
                    if (ThreadExt.cancellableDelay$default(((long) i6) * 1000, function0, 0L, c625413, 4, null) != obj4) {
                        return obj4;
                    }
                    longRef2 = longRef3;
                    uploadItem3 = uploadItem2;
                    dbxClientV25 = dbxClientV26;
                    i5 = i6;
                    r122 = r9;
                    c62541 = c625413;
                    objectRef3 = objectRef5;
                    r5 = r52;
                    z = z4;
                    str = str2;
                    c625412 = c62541;
                    obj2 = obj4;
                    dbxClientV22 = dbxClientV25;
                    i3 = i5;
                    uploadItem2 = uploadItem3;
                    longRef = longRef2;
                    objectRef2 = objectRef3;
                    r9 = r122;
                    r12 = r5;
                    i = i3 + 1;
                    coroutine_suspended = obj2;
                    z2 = z;
                    str2 = str;
                    r9 = r9;
                    objectRef = r12;
                    if (i < 6) {
                    }
                } catch (DbxException e12) {
                    e = e12;
                    Log.e(TAG, str2, e);
                    lastError = e;
                    r17 = LongValue;
                    function0 = new Function0() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(UploadHTTP.launchUpload$lambda$2(r9, uploadItem2));
                        }
                    };
                    c625413.L$0 = dbxClientV26;
                    c625413.L$1 = uploadItem2;
                    c625413.L$2 = r9;
                    c625413.L$3 = longRef3;
                    c625413.L$4 = r52;
                    c625413.L$5 = objectRef5;
                    c625413.L$6 = null;
                    c625413.I$0 = i6;
                    c625413.Z$0 = r17;
                    c625413.label = 2;
                    c = 2;
                    obj4 = obj5;
                    if (ThreadExt.cancellableDelay$default(((long) i6) * 1000, function0, 0L, c625413, 4, null) != obj4) {
                    }
                } catch (IOException e13) {
                    e = e13;
                    Log.e(TAG, "Error reading from file \"" + uploadItem2.notebookTempUploadPath + "\": ", e);
                    lastError = e;
                    r17 = LongValue;
                }
                File file = new File(uploadItem2.notebookTempUploadPath);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    FileInputStream fileInputStream2 = fileInputStream;
                    if (uploadItem2.size.longValue() > SESSION_UPLOAD_SIZE_LIMIT) {
                        if (r52.element == null) {
                            objectRef5.element = dbxClientV26.files().uploadSessionStart();
                            UploadSessionStartUploader uploadSessionStartUploader = (UploadSessionStartUploader) objectRef5.element;
                            if (uploadSessionStartUploader != null) {
                                try {
                                    UploadSessionStartResult uploadSessionStartResultUploadAndFinish = uploadSessionStartUploader.uploadAndFinish(fileInputStream2, 8388608L, new IOUtil.ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda1
                                        @Override // com.dropbox.core.util.IOUtil.ProgressListener
                                        public final void onProgress(long j) throws IOException {
                                            UploadHTTP.launchUpload$lambda$0$1(r9, uploadItem2, objectRef5, j);
                                        }
                                    });
                                    ?? sessionId = uploadSessionStartResultUploadAndFinish != null ? uploadSessionStartResultUploadAndFinish.getSessionId() : 0;
                                    r52.element = sessionId;
                                    longRef3.element += 8388608;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            r52.element = sessionId;
                            longRef3.element += 8388608;
                        }
                        if (r52.element == null) {
                            throw new IllegalStateException("Chunked uploadAndFinish return a null sessionId");
                        }
                        UploadSessionCursor uploadSessionCursor = new UploadSessionCursor((String) r52.element, longRef3.element);
                        while (uploadItem2.size.longValue() - longRef3.element > 8388608) {
                            final UploadSessionAppendV2Uploader uploadSessionAppendV2UploaderUploadSessionAppendV2 = dbxClientV26.files().uploadSessionAppendV2(uploadSessionCursor);
                            uploadSessionAppendV2UploaderUploadSessionAppendV2.uploadAndFinish(fileInputStream2, 8388608L, new IOUtil.ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda2
                                @Override // com.dropbox.core.util.IOUtil.ProgressListener
                                public final void onProgress(long j) throws IOException {
                                    UploadHTTP.launchUpload$lambda$0$2(r9, uploadItem2, uploadSessionAppendV2UploaderUploadSessionAppendV2, j);
                                }
                            });
                            longRef3.element += 8388608;
                            uploadSessionCursor = new UploadSessionCursor((String) r52.element, longRef3.element);
                        }
                        CommitInfo commitInfoBuild = CommitInfo.newBuilder(uploadItem2.notebookCloudPath).withMode(WriteMode.OVERWRITE).withClientModified(new Date(file.lastModified())).build();
                        final UploadSessionFinishUploader uploadSessionFinishUploaderUploadSessionFinish = dbxClientV26.files().uploadSessionFinish(uploadSessionCursor, commitInfoBuild);
                        uploadSessionFinishUploaderUploadSessionFinish.uploadAndFinish(fileInputStream2, 8388608L, new IOUtil.ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda3
                            @Override // com.dropbox.core.util.IOUtil.ProgressListener
                            public final void onProgress(long j) throws IOException {
                                UploadHTTP.launchUpload$lambda$0$3(r9, uploadItem2, uploadSessionFinishUploaderUploadSessionFinish, j);
                            }
                        });
                        String str3 = (String) r52.element;
                        Long size2 = uploadItem2.size;
                        Intrinsics.checkNotNullExpressionValue(size2, "size");
                        UploadSessionFinishArg uploadSessionFinishArg = new UploadSessionFinishArg(new UploadSessionCursor(str3, size2.longValue()), commitInfoBuild);
                        CloseableKt.closeFinally(fileInputStream, null);
                        return uploadSessionFinishArg;
                    }
                    try {
                        final UploadSessionStartUploader uploadSessionStartUploaderStart = dbxClientV26.files().uploadSessionStartBuilder().withClose(Boxing.boxBoolean(z4)).start();
                        r52.element = uploadSessionStartUploaderStart.uploadAndFinish(fileInputStream2, new IOUtil.ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda0
                            @Override // com.dropbox.core.util.IOUtil.ProgressListener
                            public final void onProgress(long j) throws IOException {
                                UploadHTTP.launchUpload$lambda$0$0(r9, uploadItem2, uploadSessionStartUploaderStart, j);
                            }
                        }).getSessionId();
                        String str4 = (String) r52.element;
                        Long size3 = uploadItem2.size;
                        Intrinsics.checkNotNullExpressionValue(size3, "size");
                        UploadSessionFinishArg uploadSessionFinishArg2 = new UploadSessionFinishArg(new UploadSessionCursor(str4, size3.longValue()), CommitInfo.newBuilder(uploadItem2.notebookCloudPath).withMode(WriteMode.OVERWRITE).withClientModified(new Date(file.lastModified())).build());
                        try {
                        } catch (RetryException e14) {
                            e = e14;
                            dbxClientV24 = dbxClientV26;
                            r13 = zOnProgress;
                            c = 2;
                            backoffMillis = e.getBackoffMillis();
                            function02 = new Function0() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Boolean.valueOf(UploadHTTP.launchUpload$lambda$1(r9, uploadItem2));
                                }
                            };
                            c625413.L$0 = dbxClientV24;
                            c625413.L$1 = uploadItem2;
                            c625413.L$2 = r9;
                            c625413.L$3 = longRef3;
                            c625413.L$4 = r52;
                            c625413.L$5 = objectRef5;
                            c625413.L$6 = SpillingKt.nullOutSpilledVariable(e);
                            c625413.I$0 = i6;
                            c625413.Z$0 = r13;
                            c625413.label = z4 ? 1 : 0;
                            z = z4 ? 1 : 0;
                            str = str2;
                            obj2 = obj5;
                            if (ThreadExt.cancellableDelay$default(backoffMillis, function02, 0L, c625413, 4, null) == obj2) {
                                return obj2;
                            }
                            i3 = i6;
                            uploadItem2 = uploadItem2;
                            longRef = longRef3;
                            objectRef2 = objectRef5;
                            r9 = r9;
                            r12 = r52;
                            c625412 = c625413;
                            dbxClientV22 = dbxClientV24;
                            i = i3 + 1;
                            coroutine_suspended = obj2;
                            z2 = z;
                            str2 = str;
                            r9 = r9;
                            objectRef = r12;
                            if (i < 6) {
                            }
                        }
                        CloseableKt.closeFinally(fileInputStream, null);
                        return uploadSessionFinishArg2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                th = th;
                try {
                    throw th;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th5;
                }
            }
            boolean z5 = c62541.Z$0;
            int i7 = c62541.I$0;
            Ref.ObjectRef objectRef6 = (Ref.ObjectRef) c62541.L$5;
            Ref.ObjectRef objectRef7 = (Ref.ObjectRef) c62541.L$4;
            Ref.LongRef longRef4 = (Ref.LongRef) c62541.L$3;
            ProgressListener progressListener3 = (ProgressListener) c62541.L$2;
            Uploader.UploadItem uploadItem4 = (Uploader.UploadItem) c62541.L$1;
            DbxClientV2 dbxClientV27 = (DbxClientV2) c62541.L$0;
            ResultKt.throwOnFailure(obj3);
            str = "Error uploading to Dropbox: ";
            obj2 = coroutine_suspended;
            c = 2;
            z = true;
            i3 = i7;
            uploadItem2 = uploadItem4;
            longRef = longRef4;
            objectRef2 = objectRef6;
            r9 = progressListener3;
            r12 = objectRef7;
            c625412 = c62541;
            dbxClientV22 = dbxClientV27;
            i = i3 + 1;
            coroutine_suspended = obj2;
            z2 = z;
            str2 = str;
            r9 = r9;
            objectRef = r12;
            if (i < 6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchUpload$lambda$0$0(ProgressListener progressListener, Uploader.UploadItem uploadItem, UploadSessionStartUploader uploadSessionStartUploader, long j) throws IOException {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        if (progressListener.onProgress(l, true, j, size.longValue())) {
            uploadSessionStartUploader.abort();
            throw new IOException("Canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void launchUpload$lambda$0$1(ProgressListener progressListener, Uploader.UploadItem uploadItem, Ref.ObjectRef objectRef, long j) throws IOException {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        if (progressListener.onProgress(l, true, j, size.longValue())) {
            ((UploadSessionStartUploader) objectRef.element).abort();
            throw new IOException("Canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchUpload$lambda$0$2(ProgressListener progressListener, Uploader.UploadItem uploadItem, UploadSessionAppendV2Uploader uploadSessionAppendV2Uploader, long j) throws IOException {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        progressListener.onProgress(l, true, j, size.longValue());
        if (uploadSessionAppendV2Uploader != null) {
            uploadSessionAppendV2Uploader.abort();
        }
        throw new IOException("Canceled");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchUpload$lambda$0$3(ProgressListener progressListener, Uploader.UploadItem uploadItem, UploadSessionFinishUploader uploadSessionFinishUploader, long j) throws IOException {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        if (progressListener.onProgress(l, true, j, size.longValue())) {
            uploadSessionFinishUploader.abort();
            throw new IOException("Canceled");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean launchUpload$lambda$1(ProgressListener progressListener, Uploader.UploadItem uploadItem) {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        return progressListener.onProgress(l, true, 0L, size.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean launchUpload$lambda$2(ProgressListener progressListener, Uploader.UploadItem uploadItem) {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        return progressListener.onProgress(l, true, 0L, size.longValue());
    }

    public final List<Uploader.UploadResult> uploadFiles(DbxClientV2 service, List<? extends Uploader.UploadItem> uploadItems, ProgressListener callback) throws Exception {
        long jLongValue;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(uploadItems, "uploadItems");
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<? extends Uploader.UploadItem> list = uploadItems;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            INSTANCE.completeFileInfo((Uploader.UploadItem) it.next());
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Uploader.UploadItem uploadItem = (Uploader.UploadItem) it2.next();
            Long requestId = uploadItem.requestId;
            Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
            long jLongValue2 = requestId.longValue();
            String str = uploadItem.fileId;
            String str2 = uploadItem.notebookCloudPath;
            String str3 = uploadItem.notebookTempUploadPath;
            Long l = uploadItem.size;
            Uploader.UploadResult uploadResult = new Uploader.UploadResult(jLongValue2, str, str2, "", str3, l != null ? l.longValue() : 0L);
            if (!new File(uploadItem.notebookTempUploadPath).exists()) {
                uploadResult.lastError = new NoSuchElementException(uploadItem.notebookName + " not found locally");
            } else {
                arrayList.add(uploadItem);
            }
            UUID uuid = uploadItem.uuid;
            Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
            linkedHashMap.put(uuid, uploadResult);
        }
        ArrayList<Uploader.UploadItem> arrayList2 = arrayList;
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Long size = ((Uploader.UploadItem) it3.next()).size;
            Intrinsics.checkNotNullExpressionValue(size, "size");
            jLongValue += size.longValue();
        }
        if (arrayList.size() < 5 && jLongValue < 8388608) {
            for (Uploader.UploadItem uploadItem2 : arrayList2) {
                UUID uuid2 = uploadItem2.uuid;
                Intrinsics.checkNotNullExpressionValue(uuid2, "uuid");
                linkedHashMap.put(uuid2, INSTANCE.uploadFile(service, uploadItem2, callback));
            }
            return CollectionsKt.toList(linkedHashMap.values());
        }
        Iterator it4 = CollectionsKt.chunked(arrayList2, 500).iterator();
        while (it4.hasNext()) {
            INSTANCE.uploadFilesBatchCommit(service, (List) it4.next(), linkedHashMap, callback);
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.ExecutorCoroutineDispatcher] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, kotlinx.coroutines.ExecutorCoroutineDispatcher] */
    private final void uploadFilesBatchCommit(DbxClientV2 service, List<? extends Uploader.UploadItem> uploadItems, Map<UUID, Uploader.UploadResult> uploadResults, ProgressListener callback) throws Exception {
        lastError = null;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Uploader.UploadItem> mutableList = CollectionsKt.toMutableList((Collection) uploadItems);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        int iMax = 25;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(25);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        objectRef.element = ExecutorsKt.from(executorServiceNewFixedThreadPool);
        int i = 1;
        while (true) {
            List<Uploader.UploadItem> list = mutableList;
            if (list.isEmpty() || i > 5) {
                break;
            }
            BuildersKt__BuildersKt.runBlocking$default(null, new C62551(mutableList, callback, uploadResults, objectRef, service, linkedHashMap, null), 1, null);
            if (!linkedHashMap.isEmpty()) {
                commitSessions(service, linkedHashMap, mutableList, uploadResults);
            }
            linkedHashMap.clear();
            i++;
            iMax = Math.max(1, MathKt.roundToInt((iMax * 2.0f) / 3.0f));
            if (!list.isEmpty() && i <= 5) {
                ExecutorService executorServiceNewFixedThreadPool2 = Executors.newFixedThreadPool(iMax);
                Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool2, "newFixedThreadPool(...)");
                objectRef.element = ExecutorsKt.from(executorServiceNewFixedThreadPool2);
                Thread.sleep(((long) i) * 1000);
            }
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.api.UploadHTTP$uploadFilesBatchCommit$1 */
    /* JADX INFO: compiled from: UploadHTTP.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.dropbox.api.UploadHTTP$uploadFilesBatchCommit$1", m1609f = "UploadHTTP.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProgressListener $callback;
        final /* synthetic */ List<Uploader.UploadItem> $currentList;
        final /* synthetic */ DbxClientV2 $service;
        final /* synthetic */ Map<Uploader.UploadItem, UploadSessionFinishArg> $sessionEntries;
        final /* synthetic */ Ref.ObjectRef<ExecutorCoroutineDispatcher> $upDispatcher;
        final /* synthetic */ Map<UUID, Uploader.UploadResult> $uploadResults;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62551(List<Uploader.UploadItem> list, ProgressListener progressListener, Map<UUID, Uploader.UploadResult> map, Ref.ObjectRef<ExecutorCoroutineDispatcher> objectRef, DbxClientV2 dbxClientV2, Map<Uploader.UploadItem, UploadSessionFinishArg> map2, Continuation<? super C62551> continuation) {
            super(2, continuation);
            this.$currentList = list;
            this.$callback = progressListener;
            this.$uploadResults = map;
            this.$upDispatcher = objectRef;
            this.$service = dbxClientV2;
            this.$sessionEntries = map2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62551 c62551 = new C62551(this.$currentList, this.$callback, this.$uploadResults, this.$upDispatcher, this.$service, this.$sessionEntries, continuation);
            c62551.L$0 = obj;
            return c62551;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Iterator<Uploader.UploadItem> it = this.$currentList.iterator();
            while (it.hasNext()) {
                Uploader.UploadItem next = it.next();
                ProgressListener progressListener = this.$callback;
                Long l = next.requestId;
                Long size = next.size;
                Intrinsics.checkNotNullExpressionValue(size, "size");
                if (!progressListener.onProgress(l, true, 0L, size.longValue())) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, this.$upDispatcher.element, null, new AnonymousClass2(this.$service, next, this.$callback, this.$sessionEntries, this.$uploadResults, it, null), 2, null);
                } else {
                    Map<UUID, Uploader.UploadResult> map = this.$uploadResults;
                    UUID uuid = next.uuid;
                    Long requestId = next.requestId;
                    Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
                    Uploader.UploadResult uploadResult = new Uploader.UploadResult(requestId.longValue(), next.fileId, next.notebookCloudPath, "", next.notebookTempUploadPath, 0L);
                    uploadResult.lastError = new IOException("Canceled");
                    map.put(uuid, uploadResult);
                    it.remove();
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.api.UploadHTTP$uploadFilesBatchCommit$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: UploadHTTP.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.dms.dropbox.api.UploadHTTP$uploadFilesBatchCommit$1$2", m1609f = "UploadHTTP.kt", m1610i = {}, m1611l = {257}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {258}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProgressListener $callback;
            final /* synthetic */ DbxClientV2 $service;
            final /* synthetic */ Map<Uploader.UploadItem, UploadSessionFinishArg> $sessionEntries;
            final /* synthetic */ Uploader.UploadItem $uploadItem;
            final /* synthetic */ Iterator<Uploader.UploadItem> $uploadItemIterator;
            final /* synthetic */ Map<UUID, Uploader.UploadResult> $uploadResults;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(DbxClientV2 dbxClientV2, Uploader.UploadItem uploadItem, ProgressListener progressListener, Map<Uploader.UploadItem, UploadSessionFinishArg> map, Map<UUID, Uploader.UploadResult> map2, Iterator<? extends Uploader.UploadItem> it, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$service = dbxClientV2;
                this.$uploadItem = uploadItem;
                this.$callback = progressListener;
                this.$sessionEntries = map;
                this.$uploadResults = map2;
                this.$uploadItemIterator = it;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$service, this.$uploadItem, this.$callback, this.$sessionEntries, this.$uploadResults, this.$uploadItemIterator, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = UploadHTTP.INSTANCE.launchUpload(this.$service, this.$uploadItem, this.$callback, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                UploadSessionFinishArg uploadSessionFinishArg = (UploadSessionFinishArg) obj;
                if (uploadSessionFinishArg != null) {
                    Map<Uploader.UploadItem, UploadSessionFinishArg> map = this.$sessionEntries;
                    Map<UUID, Uploader.UploadResult> map2 = this.$uploadResults;
                    Uploader.UploadItem uploadItem = this.$uploadItem;
                    Iterator<Uploader.UploadItem> it = this.$uploadItemIterator;
                    synchronized (map) {
                        if (UploadHTTP.lastError instanceof IOException) {
                            Exception exc = UploadHTTP.lastError;
                            if (Intrinsics.areEqual(exc != null ? exc.getMessage() : null, "Canceled")) {
                                UUID uuid = uploadItem.uuid;
                                Long requestId = uploadItem.requestId;
                                Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
                                Uploader.UploadResult uploadResult = new Uploader.UploadResult(requestId.longValue(), uploadItem.fileId, uploadItem.notebookCloudPath, "", uploadItem.notebookTempUploadPath, 0L);
                                uploadResult.lastError = new IOException("Canceled");
                                map2.put(uuid, uploadResult);
                                it.remove();
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        map.put(uploadItem, uploadSessionFinishArg);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void commitSessions(DbxClientV2 service, Map<Uploader.UploadItem, ? extends UploadSessionFinishArg> sessionEntries, List<Uploader.UploadItem> currentList, Map<UUID, Uploader.UploadResult> uploadResults) throws Exception {
        UploadSessionFinishBatchJobStatus uploadSessionFinishBatchJobStatusUploadSessionFinishBatchCheck;
        FileMetadata successValue;
        boolean z;
        Set<Map.Entry<Uploader.UploadItem, ? extends UploadSessionFinishArg>> setEntrySet = sessionEntries.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            arrayList.add((Uploader.UploadItem) ((Map.Entry) it.next()).getKey());
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it2 = setEntrySet.iterator();
        while (it2.hasNext()) {
            arrayList3.add((UploadSessionFinishArg) ((Map.Entry) it2.next()).getValue());
        }
        UploadSessionFinishBatchLaunch uploadSessionFinishBatchLaunchUploadSessionFinishBatch = service.files().uploadSessionFinishBatch(arrayList3);
        while (true) {
            try {
                uploadSessionFinishBatchJobStatusUploadSessionFinishBatchCheck = service.files().uploadSessionFinishBatchCheck(uploadSessionFinishBatchLaunchUploadSessionFinishBatch.getAsyncJobIdValue());
                if (uploadSessionFinishBatchJobStatusUploadSessionFinishBatchCheck.isComplete()) {
                    break;
                } else {
                    Thread.sleep(WAIT_FOR_COMPLETE_INTERVAL);
                }
            } catch (RetryException e) {
                Log.i(TAG, "Server is not responding, retry failed: " + e.getMessage());
                throw e;
            } catch (Exception e2) {
                Log.e(TAG, "Error uploading to Dropbox: ", e2);
                throw e2;
            }
        }
        List<UploadSessionFinishBatchResultEntry> entries = uploadSessionFinishBatchJobStatusUploadSessionFinishBatchCheck.getCompleteValue().getEntries();
        if (entries != null) {
            int i = 0;
            for (Object obj : entries) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                UploadSessionFinishBatchResultEntry uploadSessionFinishBatchResultEntry = (UploadSessionFinishBatchResultEntry) obj;
                Uploader.UploadItem uploadItem = (Uploader.UploadItem) arrayList2.get(i);
                if (uploadSessionFinishBatchResultEntry.isSuccess()) {
                    currentList.remove(uploadItem);
                    successValue = uploadSessionFinishBatchResultEntry.getSuccessValue();
                } else {
                    successValue = null;
                }
                if (uploadSessionFinishBatchResultEntry.isFailure()) {
                    UploadHTTP uploadHTTP = INSTANCE;
                    UploadSessionFinishError failureValue = uploadSessionFinishBatchResultEntry.getFailureValue();
                    z = uploadHTTP.hasInsufficientStorage(failureValue != null ? failureValue.getPathValue() : null);
                }
                UUID uuid = uploadItem.uuid;
                String contentHash = null;
                Long requestId = uploadItem.requestId;
                Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
                long jLongValue = requestId.longValue();
                String id = successValue != null ? successValue.getId() : null;
                String pathDisplay = successValue != null ? successValue.getPathDisplay() : null;
                String rev = successValue != null ? successValue.getRev() : null;
                String str = uploadItem.notebookTempUploadPath;
                if (successValue != null) {
                    contentHash = successValue.getContentHash();
                }
                uploadResults.put(uuid, new Uploader.UploadResult(jLongValue, id, pathDisplay, rev, str, contentHash, uploadSessionFinishBatchResultEntry.isSuccess(), z, lastError, successValue, 0L));
                i = i2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Uploader.UploadResult uploadFile(DbxClientV2 service, final Uploader.UploadItem uploadItem, final ProgressListener callback) {
        int i;
        String str;
        FileMetadata fileMetadata;
        boolean z;
        FileMetadata fileMetadataUploadAndFinish;
        Throwable th;
        Long requestId = uploadItem.requestId;
        Intrinsics.checkNotNullExpressionValue(requestId, "requestId");
        Uploader.UploadResult uploadResult = new Uploader.UploadResult(requestId.longValue(), uploadItem.fileId, uploadItem.notebookCloudPath, "", uploadItem.notebookTempUploadPath, "", false, false, lastError, null, 0L);
        if (!completeFileInfo(uploadItem)) {
            uploadResult.lastError = new NoSuchElementException(uploadItem.notebookName + " not found locally");
            return uploadResult;
        }
        lastError = null;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        booleanRef.element = callback.onProgress(l, false, 0L, size.longValue());
        if (booleanRef.element) {
            Long requestId2 = uploadItem.requestId;
            Intrinsics.checkNotNullExpressionValue(requestId2, "requestId");
            long jLongValue = requestId2.longValue();
            String str2 = uploadItem.fileId;
            String str3 = uploadItem.notebookCloudPath;
            String str4 = uploadItem.notebookTempUploadPath;
            Long size2 = uploadItem.size;
            Intrinsics.checkNotNullExpressionValue(size2, "size");
            Uploader.UploadResult uploadResult2 = new Uploader.UploadResult(jLongValue, str2, str3, "", str4, size2.longValue());
            uploadResult2.lastError = new IOException("Canceled");
            return uploadResult2;
        }
        boolean zHasInsufficientStorage = false;
        int i2 = 1;
        FileMetadata fileMetadata2 = null;
        while (fileMetadata2 == null && i2 <= 5 && !booleanRef.element) {
            try {
                String str5 = uploadItem.notebookCloudPath;
                FileInputStream fileInputStream = new FileInputStream(uploadItem.notebookTempUploadPath);
                try {
                    fileMetadataUploadAndFinish = service.files().uploadBuilder(str5).withMode(WriteMode.OVERWRITE).start().uploadAndFinish(fileInputStream, new IOUtil.ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.api.UploadHTTP$$ExternalSyntheticLambda6
                        @Override // com.dropbox.core.util.IOUtil.ProgressListener
                        public final void onProgress(long j) throws IOException {
                            UploadHTTP.uploadFile$lambda$1$0(booleanRef, callback, uploadItem, j);
                        }
                    });
                    try {
                        FileMetadata fileMetadata3 = fileMetadataUploadAndFinish;
                        if (fileMetadata3 != null) {
                            try {
                                String rev = fileMetadata3.getRev();
                                if (rev != null) {
                                    Long l2 = uploadItem.requestId;
                                    Long size3 = uploadItem.size;
                                    Intrinsics.checkNotNullExpressionValue(size3, "size");
                                    long jLongValue2 = size3.longValue();
                                    Long size4 = uploadItem.size;
                                    Intrinsics.checkNotNullExpressionValue(size4, "size");
                                    i = i2;
                                    try {
                                        callback.onProgress(l2, true, jLongValue2, size4.longValue());
                                        callback.onComplete(uploadItem.requestId, rev);
                                        Unit unit = Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        th = th;
                                        str = null;
                                        try {
                                            throw th;
                                        } catch (Throwable th3) {
                                            CloseableKt.closeFinally(fileInputStream, th);
                                            throw th3;
                                        }
                                    }
                                } else {
                                    i = i2;
                                }
                                str = null;
                                try {
                                    CloseableKt.closeFinally(fileInputStream, null);
                                    z = zHasInsufficientStorage;
                                    fileMetadata = fileMetadataUploadAndFinish;
                                } catch (UploadErrorException e) {
                                    e = e;
                                    fileMetadata2 = fileMetadataUploadAndFinish;
                                    zHasInsufficientStorage = hasInsufficientStorage(e.errorValue.getPathValue().getReason());
                                    lastError = e;
                                    Log.e(TAG, "Error uploading to Dropbox: ", e);
                                    fileMetadata = fileMetadata2;
                                    z = zHasInsufficientStorage;
                                } catch (DbxException e2) {
                                    e = e2;
                                    fileMetadata2 = fileMetadataUploadAndFinish;
                                    lastError = e;
                                    Log.e(TAG, "Error uploading to Dropbox: ", e);
                                    fileMetadata = fileMetadata2;
                                    z = zHasInsufficientStorage;
                                } catch (IOException e3) {
                                    e = e3;
                                    fileMetadata2 = fileMetadataUploadAndFinish;
                                    lastError = e;
                                    Log.e(TAG, "Error uploading to Dropbox: ", e);
                                    fileMetadata = fileMetadata2;
                                    z = zHasInsufficientStorage;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                i = i2;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        i = i2;
                        str = null;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i = i2;
                    str = null;
                    fileMetadataUploadAndFinish = fileMetadata2;
                }
            } catch (UploadErrorException e4) {
                e = e4;
                i = i2;
                str = null;
            } catch (DbxException e5) {
                e = e5;
                i = i2;
                str = null;
            } catch (IOException e6) {
                e = e6;
                i = i2;
                str = null;
            }
            Long requestId3 = uploadItem.requestId;
            Intrinsics.checkNotNullExpressionValue(requestId3, "requestId");
            long jLongValue3 = requestId3.longValue();
            FileMetadata fileMetadata4 = fileMetadata;
            String id = fileMetadata4 != null ? fileMetadata4.getId() : str;
            String pathDisplay = fileMetadata4 != null ? fileMetadata4.getPathDisplay() : str;
            String rev2 = fileMetadata4 != null ? fileMetadata4.getRev() : str;
            String str6 = uploadItem.notebookTempUploadPath;
            String contentHash = fileMetadata4 != null ? fileMetadata4.getContentHash() : str;
            boolean z2 = fileMetadata != null;
            Exception exc = lastError;
            Long size5 = uploadItem.size;
            Intrinsics.checkNotNullExpressionValue(size5, "size");
            i2 = i + 1;
            uploadResult = new Uploader.UploadResult(jLongValue3, id, pathDisplay, rev2, str6, contentHash, z2, z, exc, fileMetadata, size5.longValue());
            zHasInsufficientStorage = z;
            fileMetadata2 = fileMetadata;
        }
        return uploadResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadFile$lambda$1$0(Ref.BooleanRef booleanRef, ProgressListener progressListener, Uploader.UploadItem uploadItem, long j) throws IOException {
        Long l = uploadItem.requestId;
        Long size = uploadItem.size;
        Intrinsics.checkNotNullExpressionValue(size, "size");
        booleanRef.element = progressListener.onProgress(l, true, j, size.longValue());
        if (booleanRef.element) {
            throw new IOException("Canceled");
        }
    }

    private final boolean completeFileInfo(Uploader.UploadItem uploadItem) {
        File file = new File(uploadItem.notebookTempUploadPath);
        if (!file.exists()) {
            return false;
        }
        uploadItem.lastModificationInMilliSeconds = Long.valueOf(file.lastModified());
        uploadItem.size = Long.valueOf(file.length());
        uploadItem.notebookName = file.getName();
        return true;
    }

    private final boolean hasInsufficientStorage(WriteError writeError) {
        return writeError != null && writeError == WriteError.INSUFFICIENT_SPACE;
    }
}
