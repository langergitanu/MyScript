package com.revenuecat.purchases.paywalls.components;

import androidx.compose.material.OutlinedTextFieldKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls$$serializer;
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

/* JADX INFO: compiled from: VideoComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, m1599d2 = {"com/revenuecat/purchases/paywalls/components/PartialVideoComponent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PartialVideoComponent;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
public final class PartialVideoComponent$$serializer implements GeneratedSerializer<PartialVideoComponent> {
    public static final PartialVideoComponent$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        PartialVideoComponent$$serializer partialVideoComponent$$serializer = new PartialVideoComponent$$serializer();
        INSTANCE = partialVideoComponent$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.PartialVideoComponent", partialVideoComponent$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.SOURCE, true);
        pluginGeneratedSerialDescriptor.addElement("fallback_source", true);
        pluginGeneratedSerialDescriptor.addElement("visible", true);
        pluginGeneratedSerialDescriptor.addElement("show_controls", true);
        pluginGeneratedSerialDescriptor.addElement("auto_play", true);
        pluginGeneratedSerialDescriptor.addElement("loop", true);
        pluginGeneratedSerialDescriptor.addElement("mute_audio", true);
        pluginGeneratedSerialDescriptor.addElement("size", true);
        pluginGeneratedSerialDescriptor.addElement("fit_mode", true);
        pluginGeneratedSerialDescriptor.addElement("mask_shape", true);
        pluginGeneratedSerialDescriptor.addElement("color_overlay", true);
        pluginGeneratedSerialDescriptor.addElement("padding", true);
        pluginGeneratedSerialDescriptor.addElement("margin", true);
        pluginGeneratedSerialDescriptor.addElement(OutlinedTextFieldKt.BorderId, true);
        pluginGeneratedSerialDescriptor.addElement("shadow", true);
        pluginGeneratedSerialDescriptor.addElement("override_source_lid", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PartialVideoComponent$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(ThemeVideoUrls$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(ThemeImageUrls$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(Size$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FitModeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(MaskShapeDeserializer.INSTANCE), BuiltinSerializersKt.getNullable(ColorScheme$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Padding$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Border$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Shadow$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LocalizationKey$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PartialVideoComponent deserialize(Decoder decoder) {
        ThemeImageUrls themeImageUrls;
        ThemeVideoUrls themeVideoUrls;
        int i;
        Boolean bool;
        Size size;
        ColorScheme colorScheme;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        String strM13839unboximpl;
        Border border;
        Shadow shadow;
        Padding padding;
        Boolean bool5;
        FitMode fitMode;
        MaskShape maskShape;
        Padding padding2;
        Shadow shadow2;
        Boolean bool6;
        Shadow shadow3;
        Border border2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        int i2 = 11;
        char c = '\n';
        char c2 = '\t';
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            ThemeVideoUrls themeVideoUrls2 = (ThemeVideoUrls) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, null);
            themeImageUrls = (ThemeImageUrls) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            Boolean bool7 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            Boolean bool8 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            Boolean bool9 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            Boolean bool10 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            Boolean bool11 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, null);
            Size size2 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Size$$serializer.INSTANCE, null);
            FitMode fitMode2 = (FitMode) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, FitModeDeserializer.INSTANCE, null);
            MaskShape maskShape2 = (MaskShape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, MaskShapeDeserializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, ColorScheme$$serializer.INSTANCE, null);
            Padding padding3 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 11, Padding$$serializer.INSTANCE, null);
            Padding padding4 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Padding$$serializer.INSTANCE, null);
            Border border3 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, Border$$serializer.INSTANCE, null);
            Shadow shadow4 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, Shadow$$serializer.INSTANCE, null);
            LocalizationKey localizationKey = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, LocalizationKey$$serializer.INSTANCE, null);
            bool3 = bool8;
            strM13839unboximpl = localizationKey != null ? localizationKey.m13839unboximpl() : null;
            padding2 = padding3;
            colorScheme = colorScheme2;
            maskShape = maskShape2;
            size = size2;
            bool = bool11;
            bool5 = bool10;
            bool4 = bool9;
            fitMode = fitMode2;
            shadow = shadow4;
            border = border3;
            padding = padding4;
            themeVideoUrls = themeVideoUrls2;
            i = 65535;
            bool2 = bool7;
        } else {
            boolean z = true;
            ThemeVideoUrls themeVideoUrls3 = null;
            Shadow shadow5 = null;
            Border border4 = null;
            FitMode fitMode3 = null;
            Size size3 = null;
            MaskShape maskShape3 = null;
            Padding padding5 = null;
            ColorScheme colorScheme3 = null;
            Boolean bool12 = null;
            ThemeImageUrls themeImageUrls2 = null;
            Boolean bool13 = null;
            String strM13839unboximpl2 = null;
            Boolean bool14 = null;
            Boolean bool15 = null;
            Boolean bool16 = null;
            int i3 = 0;
            Padding padding6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(descriptor2);
                switch (iDecodeElementIndex) {
                    case -1:
                        bool6 = bool13;
                        z = false;
                        border4 = border4;
                        shadow5 = shadow5;
                        i2 = 11;
                        c = '\n';
                        bool13 = bool6;
                        break;
                    case 0:
                        shadow3 = shadow5;
                        border2 = border4;
                        bool6 = bool13;
                        themeVideoUrls3 = (ThemeVideoUrls) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 0, ThemeVideoUrls$$serializer.INSTANCE, themeVideoUrls3);
                        i3 |= 1;
                        border4 = border2;
                        shadow5 = shadow3;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        bool13 = bool6;
                        break;
                    case 1:
                        shadow3 = shadow5;
                        border2 = border4;
                        bool6 = bool13;
                        themeImageUrls2 = (ThemeImageUrls) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, themeImageUrls2);
                        i3 |= 2;
                        bool12 = bool12;
                        border4 = border2;
                        shadow5 = shadow3;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        bool13 = bool6;
                        break;
                    case 2:
                        shadow3 = shadow5;
                        border2 = border4;
                        bool6 = bool13;
                        bool12 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool12);
                        i3 |= 4;
                        border4 = border2;
                        shadow5 = shadow3;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        bool13 = bool6;
                        break;
                    case 3:
                        i3 |= 8;
                        bool16 = bool16;
                        shadow5 = shadow5;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        bool13 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool13);
                        border4 = border4;
                        break;
                    case 4:
                        shadow2 = shadow5;
                        bool16 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool16);
                        i3 |= 16;
                        border4 = border4;
                        shadow5 = shadow2;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 5:
                        shadow2 = shadow5;
                        bool15 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool15);
                        i3 |= 32;
                        shadow5 = shadow2;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 6:
                        bool14 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, bool14);
                        i3 |= 64;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 7:
                        size3 = (Size) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 7, Size$$serializer.INSTANCE, size3);
                        i3 |= 128;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 8:
                        fitMode3 = (FitMode) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 8, FitModeDeserializer.INSTANCE, fitMode3);
                        i3 |= 256;
                        i2 = 11;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 9:
                        maskShape3 = (MaskShape) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 9, MaskShapeDeserializer.INSTANCE, maskShape3);
                        i3 |= 512;
                        c2 = '\t';
                        i2 = 11;
                        c = '\n';
                        break;
                    case 10:
                        colorScheme3 = (ColorScheme) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 10, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i3 |= 1024;
                        c = '\n';
                        i2 = 11;
                        c2 = '\t';
                        break;
                    case 11:
                        padding5 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, i2, Padding$$serializer.INSTANCE, padding5);
                        i3 |= 2048;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 12:
                        padding6 = (Padding) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 12, Padding$$serializer.INSTANCE, padding6);
                        i3 |= 4096;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 13:
                        border4 = (Border) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 13, Border$$serializer.INSTANCE, border4);
                        i3 |= 8192;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 14:
                        shadow5 = (Shadow) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 14, Shadow$$serializer.INSTANCE, shadow5);
                        i3 |= 16384;
                        c = '\n';
                        c2 = '\t';
                        break;
                    case 15:
                        LocalizationKey localizationKey2 = (LocalizationKey) compositeDecoderBeginStructure.decodeNullableSerializableElement(descriptor2, 15, LocalizationKey$$serializer.INSTANCE, strM13839unboximpl2 != null ? LocalizationKey.m13833boximpl(strM13839unboximpl2) : null);
                        strM13839unboximpl2 = localizationKey2 != null ? localizationKey2.m13839unboximpl() : null;
                        i3 |= 32768;
                        c = '\n';
                        c2 = '\t';
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            Border border5 = border4;
            Boolean bool17 = bool12;
            themeImageUrls = themeImageUrls2;
            Boolean bool18 = bool15;
            themeVideoUrls = themeVideoUrls3;
            i = i3;
            bool = bool14;
            size = size3;
            colorScheme = colorScheme3;
            bool2 = bool17;
            bool3 = bool13;
            bool4 = bool16;
            strM13839unboximpl = strM13839unboximpl2;
            border = border5;
            shadow = shadow5;
            padding = padding6;
            bool5 = bool18;
            fitMode = fitMode3;
            maskShape = maskShape3;
            padding2 = padding5;
        }
        compositeDecoderBeginStructure.endStructure(descriptor2);
        return new PartialVideoComponent(i, themeVideoUrls, themeImageUrls, bool2, bool3, bool4, bool5, bool, size, fitMode, maskShape, colorScheme, padding2, padding, border, shadow, strM13839unboximpl, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PartialVideoComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        PartialVideoComponent.write$Self$purchases_defaultsRelease(value, compositeEncoderBeginStructure, descriptor2);
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
