package aws.sdk.kotlin.services.p010s3.model;

import androidx.core.app.NotificationCompat;
import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringFilter;
import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringStatus;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: IntelligentTieringConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0017\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001d\u001a\u00020\u00002\u0019\b\u0002\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration$Builder;)V", "filter", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringFilter;", "id", "", "getId", "()Ljava/lang/String;", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/IntelligentTieringStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringStatus;", "tierings", "", "Laws/sdk/kotlin/services/s3/model/Tiering;", "getTierings", "()Ljava/util/List;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IntelligentTieringConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IntelligentTieringFilter filter;
    private final String id;
    private final IntelligentTieringStatus status;
    private final List<Tiering> tierings;

    public /* synthetic */ IntelligentTieringConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private IntelligentTieringConfiguration(Builder builder) {
        this.filter = builder.getFilter();
        String id = builder.getId();
        if (id == null) {
            throw new IllegalArgumentException("A non-null value must be provided for id".toString());
        }
        this.id = id;
        IntelligentTieringStatus status = builder.getStatus();
        if (status == null) {
            throw new IllegalArgumentException("A non-null value must be provided for status".toString());
        }
        this.status = status;
        List<Tiering> tierings = builder.getTierings();
        if (tierings == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tierings".toString());
        }
        this.tierings = tierings;
    }

    public final IntelligentTieringFilter getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final IntelligentTieringStatus getStatus() {
        return this.status;
    }

    public final List<Tiering> getTierings() {
        return this.tierings;
    }

    /* JADX INFO: compiled from: IntelligentTieringConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IntelligentTieringConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IntelligentTieringConfiguration(");
        sb.append("filter=" + this.filter + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("status=" + this.status + AbstractJsonLexerKt.COMMA);
        sb.append("tierings=" + this.tierings);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        IntelligentTieringFilter intelligentTieringFilter = this.filter;
        return ((((((intelligentTieringFilter != null ? intelligentTieringFilter.hashCode() : 0) * 31) + this.id.hashCode()) * 31) + this.status.hashCode()) * 31) + this.tierings.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        IntelligentTieringConfiguration intelligentTieringConfiguration = (IntelligentTieringConfiguration) other;
        return Intrinsics.areEqual(this.filter, intelligentTieringConfiguration.filter) && Intrinsics.areEqual(this.id, intelligentTieringConfiguration.id) && Intrinsics.areEqual(this.status, intelligentTieringConfiguration.status) && Intrinsics.areEqual(this.tierings, intelligentTieringConfiguration.tierings);
    }

    public static /* synthetic */ IntelligentTieringConfiguration copy$default(IntelligentTieringConfiguration intelligentTieringConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.IntelligentTieringConfiguration.copy.1
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
        Builder builder = new Builder(intelligentTieringConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final IntelligentTieringConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: IntelligentTieringConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0002\b'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "(Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;)V", "filter", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringFilter;", "setFilter", "(Laws/sdk/kotlin/services/s3/model/IntelligentTieringFilter;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_STATUS, "Laws/sdk/kotlin/services/s3/model/IntelligentTieringStatus;", "getStatus", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringStatus;", "setStatus", "(Laws/sdk/kotlin/services/s3/model/IntelligentTieringStatus;)V", "tierings", "", "Laws/sdk/kotlin/services/s3/model/Tiering;", "getTierings", "()Ljava/util/List;", "setTierings", "(Ljava/util/List;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringFilter$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private IntelligentTieringFilter filter;
        private String id;
        private IntelligentTieringStatus status;
        private List<Tiering> tierings;

        public final IntelligentTieringFilter getFilter() {
            return this.filter;
        }

        public final void setFilter(IntelligentTieringFilter intelligentTieringFilter) {
            this.filter = intelligentTieringFilter;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final IntelligentTieringStatus getStatus() {
            return this.status;
        }

        public final void setStatus(IntelligentTieringStatus intelligentTieringStatus) {
            this.status = intelligentTieringStatus;
        }

        public final List<Tiering> getTierings() {
            return this.tierings;
        }

        public final void setTierings(List<Tiering> list) {
            this.tierings = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(IntelligentTieringConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.filter = x.getFilter();
            this.id = x.getId();
            this.status = x.getStatus();
            this.tierings = x.getTierings();
        }

        public final IntelligentTieringConfiguration build() {
            return new IntelligentTieringConfiguration(this, null);
        }

        public final void filter(Function1<? super IntelligentTieringFilter.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.filter = IntelligentTieringConfigurationKt.awsSdkKotlinServicesS3ModelIntelligentTieringFilterDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.id == null) {
                this.id = "";
            }
            if (this.status == null) {
                this.status = new IntelligentTieringStatus.SdkUnknown("no value provided");
            }
            if (this.tierings == null) {
                this.tierings = CollectionsKt.emptyList();
            }
            return this;
        }
    }
}
