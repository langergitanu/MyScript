package com.revenuecat.purchases.paywalls.components;

import androidx.media3.common.MimeTypes;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: PaywallComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/PaywallComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeFallback", "jsonDecoder", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/JsonObject;", "missingFallbackMessage", "", "decodeWebViewOrFallback", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallComponentSerializer implements KSerializer<PaywallComponent> {
    private final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("PaywallComponent", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.paywalls.components.PaywallComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
            invoke2(classSerialDescriptorBuilder);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.element$default(buildClassSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        }
    });

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponent deserialize(Decoder decoder) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String content = null;
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Can only deserialize PaywallComponent from JSON, got: " + Reflection.getOrCreateKotlinClass(decoder.getClass()));
        }
        JsonObject jsonObject = JsonElementKt.getJsonObject(jsonDecoder.decodeJsonElement());
        JsonElement jsonElement = (JsonElement) jsonObject.get("type");
        if (jsonElement != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) != null) {
            content = jsonPrimitive.getContent();
        }
        if (content != null) {
            switch (content.hashCode()) {
                case -2076650431:
                    if (content.equals("timeline")) {
                        Json json = jsonDecoder.getJson();
                        json.getSerializersModule();
                        return (PaywallComponent) json.decodeFromJsonElement(TimelineComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -1896978765:
                    if (content.equals("tab_control")) {
                        Json json2 = jsonDecoder.getJson();
                        json2.getSerializersModule();
                        return (PaywallComponent) json2.decodeFromJsonElement(TabControlComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -1822017359:
                    if (content.equals("sticky_footer")) {
                        Json json3 = jsonDecoder.getJson();
                        json3.getSerializersModule();
                        return (PaywallComponent) json3.decodeFromJsonElement(StickyFooterComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -1391809488:
                    if (content.equals(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME)) {
                        Json json4 = jsonDecoder.getJson();
                        json4.getSerializersModule();
                        return (PaywallComponent) json4.decodeFromJsonElement(PurchaseButtonComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -1377687758:
                    if (content.equals("button")) {
                        Json json5 = jsonDecoder.getJson();
                        json5.getSerializersModule();
                        return (PaywallComponent) json5.decodeFromJsonElement(ButtonComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -1221270899:
                    if (content.equals("header")) {
                        Json json6 = jsonDecoder.getJson();
                        json6.getSerializersModule();
                        return (PaywallComponent) json6.decodeFromJsonElement(HeaderComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -807062458:
                    if (content.equals(Keys.PACKAGE)) {
                        Json json7 = jsonDecoder.getJson();
                        json7.getSerializersModule();
                        return (PaywallComponent) json7.decodeFromJsonElement(PackageComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case -718398288:
                    if (content.equals("web_view")) {
                        return decodeWebViewOrFallback(jsonDecoder, jsonObject);
                    }
                    break;
                case -364374390:
                    if (content.equals("fallback_header")) {
                        return FallbackHeaderComponent.INSTANCE;
                    }
                    break;
                case 2908512:
                    if (content.equals("carousel")) {
                        Json json8 = jsonDecoder.getJson();
                        json8.getSerializersModule();
                        return (PaywallComponent) json8.decodeFromJsonElement(CarouselComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 3226745:
                    if (content.equals("icon")) {
                        Json json9 = jsonDecoder.getJson();
                        json9.getSerializersModule();
                        return (PaywallComponent) json9.decodeFromJsonElement(IconComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 3552126:
                    if (content.equals("tabs")) {
                        Json json10 = jsonDecoder.getJson();
                        json10.getSerializersModule();
                        return (PaywallComponent) json10.decodeFromJsonElement(TabsComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 3556653:
                    if (content.equals("text")) {
                        Json json11 = jsonDecoder.getJson();
                        json11.getSerializersModule();
                        return (PaywallComponent) json11.decodeFromJsonElement(TextComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 100313435:
                    if (content.equals("image")) {
                        Json json12 = jsonDecoder.getJson();
                        json12.getSerializersModule();
                        return (PaywallComponent) json12.decodeFromJsonElement(ImageComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 109757064:
                    if (content.equals("stack")) {
                        Json json13 = jsonDecoder.getJson();
                        json13.getSerializersModule();
                        return (PaywallComponent) json13.decodeFromJsonElement(StackComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 112202875:
                    if (content.equals(MimeTypes.BASE_TYPE_VIDEO)) {
                        Json json14 = jsonDecoder.getJson();
                        json14.getSerializersModule();
                        return (PaywallComponent) json14.decodeFromJsonElement(VideoComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 318201406:
                    if (content.equals("tab_control_button")) {
                        Json json15 = jsonDecoder.getJson();
                        json15.getSerializersModule();
                        return (PaywallComponent) json15.decodeFromJsonElement(TabControlButtonComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 827585120:
                    if (content.equals("tab_control_toggle")) {
                        Json json16 = jsonDecoder.getJson();
                        json16.getSerializersModule();
                        return (PaywallComponent) json16.decodeFromJsonElement(TabControlToggleComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
                case 1352226353:
                    if (content.equals("countdown")) {
                        Json json17 = jsonDecoder.getJson();
                        json17.getSerializersModule();
                        return (PaywallComponent) json17.decodeFromJsonElement(CountdownComponent.INSTANCE.serializer(), jsonObject);
                    }
                    break;
            }
        }
        return decodeFallback(jsonDecoder, jsonObject, "No fallback provided for unknown type: " + content);
    }

    private final PaywallComponent decodeWebViewOrFallback(JsonDecoder jsonDecoder, JsonObject json) {
        Integer intOrNull;
        JsonElement jsonElement = (JsonElement) json.get("protocol_version");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            JsonPrimitive jsonPrimitive2 = jsonPrimitive.getIsString() ? null : jsonPrimitive;
            if (jsonPrimitive2 != null && (intOrNull = JsonElementKt.getIntOrNull(jsonPrimitive2)) != null) {
                int iIntValue = intOrNull.intValue();
                if (iIntValue == 1) {
                    Json json2 = jsonDecoder.getJson();
                    json2.getSerializersModule();
                    return (PaywallComponent) json2.decodeFromJsonElement(WebViewComponent.INSTANCE.serializer(), json);
                }
                return decodeFallback(jsonDecoder, json, "No fallback provided for web_view with unsupported protocol_version: " + iIntValue);
            }
        }
        throw new SerializationException("web_view protocol_version is missing or malformed: " + jsonElement);
    }

    private final PaywallComponent decodeFallback(JsonDecoder jsonDecoder, JsonObject json, String missingFallbackMessage) {
        JsonElement jsonElement = (JsonElement) json.get("fallback");
        if (jsonElement != null) {
            JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
            if (jsonObject != null) {
                Json json2 = jsonDecoder.getJson();
                json2.getSerializersModule();
                PaywallComponent paywallComponent = (PaywallComponent) json2.decodeFromJsonElement(PaywallComponent.INSTANCE.serializer(), jsonObject);
                if (paywallComponent != null) {
                    return paywallComponent;
                }
            }
        }
        throw new SerializationException(missingFallbackMessage);
    }
}
