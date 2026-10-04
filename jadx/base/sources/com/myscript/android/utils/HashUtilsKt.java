package com.myscript.android.utils;

import com.revenuecat.purchases.common.verification.SigningManager;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: HashUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"md5", "", "getMd5", "(Ljava/lang/String;)Ljava/lang/String;", SigningManager.POST_PARAMS_ALGORITHM, "getSha256", "hexa", "Ljava/math/BigInteger;", "getHexa", "(Ljava/math/BigInteger;)Ljava/lang/String;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HashUtilsKt {
    public static final String getMd5(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return getHexa(new BigInteger(1, messageDigest.digest(bytes)));
    }

    public static final String getSha256(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return getHexa(new BigInteger(1, messageDigest.digest(bytes)));
    }

    private static final String getHexa(BigInteger bigInteger) {
        String string = bigInteger.toString(16);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.padStart(string, 32, '0');
    }
}
