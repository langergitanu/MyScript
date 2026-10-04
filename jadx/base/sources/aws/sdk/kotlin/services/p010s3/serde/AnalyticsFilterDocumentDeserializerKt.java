package aws.sdk.kotlin.services.p010s3.serde;

import androidx.compose.material3.internal.TextFieldImplKt;
import aws.sdk.kotlin.services.p010s3.model.AnalyticsFilter;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsFilterDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeAnalyticsFilterDocument", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsFilterDocumentDeserializerKt {
    public static final AnalyticsFilter deserializeAnalyticsFilterDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        AnalyticsFilter.And prefix = null;
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                break;
            }
            String tagName = xmlTagReaderNextTag.getTagName();
            int iHashCode = tagName.hashCode();
            if (iHashCode != -1896243534) {
                if (iHashCode != 65975) {
                    if (iHashCode == 83834 && tagName.equals("Tag")) {
                        prefix = new AnalyticsFilter.Tag(TagDocumentDeserializerKt.deserializeTagDocument(xmlTagReaderNextTag));
                    }
                } else if (tagName.equals("And")) {
                    prefix = new AnalyticsFilter.And(AnalyticsAndOperatorDocumentDeserializerKt.deserializeAnalyticsAndOperatorDocument(xmlTagReaderNextTag));
                }
            } else if (tagName.equals(TextFieldImplKt.PrefixId)) {
                Object objTryData = XmlTagReaderKt.tryData(xmlTagReaderNextTag);
                Throwable thM14502exceptionOrNullimpl = Result.m14502exceptionOrNullimpl(objTryData);
                if (thM14502exceptionOrNullimpl != null) {
                    Result.Companion companion = Result.INSTANCE;
                    objTryData = Result.m14499constructorimpl(ResultKt.createFailure(new DeserializationException("expected (string: `com.amazonaws.s3#Prefix`)", thM14502exceptionOrNullimpl)));
                }
                ResultKt.throwOnFailure(objTryData);
                prefix = new AnalyticsFilter.Prefix((String) objTryData);
            }
            xmlTagReaderNextTag.drop();
        }
        if (prefix != null) {
            return prefix;
        }
        throw new DeserializationException("Deserialized union value unexpectedly null: AnalyticsFilter");
    }
}
