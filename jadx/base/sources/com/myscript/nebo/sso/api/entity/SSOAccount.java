package com.myscript.nebo.sso.api.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOAccount.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\b\u0012\u0006\u0010\u001b\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\u0015\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0013HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\bHÆ\u0003Jð\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010O\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010P\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010#R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b\t\u0010$R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR*\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001fR\u0016\u0010\u001a\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010#R\u0016\u0010\u001b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010#R\u0011\u00107\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b7\u0010#R\u0011\u00108\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b8\u0010#¨\u0006Q"}, m1599d2 = {"Lcom/myscript/nebo/sso/api/entity/SSOAccount;", "", "login", "", "firstName", "lastName", "email", "isActivated", "", "isExplicitConsentTermsPrivacy", "explicitConsentTermsPrivacyVersion", "", "explicitConsentTermsPrivacyDate", "providers", "", "Lcom/myscript/nebo/sso/api/entity/Provider;", "shareWithMyScript", "publicAuthorId", "features", "", "Lcom/myscript/nebo/sso/api/entity/SSONeboFeature;", "legalNoticeVersionAccepted", "consents", "Lcom/myscript/nebo/sso/api/entity/Consent;", "appConnectionKey", "helpUsScreenShown", "isDeletionRequested", "isSocialOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getLogin", "()Ljava/lang/String;", "getFirstName", "getLastName", "getEmail", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExplicitConsentTermsPrivacyVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExplicitConsentTermsPrivacyDate", "getProviders", "()Ljava/util/List;", "getShareWithMyScript", "getPublicAuthorId", "getFeatures$annotations", "()V", "getFeatures", "()Ljava/util/Map;", "getLegalNoticeVersionAccepted", "()I", "getConsents", "getAppConnectionKey", "getHelpUsScreenShown", "isSharedWithMyScript", "isInstrumentedFeatureActivated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/myscript/nebo/sso/api/entity/SSOAccount;", "equals", "other", "hashCode", "toString", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class SSOAccount {

    @SerializedName("app_connection_key")
    private final String appConnectionKey;

    @SerializedName("consents")
    private final Map<String, Consent> consents;

    @SerializedName("email")
    private final String email;

    @SerializedName("explicit_consent_terms_privacy_date")
    private final String explicitConsentTermsPrivacyDate;

    @SerializedName("explicit_consent_terms_privacy_version")
    private final Integer explicitConsentTermsPrivacyVersion;

    @SerializedName("features")
    private final Map<String, SSONeboFeature> features;

    @SerializedName("firstName")
    private final String firstName;

    @SerializedName("help_us_screen_shown")
    private final String helpUsScreenShown;

    @SerializedName("activated")
    private final boolean isActivated;

    @SerializedName("deletion_requested")
    private final boolean isDeletionRequested;

    @SerializedName("explicit_consent_terms_privacy")
    private final Boolean isExplicitConsentTermsPrivacy;

    @SerializedName("is_social_only")
    private final boolean isSocialOnly;

    @SerializedName("lastName")
    private final String lastName;

    @SerializedName("legal_notice_version_accepted")
    private final int legalNoticeVersionAccepted;

    @SerializedName("login")
    private final String login;

    @SerializedName("provider")
    private final List<Provider> providers;

    @SerializedName("public_author_id")
    private final String publicAuthorId;

    @SerializedName("share_with_myscript")
    private final String shareWithMyScript;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SSOAccount copy$default(SSOAccount sSOAccount, String str, String str2, String str3, String str4, boolean z, Boolean bool, Integer num, String str5, List list, String str6, String str7, Map map, int i, Map map2, String str8, String str9, boolean z2, boolean z3, int i2, Object obj) {
        boolean z4;
        boolean z5;
        String str10 = (i2 & 1) != 0 ? sSOAccount.login : str;
        String str11 = (i2 & 2) != 0 ? sSOAccount.firstName : str2;
        String str12 = (i2 & 4) != 0 ? sSOAccount.lastName : str3;
        String str13 = (i2 & 8) != 0 ? sSOAccount.email : str4;
        boolean z6 = (i2 & 16) != 0 ? sSOAccount.isActivated : z;
        Boolean bool2 = (i2 & 32) != 0 ? sSOAccount.isExplicitConsentTermsPrivacy : bool;
        Integer num2 = (i2 & 64) != 0 ? sSOAccount.explicitConsentTermsPrivacyVersion : num;
        String str14 = (i2 & 128) != 0 ? sSOAccount.explicitConsentTermsPrivacyDate : str5;
        List list2 = (i2 & 256) != 0 ? sSOAccount.providers : list;
        String str15 = (i2 & 512) != 0 ? sSOAccount.shareWithMyScript : str6;
        String str16 = (i2 & 1024) != 0 ? sSOAccount.publicAuthorId : str7;
        Map map3 = (i2 & 2048) != 0 ? sSOAccount.features : map;
        int i3 = (i2 & 4096) != 0 ? sSOAccount.legalNoticeVersionAccepted : i;
        Map map4 = (i2 & 8192) != 0 ? sSOAccount.consents : map2;
        String str17 = str10;
        String str18 = (i2 & 16384) != 0 ? sSOAccount.appConnectionKey : str8;
        String str19 = (i2 & 32768) != 0 ? sSOAccount.helpUsScreenShown : str9;
        boolean z7 = (i2 & 65536) != 0 ? sSOAccount.isDeletionRequested : z2;
        if ((i2 & 131072) != 0) {
            z5 = z7;
            z4 = sSOAccount.isSocialOnly;
        } else {
            z4 = z3;
            z5 = z7;
        }
        return sSOAccount.copy(str17, str11, str12, str13, z6, bool2, num2, str14, list2, str15, str16, map3, i3, map4, str18, str19, z5, z4);
    }

    @Deprecated(message = "Use SSO shouldn't deal with Nebo feature flag")
    public static /* synthetic */ void getFeatures$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getShareWithMyScript() {
        return this.shareWithMyScript;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPublicAuthorId() {
        return this.publicAuthorId;
    }

    public final Map<String, SSONeboFeature> component12() {
        return this.features;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getLegalNoticeVersionAccepted() {
        return this.legalNoticeVersionAccepted;
    }

    public final Map<String, Consent> component14() {
        return this.consents;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getAppConnectionKey() {
        return this.appConnectionKey;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getHelpUsScreenShown() {
        return this.helpUsScreenShown;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getIsDeletionRequested() {
        return this.isDeletionRequested;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getIsSocialOnly() {
        return this.isSocialOnly;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsActivated() {
        return this.isActivated;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsExplicitConsentTermsPrivacy() {
        return this.isExplicitConsentTermsPrivacy;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getExplicitConsentTermsPrivacyVersion() {
        return this.explicitConsentTermsPrivacyVersion;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getExplicitConsentTermsPrivacyDate() {
        return this.explicitConsentTermsPrivacyDate;
    }

    public final List<Provider> component9() {
        return this.providers;
    }

    public final SSOAccount copy(String login, String firstName, String lastName, String email, boolean isActivated, Boolean isExplicitConsentTermsPrivacy, Integer explicitConsentTermsPrivacyVersion, String explicitConsentTermsPrivacyDate, List<Provider> providers, String shareWithMyScript, String publicAuthorId, Map<String, SSONeboFeature> features, int legalNoticeVersionAccepted, Map<String, Consent> consents, String appConnectionKey, String helpUsScreenShown, boolean isDeletionRequested, boolean isSocialOnly) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(consents, "consents");
        Intrinsics.checkNotNullParameter(appConnectionKey, "appConnectionKey");
        Intrinsics.checkNotNullParameter(helpUsScreenShown, "helpUsScreenShown");
        return new SSOAccount(login, firstName, lastName, email, isActivated, isExplicitConsentTermsPrivacy, explicitConsentTermsPrivacyVersion, explicitConsentTermsPrivacyDate, providers, shareWithMyScript, publicAuthorId, features, legalNoticeVersionAccepted, consents, appConnectionKey, helpUsScreenShown, isDeletionRequested, isSocialOnly);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SSOAccount)) {
            return false;
        }
        SSOAccount sSOAccount = (SSOAccount) other;
        return Intrinsics.areEqual(this.login, sSOAccount.login) && Intrinsics.areEqual(this.firstName, sSOAccount.firstName) && Intrinsics.areEqual(this.lastName, sSOAccount.lastName) && Intrinsics.areEqual(this.email, sSOAccount.email) && this.isActivated == sSOAccount.isActivated && Intrinsics.areEqual(this.isExplicitConsentTermsPrivacy, sSOAccount.isExplicitConsentTermsPrivacy) && Intrinsics.areEqual(this.explicitConsentTermsPrivacyVersion, sSOAccount.explicitConsentTermsPrivacyVersion) && Intrinsics.areEqual(this.explicitConsentTermsPrivacyDate, sSOAccount.explicitConsentTermsPrivacyDate) && Intrinsics.areEqual(this.providers, sSOAccount.providers) && Intrinsics.areEqual(this.shareWithMyScript, sSOAccount.shareWithMyScript) && Intrinsics.areEqual(this.publicAuthorId, sSOAccount.publicAuthorId) && Intrinsics.areEqual(this.features, sSOAccount.features) && this.legalNoticeVersionAccepted == sSOAccount.legalNoticeVersionAccepted && Intrinsics.areEqual(this.consents, sSOAccount.consents) && Intrinsics.areEqual(this.appConnectionKey, sSOAccount.appConnectionKey) && Intrinsics.areEqual(this.helpUsScreenShown, sSOAccount.helpUsScreenShown) && this.isDeletionRequested == sSOAccount.isDeletionRequested && this.isSocialOnly == sSOAccount.isSocialOnly;
    }

    public int hashCode() {
        int iHashCode = this.login.hashCode() * 31;
        String str = this.firstName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.lastName;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.email.hashCode()) * 31) + Boolean.hashCode(this.isActivated)) * 31;
        Boolean bool = this.isExplicitConsentTermsPrivacy;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.explicitConsentTermsPrivacyVersion;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.explicitConsentTermsPrivacyDate;
        int iHashCode6 = (((iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.providers.hashCode()) * 31;
        String str4 = this.shareWithMyScript;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.publicAuthorId;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Map<String, SSONeboFeature> map = this.features;
        return ((((((((((((iHashCode8 + (map != null ? map.hashCode() : 0)) * 31) + Integer.hashCode(this.legalNoticeVersionAccepted)) * 31) + this.consents.hashCode()) * 31) + this.appConnectionKey.hashCode()) * 31) + this.helpUsScreenShown.hashCode()) * 31) + Boolean.hashCode(this.isDeletionRequested)) * 31) + Boolean.hashCode(this.isSocialOnly);
    }

    public String toString() {
        return "SSOAccount(login=" + this.login + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", isActivated=" + this.isActivated + ", isExplicitConsentTermsPrivacy=" + this.isExplicitConsentTermsPrivacy + ", explicitConsentTermsPrivacyVersion=" + this.explicitConsentTermsPrivacyVersion + ", explicitConsentTermsPrivacyDate=" + this.explicitConsentTermsPrivacyDate + ", providers=" + this.providers + ", shareWithMyScript=" + this.shareWithMyScript + ", publicAuthorId=" + this.publicAuthorId + ", features=" + this.features + ", legalNoticeVersionAccepted=" + this.legalNoticeVersionAccepted + ", consents=" + this.consents + ", appConnectionKey=" + this.appConnectionKey + ", helpUsScreenShown=" + this.helpUsScreenShown + ", isDeletionRequested=" + this.isDeletionRequested + ", isSocialOnly=" + this.isSocialOnly + ")";
    }

    public SSOAccount(String login, String str, String str2, String email, boolean z, Boolean bool, Integer num, String str3, List<Provider> providers, String str4, String str5, Map<String, SSONeboFeature> map, int i, Map<String, Consent> consents, String appConnectionKey, String helpUsScreenShown, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(consents, "consents");
        Intrinsics.checkNotNullParameter(appConnectionKey, "appConnectionKey");
        Intrinsics.checkNotNullParameter(helpUsScreenShown, "helpUsScreenShown");
        this.login = login;
        this.firstName = str;
        this.lastName = str2;
        this.email = email;
        this.isActivated = z;
        this.isExplicitConsentTermsPrivacy = bool;
        this.explicitConsentTermsPrivacyVersion = num;
        this.explicitConsentTermsPrivacyDate = str3;
        this.providers = providers;
        this.shareWithMyScript = str4;
        this.publicAuthorId = str5;
        this.features = map;
        this.legalNoticeVersionAccepted = i;
        this.consents = consents;
        this.appConnectionKey = appConnectionKey;
        this.helpUsScreenShown = helpUsScreenShown;
        this.isDeletionRequested = z2;
        this.isSocialOnly = z3;
    }

    public /* synthetic */ SSOAccount(String str, String str2, String str3, String str4, boolean z, Boolean bool, Integer num, String str5, List list, String str6, String str7, Map map, int i, Map map2, String str8, String str9, boolean z2, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, str4, z, (i2 & 32) != 0 ? null : bool, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : str5, list, (i2 & 512) != 0 ? null : str6, (i2 & 1024) != 0 ? null : str7, (i2 & 2048) != 0 ? null : map, i, map2, str8, str9, z2, z3);
    }

    public final String getLogin() {
        return this.login;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean isActivated() {
        return this.isActivated;
    }

    public final Boolean isExplicitConsentTermsPrivacy() {
        return this.isExplicitConsentTermsPrivacy;
    }

    public final Integer getExplicitConsentTermsPrivacyVersion() {
        return this.explicitConsentTermsPrivacyVersion;
    }

    public final String getExplicitConsentTermsPrivacyDate() {
        return this.explicitConsentTermsPrivacyDate;
    }

    public final List<Provider> getProviders() {
        return this.providers;
    }

    public final String getShareWithMyScript() {
        return this.shareWithMyScript;
    }

    public final String getPublicAuthorId() {
        return this.publicAuthorId;
    }

    public final Map<String, SSONeboFeature> getFeatures() {
        return this.features;
    }

    public final int getLegalNoticeVersionAccepted() {
        return this.legalNoticeVersionAccepted;
    }

    public final Map<String, Consent> getConsents() {
        return this.consents;
    }

    public final String getAppConnectionKey() {
        return this.appConnectionKey;
    }

    public final String getHelpUsScreenShown() {
        return this.helpUsScreenShown;
    }

    public final boolean isDeletionRequested() {
        return this.isDeletionRequested;
    }

    public final boolean isSocialOnly() {
        return this.isSocialOnly;
    }

    public final boolean isSharedWithMyScript() {
        return Intrinsics.areEqual(this.shareWithMyScript, "1");
    }

    public final boolean isInstrumentedFeatureActivated() {
        SSONeboFeature sSONeboFeature;
        Map<String, SSONeboFeature> map = this.features;
        if (map == null || (sSONeboFeature = map.get("instrumented")) == null) {
            return false;
        }
        return sSONeboFeature.isActivated();
    }
}
