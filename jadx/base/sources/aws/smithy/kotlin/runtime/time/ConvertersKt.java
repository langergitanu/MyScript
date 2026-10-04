package aws.smithy.kotlin.runtime.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Converters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/time/Instant;", "Ljava/time/Instant;", "toJvmInstant", "(Laws/smithy/kotlin/runtime/time/Instant;)Ljava/time/Instant;", "toSdkInstant", "(Ljava/time/Instant;)Laws/smithy/kotlin/runtime/time/Instant;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConvertersKt {
    public static final java.time.Instant toJvmInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.getValue();
    }

    public static final Instant toSdkInstant(java.time.Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return new Instant(instant);
    }
}
