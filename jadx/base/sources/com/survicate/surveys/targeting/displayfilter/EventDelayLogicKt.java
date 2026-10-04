package com.survicate.surveys.targeting.displayfilter;

import com.survicate.surveys.entities.survey.EventTriggerSettings;
import com.survicate.surveys.targeting.ActiveEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventDelayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1599d2 = {"isDelaySatisfiedBy", "", "Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "currentTimeMs", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventDelayLogicKt {
    public static final boolean isDelaySatisfiedBy(EventTriggerSettings eventTriggerSettings, ActiveEvent activeEvent, long j) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Long delay = eventTriggerSettings.getDelay();
        return delay == null || delay.longValue() - (j - activeEvent.getInvokeTimeMs()) <= 0;
    }
}
