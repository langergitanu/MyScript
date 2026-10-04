package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Part.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\"\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010#\u001a\u00020\u0019H\u0096\u0080\u0004J\u0014\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010'\u001a\u00020\u00002\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020*0)¢\u0006\u0002\b+H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Part;", "", "builder", "Laws/sdk/kotlin/services/s3/model/Part$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/Part$Builder;)V", "checksumCrc32", "", "getChecksumCrc32", "()Ljava/lang/String;", "checksumCrc32C", "getChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "checksumSha256", "getChecksumSha256", "eTag", "getETag", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "partNumber", "", "getPartNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Part {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String checksumCrc32;
    private final String checksumCrc32C;
    private final String checksumCrc64Nvme;
    private final String checksumSha1;
    private final String checksumSha256;
    private final String eTag;
    private final Instant lastModified;
    private final Integer partNumber;
    private final Long size;

    public /* synthetic */ Part(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Part(Builder builder) {
        this.checksumCrc32 = builder.getChecksumCrc32();
        this.checksumCrc32C = builder.getChecksumCrc32C();
        this.checksumCrc64Nvme = builder.getChecksumCrc64Nvme();
        this.checksumSha1 = builder.getChecksumSha1();
        this.checksumSha256 = builder.getChecksumSha256();
        this.eTag = builder.getETag();
        this.lastModified = builder.getLastModified();
        this.partNumber = builder.getPartNumber();
        this.size = builder.getSize();
    }

    public final String getChecksumCrc32() {
        return this.checksumCrc32;
    }

    public final String getChecksumCrc32C() {
        return this.checksumCrc32C;
    }

    public final String getChecksumCrc64Nvme() {
        return this.checksumCrc64Nvme;
    }

    public final String getChecksumSha1() {
        return this.checksumSha1;
    }

    public final String getChecksumSha256() {
        return this.checksumSha256;
    }

    public final String getETag() {
        return this.eTag;
    }

    public final Instant getLastModified() {
        return this.lastModified;
    }

    public final Integer getPartNumber() {
        return this.partNumber;
    }

    public final Long getSize() {
        return this.size;
    }

    /* JADX INFO: compiled from: Part.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Part$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/Part;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Part$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Part invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Part(");
        sb.append("checksumCrc32=" + this.checksumCrc32 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc32C=" + this.checksumCrc32C + AbstractJsonLexerKt.COMMA);
        sb.append("checksumCrc64Nvme=" + this.checksumCrc64Nvme + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha1=" + this.checksumSha1 + AbstractJsonLexerKt.COMMA);
        sb.append("checksumSha256=" + this.checksumSha256 + AbstractJsonLexerKt.COMMA);
        sb.append("eTag=" + this.eTag + AbstractJsonLexerKt.COMMA);
        sb.append("lastModified=" + this.lastModified + AbstractJsonLexerKt.COMMA);
        sb.append("partNumber=" + this.partNumber + AbstractJsonLexerKt.COMMA);
        sb.append("size=" + this.size);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.checksumCrc32;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.checksumCrc32C;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.checksumCrc64Nvme;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.checksumSha1;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.checksumSha256;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.eTag;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Instant instant = this.lastModified;
        int iHashCode7 = (iHashCode6 + (instant != null ? instant.hashCode() : 0)) * 31;
        Integer num = this.partNumber;
        int iIntValue = (iHashCode7 + (num != null ? num.intValue() : 0)) * 31;
        Long l = this.size;
        return iIntValue + (l != null ? Long.hashCode(l.longValue()) : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Part part = (Part) other;
        return Intrinsics.areEqual(this.checksumCrc32, part.checksumCrc32) && Intrinsics.areEqual(this.checksumCrc32C, part.checksumCrc32C) && Intrinsics.areEqual(this.checksumCrc64Nvme, part.checksumCrc64Nvme) && Intrinsics.areEqual(this.checksumSha1, part.checksumSha1) && Intrinsics.areEqual(this.checksumSha256, part.checksumSha256) && Intrinsics.areEqual(this.eTag, part.eTag) && Intrinsics.areEqual(this.lastModified, part.lastModified) && Intrinsics.areEqual(this.partNumber, part.partNumber) && Intrinsics.areEqual(this.size, part.size);
    }

    public static /* synthetic */ Part copy$default(Part part, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.Part.copy.1
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
        Builder builder = new Builder(part);
        block.invoke(builder);
        return builder.build();
    }

    public final Part copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: Part.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00100\u001a\u00020\u0005H\u0001J\r\u00101\u001a\u00020\u0000H\u0000¢\u0006\u0002\b2R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00063"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/Part$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/Part;", "(Laws/sdk/kotlin/services/s3/model/Part;)V", "checksumCrc32", "", "getChecksumCrc32", "()Ljava/lang/String;", "setChecksumCrc32", "(Ljava/lang/String;)V", "checksumCrc32C", "getChecksumCrc32C", "setChecksumCrc32C", "checksumCrc64Nvme", "getChecksumCrc64Nvme", "setChecksumCrc64Nvme", "checksumSha1", "getChecksumSha1", "setChecksumSha1", "checksumSha256", "getChecksumSha256", "setChecksumSha256", "eTag", "getETag", "setETag", "lastModified", "Laws/smithy/kotlin/runtime/time/Instant;", "getLastModified", "()Laws/smithy/kotlin/runtime/time/Instant;", "setLastModified", "(Laws/smithy/kotlin/runtime/time/Instant;)V", "partNumber", "", "getPartNumber", "()Ljava/lang/Integer;", "setPartNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String checksumCrc32;
        private String checksumCrc32C;
        private String checksumCrc64Nvme;
        private String checksumSha1;
        private String checksumSha256;
        private String eTag;
        private Instant lastModified;
        private Integer partNumber;
        private Long size;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getChecksumCrc32() {
            return this.checksumCrc32;
        }

        public final void setChecksumCrc32(String str) {
            this.checksumCrc32 = str;
        }

        public final String getChecksumCrc32C() {
            return this.checksumCrc32C;
        }

        public final void setChecksumCrc32C(String str) {
            this.checksumCrc32C = str;
        }

        public final String getChecksumCrc64Nvme() {
            return this.checksumCrc64Nvme;
        }

        public final void setChecksumCrc64Nvme(String str) {
            this.checksumCrc64Nvme = str;
        }

        public final String getChecksumSha1() {
            return this.checksumSha1;
        }

        public final void setChecksumSha1(String str) {
            this.checksumSha1 = str;
        }

        public final String getChecksumSha256() {
            return this.checksumSha256;
        }

        public final void setChecksumSha256(String str) {
            this.checksumSha256 = str;
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

        public final Integer getPartNumber() {
            return this.partNumber;
        }

        public final void setPartNumber(Integer num) {
            this.partNumber = num;
        }

        public final Long getSize() {
            return this.size;
        }

        public final void setSize(Long l) {
            this.size = l;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Part x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.checksumCrc32 = x.getChecksumCrc32();
            this.checksumCrc32C = x.getChecksumCrc32C();
            this.checksumCrc64Nvme = x.getChecksumCrc64Nvme();
            this.checksumSha1 = x.getChecksumSha1();
            this.checksumSha256 = x.getChecksumSha256();
            this.eTag = x.getETag();
            this.lastModified = x.getLastModified();
            this.partNumber = x.getPartNumber();
            this.size = x.getSize();
        }

        public final Part build() {
            return new Part(this, null);
        }
    }
}
