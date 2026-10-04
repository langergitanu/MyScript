package aws.smithy.kotlin.runtime.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u00020\u0012HÖ\u0081\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0004HÖ\u0081\u0004¢\u0006\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/OperatingSystem;", "", "Laws/smithy/kotlin/runtime/util/OsFamily;", "family", "", "version", "<init>", "(Laws/smithy/kotlin/runtime/util/OsFamily;Ljava/lang/String;)V", "component1", "()Laws/smithy/kotlin/runtime/util/OsFamily;", "component2", "()Ljava/lang/String;", "copy", "(Laws/smithy/kotlin/runtime/util/OsFamily;Ljava/lang/String;)Laws/smithy/kotlin/runtime/util/OperatingSystem;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Laws/smithy/kotlin/runtime/util/OsFamily;", "getFamily", "Ljava/lang/String;", "getVersion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class OperatingSystem {
    private final OsFamily family;
    private final String version;

    public static /* synthetic */ OperatingSystem copy$default(OperatingSystem operatingSystem, OsFamily osFamily, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            osFamily = operatingSystem.family;
        }
        if ((i & 2) != 0) {
            str = operatingSystem.version;
        }
        return operatingSystem.copy(osFamily, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final OsFamily getFamily() {
        return this.family;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final OperatingSystem copy(OsFamily family, String version) {
        Intrinsics.checkNotNullParameter(family, "family");
        return new OperatingSystem(family, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperatingSystem)) {
            return false;
        }
        OperatingSystem operatingSystem = (OperatingSystem) other;
        return this.family == operatingSystem.family && Intrinsics.areEqual(this.version, operatingSystem.version);
    }

    public int hashCode() {
        int iHashCode = this.family.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "OperatingSystem(family=" + this.family + ", version=" + this.version + ')';
    }

    public OperatingSystem(OsFamily family, String str) {
        Intrinsics.checkNotNullParameter(family, "family");
        this.family = family;
        this.version = str;
    }

    public final OsFamily getFamily() {
        return this.family;
    }

    public final String getVersion() {
        return this.version;
    }
}
