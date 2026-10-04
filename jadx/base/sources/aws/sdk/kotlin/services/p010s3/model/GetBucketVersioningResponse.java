package aws.sdk.kotlin.services.p010s3.model;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GetBucketVersioningResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0015\u001a\u00020\u00002\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse$Builder;)V", "mfaDelete", "Laws/sdk/kotlin/services/s3/model/MfaDeleteStatus;", "getMfaDelete", "()Laws/sdk/kotlin/services/s3/model/MfaDeleteStatus;", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/BucketVersioningStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/BucketVersioningStatus;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetBucketVersioningResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MfaDeleteStatus mfaDelete;
    private final BucketVersioningStatus status;

    public /* synthetic */ GetBucketVersioningResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetBucketVersioningResponse(Builder builder) {
        this.mfaDelete = builder.getMfaDelete();
        this.status = builder.getStatus();
    }

    public final MfaDeleteStatus getMfaDelete() {
        return this.mfaDelete;
    }

    public final BucketVersioningStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: compiled from: GetBucketVersioningResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetBucketVersioningResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketVersioningResponse(");
        sb.append("mfaDelete=" + this.mfaDelete + AbstractJsonLexerKt.COMMA);
        sb.append("status=" + this.status);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        MfaDeleteStatus mfaDeleteStatus = this.mfaDelete;
        int iHashCode = (mfaDeleteStatus != null ? mfaDeleteStatus.hashCode() : 0) * 31;
        BucketVersioningStatus bucketVersioningStatus = this.status;
        return iHashCode + (bucketVersioningStatus != null ? bucketVersioningStatus.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetBucketVersioningResponse getBucketVersioningResponse = (GetBucketVersioningResponse) other;
        return Intrinsics.areEqual(this.mfaDelete, getBucketVersioningResponse.mfaDelete) && Intrinsics.areEqual(this.status, getBucketVersioningResponse.status);
    }

    public static /* synthetic */ GetBucketVersioningResponse copy$default(GetBucketVersioningResponse getBucketVersioningResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetBucketVersioningResponse.copy.1
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
        Builder builder = new Builder(getBucketVersioningResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final GetBucketVersioningResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetBucketVersioningResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;", "(Laws/sdk/kotlin/services/s3/model/GetBucketVersioningResponse;)V", "mfaDelete", "Laws/sdk/kotlin/services/s3/model/MfaDeleteStatus;", "getMfaDelete", "()Laws/sdk/kotlin/services/s3/model/MfaDeleteStatus;", "setMfaDelete", "(Laws/sdk/kotlin/services/s3/model/MfaDeleteStatus;)V", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/BucketVersioningStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/BucketVersioningStatus;", "setStatus", "(Laws/sdk/kotlin/services/s3/model/BucketVersioningStatus;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private MfaDeleteStatus mfaDelete;
        private BucketVersioningStatus status;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final MfaDeleteStatus getMfaDelete() {
            return this.mfaDelete;
        }

        public final void setMfaDelete(MfaDeleteStatus mfaDeleteStatus) {
            this.mfaDelete = mfaDeleteStatus;
        }

        public final BucketVersioningStatus getStatus() {
            return this.status;
        }

        public final void setStatus(BucketVersioningStatus bucketVersioningStatus) {
            this.status = bucketVersioningStatus;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetBucketVersioningResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.mfaDelete = x.getMfaDelete();
            this.status = x.getStatus();
        }

        public final GetBucketVersioningResponse build() {
            return new GetBucketVersioningResponse(this, null);
        }
    }
}
