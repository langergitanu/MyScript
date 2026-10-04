package aws.sdk.kotlin.services.p010s3.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ListMultipartUploadsResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\u00020\u0001:\u000289B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010/\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u00100\u001a\u00020\u001cH\u0096\u0080\u0004J\u0014\u00101\u001a\u00020\u00162\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00103\u001a\u00020\u00002\u0019\b\u0002\u00104\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020605¢\u0006\u0002\b7H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0015\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u0013\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR\u0019\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006:"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "commonPrefixes", "", "Laws/sdk/kotlin/services/s3/model/CommonPrefix;", "getCommonPrefixes", "()Ljava/util/List;", TtmlNode.RUBY_DELIMITER, "getDelimiter", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "isTruncated", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "keyMarker", "getKeyMarker", "maxUploads", "", "getMaxUploads", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "nextKeyMarker", "getNextKeyMarker", "nextUploadIdMarker", "getNextUploadIdMarker", "prefix", "getPrefix", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "uploadIdMarker", "getUploadIdMarker", "uploads", "Laws/sdk/kotlin/services/s3/model/MultipartUpload;", "getUploads", "toString", "hashCode", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListMultipartUploadsResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final List<CommonPrefix> commonPrefixes;
    private final String delimiter;
    private final EncodingType encodingType;
    private final Boolean isTruncated;
    private final String keyMarker;
    private final Integer maxUploads;
    private final String nextKeyMarker;
    private final String nextUploadIdMarker;
    private final String prefix;
    private final RequestCharged requestCharged;
    private final String uploadIdMarker;
    private final List<MultipartUpload> uploads;

    public /* synthetic */ ListMultipartUploadsResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListMultipartUploadsResponse(Builder builder) {
        this.bucket = builder.getBucket();
        this.commonPrefixes = builder.getCommonPrefixes();
        this.delimiter = builder.getDelimiter();
        this.encodingType = builder.getEncodingType();
        this.isTruncated = builder.getIsTruncated();
        this.keyMarker = builder.getKeyMarker();
        this.maxUploads = builder.getMaxUploads();
        this.nextKeyMarker = builder.getNextKeyMarker();
        this.nextUploadIdMarker = builder.getNextUploadIdMarker();
        this.prefix = builder.getPrefix();
        this.requestCharged = builder.getRequestCharged();
        this.uploadIdMarker = builder.getUploadIdMarker();
        this.uploads = builder.getUploads();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final List<CommonPrefix> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public final String getDelimiter() {
        return this.delimiter;
    }

    public final EncodingType getEncodingType() {
        return this.encodingType;
    }

    /* JADX INFO: renamed from: isTruncated, reason: from getter */
    public final Boolean getIsTruncated() {
        return this.isTruncated;
    }

    public final String getKeyMarker() {
        return this.keyMarker;
    }

    public final Integer getMaxUploads() {
        return this.maxUploads;
    }

    public final String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public final String getNextUploadIdMarker() {
        return this.nextUploadIdMarker;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public final List<MultipartUpload> getUploads() {
        return this.uploads;
    }

    /* JADX INFO: compiled from: ListMultipartUploadsResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListMultipartUploadsResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListMultipartUploadsResponse(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("commonPrefixes=" + this.commonPrefixes + AbstractJsonLexerKt.COMMA);
        sb.append("delimiter=" + this.delimiter + AbstractJsonLexerKt.COMMA);
        sb.append("encodingType=" + this.encodingType + AbstractJsonLexerKt.COMMA);
        sb.append("isTruncated=" + this.isTruncated + AbstractJsonLexerKt.COMMA);
        sb.append("keyMarker=" + this.keyMarker + AbstractJsonLexerKt.COMMA);
        sb.append("maxUploads=" + this.maxUploads + AbstractJsonLexerKt.COMMA);
        sb.append("nextKeyMarker=" + this.nextKeyMarker + AbstractJsonLexerKt.COMMA);
        sb.append("nextUploadIdMarker=" + this.nextUploadIdMarker + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("uploadIdMarker=" + this.uploadIdMarker + AbstractJsonLexerKt.COMMA);
        sb.append("uploads=" + this.uploads);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<CommonPrefix> list = this.commonPrefixes;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.delimiter;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        EncodingType encodingType = this.encodingType;
        int iHashCode4 = (iHashCode3 + (encodingType != null ? encodingType.hashCode() : 0)) * 31;
        Boolean bool = this.isTruncated;
        int iHashCode5 = (iHashCode4 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str3 = this.keyMarker;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.maxUploads;
        int iIntValue = (iHashCode6 + (num != null ? num.intValue() : 0)) * 31;
        String str4 = this.nextKeyMarker;
        int iHashCode7 = (iIntValue + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nextUploadIdMarker;
        int iHashCode8 = (iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.prefix;
        int iHashCode9 = (iHashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode10 = (iHashCode9 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        String str7 = this.uploadIdMarker;
        int iHashCode11 = (iHashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<MultipartUpload> list2 = this.uploads;
        return iHashCode11 + (list2 != null ? list2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListMultipartUploadsResponse listMultipartUploadsResponse = (ListMultipartUploadsResponse) other;
        return Intrinsics.areEqual(this.bucket, listMultipartUploadsResponse.bucket) && Intrinsics.areEqual(this.commonPrefixes, listMultipartUploadsResponse.commonPrefixes) && Intrinsics.areEqual(this.delimiter, listMultipartUploadsResponse.delimiter) && Intrinsics.areEqual(this.encodingType, listMultipartUploadsResponse.encodingType) && Intrinsics.areEqual(this.isTruncated, listMultipartUploadsResponse.isTruncated) && Intrinsics.areEqual(this.keyMarker, listMultipartUploadsResponse.keyMarker) && Intrinsics.areEqual(this.maxUploads, listMultipartUploadsResponse.maxUploads) && Intrinsics.areEqual(this.nextKeyMarker, listMultipartUploadsResponse.nextKeyMarker) && Intrinsics.areEqual(this.nextUploadIdMarker, listMultipartUploadsResponse.nextUploadIdMarker) && Intrinsics.areEqual(this.prefix, listMultipartUploadsResponse.prefix) && Intrinsics.areEqual(this.requestCharged, listMultipartUploadsResponse.requestCharged) && Intrinsics.areEqual(this.uploadIdMarker, listMultipartUploadsResponse.uploadIdMarker) && Intrinsics.areEqual(this.uploads, listMultipartUploadsResponse.uploads);
    }

    public static /* synthetic */ ListMultipartUploadsResponse copy$default(ListMultipartUploadsResponse listMultipartUploadsResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListMultipartUploadsResponse.copy.1
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
        Builder builder = new Builder(listMultipartUploadsResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final ListMultipartUploadsResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListMultipartUploadsResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010C\u001a\u00020\u0005H\u0001J\r\u0010D\u001a\u00020\u0000H\u0000¢\u0006\u0002\bER\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010-\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR\u001c\u00100\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\n\"\u0004\b2\u0010\fR\u001c\u00103\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\n\"\u0004\b5\u0010\fR\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\n\"\u0004\b>\u0010\fR\"\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0011\"\u0004\bB\u0010\u0013¨\u0006F"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;", "(Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsResponse;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "commonPrefixes", "", "Laws/sdk/kotlin/services/s3/model/CommonPrefix;", "getCommonPrefixes", "()Ljava/util/List;", "setCommonPrefixes", "(Ljava/util/List;)V", TtmlNode.RUBY_DELIMITER, "getDelimiter", "setDelimiter", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "setEncodingType", "(Laws/sdk/kotlin/services/s3/model/EncodingType;)V", "isTruncated", "", "()Ljava/lang/Boolean;", "setTruncated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "keyMarker", "getKeyMarker", "setKeyMarker", "maxUploads", "", "getMaxUploads", "()Ljava/lang/Integer;", "setMaxUploads", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nextKeyMarker", "getNextKeyMarker", "setNextKeyMarker", "nextUploadIdMarker", "getNextUploadIdMarker", "setNextUploadIdMarker", "prefix", "getPrefix", "setPrefix", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "uploadIdMarker", "getUploadIdMarker", "setUploadIdMarker", "uploads", "Laws/sdk/kotlin/services/s3/model/MultipartUpload;", "getUploads", "setUploads", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private List<CommonPrefix> commonPrefixes;
        private String delimiter;
        private EncodingType encodingType;
        private Boolean isTruncated;
        private String keyMarker;
        private Integer maxUploads;
        private String nextKeyMarker;
        private String nextUploadIdMarker;
        private String prefix;
        private RequestCharged requestCharged;
        private String uploadIdMarker;
        private List<MultipartUpload> uploads;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final List<CommonPrefix> getCommonPrefixes() {
            return this.commonPrefixes;
        }

        public final void setCommonPrefixes(List<CommonPrefix> list) {
            this.commonPrefixes = list;
        }

        public final String getDelimiter() {
            return this.delimiter;
        }

        public final void setDelimiter(String str) {
            this.delimiter = str;
        }

        public final EncodingType getEncodingType() {
            return this.encodingType;
        }

        public final void setEncodingType(EncodingType encodingType) {
            this.encodingType = encodingType;
        }

        /* JADX INFO: renamed from: isTruncated, reason: from getter */
        public final Boolean getIsTruncated() {
            return this.isTruncated;
        }

        public final void setTruncated(Boolean bool) {
            this.isTruncated = bool;
        }

        public final String getKeyMarker() {
            return this.keyMarker;
        }

        public final void setKeyMarker(String str) {
            this.keyMarker = str;
        }

        public final Integer getMaxUploads() {
            return this.maxUploads;
        }

        public final void setMaxUploads(Integer num) {
            this.maxUploads = num;
        }

        public final String getNextKeyMarker() {
            return this.nextKeyMarker;
        }

        public final void setNextKeyMarker(String str) {
            this.nextKeyMarker = str;
        }

        public final String getNextUploadIdMarker() {
            return this.nextUploadIdMarker;
        }

        public final void setNextUploadIdMarker(String str) {
            this.nextUploadIdMarker = str;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final RequestCharged getRequestCharged() {
            return this.requestCharged;
        }

        public final void setRequestCharged(RequestCharged requestCharged) {
            this.requestCharged = requestCharged;
        }

        public final String getUploadIdMarker() {
            return this.uploadIdMarker;
        }

        public final void setUploadIdMarker(String str) {
            this.uploadIdMarker = str;
        }

        public final List<MultipartUpload> getUploads() {
            return this.uploads;
        }

        public final void setUploads(List<MultipartUpload> list) {
            this.uploads = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListMultipartUploadsResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.commonPrefixes = x.getCommonPrefixes();
            this.delimiter = x.getDelimiter();
            this.encodingType = x.getEncodingType();
            this.isTruncated = x.getIsTruncated();
            this.keyMarker = x.getKeyMarker();
            this.maxUploads = x.getMaxUploads();
            this.nextKeyMarker = x.getNextKeyMarker();
            this.nextUploadIdMarker = x.getNextUploadIdMarker();
            this.prefix = x.getPrefix();
            this.requestCharged = x.getRequestCharged();
            this.uploadIdMarker = x.getUploadIdMarker();
            this.uploads = x.getUploads();
        }

        public final ListMultipartUploadsResponse build() {
            return new ListMultipartUploadsResponse(this, null);
        }
    }
}
