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

/* JADX INFO: compiled from: ReplicationConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000f\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0015\u001a\u00020\u00002\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019H\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration$Builder;)V", "role", "", "getRole", "()Ljava/lang/String;", "rules", "", "Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "getRules", "()Ljava/util/List;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ReplicationConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String role;
    private final List<ReplicationRule> rules;

    public /* synthetic */ ReplicationConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ReplicationConfiguration(Builder builder) {
        String role = builder.getRole();
        if (role == null) {
            throw new IllegalArgumentException("A non-null value must be provided for role".toString());
        }
        this.role = role;
        List<ReplicationRule> rules = builder.getRules();
        if (rules == null) {
            throw new IllegalArgumentException("A non-null value must be provided for rules".toString());
        }
        this.rules = rules;
    }

    public final String getRole() {
        return this.role;
    }

    public final List<ReplicationRule> getRules() {
        return this.rules;
    }

    /* JADX INFO: compiled from: ReplicationConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReplicationConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ReplicationConfiguration(");
        sb.append("role=" + this.role + AbstractJsonLexerKt.COMMA);
        sb.append("rules=" + this.rules);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        return (this.role.hashCode() * 31) + this.rules.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ReplicationConfiguration replicationConfiguration = (ReplicationConfiguration) other;
        return Intrinsics.areEqual(this.role, replicationConfiguration.role) && Intrinsics.areEqual(this.rules, replicationConfiguration.rules);
    }

    public static /* synthetic */ ReplicationConfiguration copy$default(ReplicationConfiguration replicationConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ReplicationConfiguration.copy.1
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
        Builder builder = new Builder(replicationConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final ReplicationConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ReplicationConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0005H\u0001J\r\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration;", "(Laws/sdk/kotlin/services/s3/model/ReplicationConfiguration;)V", "role", "", "getRole", "()Ljava/lang/String;", "setRole", "(Ljava/lang/String;)V", "rules", "", "Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String role;
        private List<ReplicationRule> rules;

        public final String getRole() {
            return this.role;
        }

        public final void setRole(String str) {
            this.role = str;
        }

        public final List<ReplicationRule> getRules() {
            return this.rules;
        }

        public final void setRules(List<ReplicationRule> list) {
            this.rules = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ReplicationConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.role = x.getRole();
            this.rules = x.getRules();
        }

        public final ReplicationConfiguration build() {
            return new ReplicationConfiguration(this, null);
        }

        public final Builder correctErrors$s3() {
            if (this.role == null) {
                this.role = "";
            }
            if (this.rules == null) {
                this.rules = CollectionsKt.emptyList();
            }
            return this;
        }
    }
}
