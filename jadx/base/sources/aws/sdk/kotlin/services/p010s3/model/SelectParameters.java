package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ExpressionType;
import aws.sdk.kotlin.services.p010s3.model.InputSerialization;
import aws.sdk.kotlin.services.p010s3.model.OutputSerialization;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SelectParameters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0016\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectParameters;", "", "builder", "Laws/sdk/kotlin/services/s3/model/SelectParameters$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/SelectParameters$Builder;)V", "expression", "", "getExpression", "()Ljava/lang/String;", "expressionType", "Laws/sdk/kotlin/services/s3/model/ExpressionType;", "getExpressionType", "()Laws/sdk/kotlin/services/s3/model/ExpressionType;", "inputSerialization", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "getInputSerialization", "()Laws/sdk/kotlin/services/s3/model/InputSerialization;", "outputSerialization", "Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "getOutputSerialization", "()Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectParameters {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String expression;
    private final ExpressionType expressionType;
    private final InputSerialization inputSerialization;
    private final OutputSerialization outputSerialization;

    public /* synthetic */ SelectParameters(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SelectParameters(Builder builder) {
        String expression = builder.getExpression();
        if (expression == null) {
            throw new IllegalArgumentException("A non-null value must be provided for expression".toString());
        }
        this.expression = expression;
        ExpressionType expressionType = builder.getExpressionType();
        if (expressionType == null) {
            throw new IllegalArgumentException("A non-null value must be provided for expressionType".toString());
        }
        this.expressionType = expressionType;
        this.inputSerialization = builder.getInputSerialization();
        this.outputSerialization = builder.getOutputSerialization();
    }

    public final String getExpression() {
        return this.expression;
    }

    public final ExpressionType getExpressionType() {
        return this.expressionType;
    }

    public final InputSerialization getInputSerialization() {
        return this.inputSerialization;
    }

    public final OutputSerialization getOutputSerialization() {
        return this.outputSerialization;
    }

    /* JADX INFO: compiled from: SelectParameters.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectParameters$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/SelectParameters;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/SelectParameters$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectParameters invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SelectParameters(");
        sb.append("expression=" + this.expression + AbstractJsonLexerKt.COMMA);
        sb.append("expressionType=" + this.expressionType + AbstractJsonLexerKt.COMMA);
        sb.append("inputSerialization=" + this.inputSerialization + AbstractJsonLexerKt.COMMA);
        sb.append("outputSerialization=" + this.outputSerialization);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = ((this.expression.hashCode() * 31) + this.expressionType.hashCode()) * 31;
        InputSerialization inputSerialization = this.inputSerialization;
        int iHashCode2 = (iHashCode + (inputSerialization != null ? inputSerialization.hashCode() : 0)) * 31;
        OutputSerialization outputSerialization = this.outputSerialization;
        return iHashCode2 + (outputSerialization != null ? outputSerialization.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        SelectParameters selectParameters = (SelectParameters) other;
        return Intrinsics.areEqual(this.expression, selectParameters.expression) && Intrinsics.areEqual(this.expressionType, selectParameters.expressionType) && Intrinsics.areEqual(this.inputSerialization, selectParameters.inputSerialization) && Intrinsics.areEqual(this.outputSerialization, selectParameters.outputSerialization);
    }

    public static /* synthetic */ SelectParameters copy$default(SelectParameters selectParameters, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.SelectParameters.copy.1
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
        Builder builder = new Builder(selectParameters);
        block.invoke(builder);
        return builder.build();
    }

    public final SelectParameters copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: SelectParameters.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020\u0005H\u0001J\u001f\u0010\u0013\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\u001f\u0010\u0019\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\r\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0002\b'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectParameters$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/SelectParameters;", "(Laws/sdk/kotlin/services/s3/model/SelectParameters;)V", "expression", "", "getExpression", "()Ljava/lang/String;", "setExpression", "(Ljava/lang/String;)V", "expressionType", "Laws/sdk/kotlin/services/s3/model/ExpressionType;", "getExpressionType", "()Laws/sdk/kotlin/services/s3/model/ExpressionType;", "setExpressionType", "(Laws/sdk/kotlin/services/s3/model/ExpressionType;)V", "inputSerialization", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "getInputSerialization", "()Laws/sdk/kotlin/services/s3/model/InputSerialization;", "setInputSerialization", "(Laws/sdk/kotlin/services/s3/model/InputSerialization;)V", "outputSerialization", "Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "getOutputSerialization", "()Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "setOutputSerialization", "(Laws/sdk/kotlin/services/s3/model/OutputSerialization;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/InputSerialization$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/OutputSerialization$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String expression;
        private ExpressionType expressionType;
        private InputSerialization inputSerialization;
        private OutputSerialization outputSerialization;

        public final String getExpression() {
            return this.expression;
        }

        public final void setExpression(String str) {
            this.expression = str;
        }

        public final ExpressionType getExpressionType() {
            return this.expressionType;
        }

        public final void setExpressionType(ExpressionType expressionType) {
            this.expressionType = expressionType;
        }

        public final InputSerialization getInputSerialization() {
            return this.inputSerialization;
        }

        public final void setInputSerialization(InputSerialization inputSerialization) {
            this.inputSerialization = inputSerialization;
        }

        public final OutputSerialization getOutputSerialization() {
            return this.outputSerialization;
        }

        public final void setOutputSerialization(OutputSerialization outputSerialization) {
            this.outputSerialization = outputSerialization;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(SelectParameters x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.expression = x.getExpression();
            this.expressionType = x.getExpressionType();
            this.inputSerialization = x.getInputSerialization();
            this.outputSerialization = x.getOutputSerialization();
        }

        public final SelectParameters build() {
            return new SelectParameters(this, null);
        }

        public final void inputSerialization(Function1<? super InputSerialization.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.inputSerialization = SelectParametersKt.awsSdkKotlinServicesS3ModelInputSerializationDslBuilderRef.invoke(block);
        }

        public final void outputSerialization(Function1<? super OutputSerialization.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.outputSerialization = SelectParametersKt.awsSdkKotlinServicesS3ModelOutputSerializationDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.expression == null) {
                this.expression = "";
            }
            if (this.expressionType == null) {
                this.expressionType = new ExpressionType.SdkUnknown("no value provided");
            }
            return this;
        }
    }
}
