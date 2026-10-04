package aws.smithy.kotlin.runtime.hashing;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Crc32c.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0003R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/hashing/Crc32c;", "Laws/smithy/kotlin/runtime/hashing/Crc32Base;", "<init>", "()V", "", "input", "", TypedValues.CycleType.S_WAVE_OFFSET, "length", "", "update", "([BII)V", "Lkotlin/UInt;", "digestValue-pVg5ArA", "()I", "digestValue", "reset", "Laws/smithy/kotlin/runtime/hashing/CRC32CImpl;", "md", "Laws/smithy/kotlin/runtime/hashing/CRC32CImpl;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Crc32c extends Crc32Base {
    private final CRC32CImpl md = new CRC32CImpl();

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public void update(byte[] input, int offset, int length) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.md.update(input, offset, length);
    }

    @Override // aws.smithy.kotlin.runtime.hashing.Crc32Base
    /* JADX INFO: renamed from: digestValue-pVg5ArA */
    public int mo12160digestValuepVg5ArA() {
        int iM14594constructorimpl = UInt.m14594constructorimpl(this.md.getValue());
        reset();
        return iM14594constructorimpl;
    }

    @Override // aws.smithy.kotlin.runtime.hashing.HashFunction
    public void reset() {
        this.md.reset();
    }
}
