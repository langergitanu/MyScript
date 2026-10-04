package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.p011io.internal.SdkSinkObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HashingSink.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/HashingSink;", "Laws/smithy/kotlin/runtime/io/internal/SdkSinkObserver;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "hash", "Laws/smithy/kotlin/runtime/io/SdkSink;", "sink", "<init>", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;Laws/smithy/kotlin/runtime/io/SdkSink;)V", "", "data", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "", "observe", "([BII)V", "digest", "()[B", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HashingSink extends SdkSinkObserver {
    private final HashFunction hash;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(HashFunction hash, SdkSink sink) {
        super(sink);
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.hash = hash;
    }

    public /* synthetic */ HashingSink(HashFunction hashFunction, SdkSink sdkSink, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hashFunction, (i & 2) != 0 ? SdkSink.INSTANCE.blackhole() : sdkSink);
    }

    @Override // aws.smithy.kotlin.runtime.p011io.internal.SdkSinkObserver
    public void observe(byte[] data, int offset, int length) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.hash.update(data, offset, length);
    }

    public final byte[] digest() {
        return this.hash.digest();
    }
}
