package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Credentials.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JF\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0083\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u00020\u001bHÖ\u0081\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u0002HÖ\u0081\u0004¢\u0006\u0004\b\u001e\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\rR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010\u0011R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010\u0013¨\u0006'"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsImpl;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "", "accessKeyId", "secretAccessKey", "sessionToken", "Laws/smithy/kotlin/runtime/time/Instant;", "expiration", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Laws/smithy/kotlin/runtime/collections/Attributes;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Laws/smithy/kotlin/runtime/time/Instant;", "component5", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Laws/smithy/kotlin/runtime/collections/Attributes;)Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccessKeyId", "getSecretAccessKey", "getSessionToken", "Laws/smithy/kotlin/runtime/time/Instant;", "getExpiration", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getAttributes", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class CredentialsImpl implements Credentials {
    private final String accessKeyId;
    private final Attributes attributes;
    private final Instant expiration;
    private final String secretAccessKey;
    private final String sessionToken;

    public static /* synthetic */ CredentialsImpl copy$default(CredentialsImpl credentialsImpl, String str, String str2, String str3, Instant instant, Attributes attributes, int i, Object obj) {
        if ((i & 1) != 0) {
            str = credentialsImpl.accessKeyId;
        }
        if ((i & 2) != 0) {
            str2 = credentialsImpl.secretAccessKey;
        }
        if ((i & 4) != 0) {
            str3 = credentialsImpl.sessionToken;
        }
        if ((i & 8) != 0) {
            instant = credentialsImpl.expiration;
        }
        if ((i & 16) != 0) {
            attributes = credentialsImpl.attributes;
        }
        Attributes attributes2 = attributes;
        String str4 = str3;
        return credentialsImpl.copy(str, str2, str4, instant, attributes2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Instant getExpiration() {
        return this.expiration;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final CredentialsImpl copy(String accessKeyId, String secretAccessKey, String sessionToken, Instant expiration, Attributes attributes) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new CredentialsImpl(accessKeyId, secretAccessKey, sessionToken, expiration, attributes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CredentialsImpl)) {
            return false;
        }
        CredentialsImpl credentialsImpl = (CredentialsImpl) other;
        return Intrinsics.areEqual(this.accessKeyId, credentialsImpl.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, credentialsImpl.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, credentialsImpl.sessionToken) && Intrinsics.areEqual(this.expiration, credentialsImpl.expiration) && Intrinsics.areEqual(this.attributes, credentialsImpl.attributes);
    }

    public int hashCode() {
        int iHashCode = ((this.accessKeyId.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31;
        String str = this.sessionToken;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Instant instant = this.expiration;
        return ((iHashCode2 + (instant != null ? instant.hashCode() : 0)) * 31) + this.attributes.hashCode();
    }

    public String toString() {
        return "CredentialsImpl(accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ", expiration=" + this.expiration + ", attributes=" + this.attributes + ')';
    }

    public CredentialsImpl(String accessKeyId, String secretAccessKey, String str, Instant instant, Attributes attributes) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = str;
        this.expiration = instant;
        this.attributes = attributes;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
    public /* bridge */ String getProviderName() {
        return super.getProviderName();
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
    public String getSessionToken() {
        return this.sessionToken;
    }

    @Override // aws.smithy.kotlin.runtime.identity.Identity
    public Instant getExpiration() {
        return this.expiration;
    }

    public /* synthetic */ CredentialsImpl(String str, String str2, String str3, Instant instant, Attributes attributes, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : instant, (i & 16) != 0 ? AttributesKt.emptyAttributes() : attributes);
    }

    @Override // aws.smithy.kotlin.runtime.identity.Identity
    public Attributes getAttributes() {
        return this.attributes;
    }
}
