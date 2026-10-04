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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: StackComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/StackComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class StackComponent$$serializer implements GeneratedSerializer<StackComponent> {
    public static final StackComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        StackComponent$$serializer stackComponent$$serializer = new StackComponent$$serializer();
        INSTANCE = stackComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("stack", stackComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("components", false);
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
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private StackComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = StackComponent.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), kSerializerArr[2], Size$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Badge$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StackOverflowDeserializer.INSTANCE), kSerializerArr[14], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public StackComponent deserialize(Decoder decoder) {
        Shape shape;
        Boolean bool;
        StackComponent.Overflow overflow;
        List list;
        Border border;
        Float f;
        Padding padding;
        ColorScheme colorScheme;
        Padding padding2;
        Background background;
        int i;
        String str;
        List list2;
        Badge badge;
        Dimension dimension;
        Shadow shadow;
        Size size;
        Boolean bool2;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = StackComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            Boolean bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Dimension dimension2 = (Dimension) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            background = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Badge$$serializer.INSTANCE, null);
            StackComponent.Overflow overflow2 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StackOverflowDeserializer.INSTANCE, null);
            List list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, kSerializerArr[14], null);
            dimension = dimension2;
            i = 65535;
            shape = shape2;
            f = f2;
            padding = padding4;
            padding2 = padding3;
            colorScheme = colorScheme2;
            overflow = overflow2;
            badge = badge2;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            border = border2;
            size = size2;
            shadow = shadow2;
            list2 = list3;
            bool = bool3;
        } else {
            int i2 = 2;
            boolean z = true;
            String str3 = null;
            Size size3 = null;
            Dimension dimension3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            Background background2 = null;
            Float f3 = null;
            shape = null;
            ColorScheme colorScheme3 = null;
            Badge badge3 = null;
            StackComponent.Overflow overflow3 = null;
            List list4 = null;
            List list5 = null;
            int i3 = 0;
            Boolean bool4 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        size3 = size3;
                        i2 = 2;
                        list5 = list5;
                        str3 = str3;
                        break;
                    case 0:
                        Boolean bool5 = bool4;
                        i3 |= 1;
                        str3 = str3;
                        size3 = size3;
                        i2 = 2;
                        list5 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], list5);
                        bool4 = bool5;
                        break;
                    case 1:
                        bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool4);
                        i3 |= 2;
                        str3 = str3;
                        badge3 = badge3;
                        i2 = 2;
                        break;
                    case 2:
                        bool2 = bool4;
                        str2 = str3;
                        dimension3 = (Dimension) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr[i2], dimension3);
                        i3 |= 4;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 3:
                        bool2 = bool4;
                        str2 = str3;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Size$$serializer.INSTANCE, size3);
                        i3 |= 8;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 4:
                        bool2 = bool4;
                        str2 = str3;
                        f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, f3);
                        i3 |= 16;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 5:
                        bool2 = bool4;
                        str2 = str3;
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 32;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 6:
                        bool2 = bool4;
                        str2 = str3;
                        background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, background2);
                        i3 |= 64;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 7:
                        bool2 = bool4;
                        str2 = str3;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 128;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 8:
                        bool2 = bool4;
                        str2 = str3;
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 256;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 9:
                        bool2 = bool4;
                        str2 = str3;
                        shape = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, ShapeDeserializer.INSTANCE, shape);
                        i3 |= 512;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 10:
                        bool2 = bool4;
                        str2 = str3;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, Border$$serializer.INSTANCE, border3);
                        i3 |= 1024;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 11:
                        bool2 = bool4;
                        str2 = str3;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 2048;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 12:
                        bool2 = bool4;
                        badge3 = (Badge) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Badge$$serializer.INSTANCE, badge3);
                        i3 |= 4096;
                        str3 = str3;
                        overflow3 = overflow3;
                        bool4 = bool2;
                        break;
                    case 13:
                        bool2 = bool4;
                        overflow3 = (StackComponent.Overflow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, StackOverflowDeserializer.INSTANCE, overflow3);
                        i3 |= 8192;
                        str3 = str3;
                        list4 = list4;
                        bool4 = bool2;
                        break;
                    case 14:
                        bool2 = bool4;
                        str2 = str3;
                        list4 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 14, kSerializerArr[14], list4);
                        i3 |= 16384;
                        str3 = str2;
                        bool4 = bool2;
                        break;
                    case 15:
                        str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str3);
                        i3 |= 32768;
                        bool4 = bool4;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            bool = bool4;
            String str4 = str3;
            overflow = overflow3;
            list = list5;
            Size size4 = size3;
            ColorScheme colorScheme4 = colorScheme3;
            border = border3;
            f = f3;
            padding = padding5;
            colorScheme = colorScheme4;
            Background background3 = background2;
            padding2 = padding6;
            background = background3;
            i = i3;
            str = str4;
            list2 = list4;
            badge = badge3;
            dimension = dimension3;
            shadow = shadow3;
            size = size4;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new StackComponent(i, list, bool, dimension, size, f, colorScheme, background, padding2, padding, shape, border, shadow, badge, overflow, list2, str, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, StackComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        StackComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
