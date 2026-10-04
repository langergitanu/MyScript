package com.revenuecat.purchases.paywalls;

import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.paywalls.PaywallData;
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

/* JADX INFO: compiled from: PaywallData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/PaywallData.Configuration.Colors.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration$Colors;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallData$Configuration$Colors$$serializer implements GeneratedSerializer<PaywallData.Configuration.Colors> {
    public static final PaywallData$Configuration$Colors$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = new PaywallData$Configuration$Colors$$serializer();
        INSTANCE = paywallData$Configuration$Colors$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Colors", paywallData$Configuration$Colors$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("background", false);
        pluginGeneratedSerialDescriptor.addElement("text_1", false);
        pluginGeneratedSerialDescriptor.addElement("text_2", true);
        pluginGeneratedSerialDescriptor.addElement("text_3", true);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_background", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_foreground", false);
        pluginGeneratedSerialDescriptor.addElement("call_to_action_secondary_background", true);
        pluginGeneratedSerialDescriptor.addElement("accent_1", true);
        pluginGeneratedSerialDescriptor.addElement("accent_2", true);
        pluginGeneratedSerialDescriptor.addElement("accent_3", true);
        pluginGeneratedSerialDescriptor.addElement("close_button", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_background", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_foreground", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_selected_background", true);
        pluginGeneratedSerialDescriptor.addElement("tier_control_selected_foreground", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallData$Configuration$Colors$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), PaywallColor.Serializer.INSTANCE, PaywallColor.Serializer.INSTANCE, BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE), BuiltinSerializersKt.getNullable(PaywallColor.Serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallData.Configuration.Colors deserialize(Decoder decoder) {
        int i;
        PaywallColor paywallColor;
        PaywallColor paywallColor2;
        PaywallColor paywallColor3;
        PaywallColor paywallColor4;
        PaywallColor paywallColor5;
        PaywallColor paywallColor6;
        PaywallColor paywallColor7;
        PaywallColor paywallColor8;
        PaywallColor paywallColor9;
        PaywallColor paywallColor10;
        PaywallColor paywallColor11;
        PaywallColor paywallColor12;
        PaywallColor paywallColor13;
        PaywallColor paywallColor14;
        PaywallColor paywallColor15;
        PaywallColor paywallColor16;
        PaywallColor paywallColor17;
        PaywallColor paywallColor18;
        PaywallColor paywallColor19;
        PaywallColor paywallColor20;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            PaywallColor paywallColor21 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor22 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor23 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor24 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor25 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor26 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor27 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor28 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor29 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor30 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor31 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor32 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, PaywallColor.Serializer.INSTANCE, null);
            PaywallColor paywallColor33 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, PaywallColor.Serializer.INSTANCE, null);
            i = 32767;
            paywallColor = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, PaywallColor.Serializer.INSTANCE, null);
            paywallColor4 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, PaywallColor.Serializer.INSTANCE, null);
            paywallColor14 = paywallColor29;
            paywallColor2 = paywallColor33;
            paywallColor3 = paywallColor31;
            paywallColor9 = paywallColor27;
            paywallColor13 = paywallColor24;
            paywallColor8 = paywallColor21;
            paywallColor6 = paywallColor32;
            paywallColor11 = paywallColor26;
            paywallColor10 = paywallColor25;
            paywallColor12 = paywallColor28;
            paywallColor15 = paywallColor23;
            paywallColor7 = paywallColor30;
            paywallColor5 = paywallColor22;
        } else {
            boolean z = true;
            PaywallColor paywallColor34 = null;
            PaywallColor paywallColor35 = null;
            PaywallColor paywallColor36 = null;
            PaywallColor paywallColor37 = null;
            PaywallColor paywallColor38 = null;
            PaywallColor paywallColor39 = null;
            PaywallColor paywallColor40 = null;
            PaywallColor paywallColor41 = null;
            PaywallColor paywallColor42 = null;
            PaywallColor paywallColor43 = null;
            PaywallColor paywallColor44 = null;
            PaywallColor paywallColor45 = null;
            PaywallColor paywallColor46 = null;
            PaywallColor paywallColor47 = null;
            i = 0;
            PaywallColor paywallColor48 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        paywallColor16 = paywallColor48;
                        paywallColor17 = paywallColor47;
                        paywallColor18 = paywallColor34;
                        z = false;
                        paywallColor48 = paywallColor16;
                        paywallColor34 = paywallColor18;
                        paywallColor47 = paywallColor17;
                        break;
                    case 0:
                        PaywallColor paywallColor49 = paywallColor47;
                        paywallColor18 = paywallColor34;
                        paywallColor16 = paywallColor48;
                        paywallColor17 = paywallColor49;
                        paywallColor45 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, PaywallColor.Serializer.INSTANCE, paywallColor45);
                        i |= 1;
                        paywallColor48 = paywallColor16;
                        paywallColor34 = paywallColor18;
                        paywallColor47 = paywallColor17;
                        break;
                    case 1:
                        i |= 2;
                        paywallColor47 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, PaywallColor.Serializer.INSTANCE, paywallColor47);
                        paywallColor34 = paywallColor34;
                        paywallColor48 = paywallColor48;
                        break;
                    case 2:
                        i |= 4;
                        paywallColor34 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, PaywallColor.Serializer.INSTANCE, paywallColor34);
                        paywallColor48 = paywallColor48;
                        paywallColor46 = paywallColor46;
                        break;
                    case 3:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor44 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, PaywallColor.Serializer.INSTANCE, paywallColor44);
                        i |= 8;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 4:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor41 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, PaywallColor.Serializer.INSTANCE, paywallColor41);
                        i |= 16;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 5:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor43 = (PaywallColor) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, PaywallColor.Serializer.INSTANCE, paywallColor43);
                        i |= 32;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 6:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor40 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, PaywallColor.Serializer.INSTANCE, paywallColor40);
                        i |= 64;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 7:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor39 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, PaywallColor.Serializer.INSTANCE, paywallColor39);
                        i |= 128;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 8:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor38 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, PaywallColor.Serializer.INSTANCE, paywallColor38);
                        i |= 256;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 9:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor42 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, PaywallColor.Serializer.INSTANCE, paywallColor42);
                        i |= 512;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 10:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor37 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, PaywallColor.Serializer.INSTANCE, paywallColor37);
                        i |= 1024;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 11:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor36 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, PaywallColor.Serializer.INSTANCE, paywallColor36);
                        i |= 2048;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 12:
                        paywallColor19 = paywallColor48;
                        paywallColor20 = paywallColor34;
                        paywallColor35 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, PaywallColor.Serializer.INSTANCE, paywallColor35);
                        i |= 4096;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 13:
                        paywallColor20 = paywallColor34;
                        paywallColor19 = paywallColor48;
                        paywallColor46 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, PaywallColor.Serializer.INSTANCE, paywallColor46);
                        i |= 8192;
                        paywallColor48 = paywallColor19;
                        paywallColor34 = paywallColor20;
                        break;
                    case 14:
                        paywallColor48 = (PaywallColor) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, PaywallColor.Serializer.INSTANCE, paywallColor48);
                        i |= 16384;
                        paywallColor34 = paywallColor34;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            PaywallColor paywallColor50 = paywallColor48;
            PaywallColor paywallColor51 = paywallColor45;
            paywallColor = paywallColor46;
            paywallColor2 = paywallColor35;
            paywallColor3 = paywallColor37;
            paywallColor4 = paywallColor50;
            paywallColor5 = paywallColor47;
            paywallColor6 = paywallColor36;
            paywallColor7 = paywallColor42;
            paywallColor8 = paywallColor51;
            paywallColor9 = paywallColor40;
            paywallColor10 = paywallColor41;
            paywallColor11 = paywallColor43;
            paywallColor12 = paywallColor39;
            paywallColor13 = paywallColor44;
            paywallColor14 = paywallColor38;
            paywallColor15 = paywallColor34;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallData.Configuration.Colors(i, paywallColor8, paywallColor5, paywallColor15, paywallColor13, paywallColor10, paywallColor11, paywallColor9, paywallColor12, paywallColor14, paywallColor7, paywallColor3, paywallColor6, paywallColor2, paywallColor, paywallColor4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallData.Configuration.Colors value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallData.Configuration.Colors.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
