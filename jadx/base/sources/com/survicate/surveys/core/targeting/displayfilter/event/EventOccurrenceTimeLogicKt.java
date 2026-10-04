package com.survicate.surveys.core.targeting.displayfilter.event;

import com.survicate.surveys.core.models.ActiveEvent;
import com.survicate.surveys.core.models.ActiveEventHistory;
import com.survicate.surveys.core.utils.StringDateRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventOccurrenceTimeLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\u001a(\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0000\u001a0\u0010\f\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¨\u0006\u000f"}, m1599d2 = {"isFirstOccurrenceTimeSatisfied", "", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;", "activeEvent", "Lcom/survicate/surveys/core/models/ActiveEvent;", "millisToDateString", "Lkotlin/Function1;", "", "", "isLastOccurrenceTimeSatisfied", "isDelaySatisfiedBy", "currentTimeMs", "isSatisfiedBy", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;", "referenceEventTimeMs", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventOccurrenceTimeLogicKt {

    /* JADX INFO: compiled from: EventOccurrenceTimeLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventTriggerOccurrenceTimeOperator.values().length];
            try {
                iArr[EventTriggerOccurrenceTimeOperator.IS_GREATER_THAN_OR_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventTriggerOccurrenceTimeOperator.IS_LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventTriggerOccurrenceTimeOperator.IS_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventTriggerOccurrenceTimeOperator.IS_NOT_BETWEEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isFirstOccurrenceTimeSatisfied(EventTriggerSettings eventTriggerSettings, ActiveEvent activeEvent, Function1<? super Long, String> millisToDateString) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Intrinsics.checkNotNullParameter(millisToDateString, "millisToDateString");
        EventTriggerOccurrenceTimeSettings firstOccurrence = eventTriggerSettings.getFirstOccurrence();
        if (firstOccurrence == null) {
            return true;
        }
        ActiveEventHistory history = activeEvent.getHistory();
        return isSatisfiedBy(firstOccurrence, activeEvent, history != null ? history.getFirstOccurrenceMs() : activeEvent.getInvokeTimeMs(), millisToDateString);
    }

    public static final boolean isLastOccurrenceTimeSatisfied(EventTriggerSettings eventTriggerSettings, ActiveEvent activeEvent, Function1<? super Long, String> millisToDateString) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Intrinsics.checkNotNullParameter(millisToDateString, "millisToDateString");
        EventTriggerOccurrenceTimeSettings lastOccurrence = eventTriggerSettings.getLastOccurrence();
        if (lastOccurrence == null) {
            return true;
        }
        ActiveEventHistory history = activeEvent.getHistory();
        return isSatisfiedBy(lastOccurrence, activeEvent, history != null ? history.getLastOccurrenceMs() : activeEvent.getInvokeTimeMs(), millisToDateString);
    }

    public static final boolean isDelaySatisfiedBy(EventTriggerSettings eventTriggerSettings, ActiveEvent activeEvent, long j) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Long delayMs = eventTriggerSettings.getDelayMs();
        return delayMs == null || delayMs.longValue() - (j - activeEvent.getInvokeTimeMs()) <= 0;
    }

    private static final boolean isSatisfiedBy(EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, ActiveEvent activeEvent, long j, Function1<? super Long, String> function1) {
        Long periodMs = eventTriggerOccurrenceTimeSettings.getPeriodMs();
        StringDateRange stringDateRangeFromIsoDates = StringDateRange.INSTANCE.fromIsoDates(eventTriggerOccurrenceTimeSettings.getDates());
        String strInvoke = function1.invoke(Long.valueOf(j));
        long invokeTimeMs = activeEvent.getInvokeTimeMs() - j;
        int i = WhenMappings.$EnumSwitchMapping$0[eventTriggerOccurrenceTimeSettings.getOperator().ordinal()];
        if (i == 1) {
            return periodMs != null && invokeTimeMs >= periodMs.longValue();
        }
        if (i == 2) {
            return periodMs != null && invokeTimeMs <= periodMs.longValue();
        }
        if (i != 3) {
            if (i == 4) {
                return (stringDateRangeFromIsoDates == null || stringDateRangeFromIsoDates.contains(strInvoke)) ? false : true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (stringDateRangeFromIsoDates != null) {
            return stringDateRangeFromIsoDates.contains(strInvoke);
        }
        return false;
    }
}
