package com.revenuecat.purchases.common.remoteconfig;

import android.util.Base64;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: RemoteConfigUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigUtils;", "", "()V", "REF_HASH_BYTES", "", "REF_REGEX", "Lkotlin/text/Regex;", "SHA_256_ALGORITHM", "", "contentAddressRef", "bytes", "", "isValidRef", "", "ref", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RemoteConfigUtils {
    private static final int REF_HASH_BYTES = 24;
    private static final String SHA_256_ALGORITHM = "SHA-256";
    public static final RemoteConfigUtils INSTANCE = new RemoteConfigUtils();
    private static final Regex REF_REGEX = new Regex("^[A-Za-z0-9_-]{32}$");

    private RemoteConfigUtils() {
    }

    public final boolean isValidRef(String ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        return REF_REGEX.matches(ref);
    }

    public final String contentAddressRef(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        byte[] bArrCopyOf = Arrays.copyOf(digest, 24);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        String strEncodeToString = Base64.encodeToString(bArrCopyOf, 11);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(truncated…ADDING or Base64.NO_WRAP)");
        return strEncodeToString;
    }
}
