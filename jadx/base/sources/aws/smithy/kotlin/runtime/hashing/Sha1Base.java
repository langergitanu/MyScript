package aws.smithy.kotlin.runtime.hashing;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;

/* JADX INFO: compiled from: Sha1.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/hashing/Sha1Base;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "<init>", "()V", "", "blockSizeBytes", "I", "getBlockSizeBytes", "()I", "digestSizeBytes", "getDigestSizeBytes", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Sha1Base implements HashFunction {
    private final int blockSizeBytes = 64;
    private final int digestSizeBytes = 20;

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public int getBlockSizeBytes() {
        return this.blockSizeBytes;
    }

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public int getDigestSizeBytes() {
        return this.digestSizeBytes;
    }
}
