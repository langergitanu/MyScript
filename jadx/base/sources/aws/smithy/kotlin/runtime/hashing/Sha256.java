package aws.smithy.kotlin.runtime.hashing;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.InternalApi;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: Sha256JVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0003R\u001c\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/hashing/Sha256;", "Laws/smithy/kotlin/runtime/hashing/Sha256Base;", "<init>", "()V", "", "input", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "", "update", "([BII)V", "digest", "()[B", "reset", "Ljava/security/MessageDigest;", "kotlin.jvm.PlatformType", "md", "Ljava/security/MessageDigest;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Sha256 extends Sha256Base {
    private final MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public void update(byte[] input, int offset, int length) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.md.update(input, offset, length);
    }

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public byte[] digest() {
        byte[] bArrDigest = this.md.digest();
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return bArrDigest;
    }

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public void reset() {
        this.md.reset();
    }
}
