package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.ServerSideEncryption;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ServerSideEncryptionByDefault.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0014\u001a\u00020\u00002\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault;", "", "builder", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault$Builder;)V", "kmsMasterKeyId", "", "getKmsMasterKeyId", "()Ljava/lang/String;", "sseAlgorithm", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getSseAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ServerSideEncryptionByDefault {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String kmsMasterKeyId;
    private final ServerSideEncryption sseAlgorithm;

    public /* synthetic */ ServerSideEncryptionByDefault(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ServerSideEncryptionByDefault(Builder builder) {
        this.kmsMasterKeyId = builder.getKmsMasterKeyId();
        ServerSideEncryption sseAlgorithm = builder.getSseAlgorithm();
        if (sseAlgorithm == null) {
            throw new IllegalArgumentException("A non-null value must be provided for sseAlgorithm".toString());
        }
        this.sseAlgorithm = sseAlgorithm;
    }

    public final String getKmsMasterKeyId() {
        return this.kmsMasterKeyId;
    }

    public final ServerSideEncryption getSseAlgorithm() {
        return this.sseAlgorithm;
    }

    /* JADX INFO: compiled from: ServerSideEncryptionByDefault.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ServerSideEncryptionByDefault invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ServerSideEncryptionByDefault(kmsMasterKeyId=*** Sensitive Data Redacted ***,");
        sb.append("sseAlgorithm=" + this.sseAlgorithm);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.kmsMasterKeyId;
        return ((str != null ? str.hashCode() : 0) * 31) + this.sseAlgorithm.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ServerSideEncryptionByDefault serverSideEncryptionByDefault = (ServerSideEncryptionByDefault) other;
        return Intrinsics.areEqual(this.kmsMasterKeyId, serverSideEncryptionByDefault.kmsMasterKeyId) && Intrinsics.areEqual(this.sseAlgorithm, serverSideEncryptionByDefault.sseAlgorithm);
    }

    public static /* synthetic */ ServerSideEncryptionByDefault copy$default(ServerSideEncryptionByDefault serverSideEncryptionByDefault, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.ServerSideEncryptionByDefault.copy.1
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
        Builder builder = new Builder(serverSideEncryptionByDefault);
        block.invoke(builder);
        return builder.build();
    }

    public final ServerSideEncryptionByDefault copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ServerSideEncryptionByDefault.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault;", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryptionByDefault;)V", "kmsMasterKeyId", "", "getKmsMasterKeyId", "()Ljava/lang/String;", "setKmsMasterKeyId", "(Ljava/lang/String;)V", "sseAlgorithm", "Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "getSseAlgorithm", "()Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;", "setSseAlgorithm", "(Laws/sdk/kotlin/services/s3/model/ServerSideEncryption;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String kmsMasterKeyId;
        private ServerSideEncryption sseAlgorithm;

        public final String getKmsMasterKeyId() {
            return this.kmsMasterKeyId;
        }

        public final void setKmsMasterKeyId(String str) {
            this.kmsMasterKeyId = str;
        }

        public final ServerSideEncryption getSseAlgorithm() {
            return this.sseAlgorithm;
        }

        public final void setSseAlgorithm(ServerSideEncryption serverSideEncryption) {
            this.sseAlgorithm = serverSideEncryption;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ServerSideEncryptionByDefault x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.kmsMasterKeyId = x.getKmsMasterKeyId();
            this.sseAlgorithm = x.getSseAlgorithm();
        }

        public final ServerSideEncryptionByDefault build() {
            return new ServerSideEncryptionByDefault(this, null);
        }

        public final Builder correctErrors$s3() {
            if (this.sseAlgorithm == null) {
                this.sseAlgorithm = new ServerSideEncryption.SdkUnknown("no value provided");
            }
            return this;
        }
    }
}
