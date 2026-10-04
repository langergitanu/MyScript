package com.survicate.surveys.targeting;

import com.survicate.surveys.targeting.provider.DelayedEventProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: EventDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/targeting/EventDelayTargeting;", "Lcom/survicate/surveys/targeting/provider/DelayedEventProvider;", "onDelayElapsed", "Lkotlin/Function0;", "", "getOnDelayElapsed", "()Lkotlin/jvm/functions/Function0;", "setOnDelayElapsed", "(Lkotlin/jvm/functions/Function0;)V", "setupDelayTriggers", "triggers", "", "Lcom/survicate/surveys/targeting/EventDelayTrigger;", "scheduleDelayFor", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "removeOutdatedEvents", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface EventDelayTargeting extends DelayedEventProvider {
    void clear();

    Function0<Unit> getOnDelayElapsed();

    void removeOutdatedEvents();

    void scheduleDelayFor(ActiveEvent activeEvent);

    void setOnDelayElapsed(Function0<Unit> function0);

    void setupDelayTriggers(List<EventDelayTrigger> triggers);
}
