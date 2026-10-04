package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AssumeRoleWithWebIdentityRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001c\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010!\u001a\u00020\u00002\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0#¢\u0006\u0002\b%H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest$Builder;)V", "durationSeconds", "", "getDurationSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "policy", "", "getPolicy", "()Ljava/lang/String;", "policyArns", "", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "getPolicyArns", "()Ljava/util/List;", "providerId", "getProviderId", "roleArn", "getRoleArn", "roleSessionName", "getRoleSessionName", "webIdentityToken", "getWebIdentityToken", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleWithWebIdentityRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer durationSeconds;
    private final String policy;
    private final List<PolicyDescriptorType> policyArns;
    private final String providerId;
    private final String roleArn;
    private final String roleSessionName;
    private final String webIdentityToken;

    public /* synthetic */ AssumeRoleWithWebIdentityRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AssumeRoleWithWebIdentityRequest(Builder builder) {
        this.durationSeconds = builder.getDurationSeconds();
        this.policy = builder.getPolicy();
        this.policyArns = builder.getPolicyArns();
        this.providerId = builder.getProviderId();
        this.roleArn = builder.getRoleArn();
        this.roleSessionName = builder.getRoleSessionName();
        this.webIdentityToken = builder.getWebIdentityToken();
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getPolicy() {
        return this.policy;
    }

    public final List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public final String getProviderId() {
        return this.providerId;
    }

    public final String getRoleArn() {
        return this.roleArn;
    }

    public final String getRoleSessionName() {
        return this.roleSessionName;
    }

    public final String getWebIdentityToken() {
        return this.webIdentityToken;
    }

    /* JADX INFO: compiled from: AssumeRoleWithWebIdentityRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssumeRoleWithWebIdentityRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AssumeRoleWithWebIdentityRequest(");
        sb.append("durationSeconds=" + this.durationSeconds + AbstractJsonLexerKt.COMMA);
        sb.append("policy=" + this.policy + AbstractJsonLexerKt.COMMA);
        sb.append("policyArns=" + this.policyArns + AbstractJsonLexerKt.COMMA);
        sb.append("providerId=" + this.providerId + AbstractJsonLexerKt.COMMA);
        sb.append("roleArn=" + this.roleArn + AbstractJsonLexerKt.COMMA);
        sb.append("roleSessionName=" + this.roleSessionName + AbstractJsonLexerKt.COMMA);
        sb.append("webIdentityToken=*** Sensitive Data Redacted ***)");
        return sb.toString();
    }

    public int hashCode() {
        Integer num = this.durationSeconds;
        int iIntValue = (num != null ? num.intValue() : 0) * 31;
        String str = this.policy;
        int iHashCode = (iIntValue + (str != null ? str.hashCode() : 0)) * 31;
        List<PolicyDescriptorType> list = this.policyArns;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.providerId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.roleArn;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.roleSessionName;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.webIdentityToken;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest = (AssumeRoleWithWebIdentityRequest) other;
        return Intrinsics.areEqual(this.durationSeconds, assumeRoleWithWebIdentityRequest.durationSeconds) && Intrinsics.areEqual(this.policy, assumeRoleWithWebIdentityRequest.policy) && Intrinsics.areEqual(this.policyArns, assumeRoleWithWebIdentityRequest.policyArns) && Intrinsics.areEqual(this.providerId, assumeRoleWithWebIdentityRequest.providerId) && Intrinsics.areEqual(this.roleArn, assumeRoleWithWebIdentityRequest.roleArn) && Intrinsics.areEqual(this.roleSessionName, assumeRoleWithWebIdentityRequest.roleSessionName) && Intrinsics.areEqual(this.webIdentityToken, assumeRoleWithWebIdentityRequest.webIdentityToken);
    }

    public static /* synthetic */ AssumeRoleWithWebIdentityRequest copy$default(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleWithWebIdentityRequest.copy.1
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
        Builder builder = new Builder(assumeRoleWithWebIdentityRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final AssumeRoleWithWebIdentityRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: AssumeRoleWithWebIdentityRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010'\u001a\u00020\u0005H\u0001J\r\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\b)R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001c\u0010!\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010$\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013¨\u0006*"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleWithWebIdentityRequest;)V", "durationSeconds", "", "getDurationSeconds", "()Ljava/lang/Integer;", "setDurationSeconds", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "policy", "", "getPolicy", "()Ljava/lang/String;", "setPolicy", "(Ljava/lang/String;)V", "policyArns", "", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "getPolicyArns", "()Ljava/util/List;", "setPolicyArns", "(Ljava/util/List;)V", "providerId", "getProviderId", "setProviderId", "roleArn", "getRoleArn", "setRoleArn", "roleSessionName", "getRoleSessionName", "setRoleSessionName", "webIdentityToken", "getWebIdentityToken", "setWebIdentityToken", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Integer durationSeconds;
        private String policy;
        private List<PolicyDescriptorType> policyArns;
        private String providerId;
        private String roleArn;
        private String roleSessionName;
        private String webIdentityToken;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final Integer getDurationSeconds() {
            return this.durationSeconds;
        }

        public final void setDurationSeconds(Integer num) {
            this.durationSeconds = num;
        }

        public final String getPolicy() {
            return this.policy;
        }

        public final void setPolicy(String str) {
            this.policy = str;
        }

        public final List<PolicyDescriptorType> getPolicyArns() {
            return this.policyArns;
        }

        public final void setPolicyArns(List<PolicyDescriptorType> list) {
            this.policyArns = list;
        }

        public final String getProviderId() {
            return this.providerId;
        }

        public final void setProviderId(String str) {
            this.providerId = str;
        }

        public final String getRoleArn() {
            return this.roleArn;
        }

        public final void setRoleArn(String str) {
            this.roleArn = str;
        }

        public final String getRoleSessionName() {
            return this.roleSessionName;
        }

        public final void setRoleSessionName(String str) {
            this.roleSessionName = str;
        }

        public final String getWebIdentityToken() {
            return this.webIdentityToken;
        }

        public final void setWebIdentityToken(String str) {
            this.webIdentityToken = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AssumeRoleWithWebIdentityRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.durationSeconds = x.getDurationSeconds();
            this.policy = x.getPolicy();
            this.policyArns = x.getPolicyArns();
            this.providerId = x.getProviderId();
            this.roleArn = x.getRoleArn();
            this.roleSessionName = x.getRoleSessionName();
            this.webIdentityToken = x.getWebIdentityToken();
        }

        public final AssumeRoleWithWebIdentityRequest build() {
            return new AssumeRoleWithWebIdentityRequest(this, null);
        }
    }
}
