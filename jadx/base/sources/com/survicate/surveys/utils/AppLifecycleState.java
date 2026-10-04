package com.survicate.surveys.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AppLifecycleProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/utils/AppLifecycleState;", "", "<init>", "(Ljava/lang/String;I)V", "FOREGROUND", "BACKGROUND", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AppLifecycleState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppLifecycleState[] $VALUES;
    public static final AppLifecycleState FOREGROUND = new AppLifecycleState("FOREGROUND", 0);
    public static final AppLifecycleState BACKGROUND = new AppLifecycleState("BACKGROUND", 1);

    private static final /* synthetic */ AppLifecycleState[] $values() {
        return new AppLifecycleState[]{FOREGROUND, BACKGROUND};
    }

    public static EnumEntries<AppLifecycleState> getEntries() {
        return $ENTRIES;
    }

    private AppLifecycleState(String str, int i) {
    }

    static {
        AppLifecycleState[] appLifecycleStateArr$values = $values();
        $VALUES = appLifecycleStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(appLifecycleStateArr$values);
    }

    public static AppLifecycleState valueOf(String str) {
        return (AppLifecycleState) Enum.valueOf(AppLifecycleState.class, str);
    }

    public static AppLifecycleState[] values() {
        return (AppLifecycleState[]) $VALUES.clone();
    }
}
