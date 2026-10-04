package com.survicate.surveys.core.providers;

import com.survicate.surveys.core.targeting.SurveyChanceResult;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyChanceStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/providers/SurveyChanceStore;", "", "saveChanceResult", "", "surveyId", "", "result", "Lcom/survicate/surveys/core/targeting/SurveyChanceResult;", "findChanceResult", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyChanceStore {
    SurveyChanceResult findChanceResult(String surveyId);

    void saveChanceResult(String surveyId, SurveyChanceResult result);
}
