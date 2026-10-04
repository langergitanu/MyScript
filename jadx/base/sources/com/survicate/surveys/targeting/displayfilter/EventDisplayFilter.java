package com.survicate.surveys.targeting.displayfilter;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.core.targeting.displayfilter.DisplayFilter;
import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.survey.EventTrigger;
import com.survicate.surveys.targeting.ActiveEvent;
import com.survicate.surveys.targeting.provider.ActiveEventProvider;
import com.survicate.surveys.targeting.provider.DelayedEventProvider;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventDisplayFilter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005H\u0002J\u0014\u0010\u0017\u001a\u00020\u0014*\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0014\u0010\u0019\u001a\u00020\u0014*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/targeting/displayfilter/EventDisplayFilter;", "Lcom/survicate/surveys/core/targeting/displayfilter/DisplayFilter;", "surveyId", "", "eventTriggers", "", "Lcom/survicate/surveys/entities/survey/EventTrigger;", "activeEventProvider", "Lcom/survicate/surveys/targeting/provider/ActiveEventProvider;", "delayedEventProvider", "Lcom/survicate/surveys/targeting/provider/DelayedEventProvider;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/survicate/surveys/targeting/provider/ActiveEventProvider;Lcom/survicate/surveys/targeting/provider/DelayedEventProvider;Lcom/survicate/surveys/utils/TimestampProvider;)V", "getSurveyId", "()Ljava/lang/String;", "getEventTriggers", "()Ljava/util/List;", "isSatisfied", "", "getEventsToValidate", "Lcom/survicate/surveys/targeting/ActiveEvent;", "isSatisfiedBy", NotificationCompat.CATEGORY_EVENT, "areSettingsSatisfiedBy", "activeEvent", "getTotalOccurrences", "", "canScheduleDelayFor", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventDisplayFilter implements DisplayFilter {
    private final ActiveEventProvider activeEventProvider;
    private final DelayedEventProvider delayedEventProvider;
    private final List<EventTrigger> eventTriggers;
    private final String surveyId;
    private final TimestampProvider timestampProvider;

    public EventDisplayFilter(String surveyId, List<EventTrigger> eventTriggers, ActiveEventProvider activeEventProvider, DelayedEventProvider delayedEventProvider, TimestampProvider timestampProvider) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(eventTriggers, "eventTriggers");
        Intrinsics.checkNotNullParameter(activeEventProvider, "activeEventProvider");
        Intrinsics.checkNotNullParameter(delayedEventProvider, "delayedEventProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        this.surveyId = surveyId;
        this.eventTriggers = eventTriggers;
        this.activeEventProvider = activeEventProvider;
        this.delayedEventProvider = delayedEventProvider;
        this.timestampProvider = timestampProvider;
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
        ActiveEvent activeEventProvideActiveEvent = this.activeEventProvider.provideActiveEvent();
        ActiveEvent activeEventProvidePostponedEvent = this.activeEventProvider.providePostponedEvent();
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.listOfNotNull(activeEventProvideActiveEvent), (Iterable) CollectionsKt.listOfNotNull(activeEventProvidePostponedEvent)), (Iterable) this.delayedEventProvider.provideDelayedEventsForSurvey(this.surveyId));
    }

    private final boolean isSatisfiedBy(EventTrigger eventTrigger, ActiveEvent activeEvent) {
        return EventTriggerExtensionsKt.isNameSatisfiedBy(eventTrigger, activeEvent) && EventTriggerExtensionsKt.arePropertiesSatisfiedBy(eventTrigger, activeEvent) && areSettingsSatisfiedBy(eventTrigger, activeEvent);
    }

    private final boolean areSettingsSatisfiedBy(EventTrigger eventTrigger, ActiveEvent activeEvent) {
        return EventOccurrenceCountLogicKt.isOccurrenceCountSatisfied(eventTrigger.getSettings(), getTotalOccurrences(activeEvent)) && EventOccurrenceTimeLogicKt.isFirstOccurrenceTimeSatisfied(eventTrigger.getSettings(), activeEvent) && EventOccurrenceTimeLogicKt.isLastOccurrenceTimeSatisfied(eventTrigger.getSettings(), activeEvent) && EventDelayLogicKt.isDelaySatisfiedBy(eventTrigger.getSettings(), activeEvent, this.timestampProvider.currentTimeMillis());
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
            if (eventTrigger.getSettings().getDelay() != null && EventTriggerExtensionsKt.isNameSatisfiedBy(eventTrigger, activeEvent) && EventTriggerExtensionsKt.arePropertiesSatisfiedBy(eventTrigger, activeEvent)) {
                return true;
            }
        }
        return false;
    }
}
