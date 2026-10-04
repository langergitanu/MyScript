package aws.sdk.kotlin.services.p010s3.internal;

import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.http.response.HttpResponseKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReaderKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Handle200ErrorsInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/internal/Handle200ErrorsInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "<init>", "()V", "modifyBeforeDeserialization", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "(Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Handle200ErrorsInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    public static final Handle200ErrorsInterceptor INSTANCE = new Handle200ErrorsInterceptor();

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.internal.Handle200ErrorsInterceptor$modifyBeforeDeserialization$1 */
    /* JADX INFO: compiled from: Handle200ErrorsInterceptor.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.internal.Handle200ErrorsInterceptor", m1609f = "Handle200ErrorsInterceptor.kt", m1610i = {0, 0}, m1611l = {28}, m1612m = "modifyBeforeDeserialization", m1613n = {WebViewMessageType.CONTEXT, "response"}, m1614nl = {29}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31441(Continuation<? super C31441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Handle200ErrorsInterceptor.this.modifyBeforeDeserialization(null, this);
        }
    }

    private Handle200ErrorsInterceptor() {
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    public /* bridge */ Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12026modifyBeforeAttemptCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    public /* bridge */ Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, continuation);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        C31441 c31441;
        HttpResponse httpResponse;
        Object objM14499constructorimpl;
        XmlToken.QualifiedName name;
        boolean z;
        if (continuation instanceof C31441) {
            c31441 = (C31441) continuation;
            if ((c31441.label & Integer.MIN_VALUE) != 0) {
                c31441.label -= Integer.MIN_VALUE;
            } else {
                c31441 = new C31441(continuation);
            }
        }
        Object obj = c31441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31441.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpResponse protocolResponse = protocolResponseInterceptorContext.getProtocolResponse();
            if (!HttpStatusCodeKt.isSuccess(protocolResponse.getStatus())) {
                return protocolResponse;
            }
            HttpBody body = protocolResponse.getBody();
            c31441.L$0 = SpillingKt.nullOutSpilledVariable(protocolResponseInterceptorContext);
            c31441.L$1 = protocolResponse;
            c31441.label = 1;
            Object all = HttpBodyKt.readAll(body, c31441);
            if (all == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpResponse = protocolResponse;
            obj = all;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            HttpResponse httpResponse2 = (HttpResponse) c31441.L$1;
            ResultKt.throwOnFailure(obj);
            httpResponse = httpResponse2;
        }
        byte[] bArr = (byte[]) obj;
        if (bArr == null) {
            return httpResponse;
        }
        XmlStreamReader xmlStreamReader = XmlStreamReaderKt.xmlStreamReader(bArr);
        try {
            Result.Companion companion = Result.INSTANCE;
            Handle200ErrorsInterceptor handle200ErrorsInterceptor = this;
            XmlToken lastToken = xmlStreamReader.getLastToken();
            do {
                z = lastToken instanceof XmlToken.BeginElement;
                if (!z) {
                    lastToken = xmlStreamReader.nextToken();
                }
                if (lastToken == null) {
                    break;
                }
            } while (!z);
            objM14499constructorimpl = Result.m14499constructorimpl((XmlToken.BeginElement) lastToken);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m14505isFailureimpl(objM14499constructorimpl)) {
            objM14499constructorimpl = null;
        }
        XmlToken.BeginElement beginElement = (XmlToken.BeginElement) objM14499constructorimpl;
        HttpStatusCode internalServerError = Intrinsics.areEqual((beginElement == null || (name = beginElement.getName()) == null) ? null : name.getLocal(), "Error") ? HttpStatusCode.INSTANCE.getInternalServerError() : null;
        if (internalServerError == null) {
            internalServerError = httpResponse.getStatus();
        }
        return HttpResponseKt.copy$default(httpResponse, internalServerError, null, HttpBody.INSTANCE.fromBytes(bArr), 2, null);
    }
}
