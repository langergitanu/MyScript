package aws.smithy.kotlin.runtime.http.operation;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetricsUtilsKt;
import aws.smithy.kotlin.runtime.client.LogMode;
import aws.smithy.kotlin.runtime.client.SdkClientOptionKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.http.response.HttpResponseKt;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.p011io.middleware.MiddlewareKt;
import aws.smithy.kotlin.runtime.p011io.middleware.Phase;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\\\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001as\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022 \u0010\t\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003j\u0002`\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001ai\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H\u0002¢\u0006\u0004\b\f\u0010\u0014\u001am\u0010\f\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u000f*\b\u0012\u0004\u0012\u00028\u00010\u00152\u001c\u0010\u0011\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00032\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H\u0002¢\u0006\u0004\b\f\u0010\u0016\u001a@\u0010\u0019\u001a\u00020\u00072\u0010\u0010\u0017\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u001c\u0010\u0018\u001a\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003H\u0082@¢\u0006\u0004\b\u0019\u0010\u001a\u001a!\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!*\u001c\b\u0007\u0010#\"\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0002\b\"¨\u0006$"}, m1599d2 = {"Request", "Response", "Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "Laws/smithy/kotlin/runtime/http/HttpHandler;", "handler", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;", "op", "decorate", "(Laws/smithy/kotlin/runtime/http/operation/SdkOperationExecution;Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/operation/SdkHttpOperation;)Laws/smithy/kotlin/runtime/io/Handler;", "I", "O", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;", "inner", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "(Laws/smithy/kotlin/runtime/http/operation/HttpSerializer;Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;", "(Laws/smithy/kotlin/runtime/http/operation/HttpDeserializer;Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)Laws/smithy/kotlin/runtime/io/Handler;", "request", "next", "httpTraceMiddleware", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/identity/Identity;", HTTP.IDENTITY_CODING, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "", "emitIdentityBusinessMetrics", "(Laws/smithy/kotlin/runtime/identity/Identity;Laws/smithy/kotlin/runtime/operation/ExecutionContext;)Lkotlin/Unit;", "Laws/smithy/kotlin/runtime/InternalApi;", "SdkHttpRequest", "http-client"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkOperationExecutionKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt$httpTraceMiddleware$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt", m1609f = "SdkOperationExecution.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m1611l = {389, 393, 396}, m1612m = "httpTraceMiddleware", m1613n = {"request", "next", "logMode", "logger", "request", "next", "logMode", "logger", NotificationCompat.CATEGORY_CALL, "request", "next", "logMode", "logger", NotificationCompat.CATEGORY_CALL}, m1614nl = {390, 395, 397}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, m1616v = 2)
    static final class C37361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C37361(Continuation<? super C37361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SdkOperationExecutionKt.httpTraceMiddleware(null, null, this);
        }
    }

    @InternalApi
    public static /* synthetic */ void SdkHttpRequest$annotations() {
    }

    public static final <Request, Response> Handler<OperationRequest<Request>, Response> decorate(SdkOperationExecution<Request, Response> sdkOperationExecution, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, SdkHttpOperation<Request, Response> op) {
        Intrinsics.checkNotNullParameter(sdkOperationExecution, "<this>");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(op, "op");
        InterceptorExecutor interceptorExecutor = new InterceptorExecutor(op.getContext(), op.getInterceptors(), op.getTypeInfo());
        Phase.register$default(sdkOperationExecution.getReceive(), new HttpCallMiddleware(), (Phase.Order) null, 2, (Object) null);
        Phase.register$default(sdkOperationExecution.getReceive(), new InterceptorTransmitMiddleware(interceptorExecutor), (Phase.Order) null, 2, (Object) null);
        sdkOperationExecution.getReceive().intercept(Phase.Order.After, C37351.INSTANCE);
        return new OperationHandler(MiddlewareKt.decorate(new InitializeHandler(decorate(op.getSerializer$http_client(), MiddlewareKt.decorate(new MutateHandler(MiddlewareKt.decorate(MiddlewareKt.decorate(new AuthHandler(decorate(op.getDeserializer$http_client(), (Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>) MiddlewareKt.decorate(handler, sdkOperationExecution.getReceive()), interceptorExecutor), interceptorExecutor, sdkOperationExecution.getAuth(), sdkOperationExecution.getEndpointResolver()), sdkOperationExecution.getOnEachAttempt()), new RetryMiddleware(sdkOperationExecution.getRetryStrategy(), sdkOperationExecution.getRetryPolicy(), interceptorExecutor))), sdkOperationExecution.getMutate()), interceptorExecutor)), sdkOperationExecution.getInitialize()), interceptorExecutor);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt$decorate$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C37351 extends FunctionReferenceImpl implements Function3<OperationRequest<HttpRequestBuilder>, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>, Continuation<? super HttpCall>, Object>, SuspendFunction {
        public static final C37351 INSTANCE = new C37351();

        C37351() {
            super(3, SdkOperationExecutionKt.class, "httpTraceMiddleware", "httpTraceMiddleware(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 1);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, Continuation<? super HttpCall> continuation) {
            return SdkOperationExecutionKt.httpTraceMiddleware(operationRequest, handler, continuation);
        }
    }

    private static final <I, O> Handler<OperationRequest<I>, O> decorate(HttpSerializer<I> httpSerializer, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends O> handler, InterceptorExecutor<I, O> interceptorExecutor) {
        return new SerializeHandler(handler, httpSerializer, interceptorExecutor);
    }

    private static final <I, O> Handler<OperationRequest<HttpRequestBuilder>, O> decorate(HttpDeserializer<O> httpDeserializer, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, InterceptorExecutor<I, O> interceptorExecutor) {
        return new DeserializeHandler(handler, httpDeserializer, interceptorExecutor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, aws.smithy.kotlin.runtime.http.HttpCall] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object httpTraceMiddleware(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler, Continuation<? super HttpCall> continuation) throws IOException {
        C37361 c37361;
        LogMode logMode;
        Logger logger;
        Object obj;
        OperationRequest<HttpRequestBuilder> operationRequest2;
        Logger logger2;
        Object objCall;
        LogMode logMode2;
        T t;
        OperationRequest<HttpRequestBuilder> operationRequest3;
        Ref.ObjectRef objectRef;
        Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler2;
        final Ref.ObjectRef objectRef2;
        Object objDumpResponse;
        Ref.ObjectRef objectRef3;
        Logger logger3;
        Object obj2;
        if (continuation instanceof C37361) {
            c37361 = (C37361) continuation;
            if ((c37361.label & Integer.MIN_VALUE) != 0) {
                c37361.label -= Integer.MIN_VALUE;
            } else {
                c37361 = new C37361(continuation);
            }
        }
        Object obj3 = c37361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37361.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj3);
            logMode = SdkClientOptionKt.getLogMode(operationRequest.getContext());
            logger = CoroutineContextLogExtKt.logger(c37361.get$context(), "httpTraceMiddleware");
            if (logMode.isEnabled(LogMode.LogRequest.INSTANCE) || logMode.isEnabled(LogMode.LogRequestWithBody.INSTANCE)) {
                HttpRequestBuilder subject = operationRequest.getSubject();
                boolean zIsEnabled = logMode.isEnabled(LogMode.LogRequestWithBody.INSTANCE);
                c37361.L$0 = operationRequest;
                c37361.L$1 = handler;
                c37361.L$2 = logMode;
                c37361.L$3 = logger;
                c37361.label = 1;
                Object objDumpRequest = HttpRequestBuilderKt.dumpRequest(subject, zIsEnabled, c37361);
                if (objDumpRequest != coroutine_suspended) {
                    obj = objDumpRequest;
                    operationRequest2 = operationRequest;
                    logger2 = logger;
                }
            } else {
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                c37361.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
                c37361.L$1 = SpillingKt.nullOutSpilledVariable(handler);
                c37361.L$2 = logMode;
                c37361.L$3 = logger;
                c37361.L$4 = objectRef4;
                c37361.L$5 = objectRef4;
                c37361.label = 2;
                objCall = handler.call(operationRequest, c37361);
                if (objCall != coroutine_suspended) {
                    logMode2 = logMode;
                    t = objCall;
                    operationRequest3 = operationRequest;
                    objectRef = objectRef4;
                    handler2 = handler;
                    objectRef2 = objectRef;
                    objectRef.element = t;
                    if (!logMode2.isEnabled(LogMode.LogResponse.INSTANCE)) {
                    }
                    HttpResponse response = ((HttpCall) objectRef2.element).getResponse();
                    boolean zIsEnabled2 = logMode2.isEnabled(LogMode.LogResponseWithBody.INSTANCE);
                    c37361.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest3);
                    c37361.L$1 = SpillingKt.nullOutSpilledVariable(handler2);
                    c37361.L$2 = SpillingKt.nullOutSpilledVariable(logMode2);
                    c37361.L$3 = logger;
                    c37361.L$4 = objectRef2;
                    c37361.L$5 = null;
                    c37361.label = 3;
                    objDumpResponse = HttpResponseKt.dumpResponse(response, zIsEnabled2, c37361);
                    if (objDumpResponse != coroutine_suspended) {
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef3 = (Ref.ObjectRef) c37361.L$4;
                logger3 = (Logger) c37361.L$3;
                ResultKt.throwOnFailure(obj3);
                obj2 = obj3;
                Pair pair = (Pair) obj2;
                HttpResponse httpResponse = (HttpResponse) pair.component1();
                final String str = (String) pair.component2();
                objectRef3.element = HttpCall.copy$default((HttpCall) objectRef3.element, null, httpResponse, 1, null);
                Logger.debug$default(logger3, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SdkOperationExecutionKt.httpTraceMiddleware$lambda$1(str);
                    }
                }, 1, null);
                objectRef2 = objectRef3;
                return objectRef2.element;
            }
            objectRef = (Ref.ObjectRef) c37361.L$5;
            objectRef2 = (Ref.ObjectRef) c37361.L$4;
            logger = (Logger) c37361.L$3;
            logMode2 = (LogMode) c37361.L$2;
            handler2 = (Handler) c37361.L$1;
            operationRequest3 = (OperationRequest) c37361.L$0;
            ResultKt.throwOnFailure(obj3);
            t = obj3;
            objectRef.element = t;
            if (!logMode2.isEnabled(LogMode.LogResponse.INSTANCE) || logMode2.isEnabled(LogMode.LogResponseWithBody.INSTANCE)) {
                HttpResponse response2 = ((HttpCall) objectRef2.element).getResponse();
                boolean zIsEnabled22 = logMode2.isEnabled(LogMode.LogResponseWithBody.INSTANCE);
                c37361.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest3);
                c37361.L$1 = SpillingKt.nullOutSpilledVariable(handler2);
                c37361.L$2 = SpillingKt.nullOutSpilledVariable(logMode2);
                c37361.L$3 = logger;
                c37361.L$4 = objectRef2;
                c37361.L$5 = null;
                c37361.label = 3;
                objDumpResponse = HttpResponseKt.dumpResponse(response2, zIsEnabled22, c37361);
                if (objDumpResponse != coroutine_suspended) {
                    objectRef3 = objectRef2;
                    logger3 = logger;
                    obj2 = objDumpResponse;
                    Pair pair2 = (Pair) obj2;
                    HttpResponse httpResponse2 = (HttpResponse) pair2.component1();
                    final String str2 = (String) pair2.component2();
                    objectRef3.element = HttpCall.copy$default((HttpCall) objectRef3.element, null, httpResponse2, 1, null);
                    Logger.debug$default(logger3, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SdkOperationExecutionKt.httpTraceMiddleware$lambda$1(str2);
                        }
                    }, 1, null);
                    objectRef2 = objectRef3;
                    return objectRef2.element;
                }
                return coroutine_suspended;
            }
            Logger.debug$default(logger, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SdkOperationExecutionKt.httpTraceMiddleware$lambda$2(objectRef2);
                }
            }, 1, null);
            return objectRef2.element;
        }
        logger2 = (Logger) c37361.L$3;
        LogMode logMode3 = (LogMode) c37361.L$2;
        Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall> handler3 = (Handler) c37361.L$1;
        operationRequest2 = (OperationRequest) c37361.L$0;
        ResultKt.throwOnFailure(obj3);
        obj = obj3;
        logMode = logMode3;
        handler = handler3;
        final String str3 = (String) obj;
        Logger.debug$default(logger2, null, new Function0() { // from class: aws.smithy.kotlin.runtime.http.operation.SdkOperationExecutionKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SdkOperationExecutionKt.httpTraceMiddleware$lambda$0(str3);
            }
        }, 1, null);
        logger = logger2;
        operationRequest = operationRequest2;
        Ref.ObjectRef objectRef42 = new Ref.ObjectRef();
        c37361.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
        c37361.L$1 = SpillingKt.nullOutSpilledVariable(handler);
        c37361.L$2 = logMode;
        c37361.L$3 = logger;
        c37361.L$4 = objectRef42;
        c37361.L$5 = objectRef42;
        c37361.label = 2;
        objCall = handler.call(operationRequest, c37361);
        if (objCall != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String httpTraceMiddleware$lambda$0(String str) {
        return "HttpRequest:\n" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String httpTraceMiddleware$lambda$1(String str) {
        return "HttpResponse:\n" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final String httpTraceMiddleware$lambda$2(Ref.ObjectRef objectRef) {
        return "HttpResponse: " + ((HttpCall) objectRef.element).getResponse().getStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitIdentityBusinessMetrics(Identity identity, ExecutionContext executionContext) {
        List list;
        List listReversed;
        Set set = (Set) identity.getAttributes().getOrNull(BusinessMetricsUtilsKt.getBusinessMetrics());
        if (set == null || (list = CollectionsKt.toList(set)) == null || (listReversed = CollectionsKt.reversed(list)) == null) {
            return null;
        }
        Iterator it = listReversed.iterator();
        while (it.hasNext()) {
            BusinessMetricsUtilsKt.emitBusinessMetric(executionContext, (BusinessMetric) it.next());
        }
        return Unit.INSTANCE;
    }
}
