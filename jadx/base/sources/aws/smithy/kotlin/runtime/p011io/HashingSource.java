package aws.smithy.kotlin.runtime.p011io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.p011io.internal.SdkSourceObserver;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HashingSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/HashingSource;", "Laws/smithy/kotlin/runtime/io/internal/SdkSourceObserver;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "hash", "Laws/smithy/kotlin/runtime/io/SdkSource;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Laws/smithy/kotlin/runtime/hashing/HashFunction;Laws/smithy/kotlin/runtime/io/SdkSource;)V", "", "data", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "", "observe", "([BII)V", "digest", "()[B", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "Laws/smithy/kotlin/runtime/io/SdkSource;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HashingSource extends SdkSourceObserver {
    private final HashFunction hash;
    private final SdkSource source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(HashFunction hash, SdkSource source) {
        super(source);
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(source, "source");
        this.hash = hash;
        this.source = source;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.internal.SdkSourceObserver
    public void observe(byte[] data, int offset, int length) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.hash.update(data, offset, length);
    }

    public final byte[] digest() {
        return this.hash.digest();
    }
}
