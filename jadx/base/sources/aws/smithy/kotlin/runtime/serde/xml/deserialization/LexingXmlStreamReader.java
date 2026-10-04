package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import aws.smithy.kotlin.runtime.serde.xml.XmlTokenKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: LexingXmlStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0080\b¢\u0006\u0002\b\rJ\n\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0082\u0010J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexingXmlStreamReader;", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", FirebaseAnalytics.Param.SOURCE, "Laws/smithy/kotlin/runtime/serde/xml/deserialization/XmlLexer;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/deserialization/XmlLexer;)V", "peekQueue", "Lkotlin/collections/ArrayDeque;", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "error", "", NotificationCompat.CATEGORY_MESSAGE, "", "error$serde_xml", "value", "lastToken", "getLastToken", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "nextToken", "peek", FirebaseAnalytics.Param.INDEX, "", "skipNext", "", "scanUntilDepth", "startDepth", TypedValues.TransitionType.S_FROM, "subTreeReader", "subtreeStartDepth", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader$SubtreeStartDepth;", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LexingXmlStreamReader implements XmlStreamReader {
    private XmlToken lastToken;
    private final ArrayDeque<XmlToken> peekQueue;
    private final XmlLexer source;

    public LexingXmlStreamReader(XmlLexer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.peekQueue = new ArrayDeque<>();
    }

    public final Void error$serde_xml(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        StringTextStream source$serde_xml = this.source.getSource();
        int iMax = Math.max(0, source$serde_xml.offset - 3);
        int iMin = Math.min(source$serde_xml.end - 1, source$serde_xml.offset + 3);
        String strSubstring = source$serde_xml.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(msg + '\n' + ("At offset " + source$serde_xml.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source$serde_xml.offset - iMax) + '^')));
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken getLastToken() {
        return this.lastToken;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken nextToken() {
        XmlToken xmlTokenRemoveFirstOrNull = this.peekQueue.removeFirstOrNull();
        if (xmlTokenRemoveFirstOrNull == null) {
            xmlTokenRemoveFirstOrNull = this.source.parseNext();
        }
        this.lastToken = xmlTokenRemoveFirstOrNull;
        return xmlTokenRemoveFirstOrNull;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken peek(int index) {
        while (index > this.peekQueue.size() && !this.source.getEndOfDocument()) {
            ArrayDeque<XmlToken> arrayDeque = this.peekQueue;
            XmlToken next = this.source.parseNext();
            Intrinsics.checkNotNull(next);
            arrayDeque.addLast(next);
        }
        return (XmlToken) LexingXmlStreamReaderKt.getOrNull(this.peekQueue, index - 1);
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public void skipNext() {
        XmlToken xmlTokenPeek = peek(1);
        if (xmlTokenPeek == null) {
            return;
        }
        scanUntilDepth(xmlTokenPeek.getDepth(), nextToken());
    }

    private final void scanUntilDepth(int startDepth, XmlToken from) {
        while (from != null && !(from instanceof XmlToken.EndDocument)) {
            if ((from instanceof XmlToken.EndElement) && ((XmlToken.EndElement) from).getDepth() == startDepth) {
                return;
            } else {
                from = nextToken();
            }
        }
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlStreamReader subTreeReader(XmlStreamReader.SubtreeStartDepth subtreeStartDepth) {
        Intrinsics.checkNotNullParameter(subtreeStartDepth, "subtreeStartDepth");
        if (XmlTokenKt.terminates(peek(1), getLastToken())) {
            nextToken();
            return new EmptyXmlStreamReader(this);
        }
        return new ChildXmlStreamReader(this, subtreeStartDepth);
    }
}
