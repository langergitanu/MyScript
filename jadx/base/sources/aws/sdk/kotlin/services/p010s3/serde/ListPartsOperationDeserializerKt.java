package aws.sdk.kotlin.services.p010s3.serde;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorDetails;
import aws.sdk.kotlin.services.p010s3.internal.S3ErrorMetadataKt;
import aws.sdk.kotlin.services.p010s3.model.ChecksumAlgorithm;
import aws.sdk.kotlin.services.p010s3.model.ChecksumType;
import aws.sdk.kotlin.services.p010s3.model.ListPartsResponse;
import aws.sdk.kotlin.services.p010s3.model.S3Exception;
import aws.sdk.kotlin.services.p010s3.model.StorageClass;
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

/* JADX INFO: compiled from: ListPartsOperationDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, m1599d2 = {"throwListPartsError", "", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/operation/ExecutionContext;", NotificationCompat.CATEGORY_CALL, "Laws/smithy/kotlin/runtime/http/HttpCall;", "payload", "", "deserializeListPartsOperationBody", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse$Builder;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListPartsOperationDeserializerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void throwListPartsError(ExecutionContext executionContext, HttpCall httpCall, byte[] bArr) {
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
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void deserializeListPartsOperationBody(ListPartsResponse.Builder builder, byte[] bArr) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Object objM14499constructorimpl2;
        Throwable thM14502exceptionOrNullimpl2;
        Object objM14499constructorimpl3;
        Throwable thM14502exceptionOrNullimpl3;
        XmlTagReader xmlTagReader = XmlTagReaderKt.xmlTagReader(bArr);
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -668327511:
                    if (tagName.equals("NextPartNumberMarker")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#NextPartNumberMarker`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setNextPartNumberMarker((String) objTryData);
                    }
                    break;
                case 75327:
                    if (tagName.equals("Key")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ObjectKey`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setKey((String) objTryData2);
                    }
                    break;
                case 2480147:
                    if (tagName.equals("Part")) {
                        builder.setParts(CollectionExtKt.createOrAppend(builder.getParts(), PartDocumentDeserializerKt.deserializePartDocument(xmlTagReaderNextTag)));
                    }
                    break;
                case 76612243:
                    if (tagName.equals("Owner")) {
                        builder.setOwner(OwnerDocumentDeserializerKt.deserializeOwnerDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 159271316:
                    if (tagName.equals("IsTruncated")) {
                        Object objM14499constructorimpl4 = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl6 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl4);
                        if (thM14502exceptionOrNullimpl6 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#IsTruncated`)", thM14502exceptionOrNullimpl6)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl4);
                        builder.setTruncated((Boolean) objM14499constructorimpl4);
                    }
                    break;
                case 458336252:
                    if (tagName.equals("MaxParts")) {
                        Object objM14499constructorimpl5 = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl7 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl5);
                        if (thM14502exceptionOrNullimpl7 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM14499constructorimpl5 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.s3#MaxParts`)", thM14502exceptionOrNullimpl7)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl5);
                        builder.setMaxParts((Integer) objM14499constructorimpl5);
                    }
                    break;
                case 875616829:
                    if (tagName.equals("ChecksumType")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData3)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData3);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setChecksumType((ChecksumType) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion5 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ChecksumType.INSTANCE.fromValue((String) objTryData3));
                            } catch (Throwable th) {
                                Result.Companion companion6 = Result.INSTANCE;
                                objTryData3 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData3);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion7 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ChecksumType`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setChecksumType((ChecksumType) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case 1035673565:
                    if (tagName.equals("StorageClass")) {
                        Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData4)) {
                            objM14499constructorimpl2 = Result.m14499constructorimpl(objTryData4);
                            thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                            if (thM14502exceptionOrNullimpl2 != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl2);
                            builder.setStorageClass((StorageClass) objM14499constructorimpl2);
                        } else {
                            try {
                                Result.Companion companion8 = Result.INSTANCE;
                                objM14499constructorimpl2 = Result.m14499constructorimpl(StorageClass.INSTANCE.fromValue((String) objTryData4));
                            } catch (Throwable th2) {
                                Result.Companion companion9 = Result.INSTANCE;
                                objTryData4 = ResultKt.createFailure(th2);
                                objM14499constructorimpl2 = Result.m14499constructorimpl(objTryData4);
                            }
                            thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                            if (thM14502exceptionOrNullimpl2 != null) {
                                Result.Companion companion10 = Result.INSTANCE;
                                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#StorageClass`)", thM14502exceptionOrNullimpl2)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl2);
                            builder.setStorageClass((StorageClass) objM14499constructorimpl2);
                        }
                        break;
                    }
                    break;
                case 1179374412:
                    if (tagName.equals("ChecksumAlgorithm")) {
                        Object objTryData5 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData5)) {
                            objM14499constructorimpl3 = Result.m14499constructorimpl(objTryData5);
                            thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl3);
                            if (thM14502exceptionOrNullimpl3 != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl3);
                            builder.setChecksumAlgorithm((ChecksumAlgorithm) objM14499constructorimpl3);
                        } else {
                            try {
                                Result.Companion companion11 = Result.INSTANCE;
                                objM14499constructorimpl3 = Result.m14499constructorimpl(ChecksumAlgorithm.INSTANCE.fromValue((String) objTryData5));
                            } catch (Throwable th3) {
                                Result.Companion companion12 = Result.INSTANCE;
                                objTryData5 = ResultKt.createFailure(th3);
                                objM14499constructorimpl3 = Result.m14499constructorimpl(objTryData5);
                            }
                            thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl3);
                            if (thM14502exceptionOrNullimpl3 != null) {
                                Result.Companion companion13 = Result.INSTANCE;
                                objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ChecksumAlgorithm`)", thM14502exceptionOrNullimpl3)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl3);
                            builder.setChecksumAlgorithm((ChecksumAlgorithm) objM14499constructorimpl3);
                        }
                        break;
                    }
                    break;
                case 1628634908:
                    if (tagName.equals("UploadId")) {
                        Object objTryData6 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl8 = Result.m14502exceptionOrNullimpl(objTryData6);
                        if (thM14502exceptionOrNullimpl8 != null) {
                            Result.Companion companion14 = Result.INSTANCE;
                            objTryData6 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#MultipartUploadId`)", thM14502exceptionOrNullimpl8)));
                        }
                        ResultKt.throwOnFailure(objTryData6);
                        builder.setUploadId((String) objTryData6);
                    }
                    break;
                case 1754980879:
                    if (tagName.equals("Initiator")) {
                        builder.setInitiator(InitiatorDocumentDeserializerKt.deserializeInitiatorDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 1866967190:
                    if (tagName.equals("PartNumberMarker")) {
                        Object objTryData7 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl9 = Result.m14502exceptionOrNullimpl(objTryData7);
                        if (thM14502exceptionOrNullimpl9 != null) {
                            Result.Companion companion15 = Result.INSTANCE;
                            objTryData7 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#PartNumberMarker`)", thM14502exceptionOrNullimpl9)));
                        }
                        ResultKt.throwOnFailure(objTryData7);
                        builder.setPartNumberMarker((String) objTryData7);
                    }
                    break;
                case 2000631306:
                    if (tagName.equals("Bucket")) {
                        Object objTryData8 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl10 = Result.m14502exceptionOrNullimpl(objTryData8);
                        if (thM14502exceptionOrNullimpl10 != null) {
                            Result.Companion companion16 = Result.INSTANCE;
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
