package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.AnalyticsConfiguration;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PutBucketAnalyticsConfigurationRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0012\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest$Builder;)V", "analyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "getAnalyticsConfiguration", "()Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "bucket", "", "getBucket", "()Ljava/lang/String;", "expectedBucketOwner", "getExpectedBucketOwner", "id", "getId", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutBucketAnalyticsConfigurationRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnalyticsConfiguration analyticsConfiguration;
    private final String bucket;
    private final String expectedBucketOwner;
    private final String id;

    public /* synthetic */ PutBucketAnalyticsConfigurationRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutBucketAnalyticsConfigurationRequest(Builder builder) {
        this.analyticsConfiguration = builder.getAnalyticsConfiguration();
        this.bucket = builder.getBucket();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.id = builder.getId();
    }

    public final AnalyticsConfiguration getAnalyticsConfiguration() {
        return this.analyticsConfiguration;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX INFO: compiled from: PutBucketAnalyticsConfigurationRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutBucketAnalyticsConfigurationRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PutBucketAnalyticsConfigurationRequest(");
        sb.append("analyticsConfiguration=" + this.analyticsConfiguration + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AnalyticsConfiguration analyticsConfiguration = this.analyticsConfiguration;
        int iHashCode = (analyticsConfiguration != null ? analyticsConfiguration.hashCode() : 0) * 31;
        String str = this.bucket;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.expectedBucketOwner;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.id;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PutBucketAnalyticsConfigurationRequest putBucketAnalyticsConfigurationRequest = (PutBucketAnalyticsConfigurationRequest) other;
        return Intrinsics.areEqual(this.analyticsConfiguration, putBucketAnalyticsConfigurationRequest.analyticsConfiguration) && Intrinsics.areEqual(this.bucket, putBucketAnalyticsConfigurationRequest.bucket) && Intrinsics.areEqual(this.expectedBucketOwner, putBucketAnalyticsConfigurationRequest.expectedBucketOwner) && Intrinsics.areEqual(this.id, putBucketAnalyticsConfigurationRequest.id);
    }

    public static /* synthetic */ PutBucketAnalyticsConfigurationRequest copy$default(PutBucketAnalyticsConfigurationRequest putBucketAnalyticsConfigurationRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PutBucketAnalyticsConfigurationRequest.copy.1
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
        Builder builder = new Builder(putBucketAnalyticsConfigurationRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final PutBucketAnalyticsConfigurationRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PutBucketAnalyticsConfigurationRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\u0000H\u0000¢\u0006\u0002\b R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;", "(Laws/sdk/kotlin/services/s3/model/PutBucketAnalyticsConfigurationRequest;)V", "analyticsConfiguration", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "getAnalyticsConfiguration", "()Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "setAnalyticsConfiguration", "(Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "id", "getId", "setId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AnalyticsConfiguration analyticsConfiguration;
        private String bucket;
        private String expectedBucketOwner;
        private String id;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final AnalyticsConfiguration getAnalyticsConfiguration() {
            return this.analyticsConfiguration;
        }

        public final void setAnalyticsConfiguration(AnalyticsConfiguration analyticsConfiguration) {
            this.analyticsConfiguration = analyticsConfiguration;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutBucketAnalyticsConfigurationRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.analyticsConfiguration = x.getAnalyticsConfiguration();
            this.bucket = x.getBucket();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.id = x.getId();
        }

        public final PutBucketAnalyticsConfigurationRequest build() {
            return new PutBucketAnalyticsConfigurationRequest(this, null);
        }

        public final void analyticsConfiguration(Function1<? super AnalyticsConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.analyticsConfiguration = PutBucketAnalyticsConfigurationRequestKt.awsSdkKotlinServicesS3ModelAnalyticsConfigurationDslBuilderRef.invoke(block);
        }
    }
}
