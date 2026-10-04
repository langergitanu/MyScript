package com.revenuecat.purchases.common.remoteconfig;

import com.revenuecat.purchases.common.remoteconfig.RemoteConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: RemoteConfiguration.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/ConfigItemSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfiguration$ConfigItem;", "()V", "BLOB_REF_KEY", "", "PREFETCH_KEY", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ConfigItemSerializer implements KSerializer<RemoteConfiguration.ConfigItem> {
    private static final String BLOB_REF_KEY = "blob_ref";
    private static final String PREFETCH_KEY = "prefetch";
    public static final ConfigItemSerializer INSTANCE = new ConfigItemSerializer();
    private static final SerialDescriptor descriptor = JsonObject.INSTANCE.serializer().getDescriptor();

    private ConfigItemSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    @Override // kotlinx.serialization.DeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RemoteConfiguration.ConfigItem deserialize(Decoder decoder) {
        String content;
        Boolean booleanOrNull;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("ConfigItem can only be deserialized from JSON.");
        }
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        JsonObject jsonObject = jsonElementDecodeJsonElement instanceof JsonObject ? (JsonObject) jsonElementDecodeJsonElement : null;
        if (jsonObject == null) {
            throw new SerializationException("ConfigItem must be a JSON object, but was: " + jsonElementDecodeJsonElement + '.');
        }
        Object obj = jsonObject.get((Object) BLOB_REF_KEY);
        JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
        if (jsonPrimitive == null) {
            content = null;
        } else {
            if (!jsonPrimitive.getIsString()) {
                jsonPrimitive = null;
            }
            if (jsonPrimitive != null) {
                content = jsonPrimitive.getContent();
            }
        }
        Object obj2 = jsonObject.get((Object) PREFETCH_KEY);
        JsonPrimitive jsonPrimitive2 = obj2 instanceof JsonPrimitive ? (JsonPrimitive) obj2 : null;
        boolean zBooleanValue = (jsonPrimitive2 == null || (booleanOrNull = JsonElementKt.getBooleanOrNull(jsonPrimitive2)) == null) ? false : booleanOrNull.booleanValue();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            if (!Intrinsics.areEqual(key, BLOB_REF_KEY) && !Intrinsics.areEqual(key, PREFETCH_KEY)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new RemoteConfiguration.ConfigItem(content, zBooleanValue, new JsonObject(linkedHashMap));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RemoteConfiguration.ConfigItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder == null) {
            throw new SerializationException("ConfigItem can only be serialized to JSON.");
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.putAll(value.getMetadata());
        String blobRef = value.getBlobRef();
        if (blobRef != null) {
        }
        if (value.getPrefetch()) {
            mapCreateMapBuilder.put(PREFETCH_KEY, JsonElementKt.JsonPrimitive((Boolean) true));
        }
        jsonEncoder.encodeJsonElement(new JsonObject(MapsKt.build(mapCreateMapBuilder)));
    }
}
