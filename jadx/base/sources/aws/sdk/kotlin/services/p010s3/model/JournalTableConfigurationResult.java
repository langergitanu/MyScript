package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ErrorDetails;
import aws.sdk.kotlin.services.p010s3.model.RecordExpiration;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: JournalTableConfigurationResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0016\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "", "builder", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult$Builder;)V", "error", "Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "getError", "()Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "recordExpiration", "Laws/sdk/kotlin/services/s3/model/RecordExpiration;", "getRecordExpiration", "()Laws/sdk/kotlin/services/s3/model/RecordExpiration;", "tableArn", "", "getTableArn", "()Ljava/lang/String;", "tableName", "getTableName", "tableStatus", "getTableStatus", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class JournalTableConfigurationResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorDetails error;
    private final RecordExpiration recordExpiration;
    private final String tableArn;
    private final String tableName;
    private final String tableStatus;

    public /* synthetic */ JournalTableConfigurationResult(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private JournalTableConfigurationResult(Builder builder) {
        this.error = builder.getError();
        this.recordExpiration = builder.getRecordExpiration();
        this.tableArn = builder.getTableArn();
        String tableName = builder.getTableName();
        if (tableName == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tableName".toString());
        }
        this.tableName = tableName;
        String tableStatus = builder.getTableStatus();
        if (tableStatus == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tableStatus".toString());
        }
        this.tableStatus = tableStatus;
    }

    public final ErrorDetails getError() {
        return this.error;
    }

    public final RecordExpiration getRecordExpiration() {
        return this.recordExpiration;
    }

    public final String getTableArn() {
        return this.tableArn;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final String getTableStatus() {
        return this.tableStatus;
    }

    /* JADX INFO: compiled from: JournalTableConfigurationResult.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JournalTableConfigurationResult invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JournalTableConfigurationResult(");
        sb.append("error=" + this.error + AbstractJsonLexerKt.COMMA);
        sb.append("recordExpiration=" + this.recordExpiration + AbstractJsonLexerKt.COMMA);
        sb.append("tableArn=" + this.tableArn + AbstractJsonLexerKt.COMMA);
        sb.append("tableName=" + this.tableName + AbstractJsonLexerKt.COMMA);
        sb.append("tableStatus=" + this.tableStatus);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        ErrorDetails errorDetails = this.error;
        int iHashCode = (errorDetails != null ? errorDetails.hashCode() : 0) * 31;
        RecordExpiration recordExpiration = this.recordExpiration;
        int iHashCode2 = (iHashCode + (recordExpiration != null ? recordExpiration.hashCode() : 0)) * 31;
        String str = this.tableArn;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.tableName.hashCode()) * 31) + this.tableStatus.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        JournalTableConfigurationResult journalTableConfigurationResult = (JournalTableConfigurationResult) other;
        return Intrinsics.areEqual(this.error, journalTableConfigurationResult.error) && Intrinsics.areEqual(this.recordExpiration, journalTableConfigurationResult.recordExpiration) && Intrinsics.areEqual(this.tableArn, journalTableConfigurationResult.tableArn) && Intrinsics.areEqual(this.tableName, journalTableConfigurationResult.tableName) && Intrinsics.areEqual(this.tableStatus, journalTableConfigurationResult.tableStatus);
    }

    public static /* synthetic */ JournalTableConfigurationResult copy$default(JournalTableConfigurationResult journalTableConfigurationResult, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.JournalTableConfigurationResult.copy.1
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
        Builder builder = new Builder(journalTableConfigurationResult);
        block.invoke(builder);
        return builder.build();
    }

    public final JournalTableConfigurationResult copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: JournalTableConfigurationResult.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\u001f\u0010\r\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\"¢\u0006\u0002\b$J\r\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0002\b'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "(Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;)V", "error", "Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "getError", "()Laws/sdk/kotlin/services/s3/model/ErrorDetails;", "setError", "(Laws/sdk/kotlin/services/s3/model/ErrorDetails;)V", "recordExpiration", "Laws/sdk/kotlin/services/s3/model/RecordExpiration;", "getRecordExpiration", "()Laws/sdk/kotlin/services/s3/model/RecordExpiration;", "setRecordExpiration", "(Laws/sdk/kotlin/services/s3/model/RecordExpiration;)V", "tableArn", "", "getTableArn", "()Ljava/lang/String;", "setTableArn", "(Ljava/lang/String;)V", "tableName", "getTableName", "setTableName", "tableStatus", "getTableStatus", "setTableStatus", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ErrorDetails$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/RecordExpiration$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private ErrorDetails error;
        private RecordExpiration recordExpiration;
        private String tableArn;
        private String tableName;
        private String tableStatus;

        public final ErrorDetails getError() {
            return this.error;
        }

        public final void setError(ErrorDetails errorDetails) {
            this.error = errorDetails;
        }

        public final RecordExpiration getRecordExpiration() {
            return this.recordExpiration;
        }

        public final void setRecordExpiration(RecordExpiration recordExpiration) {
            this.recordExpiration = recordExpiration;
        }

        public final String getTableArn() {
            return this.tableArn;
        }

        public final void setTableArn(String str) {
            this.tableArn = str;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public final void setTableName(String str) {
            this.tableName = str;
        }

        public final String getTableStatus() {
            return this.tableStatus;
        }

        public final void setTableStatus(String str) {
            this.tableStatus = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(JournalTableConfigurationResult x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.error = x.getError();
            this.recordExpiration = x.getRecordExpiration();
            this.tableArn = x.getTableArn();
            this.tableName = x.getTableName();
            this.tableStatus = x.getTableStatus();
        }

        public final JournalTableConfigurationResult build() {
            return new JournalTableConfigurationResult(this, null);
        }

        public final void error(Function1<? super ErrorDetails.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.error = JournalTableConfigurationResultKt.awsSdkKotlinServicesS3ModelErrorDetailsDslBuilderRef.invoke(block);
        }

        public final void recordExpiration(Function1<? super RecordExpiration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.recordExpiration = JournalTableConfigurationResultKt.awsSdkKotlinServicesS3ModelRecordExpirationDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.tableName == null) {
                this.tableName = "";
            }
            if (this.tableStatus == null) {
                this.tableStatus = "";
            }
            return this;
        }
    }
}
