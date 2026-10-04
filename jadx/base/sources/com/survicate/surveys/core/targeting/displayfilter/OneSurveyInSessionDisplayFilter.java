package com.survicate.surveys.core.targeting.displayfilter;

import com.survicate.surveys.core.providers.PresentationStateProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OneSurveyInSessionDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/OneSurveyInSessionDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "isEnabled", "", "presentationStateProvider", "Lcom/survicate/surveys/core/providers/PresentationStateProvider;", "<init>", "(ZLcom/survicate/surveys/core/providers/PresentationStateProvider;)V", "isSatisfied", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class OneSurveyInSessionDisplayFilter implements DisplayFilter {
    private final boolean isEnabled;
    private final PresentationStateProvider presentationStateProvider;

    public OneSurveyInSessionDisplayFilter(boolean z, PresentationStateProvider presentationStateProvider) {
        Intrinsics.checkNotNullParameter(presentationStateProvider, "presentationStateProvider");
        this.isEnabled = z;
        this.presentationStateProvider = presentationStateProvider;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        return (this.isEnabled && this.presentationStateProvider.wasAnySurveyPresentedInSession()) ? false : true;
    }
}
