package com.survicate.surveys.entities.survey;

import com.survicate.surveys.entities.models.EventSuggestion;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetworkTargetingEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"toEventSuggestion", "Lcom/survicate/surveys/entities/models/EventSuggestion;", "Lcom/survicate/surveys/entities/survey/NetworkTargetingEvent;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NetworkTargetingEventKt {
    public static final EventSuggestion toEventSuggestion(NetworkTargetingEvent networkTargetingEvent) {
        Intrinsics.checkNotNullParameter(networkTargetingEvent, "<this>");
        String name = networkTargetingEvent.getName();
        List<String> properties = networkTargetingEvent.getProperties();
        if (properties == null) {
            properties = CollectionsKt.emptyList();
        }
        return new EventSuggestion(name, properties);
    }
}
