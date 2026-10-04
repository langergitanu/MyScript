package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Owner;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DeleteMarkerEntry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0018\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001d\u001a\u00020\u00002\u0019\b\u0002\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry;", "", "builder", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry$Builder;)V", "isLatest", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "versionId", "getVersionId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DeleteMarkerEntry {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean isLatest;
    private final String key;
    private final Instant lastModified;
    private final Owner owner;
    private final String versionId;

    public /* synthetic */ DeleteMarkerEntry(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private DeleteMarkerEntry(Builder builder) {
        this.isLatest = builder.getIsLatest();
        this.key = builder.getKey();
        this.lastModified = builder.getLastModified();
        this.owner = builder.getOwner();
        this.versionId = builder.getVersionId();
    }

    /* JADX INFO: renamed from: isLatest, reason: from getter */
    public final Boolean getIsLatest() {
        return this.isLatest;
    }

    public final String getKey() {
        return this.key;
    }

    public final Instant getLastModified() {
        return this.lastModified;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: DeleteMarkerEntry.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteMarkerEntry invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteMarkerEntry(");
        sb.append("isLatest=" + this.isLatest + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("lastModified=" + this.lastModified + AbstractJsonLexerKt.COMMA);
        sb.append("owner=" + this.owner + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.isLatest;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        String str = this.key;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        Instant instant = this.lastModified;
        int iHashCode3 = (iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31;
        Owner owner = this.owner;
        int iHashCode4 = (iHashCode3 + (owner != null ? owner.hashCode() : 0)) * 31;
        String str2 = this.versionId;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DeleteMarkerEntry deleteMarkerEntry = (DeleteMarkerEntry) other;
        return Intrinsics.areEqual(this.isLatest, deleteMarkerEntry.isLatest) && Intrinsics.areEqual(this.key, deleteMarkerEntry.key) && Intrinsics.areEqual(this.lastModified, deleteMarkerEntry.lastModified) && Intrinsics.areEqual(this.owner, deleteMarkerEntry.owner) && Intrinsics.areEqual(this.versionId, deleteMarkerEntry.versionId);
    }

    public static /* synthetic */ DeleteMarkerEntry copy$default(DeleteMarkerEntry deleteMarkerEntry, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.DeleteMarkerEntry.copy.1
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
        Builder builder = new Builder(deleteMarkerEntry);
        block.invoke(builder);
        return builder.build();
    }

    public final DeleteMarkerEntry copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: DeleteMarkerEntry.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\u0005H\u0001J\u001f\u0010\u0019\u001a\u00020#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020#0%¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006*"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry;", "(Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry;)V", "isLatest", "", "()Ljava/lang/Boolean;", "setLatest", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "setLastModified", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "setOwner", "(Laws/sdk/kotlin/services/s3/model/Owner;)V", "versionId", "getVersionId", "setVersionId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Owner$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean isLatest;
        private String key;
        private Instant lastModified;
        private Owner owner;
        private String versionId;

        public final Builder correctErrors$s3() {
            return this;
        }

        /* JADX INFO: renamed from: isLatest, reason: from getter */
        public final Boolean getIsLatest() {
            return this.isLatest;
        }

        public final void setLatest(Boolean bool) {
            this.isLatest = bool;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Instant getLastModified() {
            return this.lastModified;
        }

        public final void setLastModified(Instant instant) {
            this.lastModified = instant;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
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
        public Builder(DeleteMarkerEntry x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.isLatest = x.getIsLatest();
            this.key = x.getKey();
            this.lastModified = x.getLastModified();
            this.owner = x.getOwner();
            this.versionId = x.getVersionId();
        }

        public final DeleteMarkerEntry build() {
            return new DeleteMarkerEntry(this, null);
        }

        public final void owner(Function1<? super Owner.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.owner = DeleteMarkerEntryKt.awsSdkKotlinServicesS3ModelOwnerDslBuilderRef.invoke(block);
        }
    }
}
