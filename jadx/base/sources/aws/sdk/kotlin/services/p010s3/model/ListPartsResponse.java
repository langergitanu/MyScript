package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Initiator;
import aws.sdk.kotlin.services.p010s3.model.Owner;
import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ListPartsResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 G2\u00020\u0001:\u0002GHB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010>\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010?\u001a\u00020#H\u0096\u0080\u0004J\u0014\u0010@\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010B\u001a\u00020\u00002\u0019\b\u0002\u0010C\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D¢\u0006\u0002\bFH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001c\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\rR\u0015\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010'\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\rR\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\rR\u0019\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListPartsResponse$Builder;)V", "abortDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getAbortDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "abortRuleId", "", "getAbortRuleId", "()Ljava/lang/String;", "bucket", "getBucket", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "initiator", "Laws/sdk/kotlin/services/s3/model/Initiator;", "getInitiator", "()Laws/sdk/kotlin/services/s3/model/Initiator;", "isTruncated", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "maxParts", "", "getMaxParts", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "nextPartNumberMarker", "getNextPartNumberMarker", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "partNumberMarker", "getPartNumberMarker", "parts", "", "Laws/sdk/kotlin/services/s3/model/Part;", "getParts", "()Ljava/util/List;", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "uploadId", "getUploadId", "toString", "hashCode", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListPartsResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Instant abortDate;
    private final String abortRuleId;
    private final String bucket;
    private final ChecksumAlgorithm checksumAlgorithm;
    private final ChecksumType checksumType;
    private final Initiator initiator;
    private final Boolean isTruncated;
    private final String key;
    private final Integer maxParts;
    private final String nextPartNumberMarker;
    private final Owner owner;
    private final String partNumberMarker;
    private final List<Part> parts;
    private final RequestCharged requestCharged;
    private final StorageClass storageClass;
    private final String uploadId;

    public /* synthetic */ ListPartsResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListPartsResponse(Builder builder) {
        this.abortDate = builder.getAbortDate();
        this.abortRuleId = builder.getAbortRuleId();
        this.bucket = builder.getBucket();
        this.checksumAlgorithm = builder.getChecksumAlgorithm();
        this.checksumType = builder.getChecksumType();
        this.initiator = builder.getInitiator();
        this.isTruncated = builder.getIsTruncated();
        this.key = builder.getKey();
        this.maxParts = builder.getMaxParts();
        this.nextPartNumberMarker = builder.getNextPartNumberMarker();
        this.owner = builder.getOwner();
        this.partNumberMarker = builder.getPartNumberMarker();
        this.parts = builder.getParts();
        this.requestCharged = builder.getRequestCharged();
        this.storageClass = builder.getStorageClass();
        this.uploadId = builder.getUploadId();
    }

    public final Instant getAbortDate() {
        return this.abortDate;
    }

    public final String getAbortRuleId() {
        return this.abortRuleId;
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final ChecksumAlgorithm getChecksumAlgorithm() {
        return this.checksumAlgorithm;
    }

    public final ChecksumType getChecksumType() {
        return this.checksumType;
    }

    public final Initiator getInitiator() {
        return this.initiator;
    }

    /* JADX INFO: renamed from: isTruncated, reason: from getter */
    public final Boolean getIsTruncated() {
        return this.isTruncated;
    }

    public final String getKey() {
        return this.key;
    }

    public final Integer getMaxParts() {
        return this.maxParts;
    }

    public final String getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final String getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public final List<Part> getParts() {
        return this.parts;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final StorageClass getStorageClass() {
        return this.storageClass;
    }

    public final String getUploadId() {
        return this.uploadId;
    }

    /* JADX INFO: compiled from: ListPartsResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListPartsResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListPartsResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListPartsResponse(");
        sb.append("abortDate=" + this.abortDate + AbstractJsonLexerKt.COMMA);
        sb.append("abortRuleId=" + this.abortRuleId + AbstractJsonLexerKt.COMMA);
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("checksumAlgorithm=" + this.checksumAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("checksumType=" + this.checksumType + AbstractJsonLexerKt.COMMA);
        sb.append("initiator=" + this.initiator + AbstractJsonLexerKt.COMMA);
        sb.append("isTruncated=" + this.isTruncated + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("maxParts=" + this.maxParts + AbstractJsonLexerKt.COMMA);
        sb.append("nextPartNumberMarker=" + this.nextPartNumberMarker + AbstractJsonLexerKt.COMMA);
        sb.append("owner=" + this.owner + AbstractJsonLexerKt.COMMA);
        sb.append("partNumberMarker=" + this.partNumberMarker + AbstractJsonLexerKt.COMMA);
        sb.append("parts=" + this.parts + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass + AbstractJsonLexerKt.COMMA);
        sb.append("uploadId=" + this.uploadId);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Instant instant = this.abortDate;
        int iHashCode = (instant != null ? instant.hashCode() : 0) * 31;
        String str = this.abortRuleId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.bucket;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ChecksumAlgorithm checksumAlgorithm = this.checksumAlgorithm;
        int iHashCode4 = (iHashCode3 + (checksumAlgorithm != null ? checksumAlgorithm.hashCode() : 0)) * 31;
        ChecksumType checksumType = this.checksumType;
        int iHashCode5 = (iHashCode4 + (checksumType != null ? checksumType.hashCode() : 0)) * 31;
        Initiator initiator = this.initiator;
        int iHashCode6 = (iHashCode5 + (initiator != null ? initiator.hashCode() : 0)) * 31;
        Boolean bool = this.isTruncated;
        int iHashCode7 = (iHashCode6 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str3 = this.key;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.maxParts;
        int iIntValue = (iHashCode8 + (num != null ? num.intValue() : 0)) * 31;
        String str4 = this.nextPartNumberMarker;
        int iHashCode9 = (iIntValue + (str4 != null ? str4.hashCode() : 0)) * 31;
        Owner owner = this.owner;
        int iHashCode10 = (iHashCode9 + (owner != null ? owner.hashCode() : 0)) * 31;
        String str5 = this.partNumberMarker;
        int iHashCode11 = (iHashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<Part> list = this.parts;
        int iHashCode12 = (iHashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode13 = (iHashCode12 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        StorageClass storageClass = this.storageClass;
        int iHashCode14 = (iHashCode13 + (storageClass != null ? storageClass.hashCode() : 0)) * 31;
        String str6 = this.uploadId;
        return iHashCode14 + (str6 != null ? str6.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListPartsResponse listPartsResponse = (ListPartsResponse) other;
        return Intrinsics.areEqual(this.abortDate, listPartsResponse.abortDate) && Intrinsics.areEqual(this.abortRuleId, listPartsResponse.abortRuleId) && Intrinsics.areEqual(this.bucket, listPartsResponse.bucket) && Intrinsics.areEqual(this.checksumAlgorithm, listPartsResponse.checksumAlgorithm) && Intrinsics.areEqual(this.checksumType, listPartsResponse.checksumType) && Intrinsics.areEqual(this.initiator, listPartsResponse.initiator) && Intrinsics.areEqual(this.isTruncated, listPartsResponse.isTruncated) && Intrinsics.areEqual(this.key, listPartsResponse.key) && Intrinsics.areEqual(this.maxParts, listPartsResponse.maxParts) && Intrinsics.areEqual(this.nextPartNumberMarker, listPartsResponse.nextPartNumberMarker) && Intrinsics.areEqual(this.owner, listPartsResponse.owner) && Intrinsics.areEqual(this.partNumberMarker, listPartsResponse.partNumberMarker) && Intrinsics.areEqual(this.parts, listPartsResponse.parts) && Intrinsics.areEqual(this.requestCharged, listPartsResponse.requestCharged) && Intrinsics.areEqual(this.storageClass, listPartsResponse.storageClass) && Intrinsics.areEqual(this.uploadId, listPartsResponse.uploadId);
    }

    public static /* synthetic */ ListPartsResponse copy$default(ListPartsResponse listPartsResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListPartsResponse.copy.1
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
        Builder builder = new Builder(listPartsResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final ListPartsResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListPartsResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010Z\u001a\u00020\u0005H\u0001J\u001f\u0010\"\u001a\u00020[2\u0017\u0010\\\u001a\u0013\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020[0]¢\u0006\u0002\b_J\u001f\u0010;\u001a\u00020[2\u0017\u0010\\\u001a\u0013\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020[0]¢\u0006\u0002\b_J\r\u0010a\u001a\u00020\u0000H\u0000¢\u0006\u0002\bbR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001e\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00108\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\"\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u0012¨\u0006c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListPartsResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListPartsResponse;", "(Laws/sdk/kotlin/services/s3/model/ListPartsResponse;)V", "abortDate", "Laws/smithy/kotlin/runtime/time/Instant;", "getAbortDate", "()Laws/smithy/kotlin/runtime/time/Instant;", "setAbortDate", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "abortRuleId", "", "getAbortRuleId", "()Ljava/lang/String;", "setAbortRuleId", "(Ljava/lang/String;)V", "bucket", "getBucket", "setBucket", "checksumAlgorithm", "Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "getChecksumAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;", "setChecksumAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ChecksumAlgorithm;)V", "checksumType", "Laws/sdk/kotlin/services/s3/model/ChecksumType;", "getChecksumType", "()Laws/sdk/kotlin/services/s3/model/ChecksumType;", "setChecksumType", "(Laws/sdk/kotlin/services/s3/model/ChecksumType;)V", "initiator", "Laws/sdk/kotlin/services/s3/model/Initiator;", "getInitiator", "()Laws/sdk/kotlin/services/s3/model/Initiator;", "setInitiator", "(Laws/sdk/kotlin/services/s3/model/Initiator;)V", "isTruncated", "", "()Ljava/lang/Boolean;", "setTruncated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "maxParts", "", "getMaxParts", "()Ljava/lang/Integer;", "setMaxParts", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nextPartNumberMarker", "getNextPartNumberMarker", "setNextPartNumberMarker", "owner", "Laws/sdk/kotlin/services/s3/model/Owner;", "getOwner", "()Laws/sdk/kotlin/services/s3/model/Owner;", "setOwner", "(Laws/sdk/kotlin/services/s3/model/Owner;)V", "partNumberMarker", "getPartNumberMarker", "setPartNumberMarker", "parts", "", "Laws/sdk/kotlin/services/s3/model/Part;", "getParts", "()Ljava/util/List;", "setParts", "(Ljava/util/List;)V", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "storageClass", "Laws/sdk/kotlin/services/s3/model/StorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/StorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/StorageClass;)V", "uploadId", "getUploadId", "setUploadId", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Initiator$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/Owner$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Instant abortDate;
        private String abortRuleId;
        private String bucket;
        private ChecksumAlgorithm checksumAlgorithm;
        private ChecksumType checksumType;
        private Initiator initiator;
        private Boolean isTruncated;
        private String key;
        private Integer maxParts;
        private String nextPartNumberMarker;
        private Owner owner;
        private String partNumberMarker;
        private List<Part> parts;
        private RequestCharged requestCharged;
        private StorageClass storageClass;
        private String uploadId;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Instant getAbortDate() {
            return this.abortDate;
        }

        public final void setAbortDate(Instant instant) {
            this.abortDate = instant;
        }

        public final String getAbortRuleId() {
            return this.abortRuleId;
        }

        public final void setAbortRuleId(String str) {
            this.abortRuleId = str;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final ChecksumAlgorithm getChecksumAlgorithm() {
            return this.checksumAlgorithm;
        }

        public final void setChecksumAlgorithm(ChecksumAlgorithm checksumAlgorithm) {
            this.checksumAlgorithm = checksumAlgorithm;
        }

        public final ChecksumType getChecksumType() {
            return this.checksumType;
        }

        public final void setChecksumType(ChecksumType checksumType) {
            this.checksumType = checksumType;
        }

        public final Initiator getInitiator() {
            return this.initiator;
        }

        public final void setInitiator(Initiator initiator) {
            this.initiator = initiator;
        }

        /* JADX INFO: renamed from: isTruncated, reason: from getter */
        public final Boolean getIsTruncated() {
            return this.isTruncated;
        }

        public final void setTruncated(Boolean bool) {
            this.isTruncated = bool;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final Integer getMaxParts() {
            return this.maxParts;
        }

        public final void setMaxParts(Integer num) {
            this.maxParts = num;
        }

        public final String getNextPartNumberMarker() {
            return this.nextPartNumberMarker;
        }

        public final void setNextPartNumberMarker(String str) {
            this.nextPartNumberMarker = str;
        }

        public final Owner getOwner() {
            return this.owner;
        }

        public final void setOwner(Owner owner) {
            this.owner = owner;
        }

        public final String getPartNumberMarker() {
            return this.partNumberMarker;
        }

        public final void setPartNumberMarker(String str) {
            this.partNumberMarker = str;
        }

        public final List<Part> getParts() {
            return this.parts;
        }

        public final void setParts(List<Part> list) {
            this.parts = list;
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

        public final String getUploadId() {
            return this.uploadId;
        }

        public final void setUploadId(String str) {
            this.uploadId = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListPartsResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.abortDate = x.getAbortDate();
            this.abortRuleId = x.getAbortRuleId();
            this.bucket = x.getBucket();
            this.checksumAlgorithm = x.getChecksumAlgorithm();
            this.checksumType = x.getChecksumType();
            this.initiator = x.getInitiator();
            this.isTruncated = x.getIsTruncated();
            this.key = x.getKey();
            this.maxParts = x.getMaxParts();
            this.nextPartNumberMarker = x.getNextPartNumberMarker();
            this.owner = x.getOwner();
            this.partNumberMarker = x.getPartNumberMarker();
            this.parts = x.getParts();
            this.requestCharged = x.getRequestCharged();
            this.storageClass = x.getStorageClass();
            this.uploadId = x.getUploadId();
        }

        public final ListPartsResponse build() {
            return new ListPartsResponse(this, null);
        }

        public final void initiator(Function1<? super Initiator.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.initiator = ListPartsResponseKt.awsSdkKotlinServicesS3ModelInitiatorDslBuilderRef.invoke(block);
        }

        public final void owner(Function1<? super Owner.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.owner = ListPartsResponseKt.awsSdkKotlinServicesS3ModelOwnerDslBuilderRef.invoke(block);
        }
    }
}
