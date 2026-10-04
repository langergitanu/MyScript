package aws.sdk.kotlin.runtime.config.profile;

import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.p011io.internal.SdkDispatchers;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt$loadAwsSharedConfig$$inlined$withSpan$default$1 */
/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/telemetry/trace/CoroutineContextTraceExtKt$withSpan$3"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt$loadAwsSharedConfig$$inlined$withSpan$default$1", m1609f = "AwsConfigLoader.kt", m1610i = {0, 0, 0, 0, 0, 0, 0}, m1611l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m1612m = "invokeSuspend", m1613n = {"$this$withContext", "$completion", "it", "$this$loadAwsSharedConfig_u24lambda_u240", FirebaseAnalytics.Param.SOURCE, "logger", "$i$a$-withSpan$default-AwsConfigLoaderKt$loadAwsSharedConfig$2"}, m1614nl = {PDFACompliance.e_PDFA1_3_1}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
public final class C3114x64acf9a8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AwsSharedConfig>, Object> {
    final /* synthetic */ AwsConfigurationSource $configurationSource$inlined;
    final /* synthetic */ PlatformProvider $platform$inlined;
    final /* synthetic */ String $profileNameOverride$inlined;
    final /* synthetic */ TraceSpan $span;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3114x64acf9a8(TraceSpan traceSpan, Continuation continuation, AwsConfigurationSource awsConfigurationSource, PlatformProvider platformProvider, String str) {
        super(2, continuation);
        this.$span = traceSpan;
        this.$configurationSource$inlined = awsConfigurationSource;
        this.$platform$inlined = platformProvider;
        this.$profileNameOverride$inlined = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C3114x64acf9a8 c3114x64acf9a8 = new C3114x64acf9a8(this.$span, continuation, this.$configurationSource$inlined, this.$platform$inlined, this.$profileNameOverride$inlined);
        c3114x64acf9a8.L$0 = obj;
        return c3114x64acf9a8;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AwsSharedConfig> continuation) {
        return ((C3114x64acf9a8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        TraceSpan traceSpan = this.$span;
        C3114x64acf9a8 c3114x64acf9a8 = this;
        AwsConfigurationSource awsConfigurationSourceResolveConfigSource = this.$configurationSource$inlined;
        if (awsConfigurationSourceResolveConfigSource == null) {
            awsConfigurationSourceResolveConfigSource = AwsConfigLoaderKt.resolveConfigSource(this.$platform$inlined, this.$profileNameOverride$inlined);
        }
        Logger logger = CoroutineContextLogExtKt.logger(coroutineScope.getCoroutineContext(), "AwsConfigParser");
        CoroutineDispatcher io2 = SdkDispatchers.INSTANCE.getIO();
        AwsConfigLoaderKt$loadAwsSharedConfig$2$1 awsConfigLoaderKt$loadAwsSharedConfig$2$1 = new AwsConfigLoaderKt$loadAwsSharedConfig$2$1(logger, this.$platform$inlined, awsConfigurationSourceResolveConfigSource, null);
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(c3114x64acf9a8);
        this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
        this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$4 = SpillingKt.nullOutSpilledVariable(awsConfigurationSourceResolveConfigSource);
        this.L$5 = SpillingKt.nullOutSpilledVariable(logger);
        this.I$0 = 0;
        this.label = 1;
        Object objWithContext = BuildersKt.withContext(io2, awsConfigLoaderKt$loadAwsSharedConfig$2$1, this);
        return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
    }
}
