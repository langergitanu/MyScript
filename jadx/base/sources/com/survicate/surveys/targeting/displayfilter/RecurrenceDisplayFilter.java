package com.survicate.surveys.targeting.displayfilter;

import com.survicate.surveys.core.targeting.backend.BackendTargetingResultProvider;
import com.survicate.surveys.core.targeting.displayfilter.DisplayFilter;
import com.survicate.surveys.entities.survey.SurveySettings;
import com.survicate.surveys.targeting.provider.PresentationTimesProvider;
import com.survicate.surveys.targeting.provider.SeenSurveysProvider;
import com.survicate.surveys.utils.DateUtils;
import com.survicate.surveys.utils.FeatureFlags;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecurrenceDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/targeting/displayfilter/RecurrenceDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "surveyId", "", "surveySettings", "Lcom/survicate/surveys/entities/survey/SurveySettings;", "isContactMode", "", "backendTargetingResultProvider", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;", "seenSurveysProvider", "Lcom/survicate/surveys/targeting/provider/SeenSurveysProvider;", "presentationTimesProvider", "Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/entities/survey/SurveySettings;ZLcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;Lcom/survicate/surveys/targeting/provider/SeenSurveysProvider;Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;Lcom/survicate/surveys/utils/TimestampProvider;)V", "isSatisfied", "isPeriodSatisfied", "isStopAfterSatisfied", "isThrottlingSatisfied", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RecurrenceDisplayFilter implements DisplayFilter {
    private final BackendTargetingResultProvider backendTargetingResultProvider;
    private final boolean isContactMode;
    private final PresentationTimesProvider presentationTimesProvider;
    private final SeenSurveysProvider seenSurveysProvider;
    private final String surveyId;
    private final SurveySettings surveySettings;
    private final TimestampProvider timestampProvider;

    public RecurrenceDisplayFilter(String surveyId, SurveySettings surveySettings, boolean z, BackendTargetingResultProvider backendTargetingResultProvider, SeenSurveysProvider seenSurveysProvider, PresentationTimesProvider presentationTimesProvider, TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(surveySettings, "surveySettings");
        Intrinsics.checkNotNullParameter(backendTargetingResultProvider, "backendTargetingResultProvider");
        Intrinsics.checkNotNullParameter(seenSurveysProvider, "seenSurveysProvider");
        Intrinsics.checkNotNullParameter(presentationTimesProvider, "presentationTimesProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        this.surveyId = surveyId;
        this.surveySettings = surveySettings;
        this.isContactMode = z;
        this.backendTargetingResultProvider = backendTargetingResultProvider;
        this.seenSurveysProvider = seenSurveysProvider;
        this.presentationTimesProvider = presentationTimesProvider;
        this.timestampProvider = timestampProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        if (this.isContactMode && FeatureFlags.INSTANCE.isBackendTargetingEnabled()) {
            return this.backendTargetingResultProvider.isFrequencySatisfied(this.surveyId);
        }
        return isPeriodSatisfied() && isStopAfterSatisfied() && isThrottlingSatisfied();
    }

    private final boolean isPeriodSatisfied() {
        if (this.seenSurveysProvider.loadSeenSurveyIds().contains(this.surveyId) && !this.surveySettings.getRecurring()) {
            return false;
        }
        Long l = this.presentationTimesProvider.loadLastPresentationTimes().get(this.surveyId);
        if (l == null || this.surveySettings.getRecurringPeriodSeconds() == -1) {
            return true;
        }
        return DateUtils.INSTANCE.differenceBetweenDates(l.longValue(), this.timestampProvider.currentTimeMillis(), TimeUnit.SECONDS) >= this.surveySettings.getRecurringPeriodSeconds();
    }

    private final boolean isStopAfterSatisfied() {
        Long recurringStopAfterSeconds = this.surveySettings.getRecurringStopAfterSeconds();
        if (recurringStopAfterSeconds != null) {
            long jLongValue = recurringStopAfterSeconds.longValue();
            Long l = this.presentationTimesProvider.loadFirstPresentationTimes().get(this.surveyId);
            if (l != null) {
                return DateUtils.INSTANCE.differenceBetweenDates(l.longValue(), this.timestampProvider.currentTimeMillis(), TimeUnit.SECONDS) < jLongValue;
            }
        }
        return true;
    }

    private final boolean isThrottlingSatisfied() {
        Long l;
        Integer surveyThrottleDays = this.surveySettings.getSurveyThrottleDays();
        if (surveyThrottleDays != null) {
            int iIntValue = surveyThrottleDays.intValue();
            Iterator<T> it = this.presentationTimesProvider.loadLastPresentationTimes().entrySet().iterator();
            if (it.hasNext()) {
                Long lValueOf = Long.valueOf(((Number) ((Map.Entry) it.next()).getValue()).longValue());
                while (it.hasNext()) {
                    Long lValueOf2 = Long.valueOf(((Number) ((Map.Entry) it.next()).getValue()).longValue());
                    if (lValueOf.compareTo(lValueOf2) < 0) {
                        lValueOf = lValueOf2;
                    }
                }
                l = lValueOf;
            } else {
                l = null;
            }
            Long l2 = l;
            if (l2 != null) {
                return DateUtils.INSTANCE.differenceBetweenDates(l2.longValue(), this.timestampProvider.currentTimeMillis(), TimeUnit.DAYS) >= ((long) iIntValue);
            }
        }
        return true;
    }
}
