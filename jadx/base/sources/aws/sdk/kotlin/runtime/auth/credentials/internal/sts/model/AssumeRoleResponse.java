package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumedRoleUser;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.Credentials;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AssumeRoleResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0017\u001a\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u000fH\u0096\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001c\u001a\u00020\u00002\u0019\b\u0002\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse$Builder;)V", "assumedRoleUser", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser;", "getAssumedRoleUser", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser;", "credentials", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Credentials;", "getCredentials", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Credentials;", "packedPolicySize", "", "getPackedPolicySize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "sourceIdentity", "", "getSourceIdentity", "()Ljava/lang/String;", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AssumedRoleUser assumedRoleUser;
    private final Credentials credentials;
    private final Integer packedPolicySize;
    private final String sourceIdentity;

    public /* synthetic */ AssumeRoleResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AssumeRoleResponse(Builder builder) {
        this.assumedRoleUser = builder.getAssumedRoleUser();
        this.credentials = builder.getCredentials();
        this.packedPolicySize = builder.getPackedPolicySize();
        this.sourceIdentity = builder.getSourceIdentity();
    }

    public final AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public final Credentials getCredentials() {
        return this.credentials;
    }

    public final Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public final String getSourceIdentity() {
        return this.sourceIdentity;
    }

    /* JADX INFO: compiled from: AssumeRoleResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssumeRoleResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AssumeRoleResponse(");
        sb.append("assumedRoleUser=" + this.assumedRoleUser + AbstractJsonLexerKt.COMMA);
        sb.append("credentials=" + this.credentials + AbstractJsonLexerKt.COMMA);
        sb.append("packedPolicySize=" + this.packedPolicySize + AbstractJsonLexerKt.COMMA);
        sb.append("sourceIdentity=" + this.sourceIdentity);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AssumedRoleUser assumedRoleUser = this.assumedRoleUser;
        int iHashCode = (assumedRoleUser != null ? assumedRoleUser.hashCode() : 0) * 31;
        Credentials credentials = this.credentials;
        int iHashCode2 = (iHashCode + (credentials != null ? credentials.hashCode() : 0)) * 31;
        Integer num = this.packedPolicySize;
        int iIntValue = (iHashCode2 + (num != null ? num.intValue() : 0)) * 31;
        String str = this.sourceIdentity;
        return iIntValue + (str != null ? str.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AssumeRoleResponse assumeRoleResponse = (AssumeRoleResponse) other;
        return Intrinsics.areEqual(this.assumedRoleUser, assumeRoleResponse.assumedRoleUser) && Intrinsics.areEqual(this.credentials, assumeRoleResponse.credentials) && Intrinsics.areEqual(this.packedPolicySize, assumeRoleResponse.packedPolicySize) && Intrinsics.areEqual(this.sourceIdentity, assumeRoleResponse.sourceIdentity);
    }

    public static /* synthetic */ AssumeRoleResponse copy$default(AssumeRoleResponse assumeRoleResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleResponse.copy.1
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
        Builder builder = new Builder(assumeRoleResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final AssumeRoleResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: AssumeRoleResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\u001f\u0010\r\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\r\u0010'\u001a\u00020\u0000H\u0000¢\u0006\u0002\b(R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleResponse;)V", "assumedRoleUser", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser;", "getAssumedRoleUser", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser;", "setAssumedRoleUser", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser;)V", "credentials", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Credentials;", "getCredentials", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Credentials;", "setCredentials", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Credentials;)V", "packedPolicySize", "", "getPackedPolicySize", "()Ljava/lang/Integer;", "setPackedPolicySize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sourceIdentity", "", "getSourceIdentity", "()Ljava/lang/String;", "setSourceIdentity", "(Ljava/lang/String;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumedRoleUser$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Credentials$Builder;", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AssumedRoleUser assumedRoleUser;
        private Credentials credentials;
        private Integer packedPolicySize;
        private String sourceIdentity;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final AssumedRoleUser getAssumedRoleUser() {
            return this.assumedRoleUser;
        }

        public final void setAssumedRoleUser(AssumedRoleUser assumedRoleUser) {
            this.assumedRoleUser = assumedRoleUser;
        }

        public final Credentials getCredentials() {
            return this.credentials;
        }

        public final void setCredentials(Credentials credentials) {
            this.credentials = credentials;
        }

        public final Integer getPackedPolicySize() {
            return this.packedPolicySize;
        }

        public final void setPackedPolicySize(Integer num) {
            this.packedPolicySize = num;
        }

        public final String getSourceIdentity() {
            return this.sourceIdentity;
        }

        public final void setSourceIdentity(String str) {
            this.sourceIdentity = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AssumeRoleResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.assumedRoleUser = x.getAssumedRoleUser();
            this.credentials = x.getCredentials();
            this.packedPolicySize = x.getPackedPolicySize();
            this.sourceIdentity = x.getSourceIdentity();
        }

        public final AssumeRoleResponse build() {
            return new AssumeRoleResponse(this, null);
        }

        public final void assumedRoleUser(Function1<? super AssumedRoleUser.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.assumedRoleUser = AssumeRoleResponseKt.f418xd0e5bbca.invoke(block);
        }

        public final void credentials(Function1<? super Credentials.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.credentials = AssumeRoleResponseKt.f419x11850d67.invoke(block);
        }
    }
}
