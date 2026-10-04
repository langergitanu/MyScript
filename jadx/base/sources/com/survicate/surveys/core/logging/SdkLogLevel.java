package com.survicate.surveys.core.logging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SdkLogLevel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/logging/SdkLogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "DEBUG", "INFO", "WARN", "ERROR", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SdkLogLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SdkLogLevel[] $VALUES;
    public static final SdkLogLevel DEBUG = new SdkLogLevel("DEBUG", 0);
    public static final SdkLogLevel INFO = new SdkLogLevel("INFO", 1);
    public static final SdkLogLevel WARN = new SdkLogLevel("WARN", 2);
    public static final SdkLogLevel ERROR = new SdkLogLevel("ERROR", 3);

    private static final /* synthetic */ SdkLogLevel[] $values() {
        return new SdkLogLevel[]{DEBUG, INFO, WARN, ERROR};
    }

    public static EnumEntries<SdkLogLevel> getEntries() {
        return $ENTRIES;
    }

    private SdkLogLevel(String str, int i) {
    }

    static {
        SdkLogLevel[] sdkLogLevelArr$values = $values();
        $VALUES = sdkLogLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sdkLogLevelArr$values);
    }

    public static SdkLogLevel valueOf(String str) {
        return (SdkLogLevel) Enum.valueOf(SdkLogLevel.class, str);
    }

    public static SdkLogLevel[] values() {
        return (SdkLogLevel[]) $VALUES.clone();
    }
}
