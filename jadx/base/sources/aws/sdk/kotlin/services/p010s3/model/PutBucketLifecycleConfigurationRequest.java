package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.BucketLifecycleConfiguration;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PutBucketLifecycleConfigurationRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0018\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001e\u001a\u00020\u00002\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "expectedBucketOwner", "getExpectedBucketOwner", "lifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration;", "getLifecycleConfiguration", "()Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration;", "transitionDefaultMinimumObjectSize", "Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "getTransitionDefaultMinimumObjectSize", "()Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutBucketLifecycleConfigurationRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final String expectedBucketOwner;
    private final BucketLifecycleConfiguration lifecycleConfiguration;
    private final TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize;

    public /* synthetic */ PutBucketLifecycleConfigurationRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutBucketLifecycleConfigurationRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.lifecycleConfiguration = builder.getLifecycleConfiguration();
        this.transitionDefaultMinimumObjectSize = builder.getTransitionDefaultMinimumObjectSize();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final BucketLifecycleConfiguration getLifecycleConfiguration() {
        return this.lifecycleConfiguration;
    }

    public final TransitionDefaultMinimumObjectSize getTransitionDefaultMinimumObjectSize() {
        return this.transitionDefaultMinimumObjectSize;
    }

    /* JADX INFO: compiled from: PutBucketLifecycleConfigurationRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutBucketLifecycleConfigurationRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketLifecycleConfigurationRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("lifecycleConfiguration=" + this.lifecycleConfiguration + AbstractJsonLexerKt.COMMA);
        sb.append("transitionDefaultMinimumObjectSize=" + this.transitionDefaultMinimumObjectSize);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode2 = (iHashCode + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        String str2 = this.expectedBucketOwner;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        BucketLifecycleConfiguration bucketLifecycleConfiguration = this.lifecycleConfiguration;
        int iHashCode4 = (iHashCode3 + (bucketLifecycleConfiguration != null ? bucketLifecycleConfiguration.hashCode() : 0)) * 31;
        TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize = this.transitionDefaultMinimumObjectSize;
        return iHashCode4 + (transitionDefaultMinimumObjectSize != null ? transitionDefaultMinimumObjectSize.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PutBucketLifecycleConfigurationRequest putBucketLifecycleConfigurationRequest = (PutBucketLifecycleConfigurationRequest) other;
        return Intrinsics.areEqual(this.bucket, putBucketLifecycleConfigurationRequest.bucket) && Intrinsics.areEqual(this.checksumAlgorithm, putBucketLifecycleConfigurationRequest.checksumAlgorithm) && Intrinsics.areEqual(this.expectedBucketOwner, putBucketLifecycleConfigurationRequest.expectedBucketOwner) && Intrinsics.areEqual(this.lifecycleConfiguration, putBucketLifecycleConfigurationRequest.lifecycleConfiguration) && Intrinsics.areEqual(this.transitionDefaultMinimumObjectSize, putBucketLifecycleConfigurationRequest.transitionDefaultMinimumObjectSize);
    }

    public static /* synthetic */ PutBucketLifecycleConfigurationRequest copy$default(PutBucketLifecycleConfigurationRequest putBucketLifecycleConfigurationRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PutBucketLifecycleConfigurationRequest.copy.1
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
        Builder builder = new Builder(putBucketLifecycleConfigurationRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final PutBucketLifecycleConfigurationRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PutBucketLifecycleConfigurationRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\u0005H\u0001J\u001f\u0010\u0016\u001a\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketLifecycleConfigurationRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "lifecycleConfiguration", "Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration;", "getLifecycleConfiguration", "()Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration;", "setLifecycleConfiguration", "(Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration;)V", "transitionDefaultMinimumObjectSize", "Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "getTransitionDefaultMinimumObjectSize", "()Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "setTransitionDefaultMinimumObjectSize", "(Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/BucketLifecycleConfiguration$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private ChecksumAlgorithm checksumAlgorithm;
        private String expectedBucketOwner;
        private BucketLifecycleConfiguration lifecycleConfiguration;
        private TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize;

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

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final BucketLifecycleConfiguration getLifecycleConfiguration() {
            return this.lifecycleConfiguration;
        }

        public final void setLifecycleConfiguration(BucketLifecycleConfiguration bucketLifecycleConfiguration) {
            this.lifecycleConfiguration = bucketLifecycleConfiguration;
        }

        public final TransitionDefaultMinimumObjectSize getTransitionDefaultMinimumObjectSize() {
            return this.transitionDefaultMinimumObjectSize;
        }

        public final void setTransitionDefaultMinimumObjectSize(TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize = transitionDefaultMinimumObjectSize;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutBucketLifecycleConfigurationRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.lifecycleConfiguration = x.getLifecycleConfiguration();
            this.transitionDefaultMinimumObjectSize = x.getTransitionDefaultMinimumObjectSize();
        }

        public final PutBucketLifecycleConfigurationRequest build() {
            return new PutBucketLifecycleConfigurationRequest(this, null);
        }

        public final void lifecycleConfiguration(Function1<? super BucketLifecycleConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.lifecycleConfiguration = PutBucketLifecycleConfigurationRequestKt.f492x859b2f12.invoke(block);
        }
    }
}
