package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: StackComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/PartialStackComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialStackComponent$$serializer implements GeneratedSerializer<PartialStackComponent> {
    public static final PartialStackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialStackComponent$$serializer partialStackComponent$$serializer = new PartialStackComponent$$serializer();
        INSTANCE = partialStackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialStackComponent", partialStackComponent$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement(TypedValues.Custom.S_DIMENSION, true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("spacing", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("badge", true);
        pluginGeneratedSerialDescriptor.addElement("overflow", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialStackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(PartialStackComponent.$childSerializers[1]), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Badge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StackOverflowDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialStackComponent deserialize(Decoder decoder) {
        Size size;
        ColorScheme colorScheme;
        int i;
        Boolean bool;
        Border border;
        Background background;
        String str;
        StackComponent.Overflow overflow;
        Badge badge;
        Shape shape;
        Padding padding;
        Float f;
        Dimension dimension;
        Shadow shadow;
        Padding padding2;
        String str2;
        String str3;
        Dimension dimension2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = PartialStackComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            bool = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Dimension dimension3 = (Dimension) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            size = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, null);
            colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Badge$$serializer.INSTANCE, null);
            i = 16383;
            background = background2;
            f = f2;
            shape = shape2;
            overflow = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StackOverflowDeserializer.INSTANCE, null);
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            shadow = shadow2;
            padding2 = padding4;
            badge = badge2;
            dimension = dimension3;
            border = border2;
            padding = padding3;
        } else {
            int i2 = 1;
            boolean z = true;
            String str4 = null;
            size = null;
            Badge badge3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            colorScheme = null;
            Border border3 = null;
            Background background3 = null;
            Float f3 = null;
            Boolean bool2 = null;
            StackComponent.Overflow overflow2 = null;
            i = 0;
            Dimension dimension4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        str2 = str4;
                        bool2 = bool2;
                        dimension4 = dimension4;
                        z = false;
                        str4 = str2;
                        i2 = 1;
                        break;
                    case 0:
                        str2 = str4;
                        i |= 1;
                        bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool2);
                        dimension4 = dimension4;
                        str4 = str2;
                        i2 = 1;
                        break;
                    case 1:
                        String str5 = str4;
                        KSerializer kSerializer = kSerializerArr[i2];
                        int i3 = i2;
                        i |= 2;
                        overflow2 = overflow2;
                        i2 = i3;
                        dimension4 = (Dimension) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializer, dimension4);
                        str4 = str5;
                        break;
                    case 2:
                        str3 = str4;
                        dimension2 = dimension4;
                        size = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, size);
                        i |= 4;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 3:
                        str3 = str4;
                        dimension2 = dimension4;
                        f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, FloatSerializer.INSTANCE, f3);
                        i |= 8;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 4:
                        str3 = str4;
                        dimension2 = dimension4;
                        colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme);
                        i |= 16;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 5:
                        str3 = str4;
                        dimension2 = dimension4;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i |= 32;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 6:
                        str3 = str4;
                        dimension2 = dimension4;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, Padding$$serializer.INSTANCE, padding6);
                        i |= 64;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 7:
                        str3 = str4;
                        dimension2 = dimension4;
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding5);
                        i |= 128;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 8:
                        str3 = str4;
                        dimension2 = dimension4;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, ShapeDeserializer.INSTANCE, shape3);
                        i |= 256;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 9:
                        str3 = str4;
                        dimension2 = dimension4;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Border$$serializer.INSTANCE, border3);
                        i |= 512;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 10:
                        str3 = str4;
                        dimension2 = dimension4;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Shadow$$serializer.INSTANCE, shadow3);
                        i |= 1024;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 11:
                        str3 = str4;
                        dimension2 = dimension4;
                        badge3 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Badge$$serializer.INSTANCE, badge3);
                        i |= 2048;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 12:
                        dimension2 = dimension4;
                        str3 = str4;
                        overflow2 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StackOverflowDeserializer.INSTANCE, overflow2);
                        i |= 4096;
                        str4 = str3;
                        dimension4 = dimension2;
                        break;
                    case 13:
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str4);
                        i |= 8192;
                        dimension4 = dimension4;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Boolean bool3 = bool2;
            Dimension dimension5 = dimension4;
            bool = bool3;
            border = border3;
            background = background3;
            str = str4;
            overflow = overflow2;
            badge = badge3;
            shape = shape3;
            padding = padding6;
            f = f3;
            dimension = dimension5;
            shadow = shadow3;
            padding2 = padding5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialStackComponent(i, bool, dimension, size, f, colorScheme, background, padding, padding2, shape, border, shadow, badge, overflow, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialStackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialStackComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
