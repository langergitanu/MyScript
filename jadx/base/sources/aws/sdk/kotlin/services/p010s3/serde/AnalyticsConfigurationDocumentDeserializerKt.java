package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.AnalyticsConfiguration;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsConfigurationDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeAnalyticsConfigurationDocument", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsConfigurationDocumentDeserializerKt {
    public static final AnalyticsConfiguration deserializeAnalyticsConfigurationDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        AnalyticsConfiguration.Builder builder = new AnalyticsConfiguration.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                int iHashCode = tagName.hashCode();
                if (iHashCode != 2363) {
                    if (iHashCode != 1644857817) {
                        if (iHashCode == 2104342424 && tagName.equals("Filter")) {
                            builder.setFilter(AnalyticsFilterDocumentDeserializerKt.deserializeAnalyticsFilterDocument(xmlTagReaderNextTag));
                        }
                    } else if (tagName.equals("StorageClassAnalysis")) {
                        builder.setStorageClassAnalysis(StorageClassAnalysisDocumentDeserializerKt.deserializeStorageClassAnalysisDocument(xmlTagReaderNextTag));
                    }
                } else if (tagName.equals("Id")) {
                    Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                    Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                    if (thM14502exceptionOrNullimpl != null) {
                        Result.Companion companion = Result.INSTANCE;
                        objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#AnalyticsId`)", thM14502exceptionOrNullimpl)));
                    }
                    ResultKt.throwOnFailure(objTryData);
                    builder.setId((String) objTryData);
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
