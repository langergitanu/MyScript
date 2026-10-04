package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.RestoreStatus;
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

/* JADX INFO: compiled from: RestoreStatusDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeRestoreStatusDocument", "Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestoreStatusDocumentDeserializerKt {
    public static final RestoreStatus deserializeRestoreStatusDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        RestoreStatus.Builder builder = new RestoreStatus.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                if (Intrinsics.areEqual(tagName, "IsRestoreInProgress")) {
                    Object objM14499constructorimpl = ParsersKt.parseBoolean(XmlTagReaderKt.tryData(xmlTagReaderNextTag));
                    Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                    if (thM14502exceptionOrNullimpl != null) {
                        Result.Companion companion = Result.INSTANCE;
                        objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (boolean: `com.amazonaws.s3#IsRestoreInProgress`)", thM14502exceptionOrNullimpl)));
                    }
                    ResultKt.throwOnFailure(objM14499constructorimpl);
                    builder.setRestoreInProgress((Boolean) objM14499constructorimpl);
                } else if (Intrinsics.areEqual(tagName, "RestoreExpiryDate")) {
                    Object timestamp = ParsersKt.parseTimestamp(XmlTagReaderKt.tryData(xmlTagReaderNextTag), TimestampFormat.ISO_8601);
                    Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(timestamp);
                    if (thM14502exceptionOrNullimpl2 != null) {
                        Result.Companion companion2 = Result.INSTANCE;
                        timestamp = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (timestamp: `com.amazonaws.s3#RestoreExpiryDate`)", thM14502exceptionOrNullimpl2)));
                    }
                    ResultKt.throwOnFailure(timestamp);
                    builder.setRestoreExpiryDate((Instant) timestamp);
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
