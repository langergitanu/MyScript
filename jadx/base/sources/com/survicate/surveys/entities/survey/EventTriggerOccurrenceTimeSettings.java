package com.survicate.surveys.entities.survey;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J4\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020\u0006HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;", "", "periodMs", "", "dates", "", "", "operator", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeOperator;", "<init>", "(Ljava/lang/Long;Ljava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeOperator;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeOperator;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPeriodMs$annotations", "()V", "getPeriodMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDates$annotations", "getDates", "()Ljava/util/List;", "getOperator$annotations", "getOperator", "()Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeOperator;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeOperator;)Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class EventTriggerOccurrenceTimeSettings {
    private final List<String> dates;
    private final EventTriggerOccurrenceTimeOperator operator;
    private final Long periodMs;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTriggerOccurrenceTimeSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTriggerOccurrenceTimeSettings._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTriggerOccurrenceTimeSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTriggerOccurrenceTimeSettings._childSerializers$_anonymous_$0();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.EventTriggerOccurrenceTimeOperator", EventTriggerOccurrenceTimeOperator.values(), new String[]{"is_greater_than_or_equal", "is_less_than_or_equal", "is_between", "is_not_between"}, new Annotation[][]{null, null, null, null}, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTriggerOccurrenceTimeSettings copy$default(EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, Long l, List list, EventTriggerOccurrenceTimeOperator eventTriggerOccurrenceTimeOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            l = eventTriggerOccurrenceTimeSettings.periodMs;
        }
        if ((i & 2) != 0) {
            list = eventTriggerOccurrenceTimeSettings.dates;
        }
        if ((i & 4) != 0) {
            eventTriggerOccurrenceTimeOperator = eventTriggerOccurrenceTimeSettings.operator;
        }
        return eventTriggerOccurrenceTimeSettings.copy(l, list, eventTriggerOccurrenceTimeOperator);
    }

    @SerialName("dates")
    public static /* synthetic */ void getDates$annotations() {
    }

    @SerialName("operator")
    public static /* synthetic */ void getOperator$annotations() {
    }

    @SerialName("period")
    public static /* synthetic */ void getPeriodMs$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getPeriodMs() {
        return this.periodMs;
    }

    public final List<String> component2() {
        return this.dates;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EventTriggerOccurrenceTimeOperator getOperator() {
        return this.operator;
    }

    public final EventTriggerOccurrenceTimeSettings copy(Long periodMs, List<String> dates, EventTriggerOccurrenceTimeOperator operator) {
        Intrinsics.checkNotNullParameter(dates, "dates");
        Intrinsics.checkNotNullParameter(operator, "operator");
        return new EventTriggerOccurrenceTimeSettings(periodMs, dates, operator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerOccurrenceTimeSettings)) {
            return false;
        }
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings = (EventTriggerOccurrenceTimeSettings) other;
        return Intrinsics.areEqual(this.periodMs, eventTriggerOccurrenceTimeSettings.periodMs) && Intrinsics.areEqual(this.dates, eventTriggerOccurrenceTimeSettings.dates) && this.operator == eventTriggerOccurrenceTimeSettings.operator;
    }

    public int hashCode() {
        Long l = this.periodMs;
        return ((((l == null ? 0 : l.hashCode()) * 31) + this.dates.hashCode()) * 31) + this.operator.hashCode();
    }

    public String toString() {
        return "EventTriggerOccurrenceTimeSettings(periodMs=" + this.periodMs + ", dates=" + this.dates + ", operator=" + this.operator + ')';
    }

    /* JADX INFO: compiled from: EventTrigger.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventTriggerOccurrenceTimeSettings> serializer() {
            return EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventTriggerOccurrenceTimeSettings(int i, Long l, List list, EventTriggerOccurrenceTimeOperator eventTriggerOccurrenceTimeOperator, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.periodMs = l;
        this.dates = list;
        this.operator = eventTriggerOccurrenceTimeOperator;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(EventTriggerOccurrenceTimeSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.periodMs);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.dates);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.operator);
    }

    public EventTriggerOccurrenceTimeSettings(Long l, List<String> dates, EventTriggerOccurrenceTimeOperator operator) {
        Intrinsics.checkNotNullParameter(dates, "dates");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.periodMs = l;
        this.dates = dates;
        this.operator = operator;
    }

    public final Long getPeriodMs() {
        return this.periodMs;
    }

    public final List<String> getDates() {
        return this.dates;
    }

    public final EventTriggerOccurrenceTimeOperator getOperator() {
        return this.operator;
    }
}
