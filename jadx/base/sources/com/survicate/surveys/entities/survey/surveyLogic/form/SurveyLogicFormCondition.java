package com.survicate.surveys.entities.survey.surveyLogic.form;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicFormCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS_FILLED_IN", "IS_NOT_FILLED_IN", "HAS_ANY_VALUE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicFormCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicFormCondition[] $VALUES;

    @SerialName("is_filled_in")
    public static final SurveyLogicFormCondition IS_FILLED_IN = new SurveyLogicFormCondition("IS_FILLED_IN", 0);

    @SerialName("is_not_filled_in")
    public static final SurveyLogicFormCondition IS_NOT_FILLED_IN = new SurveyLogicFormCondition("IS_NOT_FILLED_IN", 1);

    @SerialName("has_any_value")
    public static final SurveyLogicFormCondition HAS_ANY_VALUE = new SurveyLogicFormCondition("HAS_ANY_VALUE", 2);

    private static final /* synthetic */ SurveyLogicFormCondition[] $values() {
        return new SurveyLogicFormCondition[]{IS_FILLED_IN, IS_NOT_FILLED_IN, HAS_ANY_VALUE};
    }

    public static EnumEntries<SurveyLogicFormCondition> getEntries() {
        return $ENTRIES;
    }

    private SurveyLogicFormCondition(String str, int i) {
    }

    static {
        SurveyLogicFormCondition[] surveyLogicFormConditionArr$values = $values();
        $VALUES = surveyLogicFormConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicFormConditionArr$values);
    }

    public static SurveyLogicFormCondition valueOf(String str) {
        return (SurveyLogicFormCondition) Enum.valueOf(SurveyLogicFormCondition.class, str);
    }

    public static SurveyLogicFormCondition[] values() {
        return (SurveyLogicFormCondition[]) $VALUES.clone();
    }
}
