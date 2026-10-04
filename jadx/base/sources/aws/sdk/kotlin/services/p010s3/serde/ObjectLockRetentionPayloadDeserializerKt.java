package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.ObjectLockRetention;
import aws.sdk.kotlin.services.p010s3.model.ObjectLockRetentionMode;
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

/* JADX INFO: compiled from: ObjectLockRetentionPayloadDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeObjectLockRetentionPayloadWithXmlNameRetention", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetention;", "payload", "", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ObjectLockRetentionPayloadDeserializerKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ObjectLockRetention deserializeObjectLockRetentionPayloadWithXmlNameRetention(byte[] payload) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(payload, "payload");
        XmlTagReader xmlTagReader = XmlTagReaderKt.xmlTagReader(payload);
        ObjectLockRetention.Builder builder = new ObjectLockRetention.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = xmlTagReader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                if (!Intrinsics.areEqual(tagName, "Mode")) {
                    if (Intrinsics.areEqual(tagName, "RetainUntilDate")) {
                        Object timestamp = ParsersKt.parseTimestamp(XmlTagReaderKt.tryData(xmlTagReaderNextTag), TimestampFormat.ISO_8601);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(timestamp);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion = Result.INSTANCE;
                            timestamp = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (timestamp: `com.amazonaws.s3#Date`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(timestamp);
                        builder.setRetainUntilDate((Instant) timestamp);
                    }
                } else {
                    Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    if (Result.m14506isSuccessimpl(objTryData)) {
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ObjectLockRetentionMode.INSTANCE.fromValue((String) objTryData));
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objTryData = ResultKt.createFailure(th);
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        }
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#ObjectLockRetentionMode`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setMode((ObjectLockRetentionMode) objM14499constructorimpl);
                    } else {
                        objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setMode((ObjectLockRetentionMode) objM14499constructorimpl);
                    }
                }
                xmlTagReaderNextTag.drop();
            } else {
                return builder.build();
            }
        }
    }
}
