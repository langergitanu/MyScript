package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LexingXmlStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/EmptyXmlStreamReader;", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "parent", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;)V", "lastToken", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "getLastToken", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "nextToken", "peek", FirebaseAnalytics.Param.INDEX, "", "skipNext", "", "subTreeReader", "subtreeStartDepth", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader$SubtreeStartDepth;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class EmptyXmlStreamReader implements XmlStreamReader {
    private final XmlStreamReader parent;

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken nextToken() {
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken peek(int index) {
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public void skipNext() {
    }

    public EmptyXmlStreamReader(XmlStreamReader xmlStreamReader) {
        this.parent = xmlStreamReader;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken getLastToken() {
        XmlStreamReader xmlStreamReader = this.parent;
        if (xmlStreamReader != null) {
            return xmlStreamReader.getLastToken();
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlStreamReader subTreeReader(XmlStreamReader.SubtreeStartDepth subtreeStartDepth) {
        Intrinsics.checkNotNullParameter(subtreeStartDepth, "subtreeStartDepth");
        return this;
    }
}
