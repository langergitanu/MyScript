package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.InventoryDestination;
import aws.sdk.kotlin.services.p010s3.model.InventoryFilter;
import aws.sdk.kotlin.services.p010s3.model.InventoryIncludedObjectVersions;
import aws.sdk.kotlin.services.p010s3.model.InventorySchedule;
import aws.smithy.kotlin.runtime.SdkDsl;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: InventoryConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\"\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010#\u001a\u00020$H\u0096\u0080\u0004J\u0014\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010'\u001a\u00020\u00002\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020*0)¢\u0006\u0002\b+H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0018R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/InventoryConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/InventoryConfiguration$Builder;)V", FirebaseAnalytics.Param.DESTINATION, "Laws/sdk/kotlin/services/s3/model/InventoryDestination;", "getDestination", "()Laws/sdk/kotlin/services/s3/model/InventoryDestination;", "filter", "Laws/sdk/kotlin/services/s3/model/InventoryFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/InventoryFilter;", "id", "", "getId", "()Ljava/lang/String;", "includedObjectVersions", "Laws/sdk/kotlin/services/s3/model/InventoryIncludedObjectVersions;", "getIncludedObjectVersions", "()Laws/sdk/kotlin/services/s3/model/InventoryIncludedObjectVersions;", "isEnabled", "", "()Z", "optionalFields", "", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "getOptionalFields", "()Ljava/util/List;", "schedule", "Laws/sdk/kotlin/services/s3/model/InventorySchedule;", "getSchedule", "()Laws/sdk/kotlin/services/s3/model/InventorySchedule;", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InventoryConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final InventoryDestination destination;
    private final InventoryFilter filter;
    private final String id;
    private final InventoryIncludedObjectVersions includedObjectVersions;
    private final boolean isEnabled;
    private final List<InventoryOptionalField> optionalFields;
    private final InventorySchedule schedule;

    public /* synthetic */ InventoryConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private InventoryConfiguration(Builder builder) {
        this.destination = builder.getDestination();
        this.filter = builder.getFilter();
        String id = builder.getId();
        if (id == null) {
            throw new IllegalArgumentException("A non-null value must be provided for id".toString());
        }
        this.id = id;
        InventoryIncludedObjectVersions includedObjectVersions = builder.getIncludedObjectVersions();
        if (includedObjectVersions == null) {
            throw new IllegalArgumentException("A non-null value must be provided for includedObjectVersions".toString());
        }
        this.includedObjectVersions = includedObjectVersions;
        Boolean isEnabled = builder.getIsEnabled();
        if (isEnabled == null) {
            throw new IllegalArgumentException("A non-null value must be provided for isEnabled".toString());
        }
        this.isEnabled = isEnabled.booleanValue();
        this.optionalFields = builder.getOptionalFields();
        this.schedule = builder.getSchedule();
    }

    public final InventoryDestination getDestination() {
        return this.destination;
    }

    public final InventoryFilter getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final InventoryIncludedObjectVersions getIncludedObjectVersions() {
        return this.includedObjectVersions;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final List<InventoryOptionalField> getOptionalFields() {
        return this.optionalFields;
    }

    public final InventorySchedule getSchedule() {
        return this.schedule;
    }

    /* JADX INFO: compiled from: InventoryConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/InventoryConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/InventoryConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InventoryConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InventoryConfiguration(");
        sb.append("destination=" + this.destination + AbstractJsonLexerKt.COMMA);
        sb.append("filter=" + this.filter + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("includedObjectVersions=" + this.includedObjectVersions + AbstractJsonLexerKt.COMMA);
        sb.append("isEnabled=" + this.isEnabled + AbstractJsonLexerKt.COMMA);
        sb.append("optionalFields=" + this.optionalFields + AbstractJsonLexerKt.COMMA);
        sb.append("schedule=" + this.schedule);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        InventoryDestination inventoryDestination = this.destination;
        int iHashCode = (inventoryDestination != null ? inventoryDestination.hashCode() : 0) * 31;
        InventoryFilter inventoryFilter = this.filter;
        int iHashCode2 = (((((((iHashCode + (inventoryFilter != null ? inventoryFilter.hashCode() : 0)) * 31) + this.id.hashCode()) * 31) + this.includedObjectVersions.hashCode()) * 31) + Boolean.hashCode(this.isEnabled)) * 31;
        List<InventoryOptionalField> list = this.optionalFields;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        InventorySchedule inventorySchedule = this.schedule;
        return iHashCode3 + (inventorySchedule != null ? inventorySchedule.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        InventoryConfiguration inventoryConfiguration = (InventoryConfiguration) other;
        return Intrinsics.areEqual(this.destination, inventoryConfiguration.destination) && Intrinsics.areEqual(this.filter, inventoryConfiguration.filter) && Intrinsics.areEqual(this.id, inventoryConfiguration.id) && Intrinsics.areEqual(this.includedObjectVersions, inventoryConfiguration.includedObjectVersions) && this.isEnabled == inventoryConfiguration.isEnabled && Intrinsics.areEqual(this.optionalFields, inventoryConfiguration.optionalFields) && Intrinsics.areEqual(this.schedule, inventoryConfiguration.schedule);
    }

    public static /* synthetic */ InventoryConfiguration copy$default(InventoryConfiguration inventoryConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.InventoryConfiguration.copy.1
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
        Builder builder = new Builder(inventoryConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final InventoryConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: InventoryConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00102\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u0002032\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020305¢\u0006\u0002\b7J\u001f\u0010\r\u001a\u0002032\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020305¢\u0006\u0002\b7J\u001f\u0010,\u001a\u0002032\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020305¢\u0006\u0002\b7J\r\u0010:\u001a\u00020\u0000H\u0000¢\u0006\u0002\b;R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InventoryConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/InventoryConfiguration;", "(Laws/sdk/kotlin/services/s3/model/InventoryConfiguration;)V", FirebaseAnalytics.Param.DESTINATION, "Laws/sdk/kotlin/services/s3/model/InventoryDestination;", "getDestination", "()Laws/sdk/kotlin/services/s3/model/InventoryDestination;", "setDestination", "(Laws/sdk/kotlin/services/s3/model/InventoryDestination;)V", "filter", "Laws/sdk/kotlin/services/s3/model/InventoryFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/InventoryFilter;", "setFilter", "(Laws/sdk/kotlin/services/s3/model/InventoryFilter;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "includedObjectVersions", "Laws/sdk/kotlin/services/s3/model/InventoryIncludedObjectVersions;", "getIncludedObjectVersions", "()Laws/sdk/kotlin/services/s3/model/InventoryIncludedObjectVersions;", "setIncludedObjectVersions", "(Laws/sdk/kotlin/services/s3/model/InventoryIncludedObjectVersions;)V", "isEnabled", "", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "optionalFields", "", "Laws/sdk/kotlin/services/s3/model/InventoryOptionalField;", "getOptionalFields", "()Ljava/util/List;", "setOptionalFields", "(Ljava/util/List;)V", "schedule", "Laws/sdk/kotlin/services/s3/model/InventorySchedule;", "getSchedule", "()Laws/sdk/kotlin/services/s3/model/InventorySchedule;", "setSchedule", "(Laws/sdk/kotlin/services/s3/model/InventorySchedule;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/InventoryDestination$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/InventoryFilter$Builder;", "Laws/sdk/kotlin/services/s3/model/InventorySchedule$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private InventoryDestination destination;
        private InventoryFilter filter;
        private String id;
        private InventoryIncludedObjectVersions includedObjectVersions;
        private Boolean isEnabled;
        private List<? extends InventoryOptionalField> optionalFields;
        private InventorySchedule schedule;

        public final InventoryDestination getDestination() {
            return this.destination;
        }

        public final void setDestination(InventoryDestination inventoryDestination) {
            this.destination = inventoryDestination;
        }

        public final InventoryFilter getFilter() {
            return this.filter;
        }

        public final void setFilter(InventoryFilter inventoryFilter) {
            this.filter = inventoryFilter;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final InventoryIncludedObjectVersions getIncludedObjectVersions() {
            return this.includedObjectVersions;
        }

        public final void setIncludedObjectVersions(InventoryIncludedObjectVersions inventoryIncludedObjectVersions) {
            this.includedObjectVersions = inventoryIncludedObjectVersions;
        }

        /* JADX INFO: renamed from: isEnabled, reason: from getter */
        public final Boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final void setEnabled(Boolean bool) {
            this.isEnabled = bool;
        }

        public final List<InventoryOptionalField> getOptionalFields() {
            return this.optionalFields;
        }

        public final void setOptionalFields(List<? extends InventoryOptionalField> list) {
            this.optionalFields = list;
        }

        public final InventorySchedule getSchedule() {
            return this.schedule;
        }

        public final void setSchedule(InventorySchedule inventorySchedule) {
            this.schedule = inventorySchedule;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(InventoryConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.destination = x.getDestination();
            this.filter = x.getFilter();
            this.id = x.getId();
            this.includedObjectVersions = x.getIncludedObjectVersions();
            this.isEnabled = Boolean.valueOf(x.getIsEnabled());
            this.optionalFields = x.getOptionalFields();
            this.schedule = x.getSchedule();
        }

        public final InventoryConfiguration build() {
            return new InventoryConfiguration(this, null);
        }

        public final void destination(Function1<? super InventoryDestination.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.destination = InventoryConfigurationKt.awsSdkKotlinServicesS3ModelInventoryDestinationDslBuilderRef.invoke(block);
        }

        public final void filter(Function1<? super InventoryFilter.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.filter = InventoryConfigurationKt.awsSdkKotlinServicesS3ModelInventoryFilterDslBuilderRef.invoke(block);
        }

        public final void schedule(Function1<? super InventorySchedule.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.schedule = InventoryConfigurationKt.awsSdkKotlinServicesS3ModelInventoryScheduleDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.id == null) {
                this.id = "";
            }
            if (this.includedObjectVersions == null) {
                this.includedObjectVersions = new InventoryIncludedObjectVersions.SdkUnknown("no value provided");
            }
            if (this.isEnabled == null) {
                this.isEnabled = false;
            }
            return this;
        }
    }
}
