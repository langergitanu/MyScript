package com.survicate.surveys.entities.survey.surveyLogic.multiple;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyLogicMultipleCondition.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EXACTLY", "INCLUDES_ALL", "INCLUDES_ANY", "DOES_NOT_INCLUDE_ANY", "HAS_ANY_VALUE", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final class SurveyLogicMultipleCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyLogicMultipleCondition[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    @SerialName("is_exactly")
    public static final SurveyLogicMultipleCondition IS_EXACTLY = new SurveyLogicMultipleCondition("IS_EXACTLY", 0);

    @SerialName("includes_all_of_the_following")
    public static final SurveyLogicMultipleCondition INCLUDES_ALL = new SurveyLogicMultipleCondition("INCLUDES_ALL", 1);

    @SerialName("includes_any_of_the_following")
    public static final SurveyLogicMultipleCondition INCLUDES_ANY = new SurveyLogicMultipleCondition("INCLUDES_ANY", 2);

    @SerialName("doesnt_include_any_of_the_following")
    public static final SurveyLogicMultipleCondition DOES_NOT_INCLUDE_ANY = new SurveyLogicMultipleCondition("DOES_NOT_INCLUDE_ANY", 3);

    @SerialName("has_any_value")
    public static final SurveyLogicMultipleCondition HAS_ANY_VALUE = new SurveyLogicMultipleCondition("HAS_ANY_VALUE", 4);

    private static final /* synthetic */ SurveyLogicMultipleCondition[] $values() {
        return new SurveyLogicMultipleCondition[]{IS_EXACTLY, INCLUDES_ALL, INCLUDES_ANY, DOES_NOT_INCLUDE_ANY, HAS_ANY_VALUE};
    }

    public static EnumEntries<SurveyLogicMultipleCondition> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: SurveyLogicMultipleCondition.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SurveyLogicMultipleCondition.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SurveyLogicMultipleCondition> serializer() {
            return get$cachedSerializer();
        }
    }

    private SurveyLogicMultipleCondition(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyLogicMultipleCondition", values(), new String[]{"is_exactly", "includes_all_of_the_following", "includes_any_of_the_following", "doesnt_include_any_of_the_following", "has_any_value"}, new Annotation[][]{null, null, null, null, null}, null);
    }

    static {
        SurveyLogicMultipleCondition[] surveyLogicMultipleConditionArr$values = $values();
        $VALUES = surveyLogicMultipleConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyLogicMultipleConditionArr$values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyLogicMultipleCondition$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SurveyLogicMultipleCondition._init_$_anonymous_();
            }
        });
    }

    public static SurveyLogicMultipleCondition valueOf(String str) {
        return (SurveyLogicMultipleCondition) Enum.valueOf(SurveyLogicMultipleCondition.class, str);
    }

    public static SurveyLogicMultipleCondition[] values() {
        return (SurveyLogicMultipleCondition[]) $VALUES.clone();
    }
}
