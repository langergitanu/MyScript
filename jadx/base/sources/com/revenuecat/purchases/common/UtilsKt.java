package com.revenuecat.purchases.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.models.ChecksumKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0002H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0005*\u00020\u000fH\u0000\u001a\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0005*\u00020\u0005H\u0007\u001a\f\u0010\u0013\u001a\u00020\u0005*\u00020\u0005H\u0007\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001a\u0010\b\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"isDeviceProtectedStorageCompat", "", "Landroid/content/Context;", "(Landroid/content/Context;)Z", "playServicesVersionName", "", "getPlayServicesVersionName", "(Landroid/content/Context;)Ljava/lang/String;", "playStoreVersionName", "getPlayStoreVersionName", "versionName", "getVersionName", "getLocale", "Ljava/util/Locale;", "md5Hex", "", "packageVersionName", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "sha1", SigningManager.POST_PARAMS_ALGORITHM, "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class UtilsKt {
    public static final Locale getLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getConfiguration().getLocales().get(0);
    }

    public static final String sha1(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, Charsets.UTF_8);
    }

    public static final String sha256(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(messageDigest.digest(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(it, Base64.NO_WRAP)");
        return new String(bArrEncode, Charsets.UTF_8);
    }

    public static final String md5Hex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "getInstance(\"MD5\")\n        .digest(this)");
        return ChecksumKt.toHexString(bArrDigest);
    }

    public static final String getVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    private static final String packageVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final String getPlayStoreVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return packageVersionName(context, "com.android.vending");
    }

    public static final String getPlayServicesVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return packageVersionName(context, "com.google.android.gms");
    }

    public static final boolean isDeviceProtectedStorageCompat(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.isDeviceProtectedStorage();
    }
}
