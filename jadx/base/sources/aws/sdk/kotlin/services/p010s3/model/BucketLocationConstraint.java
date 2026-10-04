package aws.sdk.kotlin.services.p010s3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BucketLocationConstraint.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 *2\u00020\u0001:#\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\"+,-./0123456789:;<=>?@ABCDEFGHIJKL¨\u0006M"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "Eu", "AfSouth1", "ApEast1", "ApNortheast1", "ApNortheast2", "ApNortheast3", "ApSouth1", "ApSouth2", "ApSoutheast1", "ApSoutheast2", "ApSoutheast3", "ApSoutheast4", "ApSoutheast5", "CaCentral1", "CnNorth1", "CnNorthwest1", "EuCentral1", "EuCentral2", "EuNorth1", "EuSouth1", "EuSouth2", "EuWest1", "EuWest2", "EuWest3", "IlCentral1", "MeCentral1", "MeSouth1", "SaEast1", "UsEast2", "UsGovEast1", "UsGovWest1", "UsWest1", "UsWest2", "SdkUnknown", "Companion", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$AfSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApEast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApNortheast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApNortheast2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApNortheast3;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSouth2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast3;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast4;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast5;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$CaCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$CnNorth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$CnNorthwest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$Eu;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuCentral2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuNorth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuSouth2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuWest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuWest2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuWest3;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$IlCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$MeCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$MeSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$SaEast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsEast2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsGovEast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsGovWest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsWest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsWest2;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class BucketLocationConstraint {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<BucketLocationConstraint> values = CollectionsKt.listOf((Object[]) new BucketLocationConstraint[]{C3160Eu.INSTANCE, AfSouth1.INSTANCE, ApEast1.INSTANCE, ApNortheast1.INSTANCE, ApNortheast2.INSTANCE, ApNortheast3.INSTANCE, ApSouth1.INSTANCE, ApSouth2.INSTANCE, ApSoutheast1.INSTANCE, ApSoutheast2.INSTANCE, ApSoutheast3.INSTANCE, ApSoutheast4.INSTANCE, ApSoutheast5.INSTANCE, CaCentral1.INSTANCE, CnNorth1.INSTANCE, CnNorthwest1.INSTANCE, EuCentral1.INSTANCE, EuCentral2.INSTANCE, EuNorth1.INSTANCE, EuSouth1.INSTANCE, EuSouth2.INSTANCE, EuWest1.INSTANCE, EuWest2.INSTANCE, EuWest3.INSTANCE, IlCentral1.INSTANCE, MeCentral1.INSTANCE, MeSouth1.INSTANCE, SaEast1.INSTANCE, UsEast2.INSTANCE, UsGovEast1.INSTANCE, UsGovWest1.INSTANCE, UsWest1.INSTANCE, UsWest2.INSTANCE});

    public /* synthetic */ BucketLocationConstraint(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private BucketLocationConstraint() {
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.model.BucketLocationConstraint$Eu */
    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$Eu;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C3160Eu extends BucketLocationConstraint {
        public static final C3160Eu INSTANCE = new C3160Eu();
        private static final String value = "EU";

        private C3160Eu() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Eu";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$AfSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class AfSouth1 extends BucketLocationConstraint {
        public static final AfSouth1 INSTANCE = new AfSouth1();
        private static final String value = "af-south-1";

        private AfSouth1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "AfSouth1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApEast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApEast1 extends BucketLocationConstraint {
        public static final ApEast1 INSTANCE = new ApEast1();
        private static final String value = "ap-east-1";

        private ApEast1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApEast1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApNortheast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApNortheast1 extends BucketLocationConstraint {
        public static final ApNortheast1 INSTANCE = new ApNortheast1();
        private static final String value = "ap-northeast-1";

        private ApNortheast1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApNortheast1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApNortheast2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApNortheast2 extends BucketLocationConstraint {
        public static final ApNortheast2 INSTANCE = new ApNortheast2();
        private static final String value = "ap-northeast-2";

        private ApNortheast2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApNortheast2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApNortheast3;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApNortheast3 extends BucketLocationConstraint {
        public static final ApNortheast3 INSTANCE = new ApNortheast3();
        private static final String value = "ap-northeast-3";

        private ApNortheast3() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApNortheast3";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSouth1 extends BucketLocationConstraint {
        public static final ApSouth1 INSTANCE = new ApSouth1();
        private static final String value = "ap-south-1";

        private ApSouth1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSouth1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSouth2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSouth2 extends BucketLocationConstraint {
        public static final ApSouth2 INSTANCE = new ApSouth2();
        private static final String value = "ap-south-2";

        private ApSouth2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSouth2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSoutheast1 extends BucketLocationConstraint {
        public static final ApSoutheast1 INSTANCE = new ApSoutheast1();
        private static final String value = "ap-southeast-1";

        private ApSoutheast1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSoutheast1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSoutheast2 extends BucketLocationConstraint {
        public static final ApSoutheast2 INSTANCE = new ApSoutheast2();
        private static final String value = "ap-southeast-2";

        private ApSoutheast2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSoutheast2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast3;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSoutheast3 extends BucketLocationConstraint {
        public static final ApSoutheast3 INSTANCE = new ApSoutheast3();
        private static final String value = "ap-southeast-3";

        private ApSoutheast3() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSoutheast3";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast4;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSoutheast4 extends BucketLocationConstraint {
        public static final ApSoutheast4 INSTANCE = new ApSoutheast4();
        private static final String value = "ap-southeast-4";

        private ApSoutheast4() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSoutheast4";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$ApSoutheast5;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ApSoutheast5 extends BucketLocationConstraint {
        public static final ApSoutheast5 INSTANCE = new ApSoutheast5();
        private static final String value = "ap-southeast-5";

        private ApSoutheast5() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ApSoutheast5";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$CaCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CaCentral1 extends BucketLocationConstraint {
        public static final CaCentral1 INSTANCE = new CaCentral1();
        private static final String value = "ca-central-1";

        private CaCentral1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "CaCentral1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$CnNorth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CnNorth1 extends BucketLocationConstraint {
        public static final CnNorth1 INSTANCE = new CnNorth1();
        private static final String value = "cn-north-1";

        private CnNorth1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "CnNorth1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$CnNorthwest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class CnNorthwest1 extends BucketLocationConstraint {
        public static final CnNorthwest1 INSTANCE = new CnNorthwest1();
        private static final String value = "cn-northwest-1";

        private CnNorthwest1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "CnNorthwest1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuCentral1 extends BucketLocationConstraint {
        public static final EuCentral1 INSTANCE = new EuCentral1();
        private static final String value = "eu-central-1";

        private EuCentral1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuCentral1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuCentral2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuCentral2 extends BucketLocationConstraint {
        public static final EuCentral2 INSTANCE = new EuCentral2();
        private static final String value = "eu-central-2";

        private EuCentral2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuCentral2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuNorth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuNorth1 extends BucketLocationConstraint {
        public static final EuNorth1 INSTANCE = new EuNorth1();
        private static final String value = "eu-north-1";

        private EuNorth1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuNorth1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuSouth1 extends BucketLocationConstraint {
        public static final EuSouth1 INSTANCE = new EuSouth1();
        private static final String value = "eu-south-1";

        private EuSouth1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuSouth1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuSouth2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuSouth2 extends BucketLocationConstraint {
        public static final EuSouth2 INSTANCE = new EuSouth2();
        private static final String value = "eu-south-2";

        private EuSouth2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuSouth2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuWest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuWest1 extends BucketLocationConstraint {
        public static final EuWest1 INSTANCE = new EuWest1();
        private static final String value = "eu-west-1";

        private EuWest1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuWest1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuWest2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuWest2 extends BucketLocationConstraint {
        public static final EuWest2 INSTANCE = new EuWest2();
        private static final String value = "eu-west-2";

        private EuWest2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuWest2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$EuWest3;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EuWest3 extends BucketLocationConstraint {
        public static final EuWest3 INSTANCE = new EuWest3();
        private static final String value = "eu-west-3";

        private EuWest3() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EuWest3";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$IlCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class IlCentral1 extends BucketLocationConstraint {
        public static final IlCentral1 INSTANCE = new IlCentral1();
        private static final String value = "il-central-1";

        private IlCentral1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "IlCentral1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$MeCentral1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class MeCentral1 extends BucketLocationConstraint {
        public static final MeCentral1 INSTANCE = new MeCentral1();
        private static final String value = "me-central-1";

        private MeCentral1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "MeCentral1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$MeSouth1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class MeSouth1 extends BucketLocationConstraint {
        public static final MeSouth1 INSTANCE = new MeSouth1();
        private static final String value = "me-south-1";

        private MeSouth1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "MeSouth1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$SaEast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class SaEast1 extends BucketLocationConstraint {
        public static final SaEast1 INSTANCE = new SaEast1();
        private static final String value = "sa-east-1";

        private SaEast1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "SaEast1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsEast2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UsEast2 extends BucketLocationConstraint {
        public static final UsEast2 INSTANCE = new UsEast2();
        private static final String value = "us-east-2";

        private UsEast2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "UsEast2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsGovEast1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UsGovEast1 extends BucketLocationConstraint {
        public static final UsGovEast1 INSTANCE = new UsGovEast1();
        private static final String value = "us-gov-east-1";

        private UsGovEast1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "UsGovEast1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsGovWest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UsGovWest1 extends BucketLocationConstraint {
        public static final UsGovWest1 INSTANCE = new UsGovWest1();
        private static final String value = "us-gov-west-1";

        private UsGovWest1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "UsGovWest1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsWest1;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UsWest1 extends BucketLocationConstraint {
        public static final UsWest1 INSTANCE = new UsWest1();
        private static final String value = "us-west-1";

        private UsWest1() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "UsWest1";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$UsWest2;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UsWest2 extends BucketLocationConstraint {
        public static final UsWest2 INSTANCE = new UsWest2();
        private static final String value = "us-west-2";

        private UsWest2() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return value;
        }

        public String toString() {
            return "UsWest2";
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends BucketLocationConstraint {
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

        @Override // aws.sdk.kotlin.services.p010s3.model.BucketLocationConstraint
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: BucketLocationConstraint.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/services/s3/model/BucketLocationConstraint;", "value", "", "values", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final BucketLocationConstraint fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -1967372894:
                    if (value.equals("us-west-1")) {
                        return UsWest1.INSTANCE;
                    }
                    break;
                case -1967372893:
                    if (value.equals("us-west-2")) {
                        return UsWest2.INSTANCE;
                    }
                    break;
                case -1630504513:
                    if (value.equals("ap-east-1")) {
                        return ApEast1.INSTANCE;
                    }
                    break;
                case -1025341009:
                    if (value.equals("il-central-1")) {
                        return IlCentral1.INSTANCE;
                    }
                    break;
                case -815252508:
                    if (value.equals("me-central-1")) {
                        return MeCentral1.INSTANCE;
                    }
                    break;
                case -534364932:
                    if (value.equals("eu-central-1")) {
                        return EuCentral1.INSTANCE;
                    }
                    break;
                case -534364931:
                    if (value.equals("eu-central-2")) {
                        return EuCentral2.INSTANCE;
                    }
                    break;
                case -441884340:
                    if (value.equals("eu-north-1")) {
                        return EuNorth1.INSTANCE;
                    }
                    break;
                case -296562668:
                    if (value.equals("eu-south-1")) {
                        return EuSouth1.INSTANCE;
                    }
                    break;
                case -296562667:
                    if (value.equals("eu-south-2")) {
                        return EuSouth2.INSTANCE;
                    }
                    break;
                case -281577977:
                    if (value.equals("cn-north-1")) {
                        return CnNorth1.INSTANCE;
                    }
                    break;
                case -177297728:
                    if (value.equals("sa-east-1")) {
                        return SaEast1.INSTANCE;
                    }
                    break;
                case 2224:
                    if (value.equals("EU")) {
                        return C3160Eu.INSTANCE;
                    }
                    break;
                case 372748112:
                    if (value.equals("eu-west-1")) {
                        return EuWest1.INSTANCE;
                    }
                    break;
                case 372748113:
                    if (value.equals("eu-west-2")) {
                        return EuWest2.INSTANCE;
                    }
                    break;
                case 372748114:
                    if (value.equals("eu-west-3")) {
                        return EuWest3.INSTANCE;
                    }
                    break;
                case 373607183:
                    if (value.equals("us-gov-east-1")) {
                        return UsGovEast1.INSTANCE;
                    }
                    break;
                case 468199888:
                    if (value.equals("ap-southeast-1")) {
                        return ApSoutheast1.INSTANCE;
                    }
                    break;
                case 468199889:
                    if (value.equals("ap-southeast-2")) {
                        return ApSoutheast2.INSTANCE;
                    }
                    break;
                case 468199890:
                    if (value.equals("ap-southeast-3")) {
                        return ApSoutheast3.INSTANCE;
                    }
                    break;
                case 468199891:
                    if (value.equals("ap-southeast-4")) {
                        return ApSoutheast4.INSTANCE;
                    }
                    break;
                case 468199892:
                    if (value.equals("ap-southeast-5")) {
                        return ApSoutheast5.INSTANCE;
                    }
                    break;
                case 786758442:
                    if (value.equals("ca-central-1")) {
                        return CaCentral1.INSTANCE;
                    }
                    break;
                case 892625985:
                    if (value.equals("us-gov-west-1")) {
                        return UsGovWest1.INSTANCE;
                    }
                    break;
                case 936829075:
                    if (value.equals("ap-south-1")) {
                        return ApSouth1.INSTANCE;
                    }
                    break;
                case 936829076:
                    if (value.equals("ap-south-2")) {
                        return ApSouth2.INSTANCE;
                    }
                    break;
                case 1280796924:
                    if (value.equals("me-south-1")) {
                        return MeSouth1.INSTANCE;
                    }
                    break;
                case 1808575601:
                    if (value.equals("us-east-2")) {
                        return UsEast2.INSTANCE;
                    }
                    break;
                case 1831504521:
                    if (value.equals("af-south-1")) {
                        return AfSouth1.INSTANCE;
                    }
                    break;
                case 1990418184:
                    if (value.equals("ap-northeast-1")) {
                        return ApNortheast1.INSTANCE;
                    }
                    break;
                case 1990418185:
                    if (value.equals("ap-northeast-2")) {
                        return ApNortheast2.INSTANCE;
                    }
                    break;
                case 1990418186:
                    if (value.equals("ap-northeast-3")) {
                        return ApNortheast3.INSTANCE;
                    }
                    break;
                case 2085125750:
                    if (value.equals("cn-northwest-1")) {
                        return CnNorthwest1.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<BucketLocationConstraint> values() {
            return BucketLocationConstraint.values;
        }
    }
}
