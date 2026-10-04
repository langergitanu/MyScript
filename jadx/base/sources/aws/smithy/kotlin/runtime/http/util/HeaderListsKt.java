package aws.smithy.kotlin.runtime.http.util;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: HeaderLists.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a*\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002\u001a*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002\u001a\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m1599d2 = {"splitHeaderListValues", "", "", "value", "readNextQuoted", "Lkotlin/Pair;", "", "startIdx", "delim", "", "readNextUnquoted", "splitHttpDateHeaderListValues", "QUOTABLE_HEADER_VALUE_CHARS", "quoteHeaderValue", "http"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeaderListsKt {
    private static final String QUOTABLE_HEADER_VALUE_CHARS = "\",()";

    @InternalApi
    public static final List<String> splitHeaderListValues(String value) {
        Pair nextQuoted$default;
        Intrinsics.checkNotNullParameter(value, "value");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < value.length()) {
            char cCharAt = value.charAt(i);
            if (cCharAt == '\t' || cCharAt == ' ') {
                i++;
            } else {
                if (cCharAt == '\"') {
                    nextQuoted$default = readNextQuoted$default(value, i, (char) 0, 2, null);
                } else {
                    nextQuoted$default = readNextUnquoted$default(value, i, (char) 0, 2, null);
                }
                int iIntValue = ((Number) nextQuoted$default.getFirst()).intValue();
                arrayList.add(nextQuoted$default.getSecond());
                i = iIntValue;
            }
        }
        return arrayList;
    }

    static /* synthetic */ Pair readNextQuoted$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = AbstractJsonLexerKt.COMMA;
        }
        return readNextQuoted(str, i, c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009d, code lost:
    
        return new kotlin.Pair<>(java.lang.Integer.valueOf(r0), kotlin.text.StringsKt.replace$default(kotlin.text.StringsKt.replace$default(r1, "\\\"", "\"", false, 4, (java.lang.Object) null), "\\\\", "\\", false, 4, (java.lang.Object) null));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Pair<Integer, String> readNextQuoted(String str, int i, char c) {
        char cCharAt;
        int i2 = i + 1;
        if (i2 >= str.length()) {
            throw new IllegalStateException("unbalanced quoted header value".toString());
        }
        int i3 = i2;
        while (i3 < str.length() && (cCharAt = str.charAt(i3)) != '\"') {
            if (cCharAt == '\\') {
                i3++;
            }
            i3++;
        }
        String strSubstring = str.substring(i2, i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (i3 >= str.length() || str.charAt(i3) != '\"') {
            throw new IllegalStateException(("missing end quote around quoted header value: `" + strSubstring + '`').toString());
        }
        while (true) {
            i3++;
            if (i3 >= str.length()) {
                break;
            }
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 != ' ' && cCharAt2 != '\t') {
                if (cCharAt2 != c) {
                    throw new IllegalStateException(("Unexpected char `" + str.charAt(i3) + "` between header values. Previous header: `" + strSubstring + '`').toString());
                }
                i3++;
            }
        }
    }

    static /* synthetic */ Pair readNextUnquoted$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = AbstractJsonLexerKt.COMMA;
        }
        return readNextUnquoted(str, i, c);
    }

    private static final Pair<Integer, String> readNextUnquoted(String str, int i, char c) {
        if (i >= str.length()) {
            throw new IllegalStateException("Check failed.");
        }
        int i2 = i;
        while (i2 < str.length() && str.charAt(i2) != c) {
            i2++;
        }
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (i2 < str.length() && str.charAt(i2) == c) {
            i2++;
        }
        return new Pair<>(Integer.valueOf(i2), StringsKt.trim((CharSequence) strSubstring).toString());
    }

    @InternalApi
    public static final List<String> splitHttpDateHeaderListValues(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == ',') {
                i++;
            }
        }
        if (i <= 1) {
            return CollectionsKt.listOf(value);
        }
        if (i % 2 == 0) {
            throw new ClientException("invalid timestamp HttpDate header comma separations: `" + value + '`');
        }
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (value.charAt(i5) == ',') {
                i4++;
            }
            if (i4 > 1) {
                String strSubstring = value.substring(i3, i5);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                arrayList.add(StringsKt.trim((CharSequence) strSubstring).toString());
                i3 = i5 + 1;
                i4 = 0;
            }
        }
        if (i3 < value.length()) {
            String strSubstring2 = value.substring(i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            arrayList.add(StringsKt.trim((CharSequence) strSubstring2).toString());
        }
        return arrayList;
    }

    @InternalApi
    public static final String quoteHeaderValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String str = value;
        if (StringsKt.trim((CharSequence) str).toString().length() == value.length()) {
            for (int i = 0; i < str.length(); i++) {
                if (!StringsKt.contains$default((CharSequence) str, str.charAt(i), false, 2, (Object) null)) {
                }
            }
            return value;
        }
        return "\"" + StringsKt.replace$default(StringsKt.replace$default(value, "\\", "\\\\", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null) + '\"';
    }
}
