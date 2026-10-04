package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ChecksumAlgorithm;
import aws.sdk.kotlin.services.p010s3.model.ChecksumType;
import aws.sdk.kotlin.services.p010s3.model.Object;
import aws.sdk.kotlin.services.p010s3.model.ObjectStorageClass;
import aws.smithy.kotlin.runtime.collections.CollectionExtKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.ParsersKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObjectDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeObjectDocument", "Laws/sdk/kotlin/services/s3/model/Object;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ObjectDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object deserializeObjectDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Object objM14499constructorimpl2;
        Throwable thM14502exceptionOrNullimpl2;
        Object objM14499constructorimpl3;
        Throwable thM14502exceptionOrNullimpl3;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Object.Builder builder = new Object.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case 75327:
                    if (tagName.equals("Key")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ObjectKey`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setKey((String) objTryData);
                    }
                    break;
                case 2139413:
                    if (tagName.equals("ETag")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ETag`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setETag((String) objTryData2);
                    }
                    break;
                case 2577441:
                    if (tagName.equals("Size")) {
                        Object objM14499constructorimpl4 = ParsersKt.parseLong(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl6 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl4);
                        if (thM14502exceptionOrNullimpl6 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (long: `com.amazonaws.s3#Size`)", thM14502exceptionOrNullimpl6)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl4);
                        builder.setSize((Long) objM14499constructorimpl4);
                    }
                    break;
                case 34348032:
                    if (tagName.equals("RestoreStatus")) {
                        builder.setRestoreStatus(RestoreStatusDocumentDeserializerKt.deserializeRestoreStatusDocument(xmlTagReaderNextTag));
                    }
                    break;
                case 76612243:
                    if (tagName.equals("Owner")) {
                        builder.setOwner(OwnerDocumentDeserializerKt.deserializeOwnerDocument(xmlTagReaderNextTag));
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
                                Result.Companion companion4 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ChecksumType.INSTANCE.fromValue((String) objTryData3));
                            } catch (Throwable th) {
                                Result.Companion companion5 = Result.INSTANCE;
                                objTryData3 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData3);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion6 = Result.INSTANCE;
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
                            builder.setStorageClass((ObjectStorageClass) objM14499constructorimpl2);
                        } else {
                            try {
                                Result.Companion companion7 = Result.INSTANCE;
                                objM14499constructorimpl2 = Result.m14499constructorimpl(ObjectStorageClass.INSTANCE.fromValue((String) objTryData4));
                            } catch (Throwable th2) {
                                Result.Companion companion8 = Result.INSTANCE;
                                objTryData4 = ResultKt.createFailure(th2);
                                objM14499constructorimpl2 = Result.m14499constructorimpl(objTryData4);
                            }
                            thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                            if (thM14502exceptionOrNullimpl2 != null) {
                                Result.Companion companion9 = Result.INSTANCE;
                                objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ObjectStorageClass`)", thM14502exceptionOrNullimpl2)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl2);
                            builder.setStorageClass((ObjectStorageClass) objM14499constructorimpl2);
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
                            builder.setChecksumAlgorithm(CollectionExtKt.createOrAppend(builder.getChecksumAlgorithm(), (ChecksumAlgorithm) objM14499constructorimpl3));
                        } else {
                            try {
                                Result.Companion companion10 = Result.INSTANCE;
                                objM14499constructorimpl3 = Result.m14499constructorimpl(ChecksumAlgorithm.INSTANCE.fromValue((String) objTryData5));
                            } catch (Throwable th3) {
                                Result.Companion companion11 = Result.INSTANCE;
                                objTryData5 = ResultKt.createFailure(th3);
                                objM14499constructorimpl3 = Result.m14499constructorimpl(objTryData5);
                            }
                            thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl3);
                            if (thM14502exceptionOrNullimpl3 != null) {
                                Result.Companion companion12 = Result.INSTANCE;
                                objM14499constructorimpl3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ChecksumAlgorithm`)", thM14502exceptionOrNullimpl3)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl3);
                            builder.setChecksumAlgorithm(CollectionExtKt.createOrAppend(builder.getChecksumAlgorithm(), (ChecksumAlgorithm) objM14499constructorimpl3));
                        }
                        break;
                    }
                    break;
                case 2123323295:
                    if (tagName.equals("LastModified")) {
                        Object timestamp = ParsersKt.parseTimestamp(XmlTagReaderKt.tryData(xmlTagReaderNextTag), TimestampFormat.ISO_8601);
                        Throwable thM14502exceptionOrNullimpl7 = Result.m14502exceptionOrNullimpl(timestamp);
                        if (thM14502exceptionOrNullimpl7 != null) {
                            Result.Companion companion13 = Result.INSTANCE;
                            timestamp = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (timestamp: `com.amazonaws.s3#LastModified`)", thM14502exceptionOrNullimpl7)));
                        }
                        ResultKt.throwOnFailure(timestamp);
                        builder.setLastModified((Instant) timestamp);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
