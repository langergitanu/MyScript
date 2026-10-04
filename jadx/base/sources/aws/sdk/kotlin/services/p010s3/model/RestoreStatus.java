package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: RestoreStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0014\u001a\u00020\u00002\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "", "builder", "Laws/sdk/kotlin/services/s3/model/RestoreStatus$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/RestoreStatus$Builder;)V", "isRestoreInProgress", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "restoreExpiryDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getRestoreExpiryDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "toString", "", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestoreStatus {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean isRestoreInProgress;
    private final Instant restoreExpiryDate;

    public /* synthetic */ RestoreStatus(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private RestoreStatus(Builder builder) {
        this.isRestoreInProgress = builder.getIsRestoreInProgress();
        this.restoreExpiryDate = builder.getRestoreExpiryDate();
    }

    /* JADX INFO: renamed from: isRestoreInProgress, reason: from getter */
    public final Boolean getIsRestoreInProgress() {
        return this.isRestoreInProgress;
    }

    public final Instant getRestoreExpiryDate() {
        return this.restoreExpiryDate;
    }

    /* JADX INFO: compiled from: RestoreStatus.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RestoreStatus$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/RestoreStatus$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RestoreStatus invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RestoreStatus(");
        sb.append("isRestoreInProgress=" + this.isRestoreInProgress + AbstractJsonLexerKt.COMMA);
        sb.append("restoreExpiryDate=" + this.restoreExpiryDate);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.isRestoreInProgress;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        Instant instant = this.restoreExpiryDate;
        return iHashCode + (instant != null ? instant.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        RestoreStatus restoreStatus = (RestoreStatus) other;
        return Intrinsics.areEqual(this.isRestoreInProgress, restoreStatus.isRestoreInProgress) && Intrinsics.areEqual(this.restoreExpiryDate, restoreStatus.restoreExpiryDate);
    }

    public static /* synthetic */ RestoreStatus copy$default(RestoreStatus restoreStatus, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.RestoreStatus.copy.1
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
        Builder builder = new Builder(restoreStatus);
        block.invoke(builder);
        return builder.build();
    }

    public final RestoreStatus copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: RestoreStatus.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RestoreStatus$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/RestoreStatus;", "(Laws/sdk/kotlin/services/s3/model/RestoreStatus;)V", "isRestoreInProgress", "", "()Ljava/lang/Boolean;", "setRestoreInProgress", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "restoreExpiryDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getRestoreExpiryDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "setRestoreExpiryDate", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean isRestoreInProgress;
        private Instant restoreExpiryDate;

        public final Builder correctErrors$s3() {
            return this;
        }

        /* JADX INFO: renamed from: isRestoreInProgress, reason: from getter */
        public final Boolean getIsRestoreInProgress() {
            return this.isRestoreInProgress;
        }

        public final void setRestoreInProgress(Boolean bool) {
            this.isRestoreInProgress = bool;
        }

        public final Instant getRestoreExpiryDate() {
            return this.restoreExpiryDate;
        }

        public final void setRestoreExpiryDate(Instant instant) {
            this.restoreExpiryDate = instant;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(RestoreStatus x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.isRestoreInProgress = x.getIsRestoreInProgress();
            this.restoreExpiryDate = x.getRestoreExpiryDate();
        }

        public final RestoreStatus build() {
            return new RestoreStatus(this, null);
        }
    }
}
