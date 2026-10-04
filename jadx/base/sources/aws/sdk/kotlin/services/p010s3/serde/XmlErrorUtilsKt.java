package aws.sdk.kotlin.services.p010s3.serde;

import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlTagReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlErrorUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, m1599d2 = {"unwrapXmlErrorResponse", "Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "root", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlErrorUtilsKt {
    public static final XmlTagReader unwrapXmlErrorResponse(XmlTagReader root) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (Intrinsics.areEqual(root.getTagName(), "Error")) {
            return root;
        }
        throw new DeserializationException("invalid error, expected <Error>; found `" + root.getTag() + '`');
    }
}
