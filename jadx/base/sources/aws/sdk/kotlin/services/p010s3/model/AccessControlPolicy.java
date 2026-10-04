package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Owner;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AccessControlPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0016\u001a\u00020\u00002\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "", "builder", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/AccessControlPolicy$Builder;)V", "grants", "", "Laws/sdk/kotlin/services/s3/model/Grant;", "getGrants", "()Ljava/util/List;", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccessControlPolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Grant> grants;
    private final Owner owner;

    public /* synthetic */ AccessControlPolicy(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AccessControlPolicy(Builder builder) {
        this.grants = builder.getGrants();
        this.owner = builder.getOwner();
    }

    public final List<Grant> getGrants() {
        return this.grants;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    /* JADX INFO: compiled from: AccessControlPolicy.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AccessControlPolicy$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AccessControlPolicy invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AccessControlPolicy(");
        sb.append("grants=" + this.grants + AbstractJsonLexerKt.COMMA);
        sb.append("owner=" + this.owner);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<Grant> list = this.grants;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Owner owner = this.owner;
        return iHashCode + (owner != null ? owner.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AccessControlPolicy accessControlPolicy = (AccessControlPolicy) other;
        return Intrinsics.areEqual(this.grants, accessControlPolicy.grants) && Intrinsics.areEqual(this.owner, accessControlPolicy.owner);
    }

    public static /* synthetic */ AccessControlPolicy copy$default(AccessControlPolicy accessControlPolicy, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.AccessControlPolicy.copy.1
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
        Builder builder = new Builder(accessControlPolicy);
        block.invoke(builder);
        return builder.build();
    }

    public final AccessControlPolicy copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: AccessControlPolicy.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0005H\u0001J\u001f\u0010\u000e\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001bR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AccessControlPolicy$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;", "(Laws/sdk/kotlin/services/s3/model/AccessControlPolicy;)V", "grants", "", "Laws/sdk/kotlin/services/s3/model/Grant;", "getGrants", "()Ljava/util/List;", "setGrants", "(Ljava/util/List;)V", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "setOwner", "(Laws/sdk/kotlin/services/s3/model/Owner;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Owner$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<Grant> grants;
        private Owner owner;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<Grant> getGrants() {
            return this.grants;
        }

        public final void setGrants(List<Grant> list) {
            this.grants = list;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AccessControlPolicy x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.grants = x.getGrants();
            this.owner = x.getOwner();
        }

        public final AccessControlPolicy build() {
            return new AccessControlPolicy(this, null);
        }

        public final void owner(Function1<? super Owner.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.owner = AccessControlPolicyKt.awsSdkKotlinServicesS3ModelOwnerDslBuilderRef.invoke(block);
        }
    }
}
