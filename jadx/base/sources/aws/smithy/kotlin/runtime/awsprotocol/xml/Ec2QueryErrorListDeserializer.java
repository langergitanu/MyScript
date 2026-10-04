package aws.smithy.kotlin.runtime.awsprotocol.xml;

import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ec2QueryErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryErrorListDeserializer;", "", "<init>", "()V", "deserialize", "", "Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryError;", "root", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Ec2QueryErrorListDeserializer {
    public static final Ec2QueryErrorListDeserializer INSTANCE = new Ec2QueryErrorListDeserializer();

    private Ec2QueryErrorListDeserializer() {
    }

    public final List<Ec2QueryError> deserialize(XmlTagReader root) {
        Intrinsics.checkNotNullParameter(root, "root");
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlTagReader xmlTagReaderNextTag = root.nextTag();
            if (xmlTagReaderNextTag == null) {
                return arrayList;
            }
            if (Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "Error")) {
                arrayList.add(Ec2QueryErrorDeserializer.INSTANCE.deserialize(xmlTagReaderNextTag));
            }
            xmlTagReaderNextTag.drop();
        }
    }
}
