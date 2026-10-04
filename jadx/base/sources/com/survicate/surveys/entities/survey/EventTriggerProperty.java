package com.survicate.surveys.entities.survey;

import java.lang.annotation.Annotation;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.apache.commons.codec.language.p042bm.Languages;

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerProperty;", "", "name", "", "value", "propertyOperator", "Lcom/survicate/surveys/entities/survey/EventTriggerPropertyOperator;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/survicate/surveys/entities/survey/EventTriggerPropertyOperator;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/survicate/surveys/entities/survey/EventTriggerPropertyOperator;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getValue$annotations", "getValue", "getPropertyOperator$annotations", "getPropertyOperator", "()Lcom/survicate/surveys/entities/survey/EventTriggerPropertyOperator;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class EventTriggerProperty {
    private final String name;
    private final EventTriggerPropertyOperator propertyOperator;
    private final String value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.survicate.surveys.entities.survey.EventTriggerProperty$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EventTriggerProperty._childSerializers$_anonymous_();
        }
    })};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createAnnotatedEnumSerializer("com.survicate.surveys.entities.survey.EventTriggerPropertyOperator", EventTriggerPropertyOperator.values(), new String[]{"is_equal", "is_not_equal", "contains", "does_not_contain", "exists", "does_not_exist", Languages.ANY}, new Annotation[][]{null, null, null, null, null, null, null}, null);
    }

    public static /* synthetic */ EventTriggerProperty copy$default(EventTriggerProperty eventTriggerProperty, String str, String str2, EventTriggerPropertyOperator eventTriggerPropertyOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventTriggerProperty.name;
        }
        if ((i & 2) != 0) {
            str2 = eventTriggerProperty.value;
        }
        if ((i & 4) != 0) {
            eventTriggerPropertyOperator = eventTriggerProperty.propertyOperator;
        }
        return eventTriggerProperty.copy(str, str2, eventTriggerPropertyOperator);
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("operator")
    public static /* synthetic */ void getPropertyOperator$annotations() {
    }

    @SerialName("value")
    public static /* synthetic */ void getValue$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EventTriggerPropertyOperator getPropertyOperator() {
        return this.propertyOperator;
    }

    public final EventTriggerProperty copy(String name, String value, EventTriggerPropertyOperator propertyOperator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(propertyOperator, "propertyOperator");
        return new EventTriggerProperty(name, value, propertyOperator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerProperty)) {
            return false;
        }
        EventTriggerProperty eventTriggerProperty = (EventTriggerProperty) other;
        return Intrinsics.areEqual(this.name, eventTriggerProperty.name) && Intrinsics.areEqual(this.value, eventTriggerProperty.value) && this.propertyOperator == eventTriggerProperty.propertyOperator;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.propertyOperator.hashCode();
    }

    public String toString() {
        return "EventTriggerProperty(name=" + this.name + ", value=" + this.value + ", propertyOperator=" + this.propertyOperator + ')';
    }

    /* JADX INFO: compiled from: EventTrigger.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerProperty$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/EventTriggerProperty;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventTriggerProperty> serializer() {
            return EventTriggerProperty$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventTriggerProperty(int i, String str, String str2, EventTriggerPropertyOperator eventTriggerPropertyOperator, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, EventTriggerProperty$$serializer.INSTANCE.getDescriptor());
        }
        this.name = str;
        this.value = str2;
        this.propertyOperator = eventTriggerPropertyOperator;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(EventTriggerProperty self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.value);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.propertyOperator);
    }

    public EventTriggerProperty(String name, String value, EventTriggerPropertyOperator propertyOperator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(propertyOperator, "propertyOperator");
        this.name = name;
        this.value = value;
        this.propertyOperator = propertyOperator;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final EventTriggerPropertyOperator getPropertyOperator() {
        return this.propertyOperator;
    }
}
