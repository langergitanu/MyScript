package aws.smithy.kotlin.runtime.serde.xml.serialization;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: LazyTagWriter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, m1599d2 = {"INDENT_PER_LEVEL", "", "hexCode", "", "serde-xml"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LazyTagWriterKt {
    private static final String INDENT_PER_LEVEL = "    ";

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hexCode(char c) {
        String string = Integer.toString(c, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
