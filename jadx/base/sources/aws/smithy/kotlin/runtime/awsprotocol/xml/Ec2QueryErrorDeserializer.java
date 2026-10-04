package aws.smithy.kotlin.runtime.awsprotocol.xml;

import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Ec2QueryErrorDeserializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryErrorDeserializer;", "", "<init>", "()V", "deserialize", "Laws/smithy/kotlin/runtime/awsprotocol/xml/Ec2QueryError;", "root", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "aws-xml-protocols"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Ec2QueryErrorDeserializer {
    public static final Ec2QueryErrorDeserializer INSTANCE = new Ec2QueryErrorDeserializer();

    private Ec2QueryErrorDeserializer() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Ec2QueryError deserialize(XmlTagReader root) {
        Intrinsics.checkNotNullParameter(root, "root");
        String strData = null;
        String strData2 = null;
        while (true) {
            XmlTagReader xmlTagReaderNextTag = root.nextTag();
            if (xmlTagReaderNextTag != null) {
                String tagName = xmlTagReaderNextTag.getTagName();
                int iHashCode = tagName.hashCode();
                if (iHashCode != -1675388953) {
                    if (iHashCode != 2105869) {
                        if (iHashCode == 954925063 && tagName.equals("message")) {
                            strData2 = XmlTagReaderKt.data(xmlTagReaderNextTag);
                        }
                    } else if (tagName.equals("Code")) {
                        strData = XmlTagReaderKt.data(xmlTagReaderNextTag);
                    }
                } else if (!tagName.equals("Message")) {
                }
                xmlTagReaderNextTag.drop();
            } else {
                return new Ec2QueryError(strData, strData2);
            }
        }
    }
}
