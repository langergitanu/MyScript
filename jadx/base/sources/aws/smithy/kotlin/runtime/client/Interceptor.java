package aws.smithy.kotlin.runtime.client;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001c\u0010\n\u001a\u00028\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001c\u0010\r\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00028\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016J\"\u0010\u0012\u001a\u00028\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0013\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016J\"\u0010\u0015\u001a\u00028\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0016\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0016J\"\u0010\u0017\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0018H\u0016J(\u0010\u0019\u001a\u00028\u00032\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0018H\u0096@¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0018H\u0016J(\u0010\u001c\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u001dH\u0016J8\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f2 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030\u001dH\u0096@¢\u0006\u0004\b \u0010!J*\u0010\"\u001a\u00020\u00072 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030\u001dH\u0016J:\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030\u001dH\u0096@¢\u0006\u0004\b$\u0010!J,\u0010%\u001a\u00020\u00072\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0002\u0012\u0006\u0012\u0004\u0018\u00018\u00030\u001dH\u0016¨\u0006&À\u0006\u0001"}, m1599d2 = {"Laws/smithy/kotlin/runtime/client/Interceptor;", "Input", "Output", "ProtocolRequest", "ProtocolResponse", "", "readBeforeExecution", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;", "modifyBeforeSerialization", "(Laws/smithy/kotlin/runtime/client/RequestInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBeforeSerialization", "readAfterSerialization", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", "modifyBeforeRetryLoop", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBeforeAttempt", "modifyBeforeSigning", "readBeforeSigning", "readAfterSigning", "modifyBeforeTransmit", "readBeforeTransmit", "readAfterTransmit", "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "modifyBeforeDeserialization", "(Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBeforeDeserialization", "readAfterDeserialization", "Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", "modifyBeforeAttemptCompletion", "Lkotlin/Result;", "modifyBeforeAttemptCompletion-gIAlu-s", "(Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAfterAttempt", "modifyBeforeCompletion", "modifyBeforeCompletion-gIAlu-s", "readAfterExecution", "smithy-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> {
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    default Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> responseInterceptorContext, Continuation<? super Result<? extends Output>> continuation) {
        return m12147modifyBeforeAttemptCompletiongIAlus$suspendImpl(this, responseInterceptorContext, continuation);
    }

    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    default Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> responseInterceptorContext, Continuation<? super Result<? extends Output>> continuation) {
        return m12148modifyBeforeCompletiongIAlus$suspendImpl(this, responseInterceptorContext, continuation);
    }

    default Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Input, ProtocolRequest, ProtocolResponse> protocolResponseInterceptorContext, Continuation<? super ProtocolResponse> continuation) {
        return modifyBeforeDeserialization$suspendImpl(this, protocolResponseInterceptorContext, continuation);
    }

    default Object modifyBeforeRetryLoop(ProtocolRequestInterceptorContext<Input, ProtocolRequest> protocolRequestInterceptorContext, Continuation<? super ProtocolRequest> continuation) {
        return modifyBeforeRetryLoop$suspendImpl(this, protocolRequestInterceptorContext, continuation);
    }

    default Object modifyBeforeSerialization(RequestInterceptorContext<Input> requestInterceptorContext, Continuation<? super Input> continuation) {
        return modifyBeforeSerialization$suspendImpl(this, requestInterceptorContext, continuation);
    }

    default Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Input, ProtocolRequest> protocolRequestInterceptorContext, Continuation<? super ProtocolRequest> continuation) {
        return modifyBeforeSigning$suspendImpl(this, protocolRequestInterceptorContext, continuation);
    }

    default Object modifyBeforeTransmit(ProtocolRequestInterceptorContext<Input, ProtocolRequest> protocolRequestInterceptorContext, Continuation<? super ProtocolRequest> continuation) {
        return modifyBeforeTransmit$suspendImpl(this, protocolRequestInterceptorContext, continuation);
    }

    default void readAfterAttempt(ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readAfterDeserialization(ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readAfterExecution(ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readAfterSerialization(ProtocolRequestInterceptorContext<Input, ProtocolRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readAfterSigning(ProtocolRequestInterceptorContext<Input, ProtocolRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readAfterTransmit(ProtocolResponseInterceptorContext<Input, ProtocolRequest, ProtocolResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readBeforeAttempt(ProtocolRequestInterceptorContext<Input, ProtocolRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readBeforeDeserialization(ProtocolResponseInterceptorContext<Input, ProtocolRequest, ProtocolResponse> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readBeforeExecution(RequestInterceptorContext<Input> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readBeforeSerialization(RequestInterceptorContext<Input> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readBeforeSigning(ProtocolRequestInterceptorContext<Input, ProtocolRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    default void readBeforeTransmit(ProtocolRequestInterceptorContext<Input, ProtocolRequest> context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object modifyBeforeSerialization$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, RequestInterceptorContext<Input> requestInterceptorContext, Continuation<? super Input> continuation) {
        return requestInterceptorContext.getRequest();
    }

    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object modifyBeforeRetryLoop$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, ProtocolRequestInterceptorContext<Input, ProtocolRequest> protocolRequestInterceptorContext, Continuation<? super ProtocolRequest> continuation) {
        return protocolRequestInterceptorContext.getProtocolRequest();
    }

    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object modifyBeforeSigning$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, ProtocolRequestInterceptorContext<Input, ProtocolRequest> protocolRequestInterceptorContext, Continuation<? super ProtocolRequest> continuation) {
        return protocolRequestInterceptorContext.getProtocolRequest();
    }

    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object modifyBeforeTransmit$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, ProtocolRequestInterceptorContext<Input, ProtocolRequest> protocolRequestInterceptorContext, Continuation<? super ProtocolRequest> continuation) {
        return protocolRequestInterceptorContext.getProtocolRequest();
    }

    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object modifyBeforeDeserialization$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, ProtocolResponseInterceptorContext<Input, ProtocolRequest, ProtocolResponse> protocolResponseInterceptorContext, Continuation<? super ProtocolResponse> continuation) {
        return protocolResponseInterceptorContext.getProtocolResponse();
    }

    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s$suspendImpl, reason: not valid java name */
    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object m12147modifyBeforeAttemptCompletiongIAlus$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> responseInterceptorContext, Continuation<? super Result<? extends Output>> continuation) {
        return responseInterceptorContext.mo12149getResponsed1pmJ48();
    }

    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s$suspendImpl, reason: not valid java name */
    static /* synthetic */ <Input, Output, ProtocolRequest, ProtocolResponse> Object m12148modifyBeforeCompletiongIAlus$suspendImpl(Interceptor<Input, Output, ProtocolRequest, ProtocolResponse> interceptor, ResponseInterceptorContext<Input, Output, ProtocolRequest, ProtocolResponse> responseInterceptorContext, Continuation<? super Result<? extends Output>> continuation) {
        return responseInterceptorContext.mo12149getResponsed1pmJ48();
    }
}
