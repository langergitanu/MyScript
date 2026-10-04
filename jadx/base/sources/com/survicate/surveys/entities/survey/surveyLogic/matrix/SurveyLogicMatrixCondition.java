package com.survicate.surveys.entities.survey.surveyLogic.matrix;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicMatrixCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "IS_BETWEEN", "HAS_ANY_VALUE", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyLogicMatrixCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicMatrixCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    @SerialName("is")
    public static final SurveyLogicMatrixCondition f2284IS = new SurveyLogicMatrixCondition("IS", 0);

    @SerialName("is_not")
    public static final SurveyLogicMatrixCondition IS_NOT = new SurveyLogicMatrixCondition("IS_NOT", 1);

    @SerialName("is_between")
    public static final SurveyLogicMatrixCondition IS_BETWEEN = new SurveyLogicMatrixCondition("IS_BETWEEN", 2);

    @SerialName("has_any_value")
    public static final SurveyLogicMatrixCondition HAS_ANY_VALUE = new SurveyLogicMatrixCondition("HAS_ANY_VALUE", 3);

    private static final /* synthetic */ SurveyLogicMatrixCondition[] $values() {
        return new SurveyLogicMatrixCondition[]{f2284IS, IS_NOT, IS_BETWEEN, HAS_ANY_VALUE};
    }

    public static EnumEntries<SurveyLogicMatrixCondition> getEntries() {
        return $ENTRIES;
    }

    private SurveyLogicMatrixCondition(String str, int i) {
    }

    static {
        SurveyLogicMatrixCondition[] surveyLogicMatrixConditionArr$values = $values();
        $VALUES = surveyLogicMatrixConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicMatrixConditionArr$values);
    }

    public static SurveyLogicMatrixCondition valueOf(String str) {
        return (SurveyLogicMatrixCondition) Enum.valueOf(SurveyLogicMatrixCondition.class, str);
    }

    public static SurveyLogicMatrixCondition[] values() {
        return (SurveyLogicMatrixCondition[]) $VALUES.clone();
    }
}
