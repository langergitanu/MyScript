package aws.smithy.kotlin.runtime.serde.json;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.serde.DeserializationException;
import com.fasterxml.jackson.core.JsonPointer;
import com.survicate.surveys.TextRecallingManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: JsonLexer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u00020\u000eH\u0002\u001a$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0002*\u00020\u000eH\u0002\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0002H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\"\b\u0002\u0010\u0005\"\b\u0012\u0004\u0012\u00020\u0007`\u00062\u0012\u0012\u0004\u0012\u00020\u00070\bj\b\u0012\u0004\u0012\u00020\u0007`\u0006*.\b\u0002\u0010\t\"\u000e\u0012\u0004\u0012\u0002`\u000b\u0012\u0004\u0012\u00020\f0\n2\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\bj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\n¨\u0006\u0019"}, m1599d2 = {"DIGITS", "", "", "EXP", "PLUS_MINUS", "StateStack", "Laws/smithy/kotlin/runtime/collections/ListStack;", "Laws/smithy/kotlin/runtime/serde/json/LexerState;", "", "StateMutation", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/serde/json/StateStack;", "", "unescape", "", "readEscapedUnicode", "", CmcdData.STREAMING_FORMAT_SS, TtmlNode.START, "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "decodeEscapedCodePoint", "isControl", "", "serde-json"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonLexerKt {
    private static final Set<Character> DIGITS = CollectionsKt.toSet(new CharRange('0', '9'));
    private static final Set<Character> EXP = SetsKt.setOf((Object[]) new Character[]{'e', 'E'});
    private static final Set<Character> PLUS_MINUS = SetsKt.setOf((Object[]) new Character[]{Character.valueOf(Soundex.SILENT_MARKER), '+'});

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isControl(char c) {
        return c >= 0 && c < ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String unescape(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 1);
        int escapedUnicode = 0;
        while (escapedUnicode < str.length()) {
            char cCharAt = str.charAt(escapedUnicode);
            if (cCharAt == '\\') {
                int i = escapedUnicode + 1;
                escapedUnicode += 2;
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '\"') {
                    sb.append('\"');
                } else if (cCharAt2 == '/') {
                    sb.append(JsonPointer.SEPARATOR);
                } else if (cCharAt2 == '\\') {
                    sb.append('\\');
                } else if (cCharAt2 == 'b') {
                    sb.append('\b');
                } else if (cCharAt2 == 'f') {
                    sb.append('\f');
                } else if (cCharAt2 == 'n') {
                    sb.append('\n');
                } else if (cCharAt2 == 'r') {
                    sb.append(TokenParser.f2380CR);
                } else if (cCharAt2 == 't') {
                    sb.append('\t');
                } else if (cCharAt2 == 'u') {
                    escapedUnicode += readEscapedUnicode(str, escapedUnicode, sb);
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new DeserializationException("Invalid escape character: `" + cCharAt2 + '`');
                }
            } else {
                sb.append(cCharAt);
                Integer.valueOf(escapedUnicode);
                escapedUnicode++;
            }
        }
        return sb.toString();
    }

    private static final int readEscapedUnicode(String str, int i, StringBuilder sb) {
        int i2 = i + 4;
        if (i2 > str.length()) {
            throw new IllegalStateException("Unexpected EOF reading escaped high surrogate".toString());
        }
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        char cDecodeEscapedCodePoint = decodeEscapedCodePoint(strSubstring);
        if (Character.isHighSurrogate(cDecodeEscapedCodePoint)) {
            String strSubstring2 = str.substring(i2, i + 10);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            if (!StringsKt.startsWith$default(strSubstring2, "\\u", false, 2, (Object) null)) {
                throw new IllegalStateException(("Expected surrogate pair, found `" + strSubstring2 + '`').toString());
            }
            String strSubstring3 = strSubstring2.substring(2);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
            char cDecodeEscapedCodePoint2 = decodeEscapedCodePoint(strSubstring3);
            if (!Character.isLowSurrogate(cDecodeEscapedCodePoint2)) {
                throw new IllegalStateException(("Invalid surrogate pair: (" + ((int) cDecodeEscapedCodePoint) + TextRecallingManager.ANSWER_SEPARATOR + ((int) cDecodeEscapedCodePoint2) + ')').toString());
            }
            StringsKt.append(sb, Character.valueOf(cDecodeEscapedCodePoint), Character.valueOf(cDecodeEscapedCodePoint2));
            Integer.valueOf(10);
            return 10;
        }
        sb.append(cDecodeEscapedCodePoint);
        return 4;
    }

    private static final char decodeEscapedCodePoint(String str) {
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (('0' > cCharAt || cCharAt >= ':') && (('a' > cCharAt || cCharAt >= 'g') && ('A' > cCharAt || cCharAt >= 'G'))) {
                throw new IllegalStateException(("Invalid unicode escape: `\\u" + str + '`').toString());
            }
        }
        return (char) Integer.parseInt(str, CharsKt.checkRadix(16));
    }
}
