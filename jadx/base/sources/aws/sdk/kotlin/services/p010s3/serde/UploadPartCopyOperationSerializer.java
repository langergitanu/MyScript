package aws.sdk.kotlin.services.p010s3.serde;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.services.p010s3.model.UploadPartCopyRequest;
import aws.smithy.kotlin.runtime.collections.MutableMultiMap;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UploadPartCopyOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/UploadPartCopyOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/UploadPartCopyRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UploadPartCopyOperationSerializer implements HttpSerializer.NonStreaming<UploadPartCopyRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, final UploadPartCopyRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.PUT);
        Url.Builder url = httpRequestBuilder.getUrl();
        if (input.getKey() == null) {
            throw new IllegalArgumentException("key is bound to the URI and must not be null".toString());
        }
        url.getPath().encodedSegments(new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.UploadPartCopyOperationSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UploadPartCopyOperationSerializer.serialize$lambda$0$1(input, (List) obj);
            }
        });
        url.getParameters().getDecodedParameters().add("x-id", "UploadPartCopy");
        url.getParameters().decodedParameters(PercentEncoding.INSTANCE.getSmithyLabel(), new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.UploadPartCopyOperationSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UploadPartCopyOperationSerializer.serialize$lambda$0$3(input, (MutableMultiMap) obj);
            }
        });
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getCopySource() != null) {
            headers.append("x-amz-copy-source", input.getCopySource());
        }
        if (input.getCopySourceIfMatch() != null) {
            headers.append("x-amz-copy-source-if-match", input.getCopySourceIfMatch());
        }
        if (input.getCopySourceIfModifiedSince() != null) {
            headers.append("x-amz-copy-source-if-modified-since", input.getCopySourceIfModifiedSince().format(TimestampFormat.RFC_5322));
        }
        if (input.getCopySourceIfNoneMatch() != null) {
            headers.append("x-amz-copy-source-if-none-match", input.getCopySourceIfNoneMatch());
        }
        if (input.getCopySourceIfUnmodifiedSince() != null) {
            headers.append("x-amz-copy-source-if-unmodified-since", input.getCopySourceIfUnmodifiedSince().format(TimestampFormat.RFC_5322));
        }
        if (input.getCopySourceRange() != null) {
            headers.append("x-amz-copy-source-range", input.getCopySourceRange());
        }
        if (input.getCopySourceSseCustomerAlgorithm() != null) {
            headers.append("x-amz-copy-source-server-side-encryption-customer-algorithm", input.getCopySourceSseCustomerAlgorithm());
        }
        if (input.getCopySourceSseCustomerKey() != null) {
            headers.append("x-amz-copy-source-server-side-encryption-customer-key", input.getCopySourceSseCustomerKey());
        }
        if (input.getCopySourceSseCustomerKeyMd5() != null) {
            headers.append("x-amz-copy-source-server-side-encryption-customer-key-MD5", input.getCopySourceSseCustomerKeyMd5());
        }
        if (input.getExpectedBucketOwner() != null) {
            headers.append("x-amz-expected-bucket-owner", input.getExpectedBucketOwner());
        }
        if (input.getExpectedSourceBucketOwner() != null) {
            headers.append("x-amz-source-expected-bucket-owner", input.getExpectedSourceBucketOwner());
        }
        if (input.getRequestPayer() != null) {
            headers.append("x-amz-request-payer", input.getRequestPayer().getValue());
        }
        if (input.getSseCustomerAlgorithm() != null) {
            headers.append("x-amz-server-side-encryption-customer-algorithm", input.getSseCustomerAlgorithm());
        }
        if (input.getSseCustomerKey() != null) {
            headers.append("x-amz-server-side-encryption-customer-key", input.getSseCustomerKey());
        }
        if (input.getSseCustomerKeyMd5() != null) {
            headers.append("x-amz-server-side-encryption-customer-key-MD5", input.getSseCustomerKeyMd5());
        }
        return httpRequestBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serialize$lambda$0$1(UploadPartCopyRequest uploadPartCopyRequest, List encodedSegments) {
        Intrinsics.checkNotNullParameter(encodedSegments, "$this$encodedSegments");
        List list = encodedSegments;
        Iterator it = StringsKt.split$default((CharSequence) uploadPartCopyRequest.getKey(), new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            list.add(PercentEncoding.INSTANCE.getSmithyLabel().encode((String) it.next()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serialize$lambda$0$3(UploadPartCopyRequest uploadPartCopyRequest, MutableMultiMap decodedParameters) {
        Intrinsics.checkNotNullParameter(decodedParameters, "$this$decodedParameters");
        if (uploadPartCopyRequest.getPartNumber() != null) {
            decodedParameters.add("partNumber", String.valueOf(uploadPartCopyRequest.getPartNumber().intValue()));
        }
        if (uploadPartCopyRequest.getUploadId() != null) {
            decodedParameters.add("uploadId", uploadPartCopyRequest.getUploadId());
        }
        return Unit.INSTANCE;
    }
}
