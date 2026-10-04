package aws.smithy.kotlin.runtime.util;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CachedValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0015HÖ\u0081\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/ExpiringValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "Laws/smithy/kotlin/runtime/time/Instant;", "expiresAt", "<init>", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/time/Instant;)V", "component1", "()Ljava/lang/Object;", "component2", "()Laws/smithy/kotlin/runtime/time/Instant;", "copy", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/time/Instant;)Laws/smithy/kotlin/runtime/util/ExpiringValue;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getValue", "Laws/smithy/kotlin/runtime/time/Instant;", "getExpiresAt", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ExpiringValue<T> {
    private final Instant expiresAt;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpiringValue copy$default(ExpiringValue expiringValue, Object obj, Instant instant, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = expiringValue.value;
        }
        if ((i & 2) != 0) {
            instant = expiringValue.expiresAt;
        }
        return expiringValue.copy(obj, instant);
    }

    public final T component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Instant getExpiresAt() {
        return this.expiresAt;
    }

    public final ExpiringValue<T> copy(T value, Instant expiresAt) {
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        return new ExpiringValue<>(value, expiresAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpiringValue)) {
            return false;
        }
        ExpiringValue expiringValue = (ExpiringValue) other;
        return Intrinsics.areEqual(this.value, expiringValue.value) && Intrinsics.areEqual(this.expiresAt, expiringValue.expiresAt);
    }

    public int hashCode() {
        T t = this.value;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.expiresAt.hashCode();
    }

    public String toString() {
        return "ExpiringValue(value=" + this.value + ", expiresAt=" + this.expiresAt + ')';
    }

    public ExpiringValue(T t, Instant expiresAt) {
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        this.value = t;
        this.expiresAt = expiresAt;
    }

    public final Instant getExpiresAt() {
        return this.expiresAt;
    }

    public final T getValue() {
        return this.value;
    }
}
