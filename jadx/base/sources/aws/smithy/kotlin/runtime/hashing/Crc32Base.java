package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.UInt;

/* JADX INFO: compiled from: Crc32.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/hashing/Crc32Base;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "<init>", "()V", "Lkotlin/UInt;", "digestValue-pVg5ArA", "()I", "digestValue", "", "digest", "()[B", "", "blockSizeBytes", "I", "getBlockSizeBytes", "digestSizeBytes", "getDigestSizeBytes", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Crc32Base implements HashFunction {
    private final int blockSizeBytes = 4;
    private final int digestSizeBytes = 4;

    /* JADX INFO: renamed from: digestValue-pVg5ArA */
    public abstract int mo12160digestValuepVg5ArA();

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public int getBlockSizeBytes() {
        return this.blockSizeBytes;
    }

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public int getDigestSizeBytes() {
        return this.digestSizeBytes;
    }

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public byte[] digest() {
        int iMo12160digestValuepVg5ArA = mo12160digestValuepVg5ArA();
        return new byte[]{(byte) UInt.m14594constructorimpl(UInt.m14594constructorimpl(iMo12160digestValuepVg5ArA >>> 24) & 255), (byte) UInt.m14594constructorimpl(UInt.m14594constructorimpl(iMo12160digestValuepVg5ArA >>> 16) & 255), (byte) UInt.m14594constructorimpl(UInt.m14594constructorimpl(iMo12160digestValuepVg5ArA >>> 8) & 255), (byte) UInt.m14594constructorimpl(iMo12160digestValuepVg5ArA & 255)};
    }
}
