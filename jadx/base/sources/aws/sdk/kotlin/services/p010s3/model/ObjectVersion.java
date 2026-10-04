package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Owner;
import aws.sdk.kotlin.services.p010s3.model.RestoreStatus;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ObjectVersion.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u00100\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u00101\u001a\u000202H\u0096\u0080\u0004J\u0014\u00103\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00105\u001a\u00020\u00002\u0019\b\u0002\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020807¢\u0006\u0002\b9H\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0013\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006<"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ObjectVersion;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ObjectVersion$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ObjectVersion$Builder;)V", "checksumAlgorithm", "", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Ljava/util/List;", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "eTag", "", "getETag", "()Ljava/lang/String;", "isLatest", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "restoreStatus", "Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "getRestoreStatus", "()Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "storageClass", "Laws/sdk/kotlin/services/s3/model/ObjectVersionStorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/ObjectVersionStorageClass;", "versionId", "getVersionId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ObjectVersion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ChecksumAlgorithm> checksumAlgorithm;
    private final ChecksumType checksumType;
    private final String eTag;
    private final Boolean isLatest;
    private final String key;
    private final Instant lastModified;
    private final Owner owner;
    private final RestoreStatus restoreStatus;
    private final Long size;
    private final ObjectVersionStorageClass storageClass;
    private final String versionId;

    public /* synthetic */ ObjectVersion(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ObjectVersion(Builder builder) {
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.checksumType = builder.getChecksumType();
        this.eTag = builder.getETag();
        this.isLatest = builder.getIsLatest();
        this.key = builder.getKey();
        this.lastModified = builder.getLastModified();
        this.owner = builder.getOwner();
        this.restoreStatus = builder.getRestoreStatus();
        this.size = builder.getSize();
        this.storageClass = builder.getStorageClass();
        this.versionId = builder.getVersionId();
    }

    public final List<ChecksumAlgorithm> getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final ChecksumType getChecksumType() {
        return this.checksumType;
    }

    public final String getETag() {
        return this.eTag;
    }

    /* JADX INFO: renamed from: isLatest, reason: from getter */
    public final Boolean getIsLatest() {
        return this.isLatest;
    }

    public final String getKey() {
        return this.key;
    }

    public final Instant getLastModified() {
        return this.lastModified;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final RestoreStatus getRestoreStatus() {
        return this.restoreStatus;
    }

    public final Long getSize() {
        return this.size;
    }

    public final ObjectVersionStorageClass getStorageClass() {
        return this.storageClass;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: ObjectVersion.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ObjectVersion$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ObjectVersion;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ObjectVersion$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ObjectVersion invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObjectVersion(");
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("eTag=" + this.eTag + AbstractJsonLexerKt.COMMA);
        sb.append("isLatest=" + this.isLatest + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("lastModified=" + this.lastModified + AbstractJsonLexerKt.COMMA);
        sb.append("owner=" + this.owner + AbstractJsonLexerKt.COMMA);
        sb.append("restoreStatus=" + this.restoreStatus + AbstractJsonLexerKt.COMMA);
        sb.append("size=" + this.size + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<ChecksumAlgorithm> list = this.checksumAlgorithm;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode2 = (iHashCode + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        String str = this.eTag;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.isLatest;
        int iHashCode4 = (iHashCode3 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.key;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Instant instant = this.lastModified;
        int iHashCode6 = (iHashCode5 + (instant != null ? instant.hashCode() : 0)) * 31;
        Owner owner = this.owner;
        int iHashCode7 = (iHashCode6 + (owner != null ? owner.hashCode() : 0)) * 31;
        RestoreStatus restoreStatus = this.restoreStatus;
        int iHashCode8 = (iHashCode7 + (restoreStatus != null ? restoreStatus.hashCode() : 0)) * 31;
        Long l = this.size;
        int iHashCode9 = (iHashCode8 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        ObjectVersionStorageClass objectVersionStorageClass = this.storageClass;
        int iHashCode10 = (iHashCode9 + (objectVersionStorageClass != null ? objectVersionStorageClass.hashCode() : 0)) * 31;
        String str3 = this.versionId;
        return iHashCode10 + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ObjectVersion objectVersion = (ObjectVersion) other;
        return Intrinsics.areEqual(this.checksumAlgorithm, objectVersion.checksumAlgorithm) && Intrinsics.areEqual(this.checksumType, objectVersion.checksumType) && Intrinsics.areEqual(this.eTag, objectVersion.eTag) && Intrinsics.areEqual(this.isLatest, objectVersion.isLatest) && Intrinsics.areEqual(this.key, objectVersion.key) && Intrinsics.areEqual(this.lastModified, objectVersion.lastModified) && Intrinsics.areEqual(this.owner, objectVersion.owner) && Intrinsics.areEqual(this.restoreStatus, objectVersion.restoreStatus) && Intrinsics.areEqual(this.size, objectVersion.size) && Intrinsics.areEqual(this.storageClass, objectVersion.storageClass) && Intrinsics.areEqual(this.versionId, objectVersion.versionId);
    }

    public static /* synthetic */ ObjectVersion copy$default(ObjectVersion objectVersion, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ObjectVersion.copy.1
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
        Builder builder = new Builder(objectVersion);
        block.invoke(builder);
        return builder.build();
    }

    public final ObjectVersion copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ObjectVersion.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010E\u001a\u00020\u0005H\u0001J\u001f\u0010)\u001a\u00020F2\u0017\u0010G\u001a\u0013\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020F0H¢\u0006\u0002\bJJ\u001f\u0010/\u001a\u00020F2\u0017\u0010G\u001a\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020F0H¢\u0006\u0002\bJJ\r\u0010L\u001a\u00020\u0000H\u0000¢\u0006\u0002\bMR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010\u0019¨\u0006N"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ObjectVersion$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ObjectVersion;", "(Laws/sdk/kotlin/services/s3/model/ObjectVersion;)V", "checksumAlgorithm", "", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Ljava/util/List;", "setChecksumAlgorithm", "(Ljava/util/List;)V", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", "eTag", "", "getETag", "()Ljava/lang/String;", "setETag", "(Ljava/lang/String;)V", "isLatest", "", "()Ljava/lang/Boolean;", "setLatest", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "setLastModified", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "setOwner", "(Laws/sdk/kotlin/services/s3/model/Owner;)V", "restoreStatus", "Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "getRestoreStatus", "()Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "setRestoreStatus", "(Laws/sdk/kotlin/services/s3/model/RestoreStatus;)V", "size", "", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "storageClass", "Laws/sdk/kotlin/services/s3/model/ObjectVersionStorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/ObjectVersionStorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/ObjectVersionStorageClass;)V", "versionId", "getVersionId", "setVersionId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Owner$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/RestoreStatus$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<? extends ChecksumAlgorithm> checksumAlgorithm;
        private ChecksumType checksumType;
        private String eTag;
        private Boolean isLatest;
        private String key;
        private Instant lastModified;
        private Owner owner;
        private RestoreStatus restoreStatus;
        private Long size;
        private ObjectVersionStorageClass storageClass;
        private String versionId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<ChecksumAlgorithm> getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(List<? extends ChecksumAlgorithm> list) {
            this.checksumAlgorithm = list;
        }

        public final ChecksumType getChecksumType() {
            return this.checksumType;
        }

        public final void setChecksumType(ChecksumType checksumType) {
            this.checksumType = checksumType;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final void setETag(String str) {
            this.eTag = str;
        }

        /* JADX INFO: renamed from: isLatest, reason: from getter */
        public final Boolean getIsLatest() {
            return this.isLatest;
        }

        public final void setLatest(Boolean bool) {
            this.isLatest = bool;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Instant getLastModified() {
            return this.lastModified;
        }

        public final void setLastModified(Instant instant) {
            this.lastModified = instant;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
        }

        public final RestoreStatus getRestoreStatus() {
            return this.restoreStatus;
        }

        public final void setRestoreStatus(RestoreStatus restoreStatus) {
            this.restoreStatus = restoreStatus;
        }

        public final Long getSize() {
            return this.size;
        }

        public final void setSize(Long l) {
            this.size = l;
        }

        public final ObjectVersionStorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(ObjectVersionStorageClass objectVersionStorageClass) {
            this.storageClass = objectVersionStorageClass;
        }

        public final String getVersionId() {
            return this.versionId;
        }

        public final void setVersionId(String str) {
            this.versionId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ObjectVersion x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.checksumType = x.getChecksumType();
            this.eTag = x.getETag();
            this.isLatest = x.getIsLatest();
            this.key = x.getKey();
            this.lastModified = x.getLastModified();
            this.owner = x.getOwner();
            this.restoreStatus = x.getRestoreStatus();
            this.size = x.getSize();
            this.storageClass = x.getStorageClass();
            this.versionId = x.getVersionId();
        }

        public final ObjectVersion build() {
            return new ObjectVersion(this, null);
        }

        public final void owner(Function1<? super Owner.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.owner = ObjectVersionKt.awsSdkKotlinServicesS3ModelOwnerDslBuilderRef.invoke(block);
        }

        public final void restoreStatus(Function1<? super RestoreStatus.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.restoreStatus = ObjectVersionKt.awsSdkKotlinServicesS3ModelRestoreStatusDslBuilderRef.invoke(block);
        }
    }
}
