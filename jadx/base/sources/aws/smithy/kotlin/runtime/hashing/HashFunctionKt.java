package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.ClientException;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.businessmetrics.BusinessMetric;
import aws.smithy.kotlin.runtime.businessmetrics.SmithyBusinessMetric;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: HashFunction.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0006\u001a%\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00000\u0007j\u0002`\bH\u0007¢\u0006\u0004\b\u0004\u0010\n\u001a\u0015\u0010\f\u001a\u0004\u0018\u00010\u0000*\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u0000*\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u000b*\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u000f\u001a\u00020\u000b*\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\"\u001e\u0010\u0016\u001a\u00020\u0015*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017*\u001c\b\u0007\u0010\u001b\"\b\u0012\u0004\u0012\u00020\u00000\u00072\b\u0012\u0004\u0012\u00020\u00000\u0007B\u0002\b\u001a¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/hashing/HashFunction;", "fn", "", "input", "hash", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;[B)[B", "([BLaws/smithy/kotlin/runtime/hashing/HashFunction;)[B", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/hashing/HashSupplier;", "hashSupplier", "([BLkotlin/jvm/functions/Function0;)[B", "", "toHashFunction", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/hashing/HashFunction;", "toHashFunctionOrThrow", "resolveChecksumAlgorithmHeaderName", "(Ljava/lang/String;)Ljava/lang/String;", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;)Ljava/lang/String;", "Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "toBusinessMetric", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;)Laws/smithy/kotlin/runtime/businessmetrics/BusinessMetric;", "", "isSupportedForFlexibleChecksums", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;)Z", "isSupportedForFlexibleChecksums$annotations", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;)V", "Laws/smithy/kotlin/runtime/InternalApi;", "HashSupplier", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HashFunctionKt {
    @InternalApi
    public static /* synthetic */ void HashSupplier$annotations() {
    }

    @InternalApi
    public static /* synthetic */ void isSupportedForFlexibleChecksums$annotations(HashFunction hashFunction) {
    }

    public static final byte[] hash(HashFunction fn, byte[] input) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        Intrinsics.checkNotNullParameter(input, "input");
        HashFunction.update$default(fn, input, 0, 0, 6, null);
        return fn.digest();
    }

    @InternalApi
    public static final byte[] hash(byte[] bArr, HashFunction fn) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(fn, "fn");
        return hash(fn, bArr);
    }

    @InternalApi
    public static final byte[] hash(byte[] bArr, Function0<? extends HashFunction> hashSupplier) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(hashSupplier, "hashSupplier");
        return hash(hashSupplier.invoke(), bArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @InternalApi
    public static final HashFunction toHashFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1352399984:
                if (lowerCase.equals("crc32c")) {
                    return new Crc32c();
                }
                return null;
            case -903629273:
                if (lowerCase.equals(SigningManager.POST_PARAMS_ALGORITHM)) {
                    return new Sha256();
                }
                return null;
            case 107902:
                if (lowerCase.equals("md5")) {
                    return new Md5();
                }
                return null;
            case 3528965:
                if (lowerCase.equals("sha1")) {
                    return new Sha1();
                }
                return null;
            case 94921523:
                if (lowerCase.equals("crc32")) {
                    return new Crc32();
                }
                return null;
            default:
                return null;
        }
    }

    @InternalApi
    public static final HashFunction toHashFunctionOrThrow(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        HashFunction hashFunction = toHashFunction(str);
        if (hashFunction != null) {
            return hashFunction;
        }
        throw new ClientException("Checksum algorithm is not supported: " + str);
    }

    public static final boolean isSupportedForFlexibleChecksums(HashFunction hashFunction) {
        Intrinsics.checkNotNullParameter(hashFunction, "<this>");
        return (hashFunction instanceof Crc32) || (hashFunction instanceof Crc32c) || (hashFunction instanceof Sha1) || (hashFunction instanceof Sha256);
    }

    @InternalApi
    public static final String resolveChecksumAlgorithmHeaderName(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return resolveChecksumAlgorithmHeaderName(toHashFunctionOrThrow(str));
    }

    @InternalApi
    public static final String resolveChecksumAlgorithmHeaderName(HashFunction hashFunction) {
        Intrinsics.checkNotNullParameter(hashFunction, "<this>");
        if (hashFunction instanceof Crc32) {
            return "x-amz-checksum-crc32";
        }
        if (hashFunction instanceof Crc32c) {
            return "x-amz-checksum-crc32c";
        }
        if (hashFunction instanceof Sha1) {
            return "x-amz-checksum-sha1";
        }
        if (hashFunction instanceof Sha256) {
            return "x-amz-checksum-sha256";
        }
        if (hashFunction instanceof Md5) {
            return "Content-MD5";
        }
        throw new ClientException("Checksum algorithm is not supported: " + Reflection.getOrCreateKotlinClass(hashFunction.getClass()).getSimpleName());
    }

    @InternalApi
    public static final BusinessMetric toBusinessMetric(HashFunction hashFunction) {
        Intrinsics.checkNotNullParameter(hashFunction, "<this>");
        if (hashFunction instanceof Crc32) {
            return SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_CRC32;
        }
        if (hashFunction instanceof Crc32c) {
            return SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_CRC32C;
        }
        if (hashFunction instanceof Sha1) {
            return SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_SHA1;
        }
        if (hashFunction instanceof Sha256) {
            return SmithyBusinessMetric.FLEXIBLE_CHECKSUMS_REQ_SHA256;
        }
        throw new IllegalStateException("Checksum was calculated using an unsupported hash function: " + Reflection.getOrCreateKotlinClass(hashFunction.getClass()).getSimpleName());
    }
}
