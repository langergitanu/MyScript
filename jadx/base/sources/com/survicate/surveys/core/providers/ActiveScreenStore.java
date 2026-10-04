package com.survicate.surveys.core.providers;

import com.survicate.surveys.core.models.ActiveScreen;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActiveScreenStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/providers/ActiveScreenStore;", "Lcom/survicate/surveys/core/providers/ActiveScreenProvider;", "saveActiveScreens", "", "screens", "", "Lcom/survicate/surveys/core/models/ActiveScreen;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ActiveScreenStore extends ActiveScreenProvider {
    void saveActiveScreens(Set<ActiveScreen> screens);
}
