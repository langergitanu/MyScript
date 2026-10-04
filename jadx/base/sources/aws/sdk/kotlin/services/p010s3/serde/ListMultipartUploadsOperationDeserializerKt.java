package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorDetails;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorMetadataKt;
import aws.sdk.kotlin.services.p010s3.model.EncodingType;
import aws.sdk.kotlin.services.p010s3.model.ListMultipartUploadsResponse;
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

/* JADX INFO: compiled from: ListMultipartUploadsOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwListMultipartUploadsError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeListMultipartUploadsOperationBody", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse$Builder;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListMultipartUploadsOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void throwListMultipartUploadsError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
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
    /* JADX WARN: Removed duplicated region for block: B:70:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void deserializeListMultipartUploadsOperationBody(ListMultipartUploadsResponse.Builder builder, byte[] bArr) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        XmlTagReader xmlTagReader = XmlTagReaderKt.xmlTagReader(bArr);
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1943297557:
                    if (tagName.equals("CommonPrefixes")) {
                        builder.setCommonPrefixes(CollectionExtKt.createOrAppend(builder.getCommonPrefixes(), CommonPrefixDocumentDeserializerKt.deserializeCommonPrefixDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case -1896243534:
                    if (tagName.equals(TextFieldImplKt.PrefixId)) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Prefix`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setPrefix((String) objTryData);
                    }
                    break;
                case -1754727903:
                    if (tagName.equals("Upload")) {
                        builder.setUploads(CollectionExtKt.createOrAppend(builder.getUploads(), MultipartUploadDocumentDeserializerKt.deserializeMultipartUploadDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case -1644471223:
                    if (tagName.equals("NextUploadIdMarker")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#NextUploadIdMarker`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setNextUploadIdMarker((String) objTryData2);
                    }
                    break;
                case -1354209106:
                    if (tagName.equals("MaxUploads")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.s3#MaxUploads`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setMaxUploads((Integer) objM14499constructorimpl2);
                    }
                    break;
                case -685399219:
                    if (tagName.equals("EncodingType")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData3)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData3);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setEncodingType((EncodingType) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion4 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(EncodingType.INSTANCE.fromValue((String) objTryData3));
                            } catch (Throwable th) {
                                Result.Companion companion5 = Result.INSTANCE;
                                objTryData3 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData3);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#EncodingType`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setEncodingType((EncodingType) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case -173622439:
                    if (tagName.equals("KeyMarker")) {
                        Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData4);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion7 = Result.INSTANCE;
                            objTryData4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#KeyMarker`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData4);
                        builder.setKeyMarker((String) objTryData4);
                    }
                    break;
                case 159271316:
                    if (tagName.equals("IsTruncated")) {
                        Object objM14499constructorimpl3 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl6 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl3);
                        if (thM14502exceptionOrNullimpl6 != null) {
                            Result.Companion companion8 = Result.INSTANCE;
                            objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#IsTruncated`)", thM14502exceptionOrNullimpl6)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl3);
                        builder.setTruncated((Boolean) objM14499constructorimpl3);
                    }
                    break;
                case 656671142:
                    if (tagName.equals("NextKeyMarker")) {
                        Object objTryData5 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl7 = Result.m14502exceptionOrNullimpl(objTryData5);
                        if (thM14502exceptionOrNullimpl7 != null) {
                            Result.Companion companion9 = Result.INSTANCE;
                            objTryData5 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#NextKeyMarker`)", thM14502exceptionOrNullimpl7)));
                        }
                        ResultKt.throwOnFailure(objTryData5);
                        builder.setNextKeyMarker((String) objTryData5);
                    }
                    break;
                case 1753449959:
                    if (tagName.equals("Delimiter")) {
                        Object objTryData6 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl8 = Result.m14502exceptionOrNullimpl(objTryData6);
                        if (thM14502exceptionOrNullimpl8 != null) {
                            Result.Companion companion10 = Result.INSTANCE;
                            objTryData6 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Delimiter`)", thM14502exceptionOrNullimpl8)));
                        }
                        ResultKt.throwOnFailure(objTryData6);
                        builder.setDelimiter((String) objTryData6);
                    }
                    break;
                case 1924643446:
                    if (tagName.equals("UploadIdMarker")) {
                        Object objTryData7 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl9 = Result.m14502exceptionOrNullimpl(objTryData7);
                        if (thM14502exceptionOrNullimpl9 != null) {
                            Result.Companion companion11 = Result.INSTANCE;
                            objTryData7 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#UploadIdMarker`)", thM14502exceptionOrNullimpl9)));
                        }
                        ResultKt.throwOnFailure(objTryData7);
                        builder.setUploadIdMarker((String) objTryData7);
                    }
                    break;
                case 2000631306:
                    if (tagName.equals("Bucket")) {
                        Object objTryData8 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl10 = Result.m14502exceptionOrNullimpl(objTryData8);
                        if (thM14502exceptionOrNullimpl10 != null) {
                            Result.Companion companion12 = Result.INSTANCE;
                            objTryData8 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#BucketName`)", thM14502exceptionOrNullimpl10)));
                        }
                        ResultKt.throwOnFailure(objTryData8);
                        builder.setBucket((String) objTryData8);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
