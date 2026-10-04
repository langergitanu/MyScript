package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: HeadBucketResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0017\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004J\u0014\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/HeadBucketResponse$Builder;)V", "accessPointAlias", "", "getAccessPointAlias", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "bucketArn", "", "getBucketArn", "()Ljava/lang/String;", "bucketLocationName", "getBucketLocationName", "bucketLocationType", "Laws/sdk/kotlin/services/s3/model/LocationType;", "getBucketLocationType", "()Laws/sdk/kotlin/services/s3/model/LocationType;", "bucketRegion", "getBucketRegion", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HeadBucketResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean accessPointAlias;
    private final String bucketArn;
    private final String bucketLocationName;
    private final LocationType bucketLocationType;
    private final String bucketRegion;

    public /* synthetic */ HeadBucketResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private HeadBucketResponse(Builder builder) {
        this.accessPointAlias = builder.getAccessPointAlias();
        this.bucketArn = builder.getBucketArn();
        this.bucketLocationName = builder.getBucketLocationName();
        this.bucketLocationType = builder.getBucketLocationType();
        this.bucketRegion = builder.getBucketRegion();
    }

    public final Boolean getAccessPointAlias() {
        return this.accessPointAlias;
    }

    public final String getBucketArn() {
        return this.bucketArn;
    }

    public final String getBucketLocationName() {
        return this.bucketLocationName;
    }

    public final LocationType getBucketLocationType() {
        return this.bucketLocationType;
    }

    public final String getBucketRegion() {
        return this.bucketRegion;
    }

    /* JADX INFO: compiled from: HeadBucketResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/HeadBucketResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeadBucketResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeadBucketResponse(");
        sb.append("accessPointAlias=" + this.accessPointAlias + AbstractJsonLexerKt.COMMA);
        sb.append("bucketArn=" + this.bucketArn + AbstractJsonLexerKt.COMMA);
        sb.append("bucketLocationName=" + this.bucketLocationName + AbstractJsonLexerKt.COMMA);
        sb.append("bucketLocationType=" + this.bucketLocationType + AbstractJsonLexerKt.COMMA);
        sb.append("bucketRegion=" + this.bucketRegion);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.accessPointAlias;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        String str = this.bucketArn;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bucketLocationName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        LocationType locationType = this.bucketLocationType;
        int iHashCode4 = (iHashCode3 + (locationType != null ? locationType.hashCode() : 0)) * 31;
        String str3 = this.bucketRegion;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        HeadBucketResponse headBucketResponse = (HeadBucketResponse) other;
        return Intrinsics.areEqual(this.accessPointAlias, headBucketResponse.accessPointAlias) && Intrinsics.areEqual(this.bucketArn, headBucketResponse.bucketArn) && Intrinsics.areEqual(this.bucketLocationName, headBucketResponse.bucketLocationName) && Intrinsics.areEqual(this.bucketLocationType, headBucketResponse.bucketLocationType) && Intrinsics.areEqual(this.bucketRegion, headBucketResponse.bucketRegion);
    }

    public static /* synthetic */ HeadBucketResponse copy$default(HeadBucketResponse headBucketResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.HeadBucketResponse.copy.1
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
        Builder builder = new Builder(headBucketResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final HeadBucketResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: HeadBucketResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u0005H\u0001J\r\u0010!\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\"R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/HeadBucketResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "(Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;)V", "accessPointAlias", "", "getAccessPointAlias", "()Ljava/lang/Boolean;", "setAccessPointAlias", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "bucketArn", "", "getBucketArn", "()Ljava/lang/String;", "setBucketArn", "(Ljava/lang/String;)V", "bucketLocationName", "getBucketLocationName", "setBucketLocationName", "bucketLocationType", "Laws/sdk/kotlin/services/s3/model/LocationType;", "getBucketLocationType", "()Laws/sdk/kotlin/services/s3/model/LocationType;", "setBucketLocationType", "(Laws/sdk/kotlin/services/s3/model/LocationType;)V", "bucketRegion", "getBucketRegion", "setBucketRegion", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean accessPointAlias;
        private String bucketArn;
        private String bucketLocationName;
        private LocationType bucketLocationType;
        private String bucketRegion;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Boolean getAccessPointAlias() {
            return this.accessPointAlias;
        }

        public final void setAccessPointAlias(Boolean bool) {
            this.accessPointAlias = bool;
        }

        public final String getBucketArn() {
            return this.bucketArn;
        }

        public final void setBucketArn(String str) {
            this.bucketArn = str;
        }

        public final String getBucketLocationName() {
            return this.bucketLocationName;
        }

        public final void setBucketLocationName(String str) {
            this.bucketLocationName = str;
        }

        public final LocationType getBucketLocationType() {
            return this.bucketLocationType;
        }

        public final void setBucketLocationType(LocationType locationType) {
            this.bucketLocationType = locationType;
        }

        public final String getBucketRegion() {
            return this.bucketRegion;
        }

        public final void setBucketRegion(String str) {
            this.bucketRegion = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(HeadBucketResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessPointAlias = x.getAccessPointAlias();
            this.bucketArn = x.getBucketArn();
            this.bucketLocationName = x.getBucketLocationName();
            this.bucketLocationType = x.getBucketLocationType();
            this.bucketRegion = x.getBucketRegion();
        }

        public final HeadBucketResponse build() {
            return new HeadBucketResponse(this, null);
        }
    }
}
