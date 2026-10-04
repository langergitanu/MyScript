package com.myscript.nebo.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\n\u001a$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"NAME_MAXIMUM_LENGTH", "", "INVALID_CHARACTERS_HUMAN_READABLE", "", "invalidCharacters", "Lkotlin/text/Regex;", "getInvalidCharacters", "()Lkotlin/text/Regex;", "consecutiveWhiteSpaces", "normalizeSpaces", "", "cleanName", "name", "sizeLimit", "badCharReplacement", "common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NameUtils {
    public static final String INVALID_CHARACTERS_HUMAN_READABLE = "\\ / : * ? \" < > | ; ! . `";
    public static final int NAME_MAXIMUM_LENGTH = 40;
    private static final Regex invalidCharacters = new Regex("[\\r\\n\\\\/:*?\"<>|;!.`]");
    private static final Regex consecutiveWhiteSpaces = new Regex("\\s{2,}");

    public static final String cleanName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return cleanName$default(name, 0, null, 6, null);
    }

    public static final String cleanName(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        return cleanName$default(name, i, null, 4, null);
    }

    public static final Regex getInvalidCharacters() {
        return invalidCharacters;
    }

    public static final String normalizeSpaces(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return consecutiveWhiteSpaces.replace(StringsKt.trim(charSequence), " ");
    }

    public static /* synthetic */ String cleanName$default(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 40;
        }
        if ((i2 & 4) != 0) {
            str2 = "_";
        }
        return cleanName(str, i, str2);
    }

    public static final String cleanName(String name, int i, String badCharReplacement) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(badCharReplacement, "badCharReplacement");
        String strReplace = invalidCharacters.replace(EmojiUtils.replaceEmoji(normalizeSpaces(name), badCharReplacement), badCharReplacement);
        if (i > 0 && strReplace.length() > i) {
            strReplace = strReplace.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(strReplace, "substring(...)");
        }
        return StringsKt.trim((CharSequence) strReplace).toString();
    }
}
