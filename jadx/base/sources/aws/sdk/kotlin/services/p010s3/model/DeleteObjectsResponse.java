package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DeleteObjectsResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0019\u001a\u00020\u00002\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse$Builder;)V", "deleted", "", "Laws/sdk/kotlin/services/s3/model/DeletedObject;", "getDeleted", "()Ljava/util/List;", "errors", "Laws/sdk/kotlin/services/s3/model/Error;", "getErrors", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeleteObjectsResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<DeletedObject> deleted;
    private final List<Error> errors;
    private final RequestCharged requestCharged;

    public /* synthetic */ DeleteObjectsResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private DeleteObjectsResponse(Builder builder) {
        this.deleted = builder.getDeleted();
        this.errors = builder.getErrors();
        this.requestCharged = builder.getRequestCharged();
    }

    public final List<DeletedObject> getDeleted() {
        return this.deleted;
    }

    public final List<Error> getErrors() {
        return this.errors;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    /* JADX INFO: compiled from: DeleteObjectsResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteObjectsResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteObjectsResponse(");
        sb.append("deleted=" + this.deleted + AbstractJsonLexerKt.COMMA);
        sb.append("errors=" + this.errors + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<DeletedObject> list = this.deleted;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Error> list2 = this.errors;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        return iHashCode2 + (requestCharged != null ? requestCharged.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DeleteObjectsResponse deleteObjectsResponse = (DeleteObjectsResponse) other;
        return Intrinsics.areEqual(this.deleted, deleteObjectsResponse.deleted) && Intrinsics.areEqual(this.errors, deleteObjectsResponse.errors) && Intrinsics.areEqual(this.requestCharged, deleteObjectsResponse.requestCharged);
    }

    public static /* synthetic */ DeleteObjectsResponse copy$default(DeleteObjectsResponse deleteObjectsResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.DeleteObjectsResponse.copy.1
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
        Builder builder = new Builder(deleteObjectsResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final DeleteObjectsResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: DeleteObjectsResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0005H\u0001J\r\u0010\u0019\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001aR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;", "(Laws/sdk/kotlin/services/s3/model/DeleteObjectsResponse;)V", "deleted", "", "Laws/sdk/kotlin/services/s3/model/DeletedObject;", "getDeleted", "()Ljava/util/List;", "setDeleted", "(Ljava/util/List;)V", "errors", "Laws/sdk/kotlin/services/s3/model/Error;", "getErrors", "setErrors", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<DeletedObject> deleted;
        private List<Error> errors;
        private RequestCharged requestCharged;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<DeletedObject> getDeleted() {
            return this.deleted;
        }

        public final void setDeleted(List<DeletedObject> list) {
            this.deleted = list;
        }

        public final List<Error> getErrors() {
            return this.errors;
        }

        public final void setErrors(List<Error> list) {
            this.errors = list;
        }

        public final RequestCharged getRequestCharged() {
            return this.requestCharged;
        }

        public final void setRequestCharged(RequestCharged requestCharged) {
            this.requestCharged = requestCharged;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(DeleteObjectsResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.deleted = x.getDeleted();
            this.errors = x.getErrors();
            this.requestCharged = x.getRequestCharged();
        }

        public final DeleteObjectsResponse build() {
            return new DeleteObjectsResponse(this, null);
        }
    }
}
