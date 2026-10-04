package aws.smithy.kotlin.runtime.http.response;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.ProtocolResponse;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.content.ByteArrayContent;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a(\u0010\b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\n\u001a\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e*\u00020\u000b2\u0006\u0010\f\u001a\u00020\n\u001a\f\u0010\u000f\u001a\u0004\u0018\u00010\u0003*\u00020\u000b\u001a*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0087@¢\u0006\u0002\u0010\u0015\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0001¨\u0006\u0018"}, m1599d2 = {"HttpResponse", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", NotificationCompat.CATEGORY_STATUS, "Laws/smithy/kotlin/runtime/http/HttpStatusCode;", "headers", "Laws/smithy/kotlin/runtime/http/Headers;", TtmlNode.TAG_BODY, "Laws/smithy/kotlin/runtime/http/HttpBody;", "copy", "header", "", "Laws/smithy/kotlin/runtime/ProtocolResponse;", "name", "getAllHeaders", "", "statusCode", "dumpResponse", "Lkotlin/Pair;", "response", "dumpBody", "", "(Laws/smithy/kotlin/runtime/http/response/HttpResponse;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toBuilder", "Laws/smithy/kotlin/runtime/http/response/HttpResponseBuilder;", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpResponseKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.response.HttpResponseKt$dumpResponse$1 */
    /* JADX INFO: compiled from: HttpResponse.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.response.HttpResponseKt", m1609f = "HttpResponse.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY}, m1612m = "dumpResponse", m1613n = {"response", "buffer", "respCopy", TtmlNode.TAG_BODY, "dumpBody"}, m1614nl = {110}, m1615s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, m1616v = 2)
    static final class C37411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C37411(Continuation<? super C37411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.dumpResponse(null, false, this);
        }
    }

    public static /* synthetic */ HttpResponse HttpResponse$default(HttpStatusCode httpStatusCode, Headers headers, HttpBody httpBody, int i, Object obj) {
        if ((i & 2) != 0) {
            headers = Headers.INSTANCE.getEmpty();
        }
        if ((i & 4) != 0) {
            httpBody = HttpBody.Empty.INSTANCE;
        }
        return HttpResponse(httpStatusCode, headers, httpBody);
    }

    public static final HttpResponse HttpResponse(HttpStatusCode status, Headers headers, HttpBody body) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        return new DefaultHttpResponse(status, headers, body);
    }

    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, HttpStatusCode httpStatusCode, Headers headers, HttpBody httpBody, int i, Object obj) {
        if ((i & 1) != 0) {
            httpStatusCode = httpResponse.getStatus();
        }
        if ((i & 2) != 0) {
            headers = httpResponse.getHeaders();
        }
        if ((i & 4) != 0) {
            httpBody = httpResponse.getBody();
        }
        return copy(httpResponse, httpStatusCode, headers, httpBody);
    }

    public static final HttpResponse copy(HttpResponse httpResponse, HttpStatusCode status, Headers headers, HttpBody body) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        return HttpResponse(status, headers, body);
    }

    public static final String header(ProtocolResponse protocolResponse, String name) {
        Headers headers;
        Intrinsics.checkNotNullParameter(protocolResponse, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        HttpResponse httpResponse = protocolResponse instanceof HttpResponse ? (HttpResponse) protocolResponse : null;
        if (httpResponse == null || (headers = httpResponse.getHeaders()) == null) {
            return null;
        }
        return headers.get(name);
    }

    public static final List<String> getAllHeaders(ProtocolResponse protocolResponse, String name) {
        Headers headers;
        Intrinsics.checkNotNullParameter(protocolResponse, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        HttpResponse httpResponse = protocolResponse instanceof HttpResponse ? (HttpResponse) protocolResponse : null;
        if (httpResponse == null || (headers = httpResponse.getHeaders()) == null) {
            return null;
        }
        return headers.getAll(name);
    }

    public static final HttpStatusCode statusCode(ProtocolResponse protocolResponse) {
        Intrinsics.checkNotNullParameter(protocolResponse, "<this>");
        HttpResponse httpResponse = protocolResponse instanceof HttpResponse ? (HttpResponse) protocolResponse : null;
        if (httpResponse != null) {
            return httpResponse.getStatus();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object dumpResponse(HttpResponse httpResponse, boolean z, Continuation<? super Pair<? extends HttpResponse, String>> continuation) throws IOException {
        C37411 c37411;
        final SdkBuffer sdkBuffer;
        SdkBuffer sdkBuffer2;
        HttpResponse httpResponse2;
        if (continuation instanceof C37411) {
            c37411 = (C37411) continuation;
            if ((c37411.label & Integer.MIN_VALUE) != 0) {
                c37411.label -= Integer.MIN_VALUE;
            } else {
                c37411 = new C37411(continuation);
            }
        }
        Object obj = c37411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37411.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sdkBuffer = new SdkBuffer();
            SdkBuffer sdkBuffer3 = sdkBuffer;
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, "HTTP " + httpResponse.getStatus() + "\r\n", 0, 0, 6, null);
            httpResponse.getHeaders().forEach(new Function2() { // from class: aws.smithy.kotlin.runtime.http.response.HttpResponseKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return HttpResponseKt.dumpResponse$lambda$0(sdkBuffer, (String) obj2, (List) obj3);
                }
            });
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, "\r\n", 0, 0, 6, null);
            if (z) {
                HttpBody body = httpResponse.getBody();
                if (body instanceof HttpBody.Bytes) {
                    SdkBufferedSink.write$default(sdkBuffer3, ((HttpBody.Bytes) body).getBytes(), 0, 0, 6, null);
                } else if ((body instanceof HttpBody.ChannelContent) || (body instanceof HttpBody.SourceContent)) {
                    c37411.L$0 = httpResponse;
                    c37411.L$1 = sdkBuffer;
                    c37411.L$2 = httpResponse;
                    c37411.L$3 = SpillingKt.nullOutSpilledVariable(body);
                    c37411.Z$0 = z;
                    c37411.label = 1;
                    Object all = HttpBodyKt.readAll(body, c37411);
                    if (all == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = all;
                    sdkBuffer2 = sdkBuffer;
                    httpResponse2 = httpResponse;
                } else if (!(body instanceof HttpBody.Empty)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return TuplesKt.m1606to(httpResponse, sdkBuffer.readUtf8());
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z2 = c37411.Z$0;
        httpResponse = (HttpResponse) c37411.L$2;
        sdkBuffer2 = (SdkBuffer) c37411.L$1;
        HttpResponse httpResponse3 = (HttpResponse) c37411.L$0;
        ResultKt.throwOnFailure(obj);
        httpResponse2 = httpResponse3;
        byte[] bArr = (byte[]) obj;
        if (bArr != null) {
            SdkBufferedSink.write$default(sdkBuffer2, bArr, 0, 0, 6, null);
            httpResponse = copy$default(httpResponse2, null, null, new ByteArrayContent(bArr), 3, null);
        }
        sdkBuffer = sdkBuffer2;
        return TuplesKt.m1606to(httpResponse, sdkBuffer.readUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dumpResponse$lambda$0(SdkBuffer sdkBuffer, String key, List values) throws IOException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        SdkBufferedSink.writeUtf8$default(sdkBuffer, CollectionsKt.joinToString$default(values, Literals.COMMENT_2, key + ": ", "\r\n", 0, null, null, 56, null), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    public static final HttpResponseBuilder toBuilder(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        if (httpResponse instanceof HttpResponseBuilderView) {
            HttpResponseBuilderView httpResponseBuilderView = (HttpResponseBuilderView) httpResponse;
            if (!httpResponseBuilderView.getAllowToBuilder$http()) {
                throw new IllegalStateException("This is an immutable HttpResponse that should not be converted to a builder".toString());
            }
            return httpResponseBuilderView.getBuilder$http();
        }
        HttpResponseBuilder httpResponseBuilder = new HttpResponseBuilder();
        httpResponseBuilder.setStatus(httpResponse.getStatus());
        httpResponseBuilder.getHeaders().appendAll(httpResponse.getHeaders());
        httpResponseBuilder.setBody(httpResponse.getBody());
        return httpResponseBuilder;
    }
}
