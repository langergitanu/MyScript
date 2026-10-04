package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.SimplePrefix;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimplePrefixDocumentDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, m1599d2 = {"deserializeSimplePrefixDocument", "Laws/sdk/kotlin/services/s3/model/SimplePrefix;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SimplePrefixDocumentDeserializerKt {
    public static final SimplePrefix deserializeSimplePrefixDocument(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        SimplePrefix.Builder builder = new SimplePrefix.Builder();
        builder.correctErrors$s3();
        return builder.build();
    }
}
