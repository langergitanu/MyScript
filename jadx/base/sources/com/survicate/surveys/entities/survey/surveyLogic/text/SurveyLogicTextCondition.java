package com.survicate.surveys.entities.survey.surveyLogic.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicTextCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;", "", "<init>", "(Ljava/lang/String;I)V", "ANSWER_CONTAINS", "ANSWER_DOES_NOT_CONTAIN", "QUESTION_IS_ANSWERED", "QUESTION_IS_NOT_ANSWERED", "HAS_ANY_VALUE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicTextCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicTextCondition[] $VALUES;

    @SerialName("answer_contains")
    public static final SurveyLogicTextCondition ANSWER_CONTAINS = new SurveyLogicTextCondition("ANSWER_CONTAINS", 0);

    @SerialName("answer_doesnt_contain")
    public static final SurveyLogicTextCondition ANSWER_DOES_NOT_CONTAIN = new SurveyLogicTextCondition("ANSWER_DOES_NOT_CONTAIN", 1);

    @SerialName("question_is_answered")
    public static final SurveyLogicTextCondition QUESTION_IS_ANSWERED = new SurveyLogicTextCondition("QUESTION_IS_ANSWERED", 2);

    @SerialName("question_is_not_answered")
    public static final SurveyLogicTextCondition QUESTION_IS_NOT_ANSWERED = new SurveyLogicTextCondition("QUESTION_IS_NOT_ANSWERED", 3);

    @SerialName("has_any_value")
    public static final SurveyLogicTextCondition HAS_ANY_VALUE = new SurveyLogicTextCondition("HAS_ANY_VALUE", 4);

    private static final /* synthetic */ SurveyLogicTextCondition[] $values() {
        return new SurveyLogicTextCondition[]{ANSWER_CONTAINS, ANSWER_DOES_NOT_CONTAIN, QUESTION_IS_ANSWERED, QUESTION_IS_NOT_ANSWERED, HAS_ANY_VALUE};
    }

    public static EnumEntries<SurveyLogicTextCondition> getEntries() {
        return $ENTRIES;
    }

    private SurveyLogicTextCondition(String str, int i) {
    }

    static {
        SurveyLogicTextCondition[] surveyLogicTextConditionArr$values = $values();
        $VALUES = surveyLogicTextConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicTextConditionArr$values);
    }

    public static SurveyLogicTextCondition valueOf(String str) {
        return (SurveyLogicTextCondition) Enum.valueOf(SurveyLogicTextCondition.class, str);
    }

    public static SurveyLogicTextCondition[] values() {
        return (SurveyLogicTextCondition[]) $VALUES.clone();
    }
}
