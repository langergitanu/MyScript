package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PutBucketLoggingResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004¨\u0006\u000f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse$Builder;)V", "toString", "", "hashCode", "", "equals", "", "other", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PutBucketLoggingResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ PutBucketLoggingResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PutBucketLoggingResponse(Builder builder) {
    }

    /* JADX INFO: compiled from: PutBucketLoggingResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PutBucketLoggingResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        return "PutBucketLoggingResponse()";
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(getClass()).hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: compiled from: PutBucketLoggingResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0001J\r\u0010\b\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;", "(Laws/sdk/kotlin/services/s3/model/PutBucketLoggingResponse;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        public final Builder correctErrors$s3() {
            return this;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PutBucketLoggingResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
        }

        public final PutBucketLoggingResponse build() {
            return new PutBucketLoggingResponse(this, null);
        }
    }
}
