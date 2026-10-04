package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CsvOutput.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001a\u001a\u00020\u00002\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CsvOutput;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CsvOutput$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CsvOutput$Builder;)V", "fieldDelimiter", "", "getFieldDelimiter", "()Ljava/lang/String;", "quoteCharacter", "getQuoteCharacter", "quoteEscapeCharacter", "getQuoteEscapeCharacter", "quoteFields", "Laws/sdk/kotlin/services/s3/model/QuoteFields;", "getQuoteFields", "()Laws/sdk/kotlin/services/s3/model/QuoteFields;", "recordDelimiter", "getRecordDelimiter", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CsvOutput {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String fieldDelimiter;
    private final String quoteCharacter;
    private final String quoteEscapeCharacter;
    private final QuoteFields quoteFields;
    private final String recordDelimiter;

    public /* synthetic */ CsvOutput(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CsvOutput(Builder builder) {
        this.fieldDelimiter = builder.getFieldDelimiter();
        this.quoteCharacter = builder.getQuoteCharacter();
        this.quoteEscapeCharacter = builder.getQuoteEscapeCharacter();
        this.quoteFields = builder.getQuoteFields();
        this.recordDelimiter = builder.getRecordDelimiter();
    }

    public final String getFieldDelimiter() {
        return this.fieldDelimiter;
    }

    public final String getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public final String getQuoteEscapeCharacter() {
        return this.quoteEscapeCharacter;
    }

    public final QuoteFields getQuoteFields() {
        return this.quoteFields;
    }

    public final String getRecordDelimiter() {
        return this.recordDelimiter;
    }

    /* JADX INFO: compiled from: CsvOutput.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CsvOutput$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CsvOutput;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CsvOutput$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CsvOutput invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CsvOutput(");
        sb.append("fieldDelimiter=" + this.fieldDelimiter + AbstractJsonLexerKt.COMMA);
        sb.append("quoteCharacter=" + this.quoteCharacter + AbstractJsonLexerKt.COMMA);
        sb.append("quoteEscapeCharacter=" + this.quoteEscapeCharacter + AbstractJsonLexerKt.COMMA);
        sb.append("quoteFields=" + this.quoteFields + AbstractJsonLexerKt.COMMA);
        sb.append("recordDelimiter=" + this.recordDelimiter);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.fieldDelimiter;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.quoteCharacter;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.quoteEscapeCharacter;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        QuoteFields quoteFields = this.quoteFields;
        int iHashCode4 = (iHashCode3 + (quoteFields != null ? quoteFields.hashCode() : 0)) * 31;
        String str4 = this.recordDelimiter;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CsvOutput csvOutput = (CsvOutput) other;
        return Intrinsics.areEqual(this.fieldDelimiter, csvOutput.fieldDelimiter) && Intrinsics.areEqual(this.quoteCharacter, csvOutput.quoteCharacter) && Intrinsics.areEqual(this.quoteEscapeCharacter, csvOutput.quoteEscapeCharacter) && Intrinsics.areEqual(this.quoteFields, csvOutput.quoteFields) && Intrinsics.areEqual(this.recordDelimiter, csvOutput.recordDelimiter);
    }

    public static /* synthetic */ CsvOutput copy$default(CsvOutput csvOutput, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CsvOutput.copy.1
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
        Builder builder = new Builder(csvOutput);
        block.invoke(builder);
        return builder.build();
    }

    public final CsvOutput copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CsvOutput.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0005H\u0001J\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CsvOutput$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CsvOutput;", "(Laws/sdk/kotlin/services/s3/model/CsvOutput;)V", "fieldDelimiter", "", "getFieldDelimiter", "()Ljava/lang/String;", "setFieldDelimiter", "(Ljava/lang/String;)V", "quoteCharacter", "getQuoteCharacter", "setQuoteCharacter", "quoteEscapeCharacter", "getQuoteEscapeCharacter", "setQuoteEscapeCharacter", "quoteFields", "Laws/sdk/kotlin/services/s3/model/QuoteFields;", "getQuoteFields", "()Laws/sdk/kotlin/services/s3/model/QuoteFields;", "setQuoteFields", "(Laws/sdk/kotlin/services/s3/model/QuoteFields;)V", "recordDelimiter", "getRecordDelimiter", "setRecordDelimiter", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String fieldDelimiter;
        private String quoteCharacter;
        private String quoteEscapeCharacter;
        private QuoteFields quoteFields;
        private String recordDelimiter;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getFieldDelimiter() {
            return this.fieldDelimiter;
        }

        public final void setFieldDelimiter(String str) {
            this.fieldDelimiter = str;
        }

        public final String getQuoteCharacter() {
            return this.quoteCharacter;
        }

        public final void setQuoteCharacter(String str) {
            this.quoteCharacter = str;
        }

        public final String getQuoteEscapeCharacter() {
            return this.quoteEscapeCharacter;
        }

        public final void setQuoteEscapeCharacter(String str) {
            this.quoteEscapeCharacter = str;
        }

        public final QuoteFields getQuoteFields() {
            return this.quoteFields;
        }

        public final void setQuoteFields(QuoteFields quoteFields) {
            this.quoteFields = quoteFields;
        }

        public final String getRecordDelimiter() {
            return this.recordDelimiter;
        }

        public final void setRecordDelimiter(String str) {
            this.recordDelimiter = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CsvOutput x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.fieldDelimiter = x.getFieldDelimiter();
            this.quoteCharacter = x.getQuoteCharacter();
            this.quoteEscapeCharacter = x.getQuoteEscapeCharacter();
            this.quoteFields = x.getQuoteFields();
            this.recordDelimiter = x.getRecordDelimiter();
        }

        public final CsvOutput build() {
            return new CsvOutput(this, null);
        }
    }
}
