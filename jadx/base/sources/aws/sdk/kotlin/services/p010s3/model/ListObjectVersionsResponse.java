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

/* JADX INFO: compiled from: ListObjectVersionsResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u00102\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u00103\u001a\u00020\u001dH\u0096\u0080\u0004J\u0014\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00106\u001a\u00020\u00002\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020908¢\u0006\u0002\b:H\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0016\u0010\u0018R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0011R\u0013\u0010#\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u0013\u0010%\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011R\u0013\u0010'\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0011R\u0019\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006="}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse$Builder;)V", "commonPrefixes", "", "Laws/sdk/kotlin/services/s3/model/CommonPrefix;", "getCommonPrefixes", "()Ljava/util/List;", "deleteMarkers", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry;", "getDeleteMarkers", TtmlNode.RUBY_DELIMITER, "", "getDelimiter", "()Ljava/lang/String;", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "isTruncated", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "keyMarker", "getKeyMarker", "maxKeys", "", "getMaxKeys", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "name", "getName", "nextKeyMarker", "getNextKeyMarker", "nextVersionIdMarker", "getNextVersionIdMarker", "prefix", "getPrefix", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "versionIdMarker", "getVersionIdMarker", "versions", "Laws/sdk/kotlin/services/s3/model/ObjectVersion;", "getVersions", "toString", "hashCode", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListObjectVersionsResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<CommonPrefix> commonPrefixes;
    private final List<DeleteMarkerEntry> deleteMarkers;
    private final String delimiter;
    private final EncodingType encodingType;
    private final Boolean isTruncated;
    private final String keyMarker;
    private final Integer maxKeys;
    private final String name;
    private final String nextKeyMarker;
    private final String nextVersionIdMarker;
    private final String prefix;
    private final RequestCharged requestCharged;
    private final String versionIdMarker;
    private final List<ObjectVersion> versions;

    public /* synthetic */ ListObjectVersionsResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ListObjectVersionsResponse(Builder builder) {
        this.commonPrefixes = builder.getCommonPrefixes();
        this.deleteMarkers = builder.getDeleteMarkers();
        this.delimiter = builder.getDelimiter();
        this.encodingType = builder.getEncodingType();
        this.isTruncated = builder.getIsTruncated();
        this.keyMarker = builder.getKeyMarker();
        this.maxKeys = builder.getMaxKeys();
        this.name = builder.getName();
        this.nextKeyMarker = builder.getNextKeyMarker();
        this.nextVersionIdMarker = builder.getNextVersionIdMarker();
        this.prefix = builder.getPrefix();
        this.requestCharged = builder.getRequestCharged();
        this.versionIdMarker = builder.getVersionIdMarker();
        this.versions = builder.getVersions();
    }

    public final List<CommonPrefix> getCommonPrefixes() {
        return this.commonPrefixes;
    }

    public final List<DeleteMarkerEntry> getDeleteMarkers() {
        return this.deleteMarkers;
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

    public final Integer getMaxKeys() {
        return this.maxKeys;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNextKeyMarker() {
        return this.nextKeyMarker;
    }

    public final String getNextVersionIdMarker() {
        return this.nextVersionIdMarker;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final RequestCharged getRequestCharged() {
        return this.requestCharged;
    }

    public final String getVersionIdMarker() {
        return this.versionIdMarker;
    }

    public final List<ObjectVersion> getVersions() {
        return this.versions;
    }

    /* JADX INFO: compiled from: ListObjectVersionsResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ListObjectVersionsResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListObjectVersionsResponse(");
        sb.append("commonPrefixes=" + this.commonPrefixes + AbstractJsonLexerKt.COMMA);
        sb.append("deleteMarkers=" + this.deleteMarkers + AbstractJsonLexerKt.COMMA);
        sb.append("delimiter=" + this.delimiter + AbstractJsonLexerKt.COMMA);
        sb.append("encodingType=" + this.encodingType + AbstractJsonLexerKt.COMMA);
        sb.append("isTruncated=" + this.isTruncated + AbstractJsonLexerKt.COMMA);
        sb.append("keyMarker=" + this.keyMarker + AbstractJsonLexerKt.COMMA);
        sb.append("maxKeys=" + this.maxKeys + AbstractJsonLexerKt.COMMA);
        sb.append("name=" + this.name + AbstractJsonLexerKt.COMMA);
        sb.append("nextKeyMarker=" + this.nextKeyMarker + AbstractJsonLexerKt.COMMA);
        sb.append("nextVersionIdMarker=" + this.nextVersionIdMarker + AbstractJsonLexerKt.COMMA);
        sb.append("prefix=" + this.prefix + AbstractJsonLexerKt.COMMA);
        sb.append("requestCharged=" + this.requestCharged + AbstractJsonLexerKt.COMMA);
        sb.append("versionIdMarker=" + this.versionIdMarker + AbstractJsonLexerKt.COMMA);
        sb.append("versions=" + this.versions);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<CommonPrefix> list = this.commonPrefixes;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<DeleteMarkerEntry> list2 = this.deleteMarkers;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.delimiter;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        EncodingType encodingType = this.encodingType;
        int iHashCode4 = (iHashCode3 + (encodingType != null ? encodingType.hashCode() : 0)) * 31;
        Boolean bool = this.isTruncated;
        int iHashCode5 = (iHashCode4 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        String str2 = this.keyMarker;
        int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.maxKeys;
        int iIntValue = (iHashCode6 + (num != null ? num.intValue() : 0)) * 31;
        String str3 = this.name;
        int iHashCode7 = (iIntValue + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.nextKeyMarker;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.nextVersionIdMarker;
        int iHashCode9 = (iHashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.prefix;
        int iHashCode10 = (iHashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        RequestCharged requestCharged = this.requestCharged;
        int iHashCode11 = (iHashCode10 + (requestCharged != null ? requestCharged.hashCode() : 0)) * 31;
        String str7 = this.versionIdMarker;
        int iHashCode12 = (iHashCode11 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<ObjectVersion> list3 = this.versions;
        return iHashCode12 + (list3 != null ? list3.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ListObjectVersionsResponse listObjectVersionsResponse = (ListObjectVersionsResponse) other;
        return Intrinsics.areEqual(this.commonPrefixes, listObjectVersionsResponse.commonPrefixes) && Intrinsics.areEqual(this.deleteMarkers, listObjectVersionsResponse.deleteMarkers) && Intrinsics.areEqual(this.delimiter, listObjectVersionsResponse.delimiter) && Intrinsics.areEqual(this.encodingType, listObjectVersionsResponse.encodingType) && Intrinsics.areEqual(this.isTruncated, listObjectVersionsResponse.isTruncated) && Intrinsics.areEqual(this.keyMarker, listObjectVersionsResponse.keyMarker) && Intrinsics.areEqual(this.maxKeys, listObjectVersionsResponse.maxKeys) && Intrinsics.areEqual(this.name, listObjectVersionsResponse.name) && Intrinsics.areEqual(this.nextKeyMarker, listObjectVersionsResponse.nextKeyMarker) && Intrinsics.areEqual(this.nextVersionIdMarker, listObjectVersionsResponse.nextVersionIdMarker) && Intrinsics.areEqual(this.prefix, listObjectVersionsResponse.prefix) && Intrinsics.areEqual(this.requestCharged, listObjectVersionsResponse.requestCharged) && Intrinsics.areEqual(this.versionIdMarker, listObjectVersionsResponse.versionIdMarker) && Intrinsics.areEqual(this.versions, listObjectVersionsResponse.versions);
    }

    public static /* synthetic */ ListObjectVersionsResponse copy$default(ListObjectVersionsResponse listObjectVersionsResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ListObjectVersionsResponse.copy.1
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
        Builder builder = new Builder(listObjectVersionsResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final ListObjectVersionsResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ListObjectVersionsResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010G\u001a\u00020\u0005H\u0001J\r\u0010H\u001a\u00020\u0000H\u0000¢\u0006\u0002\bIR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001e\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u00101\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001c\u00104\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R\u001c\u00107\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0015\"\u0004\bB\u0010\u0017R\"\u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\r¨\u0006J"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;", "(Laws/sdk/kotlin/services/s3/model/ListObjectVersionsResponse;)V", "commonPrefixes", "", "Laws/sdk/kotlin/services/s3/model/CommonPrefix;", "getCommonPrefixes", "()Ljava/util/List;", "setCommonPrefixes", "(Ljava/util/List;)V", "deleteMarkers", "Laws/sdk/kotlin/services/s3/model/DeleteMarkerEntry;", "getDeleteMarkers", "setDeleteMarkers", TtmlNode.RUBY_DELIMITER, "", "getDelimiter", "()Ljava/lang/String;", "setDelimiter", "(Ljava/lang/String;)V", "encodingType", "Laws/sdk/kotlin/services/s3/model/EncodingType;", "getEncodingType", "()Laws/sdk/kotlin/services/s3/model/EncodingType;", "setEncodingType", "(Laws/sdk/kotlin/services/s3/model/EncodingType;)V", "isTruncated", "", "()Ljava/lang/Boolean;", "setTruncated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "keyMarker", "getKeyMarker", "setKeyMarker", "maxKeys", "", "getMaxKeys", "()Ljava/lang/Integer;", "setMaxKeys", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "getName", "setName", "nextKeyMarker", "getNextKeyMarker", "setNextKeyMarker", "nextVersionIdMarker", "getNextVersionIdMarker", "setNextVersionIdMarker", "prefix", "getPrefix", "setPrefix", "requestCharged", "Laws/sdk/kotlin/services/s3/model/RequestCharged;", "getRequestCharged", "()Laws/sdk/kotlin/services/s3/model/RequestCharged;", "setRequestCharged", "(Laws/sdk/kotlin/services/s3/model/RequestCharged;)V", "versionIdMarker", "getVersionIdMarker", "setVersionIdMarker", "versions", "Laws/sdk/kotlin/services/s3/model/ObjectVersion;", "getVersions", "setVersions", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<CommonPrefix> commonPrefixes;
        private List<DeleteMarkerEntry> deleteMarkers;
        private String delimiter;
        private EncodingType encodingType;
        private Boolean isTruncated;
        private String keyMarker;
        private Integer maxKeys;
        private String name;
        private String nextKeyMarker;
        private String nextVersionIdMarker;
        private String prefix;
        private RequestCharged requestCharged;
        private String versionIdMarker;
        private List<ObjectVersion> versions;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<CommonPrefix> getCommonPrefixes() {
            return this.commonPrefixes;
        }

        public final void setCommonPrefixes(List<CommonPrefix> list) {
            this.commonPrefixes = list;
        }

        public final List<DeleteMarkerEntry> getDeleteMarkers() {
            return this.deleteMarkers;
        }

        public final void setDeleteMarkers(List<DeleteMarkerEntry> list) {
            this.deleteMarkers = list;
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

        public final Integer getMaxKeys() {
            return this.maxKeys;
        }

        public final void setMaxKeys(Integer num) {
            this.maxKeys = num;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getNextKeyMarker() {
            return this.nextKeyMarker;
        }

        public final void setNextKeyMarker(String str) {
            this.nextKeyMarker = str;
        }

        public final String getNextVersionIdMarker() {
            return this.nextVersionIdMarker;
        }

        public final void setNextVersionIdMarker(String str) {
            this.nextVersionIdMarker = str;
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

        public final String getVersionIdMarker() {
            return this.versionIdMarker;
        }

        public final void setVersionIdMarker(String str) {
            this.versionIdMarker = str;
        }

        public final List<ObjectVersion> getVersions() {
            return this.versions;
        }

        public final void setVersions(List<ObjectVersion> list) {
            this.versions = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ListObjectVersionsResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.commonPrefixes = x.getCommonPrefixes();
            this.deleteMarkers = x.getDeleteMarkers();
            this.delimiter = x.getDelimiter();
            this.encodingType = x.getEncodingType();
            this.isTruncated = x.getIsTruncated();
            this.keyMarker = x.getKeyMarker();
            this.maxKeys = x.getMaxKeys();
            this.name = x.getName();
            this.nextKeyMarker = x.getNextKeyMarker();
            this.nextVersionIdMarker = x.getNextVersionIdMarker();
            this.prefix = x.getPrefix();
            this.requestCharged = x.getRequestCharged();
            this.versionIdMarker = x.getVersionIdMarker();
            this.versions = x.getVersions();
        }

        public final ListObjectVersionsResponse build() {
            return new ListObjectVersionsResponse(this, null);
        }
    }
}
