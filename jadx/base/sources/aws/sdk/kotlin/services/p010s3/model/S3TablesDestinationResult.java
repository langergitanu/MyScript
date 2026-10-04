package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: S3TablesDestinationResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0010\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0016\u001a\u00020\u00002\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult;", "", "builder", "Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult$Builder;)V", "tableArn", "", "getTableArn", "()Ljava/lang/String;", "tableBucketArn", "getTableBucketArn", "tableName", "getTableName", "tableNamespace", "getTableNamespace", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3TablesDestinationResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String tableArn;
    private final String tableBucketArn;
    private final String tableName;
    private final String tableNamespace;

    public /* synthetic */ S3TablesDestinationResult(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private S3TablesDestinationResult(Builder builder) {
        String tableArn = builder.getTableArn();
        if (tableArn == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tableArn".toString());
        }
        this.tableArn = tableArn;
        String tableBucketArn = builder.getTableBucketArn();
        if (tableBucketArn == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tableBucketArn".toString());
        }
        this.tableBucketArn = tableBucketArn;
        String tableName = builder.getTableName();
        if (tableName == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tableName".toString());
        }
        this.tableName = tableName;
        String tableNamespace = builder.getTableNamespace();
        if (tableNamespace == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tableNamespace".toString());
        }
        this.tableNamespace = tableNamespace;
    }

    public final String getTableArn() {
        return this.tableArn;
    }

    public final String getTableBucketArn() {
        return this.tableBucketArn;
    }

    public final String getTableName() {
        return this.tableName;
    }

    public final String getTableNamespace() {
        return this.tableNamespace;
    }

    /* JADX INFO: compiled from: S3TablesDestinationResult.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final S3TablesDestinationResult invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("S3TablesDestinationResult(");
        sb.append("tableArn=" + this.tableArn + AbstractJsonLexerKt.COMMA);
        sb.append("tableBucketArn=" + this.tableBucketArn + AbstractJsonLexerKt.COMMA);
        sb.append("tableName=" + this.tableName + AbstractJsonLexerKt.COMMA);
        sb.append("tableNamespace=" + this.tableNamespace);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        return (((((this.tableArn.hashCode() * 31) + this.tableBucketArn.hashCode()) * 31) + this.tableName.hashCode()) * 31) + this.tableNamespace.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        S3TablesDestinationResult s3TablesDestinationResult = (S3TablesDestinationResult) other;
        return Intrinsics.areEqual(this.tableArn, s3TablesDestinationResult.tableArn) && Intrinsics.areEqual(this.tableBucketArn, s3TablesDestinationResult.tableBucketArn) && Intrinsics.areEqual(this.tableName, s3TablesDestinationResult.tableName) && Intrinsics.areEqual(this.tableNamespace, s3TablesDestinationResult.tableNamespace);
    }

    public static /* synthetic */ S3TablesDestinationResult copy$default(S3TablesDestinationResult s3TablesDestinationResult, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.S3TablesDestinationResult.copy.1
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
        Builder builder = new Builder(s3TablesDestinationResult);
        block.invoke(builder);
        return builder.build();
    }

    public final S3TablesDestinationResult copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: S3TablesDestinationResult.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0005H\u0001J\r\u0010\u0017\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\u0019"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult;", "(Laws/sdk/kotlin/services/s3/model/S3TablesDestinationResult;)V", "tableArn", "", "getTableArn", "()Ljava/lang/String;", "setTableArn", "(Ljava/lang/String;)V", "tableBucketArn", "getTableBucketArn", "setTableBucketArn", "tableName", "getTableName", "setTableName", "tableNamespace", "getTableNamespace", "setTableNamespace", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String tableArn;
        private String tableBucketArn;
        private String tableName;
        private String tableNamespace;

        public final String getTableArn() {
            return this.tableArn;
        }

        public final void setTableArn(String str) {
            this.tableArn = str;
        }

        public final String getTableBucketArn() {
            return this.tableBucketArn;
        }

        public final void setTableBucketArn(String str) {
            this.tableBucketArn = str;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public final void setTableName(String str) {
            this.tableName = str;
        }

        public final String getTableNamespace() {
            return this.tableNamespace;
        }

        public final void setTableNamespace(String str) {
            this.tableNamespace = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(S3TablesDestinationResult x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.tableArn = x.getTableArn();
            this.tableBucketArn = x.getTableBucketArn();
            this.tableName = x.getTableName();
            this.tableNamespace = x.getTableNamespace();
        }

        public final S3TablesDestinationResult build() {
            return new S3TablesDestinationResult(this, null);
        }

        public final Builder correctErrors$s3() {
            if (this.tableArn == null) {
                this.tableArn = "";
            }
            if (this.tableBucketArn == null) {
                this.tableBucketArn = "";
            }
            if (this.tableName == null) {
                this.tableName = "";
            }
            if (this.tableNamespace == null) {
                this.tableNamespace = "";
            }
            return this;
        }
    }
}
