package com.revenuecat.purchases.paywalls.components;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PurchaseButtonComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/PurchaseButtonComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PurchaseButtonComponent$$serializer implements GeneratedSerializer<PurchaseButtonComponent> {
    public static final PurchaseButtonComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PurchaseButtonComponent$$serializer purchaseButtonComponent$$serializer = new PurchaseButtonComponent$$serializer();
        INSTANCE = purchaseButtonComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME, purchaseButtonComponent$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("stack", false);
        pluginGeneratedSerialDescriptor.addElement("action", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.METHOD, true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PurchaseButtonComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StackComponent$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ActionDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(PurchaseButtonMethodDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PurchaseButtonComponent deserialize(Decoder decoder) {
        int i;
        StackComponent stackComponent;
        PurchaseButtonComponent.Action action;
        PurchaseButtonComponent.Method method;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        StackComponent stackComponent2 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            StackComponent stackComponent3 = (StackComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            PurchaseButtonComponent.Action action2 = (PurchaseButtonComponent.Action) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ActionDeserializer.INSTANCE, null);
            PurchaseButtonComponent.Method method2 = (PurchaseButtonComponent.Method) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PurchaseButtonMethodDeserializer.INSTANCE, null);
            stackComponent = stackComponent3;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            method = method2;
            action = action2;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            PurchaseButtonComponent.Action action3 = null;
            PurchaseButtonComponent.Method method3 = null;
            String str2 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    stackComponent2 = (StackComponent) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, StackComponent$$serializer.INSTANCE, stackComponent2);
                    i2 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    action3 = (PurchaseButtonComponent.Action) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ActionDeserializer.INSTANCE, action3);
                    i2 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    method3 = (PurchaseButtonComponent.Method) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PurchaseButtonMethodDeserializer.INSTANCE, method3);
                    i2 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str2);
                    i2 |= 8;
                }
            }
            i = i2;
            stackComponent = stackComponent2;
            action = action3;
            method = method3;
            str = str2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PurchaseButtonComponent(i, stackComponent, action, method, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PurchaseButtonComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PurchaseButtonComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
