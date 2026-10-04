package aws.smithy.kotlin.runtime.serde.xml.dom;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.StackKt;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: compiled from: XmlNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\u0010"}, m1599d2 = {"parseDom", "Laws/smithy/kotlin/runtime/serde/xml/dom/XmlNode;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "toXmlString", "", "pretty", "", "formatXmlNode", "", "curr", "depth", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlNodeKt {
    @InternalApi
    public static final XmlNode parseDom(XmlStreamReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlToken xmlTokenNextToken = reader.nextToken();
            if (xmlTokenNextToken instanceof XmlToken.BeginElement) {
                XmlNode xmlNodeFromToken$serde_xml = XmlNode.INSTANCE.fromToken$serde_xml((XmlToken.BeginElement) xmlTokenNextToken);
                if (!arrayList.isEmpty()) {
                    XmlNode xmlNode = (XmlNode) StackKt.top(arrayList);
                    xmlNode.addChild(xmlNodeFromToken$serde_xml);
                    xmlNodeFromToken$serde_xml.setParent(xmlNode);
                }
                StackKt.push(arrayList, xmlNodeFromToken$serde_xml);
            } else if (xmlTokenNextToken instanceof XmlToken.EndElement) {
                XmlNode xmlNode2 = (XmlNode) StackKt.top(arrayList);
                XmlToken.EndElement endElement = (XmlToken.EndElement) xmlTokenNextToken;
                if (!Intrinsics.areEqual(xmlNode2.getName(), endElement.getName())) {
                    throw new DeserializationException("expected end of element: `" + xmlNode2.getName() + "`, found: `" + endElement.getName() + '`');
                }
                if (arrayList.size() > 1) {
                    StackKt.pop(arrayList);
                }
            } else if (xmlTokenNextToken instanceof XmlToken.Text) {
                ((XmlNode) StackKt.top(arrayList)).setText(((XmlToken.Text) xmlTokenNextToken).getValue());
            } else if (xmlTokenNextToken == null || (xmlTokenNextToken instanceof XmlToken.EndDocument)) {
                break;
            }
        }
        if (arrayList.size() != 1) {
            throw new IllegalStateException("invalid XML document, node stack size > 1".toString());
        }
        return (XmlNode) StackKt.pop(arrayList);
    }

    public static /* synthetic */ String toXmlString$default(XmlNode xmlNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toXmlString(xmlNode, z);
    }

    @InternalApi
    public static final String toXmlString(XmlNode xmlNode, boolean z) {
        Intrinsics.checkNotNullParameter(xmlNode, "<this>");
        StringBuilder sb = new StringBuilder();
        formatXmlNode(xmlNode, 0, sb, z);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final void formatXmlNode(XmlNode curr, int i, StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(curr, "curr");
        Intrinsics.checkNotNullParameter(sb, "sb");
        String strRepeat = z ? StringsKt.repeat(" ", i * 4) : "";
        sb.append(strRepeat + Typography.less);
        sb.append(curr.getName().toString());
        for (XmlToken.Namespace namespace : curr.getNamespaces()) {
            sb.append(" xmlns");
            if (namespace.getPrefix() != null) {
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + namespace.getPrefix());
            }
            sb.append("=\"" + namespace.getUri() + '\"');
        }
        if (!curr.getAttributes().isEmpty()) {
            sb.append(" ");
        }
        for (Map.Entry<XmlToken.QualifiedName, String> entry : curr.getAttributes().entrySet()) {
            sb.append(entry.getKey() + "=\"" + entry.getValue() + '\"');
        }
        sb.append(">");
        if (curr.getText() != null) {
            sb.append(curr.getText());
        }
        if (z && !curr.getChildren().isEmpty()) {
            sb.append('\n');
        }
        Iterator<Map.Entry<String, List<XmlNode>>> it = curr.getChildren().entrySet().iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                formatXmlNode((XmlNode) it2.next(), i + 1, sb, z);
            }
        }
        if (!curr.getChildren().isEmpty()) {
            sb.append(strRepeat);
        }
        sb.append("</");
        sb.append(curr.getName().toString());
        sb.append(">");
        if (!z || i <= 0) {
            return;
        }
        sb.append('\n');
    }
}
