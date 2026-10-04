package aws.sdk.kotlin.services.p010s3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReplicationStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "Complete", "Completed", "Failed", "Pending", "Replica", "SdkUnknown", "Companion", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Complete;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Completed;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Failed;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Pending;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Replica;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus$SdkUnknown;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class ReplicationStatus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<ReplicationStatus> values = CollectionsKt.listOf((Object[]) new ReplicationStatus[]{Complete.INSTANCE, Completed.INSTANCE, Failed.INSTANCE, Pending.INSTANCE, Replica.INSTANCE});

    public /* synthetic */ ReplicationStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private ReplicationStatus() {
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Complete;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Complete extends ReplicationStatus {
        public static final Complete INSTANCE = new Complete();
        private static final String value = "COMPLETE";

        private Complete() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.ReplicationStatus
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Complete";
        }
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Completed;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Completed extends ReplicationStatus {
        public static final Completed INSTANCE = new Completed();
        private static final String value = "COMPLETED";

        private Completed() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.ReplicationStatus
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Completed";
        }
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Failed;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Failed extends ReplicationStatus {
        public static final Failed INSTANCE = new Failed();
        private static final String value = "FAILED";

        private Failed() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.ReplicationStatus
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Failed";
        }
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Pending;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Pending extends ReplicationStatus {
        public static final Pending INSTANCE = new Pending();
        private static final String value = "PENDING";

        private Pending() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.ReplicationStatus
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Pending";
        }
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Replica;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Replica extends ReplicationStatus {
        public static final Replica INSTANCE = new Replica();
        private static final String value = "REPLICA";

        private Replica() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.ReplicationStatus
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Replica";
        }
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends ReplicationStatus {
        private final String value;

        public static /* synthetic */ SdkUnknown copy$default(SdkUnknown sdkUnknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sdkUnknown.value;
            }
            return sdkUnknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final SdkUnknown copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SdkUnknown(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SdkUnknown) && Intrinsics.areEqual(this.value, ((SdkUnknown) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkUnknown(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.ReplicationStatus
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: ReplicationStatus.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationStatus$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/services/s3/model/ReplicationStatus;", "value", "", "values", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final ReplicationStatus fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case 35394935:
                    if (value.equals("PENDING")) {
                        return Pending.INSTANCE;
                    }
                    break;
                case 183181625:
                    if (value.equals("COMPLETE")) {
                        return Complete.INSTANCE;
                    }
                    break;
                case 1383663147:
                    if (value.equals("COMPLETED")) {
                        return Completed.INSTANCE;
                    }
                    break;
                case 1812487320:
                    if (value.equals("REPLICA")) {
                        return Replica.INSTANCE;
                    }
                    break;
                case 2066319421:
                    if (value.equals("FAILED")) {
                        return Failed.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<ReplicationStatus> values() {
            return ReplicationStatus.values;
        }
    }
}
