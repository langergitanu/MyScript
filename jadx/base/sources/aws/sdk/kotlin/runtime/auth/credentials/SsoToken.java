package aws.sdk.kotlin.runtime.auth.credentials;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import aws.smithy.kotlin.runtime.http.auth.BearerToken;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SsoTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0083\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/SsoToken;", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "token", "", "expiration", "Laws/smithy/kotlin/runtime/time/Instant;", "refreshToken", "clientId", "clientSecret", "registrationExpiresAt", TtmlNode.TAG_REGION, "startUrl", "<init>", "(Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getExpiration", "()Laws/smithy/kotlin/runtime/time/Instant;", "getRefreshToken", "getClientId", "getClientSecret", "getRegistrationExpiresAt", "getRegion", "getStartUrl", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "getAttributes", "()Laws/smithy/kotlin/runtime/collections/Attributes;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SsoToken implements BearerToken {
    private final Attributes attributes;
    private final String clientId;
    private final String clientSecret;
    private final Instant expiration;
    private final String refreshToken;
    private final String region;
    private final Instant registrationExpiresAt;
    private final String startUrl;
    private final String token;

    public static /* synthetic */ SsoToken copy$default(SsoToken ssoToken, String str, Instant instant, String str2, String str3, String str4, Instant instant2, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ssoToken.token;
        }
        if ((i & 2) != 0) {
            instant = ssoToken.expiration;
        }
        if ((i & 4) != 0) {
            str2 = ssoToken.refreshToken;
        }
        if ((i & 8) != 0) {
            str3 = ssoToken.clientId;
        }
        if ((i & 16) != 0) {
            str4 = ssoToken.clientSecret;
        }
        if ((i & 32) != 0) {
            instant2 = ssoToken.registrationExpiresAt;
        }
        if ((i & 64) != 0) {
            str5 = ssoToken.region;
        }
        if ((i & 128) != 0) {
            str6 = ssoToken.startUrl;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        Instant instant3 = instant2;
        return ssoToken.copy(str, instant, str2, str3, str9, instant3, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Instant getExpiration() {
        return this.expiration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getClientSecret() {
        return this.clientSecret;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Instant getRegistrationExpiresAt() {
        return this.registrationExpiresAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStartUrl() {
        return this.startUrl;
    }

    public final SsoToken copy(String token, Instant expiration, String refreshToken, String clientId, String clientSecret, Instant registrationExpiresAt, String region, String startUrl) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(expiration, "expiration");
        return new SsoToken(token, expiration, refreshToken, clientId, clientSecret, registrationExpiresAt, region, startUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SsoToken)) {
            return false;
        }
        SsoToken ssoToken = (SsoToken) other;
        return Intrinsics.areEqual(this.token, ssoToken.token) && Intrinsics.areEqual(this.expiration, ssoToken.expiration) && Intrinsics.areEqual(this.refreshToken, ssoToken.refreshToken) && Intrinsics.areEqual(this.clientId, ssoToken.clientId) && Intrinsics.areEqual(this.clientSecret, ssoToken.clientSecret) && Intrinsics.areEqual(this.registrationExpiresAt, ssoToken.registrationExpiresAt) && Intrinsics.areEqual(this.region, ssoToken.region) && Intrinsics.areEqual(this.startUrl, ssoToken.startUrl);
    }

    public int hashCode() {
        int iHashCode = ((this.token.hashCode() * 31) + this.expiration.hashCode()) * 31;
        String str = this.refreshToken;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.clientId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.clientSecret;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Instant instant = this.registrationExpiresAt;
        int iHashCode5 = (iHashCode4 + (instant == null ? 0 : instant.hashCode())) * 31;
        String str4 = this.region;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.startUrl;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "SsoToken(token=" + this.token + ", expiration=" + this.expiration + ", refreshToken=" + this.refreshToken + ", clientId=" + this.clientId + ", clientSecret=" + this.clientSecret + ", registrationExpiresAt=" + this.registrationExpiresAt + ", region=" + this.region + ", startUrl=" + this.startUrl + ')';
    }

    public SsoToken(String token, Instant expiration, String str, String str2, String str3, Instant instant, String str4, String str5) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(expiration, "expiration");
        this.token = token;
        this.expiration = expiration;
        this.refreshToken = str;
        this.clientId = str2;
        this.clientSecret = str3;
        this.registrationExpiresAt = instant;
        this.region = str4;
        this.startUrl = str5;
        this.attributes = AttributesKt.emptyAttributes();
    }

    public /* synthetic */ SsoToken(String str, Instant instant, String str2, String str3, String str4, Instant instant2, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, instant, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : instant2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6);
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.BearerToken
    public String getToken() {
        return this.token;
    }

    @Override // aws.smithy.kotlin.runtime.identity.Identity
    public Instant getExpiration() {
        return this.expiration;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final Instant getRegistrationExpiresAt() {
        return this.registrationExpiresAt;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getStartUrl() {
        return this.startUrl;
    }

    @Override // aws.smithy.kotlin.runtime.identity.Identity
    public Attributes getAttributes() {
        return this.attributes;
    }
}
