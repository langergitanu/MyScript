package com.survicate.surveys.infrastructure.storage.contacts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BackendTargetingState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/contacts/BackendTargetingState;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "UNKNOWN", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BackendTargetingState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackendTargetingState[] $VALUES;
    public static final BackendTargetingState ENABLED = new BackendTargetingState("ENABLED", 0);
    public static final BackendTargetingState DISABLED = new BackendTargetingState("DISABLED", 1);
    public static final BackendTargetingState UNKNOWN = new BackendTargetingState("UNKNOWN", 2);

    private static final /* synthetic */ BackendTargetingState[] $values() {
        return new BackendTargetingState[]{ENABLED, DISABLED, UNKNOWN};
    }

    public static EnumEntries<BackendTargetingState> getEntries() {
        return $ENTRIES;
    }

    private BackendTargetingState(String str, int i) {
    }

    static {
        BackendTargetingState[] backendTargetingStateArr$values = $values();
        $VALUES = backendTargetingStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(backendTargetingStateArr$values);
    }

    public static BackendTargetingState valueOf(String str) {
        return (BackendTargetingState) Enum.valueOf(BackendTargetingState.class, str);
    }

    public static BackendTargetingState[] values() {
        return (BackendTargetingState[]) $VALUES.clone();
    }
}
