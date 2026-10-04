package aws.sdk.kotlin.services.p010s3.serde;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsRequest;
import aws.sdk.kotlin.services.p010s3.model.OptionalObjectAttributes;
import aws.smithy.kotlin.runtime.collections.MutableMultiMap;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.HttpMethod;
import aws.smithy.kotlin.runtime.http.operation.HttpSerializer;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.util.HeaderListsKt;
import aws.smithy.kotlin.runtime.net.url.Url;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.text.encoding.PercentEncoding;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListObjectsOperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/ListObjectsOperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/ListObjectsRequest;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListObjectsOperationSerializer implements HttpSerializer.NonStreaming<ListObjectsRequest> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, final ListObjectsRequest input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.GET);
        Url.Builder url = httpRequestBuilder.getUrl();
        url.getPath().setTrailingSlash(true);
        url.getParameters().decodedParameters(PercentEncoding.INSTANCE.getSmithyLabel(), new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.ListObjectsOperationSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListObjectsOperationSerializer.serialize$lambda$0$0(input, (MutableMultiMap) obj);
            }
        });
        HeadersBuilder headers = httpRequestBuilder.getHeaders();
        if (input.getExpectedBucketOwner() != null) {
            headers.append("x-amz-expected-bucket-owner", input.getExpectedBucketOwner());
        }
        if (input.getOptionalObjectAttributes() != null) {
            List<OptionalObjectAttributes> optionalObjectAttributes = input.getOptionalObjectAttributes();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(optionalObjectAttributes, 10));
            Iterator<T> it = optionalObjectAttributes.iterator();
            while (it.hasNext()) {
                arrayList.add(HeaderListsKt.quoteHeaderValue(((OptionalObjectAttributes) it.next()).getValue()));
            }
            headers.appendAll("x-amz-optional-object-attributes", arrayList);
        }
        if (input.getRequestPayer() != null) {
            headers.append("x-amz-request-payer", input.getRequestPayer().getValue());
        }
        return httpRequestBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serialize$lambda$0$0(ListObjectsRequest listObjectsRequest, MutableMultiMap decodedParameters) {
        Intrinsics.checkNotNullParameter(decodedParameters, "$this$decodedParameters");
        if (listObjectsRequest.getDelimiter() != null) {
            decodedParameters.add(TtmlNode.RUBY_DELIMITER, listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getEncodingType() != null) {
            decodedParameters.add("encoding-type", listObjectsRequest.getEncodingType().getValue());
        }
        if (listObjectsRequest.getMarker() != null) {
            decodedParameters.add("marker", listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getMaxKeys() != null) {
            decodedParameters.add("max-keys", String.valueOf(listObjectsRequest.getMaxKeys().intValue()));
        }
        if (listObjectsRequest.getPrefix() != null) {
            decodedParameters.add("prefix", listObjectsRequest.getPrefix());
        }
        return Unit.INSTANCE;
    }
}
