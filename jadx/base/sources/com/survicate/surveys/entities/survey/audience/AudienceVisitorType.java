package com.survicate.surveys.entities.survey.audience;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AudienceVisitorType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/audience/AudienceVisitorType;", "", "<init>", "(Ljava/lang/String;I)V", "ANONYMOUS", "IDENTIFIED", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AudienceVisitorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudienceVisitorType[] $VALUES;

    @SerialName("anonymous")
    public static final AudienceVisitorType ANONYMOUS = new AudienceVisitorType("ANONYMOUS", 0);

    @SerialName("identified")
    public static final AudienceVisitorType IDENTIFIED = new AudienceVisitorType("IDENTIFIED", 1);

    private static final /* synthetic */ AudienceVisitorType[] $values() {
        return new AudienceVisitorType[]{ANONYMOUS, IDENTIFIED};
    }

    public static EnumEntries<AudienceVisitorType> getEntries() {
        return $ENTRIES;
    }

    private AudienceVisitorType(String str, int i) {
    }

    static {
        AudienceVisitorType[] audienceVisitorTypeArr$values = $values();
        $VALUES = audienceVisitorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(audienceVisitorTypeArr$values);
    }

    public static AudienceVisitorType valueOf(String str) {
        return (AudienceVisitorType) Enum.valueOf(AudienceVisitorType.class, str);
    }

    public static AudienceVisitorType[] values() {
        return (AudienceVisitorType[]) $VALUES.clone();
    }
}
