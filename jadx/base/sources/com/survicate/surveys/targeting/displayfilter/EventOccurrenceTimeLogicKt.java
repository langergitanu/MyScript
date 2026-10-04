package com.survicate.surveys.targeting.displayfilter;

import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.survey.EventTriggerOccurrenceTimeOperator;
import com.survicate.surveys.entities.survey.EventTriggerOccurrenceTimeSettings;
import com.survicate.surveys.entities.survey.EventTriggerSettings;
import com.survicate.surveys.targeting.ActiveEvent;
import com.survicate.surveys.utils.DateUtilsKt;
import com.survicate.surveys.utils.StringDateRange;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventOccurrenceTimeLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, m1599d2 = {"isFirstOccurrenceTimeSatisfied", "", "Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "isLastOccurrenceTimeSatisfied", "isSatisfiedBy", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;", "referenceEventTimeMs", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
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

    public static final boolean isFirstOccurrenceTimeSatisfied(EventTriggerSettings eventTriggerSettings, ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        if (eventTriggerSettings.getFirstOccurrence() == null) {
            return true;
        }
        ActiveEventHistory history = activeEvent.getHistory();
        return isSatisfiedBy(eventTriggerSettings.getFirstOccurrence(), activeEvent, history != null ? history.getFirstOccurrenceMs() : activeEvent.getInvokeTimeMs());
    }

    public static final boolean isLastOccurrenceTimeSatisfied(EventTriggerSettings eventTriggerSettings, ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        if (eventTriggerSettings.getLastOccurrence() == null) {
            return true;
        }
        ActiveEventHistory history = activeEvent.getHistory();
        return isSatisfiedBy(eventTriggerSettings.getLastOccurrence(), activeEvent, history != null ? history.getLastOccurrenceMs() : activeEvent.getInvokeTimeMs());
    }

    private static final boolean isSatisfiedBy(EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, ActiveEvent activeEvent, long j) {
        Boolean boolValueOf;
        Long periodMs = eventTriggerOccurrenceTimeSettings.getPeriodMs();
        StringDateRange stringDateRangeFromIsoDates = StringDateRange.INSTANCE.fromIsoDates(eventTriggerOccurrenceTimeSettings.getDates());
        String dateOnlyPart = DateUtilsKt.getDateOnlyPart(DateUtilsKt.toIsoString$default(new Date(j), null, 1, null));
        long invokeTimeMs = activeEvent.getInvokeTimeMs() - j;
        int i = WhenMappings.$EnumSwitchMapping$0[eventTriggerOccurrenceTimeSettings.getOperator().ordinal()];
        if (i == 1) {
            return periodMs != null && invokeTimeMs >= periodMs.longValue();
        }
        if (i == 2) {
            return periodMs != null && invokeTimeMs <= periodMs.longValue();
        }
        if (i == 3) {
            if (dateOnlyPart != null) {
                boolValueOf = stringDateRangeFromIsoDates != null ? Boolean.valueOf(stringDateRangeFromIsoDates.contains(dateOnlyPart)) : null;
                if (boolValueOf != null) {
                    return boolValueOf.booleanValue();
                }
            }
            return false;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (dateOnlyPart != null) {
            boolValueOf = stringDateRangeFromIsoDates != null ? Boolean.valueOf(!stringDateRangeFromIsoDates.contains(dateOnlyPart)) : null;
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        return false;
    }
}
