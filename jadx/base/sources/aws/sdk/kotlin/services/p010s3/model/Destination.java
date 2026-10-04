package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.AccessControlTranslation;
import aws.sdk.kotlin.services.p010s3.model.EncryptionConfiguration;
import aws.sdk.kotlin.services.p010s3.model.Metrics;
import aws.sdk.kotlin.services.p010s3.model.ReplicationTime;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Destination.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010 \u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010!\u001a\u00020\"H\u0096\u0080\u0004J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010&\u001a\u00020\u00002\u0019\b\u0002\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Destination;", "", "builder", "Laws/sdk/kotlin/services/s3/model/Destination$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Destination$Builder;)V", "accessControlTranslation", "Laws/sdk/kotlin/services/s3/model/AccessControlTranslation;", "getAccessControlTranslation", "()Laws/sdk/kotlin/services/s3/model/AccessControlTranslation;", "account", "", "getAccount", "()Ljava/lang/String;", "bucket", "getBucket", "encryptionConfiguration", "Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration;", "getEncryptionConfiguration", "()Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration;", "metrics", "Laws/sdk/kotlin/services/s3/model/Metrics;", "getMetrics", "()Laws/sdk/kotlin/services/s3/model/Metrics;", "replicationTime", "Laws/sdk/kotlin/services/s3/model/ReplicationTime;", "getReplicationTime", "()Laws/sdk/kotlin/services/s3/model/ReplicationTime;", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Destination {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AccessControlTranslation accessControlTranslation;
    private final String account;
    private final String bucket;
    private final EncryptionConfiguration encryptionConfiguration;
    private final Metrics metrics;
    private final ReplicationTime replicationTime;
    private final StorageClass storageClass;

    public /* synthetic */ Destination(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Destination(Builder builder) {
        this.accessControlTranslation = builder.getAccessControlTranslation();
        this.account = builder.getAccount();
        String bucket = builder.getBucket();
        if (bucket == null) {
            throw new IllegalArgumentException("A non-null value must be provided for bucket".toString());
        }
        this.bucket = bucket;
        this.encryptionConfiguration = builder.getEncryptionConfiguration();
        this.metrics = builder.getMetrics();
        this.replicationTime = builder.getReplicationTime();
        this.storageClass = builder.getStorageClass();
    }

    public final AccessControlTranslation getAccessControlTranslation() {
        return this.accessControlTranslation;
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final EncryptionConfiguration getEncryptionConfiguration() {
        return this.encryptionConfiguration;
    }

    public final Metrics getMetrics() {
        return this.metrics;
    }

    public final ReplicationTime getReplicationTime() {
        return this.replicationTime;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    /* JADX INFO: compiled from: Destination.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Destination$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/Destination;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Destination$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Destination invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Destination(");
        sb.append("accessControlTranslation=" + this.accessControlTranslation + AbstractJsonLexerKt.COMMA);
        sb.append("account=" + this.account + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("encryptionConfiguration=" + this.encryptionConfiguration + AbstractJsonLexerKt.COMMA);
        sb.append("metrics=" + this.metrics + AbstractJsonLexerKt.COMMA);
        sb.append("replicationTime=" + this.replicationTime + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AccessControlTranslation accessControlTranslation = this.accessControlTranslation;
        int iHashCode = (accessControlTranslation != null ? accessControlTranslation.hashCode() : 0) * 31;
        String str = this.account;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.bucket.hashCode()) * 31;
        EncryptionConfiguration encryptionConfiguration = this.encryptionConfiguration;
        int iHashCode3 = (iHashCode2 + (encryptionConfiguration != null ? encryptionConfiguration.hashCode() : 0)) * 31;
        Metrics metrics = this.metrics;
        int iHashCode4 = (iHashCode3 + (metrics != null ? metrics.hashCode() : 0)) * 31;
        ReplicationTime replicationTime = this.replicationTime;
        int iHashCode5 = (iHashCode4 + (replicationTime != null ? replicationTime.hashCode() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        return iHashCode5 + (storageClass != null ? storageClass.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Destination destination = (Destination) other;
        return Intrinsics.areEqual(this.accessControlTranslation, destination.accessControlTranslation) && Intrinsics.areEqual(this.account, destination.account) && Intrinsics.areEqual(this.bucket, destination.bucket) && Intrinsics.areEqual(this.encryptionConfiguration, destination.encryptionConfiguration) && Intrinsics.areEqual(this.metrics, destination.metrics) && Intrinsics.areEqual(this.replicationTime, destination.replicationTime) && Intrinsics.areEqual(this.storageClass, destination.storageClass);
    }

    public static /* synthetic */ Destination copy$default(Destination destination, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.Destination.copy.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(destination);
        block.invoke(builder);
        return builder.build();
    }

    public final Destination copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: Destination.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010.\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020/01¢\u0006\u0002\b3J\u001f\u0010\u0016\u001a\u00020/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020/01¢\u0006\u0002\b3J\u001f\u0010\u001c\u001a\u00020/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/01¢\u0006\u0002\b3J\u001f\u0010\"\u001a\u00020/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020/01¢\u0006\u0002\b3J\r\u00107\u001a\u00020\u0000H\u0000¢\u0006\u0002\b8R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00069"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Destination$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/Destination;", "(Laws/sdk/kotlin/services/s3/model/Destination;)V", "accessControlTranslation", "Laws/sdk/kotlin/services/s3/model/AccessControlTranslation;", "getAccessControlTranslation", "()Laws/sdk/kotlin/services/s3/model/AccessControlTranslation;", "setAccessControlTranslation", "(Laws/sdk/kotlin/services/s3/model/AccessControlTranslation;)V", "account", "", "getAccount", "()Ljava/lang/String;", "setAccount", "(Ljava/lang/String;)V", "bucket", "getBucket", "setBucket", "encryptionConfiguration", "Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration;", "getEncryptionConfiguration", "()Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration;", "setEncryptionConfiguration", "(Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration;)V", "metrics", "Laws/sdk/kotlin/services/s3/model/Metrics;", "getMetrics", "()Laws/sdk/kotlin/services/s3/model/Metrics;", "setMetrics", "(Laws/sdk/kotlin/services/s3/model/Metrics;)V", "replicationTime", "Laws/sdk/kotlin/services/s3/model/ReplicationTime;", "getReplicationTime", "()Laws/sdk/kotlin/services/s3/model/ReplicationTime;", "setReplicationTime", "(Laws/sdk/kotlin/services/s3/model/ReplicationTime;)V", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/AccessControlTranslation$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/EncryptionConfiguration$Builder;", "Laws/sdk/kotlin/services/s3/model/Metrics$Builder;", "Laws/sdk/kotlin/services/s3/model/ReplicationTime$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AccessControlTranslation accessControlTranslation;
        private String account;
        private String bucket;
        private EncryptionConfiguration encryptionConfiguration;
        private Metrics metrics;
        private ReplicationTime replicationTime;
        private StorageClass storageClass;

        public final AccessControlTranslation getAccessControlTranslation() {
            return this.accessControlTranslation;
        }

        public final void setAccessControlTranslation(AccessControlTranslation accessControlTranslation) {
            this.accessControlTranslation = accessControlTranslation;
        }

        public final String getAccount() {
            return this.account;
        }

        public final void setAccount(String str) {
            this.account = str;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final EncryptionConfiguration getEncryptionConfiguration() {
            return this.encryptionConfiguration;
        }

        public final void setEncryptionConfiguration(EncryptionConfiguration encryptionConfiguration) {
            this.encryptionConfiguration = encryptionConfiguration;
        }

        public final Metrics getMetrics() {
            return this.metrics;
        }

        public final void setMetrics(Metrics metrics) {
            this.metrics = metrics;
        }

        public final ReplicationTime getReplicationTime() {
            return this.replicationTime;
        }

        public final void setReplicationTime(ReplicationTime replicationTime) {
            this.replicationTime = replicationTime;
        }

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Destination x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessControlTranslation = x.getAccessControlTranslation();
            this.account = x.getAccount();
            this.bucket = x.getBucket();
            this.encryptionConfiguration = x.getEncryptionConfiguration();
            this.metrics = x.getMetrics();
            this.replicationTime = x.getReplicationTime();
            this.storageClass = x.getStorageClass();
        }

        public final Destination build() {
            return new Destination(this, null);
        }

        public final void accessControlTranslation(Function1<? super AccessControlTranslation.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.accessControlTranslation = DestinationKt.awsSdkKotlinServicesS3ModelAccessControlTranslationDslBuilderRef.invoke(block);
        }

        public final void encryptionConfiguration(Function1<? super EncryptionConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.encryptionConfiguration = DestinationKt.awsSdkKotlinServicesS3ModelEncryptionConfigurationDslBuilderRef.invoke(block);
        }

        public final void metrics(Function1<? super Metrics.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.metrics = DestinationKt.awsSdkKotlinServicesS3ModelMetricsDslBuilderRef.invoke(block);
        }

        public final void replicationTime(Function1<? super ReplicationTime.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.replicationTime = DestinationKt.awsSdkKotlinServicesS3ModelReplicationTimeDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.bucket == null) {
                this.bucket = "";
            }
            return this;
        }
    }
}
