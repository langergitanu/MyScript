package aws.sdk.kotlin.runtime.endpoint.functions;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Functions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/runtime/endpoint/functions/PartitionConfig;", "", "name", "", "dnsSuffix", "dualStackDnsSuffix", "supportsFIPS", "", "supportsDualStack", "implicitGlobalRegion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getDnsSuffix", "getDualStackDnsSuffix", "getSupportsFIPS", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSupportsDualStack", "getImplicitGlobalRegion", "mergeWith", "other", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Laws/sdk/kotlin/runtime/endpoint/functions/PartitionConfig;", "equals", "hashCode", "", "toString", "aws-endpoint"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class PartitionConfig {
    private final String dnsSuffix;
    private final String dualStackDnsSuffix;
    private final String implicitGlobalRegion;
    private final String name;
    private final Boolean supportsDualStack;
    private final Boolean supportsFIPS;

    public PartitionConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ PartitionConfig copy$default(PartitionConfig partitionConfig, String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = partitionConfig.name;
        }
        if ((i & 2) != 0) {
            str2 = partitionConfig.dnsSuffix;
        }
        if ((i & 4) != 0) {
            str3 = partitionConfig.dualStackDnsSuffix;
        }
        if ((i & 8) != 0) {
            bool = partitionConfig.supportsFIPS;
        }
        if ((i & 16) != 0) {
            bool2 = partitionConfig.supportsDualStack;
        }
        if ((i & 32) != 0) {
            str4 = partitionConfig.implicitGlobalRegion;
        }
        Boolean bool3 = bool2;
        String str5 = str4;
        return partitionConfig.copy(str, str2, str3, bool, bool3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDnsSuffix() {
        return this.dnsSuffix;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDualStackDnsSuffix() {
        return this.dualStackDnsSuffix;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getSupportsFIPS() {
        return this.supportsFIPS;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getSupportsDualStack() {
        return this.supportsDualStack;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImplicitGlobalRegion() {
        return this.implicitGlobalRegion;
    }

    public final PartitionConfig copy(String name, String dnsSuffix, String dualStackDnsSuffix, Boolean supportsFIPS, Boolean supportsDualStack, String implicitGlobalRegion) {
        return new PartitionConfig(name, dnsSuffix, dualStackDnsSuffix, supportsFIPS, supportsDualStack, implicitGlobalRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartitionConfig)) {
            return false;
        }
        PartitionConfig partitionConfig = (PartitionConfig) other;
        return Intrinsics.areEqual(this.name, partitionConfig.name) && Intrinsics.areEqual(this.dnsSuffix, partitionConfig.dnsSuffix) && Intrinsics.areEqual(this.dualStackDnsSuffix, partitionConfig.dualStackDnsSuffix) && Intrinsics.areEqual(this.supportsFIPS, partitionConfig.supportsFIPS) && Intrinsics.areEqual(this.supportsDualStack, partitionConfig.supportsDualStack) && Intrinsics.areEqual(this.implicitGlobalRegion, partitionConfig.implicitGlobalRegion);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.dnsSuffix;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dualStackDnsSuffix;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.supportsFIPS;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.supportsDualStack;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str4 = this.implicitGlobalRegion;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "PartitionConfig(name=" + this.name + ", dnsSuffix=" + this.dnsSuffix + ", dualStackDnsSuffix=" + this.dualStackDnsSuffix + ", supportsFIPS=" + this.supportsFIPS + ", supportsDualStack=" + this.supportsDualStack + ", implicitGlobalRegion=" + this.implicitGlobalRegion + ')';
    }

    public PartitionConfig(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4) {
        this.name = str;
        this.dnsSuffix = str2;
        this.dualStackDnsSuffix = str3;
        this.supportsFIPS = bool;
        this.supportsDualStack = bool2;
        this.implicitGlobalRegion = str4;
    }

    public /* synthetic */ PartitionConfig(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : str4);
    }

    public final String getName() {
        return this.name;
    }

    public final String getDnsSuffix() {
        return this.dnsSuffix;
    }

    public final String getDualStackDnsSuffix() {
        return this.dualStackDnsSuffix;
    }

    public final Boolean getSupportsFIPS() {
        return this.supportsFIPS;
    }

    public final Boolean getSupportsDualStack() {
        return this.supportsDualStack;
    }

    public final String getImplicitGlobalRegion() {
        return this.implicitGlobalRegion;
    }

    public final PartitionConfig mergeWith(PartitionConfig other) {
        Intrinsics.checkNotNullParameter(other, "other");
        String str = other.name;
        if (str == null) {
            str = this.name;
        }
        String str2 = str;
        String str3 = other.dnsSuffix;
        if (str3 == null) {
            str3 = this.dnsSuffix;
        }
        String str4 = str3;
        String str5 = other.dualStackDnsSuffix;
        if (str5 == null) {
            str5 = this.dualStackDnsSuffix;
        }
        String str6 = str5;
        Boolean bool = other.supportsFIPS;
        if (bool == null) {
            bool = this.supportsFIPS;
        }
        Boolean bool2 = bool;
        Boolean bool3 = other.supportsDualStack;
        if (bool3 == null) {
            bool3 = this.supportsDualStack;
        }
        Boolean bool4 = bool3;
        String str7 = other.implicitGlobalRegion;
        if (str7 == null) {
            str7 = this.implicitGlobalRegion;
        }
        return new PartitionConfig(str2, str4, str6, bool2, bool4, str7);
    }
}
