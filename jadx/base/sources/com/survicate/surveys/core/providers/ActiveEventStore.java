package com.survicate.surveys.core.providers;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.core.models.ActiveEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActiveEventStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/providers/ActiveEventStore;", "Lcom/survicate/surveys/core/providers/ActiveEventProvider;", "saveActiveEvent", "", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/core/models/ActiveEvent;", "savePostponedEvent", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ActiveEventStore extends ActiveEventProvider {
    void saveActiveEvent(ActiveEvent event);

    void savePostponedEvent(ActiveEvent event);
}
