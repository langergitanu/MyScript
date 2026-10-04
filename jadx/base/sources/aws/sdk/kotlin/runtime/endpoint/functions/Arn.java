package aws.sdk.kotlin.runtime.endpoint.functions;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Functions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, m1599d2 = {"Laws/sdk/kotlin/runtime/endpoint/functions/Arn;", "", "partition", "", NotificationCompat.CATEGORY_SERVICE, TtmlNode.TAG_REGION, "accountId", "resourceId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPartition", "()Ljava/lang/String;", "getService", "getRegion", "getAccountId", "getResourceId", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-endpoint"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final /* data */ class Arn {
    private final String accountId;
    private final String partition;
    private final String region;
    private final List<String> resourceId;
    private final String service;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Arn copy$default(Arn arn, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = arn.partition;
        }
        if ((i & 2) != 0) {
            str2 = arn.service;
        }
        if ((i & 4) != 0) {
            str3 = arn.region;
        }
        if ((i & 8) != 0) {
            str4 = arn.accountId;
        }
        if ((i & 16) != 0) {
            list = arn.resourceId;
        }
        List list2 = list;
        String str5 = str3;
        return arn.copy(str, str2, str5, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPartition() {
        return this.partition;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getService() {
        return this.service;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    public final List<String> component5() {
        return this.resourceId;
    }

    public final Arn copy(String partition, String service, String region, String accountId, List<String> resourceId) {
        Intrinsics.checkNotNullParameter(partition, "partition");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        return new Arn(partition, service, region, accountId, resourceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Arn)) {
            return false;
        }
        Arn arn = (Arn) other;
        return Intrinsics.areEqual(this.partition, arn.partition) && Intrinsics.areEqual(this.service, arn.service) && Intrinsics.areEqual(this.region, arn.region) && Intrinsics.areEqual(this.accountId, arn.accountId) && Intrinsics.areEqual(this.resourceId, arn.resourceId);
    }

    public int hashCode() {
        return (((((((this.partition.hashCode() * 31) + this.service.hashCode()) * 31) + this.region.hashCode()) * 31) + this.accountId.hashCode()) * 31) + this.resourceId.hashCode();
    }

    public String toString() {
        return "Arn(partition=" + this.partition + ", service=" + this.service + ", region=" + this.region + ", accountId=" + this.accountId + ", resourceId=" + this.resourceId + ')';
    }

    public Arn(String partition, String service, String region, String accountId, List<String> resourceId) {
        Intrinsics.checkNotNullParameter(partition, "partition");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(resourceId, "resourceId");
        this.partition = partition;
        this.service = service;
        this.region = region;
        this.accountId = accountId;
        this.resourceId = resourceId;
    }

    public final String getPartition() {
        return this.partition;
    }

    public final String getService() {
        return this.service;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final List<String> getResourceId() {
        return this.resourceId;
    }
}
