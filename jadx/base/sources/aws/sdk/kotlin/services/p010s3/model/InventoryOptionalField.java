package aws.sdk.kotlin.services.p010s3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InventoryOptionalField.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00192\u00020\u0001:\u0012\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0011\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*¨\u0006+"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "BucketKeyStatus", "ChecksumAlgorithm", "ETag", "EncryptionStatus", "IntelligentTieringAccessTier", "IsMultipartUploaded", "LastModifiedDate", "LifecycleExpirationDate", "ObjectAccessControlList", "ObjectLockLegalHoldStatus", "ObjectLockMode", "ObjectLockRetainUntilDate", "ObjectOwner", "ReplicationStatus", "Size", "StorageClass", "SdkUnknown", "Companion", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$BucketKeyStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ChecksumAlgorithm;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ETag;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$EncryptionStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$IntelligentTieringAccessTier;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$IsMultipartUploaded;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$LastModifiedDate;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$LifecycleExpirationDate;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectAccessControlList;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectLockLegalHoldStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectLockMode;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectLockRetainUntilDate;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectOwner;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ReplicationStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$Size;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$StorageClass;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class InventoryOptionalField {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<InventoryOptionalField> values = CollectionsKt.listOf((Object[]) new InventoryOptionalField[]{BucketKeyStatus.INSTANCE, ChecksumAlgorithm.INSTANCE, ETag.INSTANCE, EncryptionStatus.INSTANCE, IntelligentTieringAccessTier.INSTANCE, IsMultipartUploaded.INSTANCE, LastModifiedDate.INSTANCE, LifecycleExpirationDate.INSTANCE, ObjectAccessControlList.INSTANCE, ObjectLockLegalHoldStatus.INSTANCE, ObjectLockMode.INSTANCE, ObjectLockRetainUntilDate.INSTANCE, ObjectOwner.INSTANCE, ReplicationStatus.INSTANCE, Size.INSTANCE, StorageClass.INSTANCE});

    public /* synthetic */ InventoryOptionalField(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private InventoryOptionalField() {
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$BucketKeyStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class BucketKeyStatus extends InventoryOptionalField {
        public static final BucketKeyStatus INSTANCE = new BucketKeyStatus();
        private static final String value = "BucketKeyStatus";

        private BucketKeyStatus() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "BucketKeyStatus";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ChecksumAlgorithm;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ChecksumAlgorithm extends InventoryOptionalField {
        public static final ChecksumAlgorithm INSTANCE = new ChecksumAlgorithm();
        private static final String value = "ChecksumAlgorithm";

        private ChecksumAlgorithm() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ChecksumAlgorithm";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ETag;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ETag extends InventoryOptionalField {
        public static final ETag INSTANCE = new ETag();
        private static final String value = "ETag";

        private ETag() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ETag";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$EncryptionStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class EncryptionStatus extends InventoryOptionalField {
        public static final EncryptionStatus INSTANCE = new EncryptionStatus();
        private static final String value = "EncryptionStatus";

        private EncryptionStatus() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "EncryptionStatus";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$IntelligentTieringAccessTier;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class IntelligentTieringAccessTier extends InventoryOptionalField {
        public static final IntelligentTieringAccessTier INSTANCE = new IntelligentTieringAccessTier();
        private static final String value = "IntelligentTieringAccessTier";

        private IntelligentTieringAccessTier() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "IntelligentTieringAccessTier";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$IsMultipartUploaded;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class IsMultipartUploaded extends InventoryOptionalField {
        public static final IsMultipartUploaded INSTANCE = new IsMultipartUploaded();
        private static final String value = "IsMultipartUploaded";

        private IsMultipartUploaded() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "IsMultipartUploaded";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$LastModifiedDate;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LastModifiedDate extends InventoryOptionalField {
        public static final LastModifiedDate INSTANCE = new LastModifiedDate();
        private static final String value = "LastModifiedDate";

        private LastModifiedDate() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "LastModifiedDate";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$LifecycleExpirationDate;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class LifecycleExpirationDate extends InventoryOptionalField {
        public static final LifecycleExpirationDate INSTANCE = new LifecycleExpirationDate();
        private static final String value = "LifecycleExpirationDate";

        private LifecycleExpirationDate() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "LifecycleExpirationDate";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectAccessControlList;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ObjectAccessControlList extends InventoryOptionalField {
        public static final ObjectAccessControlList INSTANCE = new ObjectAccessControlList();
        private static final String value = "ObjectAccessControlList";

        private ObjectAccessControlList() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ObjectAccessControlList";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectLockLegalHoldStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ObjectLockLegalHoldStatus extends InventoryOptionalField {
        public static final ObjectLockLegalHoldStatus INSTANCE = new ObjectLockLegalHoldStatus();
        private static final String value = "ObjectLockLegalHoldStatus";

        private ObjectLockLegalHoldStatus() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ObjectLockLegalHoldStatus";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectLockMode;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ObjectLockMode extends InventoryOptionalField {
        public static final ObjectLockMode INSTANCE = new ObjectLockMode();
        private static final String value = "ObjectLockMode";

        private ObjectLockMode() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ObjectLockMode";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectLockRetainUntilDate;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ObjectLockRetainUntilDate extends InventoryOptionalField {
        public static final ObjectLockRetainUntilDate INSTANCE = new ObjectLockRetainUntilDate();
        private static final String value = "ObjectLockRetainUntilDate";

        private ObjectLockRetainUntilDate() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ObjectLockRetainUntilDate";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ObjectOwner;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ObjectOwner extends InventoryOptionalField {
        public static final ObjectOwner INSTANCE = new ObjectOwner();
        private static final String value = "ObjectOwner";

        private ObjectOwner() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ObjectOwner";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$ReplicationStatus;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ReplicationStatus extends InventoryOptionalField {
        public static final ReplicationStatus INSTANCE = new ReplicationStatus();
        private static final String value = "ReplicationStatus";

        private ReplicationStatus() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ReplicationStatus";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$Size;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Size extends InventoryOptionalField {
        public static final Size INSTANCE = new Size();
        private static final String value = "Size";

        private Size() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "Size";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$StorageClass;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class StorageClass extends InventoryOptionalField {
        public static final StorageClass INSTANCE = new StorageClass();
        private static final String value = "StorageClass";

        private StorageClass() {
            super(null);
        }

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return value;
        }

        public String toString() {
            return "StorageClass";
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$SdkUnknown;", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends InventoryOptionalField {
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

        @Override // aws.sdk.kotlin.services.p010s3.model.InventoryOptionalField
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: InventoryOptionalField.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryOptionalField$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "value", "", "values", "", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final InventoryOptionalField fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -2118583618:
                    if (value.equals("ReplicationStatus")) {
                        return ReplicationStatus.INSTANCE;
                    }
                    break;
                case -2082980094:
                    if (value.equals("IsMultipartUploaded")) {
                        return IsMultipartUploaded.INSTANCE;
                    }
                    break;
                case -1713954443:
                    if (value.equals("EncryptionStatus")) {
                        return EncryptionStatus.INSTANCE;
                    }
                    break;
                case -1016825352:
                    if (value.equals("ObjectAccessControlList")) {
                        return ObjectAccessControlList.INSTANCE;
                    }
                    break;
                case 2139413:
                    if (value.equals("ETag")) {
                        return ETag.INSTANCE;
                    }
                    break;
                case 2577441:
                    if (value.equals("Size")) {
                        return Size.INSTANCE;
                    }
                    break;
                case 208734701:
                    if (value.equals("ObjectLockMode")) {
                        return ObjectLockMode.INSTANCE;
                    }
                    break;
                case 375994004:
                    if (value.equals("ObjectOwner")) {
                        return ObjectOwner.INSTANCE;
                    }
                    break;
                case 564561437:
                    if (value.equals("ObjectLockRetainUntilDate")) {
                        return ObjectLockRetainUntilDate.INSTANCE;
                    }
                    break;
                case 828559008:
                    if (value.equals("ObjectLockLegalHoldStatus")) {
                        return ObjectLockLegalHoldStatus.INSTANCE;
                    }
                    break;
                case 1004001967:
                    if (value.equals("IntelligentTieringAccessTier")) {
                        return IntelligentTieringAccessTier.INSTANCE;
                    }
                    break;
                case 1035673565:
                    if (value.equals("StorageClass")) {
                        return StorageClass.INSTANCE;
                    }
                    break;
                case 1179374412:
                    if (value.equals("ChecksumAlgorithm")) {
                        return ChecksumAlgorithm.INSTANCE;
                    }
                    break;
                case 1229188167:
                    if (value.equals("BucketKeyStatus")) {
                        return BucketKeyStatus.INSTANCE;
                    }
                    break;
                case 1911346157:
                    if (value.equals("LastModifiedDate")) {
                        return LastModifiedDate.INSTANCE;
                    }
                    break;
                case 2020280551:
                    if (value.equals("LifecycleExpirationDate")) {
                        return LifecycleExpirationDate.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<InventoryOptionalField> values() {
            return InventoryOptionalField.values;
        }
    }
}
