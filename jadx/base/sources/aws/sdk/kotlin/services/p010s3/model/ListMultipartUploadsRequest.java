package aws.sdk.kotlin.services.p010s3.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ListMultipartUploadsRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010!\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\"\u001a\u00020\u0015H\u0096\u0080\u0004J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010&\u001a\u00020\u00002\u0019\b\u0002\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", TtmlNode.RUBY_DELIMITER, "getDelimiter", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "expectedBucketOwner", "getExpectedBucketOwner", "keyMarker", "getKeyMarker", "maxUploads", "", "getMaxUploads", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "prefix", "getPrefix", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "uploadIdMarker", "getUploadIdMarker", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListMultipartUploadsRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final String delimiter;
    private final EncodingType encodingType;
    private final String expectedBucketOwner;
    private final String keyMarker;
    private final Integer maxUploads;
    private final String prefix;
    private final RequestPayer requestPayer;
    private final String uploadIdMarker;

    public /* synthetic */ ListMultipartUploadsRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListMultipartUploadsRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.delimiter = builder.getDelimiter();
        this.encodingType = builder.getEncodingType();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.keyMarker = builder.getKeyMarker();
        this.maxUploads = builder.getMaxUploads();
        this.prefix = builder.getPrefix();
        this.requestPayer = builder.getRequestPayer();
        this.uploadIdMarker = builder.getUploadIdMarker();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getDelimiter() {
        return this.delimiter;
    }

    public final EncodingType getEncodingType() {
        return this.encodingType;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
    }

    public final String getKeyMarker() {
        return this.keyMarker;
    }

    public final Integer getMaxUploads() {
        return this.maxUploads;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    /* JADX INFO: compiled from: ListMultipartUploadsRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListMultipartUploadsRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListMultipartUploadsRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("delimiter=" + this.delimiter + AbstractJsonLexerKt.COMMA);
        sb.append("encodingType=" + this.encodingType + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("keyMarker=" + this.keyMarker + AbstractJsonLexerKt.COMMA);
        sb.append("maxUploads=" + this.maxUploads + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("uploadIdMarker=" + this.uploadIdMarker);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.delimiter;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        EncodingType encodingType = this.encodingType;
        int iHashCode3 = (iHashCode2 + (encodingType != null ? encodingType.hashCode() : 0)) * 31;
        String str3 = this.expectedBucketOwner;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.keyMarker;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.maxUploads;
        int iIntValue = (iHashCode5 + (num != null ? num.intValue() : 0)) * 31;
        String str5 = this.prefix;
        int iHashCode6 = (iIntValue + (str5 != null ? str5.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode7 = (iHashCode6 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        String str6 = this.uploadIdMarker;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListMultipartUploadsRequest listMultipartUploadsRequest = (ListMultipartUploadsRequest) other;
        return Intrinsics.areEqual(this.bucket, listMultipartUploadsRequest.bucket) && Intrinsics.areEqual(this.delimiter, listMultipartUploadsRequest.delimiter) && Intrinsics.areEqual(this.encodingType, listMultipartUploadsRequest.encodingType) && Intrinsics.areEqual(this.expectedBucketOwner, listMultipartUploadsRequest.expectedBucketOwner) && Intrinsics.areEqual(this.keyMarker, listMultipartUploadsRequest.keyMarker) && Intrinsics.areEqual(this.maxUploads, listMultipartUploadsRequest.maxUploads) && Intrinsics.areEqual(this.prefix, listMultipartUploadsRequest.prefix) && Intrinsics.areEqual(this.requestPayer, listMultipartUploadsRequest.requestPayer) && Intrinsics.areEqual(this.uploadIdMarker, listMultipartUploadsRequest.uploadIdMarker);
    }

    public static /* synthetic */ ListMultipartUploadsRequest copy$default(ListMultipartUploadsRequest listMultipartUploadsRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListMultipartUploadsRequest.copy.1
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
        Builder builder = new Builder(listMultipartUploadsRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final ListMultipartUploadsRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListMultipartUploadsRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010/\u001a\u00020\u0005H\u0001J\r\u00100\u001a\u00020\u0000H\u0000¢\u0006\u0002\b1R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\f¨\u00062"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;", "(Laws/sdk/kotlin/services/s3/model/ListMultipartUploadsRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", TtmlNode.RUBY_DELIMITER, "getDelimiter", "setDelimiter", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "setEncodingType", "(Laws/sdk/kotlin/services/s3/model/EncodingType;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "keyMarker", "getKeyMarker", "setKeyMarker", "maxUploads", "", "getMaxUploads", "()Ljava/lang/Integer;", "setMaxUploads", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "prefix", "getPrefix", "setPrefix", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "uploadIdMarker", "getUploadIdMarker", "setUploadIdMarker", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String delimiter;
        private EncodingType encodingType;
        private String expectedBucketOwner;
        private String keyMarker;
        private Integer maxUploads;
        private String prefix;
        private RequestPayer requestPayer;
        private String uploadIdMarker;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
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

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
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

        public final String getPrefix() {
            return this.prefix;
        }

        public final void setPrefix(String str) {
            this.prefix = str;
        }

        public final RequestPayer getRequestPayer() {
            return this.requestPayer;
        }

        public final void setRequestPayer(RequestPayer requestPayer) {
            this.requestPayer = requestPayer;
        }

        public final String getUploadIdMarker() {
            return this.uploadIdMarker;
        }

        public final void setUploadIdMarker(String str) {
            this.uploadIdMarker = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListMultipartUploadsRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.delimiter = x.getDelimiter();
            this.encodingType = x.getEncodingType();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.keyMarker = x.getKeyMarker();
            this.maxUploads = x.getMaxUploads();
            this.prefix = x.getPrefix();
            this.requestPayer = x.getRequestPayer();
            this.uploadIdMarker = x.getUploadIdMarker();
        }

        public final ListMultipartUploadsRequest build() {
            return new ListMultipartUploadsRequest(this, null);
        }
    }
}
