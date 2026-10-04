package com.survicate.surveys.core.targeting;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SurveyChanceResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/SurveyChanceResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyChanceResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyChanceResult[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final SurveyChanceResult SUCCESS = new SurveyChanceResult("SUCCESS", 0);
    public static final SurveyChanceResult FAILURE = new SurveyChanceResult("FAILURE", 1);

    private static final /* synthetic */ SurveyChanceResult[] $values() {
        return new SurveyChanceResult[]{SUCCESS, FAILURE};
    }

    public static EnumEntries<SurveyChanceResult> getEntries() {
        return $ENTRIES;
    }

    private SurveyChanceResult(String str, int i) {
    }

    static {
        SurveyChanceResult[] surveyChanceResultArr$values = $values();
        $VALUES = surveyChanceResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(surveyChanceResultArr$values);
        INSTANCE = new Companion(null);
    }

    /* JADX INFO: compiled from: SurveyChanceResult.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/SurveyChanceResult$Companion;", "", "<init>", "()V", "fromPercentage", "Lcom/survicate/surveys/core/targeting/SurveyChanceResult;", "generatedPercentage", "", "expectedPercentage", "fromPercentage$shared_release", "(DLjava/lang/Double;)Lcom/survicate/surveys/core/targeting/SurveyChanceResult;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SurveyChanceResult fromPercentage$shared_release(double generatedPercentage, Double expectedPercentage) {
            if (expectedPercentage == null || expectedPercentage.doubleValue() <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return SurveyChanceResult.FAILURE;
            }
            return generatedPercentage <= expectedPercentage.doubleValue() ? SurveyChanceResult.SUCCESS : SurveyChanceResult.FAILURE;
        }
    }

    public static SurveyChanceResult valueOf(String str) {
        return (SurveyChanceResult) Enum.valueOf(SurveyChanceResult.class, str);
    }

    public static SurveyChanceResult[] values() {
        return (SurveyChanceResult[]) $VALUES.clone();
    }
}
