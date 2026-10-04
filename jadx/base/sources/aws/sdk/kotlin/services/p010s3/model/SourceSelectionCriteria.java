package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ReplicaModifications;
import aws.sdk.kotlin.services.p010s3.model.SseKmsEncryptedObjects;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SourceSelectionCriteria.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0015\u001a\u00020\u00002\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "", "builder", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria$Builder;)V", "replicaModifications", "Laws/sdk/kotlin/services/s3/model/ReplicaModifications;", "getReplicaModifications", "()Laws/sdk/kotlin/services/s3/model/ReplicaModifications;", "sseKmsEncryptedObjects", "Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects;", "getSseKmsEncryptedObjects", "()Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SourceSelectionCriteria {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ReplicaModifications replicaModifications;
    private final SseKmsEncryptedObjects sseKmsEncryptedObjects;

    public /* synthetic */ SourceSelectionCriteria(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SourceSelectionCriteria(Builder builder) {
        this.replicaModifications = builder.getReplicaModifications();
        this.sseKmsEncryptedObjects = builder.getSseKmsEncryptedObjects();
    }

    public final ReplicaModifications getReplicaModifications() {
        return this.replicaModifications;
    }

    public final SseKmsEncryptedObjects getSseKmsEncryptedObjects() {
        return this.sseKmsEncryptedObjects;
    }

    /* JADX INFO: compiled from: SourceSelectionCriteria.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SourceSelectionCriteria invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SourceSelectionCriteria(");
        sb.append("replicaModifications=" + this.replicaModifications + AbstractJsonLexerKt.COMMA);
        sb.append("sseKmsEncryptedObjects=" + this.sseKmsEncryptedObjects);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ReplicaModifications replicaModifications = this.replicaModifications;
        int iHashCode = (replicaModifications != null ? replicaModifications.hashCode() : 0) * 31;
        SseKmsEncryptedObjects sseKmsEncryptedObjects = this.sseKmsEncryptedObjects;
        return iHashCode + (sseKmsEncryptedObjects != null ? sseKmsEncryptedObjects.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        SourceSelectionCriteria sourceSelectionCriteria = (SourceSelectionCriteria) other;
        return Intrinsics.areEqual(this.replicaModifications, sourceSelectionCriteria.replicaModifications) && Intrinsics.areEqual(this.sseKmsEncryptedObjects, sourceSelectionCriteria.sseKmsEncryptedObjects);
    }

    public static /* synthetic */ SourceSelectionCriteria copy$default(SourceSelectionCriteria sourceSelectionCriteria, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.SourceSelectionCriteria.copy.1
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
        Builder builder = new Builder(sourceSelectionCriteria);
        block.invoke(builder);
        return builder.build();
    }

    public final SourceSelectionCriteria copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: SourceSelectionCriteria.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0018J\u001f\u0010\r\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0018J\r\u0010\u001a\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "(Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;)V", "replicaModifications", "Laws/sdk/kotlin/services/s3/model/ReplicaModifications;", "getReplicaModifications", "()Laws/sdk/kotlin/services/s3/model/ReplicaModifications;", "setReplicaModifications", "(Laws/sdk/kotlin/services/s3/model/ReplicaModifications;)V", "sseKmsEncryptedObjects", "Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects;", "getSseKmsEncryptedObjects", "()Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects;", "setSseKmsEncryptedObjects", "(Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ReplicaModifications$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/SseKmsEncryptedObjects$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ReplicaModifications replicaModifications;
        private SseKmsEncryptedObjects sseKmsEncryptedObjects;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final ReplicaModifications getReplicaModifications() {
            return this.replicaModifications;
        }

        public final void setReplicaModifications(ReplicaModifications replicaModifications) {
            this.replicaModifications = replicaModifications;
        }

        public final SseKmsEncryptedObjects getSseKmsEncryptedObjects() {
            return this.sseKmsEncryptedObjects;
        }

        public final void setSseKmsEncryptedObjects(SseKmsEncryptedObjects sseKmsEncryptedObjects) {
            this.sseKmsEncryptedObjects = sseKmsEncryptedObjects;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(SourceSelectionCriteria x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.replicaModifications = x.getReplicaModifications();
            this.sseKmsEncryptedObjects = x.getSseKmsEncryptedObjects();
        }

        public final SourceSelectionCriteria build() {
            return new SourceSelectionCriteria(this, null);
        }

        public final void replicaModifications(Function1<? super ReplicaModifications.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.replicaModifications = SourceSelectionCriteriaKt.awsSdkKotlinServicesS3ModelReplicaModificationsDslBuilderRef.invoke(block);
        }

        public final void sseKmsEncryptedObjects(Function1<? super SseKmsEncryptedObjects.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.sseKmsEncryptedObjects = SourceSelectionCriteriaKt.awsSdkKotlinServicesS3ModelSseKmsEncryptedObjectsDslBuilderRef.invoke(block);
        }
    }
}
