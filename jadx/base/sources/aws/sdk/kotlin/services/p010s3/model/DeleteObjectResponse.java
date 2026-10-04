package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DeleteObjectResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0013\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0014\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cH\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse$Builder;)V", "deleteMarker", "", "getDeleteMarker", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "versionId", "", "getVersionId", "()Ljava/lang/String;", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeleteObjectResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean deleteMarker;
    private final RequestCharged requestCharged;
    private final String versionId;

    public /* synthetic */ DeleteObjectResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private DeleteObjectResponse(Builder builder) {
        this.deleteMarker = builder.getDeleteMarker();
        this.requestCharged = builder.getRequestCharged();
        this.versionId = builder.getVersionId();
    }

    public final Boolean getDeleteMarker() {
        return this.deleteMarker;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: DeleteObjectResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteObjectResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectResponse(");
        sb.append("deleteMarker=" + this.deleteMarker + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.deleteMarker;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode2 = (iHashCode + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        String str = this.versionId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DeleteObjectResponse deleteObjectResponse = (DeleteObjectResponse) other;
        return Intrinsics.areEqual(this.deleteMarker, deleteObjectResponse.deleteMarker) && Intrinsics.areEqual(this.requestCharged, deleteObjectResponse.requestCharged) && Intrinsics.areEqual(this.versionId, deleteObjectResponse.versionId);
    }

    public static /* synthetic */ DeleteObjectResponse copy$default(DeleteObjectResponse deleteObjectResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.DeleteObjectResponse.copy.1
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
        Builder builder = new Builder(deleteObjectResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final DeleteObjectResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: DeleteObjectResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u0005H\u0001J\r\u0010\u001b\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001cR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectResponse;)V", "deleteMarker", "", "getDeleteMarker", "()Ljava/lang/Boolean;", "setDeleteMarker", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "versionId", "", "getVersionId", "()Ljava/lang/String;", "setVersionId", "(Ljava/lang/String;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean deleteMarker;
        private RequestCharged requestCharged;
        private String versionId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Boolean getDeleteMarker() {
            return this.deleteMarker;
        }

        public final void setDeleteMarker(Boolean bool) {
            this.deleteMarker = bool;
        }

        public final RequestCharged getRequestCharged() {
            return this.requestCharged;
        }

        public final void setRequestCharged(RequestCharged requestCharged) {
            this.requestCharged = requestCharged;
        }

        public final String getVersionId() {
            return this.versionId;
        }

        public final void setVersionId(String str) {
            this.versionId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(DeleteObjectResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.deleteMarker = x.getDeleteMarker();
            this.requestCharged = x.getRequestCharged();
            this.versionId = x.getVersionId();
        }

        public final DeleteObjectResponse build() {
            return new DeleteObjectResponse(this, null);
        }
    }
}
