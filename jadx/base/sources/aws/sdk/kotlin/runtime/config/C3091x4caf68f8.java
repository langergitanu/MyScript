package aws.sdk.kotlin.runtime.config;

import androidx.media3.extractor.p007ts.TsExtractor;
import aws.sdk.kotlin.runtime.config.AwsSdkClientConfig;
import aws.sdk.kotlin.runtime.config.auth.ResolveAuthSchemePreferenceKt;
import aws.sdk.kotlin.runtime.config.checksums.ResolveFlexibleChecksumsConfigKt;
import aws.sdk.kotlin.runtime.config.compression.RequestCompressionResolversKt;
import aws.sdk.kotlin.runtime.config.endpoints.ResolversKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt;
import aws.sdk.kotlin.runtime.config.useragent.ResolveUserAgentKt;
import aws.sdk.kotlin.runtime.region.ResolveRegionKt;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awscredentials.SigV4aClientConfig;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.RetryStrategyClientConfig;
import aws.smithy.kotlin.runtime.client.SdkClient;
import aws.smithy.kotlin.runtime.client.SdkClientConfig;
import aws.smithy.kotlin.runtime.client.config.ClientSettings;
import aws.smithy.kotlin.runtime.client.config.CompressionClientConfig;
import aws.smithy.kotlin.runtime.client.config.HttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.RequestCompressionConfig;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.http.auth.HttpAuthConfig;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.joda.time.DateTimeConstants;

/* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory$fromEnvironment$$inlined$withSpan$default$1 */
/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/telemetry/trace/CoroutineContextTraceExtKt$withSpan$3"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory$fromEnvironment$$inlined$withSpan$default$1", m1609f = "AbstractAwsSdkClientFactory.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12}, m1611l = {PDFACompliance.e_PDFA1_3_3, TsExtractor.TS_STREAM_TYPE_DTS_UHD, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 140, PDFACompliance.e_PDFA1_4_1, PDFACompliance.e_PDFA1_4_2, 147, 151, 156, PDFACompliance.e_PDFA1_6_1, 164, DateTimeConstants.HOURS_PER_WEEK, 172}, m1612m = "invokeSuspend", m1613n = {"$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2", "$this$withContext", "$completion", "it", "$this$fromEnvironment_u24lambda_u240", DeviceDimensionProvider.KEY_PLATFORM, "sharedConfig", "profile", "$i$a$-withSpan$default-AbstractAwsSdkClientFactory$fromEnvironment$2"}, m1614nl = {TsExtractor.TS_STREAM_TYPE_DTS_HD, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 140, PDFACompliance.e_PDFA1_4_1, PDFACompliance.e_PDFA1_4_2, 144, 145, 149, 155, 160, 163, PDFACompliance.e_PDFA1_7_1, PDFACompliance.e_PDFA1_7_3}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, m1616v = 2)
public final class C3091x4caf68f8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $block$inlined;
    final /* synthetic */ SdkClient.Builder $builder$inlined;
    final /* synthetic */ SdkClientConfig.Builder $config$inlined;
    final /* synthetic */ TraceSpan $span;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ AbstractAwsSdkClientFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3091x4caf68f8(TraceSpan traceSpan, Continuation continuation, SdkClientConfig.Builder builder, Function1 function1, AbstractAwsSdkClientFactory abstractAwsSdkClientFactory, SdkClient.Builder builder2) {
        super(2, continuation);
        this.$span = traceSpan;
        this.$config$inlined = builder;
        this.$block$inlined = function1;
        this.this$0 = abstractAwsSdkClientFactory;
        this.$builder$inlined = builder2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C3091x4caf68f8 c3091x4caf68f8 = new C3091x4caf68f8(this.$span, continuation, this.$config$inlined, this.$block$inlined, this.this$0, this.$builder$inlined);
        c3091x4caf68f8.L$0 = obj;
        return c3091x4caf68f8;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C3091x4caf68f8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0508, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0550, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0599, code lost:
    
        if (r14.finalizeEnvironmentalConfig(r3, r6, r5, r13) == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x02a0, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02d3, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0312, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x03f7, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0440, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0484, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x04c8, code lost:
    
        if (r14 == r1) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0511 A[PHI: r2 r5 r6 r7 r8 r9 r10
      0x0511: PHI (r2v41 int) = (r2v34 int), (r2v42 int) binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]
      0x0511: PHI (r5v60 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r5v51 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r5v61 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]
      0x0511: PHI (r6v47 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r6v38 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r6v48 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]
      0x0511: PHI (r7v47 aws.smithy.kotlin.runtime.util.PlatformProvider) = (r7v38 aws.smithy.kotlin.runtime.util.PlatformProvider), (r7v48 aws.smithy.kotlin.runtime.util.PlatformProvider) binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]
      0x0511: PHI (r8v47 kotlinx.coroutines.CoroutineScope) = (r8v38 kotlinx.coroutines.CoroutineScope), (r8v48 kotlinx.coroutines.CoroutineScope) binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]
      0x0511: PHI (r9v49 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r9v40 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r9v50 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]
      0x0511: PHI (r10v47 kotlin.coroutines.Continuation) = (r10v38 kotlin.coroutines.Continuation), (r10v48 kotlin.coroutines.Continuation) binds: [B:93:0x0491, B:106:0x050e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0558 A[PHI: r2 r5 r6 r7 r8 r9 r10
      0x0558: PHI (r2v45 int) = (r2v41 int), (r2v46 int) binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]
      0x0558: PHI (r5v65 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r5v60 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r5v66 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]
      0x0558: PHI (r6v52 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r6v47 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r6v53 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]
      0x0558: PHI (r7v52 aws.smithy.kotlin.runtime.util.PlatformProvider) = (r7v47 aws.smithy.kotlin.runtime.util.PlatformProvider), (r7v53 aws.smithy.kotlin.runtime.util.PlatformProvider) binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]
      0x0558: PHI (r8v52 kotlinx.coroutines.CoroutineScope) = (r8v47 kotlinx.coroutines.CoroutineScope), (r8v53 kotlinx.coroutines.CoroutineScope) binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]
      0x0558: PHI (r9v54 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r9v49 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r9v55 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]
      0x0558: PHI (r10v52 kotlin.coroutines.Continuation) = (r10v47 kotlin.coroutines.Continuation), (r10v53 kotlin.coroutines.Continuation) binds: [B:108:0x0515, B:115:0x0555] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02d9 A[PHI: r2 r5 r6 r7 r8 r9 r10 r11 r14
      0x02d9: PHI (r2v15 int) = (r2v9 int), (r2v12 int), (r2v16 int) binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r5v18 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder) = 
      (r5v5 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
      (r5v14 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
      (r5v21 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
     binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r6v9 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r6v1 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r6v5 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r6v10 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r7v9 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r7v1 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r7v5 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r7v10 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r8v9 aws.smithy.kotlin.runtime.util.PlatformProvider) = 
      (r8v1 aws.smithy.kotlin.runtime.util.PlatformProvider)
      (r8v5 aws.smithy.kotlin.runtime.util.PlatformProvider)
      (r8v10 aws.smithy.kotlin.runtime.util.PlatformProvider)
     binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r9v11 kotlinx.coroutines.CoroutineScope) = 
      (r9v3 kotlinx.coroutines.CoroutineScope)
      (r9v7 kotlinx.coroutines.CoroutineScope)
      (r9v12 kotlinx.coroutines.CoroutineScope)
     binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r10v9 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r10v1 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r10v5 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r10v10 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r11v10 kotlin.coroutines.Continuation) = (r11v2 kotlin.coroutines.Continuation), (r11v6 kotlin.coroutines.Continuation), (r11v11 kotlin.coroutines.Continuation) binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]
      0x02d9: PHI (r14v30 java.lang.String) = (r14v13 java.lang.String), (r14v21 java.lang.String), (r14v41 java.lang.String) binds: [B:34:0x026b, B:42:0x02a8, B:46:0x02d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0318 A[PHI: r2 r5 r6 r7 r8 r9 r10 r11 r14
      0x0318: PHI (r2v18 int) = (r2v15 int), (r2v19 int) binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r5v24 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder) = 
      (r5v20 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
      (r5v28 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
     binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r6v13 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r6v9 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r6v15 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r7v13 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r7v9 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r7v15 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r8v13 aws.smithy.kotlin.runtime.util.PlatformProvider) = (r8v9 aws.smithy.kotlin.runtime.util.PlatformProvider), (r8v15 aws.smithy.kotlin.runtime.util.PlatformProvider) binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r9v15 kotlinx.coroutines.CoroutineScope) = (r9v11 kotlinx.coroutines.CoroutineScope), (r9v17 kotlinx.coroutines.CoroutineScope) binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r10v13 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r10v9 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r10v15 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r11v14 kotlin.coroutines.Continuation) = (r11v10 kotlin.coroutines.Continuation), (r11v15 kotlin.coroutines.Continuation) binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0318: PHI (r14v42 java.lang.Boolean) = (r14v33 java.lang.Boolean), (r14v53 java.lang.Boolean) binds: [B:48:0x02e7, B:52:0x0316] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0365 A[PHI: r2 r5 r6 r7 r8 r9 r10 r11 r14
      0x0365: PHI (r2v21 int) = (r2v18 int), (r2v22 int) binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r5v31 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder) = 
      (r5v26 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
      (r5v35 aws.sdk.kotlin.runtime.config.AwsSdkClientConfig$Builder)
     binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r6v18 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r6v13 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r6v22 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r7v18 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r7v13 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r7v22 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r8v18 aws.smithy.kotlin.runtime.util.PlatformProvider) = (r8v13 aws.smithy.kotlin.runtime.util.PlatformProvider), (r8v22 aws.smithy.kotlin.runtime.util.PlatformProvider) binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r9v20 kotlinx.coroutines.CoroutineScope) = (r9v15 kotlinx.coroutines.CoroutineScope), (r9v24 kotlinx.coroutines.CoroutineScope) binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r10v18 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r10v13 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r10v22 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r11v18 kotlin.coroutines.Continuation) = (r11v14 kotlin.coroutines.Continuation), (r11v19 kotlin.coroutines.Continuation) binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]
      0x0365: PHI (r14v54 java.lang.Boolean) = (r14v45 java.lang.Boolean), (r14v65 java.lang.Boolean) binds: [B:54:0x0326, B:59:0x035c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0449 A[PHI: r2 r5 r6 r7 r8 r9 r10
      0x0449: PHI (r2v30 int) = (r2v24 int), (r2v31 int) binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]
      0x0449: PHI (r5v46 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r5v38 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r5v47 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]
      0x0449: PHI (r6v33 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r6v25 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r6v34 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]
      0x0449: PHI (r7v33 aws.smithy.kotlin.runtime.util.PlatformProvider) = (r7v25 aws.smithy.kotlin.runtime.util.PlatformProvider), (r7v34 aws.smithy.kotlin.runtime.util.PlatformProvider) binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]
      0x0449: PHI (r8v33 kotlinx.coroutines.CoroutineScope) = (r8v25 kotlinx.coroutines.CoroutineScope), (r8v34 kotlinx.coroutines.CoroutineScope) binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]
      0x0449: PHI (r9v35 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r9v27 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r9v36 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]
      0x0449: PHI (r10v33 kotlin.coroutines.Continuation) = (r10v25 kotlin.coroutines.Continuation), (r10v34 kotlin.coroutines.Continuation) binds: [B:69:0x03b8, B:82:0x0446] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x048d A[PHI: r2 r5 r6 r7 r8 r9 r10
      0x048d: PHI (r2v34 int) = (r2v30 int), (r2v35 int) binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]
      0x048d: PHI (r5v51 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>) = 
      (r5v46 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
      (r5v52 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.ConfigSection>)
     binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]
      0x048d: PHI (r6v38 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>) = 
      (r6v33 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
      (r6v39 aws.smithy.kotlin.runtime.util.LazyAsyncValue<aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig>)
     binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]
      0x048d: PHI (r7v38 aws.smithy.kotlin.runtime.util.PlatformProvider) = (r7v33 aws.smithy.kotlin.runtime.util.PlatformProvider), (r7v39 aws.smithy.kotlin.runtime.util.PlatformProvider) binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]
      0x048d: PHI (r8v38 kotlinx.coroutines.CoroutineScope) = (r8v33 kotlinx.coroutines.CoroutineScope), (r8v39 kotlinx.coroutines.CoroutineScope) binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]
      0x048d: PHI (r9v40 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan) = 
      (r9v35 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
      (r9v41 aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan)
     binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]
      0x048d: PHI (r10v38 kotlin.coroutines.Continuation) = (r10v33 kotlin.coroutines.Continuation), (r10v39 kotlin.coroutines.Continuation) binds: [B:84:0x044d, B:91:0x048a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0493  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TraceSpan traceSpan;
        C3091x4caf68f8 c3091x4caf68f8;
        PlatformProvider system;
        LazyAsyncValue<AwsSharedConfig> lazyAsyncValueAsyncLazy;
        LazyAsyncValue<ConfigSection> lazyAsyncValueAsyncLazy2;
        CoroutineScope coroutineScope;
        int i;
        RetryStrategyClientConfig.Builder builder;
        Function1 function1;
        LogMode logMode;
        AwsSdkClientConfig.Builder builder2;
        String region;
        AwsSdkClientConfig.Builder builder3;
        Boolean useFips;
        AwsSdkClientConfig.Builder builder4;
        Boolean useDualStack;
        AwsSdkClientConfig.Builder builder5;
        LazyAsyncValue<ConfigSection> lazyAsyncValue;
        LazyAsyncValue<AwsSharedConfig> lazyAsyncValue2;
        PlatformProvider platformProvider;
        CoroutineScope coroutineScope2;
        TraceSpan traceSpan2;
        Continuation continuation;
        AwsSdkClientConfig.Builder builder6;
        String applicationId;
        LazyAsyncValue<ConfigSection> lazyAsyncValue3;
        LazyAsyncValue<AwsSharedConfig> lazyAsyncValue4;
        PlatformProvider platformProvider2;
        CoroutineScope coroutineScope3;
        TraceSpan traceSpan3;
        Continuation continuation2;
        SdkClientConfig.Builder builder7;
        RequestCompressionConfig.Builder requestCompression;
        Boolean disableRequestCompression;
        RequestCompressionConfig.Builder requestCompression2;
        Long requestMinCompressionSizeBytes;
        SdkClientConfig.Builder builder8;
        SigV4aClientConfig.Builder builder9;
        Set<String> sigV4aSigningRegionSet;
        SdkClientConfig.Builder builder10;
        HttpChecksumConfig.Builder builder11;
        RequestHttpChecksumConfig requestChecksumCalculation;
        HttpChecksumConfig.Builder builder12;
        ResponseHttpChecksumConfig responseChecksumValidation;
        SdkClientConfig.Builder builder13;
        HttpAuthConfig.Builder builder14;
        List<AuthSchemeId> authSchemePreference;
        CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                traceSpan = this.$span;
                c3091x4caf68f8 = this;
                system = PlatformProvider.INSTANCE.getSystem();
                lazyAsyncValueAsyncLazy = LazyAsyncValueKt.asyncLazy(new AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1(system, null));
                lazyAsyncValueAsyncLazy2 = LazyAsyncValueKt.asyncLazy(new AbstractAwsSdkClientFactory$fromEnvironment$2$profile$1(lazyAsyncValueAsyncLazy, null));
                SdkClientConfig.Builder builder15 = this.$config$inlined;
                if (!(builder15 instanceof RetryStrategyClientConfig.Builder)) {
                    coroutineScope = coroutineScope4;
                    i = 0;
                    function1 = this.$block$inlined;
                    if (function1 != null) {
                    }
                    SdkClientConfig.Builder builder16 = this.$config$inlined;
                    logMode = builder16.getLogMode();
                    if (logMode == null) {
                    }
                    builder16.setLogMode(logMode);
                    SdkClientConfig.Builder builder17 = this.$config$inlined;
                    builder2 = (AwsSdkClientConfig.Builder) builder17;
                    region = ((AwsSdkClientConfig.Builder) builder17).getRegion();
                    if (region != null) {
                    }
                    return coroutine_suspended;
                }
                RetryStrategyClientConfig.Builder builder18 = (RetryStrategyClientConfig.Builder) builder15;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                this.L$1 = SpillingKt.nullOutSpilledVariable(c3091x4caf68f8);
                this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
                this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                this.L$4 = system;
                this.L$5 = lazyAsyncValueAsyncLazy;
                this.L$6 = lazyAsyncValueAsyncLazy2;
                this.L$7 = builder18;
                this.I$0 = 0;
                this.label = 1;
                Object objResolveRetryStrategy$default = ResolveRetryStrategyKt.resolveRetryStrategy$default(null, lazyAsyncValueAsyncLazy2, this, 1, null);
                if (objResolveRetryStrategy$default != coroutine_suspended) {
                    builder = builder18;
                    obj = objResolveRetryStrategy$default;
                    i = 0;
                    coroutineScope = coroutineScope4;
                    builder.setRetryStrategy((RetryStrategy) obj);
                    function1 = this.$block$inlined;
                    if (function1 != null) {
                        function1.invoke(this.$config$inlined);
                    }
                    SdkClientConfig.Builder builder162 = this.$config$inlined;
                    logMode = builder162.getLogMode();
                    if (logMode == null) {
                        logMode = (LogMode) EnvironmentSettingKt.resolve(ClientSettings.INSTANCE.getLogMode(), system);
                    }
                    builder162.setLogMode(logMode);
                    SdkClientConfig.Builder builder172 = this.$config$inlined;
                    builder2 = (AwsSdkClientConfig.Builder) builder172;
                    region = ((AwsSdkClientConfig.Builder) builder172).getRegion();
                    if (region != null) {
                        builder2.setRegion(region);
                        SdkClientConfig.Builder builder19 = this.$config$inlined;
                        builder3 = (AwsSdkClientConfig.Builder) builder19;
                        useFips = ((AwsSdkClientConfig.Builder) builder19).getUseFips();
                        if (useFips != null) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(c3091x4caf68f8);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$4 = system;
                            this.L$5 = lazyAsyncValueAsyncLazy;
                            this.L$6 = lazyAsyncValueAsyncLazy2;
                            this.L$7 = builder3;
                            this.I$0 = i;
                            this.label = 4;
                            obj = ResolversKt.resolveUseFips$default(null, lazyAsyncValueAsyncLazy2, this, 1, null);
                            break;
                        } else {
                            builder3.setUseFips(useFips);
                            SdkClientConfig.Builder builder20 = this.$config$inlined;
                            builder4 = (AwsSdkClientConfig.Builder) builder20;
                            useDualStack = ((AwsSdkClientConfig.Builder) builder20).getUseDualStack();
                            if (useDualStack != null) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(c3091x4caf68f8);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                this.L$4 = system;
                                this.L$5 = lazyAsyncValueAsyncLazy;
                                this.L$6 = lazyAsyncValueAsyncLazy2;
                                this.L$7 = builder4;
                                this.I$0 = i;
                                this.label = 5;
                                obj = ResolversKt.resolveUseDualStack$default(null, lazyAsyncValueAsyncLazy2, this, 1, null);
                                if (obj != coroutine_suspended) {
                                    builder5 = builder4;
                                    lazyAsyncValue = lazyAsyncValueAsyncLazy2;
                                    lazyAsyncValue2 = lazyAsyncValueAsyncLazy;
                                    platformProvider = system;
                                    coroutineScope2 = coroutineScope;
                                    traceSpan2 = traceSpan;
                                    continuation = c3091x4caf68f8;
                                    useDualStack = (Boolean) obj;
                                    c3091x4caf68f8 = continuation;
                                    traceSpan = traceSpan2;
                                    coroutineScope = coroutineScope2;
                                    system = platformProvider;
                                    lazyAsyncValueAsyncLazy = lazyAsyncValue2;
                                    lazyAsyncValueAsyncLazy2 = lazyAsyncValue;
                                    builder4 = builder5;
                                    builder4.setUseDualStack(useDualStack);
                                    SdkClientConfig.Builder builder21 = this.$config$inlined;
                                    builder6 = (AwsSdkClientConfig.Builder) builder21;
                                    applicationId = ((AwsSdkClientConfig.Builder) builder21).getApplicationId();
                                    if (applicationId == null) {
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(c3091x4caf68f8);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                        this.L$4 = system;
                                        this.L$5 = lazyAsyncValueAsyncLazy;
                                        this.L$6 = lazyAsyncValueAsyncLazy2;
                                        this.L$7 = builder6;
                                        this.I$0 = i;
                                        this.label = 6;
                                        obj = ResolveUserAgentKt.resolveUserAgentAppId(system, lazyAsyncValueAsyncLazy2, this);
                                        if (obj != coroutine_suspended) {
                                            lazyAsyncValue3 = lazyAsyncValueAsyncLazy2;
                                            lazyAsyncValue4 = lazyAsyncValueAsyncLazy;
                                            platformProvider2 = system;
                                            coroutineScope3 = coroutineScope;
                                            traceSpan3 = traceSpan;
                                            continuation2 = c3091x4caf68f8;
                                            applicationId = (String) obj;
                                            builder6.setApplicationId(applicationId);
                                            builder7 = this.$config$inlined;
                                            if (builder7 instanceof CompressionClientConfig.Builder) {
                                                requestCompression = ((CompressionClientConfig.Builder) builder7).getRequestCompression();
                                                disableRequestCompression = ((CompressionClientConfig.Builder) this.$config$inlined).getRequestCompression().getDisableRequestCompression();
                                                if (disableRequestCompression != null) {
                                                    requestCompression.setDisableRequestCompression(disableRequestCompression);
                                                    requestCompression2 = ((CompressionClientConfig.Builder) this.$config$inlined).getRequestCompression();
                                                    requestMinCompressionSizeBytes = ((CompressionClientConfig.Builder) this.$config$inlined).getRequestCompression().getRequestMinCompressionSizeBytes();
                                                    if (requestMinCompressionSizeBytes == null) {
                                                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                        this.L$4 = platformProvider2;
                                                        this.L$5 = lazyAsyncValue4;
                                                        this.L$6 = lazyAsyncValue3;
                                                        this.L$7 = requestCompression2;
                                                        this.I$0 = i;
                                                        this.label = 8;
                                                        obj = RequestCompressionResolversKt.resolveRequestMinCompressionSizeBytes(platformProvider2, lazyAsyncValue3, this);
                                                    }
                                                    requestCompression2.setRequestMinCompressionSizeBytes(requestMinCompressionSizeBytes);
                                                    builder8 = this.$config$inlined;
                                                    if (!(builder8 instanceof SigV4aClientConfig.Builder)) {
                                                        builder9 = (SigV4aClientConfig.Builder) builder8;
                                                        sigV4aSigningRegionSet = ((SigV4aClientConfig.Builder) builder8).getSigV4aSigningRegionSet();
                                                        if (sigV4aSigningRegionSet == null) {
                                                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                            this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                            this.L$4 = platformProvider2;
                                                            this.L$5 = lazyAsyncValue4;
                                                            this.L$6 = lazyAsyncValue3;
                                                            this.L$7 = builder9;
                                                            this.I$0 = i;
                                                            this.label = 9;
                                                            obj = ResolveRegionKt.resolveSigV4aSigningRegionSet(platformProvider2, lazyAsyncValue3, this);
                                                        }
                                                        builder9.setSigV4aSigningRegionSet(sigV4aSigningRegionSet);
                                                        builder10 = this.$config$inlined;
                                                        if (builder10 instanceof HttpChecksumConfig.Builder) {
                                                            builder11 = (HttpChecksumConfig.Builder) builder10;
                                                            requestChecksumCalculation = ((HttpChecksumConfig.Builder) builder10).getRequestChecksumCalculation();
                                                            if (requestChecksumCalculation != null) {
                                                                builder11.setRequestChecksumCalculation(requestChecksumCalculation);
                                                                SdkClientConfig.Builder builder22 = this.$config$inlined;
                                                                builder12 = (HttpChecksumConfig.Builder) builder22;
                                                                responseChecksumValidation = ((HttpChecksumConfig.Builder) builder22).getResponseChecksumValidation();
                                                                if (responseChecksumValidation == null) {
                                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                                    this.L$4 = platformProvider2;
                                                                    this.L$5 = lazyAsyncValue4;
                                                                    this.L$6 = lazyAsyncValue3;
                                                                    this.L$7 = builder12;
                                                                    this.I$0 = i;
                                                                    this.label = 11;
                                                                    obj = ResolveFlexibleChecksumsConfigKt.resolveResponseChecksumValidation(platformProvider2, lazyAsyncValue3, this);
                                                                }
                                                                builder12.setResponseChecksumValidation(responseChecksumValidation);
                                                                builder13 = this.$config$inlined;
                                                                if (!(builder13 instanceof HttpAuthConfig.Builder)) {
                                                                    builder14 = (HttpAuthConfig.Builder) builder13;
                                                                    authSchemePreference = ((HttpAuthConfig.Builder) builder13).getAuthSchemePreference();
                                                                    if (authSchemePreference == null) {
                                                                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(platformProvider2);
                                                                        this.L$5 = lazyAsyncValue4;
                                                                        this.L$6 = lazyAsyncValue3;
                                                                        this.L$7 = builder14;
                                                                        this.I$0 = i;
                                                                        this.label = 12;
                                                                        obj = ResolveAuthSchemePreferenceKt.resolveAuthSchemePreference(platformProvider2, lazyAsyncValue3, this);
                                                                    }
                                                                    builder14.setAuthSchemePreference(authSchemePreference);
                                                                    this.this$0.finalizeConfig(this.$builder$inlined);
                                                                    AbstractAwsSdkClientFactory abstractAwsSdkClientFactory = this.this$0;
                                                                    SdkClient.Builder builder23 = this.$builder$inlined;
                                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(platformProvider2);
                                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue4);
                                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
                                                                    this.L$7 = null;
                                                                    this.I$0 = i;
                                                                    this.label = 13;
                                                                } else {
                                                                    this.this$0.finalizeConfig(this.$builder$inlined);
                                                                    AbstractAwsSdkClientFactory abstractAwsSdkClientFactory2 = this.this$0;
                                                                    SdkClient.Builder builder232 = this.$builder$inlined;
                                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(platformProvider2);
                                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue4);
                                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
                                                                    this.L$7 = null;
                                                                    this.I$0 = i;
                                                                    this.label = 13;
                                                                }
                                                            } else {
                                                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                                this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                                this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                                this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                                this.L$4 = platformProvider2;
                                                                this.L$5 = lazyAsyncValue4;
                                                                this.L$6 = lazyAsyncValue3;
                                                                this.L$7 = builder11;
                                                                this.I$0 = i;
                                                                this.label = 10;
                                                                obj = ResolveFlexibleChecksumsConfigKt.resolveRequestChecksumCalculation(platformProvider2, lazyAsyncValue3, this);
                                                            }
                                                            break;
                                                        } else {
                                                            builder13 = this.$config$inlined;
                                                            if (!(builder13 instanceof HttpAuthConfig.Builder)) {
                                                            }
                                                        }
                                                        break;
                                                    } else {
                                                        builder10 = this.$config$inlined;
                                                        if (builder10 instanceof HttpChecksumConfig.Builder) {
                                                        }
                                                    }
                                                } else {
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                                                    this.L$4 = platformProvider2;
                                                    this.L$5 = lazyAsyncValue4;
                                                    this.L$6 = lazyAsyncValue3;
                                                    this.L$7 = requestCompression;
                                                    this.I$0 = i;
                                                    this.label = 7;
                                                    obj = RequestCompressionResolversKt.resolveDisableRequestCompression(platformProvider2, lazyAsyncValue3, this);
                                                }
                                                break;
                                            } else {
                                                builder8 = this.$config$inlined;
                                                if (!(builder8 instanceof SigV4aClientConfig.Builder)) {
                                                }
                                            }
                                        }
                                    } else {
                                        lazyAsyncValue3 = lazyAsyncValueAsyncLazy2;
                                        lazyAsyncValue4 = lazyAsyncValueAsyncLazy;
                                        platformProvider2 = system;
                                        coroutineScope3 = coroutineScope;
                                        traceSpan3 = traceSpan;
                                        continuation2 = c3091x4caf68f8;
                                        builder6.setApplicationId(applicationId);
                                        builder7 = this.$config$inlined;
                                        if (builder7 instanceof CompressionClientConfig.Builder) {
                                        }
                                    }
                                }
                            } else {
                                builder4.setUseDualStack(useDualStack);
                                SdkClientConfig.Builder builder212 = this.$config$inlined;
                                builder6 = (AwsSdkClientConfig.Builder) builder212;
                                applicationId = ((AwsSdkClientConfig.Builder) builder212).getApplicationId();
                                if (applicationId == null) {
                                }
                            }
                        }
                    } else {
                        RegionProvider regionProvider = ((AwsSdkClientConfig.Builder) this.$config$inlined).getRegionProvider();
                        if (regionProvider != null) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(c3091x4caf68f8);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.L$4 = system;
                            this.L$5 = lazyAsyncValueAsyncLazy;
                            this.L$6 = lazyAsyncValueAsyncLazy2;
                            this.L$7 = builder2;
                            this.I$0 = i;
                            this.label = 2;
                            obj = regionProvider.getRegion(this);
                            break;
                        } else {
                            region = null;
                            if (region != null) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(c3091x4caf68f8);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                this.L$4 = system;
                                this.L$5 = lazyAsyncValueAsyncLazy;
                                this.L$6 = lazyAsyncValueAsyncLazy2;
                                this.L$7 = builder2;
                                this.I$0 = i;
                                this.label = 3;
                                obj = ResolveRegionKt.resolveRegion$default(null, lazyAsyncValueAsyncLazy2, this, 1, null);
                                break;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                i = this.I$0;
                builder = (RetryStrategyClientConfig.Builder) this.L$7;
                lazyAsyncValueAsyncLazy2 = (LazyAsyncValue) this.L$6;
                lazyAsyncValueAsyncLazy = (LazyAsyncValue) this.L$5;
                system = (PlatformProvider) this.L$4;
                coroutineScope = (CoroutineScope) this.L$3;
                traceSpan = (TraceSpan) this.L$2;
                c3091x4caf68f8 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                builder.setRetryStrategy((RetryStrategy) obj);
                function1 = this.$block$inlined;
                if (function1 != null) {
                }
                SdkClientConfig.Builder builder1622 = this.$config$inlined;
                logMode = builder1622.getLogMode();
                if (logMode == null) {
                }
                builder1622.setLogMode(logMode);
                SdkClientConfig.Builder builder1722 = this.$config$inlined;
                builder2 = (AwsSdkClientConfig.Builder) builder1722;
                region = ((AwsSdkClientConfig.Builder) builder1722).getRegion();
                if (region != null) {
                }
                return coroutine_suspended;
            case 2:
                i = this.I$0;
                builder2 = (AwsSdkClientConfig.Builder) this.L$7;
                lazyAsyncValueAsyncLazy2 = (LazyAsyncValue) this.L$6;
                lazyAsyncValueAsyncLazy = (LazyAsyncValue) this.L$5;
                system = (PlatformProvider) this.L$4;
                coroutineScope = (CoroutineScope) this.L$3;
                traceSpan = (TraceSpan) this.L$2;
                c3091x4caf68f8 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                region = (String) obj;
                if (region != null) {
                }
                return coroutine_suspended;
            case 3:
                i = this.I$0;
                builder2 = (AwsSdkClientConfig.Builder) this.L$7;
                lazyAsyncValueAsyncLazy2 = (LazyAsyncValue) this.L$6;
                lazyAsyncValueAsyncLazy = (LazyAsyncValue) this.L$5;
                system = (PlatformProvider) this.L$4;
                coroutineScope = (CoroutineScope) this.L$3;
                traceSpan = (TraceSpan) this.L$2;
                c3091x4caf68f8 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                region = (String) obj;
                builder2.setRegion(region);
                SdkClientConfig.Builder builder192 = this.$config$inlined;
                builder3 = (AwsSdkClientConfig.Builder) builder192;
                useFips = ((AwsSdkClientConfig.Builder) builder192).getUseFips();
                if (useFips != null) {
                }
                return coroutine_suspended;
            case 4:
                i = this.I$0;
                builder3 = (AwsSdkClientConfig.Builder) this.L$7;
                lazyAsyncValueAsyncLazy2 = (LazyAsyncValue) this.L$6;
                lazyAsyncValueAsyncLazy = (LazyAsyncValue) this.L$5;
                system = (PlatformProvider) this.L$4;
                coroutineScope = (CoroutineScope) this.L$3;
                traceSpan = (TraceSpan) this.L$2;
                c3091x4caf68f8 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                useFips = (Boolean) obj;
                builder3.setUseFips(useFips);
                SdkClientConfig.Builder builder202 = this.$config$inlined;
                builder4 = (AwsSdkClientConfig.Builder) builder202;
                useDualStack = ((AwsSdkClientConfig.Builder) builder202).getUseDualStack();
                if (useDualStack != null) {
                }
                return coroutine_suspended;
            case 5:
                i = this.I$0;
                builder5 = (AwsSdkClientConfig.Builder) this.L$7;
                lazyAsyncValue = (LazyAsyncValue) this.L$6;
                lazyAsyncValue2 = (LazyAsyncValue) this.L$5;
                platformProvider = (PlatformProvider) this.L$4;
                coroutineScope2 = (CoroutineScope) this.L$3;
                traceSpan2 = (TraceSpan) this.L$2;
                continuation = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                useDualStack = (Boolean) obj;
                c3091x4caf68f8 = continuation;
                traceSpan = traceSpan2;
                coroutineScope = coroutineScope2;
                system = platformProvider;
                lazyAsyncValueAsyncLazy = lazyAsyncValue2;
                lazyAsyncValueAsyncLazy2 = lazyAsyncValue;
                builder4 = builder5;
                builder4.setUseDualStack(useDualStack);
                SdkClientConfig.Builder builder2122 = this.$config$inlined;
                builder6 = (AwsSdkClientConfig.Builder) builder2122;
                applicationId = ((AwsSdkClientConfig.Builder) builder2122).getApplicationId();
                if (applicationId == null) {
                }
                break;
            case 6:
                i = this.I$0;
                builder6 = (AwsSdkClientConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                applicationId = (String) obj;
                builder6.setApplicationId(applicationId);
                builder7 = this.$config$inlined;
                if (builder7 instanceof CompressionClientConfig.Builder) {
                }
                return coroutine_suspended;
            case 7:
                i = this.I$0;
                requestCompression = (RequestCompressionConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                disableRequestCompression = (Boolean) obj;
                requestCompression.setDisableRequestCompression(disableRequestCompression);
                requestCompression2 = ((CompressionClientConfig.Builder) this.$config$inlined).getRequestCompression();
                requestMinCompressionSizeBytes = ((CompressionClientConfig.Builder) this.$config$inlined).getRequestCompression().getRequestMinCompressionSizeBytes();
                if (requestMinCompressionSizeBytes == null) {
                }
                requestCompression2.setRequestMinCompressionSizeBytes(requestMinCompressionSizeBytes);
                builder8 = this.$config$inlined;
                if (!(builder8 instanceof SigV4aClientConfig.Builder)) {
                }
                return coroutine_suspended;
            case 8:
                i = this.I$0;
                requestCompression2 = (RequestCompressionConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                requestMinCompressionSizeBytes = (Long) obj;
                requestCompression2.setRequestMinCompressionSizeBytes(requestMinCompressionSizeBytes);
                builder8 = this.$config$inlined;
                if (!(builder8 instanceof SigV4aClientConfig.Builder)) {
                }
                return coroutine_suspended;
            case 9:
                i = this.I$0;
                builder9 = (SigV4aClientConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                sigV4aSigningRegionSet = (Set) obj;
                builder9.setSigV4aSigningRegionSet(sigV4aSigningRegionSet);
                builder10 = this.$config$inlined;
                if (builder10 instanceof HttpChecksumConfig.Builder) {
                }
                return coroutine_suspended;
            case 10:
                i = this.I$0;
                builder11 = (HttpChecksumConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                requestChecksumCalculation = (RequestHttpChecksumConfig) obj;
                builder11.setRequestChecksumCalculation(requestChecksumCalculation);
                SdkClientConfig.Builder builder222 = this.$config$inlined;
                builder12 = (HttpChecksumConfig.Builder) builder222;
                responseChecksumValidation = ((HttpChecksumConfig.Builder) builder222).getResponseChecksumValidation();
                if (responseChecksumValidation == null) {
                }
                builder12.setResponseChecksumValidation(responseChecksumValidation);
                builder13 = this.$config$inlined;
                if (!(builder13 instanceof HttpAuthConfig.Builder)) {
                }
                return coroutine_suspended;
            case 11:
                i = this.I$0;
                builder12 = (HttpChecksumConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                responseChecksumValidation = (ResponseHttpChecksumConfig) obj;
                builder12.setResponseChecksumValidation(responseChecksumValidation);
                builder13 = this.$config$inlined;
                if (!(builder13 instanceof HttpAuthConfig.Builder)) {
                }
                return coroutine_suspended;
            case 12:
                i = this.I$0;
                builder14 = (HttpAuthConfig.Builder) this.L$7;
                lazyAsyncValue3 = (LazyAsyncValue) this.L$6;
                lazyAsyncValue4 = (LazyAsyncValue) this.L$5;
                platformProvider2 = (PlatformProvider) this.L$4;
                coroutineScope3 = (CoroutineScope) this.L$3;
                traceSpan3 = (TraceSpan) this.L$2;
                continuation2 = (Continuation) this.L$1;
                ResultKt.throwOnFailure(obj);
                authSchemePreference = (List) obj;
                builder14.setAuthSchemePreference(authSchemePreference);
                this.this$0.finalizeConfig(this.$builder$inlined);
                AbstractAwsSdkClientFactory abstractAwsSdkClientFactory22 = this.this$0;
                SdkClient.Builder builder2322 = this.$builder$inlined;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope4);
                this.L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan3);
                this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope3);
                this.L$4 = SpillingKt.nullOutSpilledVariable(platformProvider2);
                this.L$5 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue4);
                this.L$6 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue3);
                this.L$7 = null;
                this.I$0 = i;
                this.label = 13;
                break;
            case 13:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
