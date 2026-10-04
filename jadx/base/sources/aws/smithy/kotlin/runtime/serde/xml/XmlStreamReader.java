package aws.smithy.kotlin.runtime.serde.xml;

import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: XmlStreamReader.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\bH'J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader;", "", "lastToken", "Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "getLastToken", "()Laws/smithy/kotlin/runtime/serde/xml/XmlToken;", "subTreeReader", "subtreeStartDepth", "Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader$SubtreeStartDepth;", "nextToken", "skipNext", "", "peek", FirebaseAnalytics.Param.INDEX, "", "SubtreeStartDepth", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface XmlStreamReader {
    XmlToken getLastToken();

    XmlToken nextToken();

    @InternalApi
    XmlToken peek(int index);

    void skipNext();

    @InternalApi
    XmlStreamReader subTreeReader(SubtreeStartDepth subtreeStartDepth);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: XmlStreamReader.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/serde/xml/XmlStreamReader$SubtreeStartDepth;", "", "<init>", "(Ljava/lang/String;I)V", "CURRENT", "CHILD", "serde-xml"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SubtreeStartDepth {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SubtreeStartDepth[] $VALUES;
        public static final SubtreeStartDepth CURRENT = new SubtreeStartDepth("CURRENT", 0);
        public static final SubtreeStartDepth CHILD = new SubtreeStartDepth("CHILD", 1);

        private static final /* synthetic */ SubtreeStartDepth[] $values() {
            return new SubtreeStartDepth[]{CURRENT, CHILD};
        }

        public static EnumEntries<SubtreeStartDepth> getEntries() {
            return $ENTRIES;
        }

        public static SubtreeStartDepth valueOf(String str) {
            return (SubtreeStartDepth) Enum.valueOf(SubtreeStartDepth.class, str);
        }

        public static SubtreeStartDepth[] values() {
            return (SubtreeStartDepth[]) $VALUES.clone();
        }

        private SubtreeStartDepth(String str, int i) {
        }

        static {
            SubtreeStartDepth[] subtreeStartDepthArr$values = $values();
            $VALUES = subtreeStartDepthArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(subtreeStartDepthArr$values);
        }
    }

    /* JADX INFO: compiled from: XmlStreamReader.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ XmlStreamReader subTreeReader$default(XmlStreamReader xmlStreamReader, SubtreeStartDepth subtreeStartDepth, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subTreeReader");
        }
        if ((i & 1) != 0) {
            subtreeStartDepth = SubtreeStartDepth.CHILD;
        }
        return xmlStreamReader.subTreeReader(subtreeStartDepth);
    }

    static /* synthetic */ XmlToken peek$default(XmlStreamReader xmlStreamReader, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: peek");
        }
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return xmlStreamReader.peek(i);
    }
}
