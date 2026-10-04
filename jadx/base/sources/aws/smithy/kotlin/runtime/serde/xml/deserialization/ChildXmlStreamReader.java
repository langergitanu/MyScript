package aws.smithy.kotlin.runtime.serde.xml.deserialization;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader;
import aws.smithy.kotlin.runtime.serde.xml.XmlToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: LexingXmlStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\bJ\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/deserialization/ChildXmlStreamReader;", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "parent", "Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexingXmlStreamReader;", "subtreeStartDepth", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader$SubtreeStartDepth;", "<init>", "(Laws/smithy/kotlin/runtime/serde/xml/deserialization/LexingXmlStreamReader;Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader$SubtreeStartDepth;)V", "lastToken", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "getLastToken", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "minimumDepth", "", "error", "", NotificationCompat.CATEGORY_MESSAGE, "", "nextToken", "peek", FirebaseAnalytics.Param.INDEX, "skipNext", "", "subTreeReader", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class ChildXmlStreamReader implements XmlStreamReader {
    private final int minimumDepth;
    private final LexingXmlStreamReader parent;
    private final XmlStreamReader.SubtreeStartDepth subtreeStartDepth;

    /* JADX INFO: compiled from: LexingXmlStreamReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[XmlStreamReader.SubtreeStartDepth.values().length];
            try {
                iArr[XmlStreamReader.SubtreeStartDepth.CHILD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[XmlStreamReader.SubtreeStartDepth.CURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ChildXmlStreamReader(LexingXmlStreamReader parent, XmlStreamReader.SubtreeStartDepth subtreeStartDepth) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(subtreeStartDepth, "subtreeStartDepth");
        this.parent = parent;
        this.subtreeStartDepth = subtreeStartDepth;
        int i = WhenMappings.$EnumSwitchMapping$0[subtreeStartDepth.ordinal()];
        Integer numValueOf = null;
        if (i == 1) {
            XmlToken lastToken = getLastToken();
            if (lastToken != null) {
                numValueOf = Integer.valueOf(lastToken.getDepth() + 1);
            }
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            XmlToken lastToken2 = getLastToken();
            if (lastToken2 != null) {
                numValueOf = Integer.valueOf(lastToken2.getDepth());
            }
        }
        if (numValueOf != null) {
            this.minimumDepth = numValueOf.intValue();
            return;
        }
        StringTextStream source = this.parent.source.getSource();
        int iMax = Math.max(0, source.offset - 3);
        int iMin = Math.min(source.end - 1, source.offset + 3);
        String strSubstring = source.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException("Unable to determine depth of last node\n" + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken getLastToken() {
        return this.parent.getLastToken();
    }

    public final Void error(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        StringTextStream source = this.parent.source.getSource();
        int iMax = Math.max(0, source.offset - 3);
        int iMin = Math.min(source.end - 1, source.offset + 3);
        String strSubstring = source.source.substring(iMax, iMin + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        throw new DeserializationException(msg + '\n' + ("At offset " + source.offset + " (showing range " + iMax + Soundex.SILENT_MARKER + iMin + "):\n" + StringTextStreamKt.nonAscii.replace(strSubstring, "·") + '\n' + (StringsKt.repeat(" ", source.offset - iMax) + '^')));
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken nextToken() {
        XmlToken xmlTokenPeek = this.parent.peek(1);
        if (xmlTokenPeek == null) {
            return null;
        }
        if (this.subtreeStartDepth == XmlStreamReader.SubtreeStartDepth.CHILD && xmlTokenPeek.getDepth() < this.minimumDepth) {
            xmlTokenPeek = this.parent.peek(2);
            if (xmlTokenPeek == null) {
                return null;
            }
            if (xmlTokenPeek.getDepth() >= this.minimumDepth) {
                this.parent.nextToken();
            }
        }
        if (xmlTokenPeek.getDepth() >= this.minimumDepth) {
            return this.parent.nextToken();
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlToken peek(int index) {
        XmlToken xmlTokenPeek = this.parent.peek(index);
        if (xmlTokenPeek != null && xmlTokenPeek.getDepth() >= this.minimumDepth) {
            return xmlTokenPeek;
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public void skipNext() {
        this.parent.skipNext();
    }

    @Override // aws.smithy.kotlin.runtime.serde.xml.XmlStreamReader
    public XmlStreamReader subTreeReader(XmlStreamReader.SubtreeStartDepth subtreeStartDepth) {
        Intrinsics.checkNotNullParameter(subtreeStartDepth, "subtreeStartDepth");
        return this.parent.subTreeReader(subtreeStartDepth);
    }
}
