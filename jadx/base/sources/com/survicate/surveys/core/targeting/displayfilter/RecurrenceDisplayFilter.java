package com.survicate.surveys.core.targeting.displayfilter;

import com.survicate.surveys.core.providers.PresentationTimesProvider;
import com.survicate.surveys.core.providers.SeenSurveysProvider;
import com.survicate.surveys.core.providers.TimestampProvider;
import com.survicate.surveys.core.targeting.backend.BackendTargetingResultProvider;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecurrenceDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u001c\u0010\u0019\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/RecurrenceDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "surveyId", "", "recurrenceSettings", "Lcom/survicate/surveys/core/targeting/displayfilter/RecurrenceDisplayFilterSettings;", "isContactMode", "", "isBackendTargetingEnabled", "backendTargetingResultProvider", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;", "seenSurveysProvider", "Lcom/survicate/surveys/core/providers/SeenSurveysProvider;", "presentationTimesProvider", "Lcom/survicate/surveys/core/providers/PresentationTimesProvider;", "timestampProvider", "Lcom/survicate/surveys/core/providers/TimestampProvider;", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/displayfilter/RecurrenceDisplayFilterSettings;ZZLcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;Lcom/survicate/surveys/core/providers/SeenSurveysProvider;Lcom/survicate/surveys/core/providers/PresentationTimesProvider;Lcom/survicate/surveys/core/providers/TimestampProvider;)V", "isSatisfied", "isPeriodSatisfied", "lastPresentationTimes", "", "", "isStopAfterSatisfied", "isThrottlingSatisfied", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class RecurrenceDisplayFilter implements DisplayFilter {
    private final BackendTargetingResultProvider backendTargetingResultProvider;
    private final boolean isBackendTargetingEnabled;
    private final boolean isContactMode;
    private final PresentationTimesProvider presentationTimesProvider;
    private final RecurrenceDisplayFilterSettings recurrenceSettings;
    private final SeenSurveysProvider seenSurveysProvider;
    private final String surveyId;
    private final TimestampProvider timestampProvider;

    public RecurrenceDisplayFilter(String surveyId, RecurrenceDisplayFilterSettings recurrenceSettings, boolean z, boolean z2, BackendTargetingResultProvider backendTargetingResultProvider, SeenSurveysProvider seenSurveysProvider, PresentationTimesProvider presentationTimesProvider, TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(recurrenceSettings, "recurrenceSettings");
        Intrinsics.checkNotNullParameter(backendTargetingResultProvider, "backendTargetingResultProvider");
        Intrinsics.checkNotNullParameter(seenSurveysProvider, "seenSurveysProvider");
        Intrinsics.checkNotNullParameter(presentationTimesProvider, "presentationTimesProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        this.surveyId = surveyId;
        this.recurrenceSettings = recurrenceSettings;
        this.isContactMode = z;
        this.isBackendTargetingEnabled = z2;
        this.backendTargetingResultProvider = backendTargetingResultProvider;
        this.seenSurveysProvider = seenSurveysProvider;
        this.presentationTimesProvider = presentationTimesProvider;
        this.timestampProvider = timestampProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        if (this.isContactMode && this.isBackendTargetingEnabled) {
            return this.backendTargetingResultProvider.isFrequencySatisfied(this.surveyId);
        }
        Map<String, Long> mapLoadLastPresentationTimes = this.presentationTimesProvider.loadLastPresentationTimes();
        return isPeriodSatisfied(mapLoadLastPresentationTimes) && isStopAfterSatisfied() && isThrottlingSatisfied(mapLoadLastPresentationTimes);
    }

    private final boolean isPeriodSatisfied(Map<String, Long> lastPresentationTimes) {
        if (this.seenSurveysProvider.wasSurveySeen(this.surveyId) && !this.recurrenceSettings.getRecurring()) {
            return false;
        }
        Long l = lastPresentationTimes.get(this.surveyId);
        return l == null || this.recurrenceSettings.getRecurringPeriodSeconds() == -1 || (this.timestampProvider.currentTimeMillis() - l.longValue()) / 1000 >= this.recurrenceSettings.getRecurringPeriodSeconds();
    }

    private final boolean isStopAfterSatisfied() {
        Long recurringStopAfterSeconds = this.recurrenceSettings.getRecurringStopAfterSeconds();
        if (recurringStopAfterSeconds != null) {
            long jLongValue = recurringStopAfterSeconds.longValue();
            Long l = this.presentationTimesProvider.loadFirstPresentationTimes().get(this.surveyId);
            if (l != null) {
                return (this.timestampProvider.currentTimeMillis() - l.longValue()) / 1000 < jLongValue;
            }
        }
        return true;
    }

    private final boolean isThrottlingSatisfied(Map<String, Long> lastPresentationTimes) {
        Long l;
        Integer surveyThrottleDays = this.recurrenceSettings.getSurveyThrottleDays();
        if (surveyThrottleDays != null) {
            int iIntValue = surveyThrottleDays.intValue();
            Iterator<T> it = lastPresentationTimes.entrySet().iterator();
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
                return (this.timestampProvider.currentTimeMillis() - l2.longValue()) / 86400000 >= ((long) iIntValue);
            }
        }
        return true;
    }
}
