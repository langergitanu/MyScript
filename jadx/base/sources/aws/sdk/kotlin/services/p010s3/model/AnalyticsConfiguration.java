package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.StorageClassAnalysis;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AnalyticsConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0012\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration$Builder;)V", "filter", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "id", "", "getId", "()Ljava/lang/String;", "storageClassAnalysis", "Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis;", "getStorageClassAnalysis", "()Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnalyticsConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnalyticsFilter filter;
    private final String id;
    private final StorageClassAnalysis storageClassAnalysis;

    public /* synthetic */ AnalyticsConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AnalyticsConfiguration(Builder builder) {
        this.filter = builder.getFilter();
        String id = builder.getId();
        if (id == null) {
            throw new IllegalArgumentException("A non-null value must be provided for id".toString());
        }
        this.id = id;
        this.storageClassAnalysis = builder.getStorageClassAnalysis();
    }

    public final AnalyticsFilter getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final StorageClassAnalysis getStorageClassAnalysis() {
        return this.storageClassAnalysis;
    }

    /* JADX INFO: compiled from: AnalyticsConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnalyticsConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AnalyticsConfiguration(");
        sb.append("filter=" + this.filter + AbstractJsonLexerKt.COMMA);
        sb.append("id=" + this.id + AbstractJsonLexerKt.COMMA);
        sb.append("storageClassAnalysis=" + this.storageClassAnalysis);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AnalyticsFilter analyticsFilter = this.filter;
        int iHashCode = (((analyticsFilter != null ? analyticsFilter.hashCode() : 0) * 31) + this.id.hashCode()) * 31;
        StorageClassAnalysis storageClassAnalysis = this.storageClassAnalysis;
        return iHashCode + (storageClassAnalysis != null ? storageClassAnalysis.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AnalyticsConfiguration analyticsConfiguration = (AnalyticsConfiguration) other;
        return Intrinsics.areEqual(this.filter, analyticsConfiguration.filter) && Intrinsics.areEqual(this.id, analyticsConfiguration.id) && Intrinsics.areEqual(this.storageClassAnalysis, analyticsConfiguration.storageClassAnalysis);
    }

    public static /* synthetic */ AnalyticsConfiguration copy$default(AnalyticsConfiguration analyticsConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.AnalyticsConfiguration.copy.1
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
        Builder builder = new Builder(analyticsConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final AnalyticsConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: AnalyticsConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0005H\u0001J\u001f\u0010\u0013\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\u0000H\u0000¢\u0006\u0002\b R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "(Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;)V", "filter", "Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "getFilter", "()Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;", "setFilter", "(Laws/sdk/kotlin/services/s3/model/AnalyticsFilter;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "storageClassAnalysis", "Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis;", "getStorageClassAnalysis", "()Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis;", "setStorageClassAnalysis", "(Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/StorageClassAnalysis$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AnalyticsFilter filter;
        private String id;
        private StorageClassAnalysis storageClassAnalysis;

        public final AnalyticsFilter getFilter() {
            return this.filter;
        }

        public final void setFilter(AnalyticsFilter analyticsFilter) {
            this.filter = analyticsFilter;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final StorageClassAnalysis getStorageClassAnalysis() {
            return this.storageClassAnalysis;
        }

        public final void setStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis) {
            this.storageClassAnalysis = storageClassAnalysis;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AnalyticsConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.filter = x.getFilter();
            this.id = x.getId();
            this.storageClassAnalysis = x.getStorageClassAnalysis();
        }

        public final AnalyticsConfiguration build() {
            return new AnalyticsConfiguration(this, null);
        }

        public final void storageClassAnalysis(Function1<? super StorageClassAnalysis.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.storageClassAnalysis = AnalyticsConfigurationKt.awsSdkKotlinServicesS3ModelStorageClassAnalysisDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.id == null) {
                this.id = "";
            }
            return this;
        }
    }
}
