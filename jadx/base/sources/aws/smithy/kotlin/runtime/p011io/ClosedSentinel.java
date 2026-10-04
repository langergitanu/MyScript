package aws.smithy.kotlin.runtime.p011io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RealSdkByteChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eHÖ\u0081\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u00020\u0011HÖ\u0081\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/ClosedSentinel;", "", "", "cause", "<init>", "(Ljava/lang/Throwable;)V", "component1", "()Ljava/lang/Throwable;", "copy", "(Ljava/lang/Throwable;)Laws/smithy/kotlin/runtime/io/ClosedSentinel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getCause", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ClosedSentinel {
    private final Throwable cause;

    public static /* synthetic */ ClosedSentinel copy$default(ClosedSentinel closedSentinel, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = closedSentinel.cause;
        }
        return closedSentinel.copy(th);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    public final ClosedSentinel copy(Throwable cause) {
        return new ClosedSentinel(cause);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ClosedSentinel) && Intrinsics.areEqual(this.cause, ((ClosedSentinel) other).cause);
    }

    public int hashCode() {
        Throwable th = this.cause;
        if (th == null) {
            return 0;
        }
        return th.hashCode();
    }

    public String toString() {
        return "ClosedSentinel(cause=" + this.cause + ')';
    }

    public ClosedSentinel(Throwable th) {
        this.cause = th;
    }

    public final Throwable getCause() {
        return this.cause;
    }
}
