package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.StateUpdate;
import com.revenuecat.purchases.paywalls.components.common.StateUpdateValue;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: StateUpdate.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/StateUpdateSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/common/StateUpdate;", "()V", "KEY_SET", "", "KEY_TO", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class StateUpdateSerializer implements KSerializer<StateUpdate> {
    private static final String KEY_SET = "set";
    private static final String KEY_TO = "to";
    public static final StateUpdateSerializer INSTANCE = new StateUpdateSerializer();
    private static final SerialDescriptor descriptor = JsonObject.INSTANCE.serializer().getDescriptor();

    private StateUpdateSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StateUpdate deserialize(Decoder decoder) {
        String content;
        StateUpdateValue.Literal literal;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            return StateUpdate.Unsupported.INSTANCE;
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        JsonObject jsonObject = jsonElementDecodeJsonElement instanceof JsonObject ? (JsonObject) jsonElementDecodeJsonElement : null;
        if (jsonObject == null) {
            return StateUpdate.Unsupported.INSTANCE;
        }
        Object obj = jsonObject.get((Object) KEY_SET);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive != null) {
            if (!jsonPrimitive.getIsString()) {
                jsonPrimitive = null;
            }
            if (jsonPrimitive != null && (content = jsonPrimitive.getContent()) != null) {
                Object obj2 = jsonObject.get((Object) "to");
                JsonPrimitive jsonPrimitive2 = obj2 instanceof JsonPrimitive ? (JsonPrimitive) obj2 : null;
                if (jsonPrimitive2 == null) {
                    return StateUpdate.Unsupported.INSTANCE;
                }
                if (jsonPrimitive2.getIsString() && Intrinsics.areEqual(jsonPrimitive2.getContent(), "$value")) {
                    literal = StateUpdateValue.PayloadReference.INSTANCE;
                } else {
                    literal = new StateUpdateValue.Literal(jsonPrimitive2);
                }
                return new StateUpdate.Set(content, literal);
            }
        }
        return StateUpdate.Unsupported.INSTANCE;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StateUpdate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new NotImplementedError("Serialization is not implemented because it is not needed.");
    }
}
