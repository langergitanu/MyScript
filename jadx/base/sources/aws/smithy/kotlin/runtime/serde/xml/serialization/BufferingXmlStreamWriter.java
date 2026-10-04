package aws.smithy.kotlin.runtime.serde.xml.serialization;

import aws.smithy.kotlin.runtime.serde.SerializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BufferingXmlStreamWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u001a\u0010&\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/serialization/BufferingXmlStreamWriter;", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamWriter;", "pretty", "", "<init>", "(Z)V", "getPretty", "()Z", "buffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nsAttributes", "", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$QualifiedName;", "", "tagWriterStack", "Lkotlin/collections/ArrayDeque;", "Laws/smithy/kotlin/runtime/serde/xml/serialization/LazyTagWriter;", "bytes", "", "getBytes", "()[B", "text", "getText", "()Ljava/lang/String;", "attribute", "name", "value", "namespace", "endDocument", "", "endTag", "qName", "namespacePrefix", "uri", "prefix", "requireWriter", "startDocument", "startTag", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BufferingXmlStreamWriter implements XmlStreamWriter {
    private final StringBuilder buffer;
    private final Map<XmlToken.QualifiedName, String> nsAttributes;
    private final boolean pretty;
    private final ArrayDeque<LazyTagWriter> tagWriterStack;

    public BufferingXmlStreamWriter() {
        this(false, 1, null);
    }

    public BufferingXmlStreamWriter(boolean z) {
        this.pretty = z;
        this.buffer = new StringBuilder();
        this.nsAttributes = new LinkedHashMap();
        this.tagWriterStack = new ArrayDeque<>();
    }

    public /* synthetic */ BufferingXmlStreamWriter(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getPretty() {
        return this.pretty;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public byte[] getBytes() {
        return StringsKt.encodeToByteArray(getText());
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public String getText() {
        endDocument();
        String string = this.buffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public XmlStreamWriter attribute(String name, String value, String namespace) {
        Intrinsics.checkNotNullParameter(name, "name");
        requireWriter().attribute(new XmlToken.QualifiedName(name, namespace), value);
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public void endDocument() {
        LazyTagWriter lazyTagWriterLastOrNull = this.tagWriterStack.lastOrNull();
        while (lazyTagWriterLastOrNull != null) {
            endTag(lazyTagWriterLastOrNull.getQName());
            lazyTagWriterLastOrNull = this.tagWriterStack.lastOrNull();
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public XmlStreamWriter endTag(String name, String namespace) {
        Intrinsics.checkNotNullParameter(name, "name");
        return endTag(new XmlToken.QualifiedName(name, namespace));
    }

    private final XmlStreamWriter endTag(XmlToken.QualifiedName qName) {
        LazyTagWriter lazyTagWriterRemoveLastOrNull = this.tagWriterStack.removeLastOrNull();
        if (lazyTagWriterRemoveLastOrNull == null) {
            throw new SerializationException("Unexpected end of tag while no tags are open");
        }
        if (!Intrinsics.areEqual(lazyTagWriterRemoveLastOrNull.getQName(), qName)) {
            throw new SerializationException("Tried to end tag " + qName + " but expected end of " + lazyTagWriterRemoveLastOrNull.getQName() + " tag");
        }
        if (this.tagWriterStack.isEmpty()) {
            lazyTagWriterRemoveLastOrNull.write(this.buffer);
        }
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public void namespacePrefix(String uri, String prefix) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.nsAttributes.put(prefix == null ? new XmlToken.QualifiedName("xmlns", null, 2, null) : new XmlToken.QualifiedName(prefix, "xmlns"), uri);
    }

    private final LazyTagWriter requireWriter() {
        if (this.tagWriterStack.isEmpty()) {
            throw new SerializationException("Attempted to serialize text or attribute without containing tag");
        }
        return this.tagWriterStack.last();
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public void startDocument() {
        this.buffer.append("<?xml version=\"1.0\"?>");
        if (this.pretty) {
            this.buffer.append('\n');
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public XmlStreamWriter startTag(String name, String namespace) {
        Intrinsics.checkNotNullParameter(name, "name");
        LazyTagWriter lazyTagWriterLastOrNull = this.tagWriterStack.lastOrNull();
        LazyTagWriter lazyTagWriter = new LazyTagWriter(this.pretty, (lazyTagWriterLastOrNull != null ? lazyTagWriterLastOrNull.getIndentLevel() : -1) + 1, new XmlToken.QualifiedName(name, namespace), this.nsAttributes);
        this.nsAttributes.clear();
        if (lazyTagWriterLastOrNull != null) {
            lazyTagWriterLastOrNull.childTag(lazyTagWriter);
        }
        this.tagWriterStack.addLast(lazyTagWriter);
        return this;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamWriter
    public XmlStreamWriter text(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        requireWriter().text(text);
        return this;
    }
}
