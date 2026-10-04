package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.LoggingEnabled;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggingEnabledDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeLoggingEnabledDocument", "Laws/sdk/kotlin/services/s3/model/LoggingEnabled;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoggingEnabledDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final LoggingEnabled deserializeLoggingEnabledDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        LoggingEnabled.Builder builder = new LoggingEnabled.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                builder.correctErrors$s3();
                return builder.build();
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -916990778:
                    if (tagName.equals("TargetObjectKeyFormat")) {
                        builder.setTargetObjectKeyFormat(TargetObjectKeyFormatDocumentDeserializerKt.deserializeTargetObjectKeyFormatDocument(xmlTagReaderNextTag));
                    }
                    break;
                case -862467333:
                    if (tagName.equals("TargetBucket")) {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#TargetBucket`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        builder.setTargetBucket((String) objTryData);
                    }
                    break;
                case -722148376:
                    if (tagName.equals("TargetGrants")) {
                        builder.setTargetGrants(TargetGrantsShapeDeserializerKt.deserializeTargetGrantsShape(xmlTagReaderNextTag));
                    }
                    break;
                case -464374877:
                    if (tagName.equals("TargetPrefix")) {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#TargetPrefix`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        builder.setTargetPrefix((String) objTryData2);
                    }
                    break;
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
