package com.myscript.nebo.analytics.firebase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NeboFirebaseEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/LoginOrigin;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SettingsAccount", "Sync", "AiButton", "PremiumModal", "Onboarding", "CreateLink", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoginOrigin[] $VALUES;
    private final String value;
    public static final LoginOrigin SettingsAccount = new LoginOrigin("SettingsAccount", 0, "settings_account");
    public static final LoginOrigin Sync = new LoginOrigin("Sync", 1, "sync");
    public static final LoginOrigin AiButton = new LoginOrigin("AiButton", 2, "ai_button");
    public static final LoginOrigin PremiumModal = new LoginOrigin("PremiumModal", 3, "premium_modal");
    public static final LoginOrigin Onboarding = new LoginOrigin("Onboarding", 4, "onboarding");
    public static final LoginOrigin CreateLink = new LoginOrigin("CreateLink", 5, "create_link");

    private static final /* synthetic */ LoginOrigin[] $values() {
        return new LoginOrigin[]{SettingsAccount, Sync, AiButton, PremiumModal, Onboarding, CreateLink};
    }

    public static EnumEntries<LoginOrigin> getEntries() {
        return $ENTRIES;
    }

    public static LoginOrigin valueOf(String str) {
        return (LoginOrigin) Enum.valueOf(LoginOrigin.class, str);
    }

    public static LoginOrigin[] values() {
        return (LoginOrigin[]) $VALUES.clone();
    }

    private LoginOrigin(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        LoginOrigin[] loginOriginArr$values = $values();
        $VALUES = loginOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(loginOriginArr$values);
    }
}
