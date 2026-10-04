package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: RenameObjectRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0002-.B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\"\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010#\u001a\u00020$H\u0096\u0080\u0004J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010(\u001a\u00020\u00002\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0013\u0010 \u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/RenameObjectRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "clientToken", "getClientToken", "destinationIfMatch", "getDestinationIfMatch", "destinationIfModifiedSince", "Laws/smithy/kotlin/runtime/time/Instant;", "getDestinationIfModifiedSince", "()Laws/smithy/kotlin/runtime/time/Instant;", "destinationIfNoneMatch", "getDestinationIfNoneMatch", "destinationIfUnmodifiedSince", "getDestinationIfUnmodifiedSince", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "renameSource", "getRenameSource", "sourceIfMatch", "getSourceIfMatch", "sourceIfModifiedSince", "getSourceIfModifiedSince", "sourceIfNoneMatch", "getSourceIfNoneMatch", "sourceIfUnmodifiedSince", "getSourceIfUnmodifiedSince", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RenameObjectRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final String clientToken;
    private final String destinationIfMatch;
    private final Instant destinationIfModifiedSince;
    private final String destinationIfNoneMatch;
    private final Instant destinationIfUnmodifiedSince;
    private final String key;
    private final String renameSource;
    private final String sourceIfMatch;
    private final Instant sourceIfModifiedSince;
    private final String sourceIfNoneMatch;
    private final Instant sourceIfUnmodifiedSince;

    public /* synthetic */ RenameObjectRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private RenameObjectRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.clientToken = builder.getClientToken();
        this.destinationIfMatch = builder.getDestinationIfMatch();
        this.destinationIfModifiedSince = builder.getDestinationIfModifiedSince();
        this.destinationIfNoneMatch = builder.getDestinationIfNoneMatch();
        this.destinationIfUnmodifiedSince = builder.getDestinationIfUnmodifiedSince();
        this.key = builder.getKey();
        this.renameSource = builder.getRenameSource();
        this.sourceIfMatch = builder.getSourceIfMatch();
        this.sourceIfModifiedSince = builder.getSourceIfModifiedSince();
        this.sourceIfNoneMatch = builder.getSourceIfNoneMatch();
        this.sourceIfUnmodifiedSince = builder.getSourceIfUnmodifiedSince();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getClientToken() {
        return this.clientToken;
    }

    public final String getDestinationIfMatch() {
        return this.destinationIfMatch;
    }

    public final Instant getDestinationIfModifiedSince() {
        return this.destinationIfModifiedSince;
    }

    public final String getDestinationIfNoneMatch() {
        return this.destinationIfNoneMatch;
    }

    public final Instant getDestinationIfUnmodifiedSince() {
        return this.destinationIfUnmodifiedSince;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getRenameSource() {
        return this.renameSource;
    }

    public final String getSourceIfMatch() {
        return this.sourceIfMatch;
    }

    public final Instant getSourceIfModifiedSince() {
        return this.sourceIfModifiedSince;
    }

    public final String getSourceIfNoneMatch() {
        return this.sourceIfNoneMatch;
    }

    public final Instant getSourceIfUnmodifiedSince() {
        return this.sourceIfUnmodifiedSince;
    }

    /* JADX INFO: compiled from: RenameObjectRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RenameObjectRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RenameObjectRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RenameObjectRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("clientToken=" + this.clientToken + AbstractJsonLexerKt.COMMA);
        sb.append("destinationIfMatch=" + this.destinationIfMatch + AbstractJsonLexerKt.COMMA);
        sb.append("destinationIfModifiedSince=" + this.destinationIfModifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("destinationIfNoneMatch=" + this.destinationIfNoneMatch + AbstractJsonLexerKt.COMMA);
        sb.append("destinationIfUnmodifiedSince=" + this.destinationIfUnmodifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("renameSource=" + this.renameSource + AbstractJsonLexerKt.COMMA);
        sb.append("sourceIfMatch=" + this.sourceIfMatch + AbstractJsonLexerKt.COMMA);
        sb.append("sourceIfModifiedSince=" + this.sourceIfModifiedSince + AbstractJsonLexerKt.COMMA);
        sb.append("sourceIfNoneMatch=" + this.sourceIfNoneMatch + AbstractJsonLexerKt.COMMA);
        sb.append("sourceIfUnmodifiedSince=" + this.sourceIfUnmodifiedSince);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clientToken;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.destinationIfMatch;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Instant instant = this.destinationIfModifiedSince;
        int iHashCode4 = (iHashCode3 + (instant != null ? instant.hashCode() : 0)) * 31;
        String str4 = this.destinationIfNoneMatch;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Instant instant2 = this.destinationIfUnmodifiedSince;
        int iHashCode6 = (iHashCode5 + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        String str5 = this.key;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.renameSource;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.sourceIfMatch;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Instant instant3 = this.sourceIfModifiedSince;
        int iHashCode10 = (iHashCode9 + (instant3 != null ? instant3.hashCode() : 0)) * 31;
        String str8 = this.sourceIfNoneMatch;
        int iHashCode11 = (iHashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Instant instant4 = this.sourceIfUnmodifiedSince;
        return iHashCode11 + (instant4 != null ? instant4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        RenameObjectRequest renameObjectRequest = (RenameObjectRequest) other;
        return Intrinsics.areEqual(this.bucket, renameObjectRequest.bucket) && Intrinsics.areEqual(this.clientToken, renameObjectRequest.clientToken) && Intrinsics.areEqual(this.destinationIfMatch, renameObjectRequest.destinationIfMatch) && Intrinsics.areEqual(this.destinationIfModifiedSince, renameObjectRequest.destinationIfModifiedSince) && Intrinsics.areEqual(this.destinationIfNoneMatch, renameObjectRequest.destinationIfNoneMatch) && Intrinsics.areEqual(this.destinationIfUnmodifiedSince, renameObjectRequest.destinationIfUnmodifiedSince) && Intrinsics.areEqual(this.key, renameObjectRequest.key) && Intrinsics.areEqual(this.renameSource, renameObjectRequest.renameSource) && Intrinsics.areEqual(this.sourceIfMatch, renameObjectRequest.sourceIfMatch) && Intrinsics.areEqual(this.sourceIfModifiedSince, renameObjectRequest.sourceIfModifiedSince) && Intrinsics.areEqual(this.sourceIfNoneMatch, renameObjectRequest.sourceIfNoneMatch) && Intrinsics.areEqual(this.sourceIfUnmodifiedSince, renameObjectRequest.sourceIfUnmodifiedSince);
    }

    public static /* synthetic */ RenameObjectRequest copy$default(RenameObjectRequest renameObjectRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.RenameObjectRequest.copy.1
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
        Builder builder = new Builder(renameObjectRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final RenameObjectRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: RenameObjectRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00101\u001a\u00020\u0005H\u0001J\r\u00102\u001a\u00020\u0000H\u0000¢\u0006\u0002\b3R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001c\u0010\"\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001c\u0010.\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018¨\u00064"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RenameObjectRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;", "(Laws/sdk/kotlin/services/s3/model/RenameObjectRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "clientToken", "getClientToken", "setClientToken", "destinationIfMatch", "getDestinationIfMatch", "setDestinationIfMatch", "destinationIfModifiedSince", "Laws/smithy/kotlin/runtime/time/Instant;", "getDestinationIfModifiedSince", "()Laws/smithy/kotlin/runtime/time/Instant;", "setDestinationIfModifiedSince", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "destinationIfNoneMatch", "getDestinationIfNoneMatch", "setDestinationIfNoneMatch", "destinationIfUnmodifiedSince", "getDestinationIfUnmodifiedSince", "setDestinationIfUnmodifiedSince", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "renameSource", "getRenameSource", "setRenameSource", "sourceIfMatch", "getSourceIfMatch", "setSourceIfMatch", "sourceIfModifiedSince", "getSourceIfModifiedSince", "setSourceIfModifiedSince", "sourceIfNoneMatch", "getSourceIfNoneMatch", "setSourceIfNoneMatch", "sourceIfUnmodifiedSince", "getSourceIfUnmodifiedSince", "setSourceIfUnmodifiedSince", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String clientToken;
        private String destinationIfMatch;
        private Instant destinationIfModifiedSince;
        private String destinationIfNoneMatch;
        private Instant destinationIfUnmodifiedSince;
        private String key;
        private String renameSource;
        private String sourceIfMatch;
        private Instant sourceIfModifiedSince;
        private String sourceIfNoneMatch;
        private Instant sourceIfUnmodifiedSince;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final String getClientToken() {
            return this.clientToken;
        }

        public final void setClientToken(String str) {
            this.clientToken = str;
        }

        public final String getDestinationIfMatch() {
            return this.destinationIfMatch;
        }

        public final void setDestinationIfMatch(String str) {
            this.destinationIfMatch = str;
        }

        public final Instant getDestinationIfModifiedSince() {
            return this.destinationIfModifiedSince;
        }

        public final void setDestinationIfModifiedSince(Instant instant) {
            this.destinationIfModifiedSince = instant;
        }

        public final String getDestinationIfNoneMatch() {
            return this.destinationIfNoneMatch;
        }

        public final void setDestinationIfNoneMatch(String str) {
            this.destinationIfNoneMatch = str;
        }

        public final Instant getDestinationIfUnmodifiedSince() {
            return this.destinationIfUnmodifiedSince;
        }

        public final void setDestinationIfUnmodifiedSince(Instant instant) {
            this.destinationIfUnmodifiedSince = instant;
        }

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final String getRenameSource() {
            return this.renameSource;
        }

        public final void setRenameSource(String str) {
            this.renameSource = str;
        }

        public final String getSourceIfMatch() {
            return this.sourceIfMatch;
        }

        public final void setSourceIfMatch(String str) {
            this.sourceIfMatch = str;
        }

        public final Instant getSourceIfModifiedSince() {
            return this.sourceIfModifiedSince;
        }

        public final void setSourceIfModifiedSince(Instant instant) {
            this.sourceIfModifiedSince = instant;
        }

        public final String getSourceIfNoneMatch() {
            return this.sourceIfNoneMatch;
        }

        public final void setSourceIfNoneMatch(String str) {
            this.sourceIfNoneMatch = str;
        }

        public final Instant getSourceIfUnmodifiedSince() {
            return this.sourceIfUnmodifiedSince;
        }

        public final void setSourceIfUnmodifiedSince(Instant instant) {
            this.sourceIfUnmodifiedSince = instant;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(RenameObjectRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.clientToken = x.getClientToken();
            this.destinationIfMatch = x.getDestinationIfMatch();
            this.destinationIfModifiedSince = x.getDestinationIfModifiedSince();
            this.destinationIfNoneMatch = x.getDestinationIfNoneMatch();
            this.destinationIfUnmodifiedSince = x.getDestinationIfUnmodifiedSince();
            this.key = x.getKey();
            this.renameSource = x.getRenameSource();
            this.sourceIfMatch = x.getSourceIfMatch();
            this.sourceIfModifiedSince = x.getSourceIfModifiedSince();
            this.sourceIfNoneMatch = x.getSourceIfNoneMatch();
            this.sourceIfUnmodifiedSince = x.getSourceIfUnmodifiedSince();
        }

        public final RenameObjectRequest build() {
            return new RenameObjectRequest(this, null);
        }
    }
}
