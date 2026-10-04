package com.survicate.surveys.core.targeting.displayfilter.event;

import com.survicate.surveys.core.models.ActiveEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventTriggerMatching.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\b"}, m1599d2 = {"isNameSatisfiedBy", "", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTrigger;", "activeEvent", "Lcom/survicate/surveys/core/models/ActiveEvent;", "arePropertiesSatisfiedBy", "isSatisfiedBy", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerProperty;", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventTriggerMatchingKt {

    /* JADX INFO: compiled from: EventTriggerMatching.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[EventTriggerRelation.values().length];
            try {
                iArr[EventTriggerRelation.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventTriggerRelation.f2267OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[EventTriggerPropertyOperator.values().length];
            try {
                iArr2[EventTriggerPropertyOperator.IS_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EventTriggerPropertyOperator.IS_NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EventTriggerPropertyOperator.CONTAINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EventTriggerPropertyOperator.DOES_NOT_CONTAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EventTriggerPropertyOperator.EXISTS.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EventTriggerPropertyOperator.DOES_NOT_EXIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EventTriggerPropertyOperator.ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final boolean isNameSatisfiedBy(EventTrigger eventTrigger, ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(eventTrigger, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        return Intrinsics.areEqual(eventTrigger.getName(), activeEvent.getName());
    }

    public static final boolean arePropertiesSatisfiedBy(EventTrigger eventTrigger, ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(eventTrigger, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        if (eventTrigger.getProperties().isEmpty()) {
            return true;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[eventTrigger.getRelation().ordinal()];
        if (i == 1) {
            List<EventTriggerProperty> properties = eventTrigger.getProperties();
            if ((properties instanceof Collection) && properties.isEmpty()) {
                return true;
            }
            Iterator<T> it = properties.iterator();
            while (it.hasNext()) {
                if (!isSatisfiedBy((EventTriggerProperty) it.next(), activeEvent)) {
                    return false;
                }
            }
            return true;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        List<EventTriggerProperty> properties2 = eventTrigger.getProperties();
        if ((properties2 instanceof Collection) && properties2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = properties2.iterator();
        while (it2.hasNext()) {
            if (isSatisfiedBy((EventTriggerProperty) it2.next(), activeEvent)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isSatisfiedBy(EventTriggerProperty eventTriggerProperty, ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(eventTriggerProperty, "<this>");
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        String str = activeEvent.getProperties().get(eventTriggerProperty.getName());
        if (str == null) {
            return eventTriggerProperty.getPropertyOperator() == EventTriggerPropertyOperator.DOES_NOT_EXIST;
        }
        switch (WhenMappings.$EnumSwitchMapping$1[eventTriggerProperty.getPropertyOperator().ordinal()]) {
            case 1:
                return Intrinsics.areEqual(str, eventTriggerProperty.getValue());
            case 2:
                return !Intrinsics.areEqual(str, eventTriggerProperty.getValue());
            case 3:
                return StringsKt.contains$default((CharSequence) str, (CharSequence) eventTriggerProperty.getValue(), false, 2, (Object) null);
            case 4:
                return !StringsKt.contains$default((CharSequence) str, (CharSequence) eventTriggerProperty.getValue(), false, 2, (Object) null);
            case 5:
                return !StringsKt.isBlank(str);
            case 6:
                return StringsKt.isBlank(str);
            case 7:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
