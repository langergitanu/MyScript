package aws.sdk.kotlin.services.p010s3.express;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.collections.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ExpressCredentialsCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u001a\u0018\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\u0000\u001a!\u0010\f\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000b*$\b\u0000\u0010\u0002\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*$\b\u0000\u0010\u0011\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00122\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0012¨\u0006\u0013"}, m1599d2 = {"DEFAULT_S3_EXPRESS_CACHE_SIZE", "", "S3ExpressCredentialsCache", "Laws/smithy/kotlin/runtime/collections/LruCache;", "Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheKey;", "Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheValue;", "Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCache;", "isExpired", "", "Laws/sdk/kotlin/services/s3/express/ExpiringValue;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "(Laws/sdk/kotlin/services/s3/express/ExpiringValue;)Z", "isExpiringWithin", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "isExpiringWithin-HG0u8IE", "(Laws/sdk/kotlin/services/s3/express/ExpiringValue;J)Z", "S3ExpressCredentialsCacheEntry", "", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3ExpressCredentialsCacheKt {
    private static final int DEFAULT_S3_EXPRESS_CACHE_SIZE = 100;

    public static final LruCache<S3ExpressCredentialsCacheKey, S3ExpressCredentialsCacheValue> S3ExpressCredentialsCache() {
        return new LruCache<>(100);
    }

    public static final boolean isExpired(ExpiringValue<Credentials> expiringValue) {
        Intrinsics.checkNotNullParameter(expiringValue, "<this>");
        return expiringValue.getExpiresAt().hasPassedNow();
    }

    /* JADX INFO: renamed from: isExpiringWithin-HG0u8IE, reason: not valid java name */
    public static final boolean m12073isExpiringWithinHG0u8IE(ExpiringValue<Credentials> isExpiringWithin, long j) {
        Intrinsics.checkNotNullParameter(isExpiringWithin, "$this$isExpiringWithin");
        return isExpiringWithin.getExpiresAt().mo15845minusLRDsOJo(j).hasPassedNow();
    }
}
