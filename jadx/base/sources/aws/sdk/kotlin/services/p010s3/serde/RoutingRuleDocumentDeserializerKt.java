package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.RoutingRule;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoutingRuleDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeRoutingRuleDocument", "Laws/sdk/kotlin/services/s3/model/RoutingRule;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RoutingRuleDocumentDeserializerKt {
    public static final RoutingRule deserializeRoutingRuleDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        RoutingRule.Builder builder = new RoutingRule.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                if (Intrinsics.areEqual(tagName, "Condition")) {
                    builder.setCondition(ConditionDocumentDeserializerKt.deserializeConditionDocument(xmlTagReaderNextTag));
                } else if (Intrinsics.areEqual(tagName, "Redirect")) {
                    builder.setRedirect(RedirectDocumentDeserializerKt.deserializeRedirectDocument(xmlTagReaderNextTag));
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
