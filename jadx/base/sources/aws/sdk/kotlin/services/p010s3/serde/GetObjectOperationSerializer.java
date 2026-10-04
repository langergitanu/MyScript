package aws.sdk.kotlin.services.p010s3.serde;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import aws.sdk.kotlin.services.p010s3.model.GetObjectRequest;
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

/* JADX INFO: compiled from: GetObjectOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/GetObjectOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/GetObjectRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectOperationSerializer implements HttpSerializer.NonStreaming<GetObjectRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, final GetObjectRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.GET);
        Url.Builder url = httpRequestBuilder.getUrl();
        if (input.getKey() == null) {
            throw new IllegalArgumentException("key is bound to the URI and must not be null".toString());
        }
        url.getPath().encodedSegments(new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.GetObjectOperationSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GetObjectOperationSerializer.serialize$lambda$0$1(input, (List) obj);
            }
        });
        url.getParameters().getDecodedParameters().add("x-id", "GetObject");
        url.getParameters().decodedParameters(PercentEncoding.INSTANCE.getSmithyLabel(), new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.GetObjectOperationSerializer$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GetObjectOperationSerializer.serialize$lambda$0$3(input, (MutableMultiMap) obj);
            }
        });
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getChecksumMode() != null) {
            headers.append("x-amz-checksum-mode", input.getChecksumMode().getValue());
        }
        if (input.getExpectedBucketOwner() != null) {
            headers.append("x-amz-expected-bucket-owner", input.getExpectedBucketOwner());
        }
        if (input.getIfMatch() != null) {
            headers.append("If-Match", input.getIfMatch());
        }
        if (input.getIfModifiedSince() != null) {
            headers.append("If-Modified-Since", input.getIfModifiedSince().format(TimestampFormat.RFC_5322));
        }
        if (input.getIfNoneMatch() != null) {
            headers.append("If-None-Match", input.getIfNoneMatch());
        }
        if (input.getIfUnmodifiedSince() != null) {
            headers.append("If-Unmodified-Since", input.getIfUnmodifiedSince().format(TimestampFormat.RFC_5322));
        }
        if (input.getRange() != null) {
            headers.append("Range", input.getRange());
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
    public static final Unit serialize$lambda$0$1(GetObjectRequest getObjectRequest, List encodedSegments) {
        Intrinsics.checkNotNullParameter(encodedSegments, "$this$encodedSegments");
        List list = encodedSegments;
        Iterator it = StringsKt.split$default((CharSequence) getObjectRequest.getKey(), new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            list.add(PercentEncoding.INSTANCE.getSmithyLabel().encode((String) it.next()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serialize$lambda$0$3(GetObjectRequest getObjectRequest, MutableMultiMap decodedParameters) {
        Intrinsics.checkNotNullParameter(decodedParameters, "$this$decodedParameters");
        if (getObjectRequest.getPartNumber() != null) {
            decodedParameters.add("partNumber", String.valueOf(getObjectRequest.getPartNumber().intValue()));
        }
        if (getObjectRequest.getResponseCacheControl() != null) {
            decodedParameters.add("response-cache-control", getObjectRequest.getResponseCacheControl());
        }
        if (getObjectRequest.getResponseContentDisposition() != null) {
            decodedParameters.add("response-content-disposition", getObjectRequest.getResponseContentDisposition());
        }
        if (getObjectRequest.getResponseContentEncoding() != null) {
            decodedParameters.add("response-content-encoding", getObjectRequest.getResponseContentEncoding());
        }
        if (getObjectRequest.getResponseContentLanguage() != null) {
            decodedParameters.add("response-content-language", getObjectRequest.getResponseContentLanguage());
        }
        if (getObjectRequest.getResponseContentType() != null) {
            decodedParameters.add("response-content-type", getObjectRequest.getResponseContentType());
        }
        if (getObjectRequest.getResponseExpires() != null) {
            decodedParameters.add("response-expires", getObjectRequest.getResponseExpires().format(TimestampFormat.RFC_5322));
        }
        if (getObjectRequest.getVersionId() != null) {
            decodedParameters.add("versionId", getObjectRequest.getVersionId());
        }
        return Unit.INSTANCE;
    }
}
