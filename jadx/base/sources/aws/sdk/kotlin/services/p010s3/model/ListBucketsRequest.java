package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ListBucketsRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0013\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Builder;)V", "bucketRegion", "", "getBucketRegion", "()Ljava/lang/String;", "continuationToken", "getContinuationToken", "maxBuckets", "", "getMaxBuckets", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "prefix", "getPrefix", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListBucketsRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucketRegion;
    private final String continuationToken;
    private final Integer maxBuckets;
    private final String prefix;

    public /* synthetic */ ListBucketsRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListBucketsRequest(Builder builder) {
        this.bucketRegion = builder.getBucketRegion();
        this.continuationToken = builder.getContinuationToken();
        this.maxBuckets = builder.getMaxBuckets();
        this.prefix = builder.getPrefix();
    }

    public final String getBucketRegion() {
        return this.bucketRegion;
    }

    public final String getContinuationToken() {
        return this.continuationToken;
    }

    public final Integer getMaxBuckets() {
        return this.maxBuckets;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    /* JADX INFO: compiled from: ListBucketsRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListBucketsRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListBucketsRequest(");
        sb.append("bucketRegion=" + this.bucketRegion + AbstractJsonLexerKt.COMMA);
        sb.append("continuationToken=" + this.continuationToken + AbstractJsonLexerKt.COMMA);
        sb.append("maxBuckets=" + this.maxBuckets + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucketRegion;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.continuationToken;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.maxBuckets;
        int iIntValue = (iHashCode2 + (num != null ? num.intValue() : 0)) * 31;
        String str3 = this.prefix;
        return iIntValue + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListBucketsRequest listBucketsRequest = (ListBucketsRequest) other;
        return Intrinsics.areEqual(this.bucketRegion, listBucketsRequest.bucketRegion) && Intrinsics.areEqual(this.continuationToken, listBucketsRequest.continuationToken) && Intrinsics.areEqual(this.maxBuckets, listBucketsRequest.maxBuckets) && Intrinsics.areEqual(this.prefix, listBucketsRequest.prefix);
    }

    public static /* synthetic */ ListBucketsRequest copy$default(ListBucketsRequest listBucketsRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListBucketsRequest.copy.1
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
        Builder builder = new Builder(listBucketsRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final ListBucketsRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListBucketsRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u0005H\u0001J\r\u0010\u001b\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\f¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketsRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListBucketsRequest;)V", "bucketRegion", "", "getBucketRegion", "()Ljava/lang/String;", "setBucketRegion", "(Ljava/lang/String;)V", "continuationToken", "getContinuationToken", "setContinuationToken", "maxBuckets", "", "getMaxBuckets", "()Ljava/lang/Integer;", "setMaxBuckets", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "prefix", "getPrefix", "setPrefix", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucketRegion;
        private String continuationToken;
        private Integer maxBuckets;
        private String prefix;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucketRegion() {
            return this.bucketRegion;
        }

        public final void setBucketRegion(String str) {
            this.bucketRegion = str;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final void setContinuationToken(String str) {
            this.continuationToken = str;
        }

        public final Integer getMaxBuckets() {
            return this.maxBuckets;
        }

        public final void setMaxBuckets(Integer num) {
            this.maxBuckets = num;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListBucketsRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucketRegion = x.getBucketRegion();
            this.continuationToken = x.getContinuationToken();
            this.maxBuckets = x.getMaxBuckets();
            this.prefix = x.getPrefix();
        }

        public final ListBucketsRequest build() {
            return new ListBucketsRequest(this, null);
        }
    }
}
