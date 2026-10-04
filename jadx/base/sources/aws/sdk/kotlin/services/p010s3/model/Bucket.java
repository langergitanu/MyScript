package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Bucket.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0012\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Bucket;", "", "builder", "Laws/sdk/kotlin/services/s3/model/Bucket$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Bucket$Builder;)V", "bucketArn", "", "getBucketArn", "()Ljava/lang/String;", "bucketRegion", "getBucketRegion", "creationDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getCreationDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "name", "getName", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Bucket {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucketArn;
    private final String bucketRegion;
    private final Instant creationDate;
    private final String name;

    public /* synthetic */ Bucket(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Bucket(Builder builder) {
        this.bucketArn = builder.getBucketArn();
        this.bucketRegion = builder.getBucketRegion();
        this.creationDate = builder.getCreationDate();
        this.name = builder.getName();
    }

    public final String getBucketArn() {
        return this.bucketArn;
    }

    public final String getBucketRegion() {
        return this.bucketRegion;
    }

    public final Instant getCreationDate() {
        return this.creationDate;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: compiled from: Bucket.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Bucket$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/Bucket;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Bucket$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Bucket invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Bucket(");
        sb.append("bucketArn=" + this.bucketArn + AbstractJsonLexerKt.COMMA);
        sb.append("bucketRegion=" + this.bucketRegion + AbstractJsonLexerKt.COMMA);
        sb.append("creationDate=" + this.creationDate + AbstractJsonLexerKt.COMMA);
        sb.append("name=" + this.name);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucketArn;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bucketRegion;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Instant instant = this.creationDate;
        int iHashCode3 = (iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        String str3 = this.name;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Bucket bucket = (Bucket) other;
        return Intrinsics.areEqual(this.bucketArn, bucket.bucketArn) && Intrinsics.areEqual(this.bucketRegion, bucket.bucketRegion) && Intrinsics.areEqual(this.creationDate, bucket.creationDate) && Intrinsics.areEqual(this.name, bucket.name);
    }

    public static /* synthetic */ Bucket copy$default(Bucket bucket, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.Bucket.copy.1
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
        Builder builder = new Builder(bucket);
        block.invoke(builder);
        return builder.build();
    }

    public final Bucket copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: Bucket.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0005H\u0001J\r\u0010\u001a\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Bucket$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/Bucket;", "(Laws/sdk/kotlin/services/s3/model/Bucket;)V", "bucketArn", "", "getBucketArn", "()Ljava/lang/String;", "setBucketArn", "(Ljava/lang/String;)V", "bucketRegion", "getBucketRegion", "setBucketRegion", "creationDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getCreationDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "setCreationDate", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "name", "getName", "setName", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucketArn;
        private String bucketRegion;
        private Instant creationDate;
        private String name;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucketArn() {
            return this.bucketArn;
        }

        public final void setBucketArn(String str) {
            this.bucketArn = str;
        }

        public final String getBucketRegion() {
            return this.bucketRegion;
        }

        public final void setBucketRegion(String str) {
            this.bucketRegion = str;
        }

        public final Instant getCreationDate() {
            return this.creationDate;
        }

        public final void setCreationDate(Instant instant) {
            this.creationDate = instant;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Bucket x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucketArn = x.getBucketArn();
            this.bucketRegion = x.getBucketRegion();
            this.creationDate = x.getCreationDate();
            this.name = x.getName();
        }

        public final Bucket build() {
            return new Bucket(this, null);
        }
    }
}
