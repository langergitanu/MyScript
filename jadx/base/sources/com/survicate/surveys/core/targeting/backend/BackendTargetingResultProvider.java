package com.survicate.surveys.core.targeting.backend;

import kotlin.Metadata;

/* JADX INFO: compiled from: BackendTargetingResultProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;", "", "isFrequencySatisfied", "", "surveyId", "", "isAudienceSatisfied", "audienceId", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface BackendTargetingResultProvider {
    boolean isAudienceSatisfied(long audienceId);

    boolean isFrequencySatisfied(String surveyId);
}
