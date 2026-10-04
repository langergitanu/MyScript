package com.dropbox.core.android.internal;

import com.dropbox.core.DbxPKCEManager;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.android.AuthActivity;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AuthUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, m1599d2 = {"Lcom/dropbox/core/android/internal/AuthUtils;", "", "()V", "createPKCEStateNonce", "", "codeChallenge", "tokenAccessType", "scope", "mIncludeGrantedScopes", "Lcom/dropbox/core/IncludeGrantedScopes;", "createStateNonce", "securityProvider", "Lcom/dropbox/core/android/AuthActivity$SecurityProvider;", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class AuthUtils {
    public static final AuthUtils INSTANCE = new AuthUtils();

    private AuthUtils() {
    }

    @JvmStatic
    public static final String createStateNonce(AuthActivity.SecurityProvider securityProvider) {
        Intrinsics.checkNotNullParameter(securityProvider, "securityProvider");
        byte[] bArr = new byte[16];
        securityProvider.getSecureRandom().nextBytes(bArr);
        StringBuilder sb = new StringBuilder("oauth2:");
        for (int i = 0; i < 16; i++) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(bArr[i] & 255)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @JvmStatic
    public static final String createPKCEStateNonce(String codeChallenge, String tokenAccessType, String scope, IncludeGrantedScopes mIncludeGrantedScopes) {
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
        Intrinsics.checkNotNullParameter(tokenAccessType, "tokenAccessType");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "oauth2code:%s:%s:%s", Arrays.copyOf(new Object[]{codeChallenge, DbxPKCEManager.CODE_CHALLENGE_METHODS, tokenAccessType}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        if (scope != null) {
            str = str + AbstractJsonLexerKt.COLON + scope;
        }
        return mIncludeGrantedScopes != null ? str + AbstractJsonLexerKt.COLON + mIncludeGrantedScopes : str;
    }
}
