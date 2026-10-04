package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Delete;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DeleteObjectsRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001f\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010 \u001a\u00020!H\u0096\u0080\u0004J\u0014\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010$\u001a\u00020\u00002\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020'0&¢\u0006\u0002\b(H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "bypassGovernanceRetention", "", "getBypassGovernanceRetention", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "delete", "Laws/sdk/kotlin/services/s3/model/Delete;", "getDelete", "()Laws/sdk/kotlin/services/s3/model/Delete;", "expectedBucketOwner", "getExpectedBucketOwner", "mfa", "getMfa", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeleteObjectsRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final Boolean bypassGovernanceRetention;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final Delete delete;
    private final String expectedBucketOwner;
    private final String mfa;
    private final RequestPayer requestPayer;

    public /* synthetic */ DeleteObjectsRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private DeleteObjectsRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.bypassGovernanceRetention = builder.getBypassGovernanceRetention();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.delete = builder.getDelete();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.mfa = builder.getMfa();
        this.requestPayer = builder.getRequestPayer();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final Boolean getBypassGovernanceRetention() {
        return this.bypassGovernanceRetention;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final Delete getDelete() {
        return this.delete;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getMfa() {
        return this.mfa;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    /* JADX INFO: compiled from: DeleteObjectsRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteObjectsRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectsRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("bypassGovernanceRetention=" + this.bypassGovernanceRetention + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("delete=" + this.delete + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("mfa=" + this.mfa + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.bypassGovernanceRetention;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode3 = (iHashCode2 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        Delete delete = this.delete;
        int iHashCode4 = (iHashCode3 + (delete != null ? delete.hashCode() : 0)) * 31;
        String str2 = this.expectedBucketOwner;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mfa;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        return iHashCode6 + (requestPayer != null ? requestPayer.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DeleteObjectsRequest deleteObjectsRequest = (DeleteObjectsRequest) other;
        return Intrinsics.areEqual(this.bucket, deleteObjectsRequest.bucket) && Intrinsics.areEqual(this.bypassGovernanceRetention, deleteObjectsRequest.bypassGovernanceRetention) && Intrinsics.areEqual(this.checksumAlgorithm, deleteObjectsRequest.checksumAlgorithm) && Intrinsics.areEqual(this.delete, deleteObjectsRequest.delete) && Intrinsics.areEqual(this.expectedBucketOwner, deleteObjectsRequest.expectedBucketOwner) && Intrinsics.areEqual(this.mfa, deleteObjectsRequest.mfa) && Intrinsics.areEqual(this.requestPayer, deleteObjectsRequest.requestPayer);
    }

    public static /* synthetic */ DeleteObjectsRequest copy$default(DeleteObjectsRequest deleteObjectsRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.DeleteObjectsRequest.copy.1
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
        Builder builder = new Builder(deleteObjectsRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final DeleteObjectsRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: DeleteObjectsRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010,\u001a\u00020\u0005H\u0001J\u001f\u0010\u001a\u001a\u00020-2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b1J\r\u00102\u001a\u00020\u0000H\u0000¢\u0006\u0002\b3R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00064"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectsRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "bypassGovernanceRetention", "", "getBypassGovernanceRetention", "()Ljava/lang/Boolean;", "setBypassGovernanceRetention", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "delete", "Laws/sdk/kotlin/services/s3/model/Delete;", "getDelete", "()Laws/sdk/kotlin/services/s3/model/Delete;", "setDelete", "(Laws/sdk/kotlin/services/s3/model/Delete;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "mfa", "getMfa", "setMfa", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Delete$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private Boolean bypassGovernanceRetention;
        private ChecksumAlgorithm checksumAlgorithm;
        private Delete delete;
        private String expectedBucketOwner;
        private String mfa;
        private RequestPayer requestPayer;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final Boolean getBypassGovernanceRetention() {
            return this.bypassGovernanceRetention;
        }

        public final void setBypassGovernanceRetention(Boolean bool) {
            this.bypassGovernanceRetention = bool;
        }

        public final ChecksumAlgorithm getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        public final Delete getDelete() {
            return this.delete;
        }

        public final void setDelete(Delete delete) {
            this.delete = delete;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final String getMfa() {
            return this.mfa;
        }

        public final void setMfa(String str) {
            this.mfa = str;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(DeleteObjectsRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.bypassGovernanceRetention = x.getBypassGovernanceRetention();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.delete = x.getDelete();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.mfa = x.getMfa();
            this.requestPayer = x.getRequestPayer();
        }

        public final DeleteObjectsRequest build() {
            return new DeleteObjectsRequest(this, null);
        }

        public final void delete(Function1<? super Delete.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.delete = DeleteObjectsRequestKt.awsSdkKotlinServicesS3ModelDeleteDslBuilderRef.invoke(block);
        }
    }
}
