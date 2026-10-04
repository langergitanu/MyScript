package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Crc32.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"", "Lkotlin/UInt;", "crc32", "([B)I", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Crc32Kt {
    @InternalApi
    public static final int crc32(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Crc32 crc32 = new Crc32();
        HashFunction.update$default(crc32, bArr, 0, 0, 6, null);
        return crc32.mo12160digestValuepVg5ArA();
    }
}
