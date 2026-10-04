package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XmlTagReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlTagReader;", "", "tag", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;", "reader", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;)V", "getTag", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken$BeginElement;", "lastEmitted", "closed", "", "tagName", "", "getTagName", "()Ljava/lang/String;", "nextToken", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "nextHasValue", "drop", "", "nextTag", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class XmlTagReader {
    private boolean closed;
    private XmlTagReader lastEmitted;
    private final XmlStreamReader reader;
    private final XmlToken.BeginElement tag;

    public XmlTagReader(XmlToken.BeginElement tag, XmlStreamReader reader) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.tag = tag;
        this.reader = reader;
    }

    public final XmlToken.BeginElement getTag() {
        return this.tag;
    }

    public final String getTagName() {
        return this.tag.getName().toString();
    }

    public final XmlToken nextToken() {
        if (this.closed) {
            return null;
        }
        if (XmlTokenKt.terminates(XmlStreamReader.peek$default(this.reader, 0, 1, null), this.tag)) {
            this.reader.nextToken();
            this.closed = true;
            return null;
        }
        return this.reader.nextToken();
    }

    public final boolean nextHasValue() {
        if (this.closed) {
            return false;
        }
        return !(XmlStreamReader.peek$default(this.reader, 0, 1, null) instanceof XmlToken.EndElement);
    }

    public final void drop() {
        while (nextToken() != null) {
        }
    }

    public final XmlTagReader nextTag() {
        XmlTagReader xmlTagReader = this.lastEmitted;
        if (xmlTagReader != null) {
            xmlTagReader.drop();
        }
        XmlToken xmlTokenNextToken = nextToken();
        while (xmlTokenNextToken != null && !(xmlTokenNextToken instanceof XmlToken.BeginElement)) {
            xmlTokenNextToken = nextToken();
        }
        XmlToken.BeginElement beginElement = (XmlToken.BeginElement) xmlTokenNextToken;
        XmlTagReader xmlTagReaderTagReader = beginElement != null ? XmlTagReaderKt.tagReader(beginElement, this.reader) : null;
        this.lastEmitted = xmlTagReaderTagReader;
        return xmlTagReaderTagReader;
    }
}
