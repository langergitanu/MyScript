package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: TabsComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/TabControlToggleComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TabControlToggleComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TabControlToggleComponent$$serializer implements GeneratedSerializer<TabControlToggleComponent> {
    public static final TabControlToggleComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabControlToggleComponent$$serializer tabControlToggleComponent$$serializer = new TabControlToggleComponent$$serializer();
        INSTANCE = tabControlToggleComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tab_control_toggle", tabControlToggleComponent$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("default_value", false);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("thumb_color_on", false);
        pluginGeneratedSerialDescriptor.addElement("thumb_color_off", false);
        pluginGeneratedSerialDescriptor.addElement("track_color_on", false);
        pluginGeneratedSerialDescriptor.addElement("track_color_off", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabControlToggleComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), ColorScheme$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabControlToggleComponent deserialize(Decoder decoder) {
        boolean zDecodeBooleanElement;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        ColorScheme colorScheme3;
        ColorScheme colorScheme4;
        String str;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 0);
            String str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            ColorScheme colorScheme5 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            ColorScheme colorScheme6 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, null);
            ColorScheme colorScheme7 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            colorScheme4 = colorScheme6;
            colorScheme = colorScheme7;
            colorScheme3 = colorScheme5;
            str = str2;
            i = 63;
        } else {
            boolean z = true;
            zDecodeBooleanElement = false;
            String str3 = null;
            ColorScheme colorScheme8 = null;
            ColorScheme colorScheme9 = null;
            ColorScheme colorScheme10 = null;
            ColorScheme colorScheme11 = null;
            int i2 = 0;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(descriptor2, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str3);
                        i2 |= 2;
                        break;
                    case 2:
                        colorScheme8 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme8);
                        i2 |= 4;
                        break;
                    case 3:
                        colorScheme9 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme9);
                        i2 |= 8;
                        break;
                    case 4:
                        colorScheme10 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme10);
                        i2 |= 16;
                        break;
                    case 5:
                        colorScheme11 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme11);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            colorScheme = colorScheme10;
            colorScheme2 = colorScheme11;
            colorScheme3 = colorScheme8;
            colorScheme4 = colorScheme9;
            str = str3;
            i = i2;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TabControlToggleComponent(i, zDecodeBooleanElement, str, colorScheme3, colorScheme4, colorScheme, colorScheme2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabControlToggleComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TabControlToggleComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
