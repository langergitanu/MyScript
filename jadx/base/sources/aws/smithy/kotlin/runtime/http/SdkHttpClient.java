package aws.smithy.kotlin.runtime.http;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.http.engine.CoroutineUtilsKt;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngine;
import aws.smithy.kotlin.runtime.http.engine.HttpClientEngineClosedException;
import aws.smithy.kotlin.runtime.http.engine.SdkRequestContextElement;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.p011io.Handler;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: SdkHttpClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\r\u0010\u000fJ\"\u0010\r\u001a\u00020\u00052\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0096@¢\u0006\u0004\b\r\u0010\u0010J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/SdkHttpClient;", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "Laws/smithy/kotlin/runtime/http/HttpHandler;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "engine", "<init>", "(Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;)V", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "request", NotificationCompat.CATEGORY_CALL, "(Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", WebViewMessageType.CONTEXT, "executeWithCallContext", "(Laws/smithy/kotlin/runtime/operation/ExecutionContext;Laws/smithy/kotlin/runtime/http/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "getEngine", "()Laws/smithy/kotlin/runtime/http/engine/HttpClientEngine;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SdkHttpClient implements Handler<OperationRequest<HttpRequestBuilder>, HttpCall> {
    private final HttpClientEngine engine;

    public SdkHttpClient(HttpClientEngine engine) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        this.engine = engine;
    }

    public final HttpClientEngine getEngine() {
        return this.engine;
    }

    public final Object call(HttpRequest httpRequest, Continuation<? super HttpCall> continuation) {
        return executeWithCallContext(new ExecutionContext(), httpRequest, continuation);
    }

    public final Object call(HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpCall> continuation) {
        return call(httpRequestBuilder.build(), continuation);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    public Object call(OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super HttpCall> continuation) {
        return executeWithCallContext(operationRequest.getContext(), operationRequest.getSubject().build(), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeWithCallContext(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super HttpCall> continuation) {
        if (!JobKt.getJob(this.engine.getCoroutineContext()).isActive()) {
            throw new HttpClientEngineClosedException(null, 1, null);
        }
        CoroutineContext coroutineContextCreateCallContext = CoroutineUtilsKt.createCallContext(this.engine, continuation.get$context());
        return BuildersKt__Builders_commonKt.async$default(this.engine, coroutineContextCreateCallContext.plus(new SdkRequestContextElement(coroutineContextCreateCallContext)), null, new C36982(executionContext, httpRequest, null), 2, null).await(continuation);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.SdkHttpClient$executeWithCallContext$2 */
    /* JADX INFO: compiled from: SdkHttpClient.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/smithy/kotlin/runtime/http/HttpCall;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.SdkHttpClient$executeWithCallContext$2", m1609f = "SdkHttpClient.kt", m1610i = {}, m1611l = {44}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C36982 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpCall>, Object> {
        final /* synthetic */ ExecutionContext $context;
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36982(ExecutionContext executionContext, HttpRequest httpRequest, Continuation<? super C36982> continuation) {
            super(2, continuation);
            this.$context = executionContext;
            this.$request = httpRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SdkHttpClient.this.new C36982(this.$context, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpCall> continuation) {
            return ((C36982) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            this.label = 1;
            Object objRoundTrip = SdkHttpClient.this.getEngine().roundTrip(this.$context, this.$request, this);
            return objRoundTrip == coroutine_suspended ? coroutine_suspended : objRoundTrip;
        }
    }
}
