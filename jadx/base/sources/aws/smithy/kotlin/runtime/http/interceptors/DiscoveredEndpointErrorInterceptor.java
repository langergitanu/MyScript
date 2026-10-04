package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.ErrorMetadata;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.ServiceException;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: DiscoveredEndpointErrorInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B;\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122 \u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R0\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/DiscoveredEndpointErrorInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "Lkotlin/reflect/KClass;", "Laws/smithy/kotlin/runtime/ServiceException;", "errorType", "Lkotlin/Function2;", "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "Lkotlin/coroutines/Continuation;", "", "invalidate", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function2;)V", "Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", WebViewMessageType.CONTEXT, "Lkotlin/Result;", "modifyBeforeAttemptCompletion-gIAlu-s", "(Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyBeforeAttemptCompletion", "Lkotlin/reflect/KClass;", "Lkotlin/jvm/functions/Function2;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DiscoveredEndpointErrorInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    private final KClass<? extends ServiceException> errorType;
    private final Function2<ExecutionContext, Continuation<? super Unit>, Object> invalidate;

    /* JADX WARN: Multi-variable type inference failed */
    public DiscoveredEndpointErrorInterceptor(KClass<? extends ServiceException> errorType, Function2<? super ExecutionContext, ? super Continuation<? super Unit>, ? extends Object> invalidate) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(invalidate, "invalidate");
        this.errorType = errorType;
        this.invalidate = invalidate;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    public /* bridge */ Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        return super.modifyBeforeDeserialization(protocolResponseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeRetryLoop(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeRetryLoop(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext, Continuation<? super Object> continuation) {
        return super.modifyBeforeSerialization(requestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeSigning(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeTransmit(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterAttempt(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterAttempt(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterDeserialization(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterDeserialization(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterExecution(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterExecution(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSerialization(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSerialization(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterTransmit(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext) {
        super.readAfterTransmit(protocolResponseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeAttempt(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeAttempt(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext) {
        super.readBeforeDeserialization(protocolResponseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeExecution(RequestInterceptorContext<Object> requestInterceptorContext) {
        super.readBeforeExecution(requestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext) {
        super.readBeforeSerialization(requestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeTransmit(protocolRequestInterceptorContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        C3711xd1c8f3d3 c3711xd1c8f3d3;
        ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext2;
        Throwable th;
        if (continuation instanceof C3711xd1c8f3d3) {
            c3711xd1c8f3d3 = (C3711xd1c8f3d3) continuation;
            if ((c3711xd1c8f3d3.label & Integer.MIN_VALUE) != 0) {
                c3711xd1c8f3d3.label -= Integer.MIN_VALUE;
            } else {
                c3711xd1c8f3d3 = new C3711xd1c8f3d3(this, continuation);
            }
        }
        Object obj = c3711xd1c8f3d3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c3711xd1c8f3d3.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(responseInterceptorContext.mo12149getResponsed1pmJ48());
            if (thM14502exceptionOrNullimpl != null && this.errorType.isInstance(thM14502exceptionOrNullimpl)) {
                Function2<ExecutionContext, Continuation<? super Unit>, Object> function2 = this.invalidate;
                ExecutionContext executionContext = responseInterceptorContext.getExecutionContext();
                c3711xd1c8f3d3.L$0 = responseInterceptorContext;
                c3711xd1c8f3d3.L$1 = thM14502exceptionOrNullimpl;
                c3711xd1c8f3d3.I$0 = 0;
                c3711xd1c8f3d3.label = 1;
                if (function2.invoke(executionContext, c3711xd1c8f3d3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                responseInterceptorContext2 = responseInterceptorContext;
                th = thM14502exceptionOrNullimpl;
            }
            return responseInterceptorContext.mo12149getResponsed1pmJ48();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c3711xd1c8f3d3.I$0;
        th = (Throwable) c3711xd1c8f3d3.L$1;
        responseInterceptorContext2 = (ResponseInterceptorContext) c3711xd1c8f3d3.L$0;
        ResultKt.throwOnFailure(obj);
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.ServiceException");
        ((ServiceException) th).getSdkErrorMetadata().getAttributes().set(ErrorMetadata.INSTANCE.getRetryable(), Boxing.boxBoolean(true));
        responseInterceptorContext = responseInterceptorContext2;
        return responseInterceptorContext.mo12149getResponsed1pmJ48();
    }
}
