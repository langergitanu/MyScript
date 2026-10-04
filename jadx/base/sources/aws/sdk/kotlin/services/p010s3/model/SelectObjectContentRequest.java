package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.InputSerialization;
import aws.sdk.kotlin.services.p010s3.model.OutputSerialization;
import aws.sdk.kotlin.services.p010s3.model.RequestProgress;
import aws.sdk.kotlin.services.p010s3.model.ScanRange;
import aws.smithy.kotlin.runtime.SdkDsl;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SelectObjectContentRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00020\u0001:\u000256B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010*\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010+\u001a\u00020,H\u0096\u0080\u0004J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u00100\u001a\u00020\u00002\u0019\b\u0002\u00101\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020302¢\u0006\u0002\b4H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR\u0013\u0010&\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\tR\u0013\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;", "", "builder", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest$Builder;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "expectedBucketOwner", "getExpectedBucketOwner", "expression", "getExpression", "expressionType", "Laws/sdk/kotlin/services/s3/model/ExpressionType;", "getExpressionType", "()Laws/sdk/kotlin/services/s3/model/ExpressionType;", "inputSerialization", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "getInputSerialization", "()Laws/sdk/kotlin/services/s3/model/InputSerialization;", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "outputSerialization", "Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "getOutputSerialization", "()Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "requestProgress", "Laws/sdk/kotlin/services/s3/model/RequestProgress;", "getRequestProgress", "()Laws/sdk/kotlin/services/s3/model/RequestProgress;", "scanRange", "Laws/sdk/kotlin/services/s3/model/ScanRange;", "getScanRange", "()Laws/sdk/kotlin/services/s3/model/ScanRange;", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectObjectContentRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bucket;
    private final String expectedBucketOwner;
    private final String expression;
    private final ExpressionType expressionType;
    private final InputSerialization inputSerialization;
    private final String key;
    private final OutputSerialization outputSerialization;
    private final RequestProgress requestProgress;
    private final ScanRange scanRange;
    private final String sseCustomerAlgorithm;
    private final String sseCustomerKey;
    private final String sseCustomerKeyMd5;

    public /* synthetic */ SelectObjectContentRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SelectObjectContentRequest(Builder builder) {
        this.bucket = builder.getBucket();
        this.expectedBucketOwner = builder.getExpectedBucketOwner();
        this.expression = builder.getExpression();
        this.expressionType = builder.getExpressionType();
        this.inputSerialization = builder.getInputSerialization();
        this.key = builder.getKey();
        this.outputSerialization = builder.getOutputSerialization();
        this.requestProgress = builder.getRequestProgress();
        this.scanRange = builder.getScanRange();
        this.sseCustomerAlgorithm = builder.getSseCustomerAlgorithm();
        this.sseCustomerKey = builder.getSseCustomerKey();
        this.sseCustomerKeyMd5 = builder.getSseCustomerKeyMd5();
    }

    public final String getBucket() {
        return this.bucket;
    }

    public final String getExpectedBucketOwner() {
        return this.expectedBucketOwner;
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

    public final String getKey() {
        return this.key;
    }

    public final OutputSerialization getOutputSerialization() {
        return this.outputSerialization;
    }

    public final RequestProgress getRequestProgress() {
        return this.requestProgress;
    }

    public final ScanRange getScanRange() {
        return this.scanRange;
    }

    public final String getSseCustomerAlgorithm() {
        return this.sseCustomerAlgorithm;
    }

    public final String getSseCustomerKey() {
        return this.sseCustomerKey;
    }

    public final String getSseCustomerKeyMd5() {
        return this.sseCustomerKeyMd5;
    }

    /* JADX INFO: compiled from: SelectObjectContentRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectObjectContentRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SelectObjectContentRequest(");
        sb.append("bucket=" + this.bucket + AbstractJsonLexerKt.COMMA);
        sb.append("expectedBucketOwner=" + this.expectedBucketOwner + AbstractJsonLexerKt.COMMA);
        sb.append("expression=" + this.expression + AbstractJsonLexerKt.COMMA);
        sb.append("expressionType=" + this.expressionType + AbstractJsonLexerKt.COMMA);
        sb.append("inputSerialization=" + this.inputSerialization + AbstractJsonLexerKt.COMMA);
        sb.append("key=" + this.key + AbstractJsonLexerKt.COMMA);
        sb.append("outputSerialization=" + this.outputSerialization + AbstractJsonLexerKt.COMMA);
        sb.append("requestProgress=" + this.requestProgress + AbstractJsonLexerKt.COMMA);
        sb.append("scanRange=" + this.scanRange + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerAlgorithm=" + this.sseCustomerAlgorithm + AbstractJsonLexerKt.COMMA);
        sb.append("sseCustomerKey=*** Sensitive Data Redacted ***,");
        sb.append("sseCustomerKeyMd5=" + this.sseCustomerKeyMd5);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bucket;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.expectedBucketOwner;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.expression;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        ExpressionType expressionType = this.expressionType;
        int iHashCode4 = (iHashCode3 + (expressionType != null ? expressionType.hashCode() : 0)) * 31;
        InputSerialization inputSerialization = this.inputSerialization;
        int iHashCode5 = (iHashCode4 + (inputSerialization != null ? inputSerialization.hashCode() : 0)) * 31;
        String str4 = this.key;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        OutputSerialization outputSerialization = this.outputSerialization;
        int iHashCode7 = (iHashCode6 + (outputSerialization != null ? outputSerialization.hashCode() : 0)) * 31;
        RequestProgress requestProgress = this.requestProgress;
        int iHashCode8 = (iHashCode7 + (requestProgress != null ? requestProgress.hashCode() : 0)) * 31;
        ScanRange scanRange = this.scanRange;
        int iHashCode9 = (iHashCode8 + (scanRange != null ? scanRange.hashCode() : 0)) * 31;
        String str5 = this.sseCustomerAlgorithm;
        int iHashCode10 = (iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.sseCustomerKey;
        int iHashCode11 = (iHashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.sseCustomerKeyMd5;
        return iHashCode11 + (str7 != null ? str7.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        SelectObjectContentRequest selectObjectContentRequest = (SelectObjectContentRequest) other;
        return Intrinsics.areEqual(this.bucket, selectObjectContentRequest.bucket) && Intrinsics.areEqual(this.expectedBucketOwner, selectObjectContentRequest.expectedBucketOwner) && Intrinsics.areEqual(this.expression, selectObjectContentRequest.expression) && Intrinsics.areEqual(this.expressionType, selectObjectContentRequest.expressionType) && Intrinsics.areEqual(this.inputSerialization, selectObjectContentRequest.inputSerialization) && Intrinsics.areEqual(this.key, selectObjectContentRequest.key) && Intrinsics.areEqual(this.outputSerialization, selectObjectContentRequest.outputSerialization) && Intrinsics.areEqual(this.requestProgress, selectObjectContentRequest.requestProgress) && Intrinsics.areEqual(this.scanRange, selectObjectContentRequest.scanRange) && Intrinsics.areEqual(this.sseCustomerAlgorithm, selectObjectContentRequest.sseCustomerAlgorithm) && Intrinsics.areEqual(this.sseCustomerKey, selectObjectContentRequest.sseCustomerKey) && Intrinsics.areEqual(this.sseCustomerKeyMd5, selectObjectContentRequest.sseCustomerKeyMd5);
    }

    public static /* synthetic */ SelectObjectContentRequest copy$default(SelectObjectContentRequest selectObjectContentRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.SelectObjectContentRequest.copy.1
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
        Builder builder = new Builder(selectObjectContentRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final SelectObjectContentRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: SelectObjectContentRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010=\u001a\u00020\u0005H\u0001J\u001f\u0010\u0019\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020>0@¢\u0006\u0002\bBJ\u001f\u0010\"\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020>0@¢\u0006\u0002\bBJ\u001f\u0010(\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020>0@¢\u0006\u0002\bBJ\u001f\u0010.\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020>0@¢\u0006\u0002\bBJ\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR\u001c\u00107\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR\u001c\u0010:\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010\f¨\u0006H"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;", "(Laws/sdk/kotlin/services/s3/model/SelectObjectContentRequest;)V", "bucket", "", "getBucket", "()Ljava/lang/String;", "setBucket", "(Ljava/lang/String;)V", "expectedBucketOwner", "getExpectedBucketOwner", "setExpectedBucketOwner", "expression", "getExpression", "setExpression", "expressionType", "Laws/sdk/kotlin/services/s3/model/ExpressionType;", "getExpressionType", "()Laws/sdk/kotlin/services/s3/model/ExpressionType;", "setExpressionType", "(Laws/sdk/kotlin/services/s3/model/ExpressionType;)V", "inputSerialization", "Laws/sdk/kotlin/services/s3/model/InputSerialization;", "getInputSerialization", "()Laws/sdk/kotlin/services/s3/model/InputSerialization;", "setInputSerialization", "(Laws/sdk/kotlin/services/s3/model/InputSerialization;)V", SubscriberAttributeKt.JSON_NAME_KEY, "getKey", "setKey", "outputSerialization", "Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "getOutputSerialization", "()Laws/sdk/kotlin/services/s3/model/OutputSerialization;", "setOutputSerialization", "(Laws/sdk/kotlin/services/s3/model/OutputSerialization;)V", "requestProgress", "Laws/sdk/kotlin/services/s3/model/RequestProgress;", "getRequestProgress", "()Laws/sdk/kotlin/services/s3/model/RequestProgress;", "setRequestProgress", "(Laws/sdk/kotlin/services/s3/model/RequestProgress;)V", "scanRange", "Laws/sdk/kotlin/services/s3/model/ScanRange;", "getScanRange", "()Laws/sdk/kotlin/services/s3/model/ScanRange;", "setScanRange", "(Laws/sdk/kotlin/services/s3/model/ScanRange;)V", "sseCustomerAlgorithm", "getSseCustomerAlgorithm", "setSseCustomerAlgorithm", "sseCustomerKey", "getSseCustomerKey", "setSseCustomerKey", "sseCustomerKeyMd5", "getSseCustomerKeyMd5", "setSseCustomerKeyMd5", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/InputSerialization$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/OutputSerialization$Builder;", "Laws/sdk/kotlin/services/s3/model/RequestProgress$Builder;", "Laws/sdk/kotlin/services/s3/model/ScanRange$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String bucket;
        private String expectedBucketOwner;
        private String expression;
        private ExpressionType expressionType;
        private InputSerialization inputSerialization;
        private String key;
        private OutputSerialization outputSerialization;
        private RequestProgress requestProgress;
        private ScanRange scanRange;
        private String sseCustomerAlgorithm;
        private String sseCustomerKey;
        private String sseCustomerKeyMd5;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final String getBucket() {
            return this.bucket;
        }

        public final void setBucket(String str) {
            this.bucket = str;
        }

        public final String getExpectedBucketOwner() {
            return this.expectedBucketOwner;
        }

        public final void setExpectedBucketOwner(String str) {
            this.expectedBucketOwner = str;
        }

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

        public final String getKey() {
            return this.key;
        }

        public final void setKey(String str) {
            this.key = str;
        }

        public final OutputSerialization getOutputSerialization() {
            return this.outputSerialization;
        }

        public final void setOutputSerialization(OutputSerialization outputSerialization) {
            this.outputSerialization = outputSerialization;
        }

        public final RequestProgress getRequestProgress() {
            return this.requestProgress;
        }

        public final void setRequestProgress(RequestProgress requestProgress) {
            this.requestProgress = requestProgress;
        }

        public final ScanRange getScanRange() {
            return this.scanRange;
        }

        public final void setScanRange(ScanRange scanRange) {
            this.scanRange = scanRange;
        }

        public final String getSseCustomerAlgorithm() {
            return this.sseCustomerAlgorithm;
        }

        public final void setSseCustomerAlgorithm(String str) {
            this.sseCustomerAlgorithm = str;
        }

        public final String getSseCustomerKey() {
            return this.sseCustomerKey;
        }

        public final void setSseCustomerKey(String str) {
            this.sseCustomerKey = str;
        }

        public final String getSseCustomerKeyMd5() {
            return this.sseCustomerKeyMd5;
        }

        public final void setSseCustomerKeyMd5(String str) {
            this.sseCustomerKeyMd5 = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(SelectObjectContentRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.bucket = x.getBucket();
            this.expectedBucketOwner = x.getExpectedBucketOwner();
            this.expression = x.getExpression();
            this.expressionType = x.getExpressionType();
            this.inputSerialization = x.getInputSerialization();
            this.key = x.getKey();
            this.outputSerialization = x.getOutputSerialization();
            this.requestProgress = x.getRequestProgress();
            this.scanRange = x.getScanRange();
            this.sseCustomerAlgorithm = x.getSseCustomerAlgorithm();
            this.sseCustomerKey = x.getSseCustomerKey();
            this.sseCustomerKeyMd5 = x.getSseCustomerKeyMd5();
        }

        public final SelectObjectContentRequest build() {
            return new SelectObjectContentRequest(this, null);
        }

        public final void inputSerialization(Function1<? super InputSerialization.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.inputSerialization = SelectObjectContentRequestKt.awsSdkKotlinServicesS3ModelInputSerializationDslBuilderRef.invoke(block);
        }

        public final void outputSerialization(Function1<? super OutputSerialization.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.outputSerialization = SelectObjectContentRequestKt.awsSdkKotlinServicesS3ModelOutputSerializationDslBuilderRef.invoke(block);
        }

        public final void requestProgress(Function1<? super RequestProgress.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.requestProgress = SelectObjectContentRequestKt.awsSdkKotlinServicesS3ModelRequestProgressDslBuilderRef.invoke(block);
        }

        public final void scanRange(Function1<? super ScanRange.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.scanRange = SelectObjectContentRequestKt.awsSdkKotlinServicesS3ModelScanRangeDslBuilderRef.invoke(block);
        }
    }
}
