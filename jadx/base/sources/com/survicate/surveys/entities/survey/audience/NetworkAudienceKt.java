package com.survicate.surveys.entities.survey.audience;

import com.survicate.surveys.targeting.TargetingFiltersFactory;
import com.survicate.surveys.targeting.audience.Audience;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkAudience.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"toDomainModel", "Lcom/survicate/surveys/targeting/audience/Audience;", "Lcom/survicate/surveys/entities/survey/audience/NetworkAudience;", "targetingFiltersFactory", "Lcom/survicate/surveys/targeting/TargetingFiltersFactory;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkAudienceKt {
    public static final Audience toDomainModel(NetworkAudience networkAudience, TargetingFiltersFactory targetingFiltersFactory) {
        Intrinsics.checkNotNullParameter(networkAudience, "<this>");
        Intrinsics.checkNotNullParameter(targetingFiltersFactory, "targetingFiltersFactory");
        return new Audience(networkAudience.getId(), networkAudience.getRelation(), targetingFiltersFactory.createAudienceFilters(networkAudience), networkAudience.getVisitorType());
    }
}
