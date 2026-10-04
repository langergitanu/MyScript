package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.ServiceErrorMetadata;
import aws.smithy.kotlin.runtime.ServiceException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: InvalidObjectState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0082\u0004J'\u0010\u0016\u001a\u00020\u00002\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InvalidObjectState;", "Laws/sdk/kotlin/services/s3/model/S3Exception;", "builder", "Laws/sdk/kotlin/services/s3/model/InvalidObjectState$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/InvalidObjectState$Builder;)V", "accessTier", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringAccessTier;", "getAccessTier", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringAccessTier;", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "toString", "", "hashCode", "", "equals", "", "other", "", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InvalidObjectState extends S3Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IntelligentTieringAccessTier accessTier;
    private final StorageClass storageClass;

    public /* synthetic */ InvalidObjectState(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private InvalidObjectState(Builder builder) {
        this.accessTier = builder.getAccessTier();
        this.storageClass = builder.getStorageClass();
        getSdkErrorMetadata().getAttributes().set(ServiceErrorMetadata.INSTANCE.getErrorType(), ServiceException.ErrorType.Client);
    }

    public final IntelligentTieringAccessTier getAccessTier() {
        return this.accessTier;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    /* JADX INFO: compiled from: InvalidObjectState.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InvalidObjectState$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/InvalidObjectState;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/InvalidObjectState$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InvalidObjectState invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder("InvalidObjectState(");
        sb.append("accessTier=" + this.accessTier + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        IntelligentTieringAccessTier intelligentTieringAccessTier = this.accessTier;
        int iHashCode = (intelligentTieringAccessTier != null ? intelligentTieringAccessTier.hashCode() : 0) * 31;
        StorageClass storageClass = this.storageClass;
        return iHashCode + (storageClass != null ? storageClass.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        InvalidObjectState invalidObjectState = (InvalidObjectState) other;
        return Intrinsics.areEqual(this.accessTier, invalidObjectState.accessTier) && Intrinsics.areEqual(this.storageClass, invalidObjectState.storageClass);
    }

    public static /* synthetic */ InvalidObjectState copy$default(InvalidObjectState invalidObjectState, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.InvalidObjectState.copy.1
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
        Builder builder = new Builder(invalidObjectState);
        block.invoke(builder);
        return builder.build();
    }

    public final InvalidObjectState copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: InvalidObjectState.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InvalidObjectState$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/InvalidObjectState;", "(Laws/sdk/kotlin/services/s3/model/InvalidObjectState;)V", "accessTier", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringAccessTier;", "getAccessTier", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringAccessTier;", "setAccessTier", "(Laws/sdk/kotlin/services/s3/model/IntelligentTieringAccessTier;)V", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private IntelligentTieringAccessTier accessTier;
        private StorageClass storageClass;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final IntelligentTieringAccessTier getAccessTier() {
            return this.accessTier;
        }

        public final void setAccessTier(IntelligentTieringAccessTier intelligentTieringAccessTier) {
            this.accessTier = intelligentTieringAccessTier;
        }

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(InvalidObjectState x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessTier = x.getAccessTier();
            this.storageClass = x.getStorageClass();
        }

        public final InvalidObjectState build() {
            return new InvalidObjectState(this, null);
        }
    }
}
