package com.survicate.surveys.entities.survey.theme;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThemeSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "", "companyLogo", "", "personalization", "", "shortTextMessage", "avatarImage", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getCompanyLogo", "()Ljava/lang/String;", "getPersonalization", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShortTextMessage", "getAvatarImage", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "equals", "other", "hashCode", "", "toString", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ThemeSettings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String avatarImage;
    private final String companyLogo;
    private final Boolean personalization;
    private final String shortTextMessage;

    public static /* synthetic */ ThemeSettings copy$default(ThemeSettings themeSettings, String str, Boolean bool, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = themeSettings.companyLogo;
        }
        if ((i & 2) != 0) {
            bool = themeSettings.personalization;
        }
        if ((i & 4) != 0) {
            str2 = themeSettings.shortTextMessage;
        }
        if ((i & 8) != 0) {
            str3 = themeSettings.avatarImage;
        }
        return themeSettings.copy(str, bool, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCompanyLogo() {
        return this.companyLogo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getPersonalization() {
        return this.personalization;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getShortTextMessage() {
        return this.shortTextMessage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarImage() {
        return this.avatarImage;
    }

    public final ThemeSettings copy(String companyLogo, Boolean personalization, String shortTextMessage, String avatarImage) {
        return new ThemeSettings(companyLogo, personalization, shortTextMessage, avatarImage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThemeSettings)) {
            return false;
        }
        ThemeSettings themeSettings = (ThemeSettings) other;
        return Intrinsics.areEqual(this.companyLogo, themeSettings.companyLogo) && Intrinsics.areEqual(this.personalization, themeSettings.personalization) && Intrinsics.areEqual(this.shortTextMessage, themeSettings.shortTextMessage) && Intrinsics.areEqual(this.avatarImage, themeSettings.avatarImage);
    }

    public int hashCode() {
        String str = this.companyLogo;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.personalization;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.shortTextMessage;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatarImage;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ThemeSettings(companyLogo=" + this.companyLogo + ", personalization=" + this.personalization + ", shortTextMessage=" + this.shortTextMessage + ", avatarImage=" + this.avatarImage + ')';
    }

    public ThemeSettings(String str, Boolean bool, String str2, String str3) {
        this.companyLogo = str;
        this.personalization = bool;
        this.shortTextMessage = str2;
        this.avatarImage = str3;
    }

    public final String getCompanyLogo() {
        return this.companyLogo;
    }

    public final Boolean getPersonalization() {
        return this.personalization;
    }

    public final String getShortTextMessage() {
        return this.shortTextMessage;
    }

    public final String getAvatarImage() {
        return this.avatarImage;
    }

    /* JADX INFO: compiled from: ThemeSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/ThemeSettings$Companion;", "", "<init>", "()V", "empty", "Lcom/survicate/surveys/entities/survey/theme/ThemeSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThemeSettings empty() {
            return new ThemeSettings(null, null, null, null);
        }
    }
}
