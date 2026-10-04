package aws.smithy.kotlin.runtime.identity;

import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [I] */
/* JADX INFO: renamed from: aws.smithy.kotlin.runtime.identity.IdentityProviderChain$resolve$suspendImpl$$inlined$withSpan$default$1 */
/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/telemetry/trace/CoroutineContextTraceExtKt$withSpan$3"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.identity.IdentityProviderChain$resolve$suspendImpl$$inlined$withSpan$default$1", m1609f = "IdentityProviderChain.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m1612m = "invokeSuspend", m1613n = {"$this$withContext", "$completion", "it", "$this$resolve_u24lambda_u240", "chain", "chainException", "logger", "provider", "$i$a$-withSpan$default-IdentityProviderChain$resolve$2"}, m1614nl = {137}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0"}, m1616v = 2)
public final class C3743x3d16e725<I> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super I>, Object> {
    final /* synthetic */ Attributes $attributes$inlined;
    final /* synthetic */ TraceSpan $span;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ IdentityProviderChain this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3743x3d16e725(TraceSpan traceSpan, Continuation continuation, IdentityProviderChain identityProviderChain, Attributes attributes) {
        super(2, continuation);
        this.$span = traceSpan;
        this.this$0 = identityProviderChain;
        this.$attributes$inlined = attributes;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C3743x3d16e725 c3743x3d16e725 = new C3743x3d16e725(this.$span, continuation, this.this$0, this.$attributes$inlined);
        c3743x3d16e725.L$0 = obj;
        return c3743x3d16e725;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super I> continuation) {
        return ((C3743x3d16e725) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00d2 -> B:20:0x00d5). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i;
        Continuation continuation;
        TraceSpan traceSpan;
        CoroutineScope coroutineScope;
        IdentityProviderChain identityProviderChain;
        Lazy lazy;
        IdentityProvider[] identityProviderArr;
        Logger logger;
        int i2;
        int length;
        final IdentityProvider identityProvider;
        Object objResolve;
        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        Throwable th = null;
        try {
        } catch (Exception e) {
            Logger.debug$default(logger, null, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.identity.IdentityProviderChain$resolve$2$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "unable to resolve identity from " + identityProvider + ": " + e.getMessage();
                }
            }, 1, null);
            ExceptionsKt.addSuppressed((Throwable) lazy.getValue(), e);
            i++;
            th = null;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = this.I$2;
            i = this.I$1;
            i2 = this.I$0;
            identityProvider = (IdentityProvider) this.L$8;
            logger = (Logger) this.L$7;
            identityProviderArr = (IdentityProvider[]) this.L$6;
            lazy = (Lazy) this.L$5;
            identityProviderChain = (IdentityProviderChain) this.L$4;
            coroutineScope = (CoroutineScope) this.L$3;
            traceSpan = (TraceSpan) this.L$2;
            continuation = (Continuation) this.L$1;
            ResultKt.throwOnFailure(obj);
            objResolve = obj;
            Intrinsics.checkNotNull(objResolve, "null cannot be cast to non-null type I of aws.smithy.kotlin.runtime.identity.IdentityProviderChain");
            return (Identity) objResolve;
        }
        ResultKt.throwOnFailure(obj);
        TraceSpan traceSpan2 = this.$span;
        C3743x3d16e725<I> c3743x3d16e725 = this;
        CoroutineContext coroutineContext = coroutineScope2.getCoroutineContext();
        String qualifiedName = Reflection.getOrCreateKotlinClass(IdentityProviderChain.class).getQualifiedName();
        if (qualifiedName == null) {
            throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
        }
        Logger logger2 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
        final IdentityProviderChain identityProviderChain2 = this.this$0;
        Lazy lazy2 = LazyKt.lazy(new Function0<IdentityProviderException>() { // from class: aws.smithy.kotlin.runtime.identity.IdentityProviderChain$resolve$2$chainException$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IdentityProviderException invoke() {
                return new IdentityProviderException("No identity could be resolved from the chain: " + identityProviderChain2, null, 2, null);
            }
        });
        IdentityProvider[] providers = this.this$0.getProviders();
        traceSpan = traceSpan2;
        coroutineScope = coroutineScope2;
        continuation = c3743x3d16e725;
        identityProviderChain = identityProviderChain2;
        length = providers.length;
        i2 = 0;
        lazy = lazy2;
        identityProviderArr = providers;
        logger = logger2;
        i = 0;
        if (i < length) {
            identityProvider = identityProviderArr[i];
            Logger.trace$default(logger, th, new Function0<String>() { // from class: aws.smithy.kotlin.runtime.identity.IdentityProviderChain$resolve$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Attempting to resolve identity from " + identityProvider;
                }
            }, 1, th);
            Attributes attributes = this.$attributes$inlined;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(continuation);
            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$4 = SpillingKt.nullOutSpilledVariable(identityProviderChain);
            this.L$5 = lazy;
            this.L$6 = identityProviderArr;
            this.L$7 = logger;
            this.L$8 = identityProvider;
            this.I$0 = i2;
            this.I$1 = i;
            this.I$2 = length;
            this.label = 1;
            objResolve = identityProvider.resolve(attributes, this);
            if (objResolve == coroutine_suspended) {
                return coroutine_suspended;
            }
            Intrinsics.checkNotNull(objResolve, "null cannot be cast to non-null type I of aws.smithy.kotlin.runtime.identity.IdentityProviderChain");
            return (Identity) objResolve;
        }
        throw ((Throwable) lazy.getValue());
    }
}
