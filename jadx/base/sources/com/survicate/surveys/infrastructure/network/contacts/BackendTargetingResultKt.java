package com.survicate.surveys.infrastructure.network.contacts;

import com.survicate.surveys.core.targeting.backend.CoreBackendTargetingAudienceResult;
import com.survicate.surveys.core.targeting.backend.CoreBackendTargetingSurveyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackendTargetingResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"toCoreResult", "Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingSurveyResult;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingSurveyResult;", "Lcom/survicate/surveys/core/targeting/backend/CoreBackendTargetingAudienceResult;", "Lcom/survicate/surveys/infrastructure/network/contacts/BackendTargetingAudienceResult;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BackendTargetingResultKt {
    public static final CoreBackendTargetingSurveyResult toCoreResult(BackendTargetingSurveyResult backendTargetingSurveyResult) {
        Intrinsics.checkNotNullParameter(backendTargetingSurveyResult, "<this>");
        return new CoreBackendTargetingSurveyResult(backendTargetingSurveyResult.getId(), backendTargetingSurveyResult.getCanShow(), backendTargetingSurveyResult.getCacheUntilMs());
    }

    public static final CoreBackendTargetingAudienceResult toCoreResult(BackendTargetingAudienceResult backendTargetingAudienceResult) {
        Intrinsics.checkNotNullParameter(backendTargetingAudienceResult, "<this>");
        return new CoreBackendTargetingAudienceResult(backendTargetingAudienceResult.getId(), backendTargetingAudienceResult.isSatisfied(), backendTargetingAudienceResult.getCacheUntilMs());
    }
}
