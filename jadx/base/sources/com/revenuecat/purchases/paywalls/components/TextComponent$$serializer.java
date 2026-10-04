package com.revenuecat.purchases.paywalls.components;

import androidx.core.provider.FontsContractCompat;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import java.util.List;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: TextComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/TextComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TextComponent$$serializer implements GeneratedSerializer<TextComponent> {
    public static final TextComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TextComponent$$serializer textComponent$$serializer = new TextComponent$$serializer();
        INSTANCE = textComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("text", textComponent$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("text_lid", false);
        pluginGeneratedSerialDescriptor.addElement("color", false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("font_name", true);
        pluginGeneratedSerialDescriptor.addElement(FontsContractCompat.Columns.WEIGHT, true);
        pluginGeneratedSerialDescriptor.addElement("font_weight_int", true);
        pluginGeneratedSerialDescriptor.addElement("font_size", true);
        pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TextComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LocalizationKey$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FontAlias$$serializer.INSTANCE), FontWeightDeserializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), FontSizeSerializer.INSTANCE, HorizontalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, TextComponent.$childSerializers[12], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TextComponent deserialize(Decoder decoder) {
        FontWeight fontWeight;
        Padding padding;
        Integer num;
        Size size;
        HorizontalAlignment horizontalAlignment;
        int i;
        String str;
        String str2;
        int i2;
        String str3;
        Padding padding2;
        List list;
        ColorScheme colorScheme;
        Boolean bool;
        ColorScheme colorScheme2;
        String str4;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = TextComponent.$childSerializers;
        int i3 = 9;
        char c2 = '\b';
        ColorScheme colorScheme3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            String strM13839unboximpl = localizationKey != null ? localizationKey.m13839unboximpl() : null;
            ColorScheme colorScheme4 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ColorScheme$$serializer.INSTANCE, null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            ColorScheme colorScheme5 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, null);
            FontAlias fontAlias = (FontAlias) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM13637unboximpl = fontAlias != null ? fontAlias.m13637unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num2 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, null);
            int iIntValue = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, FontSizeSerializer.INSTANCE, 0)).intValue();
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], null);
            str2 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            i2 = iIntValue;
            size = size2;
            horizontalAlignment = horizontalAlignment2;
            padding = padding3;
            str3 = strM13637unboximpl;
            bool = bool2;
            colorScheme2 = colorScheme4;
            padding2 = padding4;
            num = num2;
            fontWeight = fontWeight2;
            colorScheme = colorScheme5;
            str = strM13839unboximpl;
            i = 16383;
        } else {
            int i4 = 0;
            int i5 = 13;
            int i6 = 1;
            String str5 = null;
            Padding padding5 = null;
            List list2 = null;
            Padding padding6 = null;
            Integer num3 = null;
            Size size3 = null;
            HorizontalAlignment horizontalAlignment3 = null;
            String strM13839unboximpl2 = null;
            FontWeight fontWeight3 = null;
            ColorScheme colorScheme6 = null;
            String strM13637unboximpl2 = null;
            Boolean bool3 = null;
            int i7 = 0;
            int iIntValue2 = 0;
            while (i6 != 0) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i6 = i4;
                        str5 = str5;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 0:
                        str4 = str5;
                        FontWeight fontWeight4 = fontWeight3;
                        ColorScheme colorScheme7 = colorScheme6;
                        Boolean bool4 = bool3;
                        int i8 = i4;
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i8, LocalizationKey$$serializer.INSTANCE, strM13839unboximpl2 != null ? LocalizationKey.m13833boximpl(strM13839unboximpl2) : null);
                        strM13839unboximpl2 = localizationKey2 != null ? localizationKey2.m13839unboximpl() : null;
                        i7 |= 1;
                        i4 = i8;
                        fontWeight3 = fontWeight4;
                        colorScheme6 = colorScheme7;
                        bool3 = bool4;
                        str5 = str4;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 1:
                        str4 = str5;
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 1, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i7 |= 2;
                        str5 = str4;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 2:
                        str4 = str5;
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool3);
                        i7 |= 4;
                        str5 = str4;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 3:
                        colorScheme6 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i7 |= 8;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 4:
                        FontWeight fontWeight5 = fontWeight3;
                        FontAlias fontAlias2 = (FontAlias) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM13637unboximpl2 != null ? FontAlias.m13631boximpl(strM13637unboximpl2) : null);
                        strM13637unboximpl2 = fontAlias2 != null ? fontAlias2.m13637unboximpl() : null;
                        i7 |= 16;
                        fontWeight3 = fontWeight5;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 5:
                        fontWeight3 = (FontWeight) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i7 |= 32;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 6:
                        c = 7;
                        num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, num3);
                        i7 |= 64;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 7:
                        c = 7;
                        iIntValue2 = ((Number) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(iIntValue2))).intValue();
                        i7 |= 128;
                        i5 = 13;
                        i3 = 9;
                        c2 = '\b';
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i7 |= 256;
                        c2 = '\b';
                        i5 = 13;
                        i3 = 9;
                        break;
                    case 9:
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i3, Size$$serializer.INSTANCE, size3);
                        i7 |= 512;
                        i5 = 13;
                        c2 = '\b';
                        break;
                    case 10:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, padding6);
                        i7 |= 1024;
                        i5 = 13;
                        c2 = '\b';
                        break;
                    case 11:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, padding5);
                        i7 |= 2048;
                        i5 = 13;
                        c2 = '\b';
                        break;
                    case 12:
                        list2 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 12, kSerializerArr[12], list2);
                        i7 |= 4096;
                        i5 = 13;
                        break;
                    case 13:
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, StringSerializer.INSTANCE, str5);
                        i7 |= 8192;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            fontWeight = fontWeight3;
            padding = padding6;
            num = num3;
            size = size3;
            horizontalAlignment = horizontalAlignment3;
            i = i7;
            str = strM13839unboximpl2;
            str2 = str5;
            i2 = iIntValue2;
            str3 = strM13637unboximpl2;
            padding2 = padding5;
            list = list2;
            colorScheme = colorScheme6;
            bool = bool3;
            colorScheme2 = colorScheme3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TextComponent(i, str, colorScheme2, bool, colorScheme, str3, fontWeight, num, i2, horizontalAlignment, size, padding, padding2, list, str2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TextComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TextComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
