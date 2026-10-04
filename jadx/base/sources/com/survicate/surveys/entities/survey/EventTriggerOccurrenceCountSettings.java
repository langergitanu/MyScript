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

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J#\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;", "", "value", "", "", "operator", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountOperator;", "<init>", "(Ljava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountOperator;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountOperator;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue$annotations", "()V", "getValue", "()Ljava/util/List;", "getOperator$annotations", "getOperator", "()Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountOperator;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class EventTriggerOccurrenceCountSettings {
    private final EventTriggerOccurrenceCountOperator operator;
    private final List<Long> value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTriggerOccurrenceCountSettings$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTriggerOccurrenceCountSettings._childSerializers$_anonymous_();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTriggerOccurrenceCountSettings$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTriggerOccurrenceCountSettings._childSerializers$_anonymous_$0();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(LongSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.EventTriggerOccurrenceCountOperator", EventTriggerOccurrenceCountOperator.values(), new String[]{"is_equal", "is_not_equal", "is_greater_than", "is_greater_than_or_equal", "is_less_than", "is_less_than_or_equal", "is_between", "is_not_between"}, new Annotation[][]{null, null, null, null, null, null, null, null}, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTriggerOccurrenceCountSettings copy$default(EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, List list, EventTriggerOccurrenceCountOperator eventTriggerOccurrenceCountOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            list = eventTriggerOccurrenceCountSettings.value;
        }
        if ((i & 2) != 0) {
            eventTriggerOccurrenceCountOperator = eventTriggerOccurrenceCountSettings.operator;
        }
        return eventTriggerOccurrenceCountSettings.copy(list, eventTriggerOccurrenceCountOperator);
    }

    @SerialName("operator")
    public static /* synthetic */ void getOperator$annotations() {
    }

    @SerialName("value")
    public static /* synthetic */ void getValue$annotations() {
    }

    public final List<Long> component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EventTriggerOccurrenceCountOperator getOperator() {
        return this.operator;
    }

    public final EventTriggerOccurrenceCountSettings copy(List<Long> value, EventTriggerOccurrenceCountOperator operator) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(operator, "operator");
        return new EventTriggerOccurrenceCountSettings(value, operator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerOccurrenceCountSettings)) {
            return false;
        }
        EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings = (EventTriggerOccurrenceCountSettings) other;
        return Intrinsics.areEqual(this.value, eventTriggerOccurrenceCountSettings.value) && this.operator == eventTriggerOccurrenceCountSettings.operator;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.operator.hashCode();
    }

    public String toString() {
        return "EventTriggerOccurrenceCountSettings(value=" + this.value + ", operator=" + this.operator + ')';
    }

    /* JADX INFO: compiled from: EventTrigger.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventTriggerOccurrenceCountSettings> serializer() {
            return EventTriggerOccurrenceCountSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventTriggerOccurrenceCountSettings(int i, List list, EventTriggerOccurrenceCountOperator eventTriggerOccurrenceCountOperator, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, EventTriggerOccurrenceCountSettings$$serializer.INSTANCE.getDescriptor());
        }
        this.value = list;
        this.operator = eventTriggerOccurrenceCountOperator;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(EventTriggerOccurrenceCountSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.value);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.operator);
    }

    public EventTriggerOccurrenceCountSettings(List<Long> value, EventTriggerOccurrenceCountOperator operator) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.value = value;
        this.operator = operator;
    }

    public final List<Long> getValue() {
        return this.value;
    }

    public final EventTriggerOccurrenceCountOperator getOperator() {
        return this.operator;
    }
}
