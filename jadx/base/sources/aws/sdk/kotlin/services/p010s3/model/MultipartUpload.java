package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Initiator;
import aws.sdk.kotlin.services.p010s3.model.Owner;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MultipartUpload.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010$\u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010%\u001a\u00020&H\u0096\u0080\u0004J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010*\u001a\u00020\u00002\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-0,¢\u0006\u0002\b.H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/MultipartUpload;", "", "builder", "Laws/sdk/kotlin/services/s3/model/MultipartUpload$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/MultipartUpload$Builder;)V", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "initiated", "Laws/smithy/kotlin/runtime/time/Instant;", "getInitiated", "()Laws/smithy/kotlin/runtime/time/Instant;", "initiator", "Laws/sdk/kotlin/services/s3/model/Initiator;", "getInitiator", "()Laws/sdk/kotlin/services/s3/model/Initiator;", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "uploadId", "getUploadId", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MultipartUpload {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ChecksumAlgorithm checksumAlgorithm;
    private final ChecksumType checksumType;
    private final Instant initiated;
    private final Initiator initiator;
    private final String key;
    private final Owner owner;
    private final StorageClass storageClass;
    private final String uploadId;

    public /* synthetic */ MultipartUpload(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private MultipartUpload(Builder builder) {
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.checksumType = builder.getChecksumType();
        this.initiated = builder.getInitiated();
        this.initiator = builder.getInitiator();
        this.key = builder.getKey();
        this.owner = builder.getOwner();
        this.storageClass = builder.getStorageClass();
        this.uploadId = builder.getUploadId();
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final ChecksumType getChecksumType() {
        return this.checksumType;
    }

    public final Instant getInitiated() {
        return this.initiated;
    }

    public final Initiator getInitiator() {
        return this.initiator;
    }

    public final String getKey() {
        return this.key;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    /* JADX INFO: compiled from: MultipartUpload.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/MultipartUpload$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/MultipartUpload;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/MultipartUpload$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MultipartUpload invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MultipartUpload(");
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("initiated=" + this.initiated + AbstractJsonLexerKt.COMMA);
        sb.append("initiator=" + this.initiator + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("owner=" + this.owner + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("uploadId=" + this.uploadId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode = (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode2 = (iHashCode + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        Instant instant = this.initiated;
        int iHashCode3 = (iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        Initiator initiator = this.initiator;
        int iHashCode4 = (iHashCode3 + (initiator != null ? initiator.hashCode() : 0)) * 31;
        String str = this.key;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        Owner owner = this.owner;
        int iHashCode6 = (iHashCode5 + (owner != null ? owner.hashCode() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode7 = (iHashCode6 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        String str2 = this.uploadId;
        return iHashCode7 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        MultipartUpload multipartUpload = (MultipartUpload) other;
        return Intrinsics.areEqual(this.checksumAlgorithm, multipartUpload.checksumAlgorithm) && Intrinsics.areEqual(this.checksumType, multipartUpload.checksumType) && Intrinsics.areEqual(this.initiated, multipartUpload.initiated) && Intrinsics.areEqual(this.initiator, multipartUpload.initiator) && Intrinsics.areEqual(this.key, multipartUpload.key) && Intrinsics.areEqual(this.owner, multipartUpload.owner) && Intrinsics.areEqual(this.storageClass, multipartUpload.storageClass) && Intrinsics.areEqual(this.uploadId, multipartUpload.uploadId);
    }

    public static /* synthetic */ MultipartUpload copy$default(MultipartUpload multipartUpload, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.MultipartUpload.copy.1
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
        Builder builder = new Builder(multipartUpload);
        block.invoke(builder);
        return builder.build();
    }

    public final MultipartUpload copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: MultipartUpload.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00104\u001a\u00020\u0005H\u0001J\u001f\u0010\u0019\u001a\u0002052\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020507¢\u0006\u0002\b9J\u001f\u0010%\u001a\u0002052\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020507¢\u0006\u0002\b9J\r\u0010;\u001a\u00020\u0000H\u0000¢\u0006\u0002\b<R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$¨\u0006="}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/MultipartUpload$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/MultipartUpload;", "(Laws/sdk/kotlin/services/s3/model/MultipartUpload;)V", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", "initiated", "Laws/smithy/kotlin/runtime/time/Instant;", "getInitiated", "()Laws/smithy/kotlin/runtime/time/Instant;", "setInitiated", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "initiator", "Laws/sdk/kotlin/services/s3/model/Initiator;", "getInitiator", "()Laws/sdk/kotlin/services/s3/model/Initiator;", "setInitiator", "(Laws/sdk/kotlin/services/s3/model/Initiator;)V", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "setOwner", "(Laws/sdk/kotlin/services/s3/model/Owner;)V", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "uploadId", "getUploadId", "setUploadId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Initiator$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/Owner$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ChecksumAlgorithm checksumAlgorithm;
        private ChecksumType checksumType;
        private Instant initiated;
        private Initiator initiator;
        private String key;
        private Owner owner;
        private StorageClass storageClass;
        private String uploadId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final ChecksumAlgorithm getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        public final ChecksumType getChecksumType() {
            return this.checksumType;
        }

        public final void setChecksumType(ChecksumType checksumType) {
            this.checksumType = checksumType;
        }

        public final Instant getInitiated() {
            return this.initiated;
        }

        public final void setInitiated(Instant instant) {
            this.initiated = instant;
        }

        public final Initiator getInitiator() {
            return this.initiator;
        }

        public final void setInitiator(Initiator initiator) {
            this.initiator = initiator;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
        }

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
        }

        public final String getUploadId() {
            return this.uploadId;
        }

        public final void setUploadId(String str) {
            this.uploadId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(MultipartUpload x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.checksumType = x.getChecksumType();
            this.initiated = x.getInitiated();
            this.initiator = x.getInitiator();
            this.key = x.getKey();
            this.owner = x.getOwner();
            this.storageClass = x.getStorageClass();
            this.uploadId = x.getUploadId();
        }

        public final MultipartUpload build() {
            return new MultipartUpload(this, null);
        }

        public final void initiator(Function1<? super Initiator.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.initiator = MultipartUploadKt.awsSdkKotlinServicesS3ModelInitiatorDslBuilderRef.invoke(block);
        }

        public final void owner(Function1<? super Owner.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.owner = MultipartUploadKt.awsSdkKotlinServicesS3ModelOwnerDslBuilderRef.invoke(block);
        }
    }
}
