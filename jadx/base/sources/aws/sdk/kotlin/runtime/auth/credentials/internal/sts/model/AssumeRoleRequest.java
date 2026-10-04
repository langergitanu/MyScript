package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AssumeRoleRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 22\u00020\u0001:\u000223B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010(\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010)\u001a\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010-\u001a\u00020\u00002\u0019\b\u0002\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1H\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0019\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0013\u0010$\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000eR\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest$Builder;)V", "durationSeconds", "", "getDurationSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "externalId", "", "getExternalId", "()Ljava/lang/String;", "policy", "getPolicy", "policyArns", "", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "getPolicyArns", "()Ljava/util/List;", "providedContexts", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;", "getProvidedContexts", "roleArn", "getRoleArn", "roleSessionName", "getRoleSessionName", "serialNumber", "getSerialNumber", "sourceIdentity", "getSourceIdentity", "tags", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Tag;", "getTags", "tokenCode", "getTokenCode", "transitiveTagKeys", "getTransitiveTagKeys", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AssumeRoleRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer durationSeconds;
    private final String externalId;
    private final String policy;
    private final List<PolicyDescriptorType> policyArns;
    private final List<ProvidedContext> providedContexts;
    private final String roleArn;
    private final String roleSessionName;
    private final String serialNumber;
    private final String sourceIdentity;
    private final List<Tag> tags;
    private final String tokenCode;
    private final List<String> transitiveTagKeys;

    public /* synthetic */ AssumeRoleRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AssumeRoleRequest(Builder builder) {
        this.durationSeconds = builder.getDurationSeconds();
        this.externalId = builder.getExternalId();
        this.policy = builder.getPolicy();
        this.policyArns = builder.getPolicyArns();
        this.providedContexts = builder.getProvidedContexts();
        this.roleArn = builder.getRoleArn();
        this.roleSessionName = builder.getRoleSessionName();
        this.serialNumber = builder.getSerialNumber();
        this.sourceIdentity = builder.getSourceIdentity();
        this.tags = builder.getTags();
        this.tokenCode = builder.getTokenCode();
        this.transitiveTagKeys = builder.getTransitiveTagKeys();
    }

    public final Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getPolicy() {
        return this.policy;
    }

    public final List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public final List<ProvidedContext> getProvidedContexts() {
        return this.providedContexts;
    }

    public final String getRoleArn() {
        return this.roleArn;
    }

    public final String getRoleSessionName() {
        return this.roleSessionName;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final String getTokenCode() {
        return this.tokenCode;
    }

    public final List<String> getTransitiveTagKeys() {
        return this.transitiveTagKeys;
    }

    /* JADX INFO: compiled from: AssumeRoleRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AssumeRoleRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AssumeRoleRequest(");
        sb.append("durationSeconds=" + this.durationSeconds + AbstractJsonLexerKt.COMMA);
        sb.append("externalId=" + this.externalId + AbstractJsonLexerKt.COMMA);
        sb.append("policy=" + this.policy + AbstractJsonLexerKt.COMMA);
        sb.append("policyArns=" + this.policyArns + AbstractJsonLexerKt.COMMA);
        sb.append("providedContexts=" + this.providedContexts + AbstractJsonLexerKt.COMMA);
        sb.append("roleArn=" + this.roleArn + AbstractJsonLexerKt.COMMA);
        sb.append("roleSessionName=" + this.roleSessionName + AbstractJsonLexerKt.COMMA);
        sb.append("serialNumber=" + this.serialNumber + AbstractJsonLexerKt.COMMA);
        sb.append("sourceIdentity=" + this.sourceIdentity + AbstractJsonLexerKt.COMMA);
        sb.append("tags=" + this.tags + AbstractJsonLexerKt.COMMA);
        sb.append("tokenCode=" + this.tokenCode + AbstractJsonLexerKt.COMMA);
        sb.append("transitiveTagKeys=" + this.transitiveTagKeys);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Integer num = this.durationSeconds;
        int iIntValue = (num != null ? num.intValue() : 0) * 31;
        String str = this.externalId;
        int iHashCode = (iIntValue + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.policy;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<PolicyDescriptorType> list = this.policyArns;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<ProvidedContext> list2 = this.providedContexts;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str3 = this.roleArn;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.roleSessionName;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.serialNumber;
        int iHashCode7 = (iHashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.sourceIdentity;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        List<Tag> list3 = this.tags;
        int iHashCode9 = (iHashCode8 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str7 = this.tokenCode;
        int iHashCode10 = (iHashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<String> list4 = this.transitiveTagKeys;
        return iHashCode10 + (list4 != null ? list4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AssumeRoleRequest assumeRoleRequest = (AssumeRoleRequest) other;
        return Intrinsics.areEqual(this.durationSeconds, assumeRoleRequest.durationSeconds) && Intrinsics.areEqual(this.externalId, assumeRoleRequest.externalId) && Intrinsics.areEqual(this.policy, assumeRoleRequest.policy) && Intrinsics.areEqual(this.policyArns, assumeRoleRequest.policyArns) && Intrinsics.areEqual(this.providedContexts, assumeRoleRequest.providedContexts) && Intrinsics.areEqual(this.roleArn, assumeRoleRequest.roleArn) && Intrinsics.areEqual(this.roleSessionName, assumeRoleRequest.roleSessionName) && Intrinsics.areEqual(this.serialNumber, assumeRoleRequest.serialNumber) && Intrinsics.areEqual(this.sourceIdentity, assumeRoleRequest.sourceIdentity) && Intrinsics.areEqual(this.tags, assumeRoleRequest.tags) && Intrinsics.areEqual(this.tokenCode, assumeRoleRequest.tokenCode) && Intrinsics.areEqual(this.transitiveTagKeys, assumeRoleRequest.transitiveTagKeys);
    }

    public static /* synthetic */ AssumeRoleRequest copy$default(AssumeRoleRequest assumeRoleRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.AssumeRoleRequest.copy.1
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
        Builder builder = new Builder(assumeRoleRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final AssumeRoleRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: AssumeRoleRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u00108\u001a\u00020\u0005H\u0001J\r\u00109\u001a\u00020\u0000H\u0000¢\u0006\u0002\b:R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001c\u0010%\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u001c\u0010(\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R\u001c\u0010+\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001c\u00102\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\"\u00105\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001d¨\u0006;"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/AssumeRoleRequest;)V", "durationSeconds", "", "getDurationSeconds", "()Ljava/lang/Integer;", "setDurationSeconds", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "externalId", "", "getExternalId", "()Ljava/lang/String;", "setExternalId", "(Ljava/lang/String;)V", "policy", "getPolicy", "setPolicy", "policyArns", "", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/PolicyDescriptorType;", "getPolicyArns", "()Ljava/util/List;", "setPolicyArns", "(Ljava/util/List;)V", "providedContexts", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;", "getProvidedContexts", "setProvidedContexts", "roleArn", "getRoleArn", "setRoleArn", "roleSessionName", "getRoleSessionName", "setRoleSessionName", "serialNumber", "getSerialNumber", "setSerialNumber", "sourceIdentity", "getSourceIdentity", "setSourceIdentity", "tags", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/Tag;", "getTags", "setTags", "tokenCode", "getTokenCode", "setTokenCode", "transitiveTagKeys", "getTransitiveTagKeys", "setTransitiveTagKeys", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Integer durationSeconds;
        private String externalId;
        private String policy;
        private List<PolicyDescriptorType> policyArns;
        private List<ProvidedContext> providedContexts;
        private String roleArn;
        private String roleSessionName;
        private String serialNumber;
        private String sourceIdentity;
        private List<Tag> tags;
        private String tokenCode;
        private List<String> transitiveTagKeys;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final Integer getDurationSeconds() {
            return this.durationSeconds;
        }

        public final void setDurationSeconds(Integer num) {
            this.durationSeconds = num;
        }

        public final String getExternalId() {
            return this.externalId;
        }

        public final void setExternalId(String str) {
            this.externalId = str;
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

        public final List<ProvidedContext> getProvidedContexts() {
            return this.providedContexts;
        }

        public final void setProvidedContexts(List<ProvidedContext> list) {
            this.providedContexts = list;
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

        public final String getSerialNumber() {
            return this.serialNumber;
        }

        public final void setSerialNumber(String str) {
            this.serialNumber = str;
        }

        public final String getSourceIdentity() {
            return this.sourceIdentity;
        }

        public final void setSourceIdentity(String str) {
            this.sourceIdentity = str;
        }

        public final List<Tag> getTags() {
            return this.tags;
        }

        public final void setTags(List<Tag> list) {
            this.tags = list;
        }

        public final String getTokenCode() {
            return this.tokenCode;
        }

        public final void setTokenCode(String str) {
            this.tokenCode = str;
        }

        public final List<String> getTransitiveTagKeys() {
            return this.transitiveTagKeys;
        }

        public final void setTransitiveTagKeys(List<String> list) {
            this.transitiveTagKeys = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AssumeRoleRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.durationSeconds = x.getDurationSeconds();
            this.externalId = x.getExternalId();
            this.policy = x.getPolicy();
            this.policyArns = x.getPolicyArns();
            this.providedContexts = x.getProvidedContexts();
            this.roleArn = x.getRoleArn();
            this.roleSessionName = x.getRoleSessionName();
            this.serialNumber = x.getSerialNumber();
            this.sourceIdentity = x.getSourceIdentity();
            this.tags = x.getTags();
            this.tokenCode = x.getTokenCode();
            this.transitiveTagKeys = x.getTransitiveTagKeys();
        }

        public final AssumeRoleRequest build() {
            return new AssumeRoleRequest(this, null);
        }
    }
}
