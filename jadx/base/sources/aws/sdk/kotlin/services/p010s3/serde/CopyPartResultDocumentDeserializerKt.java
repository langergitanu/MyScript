package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.CopyPartResult;
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

/* JADX INFO: compiled from: CopyPartResultDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeCopyPartResultDocument", "Laws/sdk/kotlin/services/s3/model/CopyPartResult;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CopyPartResultDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final CopyPartResult deserializeCopyPartResultDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        CopyPartResult.Builder builder = new CopyPartResult.Builder();
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
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumCRC32C`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setChecksumCrc32C((String) objTryData);
                    }
                    break;
                case -421146518:
                    if (tagName.equals("ChecksumSHA256")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumSHA256`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setChecksumSha256((String) objTryData2);
                    }
                    break;
                case 2139413:
                    if (tagName.equals("ETag")) {
                        Object objTryData3 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(objTryData3);
                        if (thM14502exceptionOrNullimpl3 != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objTryData3 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ETag`)", thM14502exceptionOrNullimpl3)));
                        }
                        ResultKt.throwOnFailure(objTryData3);
                        builder.setETag((String) objTryData3);
                    }
                    break;
                case 215688911:
                    if (tagName.equals("ChecksumCRC64NVME")) {
                        Object objTryData4 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl4 = Result.m14502exceptionOrNullimpl(objTryData4);
                        if (thM14502exceptionOrNullimpl4 != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objTryData4 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumCRC64NVME`)", thM14502exceptionOrNullimpl4)));
                        }
                        ResultKt.throwOnFailure(objTryData4);
                        builder.setChecksumCrc64Nvme((String) objTryData4);
                    }
                    break;
                case 875538440:
                    if (tagName.equals("ChecksumSHA1")) {
                        Object objTryData5 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl5 = Result.m14502exceptionOrNullimpl(objTryData5);
                        if (thM14502exceptionOrNullimpl5 != null) {
                            Result.Companion companion5 = Result.INSTANCE;
                            objTryData5 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumSHA1`)", thM14502exceptionOrNullimpl5)));
                        }
                        ResultKt.throwOnFailure(objTryData5);
                        builder.setChecksumSha1((String) objTryData5);
                    }
                    break;
                case 1357411472:
                    if (tagName.equals("ChecksumCRC32")) {
                        Object objTryData6 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl6 = Result.m14502exceptionOrNullimpl(objTryData6);
                        if (thM14502exceptionOrNullimpl6 != null) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objTryData6 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#ChecksumCRC32`)", thM14502exceptionOrNullimpl6)));
                        }
                        ResultKt.throwOnFailure(objTryData6);
                        builder.setChecksumCrc32((String) objTryData6);
                    }
                    break;
                case 2123323295:
                    if (tagName.equals("LastModified")) {
                        Object timestamp = ParsersKt.parseTimestamp(XmlTagReaderKt.tryData(xmlTagReaderNextTag), TimestampFormat.ISO_8601);
                        Throwable thM14502exceptionOrNullimpl7 = Result.m14502exceptionOrNullimpl(timestamp);
                        if (thM14502exceptionOrNullimpl7 != null) {
                            Result.Companion companion7 = Result.INSTANCE;
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
