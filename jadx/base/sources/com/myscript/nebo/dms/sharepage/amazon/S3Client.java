package com.myscript.nebo.dms.sharepage.amazon;

import android.util.Log;
import androidx.media3.datasource.cache.CacheDataSink;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.AbortMultipartUploadResponse;
import aws.sdk.kotlin.services.p010s3.model.CompleteMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CompletedMultipartUpload;
import aws.sdk.kotlin.services.p010s3.model.CompletedPart;
import aws.sdk.kotlin.services.p010s3.model.CreateMultipartUploadRequest;
import aws.sdk.kotlin.services.p010s3.model.CreateMultipartUploadResponse;
import aws.sdk.kotlin.services.p010s3.model.PutObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartRequest;
import aws.sdk.kotlin.services.p010s3.model.UploadPartResponse;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.content.ByteStreamJVMKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.dms.sharepage.api.entity.PublishResult;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p039io.CloseableKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: S3Client.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003$%&B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ&\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0019JB\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0 H\u0082@¢\u0006\u0002\u0010!JJ\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0 2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010#R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/amazon/S3Client;", "", "params", "Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult$S3UploadParameters;", "<init>", "(Lcom/myscript/nebo/dms/sharepage/api/entity/PublishResult$S3UploadParameters;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "uploadJob", "Lkotlinx/coroutines/Job;", "upload", "", "localDocumentPath", "", "uuid", "pageTitle", "uploadFileName", "collectMetadata", "Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$CollectMetadata;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$UploadListener;", "cancel", "runUpload", "file", "Ljava/io/File;", "(Ljava/io/File;Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$CollectMetadata;Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$UploadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "singleShotUpload", "s3", "Laws/sdk/kotlin/services/s3/S3Client;", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, "userMetadata", "", "(Laws/sdk/kotlin/services/s3/S3Client;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "multipartUpload", "(Laws/sdk/kotlin/services/s3/S3Client;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$UploadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UploadListener", "CollectMetadata", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3Client {
    private static final String CONTENT_DISPOSITION = "attachment; filename=page.nebo; filename*=UTF-8''page.nebo";
    private static final String CONTENT_TYPE = "application/vnd.myscript.nebo";
    private static final String DEFAULT_FILE_NAME = "page.nebo";
    private static final int MINIMUM_PART_UPLOAD_SIZE = 5242880;
    private static final String TAG = "S3Client";
    private final PublishResult.S3UploadParameters params;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private Job uploadJob;

    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$CollectMetadata;", "", "<init>", "()V", "shareWithMyscript", "", "userLogin", "", "contentSha256", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CollectMetadata {
        public String contentSha256;
        public boolean shareWithMyscript;
        public String userLogin;
    }

    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/amazon/S3Client$UploadListener;", "", "onProgress", "", "bytesCurrent", "", "bytesTotal", "onError", "onComplete", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface UploadListener {
        void onComplete();

        void onError();

        void onProgress(long bytesCurrent, long bytesTotal);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.amazon.S3Client$multipartUpload$1 */
    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.amazon.S3Client", m1609f = "S3Client.kt", m1610i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, m1611l = {135, 160, 179, PsExtractor.PRIVATE_STREAM_1}, m1612m = "multipartUpload", m1613n = {"s3", "file", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, "userMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "s3", "file", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, "userMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "init", "uploadId", "parts", "raf", "partNumber", "partBuffer", "partBytes", "totalLength", "$i$a$-use-S3Client$multipartUpload$2", "filePosition", "partSize", "s3", "file", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, "userMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "init", "uploadId", "parts", "totalLength", "s3", "file", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, "userMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "init", "uploadId", "parts", "t", "$this$multipartUpload_u24lambda_u244", "totalLength", "$i$a$-runCatching-S3Client$multipartUpload$4"}, m1614nl = {144, 169, PDFACompliance.e_PDFA1_8_7, 193}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "J$0", "I$0", "J$1", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "J$0", "I$0"}, m1616v = 2)
    static final class C62821 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C62821(Continuation<? super C62821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return S3Client.this.multipartUpload(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.amazon.S3Client$runUpload$1 */
    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.amazon.S3Client", m1609f = "S3Client.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {PDFACompliance.e_PDFA9_3, 96}, m1612m = "runUpload", m1613n = {"file", "collectMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "params", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, TtmlNode.TAG_REGION, "userMetadata", "client", "s3", "$i$a$-use-S3Client$runUpload$2", "file", "collectMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "params", "bucket", SubscriberAttributeKt.JSON_NAME_KEY, TtmlNode.TAG_REGION, "userMetadata", "client", "s3", "$i$a$-use-S3Client$runUpload$2"}, m1614nl = {PDFACompliance.e_PDFA9_4, 98}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "I$0"}, m1616v = 2)
    static final class C62831 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C62831(Continuation<? super C62831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return S3Client.this.runUpload(null, null, null, this);
        }
    }

    public S3Client(PublishResult.S3UploadParameters s3UploadParameters) {
        this.params = s3UploadParameters;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.sharepage.amazon.S3Client$upload$1 */
    /* JADX INFO: compiled from: S3Client.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.sharepage.amazon.S3Client$upload$1", m1609f = "S3Client.kt", m1610i = {}, m1611l = {60}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {61}, m1615s = {}, m1616v = 2)
    static final class C62841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CollectMetadata $collectMetadata;
        final /* synthetic */ UploadListener $listener;
        final /* synthetic */ String $localDocumentPath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62841(String str, CollectMetadata collectMetadata, UploadListener uploadListener, Continuation<? super C62841> continuation) {
            super(2, continuation);
            this.$localDocumentPath = str;
            this.$collectMetadata = collectMetadata;
            this.$listener = uploadListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return S3Client.this.new C62841(this.$localDocumentPath, this.$collectMetadata, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (S3Client.this.runUpload(new File(this.$localDocumentPath), this.$collectMetadata, this.$listener, this) == coroutine_suspended) {
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

    public final void upload(String localDocumentPath, String uuid, String pageTitle, String uploadFileName, CollectMetadata collectMetadata, UploadListener listener) {
        Intrinsics.checkNotNullParameter(localDocumentPath, "localDocumentPath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Intrinsics.checkNotNullParameter(uploadFileName, "uploadFileName");
        Intrinsics.checkNotNullParameter(collectMetadata, "collectMetadata");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.uploadJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C62841(localDocumentPath, collectMetadata, listener, null), 3, null);
    }

    public final void cancel() {
        Job job = this.uploadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.uploadJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.myscript.nebo.dms.sharepage.amazon.S3Client$UploadListener] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.myscript.nebo.dms.sharepage.amazon.S3Client$UploadListener] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runUpload(File file, CollectMetadata collectMetadata, UploadListener uploadListener, Continuation<? super Unit> continuation) {
        C62831 c62831;
        ?? r8;
        Throwable th;
        ?? r3;
        ?? r32;
        ?? r33;
        File file2;
        UploadListener uploadListener2;
        Closeable closeable;
        UploadListener uploadListener3 = uploadListener;
        if (continuation instanceof C62831) {
            c62831 = (C62831) continuation;
            if ((c62831.label & Integer.MIN_VALUE) != 0) {
                c62831.label -= Integer.MIN_VALUE;
            } else {
                c62831 = new C62831(continuation);
            }
        }
        C62831 c628312 = c62831;
        Object obj = c628312.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r34 = c628312.label;
        ?? r4 = 2;
        try {
            try {
                if (r34 == 0) {
                    ResultKt.throwOnFailure(obj);
                    final PublishResult.S3UploadParameters s3UploadParameters = this.params;
                    if (s3UploadParameters == null) {
                        uploadListener3.onError();
                        return Unit.INSTANCE;
                    }
                    String str = s3UploadParameters.bucket;
                    if (str == null) {
                        uploadListener3.onError();
                        return Unit.INSTANCE;
                    }
                    String str2 = s3UploadParameters.objectKey;
                    if (str2 == null) {
                        uploadListener3.onError();
                        return Unit.INSTANCE;
                    }
                    final String str3 = s3UploadParameters.region;
                    if (str3 == null) {
                        uploadListener3.onError();
                        return Unit.INSTANCE;
                    }
                    Pair[] pairArr = new Pair[3];
                    pairArr[0] = TuplesKt.m1606to("share-with-myscript", String.valueOf(collectMetadata.shareWithMyscript));
                    String str4 = collectMetadata.userLogin;
                    if (str4 == null) {
                        str4 = "";
                    }
                    pairArr[1] = TuplesKt.m1606to("login", str4);
                    String str5 = collectMetadata.contentSha256;
                    pairArr[2] = TuplesKt.m1606to("content-sha256", str5 != null ? str5 : "");
                    Map<String, String> mapMapOf = MapsKt.mapOf(pairArr);
                    aws.sdk.kotlin.services.p010s3.S3Client s3Client = (aws.sdk.kotlin.services.p010s3.S3Client) aws.sdk.kotlin.services.p010s3.S3Client.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return S3Client.runUpload$lambda$4(str3, s3UploadParameters, (S3Client.Config.Builder) obj2);
                        }
                    });
                    aws.sdk.kotlin.services.p010s3.S3Client s3Client2 = s3Client;
                    try {
                        aws.sdk.kotlin.services.p010s3.S3Client s3Client3 = s3Client2;
                        try {
                            try {
                                if (file.length() < CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                                    try {
                                        c628312.L$0 = file;
                                        c628312.L$1 = SpillingKt.nullOutSpilledVariable(collectMetadata);
                                        c628312.L$2 = uploadListener3;
                                        c628312.L$3 = SpillingKt.nullOutSpilledVariable(s3UploadParameters);
                                        c628312.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                        c628312.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                        c628312.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                        c628312.L$7 = SpillingKt.nullOutSpilledVariable(mapMapOf);
                                        c628312.L$8 = SpillingKt.nullOutSpilledVariable(s3Client);
                                        c628312.L$9 = s3Client2;
                                        c628312.L$10 = SpillingKt.nullOutSpilledVariable(s3Client3);
                                        c628312.I$0 = 0;
                                        c628312.label = 1;
                                        if (singleShotUpload(s3Client3, file, str, str2, mapMapOf, c628312) != coroutine_suspended) {
                                            file2 = file;
                                            uploadListener2 = uploadListener3;
                                            closeable = s3Client2;
                                            uploadListener2.onProgress(file2.length(), file2.length());
                                            r34 = closeable;
                                            r4 = uploadListener2;
                                            r4.onComplete();
                                            r33 = r34;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        r32 = s3Client2;
                                        r8 = uploadListener3;
                                        Log.e(TAG, "Could not upload page", e);
                                        r8.onError();
                                        r33 = r32;
                                    }
                                } else {
                                    c628312.L$0 = SpillingKt.nullOutSpilledVariable(file);
                                    c628312.L$1 = SpillingKt.nullOutSpilledVariable(collectMetadata);
                                    c628312.L$2 = uploadListener3;
                                    c628312.L$3 = SpillingKt.nullOutSpilledVariable(s3UploadParameters);
                                    c628312.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                    c628312.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                    c628312.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                    c628312.L$7 = SpillingKt.nullOutSpilledVariable(mapMapOf);
                                    c628312.L$8 = SpillingKt.nullOutSpilledVariable(s3Client);
                                    c628312.L$9 = s3Client2;
                                    c628312.L$10 = SpillingKt.nullOutSpilledVariable(s3Client3);
                                    c628312.I$0 = 0;
                                    c628312.label = 2;
                                    if (multipartUpload(s3Client3, file, str, str2, mapMapOf, uploadListener3, c628312) != coroutine_suspended) {
                                        r4 = uploadListener;
                                        r34 = s3Client2;
                                        r4.onComplete();
                                        r33 = r34;
                                    }
                                }
                                return coroutine_suspended;
                            } catch (CancellationException e2) {
                                throw e2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            uploadListener3 = uploadListener;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r3 = s3Client2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(r3, th);
                            throw th3;
                        }
                    }
                } else if (r34 == 1) {
                    int i = c628312.I$0;
                    Closeable closeable2 = (Closeable) c628312.L$9;
                    UploadListener uploadListener4 = (UploadListener) c628312.L$2;
                    file2 = (File) c628312.L$0;
                    ResultKt.throwOnFailure(obj);
                    closeable = closeable2;
                    uploadListener2 = uploadListener4;
                    uploadListener2.onProgress(file2.length(), file2.length());
                    r34 = closeable;
                    r4 = uploadListener2;
                    r4.onComplete();
                    r33 = r34;
                } else {
                    if (r34 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i2 = c628312.I$0;
                    Closeable closeable3 = (Closeable) c628312.L$9;
                    UploadListener uploadListener5 = (UploadListener) c628312.L$2;
                    ResultKt.throwOnFailure(obj);
                    r34 = closeable3;
                    r4 = uploadListener5;
                    r4.onComplete();
                    r33 = r34;
                }
            } catch (Throwable th4) {
                th = th4;
                r3 = r34;
            }
        } catch (CancellationException e4) {
            throw e4;
        } catch (Exception e5) {
            e = e5;
            r8 = r4;
            r32 = r34;
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(r33, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runUpload$lambda$4(String str, final PublishResult.S3UploadParameters s3UploadParameters, S3Client.Config.Builder AwsS3Client) {
        Intrinsics.checkNotNullParameter(AwsS3Client, "$this$AwsS3Client");
        AwsS3Client.setRegion(str);
        AwsS3Client.setCredentialsProvider(StaticCredentialsProvider.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return S3Client.runUpload$lambda$4$0(s3UploadParameters, (StaticCredentialsProvider.Builder) obj);
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runUpload$lambda$4$0(PublishResult.S3UploadParameters s3UploadParameters, StaticCredentialsProvider.Builder StaticCredentialsProvider) {
        Intrinsics.checkNotNullParameter(StaticCredentialsProvider, "$this$StaticCredentialsProvider");
        String str = s3UploadParameters.accessKeyId;
        if (str == null) {
            str = "";
        }
        StaticCredentialsProvider.setAccessKeyId(str);
        String str2 = s3UploadParameters.secretAccessKey;
        StaticCredentialsProvider.setSecretAccessKey(str2 != null ? str2 : "");
        StaticCredentialsProvider.setSessionToken(s3UploadParameters.sessionToken);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object singleShotUpload(aws.sdk.kotlin.services.p010s3.S3Client s3Client, final File file, final String str, final String str2, final Map<String, String> map, Continuation<? super Unit> continuation) {
        Object objPutObject = s3Client.putObject(PutObjectRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return S3Client.singleShotUpload$lambda$0(str, str2, map, file, (PutObjectRequest.Builder) obj);
            }
        }), continuation);
        return objPutObject == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPutObject : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit singleShotUpload$lambda$0(String str, String str2, Map map, File file, PutObjectRequest.Builder PutObjectRequest) {
        Intrinsics.checkNotNullParameter(PutObjectRequest, "$this$PutObjectRequest");
        PutObjectRequest.setBucket(str);
        PutObjectRequest.setKey(str2);
        PutObjectRequest.setContentType(CONTENT_TYPE);
        PutObjectRequest.setContentDisposition(CONTENT_DISPOSITION);
        PutObjectRequest.setMetadata(map);
        PutObjectRequest.setBody(ByteStreamJVMKt.asByteStream$default(file, 0L, 0L, 3, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0345  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x02af -> B:132:0x02c6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object multipartUpload(aws.sdk.kotlin.services.p010s3.S3Client s3Client, File file, String str, String str2, final Map<String, String> map, UploadListener uploadListener, Continuation<? super Unit> continuation) throws Throwable {
        C62821 c62821;
        aws.sdk.kotlin.services.p010s3.S3Client s3Client2;
        Object obj;
        Map<String, String> map2;
        File file2;
        UploadListener uploadListener2;
        CreateMultipartUploadResponse createMultipartUploadResponse;
        long length;
        Object obj2;
        Throwable th;
        aws.sdk.kotlin.services.p010s3.S3Client s3Client3;
        final String str3;
        final String str4;
        final String str5;
        File file3;
        Map<String, String> map3;
        final List list;
        UploadListener uploadListener3;
        long j;
        String str6;
        aws.sdk.kotlin.services.p010s3.S3Client s3Client4;
        CreateMultipartUploadResponse createMultipartUploadResponse2;
        Closeable closeable;
        Throwable th2;
        RandomAccessFile randomAccessFile;
        CreateMultipartUploadResponse createMultipartUploadResponse3;
        File file4;
        byte[] bArr;
        aws.sdk.kotlin.services.p010s3.S3Client s3Client5;
        Map<String, String> map4;
        List list2;
        final Ref.IntRef intRef;
        final String str7;
        final String str8;
        final String str9;
        long j2;
        int i;
        Throwable th3;
        Map<String, String> map5;
        File file5;
        final String str10;
        long j3;
        Closeable closeable2;
        byte[] bArrCopyOf;
        Object obj3;
        Throwable th4;
        Ref.IntRef intRef2;
        byte[] bArr2;
        File file6;
        aws.sdk.kotlin.services.p010s3.S3Client s3Client6;
        List list3;
        String str11;
        aws.sdk.kotlin.services.p010s3.S3Client s3Client7;
        Throwable th5;
        final String str12 = str;
        final String str13 = str2;
        if (continuation instanceof C62821) {
            c62821 = (C62821) continuation;
            if ((c62821.label & Integer.MIN_VALUE) != 0) {
                c62821.label -= Integer.MIN_VALUE;
            } else {
                c62821 = new C62821(continuation);
            }
        }
        Object objAbortMultipartUpload = c62821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c62821.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAbortMultipartUpload);
            CreateMultipartUploadRequest createMultipartUploadRequestInvoke = CreateMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return S3Client.multipartUpload$lambda$0(str12, str13, map, (CreateMultipartUploadRequest.Builder) obj4);
                }
            });
            c62821.L$0 = s3Client;
            c62821.L$1 = file;
            c62821.L$2 = str12;
            c62821.L$3 = str13;
            c62821.L$4 = SpillingKt.nullOutSpilledVariable(map);
            c62821.L$5 = uploadListener;
            c62821.label = 1;
            Object objCreateMultipartUpload = s3Client.createMultipartUpload(createMultipartUploadRequestInvoke, c62821);
            if (objCreateMultipartUpload == coroutine_suspended) {
                return coroutine_suspended;
            }
            s3Client2 = s3Client;
            obj = objCreateMultipartUpload;
            map2 = map;
            file2 = file;
            uploadListener2 = uploadListener;
        } else if (i2 == 1) {
            UploadListener uploadListener4 = (UploadListener) c62821.L$5;
            Map<String, String> map6 = (Map) c62821.L$4;
            str13 = (String) c62821.L$3;
            String str14 = (String) c62821.L$2;
            file2 = (File) c62821.L$1;
            s3Client2 = (aws.sdk.kotlin.services.p010s3.S3Client) c62821.L$0;
            ResultKt.throwOnFailure(objAbortMultipartUpload);
            uploadListener2 = uploadListener4;
            obj = objAbortMultipartUpload;
            map2 = map6;
            str12 = str14;
        } else if (i2 == 2) {
            int i3 = c62821.I$1;
            long j4 = c62821.J$1;
            int i4 = c62821.I$0;
            long j5 = c62821.J$0;
            bArr = (byte[]) c62821.L$12;
            Ref.IntRef intRef3 = (Ref.IntRef) c62821.L$11;
            RandomAccessFile randomAccessFile2 = (RandomAccessFile) c62821.L$10;
            closeable = (Closeable) c62821.L$9;
            List list4 = (List) c62821.L$8;
            String str15 = (String) c62821.L$7;
            createMultipartUploadResponse2 = (CreateMultipartUploadResponse) c62821.L$6;
            UploadListener uploadListener5 = (UploadListener) c62821.L$5;
            Map<String, String> map7 = (Map) c62821.L$4;
            String str16 = (String) c62821.L$3;
            String str17 = (String) c62821.L$2;
            file3 = (File) c62821.L$1;
            aws.sdk.kotlin.services.p010s3.S3Client s3Client8 = (aws.sdk.kotlin.services.p010s3.S3Client) c62821.L$0;
            try {
                ResultKt.throwOnFailure(objAbortMultipartUpload);
                Object objUploadPart = objAbortMultipartUpload;
                long j6 = j4;
                obj2 = coroutine_suspended;
                String str18 = str15;
                uploadListener3 = uploadListener5;
                final Ref.IntRef intRef4 = intRef3;
                String str19 = str16;
                str7 = str17;
                s3Client5 = s3Client8;
                int iMin = i3;
                int i5 = i4;
                list2 = list4;
                th3 = null;
                try {
                    try {
                        final UploadPartResponse uploadPartResponse = (UploadPartResponse) objUploadPart;
                        list2.add(CompletedPart.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                return S3Client.multipartUpload$lambda$2$1(intRef4, uploadPartResponse, (CompletedPart.Builder) obj4);
                            }
                        }));
                        long j7 = j6 + ((long) iMin);
                        intRef4.element++;
                        uploadListener3.onProgress(j7, j5);
                        s3Client5 = s3Client7;
                        intRef = intRef4;
                        coroutine_suspended = obj2;
                        j2 = j7;
                        randomAccessFile = randomAccessFile2;
                        length = j5;
                        createMultipartUploadResponse3 = createMultipartUploadResponse2;
                        map4 = map7;
                        i = i5;
                        file4 = file3;
                        str8 = str19;
                        str9 = str18;
                        if (j2 < length) {
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                JobKt.ensureActive(c62821.get$context());
                                                iMin = (int) Math.min(CacheDataSink.DEFAULT_FRAGMENT_SIZE, j3 - j2);
                                                randomAccessFile.seek(j2);
                                                randomAccessFile.readFully(bArr, 0, iMin);
                                                if (iMin == bArr.length) {
                                                    try {
                                                        bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                                                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                                                    } catch (Throwable th6) {
                                                        map3 = map5;
                                                        s3Client4 = s3Client5;
                                                        obj2 = coroutine_suspended;
                                                        list = list2;
                                                        closeable = closeable2;
                                                        str6 = str7;
                                                        str3 = str9;
                                                        createMultipartUploadResponse2 = createMultipartUploadResponse3;
                                                        j = j3;
                                                        th2 = th6;
                                                        file3 = file4;
                                                        str5 = str8;
                                                    }
                                                } else {
                                                    bArrCopyOf = Arrays.copyOf(bArr, iMin);
                                                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                                                }
                                                final byte[] bArr3 = bArrCopyOf;
                                                UploadPartRequest uploadPartRequestInvoke = UploadPartRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda5
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        return S3Client.multipartUpload$lambda$2$0(str7, str8, str9, intRef, bArr3, (UploadPartRequest.Builder) obj4);
                                                    }
                                                });
                                                c62821.L$0 = s3Client5;
                                                c62821.L$1 = SpillingKt.nullOutSpilledVariable(file5);
                                                c62821.L$2 = str4;
                                                c62821.L$3 = str5;
                                                c62821.L$4 = SpillingKt.nullOutSpilledVariable(map5);
                                                c62821.L$5 = uploadListener3;
                                                c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse3);
                                                c62821.L$7 = str10;
                                                c62821.L$8 = list2;
                                                c62821.L$9 = closeable;
                                                c62821.L$10 = randomAccessFile;
                                                c62821.L$11 = intRef2;
                                                c62821.L$12 = bArr;
                                                RandomAccessFile randomAccessFile3 = randomAccessFile;
                                                c62821.L$13 = SpillingKt.nullOutSpilledVariable(bArr3);
                                                c62821.J$0 = j;
                                                c62821.I$0 = i;
                                                c62821.J$1 = j2;
                                                c62821.I$1 = iMin;
                                                i5 = i;
                                                c62821.label = 2;
                                                objUploadPart = s3Client5.uploadPart(uploadPartRequestInvoke, c62821);
                                                long j8 = j2;
                                                obj2 = obj3;
                                                if (objUploadPart == obj2) {
                                                    return obj2;
                                                }
                                                map7 = map5;
                                                file3 = file5;
                                                intRef4 = intRef2;
                                                str19 = str5;
                                                j5 = j;
                                                bArr = bArr2;
                                                list2 = list;
                                                str7 = str4;
                                                th3 = th4;
                                                j6 = j8;
                                                str18 = str10;
                                                randomAccessFile2 = randomAccessFile3;
                                                createMultipartUploadResponse2 = createMultipartUploadResponse3;
                                                final UploadPartResponse uploadPartResponse2 = (UploadPartResponse) objUploadPart;
                                                s3Client7 = s3Client5;
                                                list2.add(CompletedPart.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda6
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        return S3Client.multipartUpload$lambda$2$1(intRef4, uploadPartResponse2, (CompletedPart.Builder) obj4);
                                                    }
                                                }));
                                                long j72 = j6 + ((long) iMin);
                                                intRef4.element++;
                                                uploadListener3.onProgress(j72, j5);
                                                s3Client5 = s3Client7;
                                                intRef = intRef4;
                                                coroutine_suspended = obj2;
                                                j2 = j72;
                                                randomAccessFile = randomAccessFile2;
                                                length = j5;
                                                createMultipartUploadResponse3 = createMultipartUploadResponse2;
                                                map4 = map7;
                                                i = i5;
                                                file4 = file3;
                                                str8 = str19;
                                                str9 = str18;
                                                if (j2 < length) {
                                                    obj2 = coroutine_suspended;
                                                    list = list2;
                                                    map5 = map4;
                                                    Throwable th7 = th3;
                                                    j = length;
                                                    file5 = file4;
                                                    str4 = str7;
                                                    str5 = str8;
                                                    str10 = str9;
                                                    try {
                                                        Unit unit = Unit.INSTANCE;
                                                        try {
                                                            CloseableKt.closeFinally(closeable, th7);
                                                            CompleteMultipartUploadRequest completeMultipartUploadRequestInvoke = CompleteMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda7
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj4) {
                                                                    return S3Client.multipartUpload$lambda$3(str4, str5, str10, list, (CompleteMultipartUploadRequest.Builder) obj4);
                                                                }
                                                            });
                                                            c62821.L$0 = s3Client5;
                                                            c62821.L$1 = SpillingKt.nullOutSpilledVariable(file5);
                                                            c62821.L$2 = str4;
                                                            c62821.L$3 = str5;
                                                            c62821.L$4 = SpillingKt.nullOutSpilledVariable(map5);
                                                            c62821.L$5 = SpillingKt.nullOutSpilledVariable(uploadListener3);
                                                            c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse3);
                                                            c62821.L$7 = str10;
                                                            c62821.L$8 = SpillingKt.nullOutSpilledVariable(list);
                                                            c62821.L$9 = null;
                                                            c62821.L$10 = null;
                                                            c62821.L$11 = null;
                                                            c62821.L$12 = null;
                                                            c62821.L$13 = null;
                                                            c62821.J$0 = j;
                                                            c62821.label = 3;
                                                            Object objCompleteMultipartUpload = s3Client5.completeMultipartUpload(completeMultipartUploadRequestInvoke, c62821);
                                                            if (objCompleteMultipartUpload == obj2) {
                                                                return obj2;
                                                            }
                                                            createMultipartUploadResponse = createMultipartUploadResponse3;
                                                            map3 = map5;
                                                            file6 = file5;
                                                            s3Client6 = s3Client5;
                                                            list3 = list;
                                                            str11 = str4;
                                                            str3 = str10;
                                                            objAbortMultipartUpload = objCompleteMultipartUpload;
                                                            return Unit.INSTANCE;
                                                        } catch (Throwable th8) {
                                                            aws.sdk.kotlin.services.p010s3.S3Client s3Client9 = s3Client5;
                                                            th = th8;
                                                            s3Client3 = s3Client9;
                                                            createMultipartUploadResponse = createMultipartUploadResponse3;
                                                            map3 = map5;
                                                            file3 = file5;
                                                            str3 = str10;
                                                            Result.Companion companion = Result.INSTANCE;
                                                            AbortMultipartUploadRequest abortMultipartUploadRequestInvoke = AbortMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda8
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Object invoke(Object obj4) {
                                                                    return S3Client.multipartUpload$lambda$4$0(str4, str5, str3, (AbortMultipartUploadRequest.Builder) obj4);
                                                                }
                                                            });
                                                            c62821.L$0 = SpillingKt.nullOutSpilledVariable(s3Client3);
                                                            c62821.L$1 = SpillingKt.nullOutSpilledVariable(file3);
                                                            c62821.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                                                            c62821.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                                                            c62821.L$4 = SpillingKt.nullOutSpilledVariable(map3);
                                                            c62821.L$5 = SpillingKt.nullOutSpilledVariable(uploadListener3);
                                                            c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse);
                                                            c62821.L$7 = SpillingKt.nullOutSpilledVariable(str3);
                                                            c62821.L$8 = SpillingKt.nullOutSpilledVariable(list);
                                                            c62821.L$9 = th;
                                                            c62821.L$10 = SpillingKt.nullOutSpilledVariable(this);
                                                            c62821.L$11 = null;
                                                            c62821.L$12 = null;
                                                            c62821.L$13 = null;
                                                            c62821.J$0 = j;
                                                            c62821.I$0 = 0;
                                                            c62821.label = 4;
                                                            objAbortMultipartUpload = s3Client3.abortMultipartUpload(abortMultipartUploadRequestInvoke, c62821);
                                                            if (objAbortMultipartUpload == obj2) {
                                                            }
                                                        }
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        createMultipartUploadResponse2 = createMultipartUploadResponse3;
                                                        map3 = map5;
                                                        file3 = file5;
                                                        s3Client4 = s3Client5;
                                                        str6 = str4;
                                                        str3 = str10;
                                                        th2 = th;
                                                        throw th2;
                                                    }
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                obj2 = coroutine_suspended;
                                                list = list2;
                                                file5 = file4;
                                                closeable = closeable2;
                                                str4 = str7;
                                                str5 = str8;
                                                str10 = str9;
                                            }
                                            j3 = length;
                                            map5 = map4;
                                            closeable2 = closeable;
                                        } catch (Throwable th11) {
                                            th = th11;
                                            obj2 = obj3;
                                        }
                                        list = list2;
                                        bArr2 = bArr;
                                        j = j3;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        obj2 = coroutine_suspended;
                                        list = list2;
                                        map5 = map4;
                                        j = length;
                                        file5 = file4;
                                        str4 = str7;
                                        str5 = str8;
                                        str10 = str9;
                                    }
                                } catch (Throwable th13) {
                                    th = th13;
                                    list = list2;
                                    obj2 = obj3;
                                    j = j3;
                                    createMultipartUploadResponse2 = createMultipartUploadResponse3;
                                    map3 = map5;
                                    file3 = file5;
                                    s3Client4 = s3Client5;
                                    str6 = str4;
                                    str3 = str10;
                                    th2 = th;
                                    throw th2;
                                }
                                closeable = closeable2;
                            } catch (Throwable th14) {
                                th = th14;
                                list = list2;
                                closeable = closeable2;
                            }
                            obj3 = coroutine_suspended;
                            th4 = th3;
                            file5 = file4;
                            str4 = str7;
                            str5 = str8;
                            str10 = str9;
                            intRef2 = intRef;
                        }
                        createMultipartUploadResponse2 = createMultipartUploadResponse3;
                        map3 = map5;
                        file3 = file5;
                        s3Client4 = s3Client5;
                        str6 = str4;
                        str3 = str10;
                        th2 = th;
                    } catch (Throwable th15) {
                        th = th15;
                        th2 = th;
                        list = list2;
                        j = j5;
                        str5 = str19;
                        str3 = str18;
                        map3 = map7;
                        str6 = str7;
                        s3Client4 = s3Client7;
                        throw th2;
                    }
                    s3Client7 = s3Client5;
                } catch (Throwable th16) {
                    th = th16;
                    s3Client7 = s3Client5;
                }
            } catch (Throwable th17) {
                th2 = th17;
                obj2 = coroutine_suspended;
                list = list4;
                str3 = str15;
                j = j5;
                uploadListener3 = uploadListener5;
                map3 = map7;
                str5 = str16;
                str6 = str17;
                s3Client4 = s3Client8;
            }
            try {
                throw th2;
            } catch (Throwable th18) {
                try {
                    CloseableKt.closeFinally(closeable, th2);
                    throw th18;
                } catch (Throwable th19) {
                    th = th19;
                    str4 = str6;
                    s3Client3 = s3Client4;
                    createMultipartUploadResponse = createMultipartUploadResponse2;
                    Result.Companion companion2 = Result.INSTANCE;
                    AbortMultipartUploadRequest abortMultipartUploadRequestInvoke2 = AbortMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            return S3Client.multipartUpload$lambda$4$0(str4, str5, str3, (AbortMultipartUploadRequest.Builder) obj4);
                        }
                    });
                    c62821.L$0 = SpillingKt.nullOutSpilledVariable(s3Client3);
                    c62821.L$1 = SpillingKt.nullOutSpilledVariable(file3);
                    c62821.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                    c62821.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                    c62821.L$4 = SpillingKt.nullOutSpilledVariable(map3);
                    c62821.L$5 = SpillingKt.nullOutSpilledVariable(uploadListener3);
                    c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse);
                    c62821.L$7 = SpillingKt.nullOutSpilledVariable(str3);
                    c62821.L$8 = SpillingKt.nullOutSpilledVariable(list);
                    c62821.L$9 = th;
                    c62821.L$10 = SpillingKt.nullOutSpilledVariable(this);
                    c62821.L$11 = null;
                    c62821.L$12 = null;
                    c62821.L$13 = null;
                    c62821.J$0 = j;
                    c62821.I$0 = 0;
                    c62821.label = 4;
                    objAbortMultipartUpload = s3Client3.abortMultipartUpload(abortMultipartUploadRequestInvoke2, c62821);
                    if (objAbortMultipartUpload == obj2) {
                    }
                }
            }
        } else {
            if (i2 != 3) {
                if (i2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i6 = c62821.I$0;
                long j9 = c62821.J$0;
                th5 = (Throwable) c62821.L$9;
                try {
                    ResultKt.throwOnFailure(objAbortMultipartUpload);
                    Result.m14499constructorimpl((AbortMultipartUploadResponse) objAbortMultipartUpload);
                    throw th5;
                } catch (Throwable th20) {
                    th = th20;
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m14499constructorimpl(ResultKt.createFailure(th));
                    throw th5;
                }
            }
            long j10 = c62821.J$0;
            List list5 = (List) c62821.L$8;
            str3 = (String) c62821.L$7;
            createMultipartUploadResponse = (CreateMultipartUploadResponse) c62821.L$6;
            uploadListener3 = (UploadListener) c62821.L$5;
            map3 = (Map) c62821.L$4;
            str5 = (String) c62821.L$3;
            str11 = (String) c62821.L$2;
            File file7 = (File) c62821.L$1;
            s3Client6 = (aws.sdk.kotlin.services.p010s3.S3Client) c62821.L$0;
            try {
                ResultKt.throwOnFailure(objAbortMultipartUpload);
                list3 = list5;
                j = j10;
                obj2 = coroutine_suspended;
                file6 = file7;
                try {
                    return Unit.INSTANCE;
                } catch (Throwable th21) {
                    list = list3;
                    file3 = file6;
                    str4 = str11;
                    th = th21;
                    s3Client3 = s3Client6;
                    try {
                        Result.Companion companion22 = Result.INSTANCE;
                        AbortMultipartUploadRequest abortMultipartUploadRequestInvoke22 = AbortMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                return S3Client.multipartUpload$lambda$4$0(str4, str5, str3, (AbortMultipartUploadRequest.Builder) obj4);
                            }
                        });
                        c62821.L$0 = SpillingKt.nullOutSpilledVariable(s3Client3);
                        c62821.L$1 = SpillingKt.nullOutSpilledVariable(file3);
                        c62821.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                        c62821.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                        c62821.L$4 = SpillingKt.nullOutSpilledVariable(map3);
                        c62821.L$5 = SpillingKt.nullOutSpilledVariable(uploadListener3);
                        c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse);
                        c62821.L$7 = SpillingKt.nullOutSpilledVariable(str3);
                        c62821.L$8 = SpillingKt.nullOutSpilledVariable(list);
                        c62821.L$9 = th;
                        c62821.L$10 = SpillingKt.nullOutSpilledVariable(this);
                        c62821.L$11 = null;
                        c62821.L$12 = null;
                        c62821.L$13 = null;
                        c62821.J$0 = j;
                        c62821.I$0 = 0;
                        c62821.label = 4;
                        objAbortMultipartUpload = s3Client3.abortMultipartUpload(abortMultipartUploadRequestInvoke22, c62821);
                        if (objAbortMultipartUpload == obj2) {
                        }
                    } catch (Throwable th22) {
                        th = th22;
                        th5 = th;
                        Result.Companion companion32 = Result.INSTANCE;
                        Result.m14499constructorimpl(ResultKt.createFailure(th));
                        throw th5;
                    }
                }
            } catch (Throwable th23) {
                th = th23;
                list = list5;
                str4 = str11;
                file3 = file7;
                s3Client3 = s3Client6;
                j = j10;
                obj2 = coroutine_suspended;
                Result.Companion companion222 = Result.INSTANCE;
                AbortMultipartUploadRequest abortMultipartUploadRequestInvoke222 = AbortMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return S3Client.multipartUpload$lambda$4$0(str4, str5, str3, (AbortMultipartUploadRequest.Builder) obj4);
                    }
                });
                c62821.L$0 = SpillingKt.nullOutSpilledVariable(s3Client3);
                c62821.L$1 = SpillingKt.nullOutSpilledVariable(file3);
                c62821.L$2 = SpillingKt.nullOutSpilledVariable(str4);
                c62821.L$3 = SpillingKt.nullOutSpilledVariable(str5);
                c62821.L$4 = SpillingKt.nullOutSpilledVariable(map3);
                c62821.L$5 = SpillingKt.nullOutSpilledVariable(uploadListener3);
                c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse);
                c62821.L$7 = SpillingKt.nullOutSpilledVariable(str3);
                c62821.L$8 = SpillingKt.nullOutSpilledVariable(list);
                c62821.L$9 = th;
                c62821.L$10 = SpillingKt.nullOutSpilledVariable(this);
                c62821.L$11 = null;
                c62821.L$12 = null;
                c62821.L$13 = null;
                c62821.J$0 = j;
                c62821.I$0 = 0;
                c62821.label = 4;
                objAbortMultipartUpload = s3Client3.abortMultipartUpload(abortMultipartUploadRequestInvoke222, c62821);
                if (objAbortMultipartUpload == obj2) {
                }
            }
        }
        createMultipartUploadResponse = (CreateMultipartUploadResponse) obj;
        String uploadId = createMultipartUploadResponse.getUploadId();
        if (uploadId == null) {
            uploadListener2.onError();
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        length = file2.length();
        try {
            RandomAccessFile randomAccessFile4 = new RandomAccessFile(file2, "r");
            try {
                RandomAccessFile randomAccessFile5 = randomAccessFile4;
                Ref.IntRef intRef5 = new Ref.IntRef();
                intRef5.element = 1;
                Map<String, String> map8 = map2;
                randomAccessFile = randomAccessFile5;
                createMultipartUploadResponse3 = createMultipartUploadResponse;
                closeable = randomAccessFile4;
                file4 = file2;
                bArr = new byte[MINIMUM_PART_UPLOAD_SIZE];
                s3Client5 = s3Client2;
                map4 = map8;
                uploadListener3 = uploadListener2;
                list2 = arrayList;
                intRef = intRef5;
                str7 = str12;
                str8 = str13;
                str9 = uploadId;
                j2 = 0;
                i = 0;
                th3 = null;
                if (j2 < length) {
                }
                createMultipartUploadResponse2 = createMultipartUploadResponse3;
                map3 = map5;
                file3 = file5;
                s3Client4 = s3Client5;
                str6 = str4;
                str3 = str10;
                th2 = th;
            } catch (Throwable th24) {
                String str20 = str12;
                obj2 = coroutine_suspended;
                str6 = str20;
                file3 = file2;
                s3Client4 = s3Client2;
                createMultipartUploadResponse2 = createMultipartUploadResponse;
                str3 = uploadId;
                closeable = randomAccessFile4;
                th2 = th24;
                str5 = str13;
                map3 = map2;
                list = arrayList;
                uploadListener3 = uploadListener2;
                j = length;
            }
        } catch (Throwable th25) {
            String str21 = str12;
            obj2 = coroutine_suspended;
            th = th25;
            s3Client3 = s3Client2;
            str3 = uploadId;
            str4 = str21;
            str5 = str13;
            file3 = file2;
            map3 = map2;
            list = arrayList;
            uploadListener3 = uploadListener2;
            j = length;
            Result.Companion companion2222 = Result.INSTANCE;
            AbortMultipartUploadRequest abortMultipartUploadRequestInvoke2222 = AbortMultipartUploadRequest.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return S3Client.multipartUpload$lambda$4$0(str4, str5, str3, (AbortMultipartUploadRequest.Builder) obj4);
                }
            });
            c62821.L$0 = SpillingKt.nullOutSpilledVariable(s3Client3);
            c62821.L$1 = SpillingKt.nullOutSpilledVariable(file3);
            c62821.L$2 = SpillingKt.nullOutSpilledVariable(str4);
            c62821.L$3 = SpillingKt.nullOutSpilledVariable(str5);
            c62821.L$4 = SpillingKt.nullOutSpilledVariable(map3);
            c62821.L$5 = SpillingKt.nullOutSpilledVariable(uploadListener3);
            c62821.L$6 = SpillingKt.nullOutSpilledVariable(createMultipartUploadResponse);
            c62821.L$7 = SpillingKt.nullOutSpilledVariable(str3);
            c62821.L$8 = SpillingKt.nullOutSpilledVariable(list);
            c62821.L$9 = th;
            c62821.L$10 = SpillingKt.nullOutSpilledVariable(this);
            c62821.L$11 = null;
            c62821.L$12 = null;
            c62821.L$13 = null;
            c62821.J$0 = j;
            c62821.I$0 = 0;
            c62821.label = 4;
            objAbortMultipartUpload = s3Client3.abortMultipartUpload(abortMultipartUploadRequestInvoke2222, c62821);
            if (objAbortMultipartUpload == obj2) {
                return obj2;
            }
            th5 = th;
            Result.m14499constructorimpl((AbortMultipartUploadResponse) objAbortMultipartUpload);
            throw th5;
        }
        throw th2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit multipartUpload$lambda$0(String str, String str2, Map map, CreateMultipartUploadRequest.Builder CreateMultipartUploadRequest) {
        Intrinsics.checkNotNullParameter(CreateMultipartUploadRequest, "$this$CreateMultipartUploadRequest");
        CreateMultipartUploadRequest.setBucket(str);
        CreateMultipartUploadRequest.setKey(str2);
        CreateMultipartUploadRequest.setContentType(CONTENT_TYPE);
        CreateMultipartUploadRequest.setContentDisposition(CONTENT_DISPOSITION);
        CreateMultipartUploadRequest.setMetadata(map);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit multipartUpload$lambda$2$0(String str, String str2, String str3, Ref.IntRef intRef, byte[] bArr, UploadPartRequest.Builder UploadPartRequest) {
        Intrinsics.checkNotNullParameter(UploadPartRequest, "$this$UploadPartRequest");
        UploadPartRequest.setBucket(str);
        UploadPartRequest.setKey(str2);
        UploadPartRequest.setUploadId(str3);
        UploadPartRequest.setPartNumber(Integer.valueOf(intRef.element));
        UploadPartRequest.setBody(ByteStream.INSTANCE.fromBytes(bArr));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit multipartUpload$lambda$2$1(Ref.IntRef intRef, UploadPartResponse uploadPartResponse, CompletedPart.Builder CompletedPart) {
        Intrinsics.checkNotNullParameter(CompletedPart, "$this$CompletedPart");
        CompletedPart.setPartNumber(Integer.valueOf(intRef.element));
        CompletedPart.setETag(uploadPartResponse.getETag());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit multipartUpload$lambda$3(String str, String str2, String str3, final List list, CompleteMultipartUploadRequest.Builder CompleteMultipartUploadRequest) {
        Intrinsics.checkNotNullParameter(CompleteMultipartUploadRequest, "$this$CompleteMultipartUploadRequest");
        CompleteMultipartUploadRequest.setBucket(str);
        CompleteMultipartUploadRequest.setKey(str2);
        CompleteMultipartUploadRequest.setUploadId(str3);
        CompleteMultipartUploadRequest.setMultipartUpload(CompletedMultipartUpload.INSTANCE.invoke(new Function1() { // from class: com.myscript.nebo.dms.sharepage.amazon.S3Client$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return S3Client.multipartUpload$lambda$3$0(list, (CompletedMultipartUpload.Builder) obj);
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit multipartUpload$lambda$3$0(List list, CompletedMultipartUpload.Builder CompletedMultipartUpload) {
        Intrinsics.checkNotNullParameter(CompletedMultipartUpload, "$this$CompletedMultipartUpload");
        CompletedMultipartUpload.setParts(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit multipartUpload$lambda$4$0(String str, String str2, String str3, AbortMultipartUploadRequest.Builder AbortMultipartUploadRequest) {
        Intrinsics.checkNotNullParameter(AbortMultipartUploadRequest, "$this$AbortMultipartUploadRequest");
        AbortMultipartUploadRequest.setBucket(str);
        AbortMultipartUploadRequest.setKey(str2);
        AbortMultipartUploadRequest.setUploadId(str3);
        return Unit.INSTANCE;
    }
}
