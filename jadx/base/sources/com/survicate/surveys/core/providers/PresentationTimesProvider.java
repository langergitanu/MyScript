package com.survicate.surveys.core.providers;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: PresentationTimesProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/providers/PresentationTimesProvider;", "", "loadLastPresentationTimes", "", "", "", "loadFirstPresentationTimes", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface PresentationTimesProvider {
    Map<String, Long> loadFirstPresentationTimes();

    Map<String, Long> loadLastPresentationTimes();
}
