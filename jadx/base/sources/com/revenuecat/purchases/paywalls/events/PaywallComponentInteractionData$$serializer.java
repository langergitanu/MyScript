package com.revenuecat.purchases.paywalls.events;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PaywallEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/events/PaywallComponentInteractionData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PaywallComponentInteractionData$$serializer implements GeneratedSerializer<PaywallComponentInteractionData> {
    public static final PaywallComponentInteractionData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PaywallComponentInteractionData$$serializer paywallComponentInteractionData$$serializer = new PaywallComponentInteractionData$$serializer();
        INSTANCE = paywallComponentInteractionData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData", paywallComponentInteractionData$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("componentType", false);
        pluginGeneratedSerialDescriptor.addElement("componentName", true);
        pluginGeneratedSerialDescriptor.addElement("componentValue", false);
        pluginGeneratedSerialDescriptor.addElement("componentUrl", true);
        pluginGeneratedSerialDescriptor.addElement("originIndex", true);
        pluginGeneratedSerialDescriptor.addElement("destinationIndex", true);
        pluginGeneratedSerialDescriptor.addElement("originContextName", true);
        pluginGeneratedSerialDescriptor.addElement("destinationContextName", true);
        pluginGeneratedSerialDescriptor.addElement("defaultIndex", true);
        pluginGeneratedSerialDescriptor.addElement("originPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("destinationPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("defaultPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("originProductIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("destinationProductIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("defaultProductIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("currentPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("resultingPackageIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("currentProductIdentifier", true);
        pluginGeneratedSerialDescriptor.addElement("resultingProductIdentifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PaywallComponentInteractionData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{PaywallComponentInteractionData.$childSerializers[0], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponentInteractionData deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Integer num;
        String str9;
        Integer num2;
        String str10;
        String str11;
        Integer num3;
        String str12;
        String str13;
        PaywallComponentType paywallComponentType;
        String str14;
        String str15;
        String str16;
        String str17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PaywallComponentInteractionData.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            PaywallComponentType paywallComponentType2 = (PaywallComponentType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            String str18 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            String strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
            String str19 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            Integer num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            String str20 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            String str21 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            Integer num6 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, IntSerializer.INSTANCE, null);
            String str22 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String str23 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str24 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            String str25 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            String str26 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            String str27 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            String str28 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            String str29 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, null);
            i = 524287;
            str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, null);
            str14 = str19;
            str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, null);
            str11 = str24;
            str6 = str29;
            str7 = str28;
            str8 = str27;
            str = str26;
            str15 = str25;
            num3 = num6;
            str13 = strDecodeStringElement;
            num = num5;
            str3 = str22;
            str12 = str21;
            str9 = str20;
            paywallComponentType = paywallComponentType2;
            str10 = str18;
            num2 = num4;
            str2 = str23;
        } else {
            boolean z = true;
            String str30 = null;
            Integer num7 = null;
            String str31 = null;
            String str32 = null;
            Integer num8 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            Integer num9 = null;
            String str37 = null;
            PaywallComponentType paywallComponentType3 = null;
            String strDecodeStringElement2 = null;
            String str38 = null;
            String str39 = null;
            String str40 = null;
            String str41 = null;
            String str42 = null;
            i = 0;
            String str43 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        num7 = num7;
                        paywallComponentType3 = paywallComponentType3;
                        str43 = str43;
                        break;
                    case 0:
                        String str44 = str30;
                        i |= 1;
                        str43 = str43;
                        num7 = num7;
                        paywallComponentType3 = (PaywallComponentType) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], paywallComponentType3);
                        str30 = str44;
                        break;
                    case 1:
                        i |= 2;
                        str43 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str43);
                        str30 = str30;
                        str38 = str38;
                        break;
                    case 2:
                        str16 = str30;
                        str17 = str43;
                        strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(descriptor2, 2);
                        i |= 4;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 3:
                        str16 = str30;
                        str17 = str43;
                        str33 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str33);
                        i |= 8;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 4:
                        str16 = str30;
                        str17 = str43;
                        num8 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num8);
                        i |= 16;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 5:
                        str16 = str30;
                        str17 = str43;
                        num7 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num7);
                        i |= 32;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 6:
                        str16 = str30;
                        str17 = str43;
                        str32 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str32);
                        i |= 64;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 7:
                        str16 = str30;
                        str17 = str43;
                        str37 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str37);
                        i |= 128;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 8:
                        str16 = str30;
                        str17 = str43;
                        num9 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, IntSerializer.INSTANCE, num9);
                        i |= 256;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 9:
                        str16 = str30;
                        str17 = str43;
                        str36 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str36);
                        i |= 512;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 10:
                        str16 = str30;
                        str17 = str43;
                        str31 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str31);
                        i |= 1024;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 11:
                        str16 = str30;
                        str17 = str43;
                        str35 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str35);
                        i |= 2048;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 12:
                        str16 = str30;
                        str17 = str43;
                        str34 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str34);
                        i |= 4096;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 13:
                        str17 = str43;
                        str38 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str38);
                        i |= 8192;
                        str30 = str30;
                        str39 = str39;
                        str43 = str17;
                        break;
                    case 14:
                        str17 = str43;
                        str39 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str39);
                        i |= 16384;
                        str30 = str30;
                        str40 = str40;
                        str43 = str17;
                        break;
                    case 15:
                        str17 = str43;
                        str40 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str40);
                        i |= 32768;
                        str30 = str30;
                        str41 = str41;
                        str43 = str17;
                        break;
                    case 16:
                        str17 = str43;
                        str41 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, str41);
                        i |= 65536;
                        str30 = str30;
                        str42 = str42;
                        str43 = str17;
                        break;
                    case 17:
                        str17 = str43;
                        str16 = str30;
                        str42 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, str42);
                        i |= 131072;
                        str30 = str16;
                        str43 = str17;
                        break;
                    case 18:
                        str30 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, str30);
                        i |= 262144;
                        str43 = str43;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            String str45 = str43;
            PaywallComponentType paywallComponentType4 = paywallComponentType3;
            str = str38;
            str2 = str31;
            str3 = str36;
            str4 = str30;
            str5 = str42;
            str6 = str41;
            str7 = str40;
            str8 = str39;
            num = num7;
            str9 = str32;
            num2 = num8;
            str10 = str45;
            str11 = str35;
            num3 = num9;
            str12 = str37;
            str13 = strDecodeStringElement2;
            paywallComponentType = paywallComponentType4;
            str14 = str33;
            str15 = str34;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PaywallComponentInteractionData(i, paywallComponentType, str10, str13, str14, num2, num, str9, str12, num3, str3, str2, str11, str15, str, str8, str7, str6, str5, str4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponentInteractionData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PaywallComponentInteractionData.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
