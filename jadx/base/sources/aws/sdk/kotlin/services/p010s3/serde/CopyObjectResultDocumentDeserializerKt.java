package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ChecksumType;
import aws.sdk.kotlin.services.p010s3.model.CopyObjectResult;
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

/* JADX INFO: compiled from: CopyObjectResultDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeCopyObjectResultDocument", "Laws/sdk/kotlin/services/s3/model/CopyObjectResult;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CopyObjectResultDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CopyObjectResult deserializeCopyObjectResultDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        CopyObjectResult.Builder builder = new CopyObjectResult.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -869917261:
                    if (tagName.equals("ChecksumCRC32C")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumCRC32C`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setChecksumCrc32C((String) objTryData);
                    }
                    break;
                case -421146518:
                    if (tagName.equals("ChecksumSHA256")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumSHA256`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setChecksumSha256((String) objTryData2);
                    }
                    break;
                case 2139413:
                    if (tagName.equals("ETag")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ETag`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setETag((String) objTryData3);
                    }
                    break;
                case 215688911:
                    if (tagName.equals("ChecksumCRC64NVME")) {
                        Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData4);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objTryData4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumCRC64NVME`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData4);
                        builder.setChecksumCrc64Nvme((String) objTryData4);
                    }
                    break;
                case 875538440:
                    if (tagName.equals("ChecksumSHA1")) {
                        Object objTryData5 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl6 = Result.m14502exceptionOrNullimpl(objTryData5);
                        if (thM14502exceptionOrNullimpl6 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData5 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumSHA1`)", thM14502exceptionOrNullimpl6)));
                        }
                        ResultKt.throwOnFailure(objTryData5);
                        builder.setChecksumSha1((String) objTryData5);
                    }
                    break;
                case 875616829:
                    if (tagName.equals("ChecksumType")) {
                        Object objTryData6 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        if (!Result.m14506isSuccessimpl(objTryData6)) {
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData6);
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setChecksumType((ChecksumType) objM14499constructorimpl);
                        } else {
                            try {
                                Result.Companion companion6 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ChecksumType.INSTANCE.fromValue((String) objTryData6));
                            } catch (Throwable th) {
                                Result.Companion companion7 = Result.INSTANCE;
                                objTryData6 = ResultKt.createFailure(th);
                                objM14499constructorimpl = Result.m14499constructorimpl(objTryData6);
                            }
                            thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion8 = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ChecksumType`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setChecksumType((ChecksumType) objM14499constructorimpl);
                        }
                        break;
                    }
                    break;
                case 1357411472:
                    if (tagName.equals("ChecksumCRC32")) {
                        Object objTryData7 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl7 = Result.m14502exceptionOrNullimpl(objTryData7);
                        if (thM14502exceptionOrNullimpl7 != null) {
                            Result.Companion companion9 = Result.INSTANCE;
                            objTryData7 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumCRC32`)", thM14502exceptionOrNullimpl7)));
                        }
                        ResultKt.throwOnFailure(objTryData7);
                        builder.setChecksumCrc32((String) objTryData7);
                    }
                    break;
                case 2123323295:
                    if (tagName.equals("LastModified")) {
                        Object timestamp = ParsersKt.parseTimestamp(XmlTagReaderKt.tryData(xmlTagReaderNextTag), TimestampFormat.ISO_8601);
                        Throwable thM14502exceptionOrNullimpl8 = Result.m14502exceptionOrNullimpl(timestamp);
                        if (thM14502exceptionOrNullimpl8 != null) {
                            Result.Companion companion10 = Result.INSTANCE;
                            timestamp = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (timestamp: `com.amazonaws.s3#LastModified`)", thM14502exceptionOrNullimpl8)));
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
