package aws.smithy.kotlin.runtime.text.encoding;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import aws.smithy.kotlin.runtime.InternalApi;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.common.base.Ascii;
import com.myscript.snt.core.SearchMatchParser;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: compiled from: PercentEncoding.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/encoding/PercentEncoding;", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "", "name", "", "", "validChars", "", "specialMapping", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;)V", "encoded", "decode", "(Ljava/lang/String;)Ljava/lang/String;", "decoded", "encode", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Ljava/util/Set;", "getValidChars", "()Ljava/util/Set;", "Ljava/util/Map;", "getSpecialMapping", "()Ljava/util/Map;", "asciiMapping", "encodeMap", "decodeMap", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PercentEncoding implements Encoding {
    private static final Set<Character> ALPHA;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Character> DIGIT;
    private static final Encoding FormUrl;
    private static final Encoding Fragment;
    private static final Encoding Host;
    private static final Encoding Path;
    private static final Encoding Query;
    private static final Set<Character> SIGV4_SIGNING_CHAR;
    private static final Set<Character> SMITHY_LABEL_CHAR;
    private static final Set<Character> SUB_DELIMS;
    private static final Encoding SigV4;
    private static final Encoding SmithyLabel;
    private static final Set<Character> UNRESERVED;
    private static final String UPPER_HEX = "0123456789ABCDEF";
    private static final Encoding UserInfo;
    private static final Set<Character> VALID_FCHAR;
    private static final Set<Character> VALID_PCHAR;
    private static final Set<Character> VALID_QCHAR;
    private static final Set<Character> VALID_UCHAR;
    private final Map<Character, String> asciiMapping;
    private final Map<Character, Character> decodeMap;
    private final Map<Character, String> encodeMap;
    private final String name;
    private final Map<Character, Character> specialMapping;
    private final Set<Character> validChars;

    public PercentEncoding(String name, Set<Character> validChars, Map<Character, Character> specialMapping) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(validChars, "validChars");
        Intrinsics.checkNotNullParameter(specialMapping, "specialMapping");
        this.name = name;
        this.validChars = validChars;
        this.specialMapping = specialMapping;
        IntRange intRangeUntil = RangesKt.until(0, 128);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf((char) ((IntIterator) it).nextInt()));
        }
        Set<Character> set = this.validChars;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!set.contains(Character.valueOf(((Character) obj).charValue()))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        Companion companion = INSTANCE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList3, 10)), 16));
        for (Object obj2 : arrayList3) {
            linkedHashMap.put(obj2, companion.percentAsciiEncode(((Character) obj2).charValue()));
        }
        this.asciiMapping = linkedHashMap;
        Map<Character, Character> map = this.specialMapping;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap2.put(entry.getKey(), String.valueOf(((Character) entry.getValue()).charValue()));
        }
        this.encodeMap = MapsKt.plus(linkedHashMap, linkedHashMap2);
        Set<Character> set2 = this.validChars;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set2, 10)), 16));
        for (Object obj3 : set2) {
            linkedHashMap3.put(obj3, Character.valueOf(((Character) obj3).charValue()));
        }
        Set<Map.Entry> setEntrySet = MapsKt.plus(linkedHashMap3, this.specialMapping).entrySet();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        for (Map.Entry entry2 : setEntrySet) {
            Pair pairM1606to = TuplesKt.m1606to(Character.valueOf(((Character) entry2.getValue()).charValue()), Character.valueOf(((Character) entry2.getKey()).charValue()));
            linkedHashMap4.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        this.decodeMap = linkedHashMap4;
    }

    @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
    public /* bridge */ Encodable encodableFromDecoded(String str) {
        return super.encodableFromDecoded(str);
    }

    @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
    public /* bridge */ Encodable encodableFromEncoded(String str) {
        return super.encodableFromEncoded(str);
    }

    @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
    public String getName() {
        return this.name;
    }

    public final Set<Character> getValidChars() {
        return this.validChars;
    }

    public /* synthetic */ PercentEncoding(String str, Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, set, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<Character, Character> getSpecialMapping() {
        return this.specialMapping;
    }

    /* JADX INFO: compiled from: PercentEncoding.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r*\u00060\tj\u0002`\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010%\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u0017\u0010'\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u0017\u0010)\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"R\u0017\u0010+\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010\"R\u0017\u0010-\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b-\u0010 \u001a\u0004\b.\u0010\"R\u0017\u0010/\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b/\u0010 \u001a\u0004\b0\u0010\"¨\u00061"}, m1599d2 = {"Laws/smithy/kotlin/runtime/text/encoding/PercentEncoding$Companion;", "", "<init>", "()V", "", "char", "", "percentAsciiEncode", "(C)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "byte", "", "percentEncode", "(Ljava/lang/StringBuilder;B)V", "", "ALPHA", "Ljava/util/Set;", "DIGIT", "UNRESERVED", "SUB_DELIMS", "VALID_UCHAR", "VALID_PCHAR", "VALID_FCHAR", "VALID_QCHAR", "SMITHY_LABEL_CHAR", "SIGV4_SIGNING_CHAR", "UPPER_HEX", "Ljava/lang/String;", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "Host", "Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "getHost", "()Laws/smithy/kotlin/runtime/text/encoding/Encoding;", "UserInfo", "getUserInfo", "Path", "getPath", "Query", "getQuery", "Fragment", "getFragment", "FormUrl", "getFormUrl", "SmithyLabel", "getSmithyLabel", "SigV4", "getSigV4", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Encoding getHost() {
            return PercentEncoding.Host;
        }

        public final Encoding getUserInfo() {
            return PercentEncoding.UserInfo;
        }

        public final Encoding getPath() {
            return PercentEncoding.Path;
        }

        public final Encoding getQuery() {
            return PercentEncoding.Query;
        }

        public final Encoding getFragment() {
            return PercentEncoding.Fragment;
        }

        public final Encoding getFormUrl() {
            return PercentEncoding.FormUrl;
        }

        public final Encoding getSmithyLabel() {
            return PercentEncoding.SmithyLabel;
        }

        public final Encoding getSigV4() {
            return PercentEncoding.SigV4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String percentAsciiEncode(char c) {
            return "%" + PercentEncoding.UPPER_HEX.charAt((c & 255) >> 4) + PercentEncoding.UPPER_HEX.charAt(c & 15);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void percentEncode(StringBuilder sb, byte b) {
            sb.append('%');
            sb.append(PercentEncoding.UPPER_HEX.charAt((b & 255) >> 4));
            sb.append(PercentEncoding.UPPER_HEX.charAt(b & Ascii.f990SI));
        }
    }

    static {
        Set<Character> set = CollectionsKt.toSet(CollectionsKt.plus((Iterable) new CharRange('A', 'Z'), (Iterable) new CharRange('a', 'z')));
        ALPHA = set;
        Set<Character> set2 = CollectionsKt.toSet(new CharRange('0', '9'));
        DIGIT = set2;
        Set<Character> setPlus = SetsKt.plus(SetsKt.plus((Set) set, (Iterable) set2), (Iterable) SetsKt.setOf((Object[]) new Character[]{Character.valueOf(Soundex.SILENT_MARKER), '.', '_', '~'}));
        UNRESERVED = setPlus;
        Character chValueOf = Character.valueOf(Typography.amp);
        Character chValueOf2 = Character.valueOf(Literals.PROPERTY_SPLITTER);
        Set<Character> of = SetsKt.setOf((Object[]) new Character[]{'!', Character.valueOf(Typography.dollar), chValueOf, '\'', '(', ')', '*', '+', Character.valueOf(AbstractJsonLexerKt.COMMA), Character.valueOf(SearchMatchParser.DELIMETER), chValueOf2});
        SUB_DELIMS = of;
        Set<Character> setPlus2 = SetsKt.plus((Set) setPlus, (Iterable) of);
        VALID_UCHAR = setPlus2;
        Character chValueOf3 = Character.valueOf(AbstractJsonLexerKt.COLON);
        Set<Character> setPlus3 = SetsKt.plus((Set) setPlus2, (Iterable) SetsKt.setOf((Object[]) new Character[]{chValueOf3, '@'}));
        VALID_PCHAR = setPlus3;
        Set<Character> setPlus4 = SetsKt.plus((Set) setPlus3, (Iterable) SetsKt.setOf((Object[]) new Character[]{Character.valueOf(JsonPointer.SEPARATOR), '?'}));
        VALID_FCHAR = setPlus4;
        Set<Character> setMinus = SetsKt.minus((Set) setPlus4, (Iterable) SetsKt.setOf((Object[]) new Character[]{chValueOf, chValueOf2}));
        VALID_QCHAR = setMinus;
        SMITHY_LABEL_CHAR = setPlus;
        SIGV4_SIGNING_CHAR = setPlus;
        int i = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Map map = null;
        Host = new PercentEncoding(DiagnosticsTracker.HOST_KEY, SetsKt.plus(setPlus, chValueOf3), map, i, defaultConstructorMarker);
        UserInfo = new PercentEncoding("user info", setPlus2, null, 4, null);
        Path = new PercentEncoding(ClientCookie.PATH_ATTR, setPlus3, map, i, defaultConstructorMarker);
        Query = new PercentEncoding("query string", setMinus, map, i, defaultConstructorMarker);
        Fragment = new PercentEncoding("fragment", setPlus4, map, i, defaultConstructorMarker);
        int i2 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        Map map2 = null;
        FormUrl = new PercentEncoding("form URL", setPlus, map2, i2, defaultConstructorMarker2);
        SmithyLabel = new PercentEncoding("Smithy label", setPlus, map2, i2, defaultConstructorMarker2);
        SigV4 = new PercentEncoding("SigV4", setPlus, map2, i2, defaultConstructorMarker2);
    }

    @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
    public String decode(String encoded) {
        Intrinsics.checkNotNullParameter(encoded, "encoded");
        StringBuilder sb = new StringBuilder(encoded.length());
        byte[] bArr = null;
        int i = 0;
        while (i < encoded.length()) {
            char cCharAt = encoded.charAt(i);
            if (cCharAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(encoded.length() - i) / 3];
                }
                byte[] bArr2 = bArr;
                int i2 = 0;
                while (i + 2 < encoded.length() && cCharAt == '%') {
                    int i3 = i + 3;
                    String strSubstring = encoded.substring(i + 1, i3);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    Integer intOrNull = StringsKt.toIntOrNull(strSubstring, 16);
                    if (intOrNull == null) {
                        break;
                    }
                    int i4 = i2 + 1;
                    bArr2[i2] = (byte) intOrNull.intValue();
                    if (i3 < encoded.length()) {
                        cCharAt = encoded.charAt(i3);
                    }
                    i2 = i4;
                    i = i3;
                }
                sb.append(StringsKt.decodeToString$default(bArr2, 0, i2, false, 5, null));
                if (i != encoded.length() && cCharAt == '%') {
                    sb.append(cCharAt);
                    i++;
                }
                bArr = bArr2;
            } else {
                Character ch2 = this.decodeMap.get(Character.valueOf(cCharAt));
                if (ch2 != null) {
                    cCharAt = ch2.charValue();
                }
                sb.append(cCharAt);
                i++;
            }
        }
        return sb.toString();
    }

    @Override // aws.smithy.kotlin.runtime.text.encoding.Encoding
    public String encode(String decoded) {
        Intrinsics.checkNotNullParameter(decoded, "decoded");
        StringBuilder sb = new StringBuilder(decoded.length());
        for (byte b : StringsKt.encodeToByteArray(decoded)) {
            char c = (char) b;
            if (this.validChars.contains(Character.valueOf(c))) {
                sb.append(c);
            } else {
                String str = this.encodeMap.get(Character.valueOf(c));
                if (str == null || sb.append(str) == null) {
                    INSTANCE.percentEncode(sb, b);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return sb.toString();
    }
}
