package com.survicate.surveys.core.targeting.displayfilter;

import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.providers.SurveyChanceStore;
import com.survicate.surveys.core.targeting.SurveyChanceResult;
import com.survicate.surveys.core.utils.DefaultRandomGenerator;
import com.survicate.surveys.core.utils.RandomGenerator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyChanceDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/SurveyChanceDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "surveyId", "", "expectedPercentage", "", "surveyChanceStore", "Lcom/survicate/surveys/core/providers/SurveyChanceStore;", "randomGenerator", "Lcom/survicate/surveys/core/utils/RandomGenerator;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Lcom/survicate/surveys/core/providers/SurveyChanceStore;Lcom/survicate/surveys/core/utils/RandomGenerator;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "(Ljava/lang/String;Ljava/lang/Double;Lcom/survicate/surveys/core/providers/SurveyChanceStore;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "Ljava/lang/Double;", "isSatisfied", "", "rollAndCache", "Lcom/survicate/surveys/core/targeting/SurveyChanceResult;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyChanceDisplayFilter implements DisplayFilter {
    private final Double expectedPercentage;
    private final SdkLogger logger;
    private final RandomGenerator randomGenerator;
    private final SurveyChanceStore surveyChanceStore;
    private final String surveyId;

    public SurveyChanceDisplayFilter(String surveyId, Double d, SurveyChanceStore surveyChanceStore, RandomGenerator randomGenerator, SdkLogger sdkLogger) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(surveyChanceStore, "surveyChanceStore");
        Intrinsics.checkNotNullParameter(randomGenerator, "randomGenerator");
        this.surveyId = surveyId;
        this.expectedPercentage = d;
        this.surveyChanceStore = surveyChanceStore;
        this.randomGenerator = randomGenerator;
        this.logger = sdkLogger;
    }

    public /* synthetic */ SurveyChanceDisplayFilter(String str, Double d, SurveyChanceStore surveyChanceStore, SdkLogger sdkLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d, surveyChanceStore, (i & 8) != 0 ? null : sdkLogger);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurveyChanceDisplayFilter(String surveyId, Double d, SurveyChanceStore surveyChanceStore, SdkLogger sdkLogger) {
        this(surveyId, d, surveyChanceStore, new DefaultRandomGenerator(), sdkLogger);
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(surveyChanceStore, "surveyChanceStore");
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        SdkLogger sdkLogger;
        SurveyChanceResult surveyChanceResultFindChanceResult = this.surveyChanceStore.findChanceResult(this.surveyId);
        if (surveyChanceResultFindChanceResult == null) {
            surveyChanceResultFindChanceResult = rollAndCache();
        }
        if (surveyChanceResultFindChanceResult == SurveyChanceResult.FAILURE && (sdkLogger = this.logger) != null) {
            sdkLogger.info("SurveyChance", "Survey " + this.surveyId + " had " + this.expectedPercentage + "% chance to be shown and it failed.");
        }
        return surveyChanceResultFindChanceResult == SurveyChanceResult.SUCCESS;
    }

    private final SurveyChanceResult rollAndCache() {
        SurveyChanceResult surveyChanceResultFromPercentage$shared_release = SurveyChanceResult.INSTANCE.fromPercentage$shared_release(this.randomGenerator.randomPercent(), this.expectedPercentage);
        this.surveyChanceStore.saveChanceResult(this.surveyId, surveyChanceResultFromPercentage$shared_release);
        return surveyChanceResultFromPercentage$shared_release;
    }
}
