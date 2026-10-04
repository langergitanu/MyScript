package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CsvInput.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004J\u0014\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010 \u001a\u00020\u00002\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"¢\u0006\u0002\b$H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CsvInput;", "", "builder", "Laws/sdk/kotlin/services/s3/model/CsvInput$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/CsvInput$Builder;)V", "allowQuotedRecordDelimiter", "", "getAllowQuotedRecordDelimiter", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "comments", "", "getComments", "()Ljava/lang/String;", "fieldDelimiter", "getFieldDelimiter", "fileHeaderInfo", "Laws/sdk/kotlin/services/s3/model/FileHeaderInfo;", "getFileHeaderInfo", "()Laws/sdk/kotlin/services/s3/model/FileHeaderInfo;", "quoteCharacter", "getQuoteCharacter", "quoteEscapeCharacter", "getQuoteEscapeCharacter", "recordDelimiter", "getRecordDelimiter", "toString", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CsvInput {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean allowQuotedRecordDelimiter;
    private final String comments;
    private final String fieldDelimiter;
    private final FileHeaderInfo fileHeaderInfo;
    private final String quoteCharacter;
    private final String quoteEscapeCharacter;
    private final String recordDelimiter;

    public /* synthetic */ CsvInput(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CsvInput(Builder builder) {
        this.allowQuotedRecordDelimiter = builder.getAllowQuotedRecordDelimiter();
        this.comments = builder.getComments();
        this.fieldDelimiter = builder.getFieldDelimiter();
        this.fileHeaderInfo = builder.getFileHeaderInfo();
        this.quoteCharacter = builder.getQuoteCharacter();
        this.quoteEscapeCharacter = builder.getQuoteEscapeCharacter();
        this.recordDelimiter = builder.getRecordDelimiter();
    }

    public final Boolean getAllowQuotedRecordDelimiter() {
        return this.allowQuotedRecordDelimiter;
    }

    public final String getComments() {
        return this.comments;
    }

    public final String getFieldDelimiter() {
        return this.fieldDelimiter;
    }

    public final FileHeaderInfo getFileHeaderInfo() {
        return this.fileHeaderInfo;
    }

    public final String getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public final String getQuoteEscapeCharacter() {
        return this.quoteEscapeCharacter;
    }

    public final String getRecordDelimiter() {
        return this.recordDelimiter;
    }

    /* JADX INFO: compiled from: CsvInput.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CsvInput$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/CsvInput;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CsvInput$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CsvInput invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CsvInput(");
        sb.append("allowQuotedRecordDelimiter=" + this.allowQuotedRecordDelimiter + AbstractJsonLexerKt.COMMA);
        sb.append("comments=" + this.comments + AbstractJsonLexerKt.COMMA);
        sb.append("fieldDelimiter=" + this.fieldDelimiter + AbstractJsonLexerKt.COMMA);
        sb.append("fileHeaderInfo=" + this.fileHeaderInfo + AbstractJsonLexerKt.COMMA);
        sb.append("quoteCharacter=" + this.quoteCharacter + AbstractJsonLexerKt.COMMA);
        sb.append("quoteEscapeCharacter=" + this.quoteEscapeCharacter + AbstractJsonLexerKt.COMMA);
        sb.append("recordDelimiter=" + this.recordDelimiter);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.allowQuotedRecordDelimiter;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        String str = this.comments;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.fieldDelimiter;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        FileHeaderInfo fileHeaderInfo = this.fileHeaderInfo;
        int iHashCode4 = (iHashCode3 + (fileHeaderInfo != null ? fileHeaderInfo.hashCode() : 0)) * 31;
        String str3 = this.quoteCharacter;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.quoteEscapeCharacter;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.recordDelimiter;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CsvInput csvInput = (CsvInput) other;
        return Intrinsics.areEqual(this.allowQuotedRecordDelimiter, csvInput.allowQuotedRecordDelimiter) && Intrinsics.areEqual(this.comments, csvInput.comments) && Intrinsics.areEqual(this.fieldDelimiter, csvInput.fieldDelimiter) && Intrinsics.areEqual(this.fileHeaderInfo, csvInput.fileHeaderInfo) && Intrinsics.areEqual(this.quoteCharacter, csvInput.quoteCharacter) && Intrinsics.areEqual(this.quoteEscapeCharacter, csvInput.quoteEscapeCharacter) && Intrinsics.areEqual(this.recordDelimiter, csvInput.recordDelimiter);
    }

    public static /* synthetic */ CsvInput copy$default(CsvInput csvInput, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.CsvInput.copy.1
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
        Builder builder = new Builder(csvInput);
        block.invoke(builder);
        return builder.build();
    }

    public final CsvInput copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CsvInput.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010&\u001a\u00020\u0005H\u0001J\r\u0010'\u001a\u00020\u0000H\u0000¢\u0006\u0002\b(R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013¨\u0006)"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/CsvInput$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/CsvInput;", "(Laws/sdk/kotlin/services/s3/model/CsvInput;)V", "allowQuotedRecordDelimiter", "", "getAllowQuotedRecordDelimiter", "()Ljava/lang/Boolean;", "setAllowQuotedRecordDelimiter", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "comments", "", "getComments", "()Ljava/lang/String;", "setComments", "(Ljava/lang/String;)V", "fieldDelimiter", "getFieldDelimiter", "setFieldDelimiter", "fileHeaderInfo", "Laws/sdk/kotlin/services/s3/model/FileHeaderInfo;", "getFileHeaderInfo", "()Laws/sdk/kotlin/services/s3/model/FileHeaderInfo;", "setFileHeaderInfo", "(Laws/sdk/kotlin/services/s3/model/FileHeaderInfo;)V", "quoteCharacter", "getQuoteCharacter", "setQuoteCharacter", "quoteEscapeCharacter", "getQuoteEscapeCharacter", "setQuoteEscapeCharacter", "recordDelimiter", "getRecordDelimiter", "setRecordDelimiter", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean allowQuotedRecordDelimiter;
        private String comments;
        private String fieldDelimiter;
        private FileHeaderInfo fileHeaderInfo;
        private String quoteCharacter;
        private String quoteEscapeCharacter;
        private String recordDelimiter;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Boolean getAllowQuotedRecordDelimiter() {
            return this.allowQuotedRecordDelimiter;
        }

        public final void setAllowQuotedRecordDelimiter(Boolean bool) {
            this.allowQuotedRecordDelimiter = bool;
        }

        public final String getComments() {
            return this.comments;
        }

        public final void setComments(String str) {
            this.comments = str;
        }

        public final String getFieldDelimiter() {
            return this.fieldDelimiter;
        }

        public final void setFieldDelimiter(String str) {
            this.fieldDelimiter = str;
        }

        public final FileHeaderInfo getFileHeaderInfo() {
            return this.fileHeaderInfo;
        }

        public final void setFileHeaderInfo(FileHeaderInfo fileHeaderInfo) {
            this.fileHeaderInfo = fileHeaderInfo;
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

        public final String getRecordDelimiter() {
            return this.recordDelimiter;
        }

        public final void setRecordDelimiter(String str) {
            this.recordDelimiter = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CsvInput x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.allowQuotedRecordDelimiter = x.getAllowQuotedRecordDelimiter();
            this.comments = x.getComments();
            this.fieldDelimiter = x.getFieldDelimiter();
            this.fileHeaderInfo = x.getFileHeaderInfo();
            this.quoteCharacter = x.getQuoteCharacter();
            this.quoteEscapeCharacter = x.getQuoteEscapeCharacter();
            this.recordDelimiter = x.getRecordDelimiter();
        }

        public final CsvInput build() {
            return new CsvInput(this, null);
        }
    }
}
