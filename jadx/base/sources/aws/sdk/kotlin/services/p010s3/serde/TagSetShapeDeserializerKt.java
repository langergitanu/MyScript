package aws.sdk.kotlin.services.p010s3.serde;

import aws.sdk.kotlin.services.p010s3.model.Tag;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TagSetShapeDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"deserializeTagSetShape", "", "Laws/sdk/kotlin/services/s3/model/Tag;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TagSetShapeDeserializerKt {
    public static final List<Tag> deserializeTagSetShape(XmlTagReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = reader.nextTag();
            if (xmlTagReaderNextTag == null) {
                return arrayList;
            }
            if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "Tag")) {
                arrayList.add(TagDocumentDeserializerKt.deserializeTagDocument(xmlTagReaderNextTag));
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
