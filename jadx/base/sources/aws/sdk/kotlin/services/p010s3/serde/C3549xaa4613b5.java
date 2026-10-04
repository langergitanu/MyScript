package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorDetails;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorMetadataKt;
import aws.sdk.kotlin.services.p010s3.model.ListBucketIntelligentTieringConfigurationsResponse;
import aws.sdk.kotlin.services.p010s3.model.S3Exception;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.collections.CollectionExtKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCode;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.serde.ListBucketIntelligentTieringConfigurationsOperationDeserializerKt */
/* JADX INFO: compiled from: ListBucketIntelligentTieringConfigurationsOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwListBucketIntelligentTieringConfigurationsError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeListBucketIntelligentTieringConfigurationsOperationBody", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListBucketIntelligentTieringConfigurationsResponse$Builder;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class C3549xaa4613b5 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void throwListBucketIntelligentTieringConfigurationsError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
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
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: deserializeListBucketIntelligentTieringConfigurationsOperationBody */
    public static final void m485x5b04949c(ListBucketIntelligentTieringConfigurationsResponse.Builder builder, byte[] bArr) {
        XmlTagReader xmlTagReader = XmlTagReaderKt.xmlTagReader(bArr);
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -871463121:
                    if (tagName.equals("NextContinuationToken")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#NextToken`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setNextContinuationToken((String) objTryData);
                    }
                    break;
                case -817802483:
                    if (tagName.equals("IntelligentTieringConfiguration")) {
                        builder.setIntelligentTieringConfigurationList(CollectionExtKt.createOrAppend(builder.getIntelligentTieringConfigurationList(), IntelligentTieringConfigurationDocumentDeserializerKt.deserializeIntelligentTieringConfigurationDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case 159271316:
                    if (tagName.equals("IsTruncated")) {
                        Object objM14499constructorimpl = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#IsTruncated`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setTruncated((Boolean) objM14499constructorimpl);
                    }
                    break;
                case 413261282:
                    if (tagName.equals("ContinuationToken")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Token`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setContinuationToken((String) objTryData2);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
