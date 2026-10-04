package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.OwnershipControls;
import aws.smithy.kotlin.runtime.collections.CollectionExtKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OwnershipControlsDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeOwnershipControlsDocument", "Laws/sdk/kotlin/services/s3/model/OwnershipControls;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class OwnershipControlsDocumentDeserializerKt {
    public static final OwnershipControls deserializeOwnershipControlsDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        OwnershipControls.Builder builder = new OwnershipControls.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "Rule")) {
                    builder.setRules(CollectionExtKt.createOrAppend(builder.getRules(), OwnershipControlsRuleDocumentDeserializerKt.deserializeOwnershipControlsRuleDocument(xmlTagReaderNextTag)));
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
