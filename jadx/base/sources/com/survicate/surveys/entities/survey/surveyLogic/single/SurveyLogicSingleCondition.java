package com.survicate.surveys.entities.survey.surveyLogic.single;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicSingleCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/single/SurveyLogicSingleCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "HAS_ANY_VALUE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicSingleCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicSingleCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    @SerialName("is")
    public static final SurveyLogicSingleCondition f2286IS = new SurveyLogicSingleCondition("IS", 0);

    @SerialName("is_not")
    public static final SurveyLogicSingleCondition IS_NOT = new SurveyLogicSingleCondition("IS_NOT", 1);

    @SerialName("has_any_value")
    public static final SurveyLogicSingleCondition HAS_ANY_VALUE = new SurveyLogicSingleCondition("HAS_ANY_VALUE", 2);

    private static final /* synthetic */ SurveyLogicSingleCondition[] $values() {
        return new SurveyLogicSingleCondition[]{f2286IS, IS_NOT, HAS_ANY_VALUE};
    }

    public static EnumEntries<SurveyLogicSingleCondition> getEntries() {
        return $ENTRIES;
    }

    private SurveyLogicSingleCondition(String str, int i) {
    }

    static {
        SurveyLogicSingleCondition[] surveyLogicSingleConditionArr$values = $values();
        $VALUES = surveyLogicSingleConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicSingleConditionArr$values);
    }

    public static SurveyLogicSingleCondition valueOf(String str) {
        return (SurveyLogicSingleCondition) Enum.valueOf(SurveyLogicSingleCondition.class, str);
    }

    public static SurveyLogicSingleCondition[] values() {
        return (SurveyLogicSingleCondition[]) $VALUES.clone();
    }
}
