package aws.smithy.kotlin.runtime.serde.xml.dom;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReaderKt;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\n\u0010\u001e\u001a\u00020\u0003H\u0096\u0080\u0004J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0000J\u0012\u0010\"\u001a\u00020 *\u00020\u0000H\u0080\u0002¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/dom/XmlNode;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "(Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;)V", "getName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "children", "", "", "getChildren", "()Ljava/util/Map;", "text", "getText", "()Ljava/lang/String;", "setText", "attributes", "getAttributes", "namespaces", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$Namespace;", "getNamespaces", "()Ljava/util/List;", "parent", "getParent", "()Laws/smithy/kotlin/runtime/serde/xml/dom/XmlNode;", "setParent", "(Laws/smithy/kotlin/runtime/serde/xml/dom/XmlNode;)V", "toString", "addChild", "", "child", "unaryPlus", "unaryPlus$serde_xml", "Companion", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlNode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<XmlToken.QualifiedName, String> attributes;
    private final Map<String, List<XmlNode>> children;
    private final XmlToken.QualifiedName name;
    private final List<XmlToken.Namespace> namespaces;
    private XmlNode parent;
    private String text;

    public final XmlToken.QualifiedName getName() {
        return this.name;
    }

    public final Map<String, List<XmlNode>> getChildren() {
        return this.children;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final Map<XmlToken.QualifiedName, String> getAttributes() {
        return this.attributes;
    }

    public final List<XmlToken.Namespace> getNamespaces() {
        return this.namespaces;
    }

    public final XmlNode getParent() {
        return this.parent;
    }

    public final void setParent(XmlNode xmlNode) {
        this.parent = xmlNode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XmlNode(String name) {
        this(new XmlToken.QualifiedName(name, null, 2, null));
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public XmlNode(XmlToken.QualifiedName name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.children = new LinkedHashMap();
        this.attributes = new LinkedHashMap();
        this.namespaces = new ArrayList();
        this.name = name;
    }

    public String toString() {
        return "XmlNode(" + this.name + ')';
    }

    /* JADX INFO: compiled from: XmlNode.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/dom/XmlNode$Companion;", "", "<init>", "()V", "parse", "Laws/smithy/kotlin/runtime/serde/xml/dom/XmlNode;", "xmlpayload", "", "fromToken", "token", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;", "fromToken$serde_xml", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final XmlNode parse(byte[] xmlpayload) {
            Intrinsics.checkNotNullParameter(xmlpayload, "xmlpayload");
            return XmlNodeKt.parseDom(XmlStreamReaderKt.xmlStreamReader(xmlpayload));
        }

        public final XmlNode fromToken$serde_xml(XmlToken.BeginElement token) {
            Intrinsics.checkNotNullParameter(token, "token");
            XmlNode xmlNode = new XmlNode(token.getName());
            xmlNode.getAttributes().putAll(token.getAttributes());
            xmlNode.getNamespaces().addAll(token.getNsDeclarations());
            return xmlNode;
        }
    }

    public final void addChild(XmlNode child) {
        Intrinsics.checkNotNullParameter(child, "child");
        XmlToken.QualifiedName qualifiedName = child.name;
        if (qualifiedName == null) {
            throw new IllegalArgumentException("child must have a name".toString());
        }
        Map<String, List<XmlNode>> map = this.children;
        String local = qualifiedName.getLocal();
        ArrayList arrayList = map.get(local);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(local, arrayList);
        }
        arrayList.add(child);
    }

    public final void unaryPlus$serde_xml(XmlNode xmlNode) {
        Intrinsics.checkNotNullParameter(xmlNode, "<this>");
        xmlNode.addChild(xmlNode);
    }
}
