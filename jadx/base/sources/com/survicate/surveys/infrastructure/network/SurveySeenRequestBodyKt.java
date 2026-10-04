package com.survicate.surveys.infrastructure.network;

import com.survicate.surveys.entities.models.RespondentEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveySeenRequestBody.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"toRequestBody", "Lcom/survicate/surveys/infrastructure/network/SurveySeenRequestBody;", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveySeenRequestBodyKt {
    public static final SurveySeenRequestBody toRequestBody(RespondentEvent.SurveySeen surveySeen) {
        Intrinsics.checkNotNullParameter(surveySeen, "<this>");
        return new SurveySeenRequestBody(surveySeen);
    }
}
