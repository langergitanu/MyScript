package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ErrorDocument;
import aws.sdk.kotlin.services.p010s3.model.IndexDocument;
import aws.sdk.kotlin.services.p010s3.model.RedirectAllRequestsTo;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: WebsiteConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001e\u001a\u00020\u00002\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration$Builder;)V", "errorDocument", "Laws/sdk/kotlin/services/s3/model/ErrorDocument;", "getErrorDocument", "()Laws/sdk/kotlin/services/s3/model/ErrorDocument;", "indexDocument", "Laws/sdk/kotlin/services/s3/model/IndexDocument;", "getIndexDocument", "()Laws/sdk/kotlin/services/s3/model/IndexDocument;", "redirectAllRequestsTo", "Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo;", "getRedirectAllRequestsTo", "()Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo;", "routingRules", "", "Laws/sdk/kotlin/services/s3/model/RoutingRule;", "getRoutingRules", "()Ljava/util/List;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WebsiteConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorDocument errorDocument;
    private final IndexDocument indexDocument;
    private final RedirectAllRequestsTo redirectAllRequestsTo;
    private final List<RoutingRule> routingRules;

    public /* synthetic */ WebsiteConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private WebsiteConfiguration(Builder builder) {
        this.errorDocument = builder.getErrorDocument();
        this.indexDocument = builder.getIndexDocument();
        this.redirectAllRequestsTo = builder.getRedirectAllRequestsTo();
        this.routingRules = builder.getRoutingRules();
    }

    public final ErrorDocument getErrorDocument() {
        return this.errorDocument;
    }

    public final IndexDocument getIndexDocument() {
        return this.indexDocument;
    }

    public final RedirectAllRequestsTo getRedirectAllRequestsTo() {
        return this.redirectAllRequestsTo;
    }

    public final List<RoutingRule> getRoutingRules() {
        return this.routingRules;
    }

    /* JADX INFO: compiled from: WebsiteConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebsiteConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WebsiteConfiguration(");
        sb.append("errorDocument=" + this.errorDocument + AbstractJsonLexerKt.COMMA);
        sb.append("indexDocument=" + this.indexDocument + AbstractJsonLexerKt.COMMA);
        sb.append("redirectAllRequestsTo=" + this.redirectAllRequestsTo + AbstractJsonLexerKt.COMMA);
        sb.append("routingRules=" + this.routingRules);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ErrorDocument errorDocument = this.errorDocument;
        int iHashCode = (errorDocument != null ? errorDocument.hashCode() : 0) * 31;
        IndexDocument indexDocument = this.indexDocument;
        int iHashCode2 = (iHashCode + (indexDocument != null ? indexDocument.hashCode() : 0)) * 31;
        RedirectAllRequestsTo redirectAllRequestsTo = this.redirectAllRequestsTo;
        int iHashCode3 = (iHashCode2 + (redirectAllRequestsTo != null ? redirectAllRequestsTo.hashCode() : 0)) * 31;
        List<RoutingRule> list = this.routingRules;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        WebsiteConfiguration websiteConfiguration = (WebsiteConfiguration) other;
        return Intrinsics.areEqual(this.errorDocument, websiteConfiguration.errorDocument) && Intrinsics.areEqual(this.indexDocument, websiteConfiguration.indexDocument) && Intrinsics.areEqual(this.redirectAllRequestsTo, websiteConfiguration.redirectAllRequestsTo) && Intrinsics.areEqual(this.routingRules, websiteConfiguration.routingRules);
    }

    public static /* synthetic */ WebsiteConfiguration copy$default(WebsiteConfiguration websiteConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.WebsiteConfiguration.copy.1
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
        Builder builder = new Builder(websiteConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final WebsiteConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: WebsiteConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\u001f\u0010\r\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\u001f\u0010\u0013\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006*"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration;", "(Laws/sdk/kotlin/services/s3/model/WebsiteConfiguration;)V", "errorDocument", "Laws/sdk/kotlin/services/s3/model/ErrorDocument;", "getErrorDocument", "()Laws/sdk/kotlin/services/s3/model/ErrorDocument;", "setErrorDocument", "(Laws/sdk/kotlin/services/s3/model/ErrorDocument;)V", "indexDocument", "Laws/sdk/kotlin/services/s3/model/IndexDocument;", "getIndexDocument", "()Laws/sdk/kotlin/services/s3/model/IndexDocument;", "setIndexDocument", "(Laws/sdk/kotlin/services/s3/model/IndexDocument;)V", "redirectAllRequestsTo", "Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo;", "getRedirectAllRequestsTo", "()Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo;", "setRedirectAllRequestsTo", "(Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo;)V", "routingRules", "", "Laws/sdk/kotlin/services/s3/model/RoutingRule;", "getRoutingRules", "()Ljava/util/List;", "setRoutingRules", "(Ljava/util/List;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ErrorDocument$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/IndexDocument$Builder;", "Laws/sdk/kotlin/services/s3/model/RedirectAllRequestsTo$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ErrorDocument errorDocument;
        private IndexDocument indexDocument;
        private RedirectAllRequestsTo redirectAllRequestsTo;
        private List<RoutingRule> routingRules;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final ErrorDocument getErrorDocument() {
            return this.errorDocument;
        }

        public final void setErrorDocument(ErrorDocument errorDocument) {
            this.errorDocument = errorDocument;
        }

        public final IndexDocument getIndexDocument() {
            return this.indexDocument;
        }

        public final void setIndexDocument(IndexDocument indexDocument) {
            this.indexDocument = indexDocument;
        }

        public final RedirectAllRequestsTo getRedirectAllRequestsTo() {
            return this.redirectAllRequestsTo;
        }

        public final void setRedirectAllRequestsTo(RedirectAllRequestsTo redirectAllRequestsTo) {
            this.redirectAllRequestsTo = redirectAllRequestsTo;
        }

        public final List<RoutingRule> getRoutingRules() {
            return this.routingRules;
        }

        public final void setRoutingRules(List<RoutingRule> list) {
            this.routingRules = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(WebsiteConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.errorDocument = x.getErrorDocument();
            this.indexDocument = x.getIndexDocument();
            this.redirectAllRequestsTo = x.getRedirectAllRequestsTo();
            this.routingRules = x.getRoutingRules();
        }

        public final WebsiteConfiguration build() {
            return new WebsiteConfiguration(this, null);
        }

        public final void errorDocument(Function1<? super ErrorDocument.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.errorDocument = WebsiteConfigurationKt.awsSdkKotlinServicesS3ModelErrorDocumentDslBuilderRef.invoke(block);
        }

        public final void indexDocument(Function1<? super IndexDocument.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.indexDocument = WebsiteConfigurationKt.awsSdkKotlinServicesS3ModelIndexDocumentDslBuilderRef.invoke(block);
        }

        public final void redirectAllRequestsTo(Function1<? super RedirectAllRequestsTo.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.redirectAllRequestsTo = WebsiteConfigurationKt.awsSdkKotlinServicesS3ModelRedirectAllRequestsToDslBuilderRef.invoke(block);
        }
    }
}
