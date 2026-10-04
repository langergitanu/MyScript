package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlToken.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0000¨\u0006\b"}, m1599d2 = {"isTerminal", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "minimumDepth", "", "isNotTerminal", "terminates", "beginToken", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlTokenKt {
    public static /* synthetic */ boolean isTerminal$default(XmlToken xmlToken, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return isTerminal(xmlToken, i);
    }

    public static final boolean isTerminal(XmlToken xmlToken, int i) {
        return xmlToken == null || Intrinsics.areEqual(xmlToken, XmlToken.EndDocument.INSTANCE) || xmlToken.getDepth() < i;
    }

    public static final boolean isNotTerminal(XmlToken xmlToken, int i) {
        return !isTerminal(xmlToken, i);
    }

    public static /* synthetic */ boolean isNotTerminal$default(XmlToken xmlToken, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return isNotTerminal(xmlToken, i);
    }

    public static final boolean terminates(XmlToken xmlToken, XmlToken xmlToken2) {
        if (xmlToken == null || xmlToken2 == null || !(xmlToken instanceof XmlToken.EndElement) || !(xmlToken2 instanceof XmlToken.BeginElement)) {
            return false;
        }
        XmlToken.EndElement endElement = (XmlToken.EndElement) xmlToken;
        XmlToken.BeginElement beginElement = (XmlToken.BeginElement) xmlToken2;
        return endElement.getDepth() == beginElement.getDepth() && Intrinsics.areEqual(endElement.getName(), beginElement.getName());
    }
}
