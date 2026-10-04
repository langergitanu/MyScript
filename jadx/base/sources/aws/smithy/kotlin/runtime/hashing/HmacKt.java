package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.InternalApi;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Hmac.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a1\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00030\u0007j\u0002`\bH\u0007¢\u0006\u0004\b\u0005\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"", SubscriberAttributeKt.JSON_NAME_KEY, "message", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "hashFunction", "hmac", "([B[BLaws/smithy/kotlin/runtime/hashing/HashFunction;)[B", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/hashing/HashSupplier;", "hashSupplier", "([B[BLkotlin/jvm/functions/Function0;)[B", "resizeToBlock", "([BLaws/smithy/kotlin/runtime/hashing/HashFunction;)[B", "", "byte", "xor", "([BB)[B", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HmacKt {
    @InternalApi
    public static final byte[] hmac(byte[] key, byte[] message, HashFunction hashFunction) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hashFunction, "hashFunction");
        byte[] bArrResizeToBlock = resizeToBlock(key, hashFunction);
        byte[] bArrXor = xor(bArrResizeToBlock, (byte) 54);
        byte[] bArrXor2 = xor(bArrResizeToBlock, (byte) 92);
        HashFunction.update$default(hashFunction, bArrXor, 0, 0, 6, null);
        HashFunction.update$default(hashFunction, message, 0, 0, 6, null);
        byte[] bArrDigest = hashFunction.digest();
        HashFunction.update$default(hashFunction, bArrXor2, 0, 0, 6, null);
        HashFunction.update$default(hashFunction, bArrDigest, 0, 0, 6, null);
        return hashFunction.digest();
    }

    @InternalApi
    public static final byte[] hmac(byte[] key, byte[] message, Function0<? extends HashFunction> hashSupplier) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hashSupplier, "hashSupplier");
        return hmac(key, message, hashSupplier.invoke());
    }

    private static final byte[] resizeToBlock(byte[] bArr, HashFunction hashFunction) {
        int blockSizeBytes = hashFunction.getBlockSizeBytes();
        if (bArr.length > blockSizeBytes) {
            bArr = HashFunctionKt.hash(bArr, hashFunction);
        }
        if (bArr.length >= blockSizeBytes) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, blockSizeBytes);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    private static final byte[] xor(byte[] bArr, byte b) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ b);
        }
        return bArr2;
    }
}
