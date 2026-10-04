package com.myscript.nebo.p034ui.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NativeSignInDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/ui/compose/PendingSignInAction;", "", "<init>", "(Ljava/lang/String;I)V", "Google", "Other", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class PendingSignInAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PendingSignInAction[] $VALUES;
    public static final PendingSignInAction Google = new PendingSignInAction("Google", 0);
    public static final PendingSignInAction Other = new PendingSignInAction("Other", 1);

    private static final /* synthetic */ PendingSignInAction[] $values() {
        return new PendingSignInAction[]{Google, Other};
    }

    public static EnumEntries<PendingSignInAction> getEntries() {
        return $ENTRIES;
    }

    public static PendingSignInAction valueOf(String str) {
        return (PendingSignInAction) Enum.valueOf(PendingSignInAction.class, str);
    }

    public static PendingSignInAction[] values() {
        return (PendingSignInAction[]) $VALUES.clone();
    }

    static {
        PendingSignInAction[] pendingSignInActionArr$values = $values();
        $VALUES = pendingSignInActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pendingSignInActionArr$values);
    }

    private PendingSignInAction(String str, int i) {
    }
}
