package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: CarouselComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class CarouselComponent$$serializer implements GeneratedSerializer<CarouselComponent> {
    public static final CarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CarouselComponent$$serializer carouselComponent$$serializer = new CarouselComponent$$serializer();
        INSTANCE = carouselComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("carousel", carouselComponent$$serializer, 20);
        pluginGeneratedSerialDescriptor.addElement("pages", false);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("initial_page_index", true);
        pluginGeneratedSerialDescriptor.addElement("page_alignment", false);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("page_peek", true);
        pluginGeneratedSerialDescriptor.addElement("page_spacing", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("page_control", true);
        pluginGeneratedSerialDescriptor.addElement("loop", true);
        pluginGeneratedSerialDescriptor.addElement("auto_advance", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("state_updates", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CarouselComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CarouselComponent.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), VerticalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CarouselComponent$PageControl$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE), kSerializerArr[17], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[19])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CarouselComponent deserialize(Decoder decoder) {
        Integer num;
        CarouselComponent.PageControl pageControl;
        Background background;
        ColorScheme colorScheme;
        String str;
        List list;
        CarouselComponent.AutoAdvancePages autoAdvancePages;
        Border border;
        VerticalAlignment verticalAlignment;
        Boolean bool;
        Boolean bool2;
        Shadow shadow;
        List list2;
        Shape shape;
        Integer num2;
        List list3;
        int i;
        Size size;
        Padding padding;
        Float f;
        Padding padding2;
        Boolean bool3;
        Padding padding3;
        String str2;
        List list4;
        Boolean bool4;
        List list5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = CarouselComponent.$childSerializers;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            List list6 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            Boolean bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Integer num3 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            VerticalAlignment verticalAlignment2 = (VerticalAlignment) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, Size$$serializer.INSTANCE, null);
            Integer num4 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            Float f2 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, FloatSerializer.INSTANCE, null);
            colorScheme = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, BackgroundDeserializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, Padding$$serializer.INSTANCE, null);
            Padding padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl pageControl2 = (CarouselComponent.PageControl) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            Boolean bool6 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, BooleanSerializer.INSTANCE, null);
            CarouselComponent.AutoAdvancePages autoAdvancePages2 = (CarouselComponent.AutoAdvancePages) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            List list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 17, kSerializerArr[17], null);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, null);
            num = num3;
            bool = bool5;
            pageControl = pageControl2;
            shadow = shadow2;
            list = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 19, kSerializerArr[19], null);
            padding = padding5;
            num2 = num4;
            bool2 = bool6;
            border = border2;
            verticalAlignment = verticalAlignment2;
            padding2 = padding4;
            f = f2;
            list2 = list7;
            background = background2;
            i = 1048575;
            autoAdvancePages = autoAdvancePages2;
            shape = shape2;
            str = str3;
            size = size2;
            list3 = list6;
        } else {
            int i2 = 19;
            int i3 = 0;
            int i4 = 1;
            List list8 = null;
            Padding padding6 = null;
            Integer num5 = null;
            VerticalAlignment verticalAlignment3 = null;
            num = null;
            Shape shape3 = null;
            Padding padding7 = null;
            Background background3 = null;
            ColorScheme colorScheme2 = null;
            Float f3 = null;
            Size size3 = null;
            Border border3 = null;
            Shadow shadow3 = null;
            CarouselComponent.PageControl pageControl3 = null;
            Boolean bool7 = null;
            CarouselComponent.AutoAdvancePages autoAdvancePages3 = null;
            List list9 = null;
            String str4 = null;
            List list10 = null;
            int i5 = 0;
            Boolean bool8 = null;
            while (i4 != 0) {
                int i6 = i2;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        i4 = i3;
                        padding6 = padding6;
                        i2 = 19;
                        bool8 = bool8;
                        str4 = str4;
                        i3 = i4;
                        break;
                    case 0:
                        padding3 = padding6;
                        str2 = str4;
                        list4 = list8;
                        int i7 = i3;
                        list10 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i7, kSerializerArr[i3], list10);
                        i5 |= 1;
                        i3 = i7;
                        bool8 = bool8;
                        padding6 = padding3;
                        list8 = list4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 1:
                        str2 = str4;
                        list4 = list8;
                        padding3 = padding6;
                        bool8 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool8);
                        i5 |= 2;
                        padding6 = padding3;
                        list8 = list4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 2:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        num = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num);
                        i5 |= 4;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 3:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        verticalAlignment3 = (VerticalAlignment) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, verticalAlignment3);
                        i5 |= 8;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 4:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i5 |= 16;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 5:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        num5 = (Integer) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num5);
                        i5 |= 32;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 6:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        f3 = (Float) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, FloatSerializer.INSTANCE, f3);
                        i5 |= 64;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 7:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, ColorScheme$$serializer.INSTANCE, colorScheme2);
                        i5 |= 128;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 8:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, BackgroundDeserializer.INSTANCE, background3);
                        i5 |= 256;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 9:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 9, Padding$$serializer.INSTANCE, padding6);
                        i5 |= 512;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 10:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        padding7 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, Padding$$serializer.INSTANCE, padding7);
                        i5 |= 1024;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 11:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, ShapeDeserializer.INSTANCE, shape3);
                        i5 |= 2048;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 12:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Border$$serializer.INSTANCE, border3);
                        i5 |= 4096;
                        shadow3 = shadow3;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 13:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, Shadow$$serializer.INSTANCE, shadow3);
                        i5 |= 8192;
                        pageControl3 = pageControl3;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 14:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        pageControl3 = (CarouselComponent.PageControl) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, pageControl3);
                        i5 |= 16384;
                        bool7 = bool7;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 15:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, BooleanSerializer.INSTANCE, bool7);
                        i5 |= 32768;
                        autoAdvancePages3 = autoAdvancePages3;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 16:
                        bool4 = bool8;
                        str2 = str4;
                        list5 = list8;
                        autoAdvancePages3 = (CarouselComponent.AutoAdvancePages) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, autoAdvancePages3);
                        i5 |= 65536;
                        list9 = list9;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 17:
                        bool4 = bool8;
                        String str5 = str4;
                        list5 = list8;
                        str2 = str5;
                        list9 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 17, kSerializerArr[17], list9);
                        i5 |= 131072;
                        list8 = list5;
                        bool8 = bool4;
                        i2 = 19;
                        str4 = str2;
                        break;
                    case 18:
                        bool3 = bool8;
                        i5 |= 262144;
                        list8 = list8;
                        i2 = 19;
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, str4);
                        bool8 = bool3;
                        break;
                    case 19:
                        bool3 = bool8;
                        list8 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i6, kSerializerArr[i6], list8);
                        i5 |= 524288;
                        i2 = i6;
                        bool8 = bool3;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Padding padding8 = padding6;
            pageControl = pageControl3;
            ColorScheme colorScheme3 = colorScheme2;
            background = background3;
            colorScheme = colorScheme3;
            str = str4;
            list = list8;
            autoAdvancePages = autoAdvancePages3;
            border = border3;
            verticalAlignment = verticalAlignment3;
            bool = bool8;
            bool2 = bool7;
            shadow = shadow3;
            list2 = list9;
            shape = shape3;
            num2 = num5;
            list3 = list10;
            i = i5;
            size = size3;
            padding = padding7;
            f = f3;
            padding2 = padding8;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new CarouselComponent(i, list3, bool, num, verticalAlignment, size, num2, f, colorScheme, background, padding2, padding, shape, border, shadow, pageControl, bool2, autoAdvancePages, list2, str, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CarouselComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        CarouselComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
