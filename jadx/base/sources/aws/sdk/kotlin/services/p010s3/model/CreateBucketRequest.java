package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.CreateBucketConfiguration;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateBucketRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010%\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010&\u001a\u00020'H\u0096\u0080\u0004J\u0014\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010*\u001a\u00020\u00002\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-0,¢\u0006\u0002\b.H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\rR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CreateBucketRequest$Builder;)V", "acl", "Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "bucket", "", "getBucket", "()Ljava/lang/String;", "createBucketConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketConfiguration;", "getCreateBucketConfiguration", "()Laws/sdk/kotlin/services/s3/model/CreateBucketConfiguration;", "grantFullControl", "getGrantFullControl", "grantRead", "getGrantRead", "grantReadAcp", "getGrantReadAcp", "grantWrite", "getGrantWrite", "grantWriteAcp", "getGrantWriteAcp", "objectLockEnabledForBucket", "", "getObjectLockEnabledForBucket", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "objectOwnership", "Laws/sdk/kotlin/services/s3/model/ObjectOwnership;", "getObjectOwnership", "()Laws/sdk/kotlin/services/s3/model/ObjectOwnership;", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateBucketRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BucketCannedAcl acl;
    private final String bucket;
    private final CreateBucketConfiguration createBucketConfiguration;
    private final String grantFullControl;
    private final String grantRead;
    private final String grantReadAcp;
    private final String grantWrite;
    private final String grantWriteAcp;
    private final Boolean objectLockEnabledForBucket;
    private final ObjectOwnership objectOwnership;

    public /* synthetic */ CreateBucketRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateBucketRequest(Builder builder) {
        this.acl = builder.getAcl();
        this.bucket = builder.getBucket();
        this.createBucketConfiguration = builder.getCreateBucketConfiguration();
        this.grantFullControl = builder.getGrantFullControl();
        this.grantRead = builder.getGrantRead();
        this.grantReadAcp = builder.getGrantReadAcp();
        this.grantWrite = builder.getGrantWrite();
        this.grantWriteAcp = builder.getGrantWriteAcp();
        this.objectLockEnabledForBucket = builder.getObjectLockEnabledForBucket();
        this.objectOwnership = builder.getObjectOwnership();
    }

    public final BucketCannedAcl getAcl() {
        return this.acl;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final CreateBucketConfiguration getCreateBucketConfiguration() {
        return this.createBucketConfiguration;
    }

    public final String getGrantFullControl() {
        return this.grantFullControl;
    }

    public final String getGrantRead() {
        return this.grantRead;
    }

    public final String getGrantReadAcp() {
        return this.grantReadAcp;
    }

    public final String getGrantWrite() {
        return this.grantWrite;
    }

    public final String getGrantWriteAcp() {
        return this.grantWriteAcp;
    }

    public final Boolean getObjectLockEnabledForBucket() {
        return this.objectLockEnabledForBucket;
    }

    public final ObjectOwnership getObjectOwnership() {
        return this.objectOwnership;
    }

    /* JADX INFO: compiled from: CreateBucketRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateBucketRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateBucketRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateBucketRequest(");
        sb.append("acl=" + this.acl + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("createBucketConfiguration=" + this.createBucketConfiguration + AbstractJsonLexerKt.COMMA);
        sb.append("grantFullControl=" + this.grantFullControl + AbstractJsonLexerKt.COMMA);
        sb.append("grantRead=" + this.grantRead + AbstractJsonLexerKt.COMMA);
        sb.append("grantReadAcp=" + this.grantReadAcp + AbstractJsonLexerKt.COMMA);
        sb.append("grantWrite=" + this.grantWrite + AbstractJsonLexerKt.COMMA);
        sb.append("grantWriteAcp=" + this.grantWriteAcp + AbstractJsonLexerKt.COMMA);
        sb.append("objectLockEnabledForBucket=" + this.objectLockEnabledForBucket + AbstractJsonLexerKt.COMMA);
        sb.append("objectOwnership=" + this.objectOwnership);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        BucketCannedAcl bucketCannedAcl = this.acl;
        int iHashCode = (bucketCannedAcl != null ? bucketCannedAcl.hashCode() : 0) * 31;
        String str = this.bucket;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        CreateBucketConfiguration createBucketConfiguration = this.createBucketConfiguration;
        int iHashCode3 = (iHashCode2 + (createBucketConfiguration != null ? createBucketConfiguration.hashCode() : 0)) * 31;
        String str2 = this.grantFullControl;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.grantRead;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.grantReadAcp;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.grantWrite;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.grantWriteAcp;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Boolean bool = this.objectLockEnabledForBucket;
        int iHashCode9 = (iHashCode8 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        ObjectOwnership objectOwnership = this.objectOwnership;
        return iHashCode9 + (objectOwnership != null ? objectOwnership.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateBucketRequest createBucketRequest = (CreateBucketRequest) other;
        return Intrinsics.areEqual(this.acl, createBucketRequest.acl) && Intrinsics.areEqual(this.bucket, createBucketRequest.bucket) && Intrinsics.areEqual(this.createBucketConfiguration, createBucketRequest.createBucketConfiguration) && Intrinsics.areEqual(this.grantFullControl, createBucketRequest.grantFullControl) && Intrinsics.areEqual(this.grantRead, createBucketRequest.grantRead) && Intrinsics.areEqual(this.grantReadAcp, createBucketRequest.grantReadAcp) && Intrinsics.areEqual(this.grantWrite, createBucketRequest.grantWrite) && Intrinsics.areEqual(this.grantWriteAcp, createBucketRequest.grantWriteAcp) && Intrinsics.areEqual(this.objectLockEnabledForBucket, createBucketRequest.objectLockEnabledForBucket) && Intrinsics.areEqual(this.objectOwnership, createBucketRequest.objectOwnership);
    }

    public static /* synthetic */ CreateBucketRequest copy$default(CreateBucketRequest createBucketRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CreateBucketRequest.copy.1
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
        Builder builder = new Builder(createBucketRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateBucketRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateBucketRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00105\u001a\u00020\u0005H\u0001J\u001f\u0010\u0013\u001a\u0002062\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020608¢\u0006\u0002\b:J\r\u0010;\u001a\u00020\u0000H\u0000¢\u0006\u0002\b<R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001c\u0010%\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006="}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CreateBucketRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;", "(Laws/sdk/kotlin/services/s3/model/CreateBucketRequest;)V", "acl", "Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "setAcl", "(Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "createBucketConfiguration", "Laws/sdk/kotlin/services/s3/model/CreateBucketConfiguration;", "getCreateBucketConfiguration", "()Laws/sdk/kotlin/services/s3/model/CreateBucketConfiguration;", "setCreateBucketConfiguration", "(Laws/sdk/kotlin/services/s3/model/CreateBucketConfiguration;)V", "grantFullControl", "getGrantFullControl", "setGrantFullControl", "grantRead", "getGrantRead", "setGrantRead", "grantReadAcp", "getGrantReadAcp", "setGrantReadAcp", "grantWrite", "getGrantWrite", "setGrantWrite", "grantWriteAcp", "getGrantWriteAcp", "setGrantWriteAcp", "objectLockEnabledForBucket", "", "getObjectLockEnabledForBucket", "()Ljava/lang/Boolean;", "setObjectLockEnabledForBucket", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "objectOwnership", "Laws/sdk/kotlin/services/s3/model/ObjectOwnership;", "getObjectOwnership", "()Laws/sdk/kotlin/services/s3/model/ObjectOwnership;", "setObjectOwnership", "(Laws/sdk/kotlin/services/s3/model/ObjectOwnership;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CreateBucketConfiguration$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private BucketCannedAcl acl;
        private String bucket;
        private CreateBucketConfiguration createBucketConfiguration;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWrite;
        private String grantWriteAcp;
        private Boolean objectLockEnabledForBucket;
        private ObjectOwnership objectOwnership;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final BucketCannedAcl getAcl() {
            return this.acl;
        }

        public final void setAcl(BucketCannedAcl bucketCannedAcl) {
            this.acl = bucketCannedAcl;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final CreateBucketConfiguration getCreateBucketConfiguration() {
            return this.createBucketConfiguration;
        }

        public final void setCreateBucketConfiguration(CreateBucketConfiguration createBucketConfiguration) {
            this.createBucketConfiguration = createBucketConfiguration;
        }

        public final String getGrantFullControl() {
            return this.grantFullControl;
        }

        public final void setGrantFullControl(String str) {
            this.grantFullControl = str;
        }

        public final String getGrantRead() {
            return this.grantRead;
        }

        public final void setGrantRead(String str) {
            this.grantRead = str;
        }

        public final String getGrantReadAcp() {
            return this.grantReadAcp;
        }

        public final void setGrantReadAcp(String str) {
            this.grantReadAcp = str;
        }

        public final String getGrantWrite() {
            return this.grantWrite;
        }

        public final void setGrantWrite(String str) {
            this.grantWrite = str;
        }

        public final String getGrantWriteAcp() {
            return this.grantWriteAcp;
        }

        public final void setGrantWriteAcp(String str) {
            this.grantWriteAcp = str;
        }

        public final Boolean getObjectLockEnabledForBucket() {
            return this.objectLockEnabledForBucket;
        }

        public final void setObjectLockEnabledForBucket(Boolean bool) {
            this.objectLockEnabledForBucket = bool;
        }

        public final ObjectOwnership getObjectOwnership() {
            return this.objectOwnership;
        }

        public final void setObjectOwnership(ObjectOwnership objectOwnership) {
            this.objectOwnership = objectOwnership;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateBucketRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.acl = x.getAcl();
            this.bucket = x.getBucket();
            this.createBucketConfiguration = x.getCreateBucketConfiguration();
            this.grantFullControl = x.getGrantFullControl();
            this.grantRead = x.getGrantRead();
            this.grantReadAcp = x.getGrantReadAcp();
            this.grantWrite = x.getGrantWrite();
            this.grantWriteAcp = x.getGrantWriteAcp();
            this.objectLockEnabledForBucket = x.getObjectLockEnabledForBucket();
            this.objectOwnership = x.getObjectOwnership();
        }

        public final CreateBucketRequest build() {
            return new CreateBucketRequest(this, null);
        }

        public final void createBucketConfiguration(Function1<? super CreateBucketConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.createBucketConfiguration = CreateBucketRequestKt.f429x9992dbb2.invoke(block);
        }
    }
}
