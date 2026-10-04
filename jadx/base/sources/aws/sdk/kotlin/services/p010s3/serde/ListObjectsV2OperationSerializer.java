package aws.sdk.kotlin.services.p010s3.serde;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.services.p010s3.model.ListObjectsV2Request;
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

/* JADX INFO: compiled from: ListObjectsV2OperationSerializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/serde/ListObjectsV2OperationSerializer;", "Laws/smithy/kotlin/runtime/http/operation/HttpSerializer$NonStreaming;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "<init>", "()V", "serialize", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", "input", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListObjectsV2OperationSerializer implements HttpSerializer.NonStreaming<ListObjectsV2Request> {
    @Override // aws.smithy.kotlin.runtime.http.operation.HttpSerializer.NonStreaming
    public HttpRequestBuilder serialize(ExecutionContext context, final ListObjectsV2Request input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.GET);
        Url.Builder url = httpRequestBuilder.getUrl();
        url.getPath().setTrailingSlash(true);
        url.getParameters().getDecodedParameters().add("list-type", "2");
        url.getParameters().decodedParameters(PercentEncoding.INSTANCE.getSmithyLabel(), new Function1() { // from class: aws.sdk.kotlin.services.s3.serde.ListObjectsV2OperationSerializer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListObjectsV2OperationSerializer.serialize$lambda$0$1(input, (MutableMultiMap) obj);
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
    public static final Unit serialize$lambda$0$1(ListObjectsV2Request listObjectsV2Request, MutableMultiMap decodedParameters) {
        Intrinsics.checkNotNullParameter(decodedParameters, "$this$decodedParameters");
        if (listObjectsV2Request.getContinuationToken() != null) {
            decodedParameters.add("continuation-token", listObjectsV2Request.getContinuationToken());
        }
        if (listObjectsV2Request.getDelimiter() != null) {
            decodedParameters.add(TtmlNode.RUBY_DELIMITER, listObjectsV2Request.getDelimiter());
        }
        if (listObjectsV2Request.getEncodingType() != null) {
            decodedParameters.add("encoding-type", listObjectsV2Request.getEncodingType().getValue());
        }
        if (listObjectsV2Request.getFetchOwner() != null) {
            decodedParameters.add("fetch-owner", String.valueOf(listObjectsV2Request.getFetchOwner().booleanValue()));
        }
        if (listObjectsV2Request.getMaxKeys() != null) {
            decodedParameters.add("max-keys", String.valueOf(listObjectsV2Request.getMaxKeys().intValue()));
        }
        if (listObjectsV2Request.getPrefix() != null) {
            decodedParameters.add("prefix", listObjectsV2Request.getPrefix());
        }
        if (listObjectsV2Request.getStartAfter() != null) {
            decodedParameters.add("start-after", listObjectsV2Request.getStartAfter());
        }
        return Unit.INSTANCE;
    }
}
