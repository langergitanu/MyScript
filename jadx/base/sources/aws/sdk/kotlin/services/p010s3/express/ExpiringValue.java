package aws.sdk.kotlin.services.p010s3.express;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;

/* JADX INFO: compiled from: S3ExpressCredentialsCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/express/ExpiringValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "expiresAt", "Lkotlin/time/ComparableTimeMark;", "<init>", "(Ljava/lang/Object;Lkotlin/time/ComparableTimeMark;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getExpiresAt", "()Lkotlin/time/ComparableTimeMark;", "component1", "component2", "copy", "(Ljava/lang/Object;Lkotlin/time/ComparableTimeMark;)Laws/sdk/kotlin/services/s3/express/ExpiringValue;", "equals", "", "other", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class ExpiringValue<T> {
    private final ComparableTimeMark expiresAt;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExpiringValue copy$default(ExpiringValue expiringValue, Object obj, ComparableTimeMark comparableTimeMark, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = expiringValue.value;
        }
        if ((i & 2) != 0) {
            comparableTimeMark = expiringValue.expiresAt;
        }
        return expiringValue.copy(obj, comparableTimeMark);
    }

    public final T component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ComparableTimeMark getExpiresAt() {
        return this.expiresAt;
    }

    public final ExpiringValue<T> copy(T value, ComparableTimeMark expiresAt) {
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

    public ExpiringValue(T t, ComparableTimeMark expiresAt) {
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        this.value = t;
        this.expiresAt = expiresAt;
    }

    public final ComparableTimeMark getExpiresAt() {
        return this.expiresAt;
    }

    public final T getValue() {
        return this.value;
    }
}
