package aws.smithy.kotlin.runtime.hashing;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Ecdsa.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0010\u0012\n\u0002\b\b\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"", SubscriberAttributeKt.JSON_NAME_KEY, "message", "ecdsaSecp256r1Rs", "([B[B)[B", "derSignature", "parseDerSignature", "([B)[B", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EcdsaKt {
    public static final byte[] ecdsaSecp256r1Rs(byte[] key, byte[] message) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(message, "message");
        return parseDerSignature(EcdsaJVMKt.ecdsaSecp256r1(key, message));
    }

    private static final byte[] parseDerSignature(byte[] bArr) {
        int i = bArr[3] & 255;
        byte[] bArrSliceArray = ArraysKt.sliceArray(bArr, RangesKt.until(4, 4 + i));
        int i2 = i + 5;
        int i3 = i + 6;
        byte[] bArrSliceArray2 = ArraysKt.sliceArray(bArr, RangesKt.until(i3, (bArr[i2] & 255) + i3));
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (byte b : bArrSliceArray) {
            if (z) {
                arrayList.add(Byte.valueOf(b));
            } else if (b != 0) {
                arrayList.add(Byte.valueOf(b));
                z = true;
            }
        }
        byte[] byteArray = CollectionsKt.toByteArray(arrayList);
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        for (byte b2 : bArrSliceArray2) {
            if (z2) {
                arrayList2.add(Byte.valueOf(b2));
            } else if (b2 != 0) {
                arrayList2.add(Byte.valueOf(b2));
                z2 = true;
            }
        }
        byte[] byteArray2 = CollectionsKt.toByteArray(arrayList2);
        if (byteArray.length < 32) {
            byteArray = ArraysKt.plus(new byte[32 - byteArray.length], byteArray);
        }
        if (byteArray2.length < 32) {
            byteArray2 = ArraysKt.plus(new byte[32 - byteArray2.length], byteArray2);
        }
        return ArraysKt.plus(byteArray, byteArray2);
    }
}
