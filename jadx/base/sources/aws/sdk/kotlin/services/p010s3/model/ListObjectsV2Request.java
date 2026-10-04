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

/* JADX INFO: compiled from: ListObjectsV2Request.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 42\u00020\u0001:\u000245B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010+\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010,\u001a\u00020\u001aH\u0096\u0080\u0004J\u0014\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010/\u001a\u00020\u00002\u0019\b\u0002\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020201¢\u0006\u0002\b3H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00066"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "continuationToken", "getContinuationToken", TtmlNode.RUBY_DELIMITER, "getDelimiter", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "expectedBucketOwner", "getExpectedBucketOwner", "fetchOwner", "", "getFetchOwner", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "maxKeys", "", "getMaxKeys", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "optionalObjectAttributes", "", "Laws/sdk/kotlin/services/s3/model/OptionalObjectAttributes;", "getOptionalObjectAttributes", "()Ljava/util/List;", "prefix", "getPrefix", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "startAfter", "getStartAfter", "toString", "hashCode", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListObjectsV2Request {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final String continuationToken;
    private final String delimiter;
    private final EncodingType encodingType;
    private final String expectedBucketOwner;
    private final Boolean fetchOwner;
    private final Integer maxKeys;
    private final List<OptionalObjectAttributes> optionalObjectAttributes;
    private final String prefix;
    private final RequestPayer requestPayer;
    private final String startAfter;

    public /* synthetic */ ListObjectsV2Request(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListObjectsV2Request(Builder builder) {
        this.bucket = builder.getBucket();
        this.continuationToken = builder.getContinuationToken();
        this.delimiter = builder.getDelimiter();
        this.encodingType = builder.getEncodingType();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.fetchOwner = builder.getFetchOwner();
        this.maxKeys = builder.getMaxKeys();
        this.optionalObjectAttributes = builder.getOptionalObjectAttributes();
        this.prefix = builder.getPrefix();
        this.requestPayer = builder.getRequestPayer();
        this.startAfter = builder.getStartAfter();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getContinuationToken() {
        return this.continuationToken;
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

    public final Boolean getFetchOwner() {
        return this.fetchOwner;
    }

    public final Integer getMaxKeys() {
        return this.maxKeys;
    }

    public final List<OptionalObjectAttributes> getOptionalObjectAttributes() {
        return this.optionalObjectAttributes;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final RequestPayer getRequestPayer() {
        return this.requestPayer;
    }

    public final String getStartAfter() {
        return this.startAfter;
    }

    /* JADX INFO: compiled from: ListObjectsV2Request.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListObjectsV2Request invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectsV2Request(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("continuationToken=" + this.continuationToken + AbstractJsonLexerKt.COMMA);
        sb.append("delimiter=" + this.delimiter + AbstractJsonLexerKt.COMMA);
        sb.append("encodingType=" + this.encodingType + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("fetchOwner=" + this.fetchOwner + AbstractJsonLexerKt.COMMA);
        sb.append("maxKeys=" + this.maxKeys + AbstractJsonLexerKt.COMMA);
        sb.append("optionalObjectAttributes=" + this.optionalObjectAttributes + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("requestPayer=" + this.requestPayer + AbstractJsonLexerKt.COMMA);
        sb.append("startAfter=" + this.startAfter);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.continuationToken;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.delimiter;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        EncodingType encodingType = this.encodingType;
        int iHashCode4 = (iHashCode3 + (encodingType != null ? encodingType.hashCode() : 0)) * 31;
        String str4 = this.expectedBucketOwner;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.fetchOwner;
        int iHashCode6 = (iHashCode5 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        Integer num = this.maxKeys;
        int iIntValue = (iHashCode6 + (num != null ? num.intValue() : 0)) * 31;
        List<OptionalObjectAttributes> list = this.optionalObjectAttributes;
        int iHashCode7 = (iIntValue + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.prefix;
        int iHashCode8 = (iHashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        RequestPayer requestPayer = this.requestPayer;
        int iHashCode9 = (iHashCode8 + (requestPayer != null ? requestPayer.hashCode() : 0)) * 31;
        String str6 = this.startAfter;
        return iHashCode9 + (str6 != null ? str6.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListObjectsV2Request listObjectsV2Request = (ListObjectsV2Request) other;
        return Intrinsics.areEqual(this.bucket, listObjectsV2Request.bucket) && Intrinsics.areEqual(this.continuationToken, listObjectsV2Request.continuationToken) && Intrinsics.areEqual(this.delimiter, listObjectsV2Request.delimiter) && Intrinsics.areEqual(this.encodingType, listObjectsV2Request.encodingType) && Intrinsics.areEqual(this.expectedBucketOwner, listObjectsV2Request.expectedBucketOwner) && Intrinsics.areEqual(this.fetchOwner, listObjectsV2Request.fetchOwner) && Intrinsics.areEqual(this.maxKeys, listObjectsV2Request.maxKeys) && Intrinsics.areEqual(this.optionalObjectAttributes, listObjectsV2Request.optionalObjectAttributes) && Intrinsics.areEqual(this.prefix, listObjectsV2Request.prefix) && Intrinsics.areEqual(this.requestPayer, listObjectsV2Request.requestPayer) && Intrinsics.areEqual(this.startAfter, listObjectsV2Request.startAfter);
    }

    public static /* synthetic */ ListObjectsV2Request copy$default(ListObjectsV2Request listObjectsV2Request, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListObjectsV2Request.copy.1
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
        Builder builder = new Builder(listObjectsV2Request);
        block.invoke(builder);
        return builder.build();
    }

    public final ListObjectsV2Request copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListObjectsV2Request.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010=\u001a\u00020\u0005H\u0001J\r\u0010>\u001a\u00020\u0000H\u0000¢\u0006\u0002\b?R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010\f¨\u0006@"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;", "(Laws/sdk/kotlin/services/s3/model/ListObjectsV2Request;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "continuationToken", "getContinuationToken", "setContinuationToken", TtmlNode.RUBY_DELIMITER, "getDelimiter", "setDelimiter", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "setEncodingType", "(Laws/sdk/kotlin/services/s3/model/EncodingType;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "fetchOwner", "", "getFetchOwner", "()Ljava/lang/Boolean;", "setFetchOwner", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "maxKeys", "", "getMaxKeys", "()Ljava/lang/Integer;", "setMaxKeys", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "optionalObjectAttributes", "", "Laws/sdk/kotlin/services/s3/model/OptionalObjectAttributes;", "getOptionalObjectAttributes", "()Ljava/util/List;", "setOptionalObjectAttributes", "(Ljava/util/List;)V", "prefix", "getPrefix", "setPrefix", "requestPayer", "Laws/sdk/kotlin/services/s3/model/RequestPayer;", "getRequestPayer", "()Laws/sdk/kotlin/services/s3/model/RequestPayer;", "setRequestPayer", "(Laws/sdk/kotlin/services/s3/model/RequestPayer;)V", "startAfter", "getStartAfter", "setStartAfter", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String continuationToken;
        private String delimiter;
        private EncodingType encodingType;
        private String expectedBucketOwner;
        private Boolean fetchOwner;
        private Integer maxKeys;
        private List<? extends OptionalObjectAttributes> optionalObjectAttributes;
        private String prefix;
        private RequestPayer requestPayer;
        private String startAfter;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public final void setContinuationToken(String str) {
            this.continuationToken = str;
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

        public final Boolean getFetchOwner() {
            return this.fetchOwner;
        }

        public final void setFetchOwner(Boolean bool) {
            this.fetchOwner = bool;
        }

        public final Integer getMaxKeys() {
            return this.maxKeys;
        }

        public final void setMaxKeys(Integer num) {
            this.maxKeys = num;
        }

        public final List<OptionalObjectAttributes> getOptionalObjectAttributes() {
            return this.optionalObjectAttributes;
        }

        public final void setOptionalObjectAttributes(List<? extends OptionalObjectAttributes> list) {
            this.optionalObjectAttributes = list;
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

        public final String getStartAfter() {
            return this.startAfter;
        }

        public final void setStartAfter(String str) {
            this.startAfter = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListObjectsV2Request x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.continuationToken = x.getContinuationToken();
            this.delimiter = x.getDelimiter();
            this.encodingType = x.getEncodingType();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.fetchOwner = x.getFetchOwner();
            this.maxKeys = x.getMaxKeys();
            this.optionalObjectAttributes = x.getOptionalObjectAttributes();
            this.prefix = x.getPrefix();
            this.requestPayer = x.getRequestPayer();
            this.startAfter = x.getStartAfter();
        }

        public final ListObjectsV2Request build() {
            return new ListObjectsV2Request(this, null);
        }
    }
}
