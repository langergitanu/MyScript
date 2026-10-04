package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.CsvInput;
import aws.sdk.kotlin.services.p010s3.model.JsonInput;
import aws.sdk.kotlin.services.p010s3.model.ParquetInput;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: InputSerialization.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0019H\u0096\u0080\u0004J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001d\u001a\u00020\u00002\u0019\b\u0002\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InputSerialization;", "", "builder", "Laws/sdk/kotlin/services/s3/model/InputSerialization$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/InputSerialization$Builder;)V", "compressionType", "Laws/sdk/kotlin/services/s3/model/CompressionType;", "getCompressionType", "()Laws/sdk/kotlin/services/s3/model/CompressionType;", "csv", "Laws/sdk/kotlin/services/s3/model/CsvInput;", "getCsv", "()Laws/sdk/kotlin/services/s3/model/CsvInput;", "json", "Laws/sdk/kotlin/services/s3/model/JsonInput;", "getJson", "()Laws/sdk/kotlin/services/s3/model/JsonInput;", "parquet", "Laws/sdk/kotlin/services/s3/model/ParquetInput;", "getParquet", "()Laws/sdk/kotlin/services/s3/model/ParquetInput;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InputSerialization {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CompressionType compressionType;
    private final CsvInput csv;
    private final JsonInput json;
    private final ParquetInput parquet;

    public /* synthetic */ InputSerialization(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private InputSerialization(Builder builder) {
        this.compressionType = builder.getCompressionType();
        this.csv = builder.getCsv();
        this.json = builder.getJson();
        this.parquet = builder.getParquet();
    }

    public final CompressionType getCompressionType() {
        return this.compressionType;
    }

    public final CsvInput getCsv() {
        return this.csv;
    }

    public final JsonInput getJson() {
        return this.json;
    }

    public final ParquetInput getParquet() {
        return this.parquet;
    }

    /* JADX INFO: compiled from: InputSerialization.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InputSerialization$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/InputSerialization$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InputSerialization invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InputSerialization(");
        sb.append("compressionType=" + this.compressionType + AbstractJsonLexerKt.COMMA);
        sb.append("csv=" + this.csv + AbstractJsonLexerKt.COMMA);
        sb.append("json=" + this.json + AbstractJsonLexerKt.COMMA);
        sb.append("parquet=" + this.parquet);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        CompressionType compressionType = this.compressionType;
        int iHashCode = (compressionType != null ? compressionType.hashCode() : 0) * 31;
        CsvInput csvInput = this.csv;
        int iHashCode2 = (iHashCode + (csvInput != null ? csvInput.hashCode() : 0)) * 31;
        JsonInput jsonInput = this.json;
        int iHashCode3 = (iHashCode2 + (jsonInput != null ? jsonInput.hashCode() : 0)) * 31;
        ParquetInput parquetInput = this.parquet;
        return iHashCode3 + (parquetInput != null ? parquetInput.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        InputSerialization inputSerialization = (InputSerialization) other;
        return Intrinsics.areEqual(this.compressionType, inputSerialization.compressionType) && Intrinsics.areEqual(this.csv, inputSerialization.csv) && Intrinsics.areEqual(this.json, inputSerialization.json) && Intrinsics.areEqual(this.parquet, inputSerialization.parquet);
    }

    public static /* synthetic */ InputSerialization copy$default(InputSerialization inputSerialization, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.InputSerialization.copy.1
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
        Builder builder = new Builder(inputSerialization);
        block.invoke(builder);
        return builder.build();
    }

    public final InputSerialization copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: InputSerialization.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020\u0005H\u0001J\u001f\u0010\r\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\u001f\u0010\u0013\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\u001f\u0010\u0019\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\r\u0010'\u001a\u00020\u0000H\u0000¢\u0006\u0002\b(R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006)"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/InputSerialization$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "(Laws/sdk/kotlin/services/s3/model/InputSerialization;)V", "compressionType", "Laws/sdk/kotlin/services/s3/model/CompressionType;", "getCompressionType", "()Laws/sdk/kotlin/services/s3/model/CompressionType;", "setCompressionType", "(Laws/sdk/kotlin/services/s3/model/CompressionType;)V", "csv", "Laws/sdk/kotlin/services/s3/model/CsvInput;", "getCsv", "()Laws/sdk/kotlin/services/s3/model/CsvInput;", "setCsv", "(Laws/sdk/kotlin/services/s3/model/CsvInput;)V", "json", "Laws/sdk/kotlin/services/s3/model/JsonInput;", "getJson", "()Laws/sdk/kotlin/services/s3/model/JsonInput;", "setJson", "(Laws/sdk/kotlin/services/s3/model/JsonInput;)V", "parquet", "Laws/sdk/kotlin/services/s3/model/ParquetInput;", "getParquet", "()Laws/sdk/kotlin/services/s3/model/ParquetInput;", "setParquet", "(Laws/sdk/kotlin/services/s3/model/ParquetInput;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/CsvInput$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/JsonInput$Builder;", "Laws/sdk/kotlin/services/s3/model/ParquetInput$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private CompressionType compressionType;
        private CsvInput csv;
        private JsonInput json;
        private ParquetInput parquet;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final CompressionType getCompressionType() {
            return this.compressionType;
        }

        public final void setCompressionType(CompressionType compressionType) {
            this.compressionType = compressionType;
        }

        public final CsvInput getCsv() {
            return this.csv;
        }

        public final void setCsv(CsvInput csvInput) {
            this.csv = csvInput;
        }

        public final JsonInput getJson() {
            return this.json;
        }

        public final void setJson(JsonInput jsonInput) {
            this.json = jsonInput;
        }

        public final ParquetInput getParquet() {
            return this.parquet;
        }

        public final void setParquet(ParquetInput parquetInput) {
            this.parquet = parquetInput;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(InputSerialization x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.compressionType = x.getCompressionType();
            this.csv = x.getCsv();
            this.json = x.getJson();
            this.parquet = x.getParquet();
        }

        public final InputSerialization build() {
            return new InputSerialization(this, null);
        }

        public final void csv(Function1<? super CsvInput.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.csv = InputSerializationKt.awsSdkKotlinServicesS3ModelCsvInputDslBuilderRef.invoke(block);
        }

        public final void json(Function1<? super JsonInput.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.json = InputSerializationKt.awsSdkKotlinServicesS3ModelJsonInputDslBuilderRef.invoke(block);
        }

        public final void parquet(Function1<? super ParquetInput.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.parquet = InputSerializationKt.awsSdkKotlinServicesS3ModelParquetInputDslBuilderRef.invoke(block);
        }
    }
}
