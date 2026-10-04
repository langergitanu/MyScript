package aws.smithy.kotlin.runtime.http.compression;

import aws.smithy.kotlin.runtime.compression.CompressionAlgorithm;
import aws.smithy.kotlin.runtime.content.ByteStream;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompressRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, m1599d2 = {"compressRequest", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/compression/CompressionAlgorithm;", "request", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CompressRequestKt {
    public static final HttpRequest compressRequest(CompressionAlgorithm compressionAlgorithm, HttpRequest request) {
        Intrinsics.checkNotNullParameter(compressionAlgorithm, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        ByteStream byteStream = HttpBodyKt.toByteStream(request.getBody());
        if (byteStream == null) {
            return request;
        }
        HttpRequestBuilder builder = HttpRequestKt.toBuilder(request);
        builder.setBody(HttpBodyKt.toHttpBody(compressionAlgorithm.compress(byteStream)));
        builder.getHeaders().append("Content-Encoding", compressionAlgorithm.getContentEncoding());
        return builder.build();
    }
}
