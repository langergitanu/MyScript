package com.dropbox.core.android.internal;

import com.dropbox.core.DbxPKCEManager;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: QueryParamsUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/dropbox/core/android/internal/QueryParamsUtil;", "", "()V", "createExtraQueryParams", "", "tokenAccessType", "Lcom/dropbox/core/TokenAccessType;", "scope", "includeGrantedScopes", "Lcom/dropbox/core/IncludeGrantedScopes;", "pkceManagerCodeChallenge", "createExtraQueryParams$android_release", "android_release"}, m1600k = 1, m1601mv = {1, 6, 0}, m1603xi = 48)
public final class QueryParamsUtil {
    public static final QueryParamsUtil INSTANCE = new QueryParamsUtil();

    private QueryParamsUtil() {
    }

    public final String createExtraQueryParams$android_release(TokenAccessType tokenAccessType, String scope, IncludeGrantedScopes includeGrantedScopes, String pkceManagerCodeChallenge) {
        Intrinsics.checkNotNullParameter(pkceManagerCodeChallenge, "pkceManagerCodeChallenge");
        if (tokenAccessType == null) {
            throw new IllegalStateException("Extra Query Param should only be used in short live token flow.".toString());
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = String.format(Locale.US, "%s=%s&%s=%s&%s=%s&%s=%s", Arrays.copyOf(new Object[]{"code_challenge", pkceManagerCodeChallenge, "code_challenge_method", DbxPKCEManager.CODE_CHALLENGE_METHODS, "token_access_type", tokenAccessType.toString(), "response_type", "code"}, 8));
        Intrinsics.checkNotNullExpressionValue(string, "format(locale, format, *args)");
        if (scope != null) {
            StringBuilder sbAppend = new StringBuilder().append(string);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "&%s=%s", Arrays.copyOf(new Object[]{"scope", scope}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
            string = sbAppend.append(str).toString();
        }
        if (includeGrantedScopes == null) {
            return string;
        }
        StringBuilder sbAppend2 = new StringBuilder().append(string);
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str2 = String.format(Locale.US, "&%s=%s", Arrays.copyOf(new Object[]{"include_granted_scopes", includeGrantedScopes.toString()}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
        return sbAppend2.append(str2).toString();
    }
}
