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

/* JADX INFO: compiled from: ListBucketsResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002 !B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0015\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001b\u001a\u00020\u00002\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fH\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListBucketsResponse$Builder;)V", "buckets", "", "Laws/sdk/kotlin/services/s3/model/Bucket;", "getBuckets", "()Ljava/util/List;", "continuationToken", "", "getContinuationToken", "()Ljava/lang/String;", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "prefix", "getPrefix", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListBucketsResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Bucket> buckets;
    private final String continuationToken;
    private final Owner owner;
    private final String prefix;

    public /* synthetic */ ListBucketsResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListBucketsResponse(Builder builder) {
        this.buckets = builder.getBuckets();
        this.continuationToken = builder.getContinuationToken();
        this.owner = builder.getOwner();
        this.prefix = builder.getPrefix();
    }

    public final List<Bucket> getBuckets() {
        return this.buckets;
    }

    public final String getContinuationToken() {
        return this.continuationToken;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    /* JADX INFO: compiled from: ListBucketsResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketsResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListBucketsResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListBucketsResponse(");
        sb.append("buckets=" + this.buckets + AbstractJsonLexerKt.COMMA);
        sb.append("continuationToken=" + this.continuationToken + AbstractJsonLexerKt.COMMA);
        sb.append("owner=" + this.owner + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<Bucket> list = this.buckets;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.continuationToken;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Owner owner = this.owner;
        int iHashCode3 = (iHashCode2 + (owner != null ? owner.hashCode() : 0)) * 31;
        String str2 = this.prefix;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListBucketsResponse listBucketsResponse = (ListBucketsResponse) other;
        return Intrinsics.areEqual(this.buckets, listBucketsResponse.buckets) && Intrinsics.areEqual(this.continuationToken, listBucketsResponse.continuationToken) && Intrinsics.areEqual(this.owner, listBucketsResponse.owner) && Intrinsics.areEqual(this.prefix, listBucketsResponse.prefix);
    }

    public static /* synthetic */ ListBucketsResponse copy$default(ListBucketsResponse listBucketsResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListBucketsResponse.copy.1
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
        Builder builder = new Builder(listBucketsResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final ListBucketsResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListBucketsResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0005H\u0001J\u001f\u0010\u0014\u001a\u00020\u001e2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001e0 ¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u0000H\u0000¢\u0006\u0002\b$R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListBucketsResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;", "(Laws/sdk/kotlin/services/s3/model/ListBucketsResponse;)V", "buckets", "", "Laws/sdk/kotlin/services/s3/model/Bucket;", "getBuckets", "()Ljava/util/List;", "setBuckets", "(Ljava/util/List;)V", "continuationToken", "", "getContinuationToken", "()Ljava/lang/String;", "setContinuationToken", "(Ljava/lang/String;)V", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "setOwner", "(Laws/sdk/kotlin/services/s3/model/Owner;)V", "prefix", "getPrefix", "setPrefix", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Owner$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<Bucket> buckets;
        private String continuationToken;
        private Owner owner;
        private String prefix;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<Bucket> getBuckets() {
            return this.buckets;
        }

        public final void setBuckets(List<Bucket> list) {
            this.buckets = list;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final void setContinuationToken(String str) {
            this.continuationToken = str;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListBucketsResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.buckets = x.getBuckets();
            this.continuationToken = x.getContinuationToken();
            this.owner = x.getOwner();
            this.prefix = x.getPrefix();
        }

        public final ListBucketsResponse build() {
            return new ListBucketsResponse(this, null);
        }

        public final void owner(Function1<? super Owner.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.owner = ListBucketsResponseKt.awsSdkKotlinServicesS3ModelOwnerDslBuilderRef.invoke(block);
        }
    }
}
