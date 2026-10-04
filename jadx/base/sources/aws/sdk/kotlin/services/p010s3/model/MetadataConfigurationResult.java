package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.DestinationResult;
import aws.sdk.kotlin.services.p010s3.model.InventoryTableConfigurationResult;
import aws.sdk.kotlin.services.p010s3.model.JournalTableConfigurationResult;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: MetadataConfigurationResult.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0019\u001a\u00020\u00002\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult;", "", "builder", "Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult$Builder;)V", "destinationResult", "Laws/sdk/kotlin/services/s3/model/DestinationResult;", "getDestinationResult", "()Laws/sdk/kotlin/services/s3/model/DestinationResult;", "inventoryTableConfigurationResult", "Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult;", "getInventoryTableConfigurationResult", "()Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult;", "journalTableConfigurationResult", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "getJournalTableConfigurationResult", "()Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetadataConfigurationResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DestinationResult destinationResult;
    private final InventoryTableConfigurationResult inventoryTableConfigurationResult;
    private final JournalTableConfigurationResult journalTableConfigurationResult;

    public /* synthetic */ MetadataConfigurationResult(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private MetadataConfigurationResult(Builder builder) {
        this.destinationResult = builder.getDestinationResult();
        this.inventoryTableConfigurationResult = builder.getInventoryTableConfigurationResult();
        this.journalTableConfigurationResult = builder.getJournalTableConfigurationResult();
    }

    public final DestinationResult getDestinationResult() {
        return this.destinationResult;
    }

    public final InventoryTableConfigurationResult getInventoryTableConfigurationResult() {
        return this.inventoryTableConfigurationResult;
    }

    public final JournalTableConfigurationResult getJournalTableConfigurationResult() {
        return this.journalTableConfigurationResult;
    }

    /* JADX INFO: compiled from: MetadataConfigurationResult.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MetadataConfigurationResult invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MetadataConfigurationResult(");
        sb.append("destinationResult=" + this.destinationResult + AbstractJsonLexerKt.COMMA);
        sb.append("inventoryTableConfigurationResult=" + this.inventoryTableConfigurationResult + AbstractJsonLexerKt.COMMA);
        sb.append("journalTableConfigurationResult=" + this.journalTableConfigurationResult);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        DestinationResult destinationResult = this.destinationResult;
        int iHashCode = (destinationResult != null ? destinationResult.hashCode() : 0) * 31;
        InventoryTableConfigurationResult inventoryTableConfigurationResult = this.inventoryTableConfigurationResult;
        int iHashCode2 = (iHashCode + (inventoryTableConfigurationResult != null ? inventoryTableConfigurationResult.hashCode() : 0)) * 31;
        JournalTableConfigurationResult journalTableConfigurationResult = this.journalTableConfigurationResult;
        return iHashCode2 + (journalTableConfigurationResult != null ? journalTableConfigurationResult.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        MetadataConfigurationResult metadataConfigurationResult = (MetadataConfigurationResult) other;
        return Intrinsics.areEqual(this.destinationResult, metadataConfigurationResult.destinationResult) && Intrinsics.areEqual(this.inventoryTableConfigurationResult, metadataConfigurationResult.inventoryTableConfigurationResult) && Intrinsics.areEqual(this.journalTableConfigurationResult, metadataConfigurationResult.journalTableConfigurationResult);
    }

    public static /* synthetic */ MetadataConfigurationResult copy$default(MetadataConfigurationResult metadataConfigurationResult, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.MetadataConfigurationResult.copy.1
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
        Builder builder = new Builder(metadataConfigurationResult);
        block.invoke(builder);
        return builder.build();
    }

    public final MetadataConfigurationResult copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: MetadataConfigurationResult.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\u001f\u0010\r\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\u001f\u0010\u0013\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\u0002\b\u001eJ\r\u0010!\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult;", "(Laws/sdk/kotlin/services/s3/model/MetadataConfigurationResult;)V", "destinationResult", "Laws/sdk/kotlin/services/s3/model/DestinationResult;", "getDestinationResult", "()Laws/sdk/kotlin/services/s3/model/DestinationResult;", "setDestinationResult", "(Laws/sdk/kotlin/services/s3/model/DestinationResult;)V", "inventoryTableConfigurationResult", "Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult;", "getInventoryTableConfigurationResult", "()Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult;", "setInventoryTableConfigurationResult", "(Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult;)V", "journalTableConfigurationResult", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "getJournalTableConfigurationResult", "()Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;", "setJournalTableConfigurationResult", "(Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DestinationResult$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/InventoryTableConfigurationResult$Builder;", "Laws/sdk/kotlin/services/s3/model/JournalTableConfigurationResult$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private DestinationResult destinationResult;
        private InventoryTableConfigurationResult inventoryTableConfigurationResult;
        private JournalTableConfigurationResult journalTableConfigurationResult;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final DestinationResult getDestinationResult() {
            return this.destinationResult;
        }

        public final void setDestinationResult(DestinationResult destinationResult) {
            this.destinationResult = destinationResult;
        }

        public final InventoryTableConfigurationResult getInventoryTableConfigurationResult() {
            return this.inventoryTableConfigurationResult;
        }

        public final void setInventoryTableConfigurationResult(InventoryTableConfigurationResult inventoryTableConfigurationResult) {
            this.inventoryTableConfigurationResult = inventoryTableConfigurationResult;
        }

        public final JournalTableConfigurationResult getJournalTableConfigurationResult() {
            return this.journalTableConfigurationResult;
        }

        public final void setJournalTableConfigurationResult(JournalTableConfigurationResult journalTableConfigurationResult) {
            this.journalTableConfigurationResult = journalTableConfigurationResult;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(MetadataConfigurationResult x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.destinationResult = x.getDestinationResult();
            this.inventoryTableConfigurationResult = x.getInventoryTableConfigurationResult();
            this.journalTableConfigurationResult = x.getJournalTableConfigurationResult();
        }

        public final MetadataConfigurationResult build() {
            return new MetadataConfigurationResult(this, null);
        }

        public final void destinationResult(Function1<? super DestinationResult.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.destinationResult = MetadataConfigurationResultKt.awsSdkKotlinServicesS3ModelDestinationResultDslBuilderRef.invoke(block);
        }

        public final void inventoryTableConfigurationResult(Function1<? super InventoryTableConfigurationResult.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.inventoryTableConfigurationResult = MetadataConfigurationResultKt.f475x690d1361.invoke(block);
        }

        public final void journalTableConfigurationResult(Function1<? super JournalTableConfigurationResult.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.journalTableConfigurationResult = MetadataConfigurationResultKt.f476x4ec769a6.invoke(block);
        }
    }
}
