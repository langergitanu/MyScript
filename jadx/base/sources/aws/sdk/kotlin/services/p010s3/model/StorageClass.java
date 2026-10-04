package aws.sdk.kotlin.services.p010s3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StorageClass.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00162\u00020\u0001:\u000f\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u000e\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "DeepArchive", "ExpressOnezone", "FsxOntap", "FsxOpenzfs", "Glacier", "GlacierIr", "IntelligentTiering", "OnezoneIa", "Outposts", "ReducedRedundancy", "Snow", "Standard", "StandardIa", "SdkUnknown", "Companion", "Laws/sdk/kotlin/services/s3/model/StorageClass$DeepArchive;", "Laws/sdk/kotlin/services/s3/model/StorageClass$ExpressOnezone;", "Laws/sdk/kotlin/services/s3/model/StorageClass$FsxOntap;", "Laws/sdk/kotlin/services/s3/model/StorageClass$FsxOpenzfs;", "Laws/sdk/kotlin/services/s3/model/StorageClass$Glacier;", "Laws/sdk/kotlin/services/s3/model/StorageClass$GlacierIr;", "Laws/sdk/kotlin/services/s3/model/StorageClass$IntelligentTiering;", "Laws/sdk/kotlin/services/s3/model/StorageClass$OnezoneIa;", "Laws/sdk/kotlin/services/s3/model/StorageClass$Outposts;", "Laws/sdk/kotlin/services/s3/model/StorageClass$ReducedRedundancy;", "Laws/sdk/kotlin/services/s3/model/StorageClass$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/StorageClass$Snow;", "Laws/sdk/kotlin/services/s3/model/StorageClass$Standard;", "Laws/sdk/kotlin/services/s3/model/StorageClass$StandardIa;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class StorageClass {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<StorageClass> values = CollectionsKt.listOf((Object[]) new StorageClass[]{DeepArchive.INSTANCE, ExpressOnezone.INSTANCE, FsxOntap.INSTANCE, FsxOpenzfs.INSTANCE, Glacier.INSTANCE, GlacierIr.INSTANCE, IntelligentTiering.INSTANCE, OnezoneIa.INSTANCE, Outposts.INSTANCE, ReducedRedundancy.INSTANCE, Snow.INSTANCE, Standard.INSTANCE, StandardIa.INSTANCE});

    public /* synthetic */ StorageClass(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private StorageClass() {
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$DeepArchive;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DeepArchive extends StorageClass {
        public static final DeepArchive INSTANCE = new DeepArchive();
        private static final String value = "DEEP_ARCHIVE";

        private DeepArchive() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "DeepArchive";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$ExpressOnezone;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ExpressOnezone extends StorageClass {
        public static final ExpressOnezone INSTANCE = new ExpressOnezone();
        private static final String value = "EXPRESS_ONEZONE";

        private ExpressOnezone() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ExpressOnezone";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$FsxOntap;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class FsxOntap extends StorageClass {
        public static final FsxOntap INSTANCE = new FsxOntap();
        private static final String value = "FSX_ONTAP";

        private FsxOntap() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "FsxOntap";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$FsxOpenzfs;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class FsxOpenzfs extends StorageClass {
        public static final FsxOpenzfs INSTANCE = new FsxOpenzfs();
        private static final String value = "FSX_OPENZFS";

        private FsxOpenzfs() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "FsxOpenzfs";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$Glacier;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Glacier extends StorageClass {
        public static final Glacier INSTANCE = new Glacier();
        private static final String value = "GLACIER";

        private Glacier() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Glacier";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$GlacierIr;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class GlacierIr extends StorageClass {
        public static final GlacierIr INSTANCE = new GlacierIr();
        private static final String value = "GLACIER_IR";

        private GlacierIr() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "GlacierIr";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$IntelligentTiering;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class IntelligentTiering extends StorageClass {
        public static final IntelligentTiering INSTANCE = new IntelligentTiering();
        private static final String value = "INTELLIGENT_TIERING";

        private IntelligentTiering() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "IntelligentTiering";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$OnezoneIa;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class OnezoneIa extends StorageClass {
        public static final OnezoneIa INSTANCE = new OnezoneIa();
        private static final String value = "ONEZONE_IA";

        private OnezoneIa() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "OnezoneIa";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$Outposts;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Outposts extends StorageClass {
        public static final Outposts INSTANCE = new Outposts();
        private static final String value = "OUTPOSTS";

        private Outposts() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Outposts";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$ReducedRedundancy;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ReducedRedundancy extends StorageClass {
        public static final ReducedRedundancy INSTANCE = new ReducedRedundancy();
        private static final String value = "REDUCED_REDUNDANCY";

        private ReducedRedundancy() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ReducedRedundancy";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$Snow;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Snow extends StorageClass {
        public static final Snow INSTANCE = new Snow();
        private static final String value = "SNOW";

        private Snow() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Snow";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$Standard;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Standard extends StorageClass {
        public static final Standard INSTANCE = new Standard();
        private static final String value = "STANDARD";

        private Standard() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Standard";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$StandardIa;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StandardIa extends StorageClass {
        public static final StandardIa INSTANCE = new StandardIa();
        private static final String value = "STANDARD_IA";

        private StandardIa() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return value;
        }

        public String toString() {
            return "StandardIa";
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends StorageClass {
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

        @Override // aws.sdk.kotlin.services.p010s3.model.StorageClass
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: StorageClass.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/StorageClass$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "value", "", "values", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final StorageClass fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -1400230653:
                    if (value.equals("EXPRESS_ONEZONE")) {
                        return ExpressOnezone.INSTANCE;
                    }
                    break;
                case -1285524091:
                    if (value.equals("ONEZONE_IA")) {
                        return OnezoneIa.INSTANCE;
                    }
                    break;
                case -456762289:
                    if (value.equals("DEEP_ARCHIVE")) {
                        return DeepArchive.INSTANCE;
                    }
                    break;
                case 2550147:
                    if (value.equals("SNOW")) {
                        return Snow.INSTANCE;
                    }
                    break;
                case 242655536:
                    if (value.equals("FSX_ONTAP")) {
                        return FsxOntap.INSTANCE;
                    }
                    break;
                case 246938206:
                    if (value.equals("REDUCED_REDUNDANCY")) {
                        return ReducedRedundancy.INSTANCE;
                    }
                    break;
                case 826164623:
                    if (value.equals("GLACIER")) {
                        return Glacier.INSTANCE;
                    }
                    break;
                case 852630853:
                    if (value.equals("OUTPOSTS")) {
                        return Outposts.INSTANCE;
                    }
                    break;
                case 988907994:
                    if (value.equals("STANDARD_IA")) {
                        return StandardIa.INSTANCE;
                    }
                    break;
                case 1305227448:
                    if (value.equals("INTELLIGENT_TIERING")) {
                        return IntelligentTiering.INSTANCE;
                    }
                    break;
                case 1307540745:
                    if (value.equals("FSX_OPENZFS")) {
                        return FsxOpenzfs.INSTANCE;
                    }
                    break;
                case 2095255229:
                    if (value.equals("STANDARD")) {
                        return Standard.INSTANCE;
                    }
                    break;
                case 2107771353:
                    if (value.equals("GLACIER_IR")) {
                        return GlacierIr.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<StorageClass> values() {
            return StorageClass.values;
        }
    }
}
