package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.revenuecat.purchases.paywalls.components.TabsComponent;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: TabsComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/TabsComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TabsComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class TabsComponent$$serializer implements GeneratedSerializer<TabsComponent> {
    public static final TabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        TabsComponent$$serializer tabsComponent$$serializer = new TabsComponent$$serializer();
        INSTANCE = tabsComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tabs", tabsComponent$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background", true);
        pluginGeneratedSerialDescriptor.addElement("shape", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("control", false);
        pluginGeneratedSerialDescriptor.addElement("tabs", false);
        pluginGeneratedSerialDescriptor.addElement("default_tab_id", true);
        pluginGeneratedSerialDescriptor.addElement("overrides", true);
        pluginGeneratedSerialDescriptor.addElement("state_updates", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private TabsComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = TabsComponent.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), Size$$serializer.INSTANCE, Padding$$serializer.INSTANCE, Padding$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackgroundDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(ShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), kSerializerArr[10], kSerializerArr[11], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[13], BuiltinSerializersKt.getNullable(kSerializerArr[14])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public TabsComponent deserialize(Decoder decoder) {
        String str;
        String str2;
        Border border;
        List list;
        List list2;
        int i;
        Background background;
        Shadow shadow;
        Padding padding;
        List list3;
        Boolean bool;
        TabsComponent.TabControl tabControl;
        ColorScheme colorScheme;
        Padding padding2;
        Size size;
        Shape shape;
        Boolean bool2;
        List list4;
        Boolean bool3;
        List list5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        KSerializer[] kSerializerArr = TabsComponent.$childSerializers;
        List list6 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            Boolean bool4 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, null);
            padding2 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, Padding$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Shadow$$serializer.INSTANCE, null);
            TabsComponent.TabControl tabControl2 = (TabsComponent.TabControl) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 10, kSerializerArr[10], null);
            list = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, kSerializerArr[11], null);
            String str3 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            shape = shape2;
            i = 32767;
            list3 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 13, kSerializerArr[13], null);
            list2 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, kSerializerArr[14], null);
            border = border2;
            str2 = str3;
            padding = padding3;
            size = size2;
            tabControl = tabControl2;
            background = background2;
            colorScheme = colorScheme2;
            bool = bool4;
            shadow = shadow2;
        } else {
            int i2 = 14;
            int i3 = 0;
            int i4 = 10;
            boolean z = true;
            Boolean bool5 = null;
            TabsComponent.TabControl tabControl3 = null;
            Border border3 = null;
            Shape shape3 = null;
            Background background3 = null;
            Padding padding4 = null;
            Shadow shadow3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding5 = null;
            List list7 = null;
            Size size3 = null;
            String str4 = null;
            List list8 = null;
            String str5 = null;
            while (z) {
                int i5 = i2;
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        bool5 = bool5;
                        i2 = 14;
                        i4 = 10;
                        str5 = str5;
                        i3 = i3;
                        break;
                    case 0:
                        bool5 = bool5;
                        i2 = 14;
                        i4 = 10;
                        str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str5);
                        i3 |= 1;
                        list6 = list6;
                        break;
                    case 1:
                        bool5 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 2;
                        list6 = list6;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 2:
                        bool2 = bool5;
                        list4 = list6;
                        size3 = (Size) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i3 |= 4;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 3:
                        bool2 = bool5;
                        list4 = list6;
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 3, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 8;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 4:
                        bool2 = bool5;
                        list4 = list6;
                        padding4 = (Padding) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 4, Padding$$serializer.INSTANCE, padding4);
                        i3 |= 16;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 5:
                        bool2 = bool5;
                        list4 = list6;
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 32;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 6:
                        bool2 = bool5;
                        list4 = list6;
                        background3 = (Background) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BackgroundDeserializer.INSTANCE, background3);
                        i3 |= 64;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 7:
                        bool2 = bool5;
                        list4 = list6;
                        shape3 = (Shape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, ShapeDeserializer.INSTANCE, shape3);
                        i3 |= 128;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 8:
                        bool2 = bool5;
                        list4 = list6;
                        border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, Border$$serializer.INSTANCE, border3);
                        i3 |= 256;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 9:
                        bool2 = bool5;
                        list4 = list6;
                        shadow3 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, Shadow$$serializer.INSTANCE, shadow3);
                        i3 |= 512;
                        list6 = list4;
                        bool5 = bool2;
                        i2 = 14;
                        i4 = 10;
                        break;
                    case 10:
                        bool3 = bool5;
                        list5 = list6;
                        tabControl3 = (TabsComponent.TabControl) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, i4, kSerializerArr[i4], tabControl3);
                        i3 |= 1024;
                        list6 = list5;
                        bool5 = bool3;
                        i2 = 14;
                        break;
                    case 11:
                        bool3 = bool5;
                        list5 = list6;
                        list7 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 11, kSerializerArr[11], list7);
                        i3 |= 2048;
                        list6 = list5;
                        bool5 = bool3;
                        i2 = 14;
                        break;
                    case 12:
                        bool3 = bool5;
                        str4 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str4);
                        i3 |= 4096;
                        list6 = list6;
                        list8 = list8;
                        bool5 = bool3;
                        i2 = 14;
                        break;
                    case 13:
                        bool3 = bool5;
                        list5 = list6;
                        list8 = (List) compositeDecoderBeginStructure.decodeSerializableElement(descriptor2, 13, kSerializerArr[13], list8);
                        i3 |= 8192;
                        list6 = list5;
                        bool5 = bool3;
                        i2 = 14;
                        break;
                    case 14:
                        list6 = (List) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i5, kSerializerArr[i5], list6);
                        i3 |= 16384;
                        i2 = i5;
                        bool5 = bool5;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            int i6 = i3;
            List list9 = list6;
            str = str5;
            str2 = str4;
            border = border3;
            list = list7;
            list2 = list9;
            i = i6;
            background = background3;
            shadow = shadow3;
            padding = padding5;
            list3 = list8;
            bool = bool5;
            tabControl = tabControl3;
            colorScheme = colorScheme3;
            padding2 = padding4;
            size = size3;
            shape = shape3;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new TabsComponent(i, str, bool, size, padding, padding2, colorScheme, background, shape, border, shadow, tabControl, list, str2, list3, list2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, TabsComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        TabsComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
