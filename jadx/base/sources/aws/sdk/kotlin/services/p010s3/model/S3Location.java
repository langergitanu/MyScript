package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Encryption;
import aws.sdk.kotlin.services.p010s3.model.Tagging;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: S3Location.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010$\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010%\u001a\u00020&H\u0096\u0080\u0004J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010*\u001a\u00020\u00002\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-0,¢\u0006\u0002\b.H\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3Location;", "", "builder", "Laws/sdk/kotlin/services/s3/model/S3Location$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/S3Location$Builder;)V", "accessControlList", "", "Laws/sdk/kotlin/services/s3/model/Grant;", "getAccessControlList", "()Ljava/util/List;", "bucketName", "", "getBucketName", "()Ljava/lang/String;", "cannedAcl", "Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "getCannedAcl", "()Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "encryption", "Laws/sdk/kotlin/services/s3/model/Encryption;", "getEncryption", "()Laws/sdk/kotlin/services/s3/model/Encryption;", "prefix", "getPrefix", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "tagging", "Laws/sdk/kotlin/services/s3/model/Tagging;", "getTagging", "()Laws/sdk/kotlin/services/s3/model/Tagging;", "userMetadata", "Laws/sdk/kotlin/services/s3/model/MetadataEntry;", "getUserMetadata", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3Location {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Grant> accessControlList;
    private final String bucketName;
    private final ObjectCannedAcl cannedAcl;
    private final Encryption encryption;
    private final String prefix;
    private final StorageClass storageClass;
    private final Tagging tagging;
    private final List<MetadataEntry> userMetadata;

    public /* synthetic */ S3Location(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private S3Location(Builder builder) {
        this.accessControlList = builder.getAccessControlList();
        String bucketName = builder.getBucketName();
        if (bucketName == null) {
            throw new IllegalArgumentException("A non-null value must be provided for bucketName".toString());
        }
        this.bucketName = bucketName;
        this.cannedAcl = builder.getCannedAcl();
        this.encryption = builder.getEncryption();
        String prefix = builder.getPrefix();
        if (prefix == null) {
            throw new IllegalArgumentException("A non-null value must be provided for prefix".toString());
        }
        this.prefix = prefix;
        this.storageClass = builder.getStorageClass();
        this.tagging = builder.getTagging();
        this.userMetadata = builder.getUserMetadata();
    }

    public final List<Grant> getAccessControlList() {
        return this.accessControlList;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public final ObjectCannedAcl getCannedAcl() {
        return this.cannedAcl;
    }

    public final Encryption getEncryption() {
        return this.encryption;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    public final Tagging getTagging() {
        return this.tagging;
    }

    public final List<MetadataEntry> getUserMetadata() {
        return this.userMetadata;
    }

    /* JADX INFO: compiled from: S3Location.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3Location$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/S3Location;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/S3Location$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final S3Location invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("S3Location(");
        sb.append("accessControlList=" + this.accessControlList + AbstractJsonLexerKt.COMMA);
        sb.append("bucketName=" + this.bucketName + AbstractJsonLexerKt.COMMA);
        sb.append("cannedAcl=" + this.cannedAcl + AbstractJsonLexerKt.COMMA);
        sb.append("encryption=" + this.encryption + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("tagging=" + this.tagging + AbstractJsonLexerKt.COMMA);
        sb.append("userMetadata=" + this.userMetadata);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<Grant> list = this.accessControlList;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.bucketName.hashCode()) * 31;
        ObjectCannedAcl objectCannedAcl = this.cannedAcl;
        int iHashCode2 = (iHashCode + (objectCannedAcl != null ? objectCannedAcl.hashCode() : 0)) * 31;
        Encryption encryption = this.encryption;
        int iHashCode3 = (((iHashCode2 + (encryption != null ? encryption.hashCode() : 0)) * 31) + this.prefix.hashCode()) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode4 = (iHashCode3 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        Tagging tagging = this.tagging;
        int iHashCode5 = (iHashCode4 + (tagging != null ? tagging.hashCode() : 0)) * 31;
        List<MetadataEntry> list2 = this.userMetadata;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        S3Location s3Location = (S3Location) other;
        return Intrinsics.areEqual(this.accessControlList, s3Location.accessControlList) && Intrinsics.areEqual(this.bucketName, s3Location.bucketName) && Intrinsics.areEqual(this.cannedAcl, s3Location.cannedAcl) && Intrinsics.areEqual(this.encryption, s3Location.encryption) && Intrinsics.areEqual(this.prefix, s3Location.prefix) && Intrinsics.areEqual(this.storageClass, s3Location.storageClass) && Intrinsics.areEqual(this.tagging, s3Location.tagging) && Intrinsics.areEqual(this.userMetadata, s3Location.userMetadata);
    }

    public static /* synthetic */ S3Location copy$default(S3Location s3Location, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.S3Location.copy.1
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
        Builder builder = new Builder(s3Location);
        block.invoke(builder);
        return builder.build();
    }

    public final S3Location copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: S3Location.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00103\u001a\u00020\u0005H\u0001J\u001f\u0010\u001a\u001a\u0002042\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020406¢\u0006\u0002\b8J\u001f\u0010)\u001a\u0002042\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020406¢\u0006\u0002\b8J\r\u0010:\u001a\u00020\u0000H\u0000¢\u0006\u0002\b;R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\r¨\u0006<"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3Location$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/S3Location;", "(Laws/sdk/kotlin/services/s3/model/S3Location;)V", "accessControlList", "", "Laws/sdk/kotlin/services/s3/model/Grant;", "getAccessControlList", "()Ljava/util/List;", "setAccessControlList", "(Ljava/util/List;)V", "bucketName", "", "getBucketName", "()Ljava/lang/String;", "setBucketName", "(Ljava/lang/String;)V", "cannedAcl", "Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "getCannedAcl", "()Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;", "setCannedAcl", "(Laws/sdk/kotlin/services/s3/model/ObjectCannedAcl;)V", "encryption", "Laws/sdk/kotlin/services/s3/model/Encryption;", "getEncryption", "()Laws/sdk/kotlin/services/s3/model/Encryption;", "setEncryption", "(Laws/sdk/kotlin/services/s3/model/Encryption;)V", "prefix", "getPrefix", "setPrefix", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "tagging", "Laws/sdk/kotlin/services/s3/model/Tagging;", "getTagging", "()Laws/sdk/kotlin/services/s3/model/Tagging;", "setTagging", "(Laws/sdk/kotlin/services/s3/model/Tagging;)V", "userMetadata", "Laws/sdk/kotlin/services/s3/model/MetadataEntry;", "getUserMetadata", "setUserMetadata", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Encryption$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/Tagging$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<Grant> accessControlList;
        private String bucketName;
        private ObjectCannedAcl cannedAcl;
        private Encryption encryption;
        private String prefix;
        private StorageClass storageClass;
        private Tagging tagging;
        private List<MetadataEntry> userMetadata;

        public final List<Grant> getAccessControlList() {
            return this.accessControlList;
        }

        public final void setAccessControlList(List<Grant> list) {
            this.accessControlList = list;
        }

        public final String getBucketName() {
            return this.bucketName;
        }

        public final void setBucketName(String str) {
            this.bucketName = str;
        }

        public final ObjectCannedAcl getCannedAcl() {
            return this.cannedAcl;
        }

        public final void setCannedAcl(ObjectCannedAcl objectCannedAcl) {
            this.cannedAcl = objectCannedAcl;
        }

        public final Encryption getEncryption() {
            return this.encryption;
        }

        public final void setEncryption(Encryption encryption) {
            this.encryption = encryption;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
        }

        public final Tagging getTagging() {
            return this.tagging;
        }

        public final void setTagging(Tagging tagging) {
            this.tagging = tagging;
        }

        public final List<MetadataEntry> getUserMetadata() {
            return this.userMetadata;
        }

        public final void setUserMetadata(List<MetadataEntry> list) {
            this.userMetadata = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(S3Location x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessControlList = x.getAccessControlList();
            this.bucketName = x.getBucketName();
            this.cannedAcl = x.getCannedAcl();
            this.encryption = x.getEncryption();
            this.prefix = x.getPrefix();
            this.storageClass = x.getStorageClass();
            this.tagging = x.getTagging();
            this.userMetadata = x.getUserMetadata();
        }

        public final S3Location build() {
            return new S3Location(this, null);
        }

        public final void encryption(Function1<? super Encryption.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.encryption = S3LocationKt.awsSdkKotlinServicesS3ModelEncryptionDslBuilderRef.invoke(block);
        }

        public final void tagging(Function1<? super Tagging.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.tagging = S3LocationKt.awsSdkKotlinServicesS3ModelTaggingDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.bucketName == null) {
                this.bucketName = "";
            }
            if (this.prefix == null) {
                this.prefix = "";
            }
            return this;
        }
    }
}
