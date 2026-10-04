package aws.sdk.kotlin.runtime.auth.credentials.profile;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LeafProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "", "<init>", "()V", "NamedSource", "AccessKey", "WebIdentityTokenRole", "LegacySso", "SsoSession", "LoginSession", "Process", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$AccessKey;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$LegacySso;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$LoginSession;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$NamedSource;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$Process;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$SsoSession;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$WebIdentityTokenRole;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class LeafProvider {
    public /* synthetic */ LeafProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LeafProvider() {
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$NamedSource;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class NamedSource extends LeafProvider {
        private final String name;

        public static /* synthetic */ NamedSource copy$default(NamedSource namedSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = namedSource.name;
            }
            return namedSource.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final NamedSource copy(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new NamedSource(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NamedSource) && Intrinsics.areEqual(this.name, ((NamedSource) other).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return "NamedSource(name=" + this.name + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NamedSource(String name) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$AccessKey;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "credentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;)V", "getCredentials", "()Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class AccessKey extends LeafProvider {
        private final Credentials credentials;

        public static /* synthetic */ AccessKey copy$default(AccessKey accessKey, Credentials credentials, int i, Object obj) {
            if ((i & 1) != 0) {
                credentials = accessKey.credentials;
            }
            return accessKey.copy(credentials);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Credentials getCredentials() {
            return this.credentials;
        }

        public final AccessKey copy(Credentials credentials) {
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            return new AccessKey(credentials);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AccessKey) && Intrinsics.areEqual(this.credentials, ((AccessKey) other).credentials);
        }

        public int hashCode() {
            return this.credentials.hashCode();
        }

        public String toString() {
            return "AccessKey(credentials=" + this.credentials + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AccessKey(Credentials credentials) {
            super(null);
            Intrinsics.checkNotNullParameter(credentials, "credentials");
            this.credentials = credentials;
        }

        public final Credentials getCredentials() {
            return this.credentials;
        }
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$WebIdentityTokenRole;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "roleArn", "", "webIdentityTokenFile", "sessionName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRoleArn", "()Ljava/lang/String;", "getWebIdentityTokenFile", "getSessionName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class WebIdentityTokenRole extends LeafProvider {
        private final String roleArn;
        private final String sessionName;
        private final String webIdentityTokenFile;

        public static /* synthetic */ WebIdentityTokenRole copy$default(WebIdentityTokenRole webIdentityTokenRole, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webIdentityTokenRole.roleArn;
            }
            if ((i & 2) != 0) {
                str2 = webIdentityTokenRole.webIdentityTokenFile;
            }
            if ((i & 4) != 0) {
                str3 = webIdentityTokenRole.sessionName;
            }
            return webIdentityTokenRole.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getRoleArn() {
            return this.roleArn;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getWebIdentityTokenFile() {
            return this.webIdentityTokenFile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSessionName() {
            return this.sessionName;
        }

        public final WebIdentityTokenRole copy(String roleArn, String webIdentityTokenFile, String sessionName) {
            Intrinsics.checkNotNullParameter(roleArn, "roleArn");
            Intrinsics.checkNotNullParameter(webIdentityTokenFile, "webIdentityTokenFile");
            return new WebIdentityTokenRole(roleArn, webIdentityTokenFile, sessionName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebIdentityTokenRole)) {
                return false;
            }
            WebIdentityTokenRole webIdentityTokenRole = (WebIdentityTokenRole) other;
            return Intrinsics.areEqual(this.roleArn, webIdentityTokenRole.roleArn) && Intrinsics.areEqual(this.webIdentityTokenFile, webIdentityTokenRole.webIdentityTokenFile) && Intrinsics.areEqual(this.sessionName, webIdentityTokenRole.sessionName);
        }

        public int hashCode() {
            int iHashCode = ((this.roleArn.hashCode() * 31) + this.webIdentityTokenFile.hashCode()) * 31;
            String str = this.sessionName;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "WebIdentityTokenRole(roleArn=" + this.roleArn + ", webIdentityTokenFile=" + this.webIdentityTokenFile + ", sessionName=" + this.sessionName + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebIdentityTokenRole(String roleArn, String webIdentityTokenFile, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(roleArn, "roleArn");
            Intrinsics.checkNotNullParameter(webIdentityTokenFile, "webIdentityTokenFile");
            this.roleArn = roleArn;
            this.webIdentityTokenFile = webIdentityTokenFile;
            this.sessionName = str;
        }

        public /* synthetic */ WebIdentityTokenRole(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3);
        }

        public final String getRoleArn() {
            return this.roleArn;
        }

        public final String getWebIdentityTokenFile() {
            return this.webIdentityTokenFile;
        }

        public final String getSessionName() {
            return this.sessionName;
        }
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$LegacySso;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "ssoStartUrl", "", "ssoRegion", "ssoAccountId", "ssoRoleName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsoStartUrl", "()Ljava/lang/String;", "getSsoRegion", "getSsoAccountId", "getSsoRoleName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class LegacySso extends LeafProvider {
        private final String ssoAccountId;
        private final String ssoRegion;
        private final String ssoRoleName;
        private final String ssoStartUrl;

        public static /* synthetic */ LegacySso copy$default(LegacySso legacySso, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = legacySso.ssoStartUrl;
            }
            if ((i & 2) != 0) {
                str2 = legacySso.ssoRegion;
            }
            if ((i & 4) != 0) {
                str3 = legacySso.ssoAccountId;
            }
            if ((i & 8) != 0) {
                str4 = legacySso.ssoRoleName;
            }
            return legacySso.copy(str, str2, str3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSsoStartUrl() {
            return this.ssoStartUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSsoRegion() {
            return this.ssoRegion;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSsoAccountId() {
            return this.ssoAccountId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSsoRoleName() {
            return this.ssoRoleName;
        }

        public final LegacySso copy(String ssoStartUrl, String ssoRegion, String ssoAccountId, String ssoRoleName) {
            Intrinsics.checkNotNullParameter(ssoStartUrl, "ssoStartUrl");
            Intrinsics.checkNotNullParameter(ssoRegion, "ssoRegion");
            Intrinsics.checkNotNullParameter(ssoAccountId, "ssoAccountId");
            Intrinsics.checkNotNullParameter(ssoRoleName, "ssoRoleName");
            return new LegacySso(ssoStartUrl, ssoRegion, ssoAccountId, ssoRoleName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LegacySso)) {
                return false;
            }
            LegacySso legacySso = (LegacySso) other;
            return Intrinsics.areEqual(this.ssoStartUrl, legacySso.ssoStartUrl) && Intrinsics.areEqual(this.ssoRegion, legacySso.ssoRegion) && Intrinsics.areEqual(this.ssoAccountId, legacySso.ssoAccountId) && Intrinsics.areEqual(this.ssoRoleName, legacySso.ssoRoleName);
        }

        public int hashCode() {
            return (((((this.ssoStartUrl.hashCode() * 31) + this.ssoRegion.hashCode()) * 31) + this.ssoAccountId.hashCode()) * 31) + this.ssoRoleName.hashCode();
        }

        public String toString() {
            return "LegacySso(ssoStartUrl=" + this.ssoStartUrl + ", ssoRegion=" + this.ssoRegion + ", ssoAccountId=" + this.ssoAccountId + ", ssoRoleName=" + this.ssoRoleName + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LegacySso(String ssoStartUrl, String ssoRegion, String ssoAccountId, String ssoRoleName) {
            super(null);
            Intrinsics.checkNotNullParameter(ssoStartUrl, "ssoStartUrl");
            Intrinsics.checkNotNullParameter(ssoRegion, "ssoRegion");
            Intrinsics.checkNotNullParameter(ssoAccountId, "ssoAccountId");
            Intrinsics.checkNotNullParameter(ssoRoleName, "ssoRoleName");
            this.ssoStartUrl = ssoStartUrl;
            this.ssoRegion = ssoRegion;
            this.ssoAccountId = ssoAccountId;
            this.ssoRoleName = ssoRoleName;
        }

        public final String getSsoStartUrl() {
            return this.ssoStartUrl;
        }

        public final String getSsoRegion() {
            return this.ssoRegion;
        }

        public final String getSsoAccountId() {
            return this.ssoAccountId;
        }

        public final String getSsoRoleName() {
            return this.ssoRoleName;
        }
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$SsoSession;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "ssoSessionName", "", "ssoStartUrl", "ssoRegion", "ssoAccountId", "ssoRoleName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSsoSessionName", "()Ljava/lang/String;", "getSsoStartUrl", "getSsoRegion", "getSsoAccountId", "getSsoRoleName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SsoSession extends LeafProvider {
        private final String ssoAccountId;
        private final String ssoRegion;
        private final String ssoRoleName;
        private final String ssoSessionName;
        private final String ssoStartUrl;

        public static /* synthetic */ SsoSession copy$default(SsoSession ssoSession, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ssoSession.ssoSessionName;
            }
            if ((i & 2) != 0) {
                str2 = ssoSession.ssoStartUrl;
            }
            if ((i & 4) != 0) {
                str3 = ssoSession.ssoRegion;
            }
            if ((i & 8) != 0) {
                str4 = ssoSession.ssoAccountId;
            }
            if ((i & 16) != 0) {
                str5 = ssoSession.ssoRoleName;
            }
            String str6 = str5;
            String str7 = str3;
            return ssoSession.copy(str, str2, str7, str4, str6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSsoSessionName() {
            return this.ssoSessionName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSsoStartUrl() {
            return this.ssoStartUrl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSsoRegion() {
            return this.ssoRegion;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSsoAccountId() {
            return this.ssoAccountId;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSsoRoleName() {
            return this.ssoRoleName;
        }

        public final SsoSession copy(String ssoSessionName, String ssoStartUrl, String ssoRegion, String ssoAccountId, String ssoRoleName) {
            Intrinsics.checkNotNullParameter(ssoSessionName, "ssoSessionName");
            Intrinsics.checkNotNullParameter(ssoStartUrl, "ssoStartUrl");
            Intrinsics.checkNotNullParameter(ssoRegion, "ssoRegion");
            Intrinsics.checkNotNullParameter(ssoAccountId, "ssoAccountId");
            Intrinsics.checkNotNullParameter(ssoRoleName, "ssoRoleName");
            return new SsoSession(ssoSessionName, ssoStartUrl, ssoRegion, ssoAccountId, ssoRoleName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SsoSession)) {
                return false;
            }
            SsoSession ssoSession = (SsoSession) other;
            return Intrinsics.areEqual(this.ssoSessionName, ssoSession.ssoSessionName) && Intrinsics.areEqual(this.ssoStartUrl, ssoSession.ssoStartUrl) && Intrinsics.areEqual(this.ssoRegion, ssoSession.ssoRegion) && Intrinsics.areEqual(this.ssoAccountId, ssoSession.ssoAccountId) && Intrinsics.areEqual(this.ssoRoleName, ssoSession.ssoRoleName);
        }

        public int hashCode() {
            return (((((((this.ssoSessionName.hashCode() * 31) + this.ssoStartUrl.hashCode()) * 31) + this.ssoRegion.hashCode()) * 31) + this.ssoAccountId.hashCode()) * 31) + this.ssoRoleName.hashCode();
        }

        public String toString() {
            return "SsoSession(ssoSessionName=" + this.ssoSessionName + ", ssoStartUrl=" + this.ssoStartUrl + ", ssoRegion=" + this.ssoRegion + ", ssoAccountId=" + this.ssoAccountId + ", ssoRoleName=" + this.ssoRoleName + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SsoSession(String ssoSessionName, String ssoStartUrl, String ssoRegion, String ssoAccountId, String ssoRoleName) {
            super(null);
            Intrinsics.checkNotNullParameter(ssoSessionName, "ssoSessionName");
            Intrinsics.checkNotNullParameter(ssoStartUrl, "ssoStartUrl");
            Intrinsics.checkNotNullParameter(ssoRegion, "ssoRegion");
            Intrinsics.checkNotNullParameter(ssoAccountId, "ssoAccountId");
            Intrinsics.checkNotNullParameter(ssoRoleName, "ssoRoleName");
            this.ssoSessionName = ssoSessionName;
            this.ssoStartUrl = ssoStartUrl;
            this.ssoRegion = ssoRegion;
            this.ssoAccountId = ssoAccountId;
            this.ssoRoleName = ssoRoleName;
        }

        public final String getSsoSessionName() {
            return this.ssoSessionName;
        }

        public final String getSsoStartUrl() {
            return this.ssoStartUrl;
        }

        public final String getSsoRegion() {
            return this.ssoRegion;
        }

        public final String getSsoAccountId() {
            return this.ssoAccountId;
        }

        public final String getSsoRoleName() {
            return this.ssoRoleName;
        }
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$LoginSession;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "loginSessionName", "", "<init>", "(Ljava/lang/String;)V", "getLoginSessionName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class LoginSession extends LeafProvider {
        private final String loginSessionName;

        public static /* synthetic */ LoginSession copy$default(LoginSession loginSession, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loginSession.loginSessionName;
            }
            return loginSession.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLoginSessionName() {
            return this.loginSessionName;
        }

        public final LoginSession copy(String loginSessionName) {
            Intrinsics.checkNotNullParameter(loginSessionName, "loginSessionName");
            return new LoginSession(loginSessionName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoginSession) && Intrinsics.areEqual(this.loginSessionName, ((LoginSession) other).loginSessionName);
        }

        public int hashCode() {
            return this.loginSessionName.hashCode();
        }

        public String toString() {
            return "LoginSession(loginSessionName=" + this.loginSessionName + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoginSession(String loginSessionName) {
            super(null);
            Intrinsics.checkNotNullParameter(loginSessionName, "loginSessionName");
            this.loginSessionName = loginSessionName;
        }

        public final String getLoginSessionName() {
            return this.loginSessionName;
        }
    }

    /* JADX INFO: compiled from: LeafProvider.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider$Process;", "Laws/sdk/kotlin/runtime/auth/credentials/profile/LeafProvider;", "command", "", "<init>", "(Ljava/lang/String;)V", "getCommand", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Process extends LeafProvider {
        private final String command;

        public static /* synthetic */ Process copy$default(Process process, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = process.command;
            }
            return process.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCommand() {
            return this.command;
        }

        public final Process copy(String command) {
            Intrinsics.checkNotNullParameter(command, "command");
            return new Process(command);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Process) && Intrinsics.areEqual(this.command, ((Process) other).command);
        }

        public int hashCode() {
            return this.command.hashCode();
        }

        public String toString() {
            return "Process(command=" + this.command + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Process(String command) {
            super(null);
            Intrinsics.checkNotNullParameter(command, "command");
            this.command = command;
        }

        public final String getCommand() {
            return this.command;
        }
    }
}
