package aws.sdk.kotlin.runtime.endpoint.functions;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: Functions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/endpoint/functions/Partition;", "", "id", "", "regions", "", "Laws/sdk/kotlin/runtime/endpoint/functions/PartitionConfig;", "regionRegex", "Lkotlin/text/Regex;", "baseConfig", "<init>", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/text/Regex;Laws/sdk/kotlin/runtime/endpoint/functions/PartitionConfig;)V", "getId", "()Ljava/lang/String;", "getRegions", "()Ljava/util/Map;", "getRegionRegex", "()Lkotlin/text/Regex;", "getBaseConfig", "()Laws/sdk/kotlin/runtime/endpoint/functions/PartitionConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-endpoint"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class Partition {
    private final PartitionConfig baseConfig;
    private final String id;
    private final Regex regionRegex;
    private final Map<String, PartitionConfig> regions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Partition copy$default(Partition partition, String str, Map map, Regex regex, PartitionConfig partitionConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = partition.id;
        }
        if ((i & 2) != 0) {
            map = partition.regions;
        }
        if ((i & 4) != 0) {
            regex = partition.regionRegex;
        }
        if ((i & 8) != 0) {
            partitionConfig = partition.baseConfig;
        }
        return partition.copy(str, map, regex, partitionConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final Map<String, PartitionConfig> component2() {
        return this.regions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Regex getRegionRegex() {
        return this.regionRegex;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PartitionConfig getBaseConfig() {
        return this.baseConfig;
    }

    public final Partition copy(String id, Map<String, PartitionConfig> regions, Regex regionRegex, PartitionConfig baseConfig) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(regions, "regions");
        Intrinsics.checkNotNullParameter(regionRegex, "regionRegex");
        Intrinsics.checkNotNullParameter(baseConfig, "baseConfig");
        return new Partition(id, regions, regionRegex, baseConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Partition)) {
            return false;
        }
        Partition partition = (Partition) other;
        return Intrinsics.areEqual(this.id, partition.id) && Intrinsics.areEqual(this.regions, partition.regions) && Intrinsics.areEqual(this.regionRegex, partition.regionRegex) && Intrinsics.areEqual(this.baseConfig, partition.baseConfig);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.regions.hashCode()) * 31) + this.regionRegex.hashCode()) * 31) + this.baseConfig.hashCode();
    }

    public String toString() {
        return "Partition(id=" + this.id + ", regions=" + this.regions + ", regionRegex=" + this.regionRegex + ", baseConfig=" + this.baseConfig + ')';
    }

    public Partition(String id, Map<String, PartitionConfig> regions, Regex regionRegex, PartitionConfig baseConfig) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(regions, "regions");
        Intrinsics.checkNotNullParameter(regionRegex, "regionRegex");
        Intrinsics.checkNotNullParameter(baseConfig, "baseConfig");
        this.id = id;
        this.regions = regions;
        this.regionRegex = regionRegex;
        this.baseConfig = baseConfig;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, PartitionConfig> getRegions() {
        return this.regions;
    }

    public final Regex getRegionRegex() {
        return this.regionRegex;
    }

    public final PartitionConfig getBaseConfig() {
        return this.baseConfig;
    }
}
