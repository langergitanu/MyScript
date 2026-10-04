package com.survicate.surveys.entities.survey;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"com/survicate/surveys/entities/survey/EventTriggerSettings.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class EventTriggerSettings$$serializer implements GeneratedSerializer<EventTriggerSettings> {
    public static final EventTriggerSettings$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private EventTriggerSettings$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        EventTriggerSettings$$serializer eventTriggerSettings$$serializer = new EventTriggerSettings$$serializer();
        INSTANCE = eventTriggerSettings$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.survicate.surveys.entities.survey.EventTriggerSettings", eventTriggerSettings$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("delay", true);
        pluginGeneratedSerialDescriptor.addElement("occurrences", true);
        pluginGeneratedSerialDescriptor.addElement("first_occurrence", true);
        pluginGeneratedSerialDescriptor.addElement("last_occurrence", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(EventTriggerOccurrenceCountSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final EventTriggerSettings deserialize(Decoder decoder) {
        int i;
        Long l;
        EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings;
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings;
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        Long l2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            Long l3 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, null);
            EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings2 = (EventTriggerOccurrenceCountSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, EventTriggerOccurrenceCountSettings$$serializer.INSTANCE, null);
            EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings3 = (EventTriggerOccurrenceTimeSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE, null);
            l = l3;
            eventTriggerOccurrenceTimeSettings2 = (EventTriggerOccurrenceTimeSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE, null);
            eventTriggerOccurrenceTimeSettings = eventTriggerOccurrenceTimeSettings3;
            eventTriggerOccurrenceCountSettings = eventTriggerOccurrenceCountSettings2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings3 = null;
            EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings4 = null;
            EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings5 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    l2 = (Long) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    eventTriggerOccurrenceCountSettings3 = (EventTriggerOccurrenceCountSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, EventTriggerOccurrenceCountSettings$$serializer.INSTANCE, eventTriggerOccurrenceCountSettings3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    eventTriggerOccurrenceTimeSettings4 = (EventTriggerOccurrenceTimeSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE, eventTriggerOccurrenceTimeSettings4);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    eventTriggerOccurrenceTimeSettings5 = (EventTriggerOccurrenceTimeSettings) compositeDecoderBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE, eventTriggerOccurrenceTimeSettings5);
                    i2 |= 8;
                }
            }
            i = i2;
            l = l2;
            eventTriggerOccurrenceCountSettings = eventTriggerOccurrenceCountSettings3;
            eventTriggerOccurrenceTimeSettings = eventTriggerOccurrenceTimeSettings4;
            eventTriggerOccurrenceTimeSettings2 = eventTriggerOccurrenceTimeSettings5;
        }
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new EventTriggerSettings(i, l, eventTriggerOccurrenceCountSettings, eventTriggerOccurrenceTimeSettings, eventTriggerOccurrenceTimeSettings2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, EventTriggerSettings value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        EventTriggerSettings.write$Self$survicate_sdk_release(value, compositeEncoderBeginStructure, serialDescriptor);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
