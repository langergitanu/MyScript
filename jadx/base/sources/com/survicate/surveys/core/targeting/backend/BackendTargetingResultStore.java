package com.survicate.surveys.core.targeting.backend;

import com.survicate.surveys.core.targeting.TargetingMode;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: BackendTargetingResultStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tH&J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tH&J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00140\tH&J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\u0010H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;", "targetingMode", "Lcom/survicate/surveys/core/targeting/TargetingMode;", "getTargetingMode", "()Lcom/survicate/surveys/core/targeting/TargetingMode;", "setTargetingMode", "(Lcom/survicate/surveys/core/targeting/TargetingMode;)V", "getSurveysToRefresh", "", "", "surveyIds", "getAudiencesToRefresh", "", "audienceIds", "updateSurveyResults", "", "results", "Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingSurveyResult;", "updateAudienceResults", "Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingAudienceResult;", "markSurveyAsDisplayed", "surveyId", "clear", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface BackendTargetingResultStore extends BackendTargetingResultProvider {
    void clear();

    List<Long> getAudiencesToRefresh(List<Long> audienceIds);

    List<String> getSurveysToRefresh(List<String> surveyIds);

    TargetingMode getTargetingMode();

    void markSurveyAsDisplayed(String surveyId);

    void setTargetingMode(TargetingMode targetingMode);

    void updateAudienceResults(List<CoreBackendTargetingAudienceResult> results);

    void updateSurveyResults(List<CoreBackendTargetingSurveyResult> results);
}
