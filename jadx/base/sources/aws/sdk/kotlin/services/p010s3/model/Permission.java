package aws.sdk.kotlin.services.p010s3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Permission.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "FullControl", "Read", "ReadAcp", "Write", "WriteAcp", "SdkUnknown", "Companion", "Laws/sdk/kotlin/services/s3/model/Permission$FullControl;", "Laws/sdk/kotlin/services/s3/model/Permission$Read;", "Laws/sdk/kotlin/services/s3/model/Permission$ReadAcp;", "Laws/sdk/kotlin/services/s3/model/Permission$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/Permission$Write;", "Laws/sdk/kotlin/services/s3/model/Permission$WriteAcp;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class Permission {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Permission> values = CollectionsKt.listOf((Object[]) new Permission[]{FullControl.INSTANCE, Read.INSTANCE, ReadAcp.INSTANCE, Write.INSTANCE, WriteAcp.INSTANCE});

    public /* synthetic */ Permission(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private Permission() {
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$FullControl;", "Laws/sdk/kotlin/services/s3/model/Permission;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class FullControl extends Permission {
        public static final FullControl INSTANCE = new FullControl();
        private static final String value = "FULL_CONTROL";

        private FullControl() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Permission
        public String getValue() {
            return value;
        }

        public String toString() {
            return "FullControl";
        }
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$Read;", "Laws/sdk/kotlin/services/s3/model/Permission;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Read extends Permission {
        public static final Read INSTANCE = new Read();
        private static final String value = "READ";

        private Read() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Permission
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Read";
        }
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$ReadAcp;", "Laws/sdk/kotlin/services/s3/model/Permission;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ReadAcp extends Permission {
        public static final ReadAcp INSTANCE = new ReadAcp();
        private static final String value = "READ_ACP";

        private ReadAcp() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Permission
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ReadAcp";
        }
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$Write;", "Laws/sdk/kotlin/services/s3/model/Permission;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Write extends Permission {
        public static final Write INSTANCE = new Write();
        private static final String value = "WRITE";

        private Write() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Permission
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Write";
        }
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$WriteAcp;", "Laws/sdk/kotlin/services/s3/model/Permission;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class WriteAcp extends Permission {
        public static final WriteAcp INSTANCE = new WriteAcp();
        private static final String value = "WRITE_ACP";

        private WriteAcp() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.Permission
        public String getValue() {
            return value;
        }

        public String toString() {
            return "WriteAcp";
        }
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/Permission;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends Permission {
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

        @Override // aws.sdk.kotlin.services.p010s3.model.Permission
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: Permission.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Permission$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/services/s3/model/Permission;", "value", "", "values", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Permission fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -83639739:
                    if (value.equals("READ_ACP")) {
                        return ReadAcp.INSTANCE;
                    }
                    break;
                case 2511254:
                    if (value.equals("READ")) {
                        return Read.INSTANCE;
                    }
                    break;
                case 78885773:
                    if (value.equals("FULL_CONTROL")) {
                        return FullControl.INSTANCE;
                    }
                    break;
                case 82862015:
                    if (value.equals("WRITE")) {
                        return Write.INSTANCE;
                    }
                    break;
                case 1381536750:
                    if (value.equals("WRITE_ACP")) {
                        return WriteAcp.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<Permission> values() {
            return Permission.values;
        }
    }
}
