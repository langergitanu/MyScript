package aws.sdk.kotlin.runtime.config.imds;

import androidx.compose.p004ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpCallKt;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware;
import aws.smithy.kotlin.runtime.http.operation.OperationEndpointKt;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.CachedValue;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: TokenMiddleware.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013H\u0016J*\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u00172\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u0017H\u0096@¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u0017H\u0082@¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/runtime/config/imds/TokenMiddleware;", "Laws/smithy/kotlin/runtime/http/operation/ModifyRequestMiddleware;", "httpClient", "Laws/smithy/kotlin/runtime/http/SdkHttpClient;", "endpointProvider", "Laws/sdk/kotlin/runtime/config/imds/ImdsEndpointProvider;", "ttl", "Lkotlin/time/Duration;", "clock", "Laws/smithy/kotlin/runtime/time/Clock;", "<init>", "(Laws/smithy/kotlin/runtime/http/SdkHttpClient;Laws/sdk/kotlin/runtime/config/imds/ImdsEndpointProvider;JLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "cachedToken", "Laws/smithy/kotlin/runtime/util/CachedValue;", "Laws/sdk/kotlin/runtime/config/imds/Token;", "install", "", "op", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "modifyRequest", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "req", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "(Laws/smithy/kotlin/runtime/time/Clock;Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TokenMiddleware implements ModifyRequestMiddleware {
    private CachedValue<Token> cachedToken;
    private final Clock clock;
    private final ImdsEndpointProvider endpointProvider;
    private final SdkHttpClient httpClient;
    private final long ttl;

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$getToken$1 */
    /* JADX INFO: compiled from: TokenMiddleware.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.TokenMiddleware", m1609f = "TokenMiddleware.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, m1611l = {RectListKt.BitOffsetForGesturable, 65, TsExtractor.TS_SYNC_BYTE, 84, 84}, m1612m = "getToken", m1613n = {"clock", "req", "logger", "tokenReq", "clock", "req", "logger", "tokenReq", "endpoint", "clock", "req", "logger", "tokenReq", "endpoint", NotificationCompat.CATEGORY_CALL, "ttl", "clock", "req", "logger", "tokenReq", "endpoint", NotificationCompat.CATEGORY_CALL, "clock", "req", "logger", "tokenReq", "endpoint", NotificationCompat.CATEGORY_CALL}, m1614nl = {63, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 72, 85, 67}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, m1616v = 2)
    static final class C31121 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C31121(Continuation<? super C31121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TokenMiddleware.this.getToken(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$1 */
    /* JADX INFO: compiled from: TokenMiddleware.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.TokenMiddleware", m1609f = "TokenMiddleware.kt", m1610i = {0}, m1611l = {45}, m1612m = "modifyRequest", m1613n = {"req"}, m1614nl = {46}, m1615s = {"L$0"}, m1616v = 2)
    static final class C31131 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C31131(Continuation<? super C31131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TokenMiddleware.this.modifyRequest((OperationRequest<HttpRequestBuilder>) null, (Continuation<? super OperationRequest<HttpRequestBuilder>>) this);
        }
    }

    public /* synthetic */ TokenMiddleware(SdkHttpClient sdkHttpClient, ImdsEndpointProvider imdsEndpointProvider, long j, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(sdkHttpClient, imdsEndpointProvider, j, clock);
    }

    private TokenMiddleware(SdkHttpClient httpClient, ImdsEndpointProvider endpointProvider, long j, Clock clock) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(endpointProvider, "endpointProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.httpClient = httpClient;
        this.endpointProvider = endpointProvider;
        this.ttl = j;
        this.clock = clock;
        Duration.Companion companion = Duration.INSTANCE;
        this.cachedToken = new CachedValue<>((ExpiringValue) null, DurationKt.toDuration(120, DurationUnit.SECONDS), clock, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TokenMiddleware(SdkHttpClient sdkHttpClient, ImdsEndpointProvider imdsEndpointProvider, long j, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = DurationKt.toDuration(ImdsClientKt.DEFAULT_TOKEN_TTL_SECONDS, DurationUnit.SECONDS);
        }
        this(sdkHttpClient, imdsEndpointProvider, j, (i & 8) != 0 ? Clock.System.INSTANCE : system, null);
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.ModifyRequestMiddleware
    public void install(SdkHttpOperation<?, ?> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Phase.register$default(op.getExecution().getOnEachAttempt(), this, (Phase.Order) null, 2, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.middleware.ModifyRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object modifyRequest(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super OperationRequest<HttpRequestBuilder>> continuation) throws Throwable {
        C31131 c31131;
        if (continuation instanceof C31131) {
            c31131 = (C31131) continuation;
            if ((c31131.label & Integer.MIN_VALUE) != 0) {
                c31131.label -= Integer.MIN_VALUE;
            } else {
                c31131 = new C31131(continuation);
            }
        }
        Object orLoad = c31131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orLoad);
            CachedValue<Token> cachedValue = this.cachedToken;
            TokenMiddleware$modifyRequest$token$1 tokenMiddleware$modifyRequest$token$1 = new TokenMiddleware$modifyRequest$token$1(this, operationRequest, null);
            c31131.L$0 = operationRequest;
            c31131.label = 1;
            orLoad = cachedValue.getOrLoad(tokenMiddleware$modifyRequest$token$1, c31131);
            if (orLoad == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            operationRequest = (OperationRequest) c31131.L$0;
            ResultKt.throwOnFailure(orLoad);
        }
        operationRequest.getSubject().getHeaders().append(TokenMiddlewareKt.X_AWS_EC2_METADATA_TOKEN, StringsKt.decodeToString(((Token) orLoad).getValue()));
        return operationRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b2 A[Catch: all -> 0x028a, TryCatch #1 {all -> 0x028a, blocks: (B:41:0x019e, B:43:0x01b2, B:45:0x01c2, B:58:0x0255, B:59:0x0262, B:60:0x0263, B:64:0x027c, B:65:0x0289), top: B:76:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0201 A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:21:0x009d, B:49:0x01fd, B:51:0x0201, B:56:0x0247, B:57:0x0254), top: B:75:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0247 A[Catch: all -> 0x00a2, TRY_ENTER, TryCatch #0 {all -> 0x00a2, blocks: (B:21:0x009d, B:49:0x01fd, B:51:0x0201, B:56:0x0247, B:57:0x0254), top: B:75:0x009d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0263 A[Catch: all -> 0x028a, TryCatch #1 {all -> 0x028a, blocks: (B:41:0x019e, B:43:0x01b2, B:45:0x01c2, B:58:0x0255, B:59:0x0262, B:60:0x0263, B:64:0x027c, B:65:0x0289), top: B:76:0x019e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getToken(Clock clock, OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super Token> continuation) throws Throwable {
        C31121 c31121;
        Clock clock2;
        Logger logger;
        HttpRequestBuilder httpRequestBuilder;
        Object obj;
        OperationRequest<HttpRequestBuilder> operationRequest2;
        Endpoint endpoint;
        Clock clock3;
        OperationRequest<HttpRequestBuilder> operationRequest3;
        final HttpCall httpCall;
        HttpCall httpCall2;
        HttpRequestBuilder httpRequestBuilder2;
        OperationRequest<HttpRequestBuilder> operationRequest4;
        Logger logger2;
        Clock clock4;
        long j;
        byte[] bArr;
        if (continuation instanceof C31121) {
            c31121 = (C31121) continuation;
            if ((c31121.label & Integer.MIN_VALUE) != 0) {
                c31121.label -= Integer.MIN_VALUE;
            } else {
                c31121 = new C31121(continuation);
            }
        }
        Object all = c31121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31121.label;
        if (i == 0) {
            ResultKt.throwOnFailure(all);
            CoroutineContext coroutineContext = c31121.get$context();
            String qualifiedName = Reflection.getOrCreateKotlinClass(TokenMiddleware.class).getQualifiedName();
            if (qualifiedName == null) {
                throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
            }
            Logger logger3 = CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName);
            Logger.trace$default(logger3, null, new Function0() { // from class: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TokenMiddleware.getToken$lambda$0();
                }
            }, 1, null);
            HttpRequestBuilder httpRequestBuilder3 = new HttpRequestBuilder();
            httpRequestBuilder3.setMethod(HttpMethod.PUT);
            httpRequestBuilder3.getHeaders().append(TokenMiddlewareKt.X_AWS_EC2_METADATA_TOKEN_TTL_SECONDS, String.valueOf(Duration.m15870getInWholeSecondsimpl(this.ttl)));
            String str = operationRequest.getSubject().getHeaders().get("User-Agent");
            if (str != null) {
                httpRequestBuilder3.getHeaders().append("User-Agent", str);
            }
            httpRequestBuilder3.getUrl().getPath().setEncoded("/latest/api/token");
            ImdsEndpointProvider imdsEndpointProvider = this.endpointProvider;
            clock2 = clock;
            c31121.L$0 = clock2;
            c31121.L$1 = SpillingKt.nullOutSpilledVariable(operationRequest);
            c31121.L$2 = logger3;
            c31121.L$3 = httpRequestBuilder3;
            c31121.label = 1;
            Object objResolveImdsEndpoint$aws_config = imdsEndpointProvider.resolveImdsEndpoint$aws_config(c31121);
            if (objResolveImdsEndpoint$aws_config != coroutine_suspended) {
                logger = logger3;
                httpRequestBuilder = httpRequestBuilder3;
                obj = objResolveImdsEndpoint$aws_config;
                operationRequest2 = operationRequest;
            }
        }
        if (i != 1) {
            if (i == 2) {
                Endpoint endpoint2 = (Endpoint) c31121.L$4;
                HttpRequestBuilder httpRequestBuilder4 = (HttpRequestBuilder) c31121.L$3;
                Logger logger4 = (Logger) c31121.L$2;
                operationRequest3 = (OperationRequest) c31121.L$1;
                Clock clock5 = (Clock) c31121.L$0;
                ResultKt.throwOnFailure(all);
                endpoint = endpoint2;
                clock3 = clock5;
                logger = logger4;
                httpRequestBuilder = httpRequestBuilder4;
                httpCall = (HttpCall) all;
                Logger.trace$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ImdsClientKt.toTraceString(httpCall);
                    }
                }, 1, null);
                try {
                } catch (Throwable th) {
                    th = th;
                    httpCall2 = httpCall;
                    httpRequestBuilder2 = httpRequestBuilder;
                    operationRequest4 = operationRequest3;
                    logger2 = logger;
                    clock4 = clock3;
                    c31121.L$0 = SpillingKt.nullOutSpilledVariable(clock4);
                    c31121.L$1 = SpillingKt.nullOutSpilledVariable(operationRequest4);
                    c31121.L$2 = SpillingKt.nullOutSpilledVariable(logger2);
                    c31121.L$3 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder2);
                    c31121.L$4 = SpillingKt.nullOutSpilledVariable(endpoint);
                    c31121.L$5 = SpillingKt.nullOutSpilledVariable(httpCall2);
                    c31121.L$6 = th;
                    c31121.label = 5;
                    if (HttpCallKt.complete(httpCall2, c31121) != coroutine_suspended) {
                    }
                }
                if (!Intrinsics.areEqual(httpCall.getResponse().getStatus(), HttpStatusCode.INSTANCE.getOK())) {
                    String str2 = httpCall.getResponse().getHeaders().get(TokenMiddlewareKt.X_AWS_EC2_METADATA_TOKEN_TTL_SECONDS);
                    if (str2 == null) {
                        throw new EC2MetadataError(HttpStatusCode.INSTANCE.getOK(), "No TTL provided in IMDS response");
                    }
                    long j2 = Long.parseLong(str2);
                    HttpBody body = httpCall.getResponse().getBody();
                    c31121.L$0 = clock3;
                    c31121.L$1 = SpillingKt.nullOutSpilledVariable(operationRequest3);
                    c31121.L$2 = SpillingKt.nullOutSpilledVariable(logger);
                    c31121.L$3 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                    c31121.L$4 = SpillingKt.nullOutSpilledVariable(endpoint);
                    c31121.L$5 = httpCall;
                    c31121.J$0 = j2;
                    c31121.label = 3;
                    all = HttpBodyKt.readAll(body, c31121);
                    if (all != coroutine_suspended) {
                        OperationRequest<HttpRequestBuilder> operationRequest5 = operationRequest3;
                        clock4 = clock3;
                        j = j2;
                        httpRequestBuilder2 = httpRequestBuilder;
                        operationRequest4 = operationRequest5;
                        httpCall2 = httpCall;
                        logger2 = logger;
                        bArr = (byte[]) all;
                        if (bArr != null) {
                        }
                    }
                }
                throw new EC2MetadataError(httpCall.getResponse().getStatus(), Intrinsics.areEqual(httpCall.getResponse().getStatus(), HttpStatusCode.INSTANCE.getForbidden()) ? "Request forbidden: IMDS is disabled or the caller has insufficient permissions." : "Failed to retrieve IMDS token");
            }
            if (i != 3) {
                if (i == 4) {
                    Token token = (Token) c31121.L$6;
                    ResultKt.throwOnFailure(all);
                    return token;
                }
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Throwable th2 = (Throwable) c31121.L$6;
                ResultKt.throwOnFailure(all);
                throw th2;
            }
            j = c31121.J$0;
            httpCall2 = (HttpCall) c31121.L$5;
            endpoint = (Endpoint) c31121.L$4;
            httpRequestBuilder2 = (HttpRequestBuilder) c31121.L$3;
            logger2 = (Logger) c31121.L$2;
            operationRequest4 = (OperationRequest) c31121.L$1;
            clock4 = (Clock) c31121.L$0;
            try {
                ResultKt.throwOnFailure(all);
                bArr = (byte[]) all;
            } catch (Throwable th3) {
                th = th3;
                c31121.L$0 = SpillingKt.nullOutSpilledVariable(clock4);
                c31121.L$1 = SpillingKt.nullOutSpilledVariable(operationRequest4);
                c31121.L$2 = SpillingKt.nullOutSpilledVariable(logger2);
                c31121.L$3 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder2);
                c31121.L$4 = SpillingKt.nullOutSpilledVariable(endpoint);
                c31121.L$5 = SpillingKt.nullOutSpilledVariable(httpCall2);
                c31121.L$6 = th;
                c31121.label = 5;
                if (HttpCallKt.complete(httpCall2, c31121) != coroutine_suspended) {
                    throw th;
                }
            }
            if (bArr != null) {
                throw new EC2MetadataError(HttpStatusCode.INSTANCE.getOK(), "No token provided in IMDS response");
            }
            Instant now = clock4.getNow();
            Duration.Companion companion = Duration.INSTANCE;
            Token token2 = new Token(bArr, now.m12289plusLRDsOJo(DurationKt.toDuration(j, DurationUnit.SECONDS)));
            c31121.L$0 = SpillingKt.nullOutSpilledVariable(clock4);
            c31121.L$1 = SpillingKt.nullOutSpilledVariable(operationRequest4);
            c31121.L$2 = SpillingKt.nullOutSpilledVariable(logger2);
            c31121.L$3 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder2);
            c31121.L$4 = SpillingKt.nullOutSpilledVariable(endpoint);
            c31121.L$5 = SpillingKt.nullOutSpilledVariable(httpCall2);
            c31121.L$6 = token2;
            c31121.label = 4;
            return HttpCallKt.complete(httpCall2, c31121) == coroutine_suspended ? coroutine_suspended : token2;
        }
        HttpRequestBuilder httpRequestBuilder5 = (HttpRequestBuilder) c31121.L$3;
        Logger logger5 = (Logger) c31121.L$2;
        OperationRequest<HttpRequestBuilder> operationRequest6 = (OperationRequest) c31121.L$1;
        Clock clock6 = (Clock) c31121.L$0;
        ResultKt.throwOnFailure(all);
        obj = all;
        operationRequest2 = operationRequest6;
        clock2 = clock6;
        logger = logger5;
        httpRequestBuilder = httpRequestBuilder5;
        Endpoint endpoint3 = (Endpoint) obj;
        OperationEndpointKt.setResolvedEndpoint(new OperationRequest(httpRequestBuilder), endpoint3);
        SdkHttpClient sdkHttpClient = this.httpClient;
        c31121.L$0 = clock2;
        c31121.L$1 = SpillingKt.nullOutSpilledVariable(operationRequest2);
        c31121.L$2 = logger;
        c31121.L$3 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
        c31121.L$4 = SpillingKt.nullOutSpilledVariable(endpoint3);
        c31121.label = 2;
        Object objCall = sdkHttpClient.call(httpRequestBuilder, (Continuation<? super HttpCall>) c31121);
        if (objCall != coroutine_suspended) {
            endpoint = endpoint3;
            clock3 = clock2;
            operationRequest3 = operationRequest2;
            all = objCall;
            httpCall = (HttpCall) all;
            Logger.trace$default(logger, null, new Function0() { // from class: aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ImdsClientKt.toTraceString(httpCall);
                }
            }, 1, null);
            if (!Intrinsics.areEqual(httpCall.getResponse().getStatus(), HttpStatusCode.INSTANCE.getOK())) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getToken$lambda$0() {
        return "refreshing IMDS token";
    }
}
