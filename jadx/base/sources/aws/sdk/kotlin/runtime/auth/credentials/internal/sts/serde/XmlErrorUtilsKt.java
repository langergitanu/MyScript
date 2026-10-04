package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.serde;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlErrorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, m1599d2 = {"unwrapWrappedXmlErrorResponse", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "root", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlErrorUtilsKt {
    public static final XmlTagReader unwrapWrappedXmlErrorResponse(XmlTagReader root) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (!Intrinsics.areEqual(root.getTagName(), "ErrorResponse")) {
            throw new DeserializationException("invalid root, expected <ErrorResponse>; found `" + root.getTag() + '`');
        }
        XmlTagReader xmlTagReaderNextTag = root.nextTag();
        if (xmlTagReaderNextTag == null || !Intrinsics.areEqual(xmlTagReaderNextTag.getTagName(), "Error")) {
            throw new DeserializationException("invalid error, expected <Error>; found `" + (xmlTagReaderNextTag != null ? xmlTagReaderNextTag.getTag() : null) + '`');
        }
        return xmlTagReaderNextTag;
    }
}
