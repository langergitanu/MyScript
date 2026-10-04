package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/grid/UserStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Trial", "Freemium", "Premium", "RenewalOffer", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserStatus[] $VALUES;
    public static final UserStatus Trial = new UserStatus("Trial", 0);
    public static final UserStatus Freemium = new UserStatus("Freemium", 1);
    public static final UserStatus Premium = new UserStatus("Premium", 2);
    public static final UserStatus RenewalOffer = new UserStatus("RenewalOffer", 3);

    private static final /* synthetic */ UserStatus[] $values() {
        return new UserStatus[]{Trial, Freemium, Premium, RenewalOffer};
    }

    public static EnumEntries<UserStatus> getEntries() {
        return $ENTRIES;
    }

    public static UserStatus valueOf(String str) {
        return (UserStatus) Enum.valueOf(UserStatus.class, str);
    }

    public static UserStatus[] values() {
        return (UserStatus[]) $VALUES.clone();
    }

    private UserStatus(String str, int i) {
    }

    static {
        UserStatus[] userStatusArr$values = $values();
        $VALUES = userStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(userStatusArr$values);
    }
}
