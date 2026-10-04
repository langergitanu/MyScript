package aws.sdk.kotlin.services.p010s3.express;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.util.SingleFlightGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: S3ExpressCredentialsCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/express/S3ExpressCredentialsCacheValue;", "", "expiringCredentials", "Laws/sdk/kotlin/services/s3/express/ExpiringValue;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "sfg", "Laws/smithy/kotlin/runtime/util/SingleFlightGroup;", "<init>", "(Laws/sdk/kotlin/services/s3/express/ExpiringValue;Laws/smithy/kotlin/runtime/util/SingleFlightGroup;)V", "getExpiringCredentials", "()Laws/sdk/kotlin/services/s3/express/ExpiringValue;", "getSfg", "()Laws/smithy/kotlin/runtime/util/SingleFlightGroup;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class S3ExpressCredentialsCacheValue {
    private final ExpiringValue<Credentials> expiringCredentials;
    private final SingleFlightGroup<ExpiringValue<Credentials>> sfg;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ S3ExpressCredentialsCacheValue copy$default(S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue, ExpiringValue expiringValue, SingleFlightGroup singleFlightGroup, int i, Object obj) {
        if ((i & 1) != 0) {
            expiringValue = s3ExpressCredentialsCacheValue.expiringCredentials;
        }
        if ((i & 2) != 0) {
            singleFlightGroup = s3ExpressCredentialsCacheValue.sfg;
        }
        return s3ExpressCredentialsCacheValue.copy(expiringValue, singleFlightGroup);
    }

    public final ExpiringValue<Credentials> component1() {
        return this.expiringCredentials;
    }

    public final SingleFlightGroup<ExpiringValue<Credentials>> component2() {
        return this.sfg;
    }

    public final S3ExpressCredentialsCacheValue copy(ExpiringValue<Credentials> expiringCredentials, SingleFlightGroup<ExpiringValue<Credentials>> sfg) {
        Intrinsics.checkNotNullParameter(expiringCredentials, "expiringCredentials");
        Intrinsics.checkNotNullParameter(sfg, "sfg");
        return new S3ExpressCredentialsCacheValue(expiringCredentials, sfg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3ExpressCredentialsCacheValue)) {
            return false;
        }
        S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue = (S3ExpressCredentialsCacheValue) other;
        return Intrinsics.areEqual(this.expiringCredentials, s3ExpressCredentialsCacheValue.expiringCredentials) && Intrinsics.areEqual(this.sfg, s3ExpressCredentialsCacheValue.sfg);
    }

    public int hashCode() {
        return (this.expiringCredentials.hashCode() * 31) + this.sfg.hashCode();
    }

    public String toString() {
        return "S3ExpressCredentialsCacheValue(expiringCredentials=" + this.expiringCredentials + ", sfg=" + this.sfg + ')';
    }

    public S3ExpressCredentialsCacheValue(ExpiringValue<Credentials> expiringCredentials, SingleFlightGroup<ExpiringValue<Credentials>> sfg) {
        Intrinsics.checkNotNullParameter(expiringCredentials, "expiringCredentials");
        Intrinsics.checkNotNullParameter(sfg, "sfg");
        this.expiringCredentials = expiringCredentials;
        this.sfg = sfg;
    }

    public final ExpiringValue<Credentials> getExpiringCredentials() {
        return this.expiringCredentials;
    }

    public /* synthetic */ S3ExpressCredentialsCacheValue(ExpiringValue expiringValue, SingleFlightGroup singleFlightGroup, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(expiringValue, (i & 2) != 0 ? new SingleFlightGroup() : singleFlightGroup);
    }

    public final SingleFlightGroup<ExpiringValue<Credentials>> getSfg() {
        return this.sfg;
    }
}
