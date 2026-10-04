package com.survicate.surveys.targeting;

import com.survicate.surveys.entities.survey.EventTrigger;
import com.survicate.surveys.targeting.displayfilter.EventDisplayFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\bH\u0000¨\u0006\t"}, m1599d2 = {"isElapsed", "", "Lcom/survicate/surveys/targeting/DelayedEvent;", "currentTimeMs", "", "createEventDelayTriggers", "", "Lcom/survicate/surveys/targeting/EventDelayTrigger;", "Lcom/survicate/surveys/targeting/displayfilter/EventDisplayFilter;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventDelayTargetingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isElapsed(DelayedEvent delayedEvent, long j) {
        return delayedEvent.getExpectedDelayMs() - (j - delayedEvent.getActiveEvent().getInvokeTimeMs()) <= 0;
    }

    public static final List<EventDelayTrigger> createEventDelayTriggers(EventDisplayFilter eventDisplayFilter) {
        Intrinsics.checkNotNullParameter(eventDisplayFilter, "<this>");
        List<EventTrigger> eventTriggers = eventDisplayFilter.getEventTriggers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : eventTriggers) {
            if (((EventTrigger) obj).getSettings().getDelay() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<EventTrigger> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (EventTrigger eventTrigger : arrayList2) {
            String name = eventTrigger.getName();
            String surveyId = eventDisplayFilter.getSurveyId();
            Long delay = eventTrigger.getSettings().getDelay();
            Intrinsics.checkNotNull(delay);
            arrayList3.add(new EventDelayTrigger(name, surveyId, delay.longValue()));
        }
        return arrayList3;
    }
}
