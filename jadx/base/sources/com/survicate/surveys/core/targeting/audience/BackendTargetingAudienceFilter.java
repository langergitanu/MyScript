package com.survicate.surveys.core.targeting.audience;

import com.survicate.surveys.core.targeting.backend.BackendTargetingResultProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackendTargetingAudienceFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/audience/BackendTargetingAudienceFilter;", "Lcom/survicate/surveys/core/targeting/audience/AudienceFilter;", "audienceId", "", "backendTargetingResultProvider", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;", "<init>", "(JLcom/survicate/surveys/core/targeting/backend/BackendTargetingResultProvider;)V", "isSatisfied", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BackendTargetingAudienceFilter implements AudienceFilter {
    private final long audienceId;
    private final BackendTargetingResultProvider backendTargetingResultProvider;

    public BackendTargetingAudienceFilter(long j, BackendTargetingResultProvider backendTargetingResultProvider) {
        Intrinsics.checkNotNullParameter(backendTargetingResultProvider, "backendTargetingResultProvider");
        this.audienceId = j;
        this.backendTargetingResultProvider = backendTargetingResultProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        return this.backendTargetingResultProvider.isAudienceSatisfied(this.audienceId);
    }
}
