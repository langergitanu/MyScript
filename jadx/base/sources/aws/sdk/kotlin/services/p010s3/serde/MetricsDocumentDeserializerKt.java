package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Metrics;
import aws.sdk.kotlin.services.p010s3.model.MetricsStatus;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeMetricsDocument", "Laws/sdk/kotlin/services/s3/model/Metrics;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetricsDocumentDeserializerKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Metrics deserializeMetricsDocument(XmlTagReader reader) {
        Object objM14499constructorimpl;
        Throwable thM14502exceptionOrNullimpl;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Metrics.Builder builder = new Metrics.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                if (!Intrinsics.areEqual(tagName, "Status")) {
                    if (Intrinsics.areEqual(tagName, "EventThreshold")) {
                        builder.setEventThreshold(ReplicationTimeValueDocumentDeserializerKt.deserializeReplicationTimeValueDocument(xmlTagReaderNextTag));
                    }
                } else {
                    Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    if (Result.m14506isSuccessimpl(objTryData)) {
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(MetricsStatus.INSTANCE.fromValue((String) objTryData));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData = ResultKt.createFailure(th);
                            objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        }
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM14499constructorimpl = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (enum: `com.amazonaws.s3#MetricsStatus`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setStatus((MetricsStatus) objM14499constructorimpl);
                    } else {
                        objM14499constructorimpl = Result.m14499constructorimpl(objTryData);
                        thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objM14499constructorimpl);
                        if (thM14502exceptionOrNullimpl != null) {
                        }
                        ResultKt.throwOnFailure(objM14499constructorimpl);
                        builder.setStatus((MetricsStatus) objM14499constructorimpl);
                    }
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
