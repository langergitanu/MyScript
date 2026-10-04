package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.MetricsFilter;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsFilterDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeMetricsFilterDocument", "Laws/sdk/kotlin/services/s3/model/MetricsFilter;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetricsFilterDocumentDeserializerKt {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final MetricsFilter deserializeMetricsFilterDocument(XmlTagReader reader) {
        MetricsFilter.Prefix prefix;
        Intrinsics.checkNotNullParameter(reader, "reader");
        MetricsFilter.And and = null;
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                if (and != null) {
                    return and;
                }
                throw new DeserializationException("Deserialized union value unexpectedly null: MetricsFilter");
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            switch (tagName.hashCode()) {
                case -1896243534:
                    if (!tagName.equals(TextFieldImplKt.PrefixId)) {
                        xmlTagReaderNextTag.drop();
                    } else {
                        Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                        if (thM14502exceptionOrNullimpl != null) {
                            Result.Companion companion = Result.INSTANCE;
                            objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Prefix`)", thM14502exceptionOrNullimpl)));
                        }
                        ResultKt.throwOnFailure(objTryData);
                        prefix = new MetricsFilter.Prefix((String) objTryData);
                    }
                    break;
                case -985185199:
                    if (!tagName.equals("AccessPointArn")) {
                        xmlTagReaderNextTag.drop();
                    } else {
                        Object objTryData2 = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                        Throwable thM14502exceptionOrNullimpl2 = Result.m14502exceptionOrNullimpl(objTryData2);
                        if (thM14502exceptionOrNullimpl2 != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objTryData2 = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#AccessPointArn`)", thM14502exceptionOrNullimpl2)));
                        }
                        ResultKt.throwOnFailure(objTryData2);
                        prefix = new MetricsFilter.AccessPointArn((String) objTryData2);
                    }
                    break;
                case 65975:
                    if (tagName.equals("And")) {
                        and = new MetricsFilter.And(MetricsAndOperatorDocumentDeserializerKt.deserializeMetricsAndOperatorDocument(xmlTagReaderNextTag));
                        continue;
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                case 83834:
                    if (tagName.equals("Tag")) {
                        and = new MetricsFilter.Tag(TagDocumentDeserializerKt.deserializeTagDocument(xmlTagReaderNextTag));
                        continue;
                    }
                    xmlTagReaderNextTag.drop();
                    break;
                default:
                    xmlTagReaderNextTag.drop();
                    break;
            }
            and = prefix;
            xmlTagReaderNextTag.drop();
        }
    }
}
