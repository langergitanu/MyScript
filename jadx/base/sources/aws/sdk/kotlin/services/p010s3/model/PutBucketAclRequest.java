package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.AccessControlPolicy;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PutBucketAclRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010$\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010%\u001a\u00020&H\u0096\u0080\u0004J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010*\u001a\u00020\u00002\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020-0,¢\u0006\u0002\b.H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0013\u0010 \u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0013\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest$Builder;)V", "accessControlPolicy", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "getAccessControlPolicy", "()Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "acl", "Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "bucket", "", "getBucket", "()Ljava/lang/String;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "contentMd5", "getContentMd5", "expectedBucketOwner", "getExpectedBucketOwner", "grantFullControl", "getGrantFullControl", "grantRead", "getGrantRead", "grantReadAcp", "getGrantReadAcp", "grantWrite", "getGrantWrite", "grantWriteAcp", "getGrantWriteAcp", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutBucketAclRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AccessControlPolicy accessControlPolicy;
    private final BucketCannedAcl acl;
    private final String bucket;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final String contentMd5;
    private final String expectedBucketOwner;
    private final String grantFullControl;
    private final String grantRead;
    private final String grantReadAcp;
    private final String grantWrite;
    private final String grantWriteAcp;

    public /* synthetic */ PutBucketAclRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutBucketAclRequest(Builder builder) {
        this.accessControlPolicy = builder.getAccessControlPolicy();
        this.acl = builder.getAcl();
        this.bucket = builder.getBucket();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.contentMd5 = builder.getContentMd5();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.grantFullControl = builder.getGrantFullControl();
        this.grantRead = builder.getGrantRead();
        this.grantReadAcp = builder.getGrantReadAcp();
        this.grantWrite = builder.getGrantWrite();
        this.grantWriteAcp = builder.getGrantWriteAcp();
    }

    public final AccessControlPolicy getAccessControlPolicy() {
        return this.accessControlPolicy;
    }

    public final BucketCannedAcl getAcl() {
        return this.acl;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final String getContentMd5() {
        return this.contentMd5;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
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

    /* JADX INFO: compiled from: PutBucketAclRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutBucketAclRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketAclRequest(");
        sb.append("accessControlPolicy=" + this.accessControlPolicy + AbstractJsonLexerKt.COMMA);
        sb.append("acl=" + this.acl + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("contentMd5=" + this.contentMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("grantFullControl=" + this.grantFullControl + AbstractJsonLexerKt.COMMA);
        sb.append("grantRead=" + this.grantRead + AbstractJsonLexerKt.COMMA);
        sb.append("grantReadAcp=" + this.grantReadAcp + AbstractJsonLexerKt.COMMA);
        sb.append("grantWrite=" + this.grantWrite + AbstractJsonLexerKt.COMMA);
        sb.append("grantWriteAcp=" + this.grantWriteAcp);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AccessControlPolicy accessControlPolicy = this.accessControlPolicy;
        int iHashCode = (accessControlPolicy != null ? accessControlPolicy.hashCode() : 0) * 31;
        BucketCannedAcl bucketCannedAcl = this.acl;
        int iHashCode2 = (iHashCode + (bucketCannedAcl != null ? bucketCannedAcl.hashCode() : 0)) * 31;
        String str = this.bucket;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode4 = (iHashCode3 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        String str2 = this.contentMd5;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expectedBucketOwner;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.grantFullControl;
        int iHashCode7 = (iHashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.grantRead;
        int iHashCode8 = (iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.grantReadAcp;
        int iHashCode9 = (iHashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.grantWrite;
        int iHashCode10 = (iHashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.grantWriteAcp;
        return iHashCode10 + (str8 != null ? str8.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PutBucketAclRequest putBucketAclRequest = (PutBucketAclRequest) other;
        return Intrinsics.areEqual(this.accessControlPolicy, putBucketAclRequest.accessControlPolicy) && Intrinsics.areEqual(this.acl, putBucketAclRequest.acl) && Intrinsics.areEqual(this.bucket, putBucketAclRequest.bucket) && Intrinsics.areEqual(this.checksumAlgorithm, putBucketAclRequest.checksumAlgorithm) && Intrinsics.areEqual(this.contentMd5, putBucketAclRequest.contentMd5) && Intrinsics.areEqual(this.expectedBucketOwner, putBucketAclRequest.expectedBucketOwner) && Intrinsics.areEqual(this.grantFullControl, putBucketAclRequest.grantFullControl) && Intrinsics.areEqual(this.grantRead, putBucketAclRequest.grantRead) && Intrinsics.areEqual(this.grantReadAcp, putBucketAclRequest.grantReadAcp) && Intrinsics.areEqual(this.grantWrite, putBucketAclRequest.grantWrite) && Intrinsics.areEqual(this.grantWriteAcp, putBucketAclRequest.grantWriteAcp);
    }

    public static /* synthetic */ PutBucketAclRequest copy$default(PutBucketAclRequest putBucketAclRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PutBucketAclRequest.copy.1
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
        Builder builder = new Builder(putBucketAclRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final PutBucketAclRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PutBucketAclRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00104\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u0002052\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020507¢\u0006\u0002\b9J\r\u0010:\u001a\u00020\u0000H\u0000¢\u0006\u0002\b;R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010%\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001c\u0010(\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001c\u0010+\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001c\u0010.\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001c\u00101\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018¨\u0006<"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAclRequest;)V", "accessControlPolicy", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "getAccessControlPolicy", "()Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "setAccessControlPolicy", "(Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;)V", "acl", "Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "getAcl", "()Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;", "setAcl", "(Laws/sdk/kotlin/services/s3/model/BucketCannedAcl;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "contentMd5", "getContentMd5", "setContentMd5", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "grantFullControl", "getGrantFullControl", "setGrantFullControl", "grantRead", "getGrantRead", "setGrantRead", "grantReadAcp", "getGrantReadAcp", "setGrantReadAcp", "grantWrite", "getGrantWrite", "setGrantWrite", "grantWriteAcp", "getGrantWriteAcp", "setGrantWriteAcp", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AccessControlPolicy accessControlPolicy;
        private BucketCannedAcl acl;
        private String bucket;
        private ChecksumAlgorithm checksumAlgorithm;
        private String contentMd5;
        private String expectedBucketOwner;
        private String grantFullControl;
        private String grantRead;
        private String grantReadAcp;
        private String grantWrite;
        private String grantWriteAcp;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final AccessControlPolicy getAccessControlPolicy() {
            return this.accessControlPolicy;
        }

        public final void setAccessControlPolicy(AccessControlPolicy accessControlPolicy) {
            this.accessControlPolicy = accessControlPolicy;
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

        public final ChecksumAlgorithm getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        public final String getContentMd5() {
            return this.contentMd5;
        }

        public final void setContentMd5(String str) {
            this.contentMd5 = str;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
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

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutBucketAclRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessControlPolicy = x.getAccessControlPolicy();
            this.acl = x.getAcl();
            this.bucket = x.getBucket();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.contentMd5 = x.getContentMd5();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.grantFullControl = x.getGrantFullControl();
            this.grantRead = x.getGrantRead();
            this.grantReadAcp = x.getGrantReadAcp();
            this.grantWrite = x.getGrantWrite();
            this.grantWriteAcp = x.getGrantWriteAcp();
        }

        public final PutBucketAclRequest build() {
            return new PutBucketAclRequest(this, null);
        }

        public final void accessControlPolicy(Function1<? super AccessControlPolicy.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.accessControlPolicy = PutBucketAclRequestKt.awsSdkKotlinServicesS3ModelAccessControlPolicyDslBuilderRef.invoke(block);
        }
    }
}
