package aws.sdk.kotlin.runtime.auth.credentials.profile;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProfileChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArn;", "", "roleArn", "", FirebaseAnalytics.Param.SOURCE, "Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArnSource;", "sessionName", "externalId", "<init>", "(Ljava/lang/String;Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArnSource;Ljava/lang/String;Ljava/lang/String;)V", "getRoleArn", "()Ljava/lang/String;", "getSource", "()Laws/sdk/kotlin/runtime/auth/credentials/profile/RoleArnSource;", "getSessionName", "getExternalId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class RoleArn {
    private final String externalId;
    private final String roleArn;
    private final String sessionName;
    private final RoleArnSource source;

    public static /* synthetic */ RoleArn copy$default(RoleArn roleArn, String str, RoleArnSource roleArnSource, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roleArn.roleArn;
        }
        if ((i & 2) != 0) {
            roleArnSource = roleArn.source;
        }
        if ((i & 4) != 0) {
            str2 = roleArn.sessionName;
        }
        if ((i & 8) != 0) {
            str3 = roleArn.externalId;
        }
        return roleArn.copy(str, roleArnSource, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRoleArn() {
        return this.roleArn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RoleArnSource getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionName() {
        return this.sessionName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    public final RoleArn copy(String roleArn, RoleArnSource source, String sessionName, String externalId) {
        Intrinsics.checkNotNullParameter(roleArn, "roleArn");
        return new RoleArn(roleArn, source, sessionName, externalId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleArn)) {
            return false;
        }
        RoleArn roleArn = (RoleArn) other;
        return Intrinsics.areEqual(this.roleArn, roleArn.roleArn) && this.source == roleArn.source && Intrinsics.areEqual(this.sessionName, roleArn.sessionName) && Intrinsics.areEqual(this.externalId, roleArn.externalId);
    }

    public int hashCode() {
        int iHashCode = this.roleArn.hashCode() * 31;
        RoleArnSource roleArnSource = this.source;
        int iHashCode2 = (iHashCode + (roleArnSource == null ? 0 : roleArnSource.hashCode())) * 31;
        String str = this.sessionName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.externalId;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RoleArn(roleArn=" + this.roleArn + ", source=" + this.source + ", sessionName=" + this.sessionName + ", externalId=" + this.externalId + ')';
    }

    public RoleArn(String roleArn, RoleArnSource roleArnSource, String str, String str2) {
        Intrinsics.checkNotNullParameter(roleArn, "roleArn");
        this.roleArn = roleArn;
        this.source = roleArnSource;
        this.sessionName = str;
        this.externalId = str2;
    }

    public /* synthetic */ RoleArn(String str, RoleArnSource roleArnSource, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : roleArnSource, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getRoleArn() {
        return this.roleArn;
    }

    public final RoleArnSource getSource() {
        return this.source;
    }

    public final String getSessionName() {
        return this.sessionName;
    }

    public final String getExternalId() {
        return this.externalId;
    }
}
