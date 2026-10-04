package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: LifecycleRuleAndOperator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0016\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator;", "", "builder", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator$Builder;)V", "objectSizeGreaterThan", "", "getObjectSizeGreaterThan", "()Ljava/lang/Long;", "Ljava/lang/Long;", "objectSizeLessThan", "getObjectSizeLessThan", "prefix", "", "getPrefix", "()Ljava/lang/String;", "tags", "", "Laws/sdk/kotlin/services/s3/model/Tag;", "getTags", "()Ljava/util/List;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRuleAndOperator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long objectSizeGreaterThan;
    private final Long objectSizeLessThan;
    private final String prefix;
    private final List<Tag> tags;

    public /* synthetic */ LifecycleRuleAndOperator(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private LifecycleRuleAndOperator(Builder builder) {
        this.objectSizeGreaterThan = builder.getObjectSizeGreaterThan();
        this.objectSizeLessThan = builder.getObjectSizeLessThan();
        this.prefix = builder.getPrefix();
        this.tags = builder.getTags();
    }

    public final Long getObjectSizeGreaterThan() {
        return this.objectSizeGreaterThan;
    }

    public final Long getObjectSizeLessThan() {
        return this.objectSizeLessThan;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    /* JADX INFO: compiled from: LifecycleRuleAndOperator.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LifecycleRuleAndOperator invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LifecycleRuleAndOperator(");
        sb.append("objectSizeGreaterThan=" + this.objectSizeGreaterThan + AbstractJsonLexerKt.COMMA);
        sb.append("objectSizeLessThan=" + this.objectSizeLessThan + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("tags=" + this.tags);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Long l = this.objectSizeGreaterThan;
        int iHashCode = (l != null ? Long.hashCode(l.longValue()) : 0) * 31;
        Long l2 = this.objectSizeLessThan;
        int iHashCode2 = (iHashCode + (l2 != null ? Long.hashCode(l2.longValue()) : 0)) * 31;
        String str = this.prefix;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<Tag> list = this.tags;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LifecycleRuleAndOperator lifecycleRuleAndOperator = (LifecycleRuleAndOperator) other;
        return Intrinsics.areEqual(this.objectSizeGreaterThan, lifecycleRuleAndOperator.objectSizeGreaterThan) && Intrinsics.areEqual(this.objectSizeLessThan, lifecycleRuleAndOperator.objectSizeLessThan) && Intrinsics.areEqual(this.prefix, lifecycleRuleAndOperator.prefix) && Intrinsics.areEqual(this.tags, lifecycleRuleAndOperator.tags);
    }

    public static /* synthetic */ LifecycleRuleAndOperator copy$default(LifecycleRuleAndOperator lifecycleRuleAndOperator, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.LifecycleRuleAndOperator.copy.1
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
        Builder builder = new Builder(lifecycleRuleAndOperator);
        block.invoke(builder);
        return builder.build();
    }

    public final LifecycleRuleAndOperator copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: LifecycleRuleAndOperator.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0005H\u0001J\r\u0010\u001f\u001a\u00020\u0000H\u0000¢\u0006\u0002\b R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator;", "(Laws/sdk/kotlin/services/s3/model/LifecycleRuleAndOperator;)V", "objectSizeGreaterThan", "", "getObjectSizeGreaterThan", "()Ljava/lang/Long;", "setObjectSizeGreaterThan", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "objectSizeLessThan", "getObjectSizeLessThan", "setObjectSizeLessThan", "prefix", "", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "tags", "", "Laws/sdk/kotlin/services/s3/model/Tag;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Long objectSizeGreaterThan;
        private Long objectSizeLessThan;
        private String prefix;
        private List<Tag> tags;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Long getObjectSizeGreaterThan() {
            return this.objectSizeGreaterThan;
        }

        public final void setObjectSizeGreaterThan(Long l) {
            this.objectSizeGreaterThan = l;
        }

        public final Long getObjectSizeLessThan() {
            return this.objectSizeLessThan;
        }

        public final void setObjectSizeLessThan(Long l) {
            this.objectSizeLessThan = l;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final List<Tag> getTags() {
            return this.tags;
        }

        public final void setTags(List<Tag> list) {
            this.tags = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(LifecycleRuleAndOperator x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.objectSizeGreaterThan = x.getObjectSizeGreaterThan();
            this.objectSizeLessThan = x.getObjectSizeLessThan();
            this.prefix = x.getPrefix();
            this.tags = x.getTags();
        }

        public final LifecycleRuleAndOperator build() {
            return new LifecycleRuleAndOperator(this, null);
        }
    }
}
