package aws.sdk.kotlin.services.p010s3.model;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.AbortIncompleteMultipartUpload;
import aws.sdk.kotlin.services.p010s3.model.ExpirationStatus;
import aws.sdk.kotlin.services.p010s3.model.LifecycleExpiration;
import aws.sdk.kotlin.services.p010s3.model.LifecycleRuleFilter;
import aws.sdk.kotlin.services.p010s3.model.NoncurrentVersionExpiration;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: LifecycleRule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u000256B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010*\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010+\u001a\u00020,H\u0096\u0080\u0004J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00100\u001a\u00020\u00002\u0019\b\u0002\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020302¢\u0006\u0002\b4H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0015R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "", "builder", "Laws/sdk/kotlin/services/s3/model/LifecycleRule$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/LifecycleRule$Builder;)V", "abortIncompleteMultipartUpload", "Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload;", "getAbortIncompleteMultipartUpload", "()Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload;", "expiration", "Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;", "getExpiration", "()Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;", "filter", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;", "id", "", "getId", "()Ljava/lang/String;", "noncurrentVersionExpiration", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration;", "getNoncurrentVersionExpiration", "()Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration;", "noncurrentVersionTransitions", "", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;", "getNoncurrentVersionTransitions", "()Ljava/util/List;", "prefix", "getPrefix$annotations", "()V", "getPrefix", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/ExpirationStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/ExpirationStatus;", "transitions", "Laws/sdk/kotlin/services/s3/model/Transition;", "getTransitions", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LifecycleRule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
    private final LifecycleExpiration expiration;
    private final LifecycleRuleFilter filter;
    private final String id;
    private final NoncurrentVersionExpiration noncurrentVersionExpiration;
    private final List<NoncurrentVersionTransition> noncurrentVersionTransitions;
    private final String prefix;
    private final ExpirationStatus status;
    private final List<Transition> transitions;

    public /* synthetic */ LifecycleRule(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Deprecated(message = "No longer recommended for use. See AWS API documentation for more details.")
    public static /* synthetic */ void getPrefix$annotations() {
    }

    private LifecycleRule(Builder builder) {
        this.abortIncompleteMultipartUpload = builder.getAbortIncompleteMultipartUpload();
        this.expiration = builder.getExpiration();
        this.filter = builder.getFilter();
        this.id = builder.getId();
        this.noncurrentVersionExpiration = builder.getNoncurrentVersionExpiration();
        this.noncurrentVersionTransitions = builder.getNoncurrentVersionTransitions();
        this.prefix = builder.getPrefix();
        ExpirationStatus status = builder.getStatus();
        if (status == null) {
            throw new IllegalArgumentException("A non-null value must be provided for status".toString());
        }
        this.status = status;
        this.transitions = builder.getTransitions();
    }

    public final AbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
        return this.abortIncompleteMultipartUpload;
    }

    public final LifecycleExpiration getExpiration() {
        return this.expiration;
    }

    public final LifecycleRuleFilter getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final NoncurrentVersionExpiration getNoncurrentVersionExpiration() {
        return this.noncurrentVersionExpiration;
    }

    public final List<NoncurrentVersionTransition> getNoncurrentVersionTransitions() {
        return this.noncurrentVersionTransitions;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final ExpirationStatus getStatus() {
        return this.status;
    }

    public final List<Transition> getTransitions() {
        return this.transitions;
    }

    /* JADX INFO: compiled from: LifecycleRule.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LifecycleRule$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/LifecycleRule$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LifecycleRule invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LifecycleRule(");
        sb.append("abortIncompleteMultipartUpload=" + this.abortIncompleteMultipartUpload + AbstractJsonLexerKt.COMMA);
        sb.append("expiration=" + this.expiration + AbstractJsonLexerKt.COMMA);
        sb.append("filter=" + this.filter + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("noncurrentVersionExpiration=" + this.noncurrentVersionExpiration + AbstractJsonLexerKt.COMMA);
        sb.append("noncurrentVersionTransitions=" + this.noncurrentVersionTransitions + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("status=" + this.status + AbstractJsonLexerKt.COMMA);
        sb.append("transitions=" + this.transitions);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AbortIncompleteMultipartUpload abortIncompleteMultipartUpload = this.abortIncompleteMultipartUpload;
        int iHashCode = (abortIncompleteMultipartUpload != null ? abortIncompleteMultipartUpload.hashCode() : 0) * 31;
        LifecycleExpiration lifecycleExpiration = this.expiration;
        int iHashCode2 = (iHashCode + (lifecycleExpiration != null ? lifecycleExpiration.hashCode() : 0)) * 31;
        LifecycleRuleFilter lifecycleRuleFilter = this.filter;
        int iHashCode3 = (iHashCode2 + (lifecycleRuleFilter != null ? lifecycleRuleFilter.hashCode() : 0)) * 31;
        String str = this.id;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        NoncurrentVersionExpiration noncurrentVersionExpiration = this.noncurrentVersionExpiration;
        int iHashCode5 = (iHashCode4 + (noncurrentVersionExpiration != null ? noncurrentVersionExpiration.hashCode() : 0)) * 31;
        List<NoncurrentVersionTransition> list = this.noncurrentVersionTransitions;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.prefix;
        int iHashCode7 = (((iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.status.hashCode()) * 31;
        List<Transition> list2 = this.transitions;
        return iHashCode7 + (list2 != null ? list2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LifecycleRule lifecycleRule = (LifecycleRule) other;
        return Intrinsics.areEqual(this.abortIncompleteMultipartUpload, lifecycleRule.abortIncompleteMultipartUpload) && Intrinsics.areEqual(this.expiration, lifecycleRule.expiration) && Intrinsics.areEqual(this.filter, lifecycleRule.filter) && Intrinsics.areEqual(this.id, lifecycleRule.id) && Intrinsics.areEqual(this.noncurrentVersionExpiration, lifecycleRule.noncurrentVersionExpiration) && Intrinsics.areEqual(this.noncurrentVersionTransitions, lifecycleRule.noncurrentVersionTransitions) && Intrinsics.areEqual(this.prefix, lifecycleRule.prefix) && Intrinsics.areEqual(this.status, lifecycleRule.status) && Intrinsics.areEqual(this.transitions, lifecycleRule.transitions);
    }

    public static /* synthetic */ LifecycleRule copy$default(LifecycleRule lifecycleRule, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.LifecycleRule.copy.1
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
        Builder builder = new Builder(lifecycleRule);
        block.invoke(builder);
        return builder.build();
    }

    public final LifecycleRule copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: LifecycleRule.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010:\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020;2\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020;0=¢\u0006\u0002\b?J\u001f\u0010\r\u001a\u00020;2\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020;0=¢\u0006\u0002\b?J\u001f\u0010\u0013\u001a\u00020;2\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020;0=¢\u0006\u0002\b?J\u001f\u0010\u001f\u001a\u00020;2\u0017\u0010<\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020;0=¢\u0006\u0002\b?J\r\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0002\bDR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R&\u0010,\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010\u001eR\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+¨\u0006E"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LifecycleRule$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "(Laws/sdk/kotlin/services/s3/model/LifecycleRule;)V", "abortIncompleteMultipartUpload", "Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload;", "getAbortIncompleteMultipartUpload", "()Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload;", "setAbortIncompleteMultipartUpload", "(Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload;)V", "expiration", "Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;", "getExpiration", "()Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;", "setExpiration", "(Laws/sdk/kotlin/services/s3/model/LifecycleExpiration;)V", "filter", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;", "setFilter", "(Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "noncurrentVersionExpiration", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration;", "getNoncurrentVersionExpiration", "()Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration;", "setNoncurrentVersionExpiration", "(Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration;)V", "noncurrentVersionTransitions", "", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;", "getNoncurrentVersionTransitions", "()Ljava/util/List;", "setNoncurrentVersionTransitions", "(Ljava/util/List;)V", "prefix", "getPrefix$annotations", "getPrefix", "setPrefix", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/ExpirationStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/ExpirationStatus;", "setStatus", "(Laws/sdk/kotlin/services/s3/model/ExpirationStatus;)V", "transitions", "Laws/sdk/kotlin/services/s3/model/Transition;", "getTransitions", "setTransitions", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/AbortIncompleteMultipartUpload$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/LifecycleExpiration$Builder;", "Laws/sdk/kotlin/services/s3/model/LifecycleRuleFilter$Builder;", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionExpiration$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
        private LifecycleExpiration expiration;
        private LifecycleRuleFilter filter;
        private String id;
        private NoncurrentVersionExpiration noncurrentVersionExpiration;
        private List<NoncurrentVersionTransition> noncurrentVersionTransitions;
        private String prefix;
        private ExpirationStatus status;
        private List<Transition> transitions;

        @Deprecated(message = "No longer recommended for use. See AWS API documentation for more details.")
        public static /* synthetic */ void getPrefix$annotations() {
        }

        public final AbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
            return this.abortIncompleteMultipartUpload;
        }

        public final void setAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload) {
            this.abortIncompleteMultipartUpload = abortIncompleteMultipartUpload;
        }

        public final LifecycleExpiration getExpiration() {
            return this.expiration;
        }

        public final void setExpiration(LifecycleExpiration lifecycleExpiration) {
            this.expiration = lifecycleExpiration;
        }

        public final LifecycleRuleFilter getFilter() {
            return this.filter;
        }

        public final void setFilter(LifecycleRuleFilter lifecycleRuleFilter) {
            this.filter = lifecycleRuleFilter;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final NoncurrentVersionExpiration getNoncurrentVersionExpiration() {
            return this.noncurrentVersionExpiration;
        }

        public final void setNoncurrentVersionExpiration(NoncurrentVersionExpiration noncurrentVersionExpiration) {
            this.noncurrentVersionExpiration = noncurrentVersionExpiration;
        }

        public final List<NoncurrentVersionTransition> getNoncurrentVersionTransitions() {
            return this.noncurrentVersionTransitions;
        }

        public final void setNoncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
            this.noncurrentVersionTransitions = list;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final ExpirationStatus getStatus() {
            return this.status;
        }

        public final void setStatus(ExpirationStatus expirationStatus) {
            this.status = expirationStatus;
        }

        public final List<Transition> getTransitions() {
            return this.transitions;
        }

        public final void setTransitions(List<Transition> list) {
            this.transitions = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(LifecycleRule x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.abortIncompleteMultipartUpload = x.getAbortIncompleteMultipartUpload();
            this.expiration = x.getExpiration();
            this.filter = x.getFilter();
            this.id = x.getId();
            this.noncurrentVersionExpiration = x.getNoncurrentVersionExpiration();
            this.noncurrentVersionTransitions = x.getNoncurrentVersionTransitions();
            this.prefix = x.getPrefix();
            this.status = x.getStatus();
            this.transitions = x.getTransitions();
        }

        public final LifecycleRule build() {
            return new LifecycleRule(this, null);
        }

        public final void abortIncompleteMultipartUpload(Function1<? super AbortIncompleteMultipartUpload.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.abortIncompleteMultipartUpload = LifecycleRuleKt.f471x891dd9e9.invoke(block);
        }

        public final void expiration(Function1<? super LifecycleExpiration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.expiration = LifecycleRuleKt.awsSdkKotlinServicesS3ModelLifecycleExpirationDslBuilderRef.invoke(block);
        }

        public final void filter(Function1<? super LifecycleRuleFilter.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.filter = LifecycleRuleKt.awsSdkKotlinServicesS3ModelLifecycleRuleFilterDslBuilderRef.invoke(block);
        }

        public final void noncurrentVersionExpiration(Function1<? super NoncurrentVersionExpiration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.noncurrentVersionExpiration = LifecycleRuleKt.f472xd29de9e7.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.status == null) {
                this.status = new ExpirationStatus.SdkUnknown("no value provided");
            }
            return this;
        }
    }
}
