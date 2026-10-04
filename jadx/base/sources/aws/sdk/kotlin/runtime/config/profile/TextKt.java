package aws.sdk.kotlin.runtime.config.profile;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Text.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u001a!\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0000\u001a\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n*\u00020\u0001H\u0000\u001a\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1599d2 = {"HELP_TEXT", "", "contextMessage", "message", "lineNumber", "", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "isValidIdentifier", "", "splitProperty", "Lkotlin/Pair;", "splitWhitespace", "", "limit", "stripComments", "stripInlineComments", "stripEnd", TtmlNode.RUBY_DELIMITER, "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TextKt {
    public static final String HELP_TEXT = "See https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html for file format details.";

    public static final String contextMessage(String message, Integer num) {
        Intrinsics.checkNotNullParameter(message, "message");
        StringBuilder sb = new StringBuilder();
        sb.append(message);
        if (num != null) {
            num.intValue();
            sb.append(" on line " + num.intValue() + '.');
        }
        sb.append(" See https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-configure.html for file format details.");
        return sb.toString();
    }

    public static /* synthetic */ String contextMessage$default(String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return contextMessage(str, num);
    }

    public static final boolean isValidIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            if (CharsKt.isWhitespace(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static final Pair<String, String> splitProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{Literals.PROPERTY_SPLITTER}, false, 2, 2, (Object) null);
        return TuplesKt.m1606to(StringsKt.trim((CharSequence) listSplit$default.get(0)).toString(), StringsKt.trim((CharSequence) listSplit$default.get(1)).toString());
    }

    public static final List<String> splitWhitespace(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trim((CharSequence) str).toString(), new String[]{" ", "\t"}, false, i, 2, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSplit$default) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        return arrayList3;
    }

    public static final String stripComments(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return stripEnd(stripEnd(str, Literals.COMMENT_1), Literals.COMMENT_2);
    }

    public static final String stripInlineComments(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return stripEnd(stripEnd(str, Literals.INLINE_COMMENT_1), Literals.INLINE_COMMENT_2);
    }

    private static final String stripEnd(String str, String str2) {
        return (String) StringsKt.split$default((CharSequence) str, new String[]{str2}, false, 2, 2, (Object) null).get(0);
    }
}
