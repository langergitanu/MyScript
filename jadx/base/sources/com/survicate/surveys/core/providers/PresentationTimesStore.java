package com.survicate.surveys.core.providers;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: PresentationTimesStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001c\u0010\b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/providers/PresentationTimesStore;", "Lcom/survicate/surveys/core/providers/PresentationTimesProvider;", "saveLastPresentationTimes", "", "presentationTimes", "", "", "", "saveFirstPresentationTimes", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface PresentationTimesStore extends PresentationTimesProvider {
    void saveFirstPresentationTimes(Map<String, Long> presentationTimes);

    void saveLastPresentationTimes(Map<String, Long> presentationTimes);
}
