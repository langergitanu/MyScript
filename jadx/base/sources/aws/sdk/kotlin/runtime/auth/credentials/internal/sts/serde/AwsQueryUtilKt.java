package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AwsQueryUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"unwrapAwsQueryResponse", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "root", "operationName", "", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AwsQueryUtilKt {
    public static final XmlTagReader unwrapAwsQueryResponse(XmlTagReader root, String operationName) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(operationName, "operationName");
        String str = operationName + "Response";
        String str2 = operationName + "Result";
        if (!Intrinsics.areEqual(root.getTagName(), str)) {
            throw new DeserializationException("invalid root, expected " + str + "; found `" + root.getTag() + '`');
        }
        XmlTagReader xmlTagReaderNextTag = root.nextTag();
        if (xmlTagReaderNextTag == null || !Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), str2)) {
            throw new DeserializationException("invalid result, expected " + str2 + "; found `" + (xmlTagReaderNextTag != null ? xmlTagReaderNextTag.getTag() : null) + '`');
        }
        return xmlTagReaderNextTag;
    }
}
