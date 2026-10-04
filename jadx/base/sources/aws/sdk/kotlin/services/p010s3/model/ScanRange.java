package aws.sdk.kotlin.services.p010s3.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ScanRange.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0014\u001a\u00020\u00002\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ScanRange;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ScanRange$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ScanRange$Builder;)V", TtmlNode.END, "", "getEnd", "()Ljava/lang/Long;", "Ljava/lang/Long;", TtmlNode.START, "getStart", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ScanRange {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long end;
    private final Long start;

    public /* synthetic */ ScanRange(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ScanRange(Builder builder) {
        this.end = builder.getEnd();
        this.start = builder.getStart();
    }

    public final Long getEnd() {
        return this.end;
    }

    public final Long getStart() {
        return this.start;
    }

    /* JADX INFO: compiled from: ScanRange.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ScanRange$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ScanRange;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ScanRange$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScanRange invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ScanRange(");
        sb.append("end=" + this.end + AbstractJsonLexerKt.COMMA);
        sb.append("start=" + this.start);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Long l = this.end;
        int iHashCode = (l != null ? Long.hashCode(l.longValue()) : 0) * 31;
        Long l2 = this.start;
        return iHashCode + (l2 != null ? Long.hashCode(l2.longValue()) : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ScanRange scanRange = (ScanRange) other;
        return Intrinsics.areEqual(this.end, scanRange.end) && Intrinsics.areEqual(this.start, scanRange.start);
    }

    public static /* synthetic */ ScanRange copy$default(ScanRange scanRange, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ScanRange.copy.1
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
        Builder builder = new Builder(scanRange);
        block.invoke(builder);
        return builder.build();
    }

    public final ScanRange copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ScanRange.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0005H\u0001J\r\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0014"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ScanRange$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ScanRange;", "(Laws/sdk/kotlin/services/s3/model/ScanRange;)V", TtmlNode.END, "", "getEnd", "()Ljava/lang/Long;", "setEnd", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", TtmlNode.START, "getStart", "setStart", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Long end;
        private Long start;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Long getEnd() {
            return this.end;
        }

        public final void setEnd(Long l) {
            this.end = l;
        }

        public final Long getStart() {
            return this.start;
        }

        public final void setStart(Long l) {
            this.start = l;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ScanRange x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.end = x.getEnd();
            this.start = x.getStart();
        }

        public final ScanRange build() {
            return new ScanRange(this, null);
        }
    }
}
