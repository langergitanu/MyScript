package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.auth.AuthOption;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.client.endpoints.SigningContextKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.auth.HttpSigner;
import aws.smithy.kotlin.runtime.http.auth.SignHttpRequest;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.telemetry.metrics.Histogram;
import aws.smithy.kotlin.runtime.telemetry.metrics.HistogramKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u0003BM\u0012\u001c\u0010\u0007\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0011\u001a\u00028\u00012\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0007\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/AuthHandler;", "Input", "Output", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "inner", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "authConfig", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "endpointResolver", "<init>", "(Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;)V", "request", NotificationCompat.CATEGORY_CALL, "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "Laws/smithy/kotlin/runtime/http/operation/OperationAuthConfig;", "Laws/smithy/kotlin/runtime/http/operation/EndpointResolver;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AuthHandler<Input, Output> implements Handler<OperationRequest<HttpRequestBuilder>, Output> {
    private final OperationAuthConfig authConfig;
    private final EndpointResolver endpointResolver;
    private final Handler<OperationRequest<HttpRequestBuilder>, Output> inner;
    private final InterceptorExecutor<Input, Output> interceptors;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.AuthHandler$call$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.AuthHandler", m1609f = "SdkOperationExecution.kt", m1610i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, m1611l = {278, 292, 302, 314, PDFACompliance.e_PDFA3_2_2, 330}, m1612m = NotificationCompat.CATEGORY_CALL, m1613n = {"request", "request", "candidateAuthSchemes", "authOption", "authScheme", "schemeAttr", "identityProvider", "$this$measureSeconds_u24default$iv", "attributes$iv", "$this$measureTimedValue$iv$iv$iv", "$i$f$measureSeconds", "$i$f$measureTimedValue", "$i$f$measureTimedValue", "mark$iv$iv$iv", "$i$a$-measureSeconds$default-AuthHandler$call$identity$1", "request", "candidateAuthSchemes", "authOption", "authScheme", "schemeAttr", "identityProvider", HTTP.IDENTITY_CODING, "resolveEndpointReq", "$this$measureSeconds_u24default$iv", "attributes$iv", "$this$measureTimedValue$iv$iv$iv", "$i$f$measureSeconds", "$i$f$measureTimedValue", "$i$f$measureTimedValue", "mark$iv$iv$iv", "$i$a$-measureSeconds$default-AuthHandler$call$endpoint$1", "request", "candidateAuthSchemes", "authOption", "authScheme", "schemeAttr", "identityProvider", HTTP.IDENTITY_CODING, "resolveEndpointReq", "request", "candidateAuthSchemes", "authOption", "authScheme", "schemeAttr", "identityProvider", HTTP.IDENTITY_CODING, "resolveEndpointReq", "modified", "signingRequest", "$this$measureSeconds_u24default$iv", "attributes$iv", "$this$measureTimedValue$iv$iv$iv", "$i$f$measureSeconds", "$i$f$measureTimedValue", "$i$f$measureTimedValue", "mark$iv$iv$iv", "$i$a$-measureSeconds$default-AuthHandler$call$3", "request", "candidateAuthSchemes", "authOption", "authScheme", "schemeAttr", "identityProvider", HTTP.IDENTITY_CODING, "resolveEndpointReq", "modified", "signingRequest"}, m1614nl = {279, 435, 443, 315, PDFACompliance.e_PDFA3_2_3, -1}, m1615s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, m1616v = 2)
    static final class C37271 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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
        final /* synthetic */ AuthHandler<Input, Output> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37271(AuthHandler<Input, Output> authHandler, Continuation<? super C37271> continuation) {
            super(continuation);
            this.this$0 = authHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.call((OperationRequest<HttpRequestBuilder>) null, (Continuation) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuthHandler(Handler<? super OperationRequest<HttpRequestBuilder>, ? extends Output> inner, InterceptorExecutor<Input, Output> interceptors, OperationAuthConfig authConfig, EndpointResolver endpointResolver) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(authConfig, "authConfig");
        this.inner = inner;
        this.interceptors = interceptors;
        this.authConfig = authConfig;
        this.endpointResolver = endpointResolver;
    }

    public /* synthetic */ AuthHandler(Handler handler, InterceptorExecutor interceptorExecutor, OperationAuthConfig operationAuthConfig, EndpointResolver endpointResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, interceptorExecutor, operationAuthConfig, (i & 8) != 0 ? null : endpointResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x04ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0196 A[SYNTHETIC] */
    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object call(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super Output> continuation) {
        C37271 c37271;
        Iterator it;
        Object next;
        AuthOption authOption;
        IdentityProvider identityProvider;
        OperationRequest<HttpRequestBuilder> operationRequest2;
        List list;
        AuthOption authOption2;
        Attributes attributes;
        Histogram<Double> histogram;
        AuthScheme authScheme;
        Attributes attributes2;
        long j;
        IdentityProvider identityProvider2;
        ResolveEndpointRequest resolveEndpointRequest;
        Histogram<Double> resolveEndpointDuration;
        long jM15974markNowz9LOYto;
        Identity identity;
        Attributes attributes3;
        ExecutionContext executionContext;
        Identity identity2;
        ResolveEndpointRequest resolveEndpointRequest2;
        Attributes attributes4;
        AuthScheme authScheme2;
        OperationRequest<HttpRequestBuilder> operationRequest3;
        IdentityProvider identityProvider3;
        String qualifiedName;
        Object next2;
        Attributes attributesEmptyAttributes;
        OperationRequest<HttpRequestBuilder> operationRequestCopy$default;
        SignHttpRequest signHttpRequest;
        Histogram<Double> signingDuration;
        long jM15974markNowz9LOYto2;
        HttpSigner signer;
        OperationRequest<HttpRequestBuilder> operationRequest4;
        ResolveEndpointRequest resolveEndpointRequest3;
        Identity identity3;
        AuthOption authOption3;
        Attributes attributes5;
        AuthScheme authScheme3;
        Attributes attributes6;
        AuthScheme authScheme4;
        Object objCall;
        OperationRequest<HttpRequestBuilder> operationRequest5 = operationRequest;
        if (continuation instanceof C37271) {
            c37271 = (C37271) continuation;
            if ((c37271.label & Integer.MIN_VALUE) != 0) {
                c37271.label -= Integer.MIN_VALUE;
            } else {
                c37271 = new C37271(this, continuation);
            }
        }
        Object objResolve = c37271.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c37271.label) {
            case 0:
                ResultKt.throwOnFailure(objResolve);
                AuthSchemeResolver authSchemeResolver = this.authConfig.getAuthSchemeResolver();
                c37271.L$0 = operationRequest5;
                c37271.label = 1;
                objResolve = authSchemeResolver.resolve(operationRequest5, c37271);
                if (objResolve != coroutine_suspended) {
                    List list2 = (List) objResolve;
                    it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = null;
                        } else {
                            next = it.next();
                            if (this.authConfig.getConfiguredAuthSchemes().containsKey(AuthSchemeId.m12116boximpl(((AuthOption) next).mo12110getSchemeIdDepwgT4()))) {
                            }
                        }
                    }
                    authOption = (AuthOption) next;
                    if (authOption != null) {
                        throw new IllegalStateException(("no auth scheme found for operation; candidates: " + list2).toString());
                    }
                    AuthScheme authScheme5 = this.authConfig.getConfiguredAuthSchemes().get(AuthSchemeId.m12116boximpl(authOption.mo12110getSchemeIdDepwgT4()));
                    if (authScheme5 == null) {
                        throw new IllegalStateException(("auth scheme " + ((Object) AuthSchemeId.m12121toStringimpl(authOption.mo12110getSchemeIdDepwgT4())) + " not configured").toString());
                    }
                    AttributesBuilder attributesBuilder = new AttributesBuilder();
                    attributesBuilder.m498to("auth.scheme_id", authScheme5.getSchemeId());
                    MutableAttributes attributes7 = attributesBuilder.getAttributes();
                    AttributesKt.merge(operationRequest5.getContext(), authOption.getAttributes());
                    identityProvider = authScheme5.identityProvider(this.authConfig.getIdentityProviderConfig());
                    Histogram<Double> resolveIdentityDuration = HttpOperationContextKt.getOperationMetrics(operationRequest5.getContext()).getResolveIdentityDuration();
                    TimeSource.Monotonic monotonic = TimeSource.Monotonic.INSTANCE;
                    long jM15974markNowz9LOYto3 = monotonic.m15974markNowz9LOYto();
                    ExecutionContext context = operationRequest5.getContext();
                    c37271.L$0 = operationRequest5;
                    c37271.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                    c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption);
                    c37271.L$3 = authScheme5;
                    c37271.L$4 = attributes7;
                    c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider);
                    c37271.L$6 = resolveIdentityDuration;
                    c37271.L$7 = attributes7;
                    c37271.L$8 = SpillingKt.nullOutSpilledVariable(monotonic);
                    c37271.I$0 = 0;
                    c37271.I$1 = 0;
                    c37271.I$2 = 0;
                    c37271.J$0 = jM15974markNowz9LOYto3;
                    c37271.I$3 = 0;
                    c37271.label = 2;
                    Object objResolve2 = identityProvider.resolve(context, c37271);
                    if (objResolve2 != coroutine_suspended) {
                        operationRequest2 = operationRequest5;
                        list = list2;
                        authOption2 = authOption;
                        attributes = attributes7;
                        objResolve = objResolve2;
                        histogram = resolveIdentityDuration;
                        authScheme = authScheme5;
                        attributes2 = attributes;
                        j = jM15974markNowz9LOYto3;
                        identityProvider2 = identityProvider;
                        TimedValue timedValue = new TimedValue((Identity) objResolve, TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(j), null);
                        HistogramKt.m12285recordSecondsdWUq8MI(histogram, timedValue.m15996getDurationUwyO8pc(), attributes, null);
                        Identity identity4 = (Identity) timedValue.getValue();
                        SdkOperationExecutionKt.emitIdentityBusinessMetrics(identity4, operationRequest2.getContext());
                        resolveEndpointRequest = new ResolveEndpointRequest(operationRequest2.getContext(), HttpRequestBuilderKt.immutableView$default(operationRequest2.getSubject(), false, 1, null), identity4);
                        if (this.endpointResolver == null) {
                            resolveEndpointDuration = HttpOperationContextKt.getOperationMetrics(operationRequest2.getContext()).getResolveEndpointDuration();
                            Attributes operationAttributes = HttpOperationContextKt.getOperationAttributes(operationRequest2.getContext());
                            TimeSource.Monotonic monotonic2 = TimeSource.Monotonic.INSTANCE;
                            jM15974markNowz9LOYto = monotonic2.m15974markNowz9LOYto();
                            EndpointResolver endpointResolver = this.endpointResolver;
                            c37271.L$0 = operationRequest2;
                            c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                            c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption2);
                            c37271.L$3 = authScheme;
                            c37271.L$4 = attributes2;
                            c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider2);
                            c37271.L$6 = identity4;
                            c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest);
                            c37271.L$8 = resolveEndpointDuration;
                            c37271.L$9 = operationAttributes;
                            c37271.L$10 = SpillingKt.nullOutSpilledVariable(monotonic2);
                            c37271.I$0 = 0;
                            c37271.I$1 = 0;
                            c37271.I$2 = 0;
                            c37271.J$0 = jM15974markNowz9LOYto;
                            c37271.I$3 = 0;
                            c37271.label = 3;
                            Object objResolve3 = endpointResolver.resolve(resolveEndpointRequest, c37271);
                            if (objResolve3 != coroutine_suspended) {
                                identity = identity4;
                                attributes3 = operationAttributes;
                                objResolve = objResolve3;
                                identityProvider2 = identityProvider2;
                                ResolveEndpointRequest resolveEndpointRequest4 = resolveEndpointRequest;
                                Identity identity5 = identity;
                                TimedValue timedValue2 = new TimedValue((Endpoint) objResolve, TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(jM15974markNowz9LOYto), null);
                                HistogramKt.m12285recordSecondsdWUq8MI(resolveEndpointDuration, timedValue2.m15996getDurationUwyO8pc(), attributes3, null);
                                final Endpoint endpoint = (Endpoint) timedValue2.getValue();
                                CoroutineContext coroutineContext = c37271.get$context();
                                Function0 function0 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.AuthHandler$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return AuthHandler.call$lambda$4(endpoint);
                                    }
                                };
                                LogLevel logLevel = LogLevel.Debug;
                                qualifiedName = Reflection.getOrCreateKotlinClass(AuthHandler.class).getQualifiedName();
                                if (qualifiedName != null) {
                                    throw new IllegalArgumentException("log<T> cannot be used on an anonymous object".toString());
                                }
                                CoroutineContextLogExtKt.log(coroutineContext, logLevel, qualifiedName, null, function0);
                                OperationEndpointKt.setResolvedEndpoint(operationRequest2, endpoint);
                                Iterator<T> it2 = SigningContextKt.getAuthOptions(endpoint).iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        next2 = it2.next();
                                        if (AuthSchemeId.m12119equalsimpl0(((AuthOption) next2).mo12110getSchemeIdDepwgT4(), authScheme.getSchemeId())) {
                                        }
                                    } else {
                                        next2 = null;
                                    }
                                }
                                AuthOption authOption4 = (AuthOption) next2;
                                if (authOption4 == null || (attributesEmptyAttributes = authOption4.getAttributes()) == null) {
                                    attributesEmptyAttributes = AttributesKt.emptyAttributes();
                                }
                                AttributesKt.merge(operationRequest2.getContext(), attributesEmptyAttributes);
                                AttributesKt.merge(operationRequest2.getContext(), endpoint.getAttributes());
                                resolveEndpointRequest = resolveEndpointRequest4;
                                identity4 = identity5;
                                InterceptorExecutor<Input, Output> interceptorExecutor = this.interceptors;
                                HttpRequest httpRequestImmutableView = HttpRequestBuilderKt.immutableView(operationRequest2.getSubject(), true);
                                c37271.L$0 = operationRequest2;
                                c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                                c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption2);
                                c37271.L$3 = authScheme;
                                c37271.L$4 = attributes2;
                                c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider2);
                                c37271.L$6 = identity4;
                                c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest);
                                executionContext = null;
                                c37271.L$8 = null;
                                c37271.L$9 = null;
                                c37271.L$10 = null;
                                c37271.label = 4;
                                objResolve = interceptorExecutor.modifyBeforeSigning(httpRequestImmutableView, c37271);
                                if (objResolve != coroutine_suspended) {
                                    identity2 = identity4;
                                    resolveEndpointRequest2 = resolveEndpointRequest;
                                    attributes4 = attributes2;
                                    authScheme2 = authScheme;
                                    operationRequest3 = operationRequest2;
                                    identityProvider3 = identityProvider2;
                                    operationRequestCopy$default = OperationRequest.copy$default(operationRequest3, executionContext, HttpRequestKt.toBuilder((HttpRequest) objResolve), 1, executionContext);
                                    ResolveEndpointRequest resolveEndpointRequest5 = resolveEndpointRequest2;
                                    this.interceptors.readBeforeSigning(HttpRequestBuilderKt.immutableView$default(operationRequestCopy$default.getSubject(), false, 1, executionContext));
                                    signHttpRequest = new SignHttpRequest(operationRequestCopy$default.getSubject(), identity2, operationRequestCopy$default.getContext());
                                    signingDuration = HttpOperationContextKt.getOperationMetrics(operationRequest3.getContext()).getSigningDuration();
                                    TimeSource.Monotonic monotonic3 = TimeSource.Monotonic.INSTANCE;
                                    Identity identity6 = identity2;
                                    jM15974markNowz9LOYto2 = monotonic3.m15974markNowz9LOYto();
                                    signer = authScheme2.getSigner();
                                    c37271.L$0 = operationRequest3;
                                    operationRequest4 = operationRequest3;
                                    c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                                    c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption2);
                                    c37271.L$3 = authScheme2;
                                    c37271.L$4 = SpillingKt.nullOutSpilledVariable(attributes4);
                                    c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider3);
                                    c37271.L$6 = SpillingKt.nullOutSpilledVariable(identity6);
                                    c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest5);
                                    c37271.L$8 = operationRequestCopy$default;
                                    c37271.L$9 = SpillingKt.nullOutSpilledVariable(signHttpRequest);
                                    c37271.L$10 = signingDuration;
                                    c37271.L$11 = attributes4;
                                    c37271.L$12 = SpillingKt.nullOutSpilledVariable(monotonic3);
                                    c37271.I$0 = 0;
                                    c37271.I$1 = 0;
                                    c37271.I$2 = 0;
                                    c37271.J$0 = jM15974markNowz9LOYto2;
                                    c37271.I$3 = 0;
                                    c37271.label = 5;
                                    if (signer.sign(signHttpRequest, c37271) != coroutine_suspended) {
                                        AuthOption authOption5 = authOption2;
                                        resolveEndpointRequest3 = resolveEndpointRequest5;
                                        identity3 = identity6;
                                        authOption3 = authOption5;
                                        attributes5 = attributes4;
                                        authScheme3 = authScheme2;
                                        attributes6 = attributes5;
                                        AuthOption authOption6 = authOption3;
                                        authScheme4 = authScheme3;
                                        TimedValue timedValue3 = new TimedValue(Unit.INSTANCE, TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(jM15974markNowz9LOYto2), null);
                                        HistogramKt.m12285recordSecondsdWUq8MI(signingDuration, timedValue3.m15996getDurationUwyO8pc(), attributes5, null);
                                        timedValue3.getValue();
                                        if (Intrinsics.areEqual(authScheme4.getSchemeId(), "aws.auth#sigv4a")) {
                                            BusinessMetricsUtilsKt.emitBusinessMetric(operationRequest4.getContext(), (BusinessMetric) SmithyBusinessMetric.SIGV4A_SIGNING);
                                        }
                                        this.interceptors.readAfterSigning(HttpRequestBuilderKt.immutableView$default(operationRequestCopy$default.getSubject(), false, 1, null));
                                        Handler<OperationRequest<HttpRequestBuilder>, Output> handler = this.inner;
                                        c37271.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest4);
                                        c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                                        c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption6);
                                        c37271.L$3 = SpillingKt.nullOutSpilledVariable(authScheme4);
                                        c37271.L$4 = SpillingKt.nullOutSpilledVariable(attributes6);
                                        c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider3);
                                        c37271.L$6 = SpillingKt.nullOutSpilledVariable(identity3);
                                        c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest3);
                                        c37271.L$8 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
                                        c37271.L$9 = SpillingKt.nullOutSpilledVariable(signHttpRequest);
                                        c37271.L$10 = null;
                                        c37271.L$11 = null;
                                        c37271.L$12 = null;
                                        c37271.label = 6;
                                        objCall = handler.call(operationRequestCopy$default, c37271);
                                        if (objCall != coroutine_suspended) {
                                            return objCall;
                                        }
                                    }
                                }
                            }
                        } else {
                            InterceptorExecutor<Input, Output> interceptorExecutor2 = this.interceptors;
                            HttpRequest httpRequestImmutableView2 = HttpRequestBuilderKt.immutableView(operationRequest2.getSubject(), true);
                            c37271.L$0 = operationRequest2;
                            c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                            c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption2);
                            c37271.L$3 = authScheme;
                            c37271.L$4 = attributes2;
                            c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider2);
                            c37271.L$6 = identity4;
                            c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest);
                            executionContext = null;
                            c37271.L$8 = null;
                            c37271.L$9 = null;
                            c37271.L$10 = null;
                            c37271.label = 4;
                            objResolve = interceptorExecutor2.modifyBeforeSigning(httpRequestImmutableView2, c37271);
                            if (objResolve != coroutine_suspended) {
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                operationRequest5 = (OperationRequest) c37271.L$0;
                ResultKt.throwOnFailure(objResolve);
                List list22 = (List) objResolve;
                it = list22.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                }
                authOption = (AuthOption) next;
                if (authOption != null) {
                }
                break;
            case 2:
                int i = c37271.I$3;
                j = c37271.J$0;
                int i2 = c37271.I$2;
                int i3 = c37271.I$1;
                int i4 = c37271.I$0;
                attributes = (Attributes) c37271.L$7;
                histogram = (Histogram) c37271.L$6;
                identityProvider = (IdentityProvider) c37271.L$5;
                Attributes attributes8 = (Attributes) c37271.L$4;
                AuthScheme authScheme6 = (AuthScheme) c37271.L$3;
                AuthOption authOption7 = (AuthOption) c37271.L$2;
                List list3 = (List) c37271.L$1;
                OperationRequest<HttpRequestBuilder> operationRequest6 = (OperationRequest) c37271.L$0;
                ResultKt.throwOnFailure(objResolve);
                list = list3;
                operationRequest2 = operationRequest6;
                authScheme = authScheme6;
                authOption2 = authOption7;
                attributes2 = attributes8;
                identityProvider2 = identityProvider;
                TimedValue timedValue4 = new TimedValue((Identity) objResolve, TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(j), null);
                HistogramKt.m12285recordSecondsdWUq8MI(histogram, timedValue4.m15996getDurationUwyO8pc(), attributes, null);
                Identity identity42 = (Identity) timedValue4.getValue();
                SdkOperationExecutionKt.emitIdentityBusinessMetrics(identity42, operationRequest2.getContext());
                resolveEndpointRequest = new ResolveEndpointRequest(operationRequest2.getContext(), HttpRequestBuilderKt.immutableView$default(operationRequest2.getSubject(), false, 1, null), identity42);
                if (this.endpointResolver == null) {
                }
                break;
            case 3:
                int i5 = c37271.I$3;
                jM15974markNowz9LOYto = c37271.J$0;
                int i6 = c37271.I$2;
                int i7 = c37271.I$1;
                int i8 = c37271.I$0;
                attributes3 = (Attributes) c37271.L$9;
                resolveEndpointDuration = (Histogram) c37271.L$8;
                resolveEndpointRequest = (ResolveEndpointRequest) c37271.L$7;
                identity = (Identity) c37271.L$6;
                identityProvider2 = (IdentityProvider) c37271.L$5;
                attributes2 = (Attributes) c37271.L$4;
                authScheme = (AuthScheme) c37271.L$3;
                authOption2 = (AuthOption) c37271.L$2;
                list = (List) c37271.L$1;
                operationRequest2 = (OperationRequest) c37271.L$0;
                ResultKt.throwOnFailure(objResolve);
                ResolveEndpointRequest resolveEndpointRequest42 = resolveEndpointRequest;
                Identity identity52 = identity;
                TimedValue timedValue22 = new TimedValue((Endpoint) objResolve, TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(jM15974markNowz9LOYto), null);
                HistogramKt.m12285recordSecondsdWUq8MI(resolveEndpointDuration, timedValue22.m15996getDurationUwyO8pc(), attributes3, null);
                final Endpoint endpoint2 = (Endpoint) timedValue22.getValue();
                CoroutineContext coroutineContext2 = c37271.get$context();
                Function0 function02 = new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.AuthHandler$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AuthHandler.call$lambda$4(endpoint2);
                    }
                };
                LogLevel logLevel2 = LogLevel.Debug;
                qualifiedName = Reflection.getOrCreateKotlinClass(AuthHandler.class).getQualifiedName();
                if (qualifiedName != null) {
                }
                break;
            case 4:
                ResolveEndpointRequest resolveEndpointRequest6 = (ResolveEndpointRequest) c37271.L$7;
                Identity identity7 = (Identity) c37271.L$6;
                IdentityProvider identityProvider4 = (IdentityProvider) c37271.L$5;
                attributes4 = (Attributes) c37271.L$4;
                authScheme2 = (AuthScheme) c37271.L$3;
                AuthOption authOption8 = (AuthOption) c37271.L$2;
                List list4 = (List) c37271.L$1;
                OperationRequest<HttpRequestBuilder> operationRequest7 = (OperationRequest) c37271.L$0;
                ResultKt.throwOnFailure(objResolve);
                identityProvider3 = identityProvider4;
                authOption2 = authOption8;
                list = list4;
                executionContext = null;
                identity2 = identity7;
                resolveEndpointRequest2 = resolveEndpointRequest6;
                operationRequest3 = operationRequest7;
                operationRequestCopy$default = OperationRequest.copy$default(operationRequest3, executionContext, HttpRequestKt.toBuilder((HttpRequest) objResolve), 1, executionContext);
                ResolveEndpointRequest resolveEndpointRequest52 = resolveEndpointRequest2;
                this.interceptors.readBeforeSigning(HttpRequestBuilderKt.immutableView$default(operationRequestCopy$default.getSubject(), false, 1, executionContext));
                signHttpRequest = new SignHttpRequest(operationRequestCopy$default.getSubject(), identity2, operationRequestCopy$default.getContext());
                signingDuration = HttpOperationContextKt.getOperationMetrics(operationRequest3.getContext()).getSigningDuration();
                TimeSource.Monotonic monotonic32 = TimeSource.Monotonic.INSTANCE;
                Identity identity62 = identity2;
                jM15974markNowz9LOYto2 = monotonic32.m15974markNowz9LOYto();
                signer = authScheme2.getSigner();
                c37271.L$0 = operationRequest3;
                operationRequest4 = operationRequest3;
                c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption2);
                c37271.L$3 = authScheme2;
                c37271.L$4 = SpillingKt.nullOutSpilledVariable(attributes4);
                c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider3);
                c37271.L$6 = SpillingKt.nullOutSpilledVariable(identity62);
                c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest52);
                c37271.L$8 = operationRequestCopy$default;
                c37271.L$9 = SpillingKt.nullOutSpilledVariable(signHttpRequest);
                c37271.L$10 = signingDuration;
                c37271.L$11 = attributes4;
                c37271.L$12 = SpillingKt.nullOutSpilledVariable(monotonic32);
                c37271.I$0 = 0;
                c37271.I$1 = 0;
                c37271.I$2 = 0;
                c37271.J$0 = jM15974markNowz9LOYto2;
                c37271.I$3 = 0;
                c37271.label = 5;
                if (signer.sign(signHttpRequest, c37271) != coroutine_suspended) {
                }
                return coroutine_suspended;
            case 5:
                int i9 = c37271.I$3;
                jM15974markNowz9LOYto2 = c37271.J$0;
                int i10 = c37271.I$2;
                int i11 = c37271.I$1;
                int i12 = c37271.I$0;
                Attributes attributes9 = (Attributes) c37271.L$11;
                signingDuration = (Histogram) c37271.L$10;
                signHttpRequest = (SignHttpRequest) c37271.L$9;
                operationRequestCopy$default = (OperationRequest) c37271.L$8;
                resolveEndpointRequest3 = (ResolveEndpointRequest) c37271.L$7;
                Identity identity8 = (Identity) c37271.L$6;
                identityProvider3 = (IdentityProvider) c37271.L$5;
                attributes6 = (Attributes) c37271.L$4;
                authScheme3 = (AuthScheme) c37271.L$3;
                authOption3 = (AuthOption) c37271.L$2;
                List list5 = (List) c37271.L$1;
                OperationRequest<HttpRequestBuilder> operationRequest8 = (OperationRequest) c37271.L$0;
                ResultKt.throwOnFailure(objResolve);
                operationRequest4 = operationRequest8;
                attributes5 = attributes9;
                identity3 = identity8;
                list = list5;
                AuthOption authOption62 = authOption3;
                authScheme4 = authScheme3;
                TimedValue timedValue32 = new TimedValue(Unit.INSTANCE, TimeSource.Monotonic.ValueTimeMark.m15979elapsedNowUwyO8pc(jM15974markNowz9LOYto2), null);
                HistogramKt.m12285recordSecondsdWUq8MI(signingDuration, timedValue32.m15996getDurationUwyO8pc(), attributes5, null);
                timedValue32.getValue();
                if (Intrinsics.areEqual(authScheme4.getSchemeId(), "aws.auth#sigv4a")) {
                }
                this.interceptors.readAfterSigning(HttpRequestBuilderKt.immutableView$default(operationRequestCopy$default.getSubject(), false, 1, null));
                Handler<OperationRequest<HttpRequestBuilder>, Output> handler2 = this.inner;
                c37271.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest4);
                c37271.L$1 = SpillingKt.nullOutSpilledVariable(list);
                c37271.L$2 = SpillingKt.nullOutSpilledVariable(authOption62);
                c37271.L$3 = SpillingKt.nullOutSpilledVariable(authScheme4);
                c37271.L$4 = SpillingKt.nullOutSpilledVariable(attributes6);
                c37271.L$5 = SpillingKt.nullOutSpilledVariable(identityProvider3);
                c37271.L$6 = SpillingKt.nullOutSpilledVariable(identity3);
                c37271.L$7 = SpillingKt.nullOutSpilledVariable(resolveEndpointRequest3);
                c37271.L$8 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
                c37271.L$9 = SpillingKt.nullOutSpilledVariable(signHttpRequest);
                c37271.L$10 = null;
                c37271.L$11 = null;
                c37271.L$12 = null;
                c37271.label = 6;
                objCall = handler2.call(operationRequestCopy$default, c37271);
                if (objCall != coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 6:
                ResultKt.throwOnFailure(objResolve);
                return objResolve;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String call$lambda$4(Endpoint endpoint) {
        return "resolved endpoint: " + endpoint;
    }
}
