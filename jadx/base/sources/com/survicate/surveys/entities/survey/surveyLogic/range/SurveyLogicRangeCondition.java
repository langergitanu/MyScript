package com.survicate.surveys.entities.survey.surveyLogic.range;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicRangeCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyLogicRangeCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "IS_BETWEEN", "HAS_ANY_VALUE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicRangeCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicRangeCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    @SerialName("is")
    public static final SurveyLogicRangeCondition f2285IS = new SurveyLogicRangeCondition("IS", 0);

    @SerialName("is_not")
    public static final SurveyLogicRangeCondition IS_NOT = new SurveyLogicRangeCondition("IS_NOT", 1);

    @SerialName("is_between")
    public static final SurveyLogicRangeCondition IS_BETWEEN = new SurveyLogicRangeCondition("IS_BETWEEN", 2);

    @SerialName("has_any_value")
    public static final SurveyLogicRangeCondition HAS_ANY_VALUE = new SurveyLogicRangeCondition("HAS_ANY_VALUE", 3);

    private static final /* synthetic */ SurveyLogicRangeCondition[] $values() {
        return new SurveyLogicRangeCondition[]{f2285IS, IS_NOT, IS_BETWEEN, HAS_ANY_VALUE};
    }

    public static EnumEntries<SurveyLogicRangeCondition> getEntries() {
        return $ENTRIES;
    }

    private SurveyLogicRangeCondition(String str, int i) {
    }

    static {
        SurveyLogicRangeCondition[] surveyLogicRangeConditionArr$values = $values();
        $VALUES = surveyLogicRangeConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicRangeConditionArr$values);
    }

    public static SurveyLogicRangeCondition valueOf(String str) {
        return (SurveyLogicRangeCondition) Enum.valueOf(SurveyLogicRangeCondition.class, str);
    }

    public static SurveyLogicRangeCondition[] values() {
        return (SurveyLogicRangeCondition[]) $VALUES.clone();
    }
}
