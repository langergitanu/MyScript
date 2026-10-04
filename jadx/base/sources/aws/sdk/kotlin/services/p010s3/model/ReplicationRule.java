package aws.sdk.kotlin.services.p010s3.model;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.DeleteMarkerReplication;
import aws.sdk.kotlin.services.p010s3.model.Destination;
import aws.sdk.kotlin.services.p010s3.model.ExistingObjectReplication;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleFilter;
import aws.sdk.kotlin.services.p010s3.model.ReplicationRuleStatus;
import aws.sdk.kotlin.services.p010s3.model.SourceSelectionCriteria;
import aws.smithy.kotlin.runtime.SdkDsl;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: ReplicationRule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u000256B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010+\u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010,\u001a\u00020\u001fH\u0096\u0080\u0004J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00100\u001a\u00020\u00002\u0019\b\u0002\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020302¢\u0006\u0002\b4H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ReplicationRule$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ReplicationRule$Builder;)V", "deleteMarkerReplication", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerReplication;", "getDeleteMarkerReplication", "()Laws/sdk/kotlin/services/s3/model/DeleteMarkerReplication;", FirebaseAnalytics.Param.DESTINATION, "Laws/sdk/kotlin/services/s3/model/Destination;", "getDestination", "()Laws/sdk/kotlin/services/s3/model/Destination;", "existingObjectReplication", "Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication;", "getExistingObjectReplication", "()Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication;", "filter", "Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;", "id", "", "getId", "()Ljava/lang/String;", "prefix", "getPrefix$annotations", "()V", "getPrefix", LogFactory.PRIORITY_KEY, "", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "sourceSelectionCriteria", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "getSourceSelectionCriteria", "()Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/ReplicationRuleStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/ReplicationRuleStatus;", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ReplicationRule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DeleteMarkerReplication deleteMarkerReplication;
    private final Destination destination;
    private final ExistingObjectReplication existingObjectReplication;
    private final ReplicationRuleFilter filter;
    private final String id;
    private final String prefix;
    private final Integer priority;
    private final SourceSelectionCriteria sourceSelectionCriteria;
    private final ReplicationRuleStatus status;

    public /* synthetic */ ReplicationRule(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Deprecated(message = "No longer recommended for use. See AWS API documentation for more details.")
    public static /* synthetic */ void getPrefix$annotations() {
    }

    private ReplicationRule(Builder builder) {
        this.deleteMarkerReplication = builder.getDeleteMarkerReplication();
        this.destination = builder.getDestination();
        this.existingObjectReplication = builder.getExistingObjectReplication();
        this.filter = builder.getFilter();
        this.id = builder.getId();
        this.prefix = builder.getPrefix();
        this.priority = builder.getPriority();
        this.sourceSelectionCriteria = builder.getSourceSelectionCriteria();
        ReplicationRuleStatus status = builder.getStatus();
        if (status == null) {
            throw new IllegalArgumentException("A non-null value must be provided for status".toString());
        }
        this.status = status;
    }

    public final DeleteMarkerReplication getDeleteMarkerReplication() {
        return this.deleteMarkerReplication;
    }

    public final Destination getDestination() {
        return this.destination;
    }

    public final ExistingObjectReplication getExistingObjectReplication() {
        return this.existingObjectReplication;
    }

    public final ReplicationRuleFilter getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final SourceSelectionCriteria getSourceSelectionCriteria() {
        return this.sourceSelectionCriteria;
    }

    public final ReplicationRuleStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: compiled from: ReplicationRule.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationRule$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ReplicationRule$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReplicationRule invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ReplicationRule(");
        sb.append("deleteMarkerReplication=" + this.deleteMarkerReplication + AbstractJsonLexerKt.COMMA);
        sb.append("destination=" + this.destination + AbstractJsonLexerKt.COMMA);
        sb.append("existingObjectReplication=" + this.existingObjectReplication + AbstractJsonLexerKt.COMMA);
        sb.append("filter=" + this.filter + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("priority=" + this.priority + AbstractJsonLexerKt.COMMA);
        sb.append("sourceSelectionCriteria=" + this.sourceSelectionCriteria + AbstractJsonLexerKt.COMMA);
        sb.append("status=" + this.status);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        DeleteMarkerReplication deleteMarkerReplication = this.deleteMarkerReplication;
        int iHashCode = (deleteMarkerReplication != null ? deleteMarkerReplication.hashCode() : 0) * 31;
        Destination destination = this.destination;
        int iHashCode2 = (iHashCode + (destination != null ? destination.hashCode() : 0)) * 31;
        ExistingObjectReplication existingObjectReplication = this.existingObjectReplication;
        int iHashCode3 = (iHashCode2 + (existingObjectReplication != null ? existingObjectReplication.hashCode() : 0)) * 31;
        ReplicationRuleFilter replicationRuleFilter = this.filter;
        int iHashCode4 = (iHashCode3 + (replicationRuleFilter != null ? replicationRuleFilter.hashCode() : 0)) * 31;
        String str = this.id;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.prefix;
        int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.priority;
        int iIntValue = (iHashCode6 + (num != null ? num.intValue() : 0)) * 31;
        SourceSelectionCriteria sourceSelectionCriteria = this.sourceSelectionCriteria;
        return ((iIntValue + (sourceSelectionCriteria != null ? sourceSelectionCriteria.hashCode() : 0)) * 31) + this.status.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ReplicationRule replicationRule = (ReplicationRule) other;
        return Intrinsics.areEqual(this.deleteMarkerReplication, replicationRule.deleteMarkerReplication) && Intrinsics.areEqual(this.destination, replicationRule.destination) && Intrinsics.areEqual(this.existingObjectReplication, replicationRule.existingObjectReplication) && Intrinsics.areEqual(this.filter, replicationRule.filter) && Intrinsics.areEqual(this.id, replicationRule.id) && Intrinsics.areEqual(this.prefix, replicationRule.prefix) && Intrinsics.areEqual(this.priority, replicationRule.priority) && Intrinsics.areEqual(this.sourceSelectionCriteria, replicationRule.sourceSelectionCriteria) && Intrinsics.areEqual(this.status, replicationRule.status);
    }

    public static /* synthetic */ ReplicationRule copy$default(ReplicationRule replicationRule, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ReplicationRule.copy.1
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
        Builder builder = new Builder(replicationRule);
        block.invoke(builder);
        return builder.build();
    }

    public final ReplicationRule copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ReplicationRule.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010<\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\u001f\u0010\r\u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\u001f\u0010\u0013\u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\u001f\u0010\u0019\u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\u001f\u00100\u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001e\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006H"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ReplicationRule$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ReplicationRule;", "(Laws/sdk/kotlin/services/s3/model/ReplicationRule;)V", "deleteMarkerReplication", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerReplication;", "getDeleteMarkerReplication", "()Laws/sdk/kotlin/services/s3/model/DeleteMarkerReplication;", "setDeleteMarkerReplication", "(Laws/sdk/kotlin/services/s3/model/DeleteMarkerReplication;)V", FirebaseAnalytics.Param.DESTINATION, "Laws/sdk/kotlin/services/s3/model/Destination;", "getDestination", "()Laws/sdk/kotlin/services/s3/model/Destination;", "setDestination", "(Laws/sdk/kotlin/services/s3/model/Destination;)V", "existingObjectReplication", "Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication;", "getExistingObjectReplication", "()Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication;", "setExistingObjectReplication", "(Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication;)V", "filter", "Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;", "setFilter", "(Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "prefix", "getPrefix$annotations", "getPrefix", "setPrefix", LogFactory.PRIORITY_KEY, "", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sourceSelectionCriteria", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "getSourceSelectionCriteria", "()Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;", "setSourceSelectionCriteria", "(Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria;)V", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/ReplicationRuleStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/ReplicationRuleStatus;", "setStatus", "(Laws/sdk/kotlin/services/s3/model/ReplicationRuleStatus;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerReplication$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/Destination$Builder;", "Laws/sdk/kotlin/services/s3/model/ExistingObjectReplication$Builder;", "Laws/sdk/kotlin/services/s3/model/ReplicationRuleFilter$Builder;", "Laws/sdk/kotlin/services/s3/model/SourceSelectionCriteria$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private DeleteMarkerReplication deleteMarkerReplication;
        private Destination destination;
        private ExistingObjectReplication existingObjectReplication;
        private ReplicationRuleFilter filter;
        private String id;
        private String prefix;
        private Integer priority;
        private SourceSelectionCriteria sourceSelectionCriteria;
        private ReplicationRuleStatus status;

        @Deprecated(message = "No longer recommended for use. See AWS API documentation for more details.")
        public static /* synthetic */ void getPrefix$annotations() {
        }

        public final DeleteMarkerReplication getDeleteMarkerReplication() {
            return this.deleteMarkerReplication;
        }

        public final void setDeleteMarkerReplication(DeleteMarkerReplication deleteMarkerReplication) {
            this.deleteMarkerReplication = deleteMarkerReplication;
        }

        public final Destination getDestination() {
            return this.destination;
        }

        public final void setDestination(Destination destination) {
            this.destination = destination;
        }

        public final ExistingObjectReplication getExistingObjectReplication() {
            return this.existingObjectReplication;
        }

        public final void setExistingObjectReplication(ExistingObjectReplication existingObjectReplication) {
            this.existingObjectReplication = existingObjectReplication;
        }

        public final ReplicationRuleFilter getFilter() {
            return this.filter;
        }

        public final void setFilter(ReplicationRuleFilter replicationRuleFilter) {
            this.filter = replicationRuleFilter;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final Integer getPriority() {
            return this.priority;
        }

        public final void setPriority(Integer num) {
            this.priority = num;
        }

        public final SourceSelectionCriteria getSourceSelectionCriteria() {
            return this.sourceSelectionCriteria;
        }

        public final void setSourceSelectionCriteria(SourceSelectionCriteria sourceSelectionCriteria) {
            this.sourceSelectionCriteria = sourceSelectionCriteria;
        }

        public final ReplicationRuleStatus getStatus() {
            return this.status;
        }

        public final void setStatus(ReplicationRuleStatus replicationRuleStatus) {
            this.status = replicationRuleStatus;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ReplicationRule x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.deleteMarkerReplication = x.getDeleteMarkerReplication();
            this.destination = x.getDestination();
            this.existingObjectReplication = x.getExistingObjectReplication();
            this.filter = x.getFilter();
            this.id = x.getId();
            this.prefix = x.getPrefix();
            this.priority = x.getPriority();
            this.sourceSelectionCriteria = x.getSourceSelectionCriteria();
            this.status = x.getStatus();
        }

        public final ReplicationRule build() {
            return new ReplicationRule(this, null);
        }

        public final void deleteMarkerReplication(Function1<? super DeleteMarkerReplication.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.deleteMarkerReplication = ReplicationRuleKt.awsSdkKotlinServicesS3ModelDeleteMarkerReplicationDslBuilderRef.invoke(block);
        }

        public final void destination(Function1<? super Destination.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.destination = ReplicationRuleKt.awsSdkKotlinServicesS3ModelDestinationDslBuilderRef.invoke(block);
        }

        public final void existingObjectReplication(Function1<? super ExistingObjectReplication.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.existingObjectReplication = ReplicationRuleKt.f504xea2ae0c0.invoke(block);
        }

        public final void filter(Function1<? super ReplicationRuleFilter.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.filter = ReplicationRuleKt.awsSdkKotlinServicesS3ModelReplicationRuleFilterDslBuilderRef.invoke(block);
        }

        public final void sourceSelectionCriteria(Function1<? super SourceSelectionCriteria.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.sourceSelectionCriteria = ReplicationRuleKt.awsSdkKotlinServicesS3ModelSourceSelectionCriteriaDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.status == null) {
                this.status = new ReplicationRuleStatus.SdkUnknown("no value provided");
            }
            return this;
        }
    }
}
