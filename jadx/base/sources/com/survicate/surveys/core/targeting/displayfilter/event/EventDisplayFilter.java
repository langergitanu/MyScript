package com.survicate.surveys.core.targeting.displayfilter.event;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.core.models.ActiveEvent;
import com.survicate.surveys.core.models.ActiveEventHistory;
import com.survicate.surveys.core.providers.ActiveEventProvider;
import com.survicate.surveys.core.providers.DelayedEventProvider;
import com.survicate.surveys.core.providers.TimestampProvider;
import com.survicate.surveys.core.targeting.displayfilter.DisplayFilter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H\u0002J\u0014\u0010\u001a\u001a\u00020\u0017*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0014\u0010\u001c\u001a\u00020\u0017*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "surveyId", "", "eventTriggers", "", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTrigger;", "activeEventProvider", "Lcom/survicate/surveys/core/providers/ActiveEventProvider;", "delayedEventProvider", "Lcom/survicate/surveys/core/providers/DelayedEventProvider;", "timestampProvider", "Lcom/survicate/surveys/core/providers/TimestampProvider;", "millisToDateString", "Lkotlin/Function1;", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/survicate/surveys/core/providers/ActiveEventProvider;Lcom/survicate/surveys/core/providers/DelayedEventProvider;Lcom/survicate/surveys/core/providers/TimestampProvider;Lkotlin/jvm/functions/Function1;)V", "getSurveyId", "()Ljava/lang/String;", "getEventTriggers", "()Ljava/util/List;", "isSatisfied", "", "getEventsToValidate", "Lcom/survicate/surveys/core/models/ActiveEvent;", "isSatisfiedBy", NotificationCompat.CATEGORY_EVENT, "areSettingsSatisfiedBy", "activeEvent", "getTotalOccurrences", "canScheduleDelayFor", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventDisplayFilter implements DisplayFilter {
    private final ActiveEventProvider activeEventProvider;
    private final DelayedEventProvider delayedEventProvider;
    private final List<EventTrigger> eventTriggers;
    private final Function1<Long, String> millisToDateString;
    private final String surveyId;
    private final TimestampProvider timestampProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public EventDisplayFilter(String surveyId, List<EventTrigger> eventTriggers, ActiveEventProvider activeEventProvider, DelayedEventProvider delayedEventProvider, TimestampProvider timestampProvider, Function1<? super Long, String> millisToDateString) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(eventTriggers, "eventTriggers");
        Intrinsics.checkNotNullParameter(activeEventProvider, "activeEventProvider");
        Intrinsics.checkNotNullParameter(delayedEventProvider, "delayedEventProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(millisToDateString, "millisToDateString");
        this.surveyId = surveyId;
        this.eventTriggers = eventTriggers;
        this.activeEventProvider = activeEventProvider;
        this.delayedEventProvider = delayedEventProvider;
        this.timestampProvider = timestampProvider;
        this.millisToDateString = millisToDateString;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }

    public final List<EventTrigger> getEventTriggers() {
        return this.eventTriggers;
    }

    @Override // com.survicate.surveys.core.targeting.TargetingFilter
    public boolean isSatisfied() {
        if (this.eventTriggers.isEmpty()) {
            return true;
        }
        List<ActiveEvent> eventsToValidate = getEventsToValidate();
        if ((eventsToValidate instanceof Collection) && eventsToValidate.isEmpty()) {
            return false;
        }
        for (ActiveEvent activeEvent : eventsToValidate) {
            List<EventTrigger> list = this.eventTriggers;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (isSatisfiedBy((EventTrigger) it.next(), activeEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final List<ActiveEvent> getEventsToValidate() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOfNotNull((Object[]) new ActiveEvent[]{this.activeEventProvider.provideActiveEvent(), this.activeEventProvider.providePostponedEvent()}), (Iterable) this.delayedEventProvider.provideDelayedEventsForSurvey(this.surveyId));
    }

    private final boolean isSatisfiedBy(EventTrigger eventTrigger, ActiveEvent activeEvent) {
        return EventTriggerMatchingKt.isNameSatisfiedBy(eventTrigger, activeEvent) && EventTriggerMatchingKt.arePropertiesSatisfiedBy(eventTrigger, activeEvent) && areSettingsSatisfiedBy(eventTrigger, activeEvent);
    }

    private final boolean areSettingsSatisfiedBy(EventTrigger eventTrigger, ActiveEvent activeEvent) {
        return EventOccurrenceCountLogicKt.isOccurrenceCountSatisfied(eventTrigger.getSettings(), getTotalOccurrences(activeEvent)) && EventOccurrenceTimeLogicKt.isFirstOccurrenceTimeSatisfied(eventTrigger.getSettings(), activeEvent, this.millisToDateString) && EventOccurrenceTimeLogicKt.isLastOccurrenceTimeSatisfied(eventTrigger.getSettings(), activeEvent, this.millisToDateString) && EventOccurrenceTimeLogicKt.isDelaySatisfiedBy(eventTrigger.getSettings(), activeEvent, this.timestampProvider.currentTimeMillis());
    }

    private final long getTotalOccurrences(ActiveEvent activeEvent) {
        ActiveEventHistory history = activeEvent.getHistory();
        return (history != null ? history.getOccurrenceCount() : 0L) + 1;
    }

    public final boolean canScheduleDelayFor(ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        List<EventTrigger> list = this.eventTriggers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (EventTrigger eventTrigger : list) {
            if (eventTrigger.getSettings().getDelayMs() != null && EventTriggerMatchingKt.isNameSatisfiedBy(eventTrigger, activeEvent) && EventTriggerMatchingKt.arePropertiesSatisfiedBy(eventTrigger, activeEvent)) {
                return true;
            }
        }
        return false;
    }
}
