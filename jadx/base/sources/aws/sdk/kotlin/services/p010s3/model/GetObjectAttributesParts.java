package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GetObjectAttributesParts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001c\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u000bH\u0096\u0080\u0004J\u0014\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010 \u001a\u00020\u00002\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"¢\u0006\u0002\b$H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u001b\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts$Builder;)V", "isTruncated", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "maxParts", "", "getMaxParts", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "nextPartNumberMarker", "", "getNextPartNumberMarker", "()Ljava/lang/String;", "partNumberMarker", "getPartNumberMarker", "parts", "", "Laws/sdk/kotlin/services/s3/model/ObjectPart;", "getParts", "()Ljava/util/List;", "totalPartsCount", "getTotalPartsCount", "toString", "hashCode", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetObjectAttributesParts {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean isTruncated;
    private final Integer maxParts;
    private final String nextPartNumberMarker;
    private final String partNumberMarker;
    private final List<ObjectPart> parts;
    private final Integer totalPartsCount;

    public /* synthetic */ GetObjectAttributesParts(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetObjectAttributesParts(Builder builder) {
        this.isTruncated = builder.getIsTruncated();
        this.maxParts = builder.getMaxParts();
        this.nextPartNumberMarker = builder.getNextPartNumberMarker();
        this.partNumberMarker = builder.getPartNumberMarker();
        this.parts = builder.getParts();
        this.totalPartsCount = builder.getTotalPartsCount();
    }

    /* JADX INFO: renamed from: isTruncated, reason: from getter */
    public final Boolean getIsTruncated() {
        return this.isTruncated;
    }

    public final Integer getMaxParts() {
        return this.maxParts;
    }

    public final String getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public final String getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public final List<ObjectPart> getParts() {
        return this.parts;
    }

    public final Integer getTotalPartsCount() {
        return this.totalPartsCount;
    }

    /* JADX INFO: compiled from: GetObjectAttributesParts.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetObjectAttributesParts invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetObjectAttributesParts(");
        sb.append("isTruncated=" + this.isTruncated + AbstractJsonLexerKt.COMMA);
        sb.append("maxParts=" + this.maxParts + AbstractJsonLexerKt.COMMA);
        sb.append("nextPartNumberMarker=" + this.nextPartNumberMarker + AbstractJsonLexerKt.COMMA);
        sb.append("partNumberMarker=" + this.partNumberMarker + AbstractJsonLexerKt.COMMA);
        sb.append("parts=" + this.parts + AbstractJsonLexerKt.COMMA);
        sb.append("totalPartsCount=" + this.totalPartsCount);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.isTruncated;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        Integer num = this.maxParts;
        int iIntValue = (iHashCode + (num != null ? num.intValue() : 0)) * 31;
        String str = this.nextPartNumberMarker;
        int iHashCode2 = (iIntValue + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.partNumberMarker;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ObjectPart> list = this.parts;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Integer num2 = this.totalPartsCount;
        return iHashCode4 + (num2 != null ? num2.intValue() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetObjectAttributesParts getObjectAttributesParts = (GetObjectAttributesParts) other;
        return Intrinsics.areEqual(this.isTruncated, getObjectAttributesParts.isTruncated) && Intrinsics.areEqual(this.maxParts, getObjectAttributesParts.maxParts) && Intrinsics.areEqual(this.nextPartNumberMarker, getObjectAttributesParts.nextPartNumberMarker) && Intrinsics.areEqual(this.partNumberMarker, getObjectAttributesParts.partNumberMarker) && Intrinsics.areEqual(this.parts, getObjectAttributesParts.parts) && Intrinsics.areEqual(this.totalPartsCount, getObjectAttributesParts.totalPartsCount);
    }

    public static /* synthetic */ GetObjectAttributesParts copy$default(GetObjectAttributesParts getObjectAttributesParts, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetObjectAttributesParts.copy.1
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
        Builder builder = new Builder(getObjectAttributesParts);
        block.invoke(builder);
        return builder.build();
    }

    public final GetObjectAttributesParts copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetObjectAttributesParts.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010'\u001a\u00020\u0005H\u0001J\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006*"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;", "(Laws/sdk/kotlin/services/s3/model/GetObjectAttributesParts;)V", "isTruncated", "", "()Ljava/lang/Boolean;", "setTruncated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "maxParts", "", "getMaxParts", "()Ljava/lang/Integer;", "setMaxParts", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "nextPartNumberMarker", "", "getNextPartNumberMarker", "()Ljava/lang/String;", "setNextPartNumberMarker", "(Ljava/lang/String;)V", "partNumberMarker", "getPartNumberMarker", "setPartNumberMarker", "parts", "", "Laws/sdk/kotlin/services/s3/model/ObjectPart;", "getParts", "()Ljava/util/List;", "setParts", "(Ljava/util/List;)V", "totalPartsCount", "getTotalPartsCount", "setTotalPartsCount", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean isTruncated;
        private Integer maxParts;
        private String nextPartNumberMarker;
        private String partNumberMarker;
        private List<ObjectPart> parts;
        private Integer totalPartsCount;

        public final Builder correctErrors$s3() {
            return this;
        }

        /* JADX INFO: renamed from: isTruncated, reason: from getter */
        public final Boolean getIsTruncated() {
            return this.isTruncated;
        }

        public final void setTruncated(Boolean bool) {
            this.isTruncated = bool;
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

        public final String getPartNumberMarker() {
            return this.partNumberMarker;
        }

        public final void setPartNumberMarker(String str) {
            this.partNumberMarker = str;
        }

        public final List<ObjectPart> getParts() {
            return this.parts;
        }

        public final void setParts(List<ObjectPart> list) {
            this.parts = list;
        }

        public final Integer getTotalPartsCount() {
            return this.totalPartsCount;
        }

        public final void setTotalPartsCount(Integer num) {
            this.totalPartsCount = num;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetObjectAttributesParts x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.isTruncated = x.getIsTruncated();
            this.maxParts = x.getMaxParts();
            this.nextPartNumberMarker = x.getNextPartNumberMarker();
            this.partNumberMarker = x.getPartNumberMarker();
            this.parts = x.getParts();
            this.totalPartsCount = x.getTotalPartsCount();
        }

        public final GetObjectAttributesParts build() {
            return new GetObjectAttributesParts(this, null);
        }
    }
}
