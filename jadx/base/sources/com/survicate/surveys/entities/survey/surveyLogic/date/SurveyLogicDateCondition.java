package com.survicate.surveys.entities.survey.surveyLogic.date;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicDateCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/date/SurveyLogicDateCondition;", "", "<init>", "(Ljava/lang/String;I)V", "HAS_ANY_VALUE", "QUESTION_IS_ANSWERED", "QUESTION_IS_NOT_ANSWERED", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicDateCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicDateCondition[] $VALUES;

    @SerialName("has_any_value")
    public static final SurveyLogicDateCondition HAS_ANY_VALUE = new SurveyLogicDateCondition("HAS_ANY_VALUE", 0);

    @SerialName("question_is_answered")
    public static final SurveyLogicDateCondition QUESTION_IS_ANSWERED = new SurveyLogicDateCondition("QUESTION_IS_ANSWERED", 1);

    @SerialName("question_is_not_answered")
    public static final SurveyLogicDateCondition QUESTION_IS_NOT_ANSWERED = new SurveyLogicDateCondition("QUESTION_IS_NOT_ANSWERED", 2);

    private static final /* synthetic */ SurveyLogicDateCondition[] $values() {
        return new SurveyLogicDateCondition[]{HAS_ANY_VALUE, QUESTION_IS_ANSWERED, QUESTION_IS_NOT_ANSWERED};
    }

    public static EnumEntries<SurveyLogicDateCondition> getEntries() {
        return $ENTRIES;
    }

    private SurveyLogicDateCondition(String str, int i) {
    }

    static {
        SurveyLogicDateCondition[] surveyLogicDateConditionArr$values = $values();
        $VALUES = surveyLogicDateConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicDateConditionArr$values);
    }

    public static SurveyLogicDateCondition valueOf(String str) {
        return (SurveyLogicDateCondition) Enum.valueOf(SurveyLogicDateCondition.class, str);
    }

    public static SurveyLogicDateCondition[] values() {
        return (SurveyLogicDateCondition[]) $VALUES.clone();
    }
}
