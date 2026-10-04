package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorDetails;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorMetadataKt;
import aws.sdk.kotlin.services.p010s3.model.ListDirectoryBucketsResponse;
import aws.sdk.kotlin.services.p010s3.model.S3Exception;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListDirectoryBucketsOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwListDirectoryBucketsError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeListDirectoryBucketsOperationBody", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListDirectoryBucketsResponse$Builder;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListDirectoryBucketsOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void throwListDirectoryBucketsError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
        S3ErrorDetails s3ErrorResponse;
        HttpResponse httpResponseWithPayload = ResponseUtilsKt.withPayload(httpCall.getResponse(), bArr);
        HttpCall httpCallCopy$default = HttpCall.copy$default(httpCall, null, httpResponseWithPayload, 1, null);
        try {
            if (bArr == null) {
                if (Intrinsics.areEqual(httpCall.getResponse().getStatus(), HttpStatusCode.INSTANCE.getNotFound())) {
                    s3ErrorResponse = new S3ErrorDetails("NotFound", null, null, null, 14, null);
                } else {
                    s3ErrorResponse = new S3ErrorDetails(httpCall.getResponse().getStatus().toString(), null, null, null, 14, null);
                }
            } else {
                s3ErrorResponse = S3ErrorMetadataKt.parseS3ErrorResponse(bArr);
            }
            s3ErrorResponse.getCode();
            S3Exception s3Exception = new S3Exception(s3ErrorResponse.getMessage());
            S3ErrorMetadataKt.setS3ErrorMetadata(s3Exception, httpResponseWithPayload, s3ErrorResponse);
            throw s3Exception;
        } catch (Exception unused) {
            S3Exception s3Exception2 = new S3Exception("Failed to parse response as restXml error");
            S3ErrorMetadataKt.setS3ErrorMetadata(s3Exception2, httpCallCopy$default.getResponse(), null);
            throw s3Exception2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deserializeListDirectoryBucketsOperationBody(ListDirectoryBucketsResponse.Builder builder, byte[] bArr) {
        XmlTagReader xmlTagReader = XmlTagReaderKt.xmlTagReader(bArr);
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            if (Intrinsics.areEqual(tagName, "Buckets")) {
                builder.setBuckets(BucketsShapeDeserializerKt.deserializeBucketsShape(xmlTagReaderNextTag));
            } else if (Intrinsics.areEqual(tagName, "ContinuationToken")) {
                Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                if (thM14502exceptionOrNullimpl != null) {
                    Result.Companion companion = Result.INSTANCE;
                    objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#DirectoryBucketToken`)", thM14502exceptionOrNullimpl)));
                }
                ResultKt.throwOnFailure(objTryData);
                builder.setContinuationToken((String) objTryData);
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
