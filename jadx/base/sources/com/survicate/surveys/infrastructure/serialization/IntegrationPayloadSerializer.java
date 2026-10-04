package com.survicate.surveys.infrastructure.serialization;

import com.survicate.surveys.IntegrationPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: IntegrationPayloadSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/IntegrationPayloadSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/IntegrationPayload;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class IntegrationPayloadSerializer implements KSerializer<IntegrationPayload> {
    public static final IntegrationPayloadSerializer INSTANCE = new IntegrationPayloadSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.SerialDescriptor("com.survicate.surveys.IntegrationPayload", JsonElement.INSTANCE.serializer().getDescriptor());

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private IntegrationPayloadSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, IntegrationPayload value) {
        JsonPrimitive JsonPrimitive;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!(encoder instanceof JsonEncoder)) {
            throw new IllegalArgumentException("IntegrationPayloadSerializer only works with JSON".toString());
        }
        Object value2 = value.getValue();
        if (value2 instanceof String) {
            JsonPrimitive = JsonElementKt.JsonPrimitive((String) value2);
        } else if (value2 instanceof Boolean) {
            JsonPrimitive = JsonElementKt.JsonPrimitive((Boolean) value2);
        } else {
            if (!(value2 instanceof Number)) {
                throw new SerializationException("Unsupported type: " + Reflection.getOrCreateKotlinClass(value2.getClass()));
            }
            JsonPrimitive = JsonElementKt.JsonPrimitive((Number) value2);
        }
        ((JsonEncoder) encoder).encodeJsonElement(JsonPrimitive);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public IntegrationPayload deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(decoder instanceof JsonDecoder)) {
            throw new IllegalArgumentException("IntegrationPayloadSerializer only works with JSON".toString());
        }
        JsonElement jsonElementDecodeJsonElement = ((JsonDecoder) decoder).decodeJsonElement();
        if (!(jsonElementDecodeJsonElement instanceof JsonPrimitive)) {
            throw new SerializationException("Expected JsonPrimitive but got: " + jsonElementDecodeJsonElement);
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementDecodeJsonElement;
        Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive);
        if (booleanOrNull != null) {
            return new IntegrationPayload(booleanOrNull.booleanValue());
        }
        Integer intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive);
        if (intOrNull != null) {
            return new IntegrationPayload((Number) Integer.valueOf(intOrNull.intValue()));
        }
        Long longOrNull = JsonElementKt.getLongOrNull(jsonPrimitive);
        if (longOrNull != null) {
            return new IntegrationPayload((Number) Long.valueOf(longOrNull.longValue()));
        }
        Double doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive);
        return doubleOrNull != null ? new IntegrationPayload((Number) Double.valueOf(doubleOrNull.doubleValue())) : new IntegrationPayload(jsonPrimitive.getContent());
    }
}
