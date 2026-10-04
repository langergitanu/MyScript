package com.survicate.surveys.entities.models;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventSuggestion.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, m1599d2 = {"withMergedPropertiesFrom", "Lcom/survicate/surveys/entities/models/EventSuggestion;", "other", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventSuggestionKt {
    public static final EventSuggestion withMergedPropertiesFrom(EventSuggestion eventSuggestion, EventSuggestion other) {
        Intrinsics.checkNotNullParameter(eventSuggestion, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return EventSuggestion.copy$default(eventSuggestion, null, CollectionsKt.distinct(CollectionsKt.plus((Collection) eventSuggestion.getProperties(), (Iterable) other.getProperties())), 1, null);
    }
}
