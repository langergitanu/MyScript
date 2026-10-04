package aws.sdk.kotlin.services.p010s3.model;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.ErrorDetails;
import aws.sdk.kotlin.services.p010s3.model.MetadataTableConfigurationResult;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GetBucketMetadataTableConfigurationResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0012\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult$Builder;)V", "error", "Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "getError", "()Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "metadataTableConfigurationResult", "Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult;", "getMetadataTableConfigurationResult", "()Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult;", NotificationCompat.CATEGORY_STATUS, "", "getStatus", "()Ljava/lang/String;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetBucketMetadataTableConfigurationResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorDetails error;
    private final MetadataTableConfigurationResult metadataTableConfigurationResult;
    private final String status;

    public /* synthetic */ GetBucketMetadataTableConfigurationResult(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetBucketMetadataTableConfigurationResult(Builder builder) {
        this.error = builder.getError();
        this.metadataTableConfigurationResult = builder.getMetadataTableConfigurationResult();
        String status = builder.getStatus();
        if (status == null) {
            throw new IllegalArgumentException("A non-null value must be provided for status".toString());
        }
        this.status = status;
    }

    public final ErrorDetails getError() {
        return this.error;
    }

    public final MetadataTableConfigurationResult getMetadataTableConfigurationResult() {
        return this.metadataTableConfigurationResult;
    }

    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: compiled from: GetBucketMetadataTableConfigurationResult.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetBucketMetadataTableConfigurationResult invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketMetadataTableConfigurationResult(");
        sb.append("error=" + this.error + AbstractJsonLexerKt.COMMA);
        sb.append("metadataTableConfigurationResult=" + this.metadataTableConfigurationResult + AbstractJsonLexerKt.COMMA);
        sb.append("status=" + this.status);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ErrorDetails errorDetails = this.error;
        int iHashCode = (errorDetails != null ? errorDetails.hashCode() : 0) * 31;
        MetadataTableConfigurationResult metadataTableConfigurationResult = this.metadataTableConfigurationResult;
        return ((iHashCode + (metadataTableConfigurationResult != null ? metadataTableConfigurationResult.hashCode() : 0)) * 31) + this.status.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult = (GetBucketMetadataTableConfigurationResult) other;
        return Intrinsics.areEqual(this.error, getBucketMetadataTableConfigurationResult.error) && Intrinsics.areEqual(this.metadataTableConfigurationResult, getBucketMetadataTableConfigurationResult.metadataTableConfigurationResult) && Intrinsics.areEqual(this.status, getBucketMetadataTableConfigurationResult.status);
    }

    public static /* synthetic */ GetBucketMetadataTableConfigurationResult copy$default(GetBucketMetadataTableConfigurationResult getBucketMetadataTableConfigurationResult, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetBucketMetadataTableConfigurationResult.copy.1
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
        Builder builder = new Builder(getBucketMetadataTableConfigurationResult);
        block.invoke(builder);
        return builder.build();
    }

    public final GetBucketMetadataTableConfigurationResult copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetBucketMetadataTableConfigurationResult.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\u001f\u0010\r\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\r\u0010 \u001a\u00020\u0000H\u0000¢\u0006\u0002\b!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult;", "(Laws/sdk/kotlin/services/s3/model/GetBucketMetadataTableConfigurationResult;)V", "error", "Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "getError", "()Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "setError", "(Laws/sdk/kotlin/services/s3/model/ErrorDetails;)V", "metadataTableConfigurationResult", "Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult;", "getMetadataTableConfigurationResult", "()Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult;", "setMetadataTableConfigurationResult", "(Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult;)V", NotificationCompat.CATEGORY_STATUS, "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ErrorDetails$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/MetadataTableConfigurationResult$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ErrorDetails error;
        private MetadataTableConfigurationResult metadataTableConfigurationResult;
        private String status;

        public final ErrorDetails getError() {
            return this.error;
        }

        public final void setError(ErrorDetails errorDetails) {
            this.error = errorDetails;
        }

        public final MetadataTableConfigurationResult getMetadataTableConfigurationResult() {
            return this.metadataTableConfigurationResult;
        }

        public final void setMetadataTableConfigurationResult(MetadataTableConfigurationResult metadataTableConfigurationResult) {
            this.metadataTableConfigurationResult = metadataTableConfigurationResult;
        }

        public final String getStatus() {
            return this.status;
        }

        public final void setStatus(String str) {
            this.status = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetBucketMetadataTableConfigurationResult x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.error = x.getError();
            this.metadataTableConfigurationResult = x.getMetadataTableConfigurationResult();
            this.status = x.getStatus();
        }

        public final GetBucketMetadataTableConfigurationResult build() {
            return new GetBucketMetadataTableConfigurationResult(this, null);
        }

        public final void error(Function1<? super ErrorDetails.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.error = GetBucketMetadataTableConfigurationResultKt.awsSdkKotlinServicesS3ModelErrorDetailsDslBuilderRef.invoke(block);
        }

        public final void metadataTableConfigurationResult(Function1<? super MetadataTableConfigurationResult.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.metadataTableConfigurationResult = GetBucketMetadataTableConfigurationResultKt.f449xdb476a34.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.status == null) {
                this.status = "";
            }
            return this;
        }
    }
}
