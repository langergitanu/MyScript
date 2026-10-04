package aws.sdk.kotlin.runtime.config.profile;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileLine.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\tH\u0002¨\u0006\n"}, m1599d2 = {"isProfile", "", "Laws/sdk/kotlin/runtime/config/profile/FileLine;", "isSsoSession", "isSection", "isComment", "isProperty", "isContinuation", "isSubProperty", "", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FileLineKt {
    public static final boolean isProfile(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        return isSection(fileLine) && !isSsoSession(fileLine);
    }

    public static final boolean isSsoSession(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        return isSection(fileLine) && StringsKt.contains$default((CharSequence) fileLine.getContent(), (CharSequence) Literals.SSO_SESSION_KEYWORD, false, 2, (Object) null);
    }

    public static final boolean isSection(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        String string = StringsKt.trim((CharSequence) TextKt.stripComments(fileLine.getContent())).toString();
        return StringsKt.startsWith$default((CharSequence) string, '[', false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) string, ']', false, 2, (Object) null);
    }

    public static final boolean isComment(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        String string = StringsKt.trim((CharSequence) fileLine.getContent()).toString();
        return StringsKt.startsWith$default(string, Literals.COMMENT_1, false, 2, (Object) null) || StringsKt.startsWith$default(string, Literals.COMMENT_2, false, 2, (Object) null);
    }

    public static final boolean isProperty(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        return !CharsKt.isWhitespace(StringsKt.first(fileLine.getContent())) && isProperty(fileLine.getContent());
    }

    public static final boolean isContinuation(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        if (!CharsKt.isWhitespace(StringsKt.first(fileLine.getContent()))) {
            return false;
        }
        String strSubstring = fileLine.getContent().substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return !StringsKt.isBlank(strSubstring);
    }

    public static final boolean isSubProperty(FileLine fileLine) {
        Intrinsics.checkNotNullParameter(fileLine, "<this>");
        return CharsKt.isWhitespace(StringsKt.first(fileLine.getContent())) && isProperty(StringsKt.trimStart((CharSequence) fileLine.getContent()).toString());
    }

    private static final boolean isProperty(String str) {
        String str2 = str;
        if (StringsKt.contains$default((CharSequence) str2, Literals.PROPERTY_SPLITTER, false, 2, (Object) null)) {
            List listSplit$default = StringsKt.split$default((CharSequence) str2, new char[]{Literals.PROPERTY_SPLITTER}, false, 2, 2, (Object) null);
            if (listSplit$default.size() == 2 && StringsKt.trim((CharSequence) listSplit$default.get(0)).toString().length() > 0) {
                return true;
            }
        }
        return false;
    }
}
