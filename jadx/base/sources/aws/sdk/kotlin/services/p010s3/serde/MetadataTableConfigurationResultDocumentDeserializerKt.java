package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.MetadataTableConfigurationResult;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataTableConfigurationResultDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeMetadataTableConfigurationResultDocument", "Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetadataTableConfigurationResultDocumentDeserializerKt {
    public static final MetadataTableConfigurationResult deserializeMetadataTableConfigurationResultDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        MetadataTableConfigurationResult.Builder builder = new MetadataTableConfigurationResult.Builder();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag != null) {
                if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "S3TablesDestinationResult")) {
                    builder.setS3TablesDestinationResult(S3TablesDestinationResultDocumentDeserializerKt.deserializeS3TablesDestinationResultDocument(xmlTagReaderNextTag));
                }
                xmlTagReaderNextTag.drop();
            } else {
                builder.correctErrors$s3();
                return builder.build();
            }
        }
    }
}
