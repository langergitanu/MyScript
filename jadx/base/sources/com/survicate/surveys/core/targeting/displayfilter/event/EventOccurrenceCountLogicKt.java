package com.survicate.surveys.core.targeting.displayfilter.event;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventOccurrenceCountLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1599d2 = {"isOccurrenceCountSatisfied", "", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;", "totalOccurrences", "", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventOccurrenceCountLogicKt {

    /* JADX INFO: compiled from: EventOccurrenceCountLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventTriggerOccurrenceCountOperator.values().length];
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_GREATER_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_GREATER_THAN_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_LESS_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_LESS_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_BETWEEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EventTriggerOccurrenceCountOperator.IS_NOT_BETWEEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isOccurrenceCountSatisfied(EventTriggerSettings eventTriggerSettings, long j) {
        Intrinsics.checkNotNullParameter(eventTriggerSettings, "<this>");
        EventTriggerOccurrenceCountSettings occurrences = eventTriggerSettings.getOccurrences();
        if (occurrences == null) {
            return true;
        }
        Long l = (Long) CollectionsKt.getOrNull(occurrences.getValue(), 0);
        if (l != null) {
            long jLongValue = l.longValue();
            Long l2 = (Long) CollectionsKt.getOrNull(occurrences.getValue(), 1);
            switch (WhenMappings.$EnumSwitchMapping$0[occurrences.getOperator().ordinal()]) {
                case 1:
                    if (j == jLongValue) {
                        return true;
                    }
                    break;
                case 2:
                    return j != jLongValue;
                case 3:
                    return j > jLongValue;
                case 4:
                    return j >= jLongValue;
                case 5:
                    return j < jLongValue;
                case 6:
                    return j <= jLongValue;
                case 7:
                    return l2 != null && jLongValue <= j && j <= l2.longValue();
                case 8:
                    return l2 != null && (jLongValue > j || j > l2.longValue());
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return false;
    }
}
