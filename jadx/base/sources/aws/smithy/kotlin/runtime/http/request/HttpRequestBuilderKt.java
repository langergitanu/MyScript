package aws.smithy.kotlin.runtime.http.request;

import androidx.compose.runtime.GapComposerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkIoKt;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import com.google.android.gms.common.internal.ImagesContract;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: HttpRequestBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a)\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0015\u001a\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, m1599d2 = {"immutableView", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "allowToBuilder", "", ImagesContract.URL, "", "block", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/net/url/Url$Builder;", "Lkotlin/ExtensionFunctionType;", "value", "Laws/smithy/kotlin/runtime/net/url/Url;", "headers", "Laws/smithy/kotlin/runtime/http/HeadersBuilder;", "header", "name", "", "dumpRequest", "request", "dumpBody", "(Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyHttpBody", "Laws/smithy/kotlin/runtime/http/HttpBody;", "original", "buffer", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "(Laws/smithy/kotlin/runtime/http/HttpBody;Laws/smithy/kotlin/runtime/io/SdkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HttpRequestBuilderKt {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt$copyHttpBody$1 */
    /* JADX INFO: compiled from: HttpRequestBuilder.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt", m1609f = "HttpRequestBuilder.kt", m1610i = {0, 0}, m1611l = {PDFACompliance.e_PDFA1_3_3}, m1612m = "copyHttpBody", m1613n = {"original", "buffer"}, m1614nl = {134}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C37381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37381(Continuation<? super C37381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpRequestBuilderKt.copyHttpBody(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt$dumpRequest$1 */
    /* JADX INFO: compiled from: HttpRequestBuilder.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt", m1609f = "HttpRequestBuilder.kt", m1610i = {0, 0, 0, 0, 0, 0}, m1611l = {PDFACompliance.e_PDFA1_2_3}, m1612m = "dumpRequest", m1613n = {"request", "buffer", "skip", TtmlNode.TAG_BODY, "dumpBody", "contentLength"}, m1614nl = {GapComposerKt.nodeKey}, m1615s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "J$0"}, m1616v = 2)
    static final class C37401 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C37401(Continuation<? super C37401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpRequestBuilderKt.dumpRequest(null, false, this);
        }
    }

    public static /* synthetic */ HttpRequest immutableView$default(HttpRequestBuilder httpRequestBuilder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return immutableView(httpRequestBuilder, z);
    }

    @InternalApi
    public static final HttpRequest immutableView(HttpRequestBuilder httpRequestBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return new HttpRequestBuilderView(httpRequestBuilder, z);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Function1<? super Url.Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(httpRequestBuilder.getUrl());
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Url value) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        httpRequestBuilder.getUrl().copyFrom(value);
    }

    public static final void headers(HttpRequestBuilder httpRequestBuilder, Function1<? super HeadersBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(httpRequestBuilder.getHeaders());
    }

    public static final void header(HttpRequestBuilder httpRequestBuilder, String name, String value) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        httpRequestBuilder.getHeaders().append(name, value);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object dumpRequest(HttpRequestBuilder httpRequestBuilder, boolean z, Continuation<? super String> continuation) throws IOException {
        C37401 c37401;
        SdkBuffer sdkBuffer;
        Long contentLength;
        SdkBuffer sdkBuffer2;
        HttpRequestBuilder httpRequestBuilder2;
        if (continuation instanceof C37401) {
            c37401 = (C37401) continuation;
            if ((c37401.label & Integer.MIN_VALUE) != 0) {
                c37401.label -= Integer.MIN_VALUE;
            } else {
                c37401 = new C37401(continuation);
            }
        }
        Object obj = c37401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37401.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sdkBuffer = new SdkBuffer();
            SdkBuffer sdkBuffer3 = sdkBuffer;
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, httpRequestBuilder.getMethod() + TokenParser.f2383SP + httpRequestBuilder.getUrl().getRequestRelativePath() + "\r\n", 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, "Host: " + httpRequestBuilder.getUrl().getHost() + "\r\n", 0, 0, 6, null);
            String str = httpRequestBuilder.getHeaders().get("Content-Length");
            long jLongValue = ((str == null || (contentLength = StringsKt.toLongOrNull(str)) == null) && (contentLength = httpRequestBuilder.getBody().getContentLength()) == null) ? 0L : contentLength.longValue();
            if (jLongValue > 0) {
                SdkBufferedSink.writeUtf8$default(sdkBuffer3, "Content-Length: " + jLongValue + "\r\n", 0, 0, 6, null);
            }
            Set of = SetsKt.setOf((Object[]) new String[]{"Host", "Content-Length"});
            Set<Map.Entry<String, List<String>>> setEntries = httpRequestBuilder.getHeaders().entries();
            ArrayList<Map.Entry> arrayList = new ArrayList();
            for (Object obj2 : setEntries) {
                if (!of.contains(((Map.Entry) obj2).getKey())) {
                    arrayList.add(obj2);
                }
            }
            for (Map.Entry entry : arrayList) {
                SdkBufferedSink.writeUtf8$default(sdkBuffer3, CollectionsKt.joinToString$default((List) entry.getValue(), Literals.COMMENT_2, ((String) entry.getKey()) + ": ", "\r\n", 0, null, null, 56, null), 0, 0, 6, null);
            }
            SdkBufferedSink.writeUtf8$default(sdkBuffer3, "\r\n", 0, 0, 6, null);
            if (z) {
                HttpBody body = httpRequestBuilder.getBody();
                if (body instanceof HttpBody.Bytes) {
                    SdkBufferedSink.write$default(sdkBuffer3, ((HttpBody.Bytes) body).getBytes(), 0, 0, 6, null);
                } else if ((body instanceof HttpBody.ChannelContent) || (body instanceof HttpBody.SourceContent)) {
                    HttpBody body2 = httpRequestBuilder.getBody();
                    c37401.L$0 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                    c37401.L$1 = sdkBuffer;
                    c37401.L$2 = SpillingKt.nullOutSpilledVariable(of);
                    c37401.L$3 = SpillingKt.nullOutSpilledVariable(body);
                    c37401.L$4 = httpRequestBuilder;
                    c37401.Z$0 = z;
                    c37401.J$0 = jLongValue;
                    c37401.label = 1;
                    Object objCopyHttpBody = copyHttpBody(body2, sdkBuffer, c37401);
                    if (objCopyHttpBody == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    sdkBuffer2 = sdkBuffer;
                    obj = objCopyHttpBody;
                    httpRequestBuilder2 = httpRequestBuilder;
                } else if (!(body instanceof HttpBody.Empty)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return sdkBuffer.readUtf8();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j = c37401.J$0;
        boolean z2 = c37401.Z$0;
        httpRequestBuilder2 = (HttpRequestBuilder) c37401.L$4;
        sdkBuffer2 = (SdkBuffer) c37401.L$1;
        ResultKt.throwOnFailure(obj);
        httpRequestBuilder2.setBody((HttpBody) obj);
        sdkBuffer = sdkBuffer2;
        return sdkBuffer.readUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object copyHttpBody(HttpBody httpBody, SdkBuffer sdkBuffer, Continuation<? super HttpBody> continuation) throws IOException {
        C37381 c37381;
        if (continuation instanceof C37381) {
            c37381 = (C37381) continuation;
            if ((c37381.label & Integer.MIN_VALUE) != 0) {
                c37381.label -= Integer.MIN_VALUE;
            } else {
                c37381 = new C37381(continuation);
            }
        }
        Object all = c37381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(all);
            c37381.L$0 = httpBody;
            c37381.L$1 = sdkBuffer;
            c37381.label = 1;
            all = HttpBodyKt.readAll(httpBody, c37381);
            if (all == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sdkBuffer = (SdkBuffer) c37381.L$1;
            httpBody = (HttpBody) c37381.L$0;
            ResultKt.throwOnFailure(all);
        }
        byte[] bArr = (byte[]) all;
        if (bArr == null) {
            return HttpBody.Empty.INSTANCE;
        }
        SdkBufferedSink.write$default(sdkBuffer, bArr, 0, 0, 6, null);
        return new HttpBody.SourceContent(httpBody, bArr) { // from class: aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt.copyHttpBody.2
            final /* synthetic */ byte[] $content;
            private final Long contentLength;
            private final boolean isDuplex;
            private final boolean isOneShot;

            {
                this.$content = bArr;
                this.contentLength = httpBody.getContentLength();
                this.isOneShot = httpBody.getIsOneShot();
                this.isDuplex = httpBody.getIsDuplex();
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody.SourceContent
            /* JADX INFO: renamed from: readFrom */
            public SdkSource get$this_toHttpBody() {
                return SdkIoKt.source(this.$content);
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            public Long getContentLength() {
                return this.contentLength;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            /* JADX INFO: renamed from: isOneShot, reason: from getter */
            public boolean getIsOneShot() {
                return this.isOneShot;
            }

            @Override // aws.smithy.kotlin.runtime.http.HttpBody
            /* JADX INFO: renamed from: isDuplex, reason: from getter */
            public boolean getIsDuplex() {
                return this.isDuplex;
            }
        };
    }
}
