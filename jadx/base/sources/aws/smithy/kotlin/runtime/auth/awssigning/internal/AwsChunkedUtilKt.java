package aws.smithy.kotlin.runtime.auth.awssigning.internal;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.PlannedRemoval;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsChunkedByteReadChannel;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsChunkedSource;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningConfig;
import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.http.DeferredHeaders;
import aws.smithy.kotlin.runtime.http.Headers;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.SdkBuffer;
import aws.smithy.kotlin.runtime.p011io.SdkBufferedSink;
import aws.smithy.kotlin.runtime.p011io.SdkByteReadChannel;
import aws.smithy.kotlin.runtime.p011io.SdkSource;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: AwsChunkedUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0018H\u0007\u001a,\u0010\u0019\u001a\u00020\u0004*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007\u001a4\u0010\u0019\u001a\u00020\u0004*\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u001e\u0010\u000b\u001a\u00020\f*\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\f*\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, m1599d2 = {"CHUNK_SIZE_BYTES", "", "AWS_CHUNKED_THRESHOLD", "writeTrailers", "", "Laws/smithy/kotlin/runtime/io/SdkBuffer;", "trailers", "Laws/smithy/kotlin/runtime/http/Headers;", "writeTrailerSignature", "signature", "", "isEligibleForAwsChunkedStreaming", "", "Laws/smithy/kotlin/runtime/http/HttpBody;", "isEligibleForAwsChunkedStreaming$annotations", "(Laws/smithy/kotlin/runtime/http/HttpBody;)V", "(Laws/smithy/kotlin/runtime/http/HttpBody;)Z", "useAwsChunkedEncoding", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "getUseAwsChunkedEncoding$annotations", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;)V", "getUseAwsChunkedEncoding", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;)Z", "setAwsChunkedHeaders", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "setAwsChunkedBody", "signer", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "signingConfig", "", "trailingHeaders", "Laws/smithy/kotlin/runtime/http/DeferredHeaders;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "aws-signing-common"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsChunkedUtilKt {
    public static final int AWS_CHUNKED_THRESHOLD = 1048576;
    public static final int CHUNK_SIZE_BYTES = 65536;

    @InternalApi
    public static /* synthetic */ void getUseAwsChunkedEncoding$annotations(AwsSigningConfig awsSigningConfig) {
    }

    @InternalApi
    public static /* synthetic */ void isEligibleForAwsChunkedStreaming$annotations(HttpBody httpBody) {
    }

    public static final void writeTrailers(SdkBuffer sdkBuffer, Headers trailers) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(trailers, "trailers");
        for (Map.Entry entry : CollectionsKt.sortedWith(trailers.entries(), new Comparator() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedUtilKt$writeTrailers$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String lowerCase = ((String) ((Map.Entry) t).getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((String) ((Map.Entry) t2).getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        })) {
            SdkBuffer sdkBuffer2 = sdkBuffer;
            SdkBufferedSink.writeUtf8$default(sdkBuffer2, (String) entry.getKey(), 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer2, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer2, CollectionsKt.joinToString$default((Iterable) entry.getValue(), ",", null, null, 0, null, new Function1() { // from class: aws.smithy.kotlin.runtime.auth.awssigning.internal.AwsChunkedUtilKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AwsChunkedUtilKt.writeTrailers$lambda$1$0((String) obj);
                }
            }, 30, null), 0, 0, 6, null);
            SdkBufferedSink.writeUtf8$default(sdkBuffer2, "\r\n", 0, 0, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence writeTrailers$lambda$1$0(String v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return StringsKt.trim((CharSequence) v).toString();
    }

    public static final void writeTrailerSignature(SdkBuffer sdkBuffer, String signature) throws IOException {
        Intrinsics.checkNotNullParameter(sdkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(signature, "signature");
        SdkBufferedSink.writeUtf8$default(sdkBuffer, "x-amz-trailer-signature:" + signature + "\r\n", 0, 0, 6, null);
    }

    public static final boolean isEligibleForAwsChunkedStreaming(HttpBody httpBody) {
        Intrinsics.checkNotNullParameter(httpBody, "<this>");
        if ((!(httpBody instanceof HttpBody.SourceContent) && !(httpBody instanceof HttpBody.ChannelContent)) || httpBody.getContentLength() == null) {
            return false;
        }
        if (httpBody.getIsOneShot()) {
            return true;
        }
        Long contentLength = httpBody.getContentLength();
        Intrinsics.checkNotNull(contentLength);
        return contentLength.longValue() > 1048576;
    }

    public static final boolean getUseAwsChunkedEncoding(AwsSigningConfig awsSigningConfig) {
        Intrinsics.checkNotNullParameter(awsSigningConfig, "<this>");
        HashSpecification hashSpecification = awsSigningConfig.getHashSpecification();
        return (hashSpecification instanceof HashSpecification.StreamingAws4HmacSha256Payload) || (hashSpecification instanceof HashSpecification.StreamingAws4HmacSha256PayloadWithTrailers) || (hashSpecification instanceof HashSpecification.StreamingUnsignedPayloadWithTrailers);
    }

    @InternalApi
    public static final void setAwsChunkedHeaders(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.getHeaders().append("Content-Encoding", "aws-chunked");
        httpRequestBuilder.getHeaders().set("Transfer-Encoding", HTTP.CHUNK_CODING);
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        String strValueOf = httpRequestBuilder.getHeaders().get("Content-Length");
        if (strValueOf == null) {
            Long contentLength = httpRequestBuilder.getBody().getContentLength();
            strValueOf = contentLength != null ? String.valueOf(contentLength.longValue()) : null;
            if (strValueOf == null) {
                throw new ClientException("Expected \"Content-Length\" header or `body.contentLength` to be set for aws-chunked");
            }
        }
        headers.set("X-Amz-Decoded-Content-Length", strValueOf);
        httpRequestBuilder.getHeaders().remove("Content-Length");
    }

    @PlannedRemoval(major = 1, minor = 7)
    @Deprecated(message = "This overload causes `runBlocking` to be called without a CoroutineContext which leads to forgetting logging context. This overload will be removed in minor version 1.7.", replaceWith = @ReplaceWith(expression = "AwsChunkedSource(delegate, signer, signingConfig, previousSignature, trailingHeaders, coroutineContext)", imports = {"kotlin.coroutines.coroutineContext"}))
    @InternalApi
    public static final void setAwsChunkedBody(HttpRequestBuilder httpRequestBuilder, AwsSigner signer, AwsSigningConfig signingConfig, byte[] signature, DeferredHeaders trailingHeaders) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(signingConfig, "signingConfig");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        setAwsChunkedBody(httpRequestBuilder, signer, signingConfig, signature, trailingHeaders, EmptyCoroutineContext.INSTANCE);
    }

    @InternalApi
    public static final void setAwsChunkedBody(HttpRequestBuilder httpRequestBuilder, AwsSigner signer, AwsSigningConfig signingConfig, byte[] signature, DeferredHeaders trailingHeaders, CoroutineContext coroutineContext) {
        HttpBody httpBody;
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(signer, "signer");
        Intrinsics.checkNotNullParameter(signingConfig, "signingConfig");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        HttpBody body = httpRequestBuilder.getBody();
        if (body instanceof HttpBody.ChannelContent) {
            SdkByteReadChannel sdkByteReadChannel$default = HttpBodyKt.toSdkByteReadChannel$default(httpRequestBuilder.getBody(), null, 1, null);
            if (sdkByteReadChannel$default == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            httpBody = HttpBodyKt.toHttpBody((SdkByteReadChannel) new AwsChunkedByteReadChannel(sdkByteReadChannel$default, signer, signingConfig, signature, trailingHeaders), (Long) (-1L));
        } else if (body instanceof HttpBody.SourceContent) {
            HttpBody body2 = httpRequestBuilder.getBody();
            Intrinsics.checkNotNull(body2, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.http.HttpBody.SourceContent");
            httpBody = HttpBodyKt.toHttpBody((SdkSource) new AwsChunkedSource(((HttpBody.SourceContent) body2).get$this_toHttpBody(), signer, signingConfig, signature, trailingHeaders, coroutineContext), (Long) (-1L));
        } else {
            throw new ClientException("HttpBody type is not supported");
        }
        httpRequestBuilder.setBody(httpBody);
    }
}
