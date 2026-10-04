package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.LifecycleExpiration;
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

/* JADX INFO: compiled from: LifecycleExpirationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeLifecycleExpirationDocument", "Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleExpirationDocumentDeserializerKt {
    public static final LifecycleExpiration deserializeLifecycleExpirationDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        LifecycleExpiration.Builder builder = new LifecycleExpiration.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                int iHashCode = tagName.hashCode();
                if (iHashCode != 2122702) {
                    if (iHashCode != 2122871) {
                        if (iHashCode == 1529679497 && tagName.equals("ExpiredObjectDeleteMarker")) {
                            Object objM14499constructorimpl = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                            Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                            if (thM14502exceptionOrNullimpl != null) {
                                Result.Companion companion = Result.INSTANCE;
                                objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#ExpiredObjectDeleteMarker`)", thM14502exceptionOrNullimpl)));
                            }
                            ResultKt.throwOnFailure(objM14499constructorimpl);
                            builder.setExpiredObjectDeleteMarker((Boolean) objM14499constructorimpl);
                        }
                    } else if (tagName.equals("Days")) {
                        Object objM14499constructorimpl2 = ParsersKt.parseInt(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objM14499constructorimpl2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (integer: `com.amazonaws.s3#Days`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl2);
                        builder.setDays((Integer) objM14499constructorimpl2);
                    }
                } else if (tagName.equals("Date")) {
                    Object timestamp = ParsersKt.parseTimestamp(XmlTagReaderKt.tryData(xmlTagReaderNextTag), TimestampFormat.ISO_8601);
                    Throwable thM14502exceptionOrNullimpl3 = Result.m14502exceptionOrNullimpl(timestamp);
                    if (thM14502exceptionOrNullimpl3 != null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        timestamp = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (timestamp: `com.amazonaws.s3#Date`)", thM14502exceptionOrNullimpl3)));
                    }
                    ResultKt.throwOnFailure(timestamp);
                    builder.setDate((Instant) timestamp);
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
