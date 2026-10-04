package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Delete.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\u0014\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0016\u001a\u00020\u00002\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0086\bø\u0001\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Delete;", "", "builder", "Laws/sdk/kotlin/services/s3/model/Delete$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Delete$Builder;)V", "objects", "", "Laws/sdk/kotlin/services/s3/model/ObjectIdentifier;", "getObjects", "()Ljava/util/List;", "quiet", "", "getQuiet", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toString", "", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Delete {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ObjectIdentifier> objects;
    private final Boolean quiet;

    public /* synthetic */ Delete(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Delete(Builder builder) {
        List<ObjectIdentifier> objects = builder.getObjects();
        if (objects == null) {
            throw new IllegalArgumentException("A non-null value must be provided for objects".toString());
        }
        this.objects = objects;
        this.quiet = builder.getQuiet();
    }

    public final List<ObjectIdentifier> getObjects() {
        return this.objects;
    }

    public final Boolean getQuiet() {
        return this.quiet;
    }

    /* JADX INFO: compiled from: Delete.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Delete$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/Delete;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Delete$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Delete invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Delete(");
        sb.append("objects=" + this.objects + AbstractJsonLexerKt.COMMA);
        sb.append("quiet=" + this.quiet);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = this.objects.hashCode() * 31;
        Boolean bool = this.quiet;
        return iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Delete delete = (Delete) other;
        return Intrinsics.areEqual(this.objects, delete.objects) && Intrinsics.areEqual(this.quiet, delete.quiet);
    }

    public static /* synthetic */ Delete copy$default(Delete delete, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.Delete.copy.1
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
        Builder builder = new Builder(delete);
        block.invoke(builder);
        return builder.build();
    }

    public final Delete copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: Delete.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0005H\u0001J\r\u0010\u0016\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0017R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Delete$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/Delete;", "(Laws/sdk/kotlin/services/s3/model/Delete;)V", "objects", "", "Laws/sdk/kotlin/services/s3/model/ObjectIdentifier;", "getObjects", "()Ljava/util/List;", "setObjects", "(Ljava/util/List;)V", "quiet", "", "getQuiet", "()Ljava/lang/Boolean;", "setQuiet", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<ObjectIdentifier> objects;
        private Boolean quiet;

        public final List<ObjectIdentifier> getObjects() {
            return this.objects;
        }

        public final void setObjects(List<ObjectIdentifier> list) {
            this.objects = list;
        }

        public final Boolean getQuiet() {
            return this.quiet;
        }

        public final void setQuiet(Boolean bool) {
            this.quiet = bool;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Delete x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.objects = x.getObjects();
            this.quiet = x.getQuiet();
        }

        public final Delete build() {
            return new Delete(this, null);
        }

        public final Builder correctErrors$s3() {
            if (this.objects == null) {
                this.objects = CollectionsKt.emptyList();
            }
            return this;
        }
    }
}
