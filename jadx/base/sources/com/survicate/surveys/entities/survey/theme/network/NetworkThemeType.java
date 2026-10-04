package com.survicate.surveys.entities.survey.theme.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NetworkThemeType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/network/NetworkThemeType;", "", "<init>", "(Ljava/lang/String;I)V", "MICRO", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkThemeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetworkThemeType[] $VALUES;

    @SerialName("MicroTheme")
    public static final NetworkThemeType MICRO = new NetworkThemeType("MICRO", 0);

    private static final /* synthetic */ NetworkThemeType[] $values() {
        return new NetworkThemeType[]{MICRO};
    }

    public static EnumEntries<NetworkThemeType> getEntries() {
        return $ENTRIES;
    }

    private NetworkThemeType(String str, int i) {
    }

    static {
        NetworkThemeType[] networkThemeTypeArr$values = $values();
        $VALUES = networkThemeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(networkThemeTypeArr$values);
    }

    public static NetworkThemeType valueOf(String str) {
        return (NetworkThemeType) Enum.valueOf(NetworkThemeType.class, str);
    }

    public static NetworkThemeType[] values() {
        return (NetworkThemeType[]) $VALUES.clone();
    }
}
