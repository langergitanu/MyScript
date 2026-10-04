package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.TargetObjectKeyFormat;
import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: LoggingEnabled.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002 !B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0015\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0017H\u0096\u0080\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001b\u001a\u00020\u00002\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fH\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LoggingEnabled;", "", "builder", "Laws/sdk/kotlin/services/s3/model/LoggingEnabled$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/LoggingEnabled$Builder;)V", "targetBucket", "", "getTargetBucket", "()Ljava/lang/String;", "targetGrants", "", "Laws/sdk/kotlin/services/s3/model/TargetGrant;", "getTargetGrants", "()Ljava/util/List;", "targetObjectKeyFormat", "Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat;", "getTargetObjectKeyFormat", "()Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat;", "targetPrefix", "getTargetPrefix", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoggingEnabled {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String targetBucket;
    private final List<TargetGrant> targetGrants;
    private final TargetObjectKeyFormat targetObjectKeyFormat;
    private final String targetPrefix;

    public /* synthetic */ LoggingEnabled(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private LoggingEnabled(Builder builder) {
        String targetBucket = builder.getTargetBucket();
        if (targetBucket == null) {
            throw new IllegalArgumentException("A non-null value must be provided for targetBucket".toString());
        }
        this.targetBucket = targetBucket;
        this.targetGrants = builder.getTargetGrants();
        this.targetObjectKeyFormat = builder.getTargetObjectKeyFormat();
        String targetPrefix = builder.getTargetPrefix();
        if (targetPrefix == null) {
            throw new IllegalArgumentException("A non-null value must be provided for targetPrefix".toString());
        }
        this.targetPrefix = targetPrefix;
    }

    public final String getTargetBucket() {
        return this.targetBucket;
    }

    public final List<TargetGrant> getTargetGrants() {
        return this.targetGrants;
    }

    public final TargetObjectKeyFormat getTargetObjectKeyFormat() {
        return this.targetObjectKeyFormat;
    }

    public final String getTargetPrefix() {
        return this.targetPrefix;
    }

    /* JADX INFO: compiled from: LoggingEnabled.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LoggingEnabled$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/LoggingEnabled;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/LoggingEnabled$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoggingEnabled invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LoggingEnabled(");
        sb.append("targetBucket=" + this.targetBucket + AbstractJsonLexerKt.COMMA);
        sb.append("targetGrants=" + this.targetGrants + AbstractJsonLexerKt.COMMA);
        sb.append("targetObjectKeyFormat=" + this.targetObjectKeyFormat + AbstractJsonLexerKt.COMMA);
        sb.append("targetPrefix=" + this.targetPrefix);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = this.targetBucket.hashCode() * 31;
        List<TargetGrant> list = this.targetGrants;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        TargetObjectKeyFormat targetObjectKeyFormat = this.targetObjectKeyFormat;
        return ((iHashCode2 + (targetObjectKeyFormat != null ? targetObjectKeyFormat.hashCode() : 0)) * 31) + this.targetPrefix.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LoggingEnabled loggingEnabled = (LoggingEnabled) other;
        return Intrinsics.areEqual(this.targetBucket, loggingEnabled.targetBucket) && Intrinsics.areEqual(this.targetGrants, loggingEnabled.targetGrants) && Intrinsics.areEqual(this.targetObjectKeyFormat, loggingEnabled.targetObjectKeyFormat) && Intrinsics.areEqual(this.targetPrefix, loggingEnabled.targetPrefix);
    }

    public static /* synthetic */ LoggingEnabled copy$default(LoggingEnabled loggingEnabled, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.LoggingEnabled.copy.1
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
        Builder builder = new Builder(loggingEnabled);
        block.invoke(builder);
        return builder.build();
    }

    public final LoggingEnabled copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: LoggingEnabled.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0005H\u0001J\u001f\u0010\u0014\u001a\u00020\u001e2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001e0 ¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u0000H\u0000¢\u0006\u0002\b$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\f¨\u0006%"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/LoggingEnabled$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/LoggingEnabled;", "(Laws/sdk/kotlin/services/s3/model/LoggingEnabled;)V", "targetBucket", "", "getTargetBucket", "()Ljava/lang/String;", "setTargetBucket", "(Ljava/lang/String;)V", "targetGrants", "", "Laws/sdk/kotlin/services/s3/model/TargetGrant;", "getTargetGrants", "()Ljava/util/List;", "setTargetGrants", "(Ljava/util/List;)V", "targetObjectKeyFormat", "Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat;", "getTargetObjectKeyFormat", "()Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat;", "setTargetObjectKeyFormat", "(Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat;)V", "targetPrefix", "getTargetPrefix", "setTargetPrefix", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/TargetObjectKeyFormat$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String targetBucket;
        private List<TargetGrant> targetGrants;
        private TargetObjectKeyFormat targetObjectKeyFormat;
        private String targetPrefix;

        public final String getTargetBucket() {
            return this.targetBucket;
        }

        public final void setTargetBucket(String str) {
            this.targetBucket = str;
        }

        public final List<TargetGrant> getTargetGrants() {
            return this.targetGrants;
        }

        public final void setTargetGrants(List<TargetGrant> list) {
            this.targetGrants = list;
        }

        public final TargetObjectKeyFormat getTargetObjectKeyFormat() {
            return this.targetObjectKeyFormat;
        }

        public final void setTargetObjectKeyFormat(TargetObjectKeyFormat targetObjectKeyFormat) {
            this.targetObjectKeyFormat = targetObjectKeyFormat;
        }

        public final String getTargetPrefix() {
            return this.targetPrefix;
        }

        public final void setTargetPrefix(String str) {
            this.targetPrefix = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(LoggingEnabled x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.targetBucket = x.getTargetBucket();
            this.targetGrants = x.getTargetGrants();
            this.targetObjectKeyFormat = x.getTargetObjectKeyFormat();
            this.targetPrefix = x.getTargetPrefix();
        }

        public final LoggingEnabled build() {
            return new LoggingEnabled(this, null);
        }

        public final void targetObjectKeyFormat(Function1<? super TargetObjectKeyFormat.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.targetObjectKeyFormat = LoggingEnabledKt.awsSdkKotlinServicesS3ModelTargetObjectKeyFormatDslBuilderRef.invoke(block);
        }

        public final Builder correctErrors$s3() {
            if (this.targetBucket == null) {
                this.targetBucket = "";
            }
            if (this.targetPrefix == null) {
                this.targetPrefix = "";
            }
            return this;
        }
    }
}
