package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ListBucketAnalyticsConfigurationsResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0015\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\u0014\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001a\u001a\u00020\u00002\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse$Builder;)V", "analyticsConfigurationList", "", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "getAnalyticsConfigurationList", "()Ljava/util/List;", "continuationToken", "", "getContinuationToken", "()Ljava/lang/String;", "isTruncated", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "nextContinuationToken", "getNextContinuationToken", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListBucketAnalyticsConfigurationsResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AnalyticsConfiguration> analyticsConfigurationList;
    private final String continuationToken;
    private final Boolean isTruncated;
    private final String nextContinuationToken;

    public /* synthetic */ ListBucketAnalyticsConfigurationsResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListBucketAnalyticsConfigurationsResponse(Builder builder) {
        this.analyticsConfigurationList = builder.getAnalyticsConfigurationList();
        this.continuationToken = builder.getContinuationToken();
        this.isTruncated = builder.getIsTruncated();
        this.nextContinuationToken = builder.getNextContinuationToken();
    }

    public final List<AnalyticsConfiguration> getAnalyticsConfigurationList() {
        return this.analyticsConfigurationList;
    }

    public final String getContinuationToken() {
        return this.continuationToken;
    }

    /* JADX INFO: renamed from: isTruncated, reason: from getter */
    public final Boolean getIsTruncated() {
        return this.isTruncated;
    }

    public final String getNextContinuationToken() {
        return this.nextContinuationToken;
    }

    /* JADX INFO: compiled from: ListBucketAnalyticsConfigurationsResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListBucketAnalyticsConfigurationsResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListBucketAnalyticsConfigurationsResponse(");
        sb.append("analyticsConfigurationList=" + this.analyticsConfigurationList + AbstractJsonLexerKt.COMMA);
        sb.append("continuationToken=" + this.continuationToken + AbstractJsonLexerKt.COMMA);
        sb.append("isTruncated=" + this.isTruncated + AbstractJsonLexerKt.COMMA);
        sb.append("nextContinuationToken=" + this.nextContinuationToken);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<AnalyticsConfiguration> list = this.analyticsConfigurationList;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.continuationToken;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Boolean bool = this.isTruncated;
        int iHashCode3 = (iHashCode2 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.nextContinuationToken;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListBucketAnalyticsConfigurationsResponse listBucketAnalyticsConfigurationsResponse = (ListBucketAnalyticsConfigurationsResponse) other;
        return Intrinsics.areEqual(this.analyticsConfigurationList, listBucketAnalyticsConfigurationsResponse.analyticsConfigurationList) && Intrinsics.areEqual(this.continuationToken, listBucketAnalyticsConfigurationsResponse.continuationToken) && Intrinsics.areEqual(this.isTruncated, listBucketAnalyticsConfigurationsResponse.isTruncated) && Intrinsics.areEqual(this.nextContinuationToken, listBucketAnalyticsConfigurationsResponse.nextContinuationToken);
    }

    public static /* synthetic */ ListBucketAnalyticsConfigurationsResponse copy$default(ListBucketAnalyticsConfigurationsResponse listBucketAnalyticsConfigurationsResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListBucketAnalyticsConfigurationsResponse.copy.1
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
        Builder builder = new Builder(listBucketAnalyticsConfigurationsResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final ListBucketAnalyticsConfigurationsResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListBucketAnalyticsConfigurationsResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0005H\u0001J\r\u0010\u001e\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006 "}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;", "(Laws/sdk/kotlin/services/s3/model/ListBucketAnalyticsConfigurationsResponse;)V", "analyticsConfigurationList", "", "Laws/sdk/kotlin/services/s3/model/AnalyticsConfiguration;", "getAnalyticsConfigurationList", "()Ljava/util/List;", "setAnalyticsConfigurationList", "(Ljava/util/List;)V", "continuationToken", "", "getContinuationToken", "()Ljava/lang/String;", "setContinuationToken", "(Ljava/lang/String;)V", "isTruncated", "", "()Ljava/lang/Boolean;", "setTruncated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "nextContinuationToken", "getNextContinuationToken", "setNextContinuationToken", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<AnalyticsConfiguration> analyticsConfigurationList;
        private String continuationToken;
        private Boolean isTruncated;
        private String nextContinuationToken;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<AnalyticsConfiguration> getAnalyticsConfigurationList() {
            return this.analyticsConfigurationList;
        }

        public final void setAnalyticsConfigurationList(List<AnalyticsConfiguration> list) {
            this.analyticsConfigurationList = list;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final void setContinuationToken(String str) {
            this.continuationToken = str;
        }

        /* JADX INFO: renamed from: isTruncated, reason: from getter */
        public final Boolean getIsTruncated() {
            return this.isTruncated;
        }

        public final void setTruncated(Boolean bool) {
            this.isTruncated = bool;
        }

        public final String getNextContinuationToken() {
            return this.nextContinuationToken;
        }

        public final void setNextContinuationToken(String str) {
            this.nextContinuationToken = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListBucketAnalyticsConfigurationsResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.analyticsConfigurationList = x.getAnalyticsConfigurationList();
            this.continuationToken = x.getContinuationToken();
            this.isTruncated = x.getIsTruncated();
            this.nextContinuationToken = x.getNextContinuationToken();
        }

        public final ListBucketAnalyticsConfigurationsResponse build() {
            return new ListBucketAnalyticsConfigurationsResponse(this, null);
        }
    }
}
