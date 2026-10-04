package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryptionConfiguration;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PutBucketEncryptionRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0016\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "contentMd5", "getContentMd5", "expectedBucketOwner", "getExpectedBucketOwner", "serverSideEncryptionConfiguration", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionConfiguration;", "getServerSideEncryptionConfiguration", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionConfiguration;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutBucketEncryptionRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final String contentMd5;
    private final String expectedBucketOwner;
    private final ServerSideEncryptionConfiguration serverSideEncryptionConfiguration;

    public /* synthetic */ PutBucketEncryptionRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutBucketEncryptionRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.contentMd5 = builder.getContentMd5();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.serverSideEncryptionConfiguration = builder.getServerSideEncryptionConfiguration();
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

    public final ServerSideEncryptionConfiguration getServerSideEncryptionConfiguration() {
        return this.serverSideEncryptionConfiguration;
    }

    /* JADX INFO: compiled from: PutBucketEncryptionRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutBucketEncryptionRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketEncryptionRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("contentMd5=" + this.contentMd5 + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("serverSideEncryptionConfiguration=" + this.serverSideEncryptionConfiguration);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode2 = (iHashCode + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        String str2 = this.contentMd5;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expectedBucketOwner;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ServerSideEncryptionConfiguration serverSideEncryptionConfiguration = this.serverSideEncryptionConfiguration;
        return iHashCode4 + (serverSideEncryptionConfiguration != null ? serverSideEncryptionConfiguration.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PutBucketEncryptionRequest putBucketEncryptionRequest = (PutBucketEncryptionRequest) other;
        return Intrinsics.areEqual(this.bucket, putBucketEncryptionRequest.bucket) && Intrinsics.areEqual(this.checksumAlgorithm, putBucketEncryptionRequest.checksumAlgorithm) && Intrinsics.areEqual(this.contentMd5, putBucketEncryptionRequest.contentMd5) && Intrinsics.areEqual(this.expectedBucketOwner, putBucketEncryptionRequest.expectedBucketOwner) && Intrinsics.areEqual(this.serverSideEncryptionConfiguration, putBucketEncryptionRequest.serverSideEncryptionConfiguration);
    }

    public static /* synthetic */ PutBucketEncryptionRequest copy$default(PutBucketEncryptionRequest putBucketEncryptionRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PutBucketEncryptionRequest.copy.1
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
        Builder builder = new Builder(putBucketEncryptionRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final PutBucketEncryptionRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PutBucketEncryptionRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020\u0005H\u0001J\u001f\u0010\u0019\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0000H\u0000¢\u0006\u0002\b&R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketEncryptionRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "contentMd5", "getContentMd5", "setContentMd5", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "serverSideEncryptionConfiguration", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionConfiguration;", "getServerSideEncryptionConfiguration", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionConfiguration;", "setServerSideEncryptionConfiguration", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionConfiguration;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionConfiguration$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private ChecksumAlgorithm checksumAlgorithm;
        private String contentMd5;
        private String expectedBucketOwner;
        private ServerSideEncryptionConfiguration serverSideEncryptionConfiguration;

        public final Builder correctErrors$s3() {
            return this;
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

        public final ServerSideEncryptionConfiguration getServerSideEncryptionConfiguration() {
            return this.serverSideEncryptionConfiguration;
        }

        public final void setServerSideEncryptionConfiguration(ServerSideEncryptionConfiguration serverSideEncryptionConfiguration) {
            this.serverSideEncryptionConfiguration = serverSideEncryptionConfiguration;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutBucketEncryptionRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.contentMd5 = x.getContentMd5();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.serverSideEncryptionConfiguration = x.getServerSideEncryptionConfiguration();
        }

        public final PutBucketEncryptionRequest build() {
            return new PutBucketEncryptionRequest(this, null);
        }

        public final void serverSideEncryptionConfiguration(Function1<? super ServerSideEncryptionConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.serverSideEncryptionConfiguration = PutBucketEncryptionRequestKt.f486x8a751849.invoke(block);
        }
    }
}
