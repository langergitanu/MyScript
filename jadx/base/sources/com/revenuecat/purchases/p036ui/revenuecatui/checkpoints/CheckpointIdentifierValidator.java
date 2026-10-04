package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CheckpointIdentifierValidator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\f\u0010\n\u001a\u00020\t*\u00020\u000bH\u0002J\f\u0010\f\u001a\u00020\t*\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointIdentifierValidator;", "", "()V", "MAX_IDENTIFIER_LENGTH", "", "invalidIdentifierLogMessage", "", Keys.IDENTIFIER, "isValid", "", "isAllowedCharacter", "", "isAsciiLetter", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CheckpointIdentifierValidator {
    public static final int $stable = 0;
    public static final CheckpointIdentifierValidator INSTANCE = new CheckpointIdentifierValidator();
    private static final int MAX_IDENTIFIER_LENGTH = 255;

    private final boolean isAsciiLetter(char c) {
        if ('a' > c || c >= '{') {
            return 'A' <= c && c < '[';
        }
        return true;
    }

    private CheckpointIdentifierValidator() {
    }

    public final boolean isValid(String identifier) {
        Character chFirstOrNull;
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (identifier.length() > 255 || (chFirstOrNull = StringsKt.firstOrNull(identifier)) == null || !isAsciiLetter(chFirstOrNull.charValue())) {
            return false;
        }
        String strDrop = StringsKt.drop(identifier, 1);
        for (int i = 0; i < strDrop.length(); i++) {
            if (!INSTANCE.isAllowedCharacter(strDrop.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public final String invalidIdentifierLogMessage(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return "Dropping invalid checkpoint identifier '" + identifier + "'. Identifiers must start with a letter, contain only ASCII letters, numbers, underscores, and hyphens, and be no more than 255 characters.";
    }

    private final boolean isAllowedCharacter(char c) {
        if (isAsciiLetter(c)) {
            return true;
        }
        return ('0' <= c && c < ':') || c == '_' || c == '-';
    }
}
