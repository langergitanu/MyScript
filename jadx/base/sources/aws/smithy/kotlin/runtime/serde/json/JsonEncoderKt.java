package aws.smithy.kotlin.runtime.serde.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: JsonEncoder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0000\u001a\f\u0010\b\u001a\u00020\t*\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"CP_QUOTATION", "", "CP_BACKSLASH", "CP_NEWLINE", "CP_CARRIAGE_RETURN", "CP_TAB", "CP_BACKSPACE", "CP_FORMFEED", "escape", "", "needsEscaped", "", "", "serde-json"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JsonEncoderKt {
    private static final int CP_BACKSLASH = 92;
    private static final int CP_BACKSPACE = 8;
    private static final int CP_CARRIAGE_RETURN = 13;
    private static final int CP_FORMFEED = 12;
    private static final int CP_NEWLINE = 10;
    private static final int CP_QUOTATION = 34;
    private static final int CP_TAB = 9;

    private static final boolean needsEscaped(char c) {
        if (c == '\"' || c == '\\') {
            return true;
        }
        return c >= 0 && c < ' ';
    }

    public static final String escape(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            if (needsEscaped(str2.charAt(i))) {
                StringBuilder sb = new StringBuilder(str.length() + 1);
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    char cCharAt = str2.charAt(i2);
                    if (cCharAt == '\"') {
                        sb.append("\\\"");
                    } else if (cCharAt == '\\') {
                        sb.append("\\\\");
                    } else if (cCharAt == '\n') {
                        sb.append("\\n");
                    } else if (cCharAt == '\r') {
                        sb.append("\\r");
                    } else if (cCharAt == '\t') {
                        sb.append("\\t");
                    } else if (cCharAt == '\b') {
                        sb.append("\\b");
                    } else if (cCharAt == '\f') {
                        sb.append("\\f");
                    } else if (cCharAt >= 0 && cCharAt < ' ') {
                        String string = Integer.toString(cCharAt, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        sb.append("\\u");
                        sb.append(StringsKt.padStart(string, 4, '0'));
                    } else {
                        sb.append(cCharAt);
                    }
                }
                return sb.toString();
            }
        }
        return str;
    }
}
