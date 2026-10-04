package aws.smithy.kotlin.runtime.serde.xml.serialization;

import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import aws.smithy.kotlin.runtime.serde.xml.serialization.TagChild;
import com.myscript.snt.core.SearchMatchParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: LazyTagWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\nJ\u0012\u0010\"\u001a\u00020\u001d2\n\u0010#\u001a\u00060$j\u0002`%J\u001c\u0010&\u001a\u00060$j\u0002`%*\u00060$j\u0002`%2\u0006\u0010!\u001a\u00020\nH\u0002J\u0014\u0010'\u001a\u00060$j\u0002`%*\u00060$j\u0002`%H\u0002J\u001c\u0010(\u001a\u00060$j\u0002`%*\u00060$j\u0002`%2\u0006\u0010!\u001a\u00020\nH\u0002J\u001c\u0010)\u001a\u00060$j\u0002`%*\u00060$j\u0002`%2\u0006\u0010!\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/serialization/LazyTagWriter;", "", "pretty", "", "indentLevel", "", "qName", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "nsAttributes", "", "", "<init>", "(ZILaws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;Ljava/util/Map;)V", "getPretty", "()Z", "getIndentLevel", "()I", "getQName", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "getNsAttributes", "()Ljava/util/Map;", "attributes", "", "children", "", "Laws/smithy/kotlin/runtime/serde/xml/serialization/TagChild;", "tagIndentationSpace", "textIndentationSpace", "attribute", "", "value", "childTag", "childWriter", "text", "write", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendIfPretty", "appendLineIfPretty", "appendXmlEscaped", "appendXmlEscapedForAttribute", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LazyTagWriter {
    private final Map<XmlToken.QualifiedName, String> attributes;
    private final List<TagChild> children;
    private final int indentLevel;
    private final Map<XmlToken.QualifiedName, String> nsAttributes;
    private final boolean pretty;
    private final XmlToken.QualifiedName qName;
    private final String tagIndentationSpace;
    private final String textIndentationSpace;

    public LazyTagWriter(boolean z, int i, XmlToken.QualifiedName qName, Map<XmlToken.QualifiedName, String> nsAttributes) {
        Intrinsics.checkNotNullParameter(qName, "qName");
        Intrinsics.checkNotNullParameter(nsAttributes, "nsAttributes");
        this.pretty = z;
        this.indentLevel = i;
        this.qName = qName;
        this.nsAttributes = nsAttributes;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.attributes = linkedHashMap;
        this.children = new ArrayList();
        this.tagIndentationSpace = StringsKt.repeat("    ", i);
        this.textIndentationSpace = StringsKt.repeat("    ", i + 1);
        linkedHashMap.putAll(nsAttributes);
    }

    public final boolean getPretty() {
        return this.pretty;
    }

    public final int getIndentLevel() {
        return this.indentLevel;
    }

    public final XmlToken.QualifiedName getQName() {
        return this.qName;
    }

    public final Map<XmlToken.QualifiedName, String> getNsAttributes() {
        return this.nsAttributes;
    }

    public final void attribute(XmlToken.QualifiedName qName, String value) {
        Intrinsics.checkNotNullParameter(qName, "qName");
        this.attributes.put(qName, value);
    }

    public final void childTag(LazyTagWriter childWriter) {
        Intrinsics.checkNotNullParameter(childWriter, "childWriter");
        this.children.add(new TagChild.Tag(childWriter));
    }

    public final void text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.children.add(new TagChild.Text(text));
    }

    public final void write(StringBuilder buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        appendIfPretty(buffer, this.tagIndentationSpace).append(Typography.less).append(this.qName);
        for (Map.Entry<XmlToken.QualifiedName, String> entry : this.attributes.entrySet()) {
            buffer.append(TokenParser.f2383SP).append(entry.getKey()).append("=\"");
            String value = entry.getValue();
            if (value != null) {
                appendXmlEscapedForAttribute(buffer, value);
            }
            buffer.append('\"');
        }
        if (this.children.isEmpty()) {
            StringBuilder sbAppend = appendIfPretty(buffer, " ").append("/>");
            Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
            appendLineIfPretty(sbAppend);
            return;
        }
        if (this.children.size() == 1 && (CollectionsKt.first((List) this.children) instanceof TagChild.Text)) {
            StringBuilder sbAppend2 = buffer.append(Typography.greater);
            Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(...)");
            Object objFirst = CollectionsKt.first((List<? extends Object>) this.children);
            Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type aws.smithy.kotlin.runtime.serde.xml.serialization.TagChild.Text");
            StringBuilder sbAppend3 = appendXmlEscaped(sbAppend2, ((TagChild.Text) objFirst).getText()).append("</").append(this.qName).append(Typography.greater);
            Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(...)");
            appendLineIfPretty(sbAppend3);
            return;
        }
        StringBuilder sbAppend4 = buffer.append(Typography.greater);
        Intrinsics.checkNotNullExpressionValue(sbAppend4, "append(...)");
        appendLineIfPretty(sbAppend4);
        for (TagChild tagChild : this.children) {
            if (tagChild instanceof TagChild.Text) {
                appendLineIfPretty(appendXmlEscaped(appendIfPretty(buffer, this.textIndentationSpace), ((TagChild.Text) tagChild).getText()));
            } else {
                if (!(tagChild instanceof TagChild.Tag)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((TagChild.Tag) tagChild).getLazyTagWriter().write(buffer);
            }
        }
        StringBuilder sbAppend5 = appendIfPretty(buffer, this.tagIndentationSpace).append("</").append(this.qName).append(Typography.greater);
        Intrinsics.checkNotNullExpressionValue(sbAppend5, "append(...)");
        appendLineIfPretty(sbAppend5);
    }

    private final StringBuilder appendIfPretty(StringBuilder sb, String str) {
        if (this.pretty) {
            sb.append(str);
        }
        return sb;
    }

    private final StringBuilder appendLineIfPretty(StringBuilder sb) {
        if (this.pretty) {
            sb.append('\n');
        }
        return sb;
    }

    private final StringBuilder appendXmlEscaped(StringBuilder sb, String str) {
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (cCharAt == '<') {
                sb.append("&lt;");
            } else if (cCharAt == '>') {
                sb.append("&gt;");
            } else if (cCharAt == '&') {
                sb.append("&amp;");
            } else if (cCharAt >= 0 && cCharAt < ' ') {
                sb.append("&#x" + LazyTagWriterKt.hexCode(cCharAt) + SearchMatchParser.DELIMETER);
            } else if (cCharAt == 133) {
                sb.append("&#x85;");
            } else if (cCharAt == 8232) {
                sb.append("&#x2028;");
            } else {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    private final StringBuilder appendXmlEscapedForAttribute(StringBuilder sb, String str) {
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (cCharAt == '<') {
                sb.append("&lt;");
            } else if (cCharAt == '>') {
                sb.append("&gt;");
            } else if (cCharAt == '&') {
                sb.append("&amp;");
            } else if (cCharAt == '\"') {
                sb.append("&quot;");
            } else if (cCharAt >= 0 && cCharAt < ' ') {
                sb.append("&#x" + LazyTagWriterKt.hexCode(cCharAt) + SearchMatchParser.DELIMETER);
            } else if (cCharAt == 133) {
                sb.append("&#x85;");
            } else if (cCharAt == 8232) {
                sb.append("&#x2028;");
            } else {
                sb.append(cCharAt);
            }
        }
        return sb;
    }
}
