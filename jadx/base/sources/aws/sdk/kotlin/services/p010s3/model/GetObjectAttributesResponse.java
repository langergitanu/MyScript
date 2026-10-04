package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Checksum;
import aws.sdk.kotlin.services.p010s3.model.GetObjectAttributesParts;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GetObjectAttributesResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u0001:\u000245B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010*\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010+\u001a\u00020,H\u0096\u0080\u0004J\u0014\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010/\u001a\u00020\u00002\u0019\b\u0002\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020201¢\u0006\u0002\b3H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00066"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse$Builder;)V", "checksum", "Laws/sdk/kotlin/services/s3/model/Checksum;", "getChecksum", "()Laws/sdk/kotlin/services/s3/model/Checksum;", "deleteMarker", "", "getDeleteMarker", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "eTag", "", "getETag", "()Ljava/lang/String;", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "objectParts", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "getObjectParts", "()Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "objectSize", "", "getObjectSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "versionId", "getVersionId", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectAttributesResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Checksum checksum;
    private final Boolean deleteMarker;
    private final String eTag;
    private final Instant lastModified;
    private final GetObjectAttributesParts objectParts;
    private final Long objectSize;
    private final RequestCharged requestCharged;
    private final StorageClass storageClass;
    private final String versionId;

    public /* synthetic */ GetObjectAttributesResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetObjectAttributesResponse(Builder builder) {
        this.checksum = builder.getChecksum();
        this.deleteMarker = builder.getDeleteMarker();
        this.eTag = builder.getETag();
        this.lastModified = builder.getLastModified();
        this.objectParts = builder.getObjectParts();
        this.objectSize = builder.getObjectSize();
        this.requestCharged = builder.getRequestCharged();
        this.storageClass = builder.getStorageClass();
        this.versionId = builder.getVersionId();
    }

    public final Checksum getChecksum() {
        return this.checksum;
    }

    public final Boolean getDeleteMarker() {
        return this.deleteMarker;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final Instant getLastModified() {
        return this.lastModified;
    }

    public final GetObjectAttributesParts getObjectParts() {
        return this.objectParts;
    }

    public final Long getObjectSize() {
        return this.objectSize;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    /* JADX INFO: compiled from: GetObjectAttributesResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetObjectAttributesResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectAttributesResponse(");
        sb.append("checksum=" + this.checksum + AbstractJsonLexerKt.COMMA);
        sb.append("deleteMarker=" + this.deleteMarker + AbstractJsonLexerKt.COMMA);
        sb.append("eTag=" + this.eTag + AbstractJsonLexerKt.COMMA);
        sb.append("lastModified=" + this.lastModified + AbstractJsonLexerKt.COMMA);
        sb.append("objectParts=" + this.objectParts + AbstractJsonLexerKt.COMMA);
        sb.append("objectSize=" + this.objectSize + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("versionId=" + this.versionId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Checksum checksum = this.checksum;
        int iHashCode = (checksum != null ? checksum.hashCode() : 0) * 31;
        Boolean bool = this.deleteMarker;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str = this.eTag;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Instant instant = this.lastModified;
        int iHashCode4 = (iHashCode3 + (instant != null ? instant.hashCode() : 0)) * 31;
        GetObjectAttributesParts getObjectAttributesParts = this.objectParts;
        int iHashCode5 = (iHashCode4 + (getObjectAttributesParts != null ? getObjectAttributesParts.hashCode() : 0)) * 31;
        Long l = this.objectSize;
        int iHashCode6 = (iHashCode5 + (l != null ? Long.hashCode(l.longValue()) : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode7 = (iHashCode6 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode8 = (iHashCode7 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        String str2 = this.versionId;
        return iHashCode8 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetObjectAttributesResponse getObjectAttributesResponse = (GetObjectAttributesResponse) other;
        return Intrinsics.areEqual(this.checksum, getObjectAttributesResponse.checksum) && Intrinsics.areEqual(this.deleteMarker, getObjectAttributesResponse.deleteMarker) && Intrinsics.areEqual(this.eTag, getObjectAttributesResponse.eTag) && Intrinsics.areEqual(this.lastModified, getObjectAttributesResponse.lastModified) && Intrinsics.areEqual(this.objectParts, getObjectAttributesResponse.objectParts) && Intrinsics.areEqual(this.objectSize, getObjectAttributesResponse.objectSize) && Intrinsics.areEqual(this.requestCharged, getObjectAttributesResponse.requestCharged) && Intrinsics.areEqual(this.storageClass, getObjectAttributesResponse.storageClass) && Intrinsics.areEqual(this.versionId, getObjectAttributesResponse.versionId);
    }

    public static /* synthetic */ GetObjectAttributesResponse copy$default(GetObjectAttributesResponse getObjectAttributesResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetObjectAttributesResponse.copy.1
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
        Builder builder = new Builder(getObjectAttributesResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final GetObjectAttributesResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetObjectAttributesResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010<\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\u001f\u0010 \u001a\u00020=2\u0017\u0010>\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020=0?¢\u0006\u0002\bAJ\r\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0002\bDR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019¨\u0006E"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesResponse;)V", "checksum", "Laws/sdk/kotlin/services/s3/model/Checksum;", "getChecksum", "()Laws/sdk/kotlin/services/s3/model/Checksum;", "setChecksum", "(Laws/sdk/kotlin/services/s3/model/Checksum;)V", "deleteMarker", "", "getDeleteMarker", "()Ljava/lang/Boolean;", "setDeleteMarker", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "eTag", "", "getETag", "()Ljava/lang/String;", "setETag", "(Ljava/lang/String;)V", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "setLastModified", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "objectParts", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "getObjectParts", "()Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "setObjectParts", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;)V", "objectSize", "", "getObjectSize", "()Ljava/lang/Long;", "setObjectSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "versionId", "getVersionId", "setVersionId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Checksum$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Checksum checksum;
        private Boolean deleteMarker;
        private String eTag;
        private Instant lastModified;
        private GetObjectAttributesParts objectParts;
        private Long objectSize;
        private RequestCharged requestCharged;
        private StorageClass storageClass;
        private String versionId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Checksum getChecksum() {
            return this.checksum;
        }

        public final void setChecksum(Checksum checksum) {
            this.checksum = checksum;
        }

        public final Boolean getDeleteMarker() {
            return this.deleteMarker;
        }

        public final void setDeleteMarker(Boolean bool) {
            this.deleteMarker = bool;
        }

        public final String getETag() {
            return this.eTag;
        }

        public final void setETag(String str) {
            this.eTag = str;
        }

        public final Instant getLastModified() {
            return this.lastModified;
        }

        public final void setLastModified(Instant instant) {
            this.lastModified = instant;
        }

        public final GetObjectAttributesParts getObjectParts() {
            return this.objectParts;
        }

        public final void setObjectParts(GetObjectAttributesParts getObjectAttributesParts) {
            this.objectParts = getObjectAttributesParts;
        }

        public final Long getObjectSize() {
            return this.objectSize;
        }

        public final void setObjectSize(Long l) {
            this.objectSize = l;
        }

        public final RequestCharged getRequestCharged() {
            return this.requestCharged;
        }

        public final void setRequestCharged(RequestCharged requestCharged) {
            this.requestCharged = requestCharged;
        }

        public final StorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(StorageClass storageClass) {
            this.storageClass = storageClass;
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
        public Builder(GetObjectAttributesResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.checksum = x.getChecksum();
            this.deleteMarker = x.getDeleteMarker();
            this.eTag = x.getETag();
            this.lastModified = x.getLastModified();
            this.objectParts = x.getObjectParts();
            this.objectSize = x.getObjectSize();
            this.requestCharged = x.getRequestCharged();
            this.storageClass = x.getStorageClass();
            this.versionId = x.getVersionId();
        }

        public final GetObjectAttributesResponse build() {
            return new GetObjectAttributesResponse(this, null);
        }

        public final void checksum(Function1<? super Checksum.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.checksum = GetObjectAttributesResponseKt.awsSdkKotlinServicesS3ModelChecksumDslBuilderRef.invoke(block);
        }

        public final void objectParts(Function1<? super GetObjectAttributesParts.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.objectParts = GetObjectAttributesResponseKt.awsSdkKotlinServicesS3ModelGetObjectAttributesPartsDslBuilderRef.invoke(block);
        }
    }
}
